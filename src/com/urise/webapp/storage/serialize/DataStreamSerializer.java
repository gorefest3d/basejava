package com.urise.webapp.storage.serialize;

import com.urise.webapp.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class DataStreamSerializer implements Serialize {
    @Override
    public void doWrite(Resume resume, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            Map<ContactType, String> contacts = resume.getContacts();
            dos.writeUTF(resume.getUuid());
            dos.writeUTF(resume.getFullName());
            dos.writeInt(contacts.size());

            for (Map.Entry<ContactType, String> entry : contacts.entrySet()) {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            }

            writeCollection(dos, resume.getSections().entrySet(), entry -> {
                SectionType sectionType = entry.getKey();
                AbstractSection section = entry.getValue();
                dos.writeUTF(sectionType.name());
                switch (sectionType) {

                    case OBJECTIVE:
                    case PERSONAL:
                        dos.writeUTF(((SingleLineSection) section).getSingleLine());
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        writeCollection(dos, ((BulletedListSection) section).getBulletedList(), dos::writeUTF);
                        break;
                    case EXPERIENCE:
                    case EDUCATION:
                        writeCollection(dos, ((OrganizationSection) section).getOrganizations(), organization -> {
                            dos.writeUTF(organization.getHomePage().getName());
                            dos.writeUTF(organization.getHomePage().getUrl());

                            writeCollection(dos, organization.getPositions(), position -> {
                                dos.writeUTF(position.getPosition());
                                dos.writeUTF(position.getDescription());
                                writeLocalDate(dos, position.getStartDate());
                                writeLocalDate(dos, position.getEndDate());
                            });

                        });
                        break;
                }
            });
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            String uuid = dis.readUTF();
            String fullName = dis.readUTF();
            Resume resume = new Resume(uuid, fullName);

            readCollection(dis, () -> resume.addContact(ContactType.valueOf(dis.readUTF()), dis.readUTF()));
            readCollection(dis, () -> {
                SectionType sectionType = SectionType.valueOf(dis.readUTF());
                resume.addSection(sectionType, readSection(dis, sectionType));
            });
            return resume;
        }
    }

    private AbstractSection readSection(DataInputStream dis, SectionType sectionType) throws IOException {
        switch (sectionType) {
            case OBJECTIVE:
            case PERSONAL:
                return new SingleLineSection(dis.readUTF());
            case ACHIEVEMENT:
            case QUALIFICATIONS:
                return new BulletedListSection(readList(dis, dis::readUTF));
            case EXPERIENCE:
            case EDUCATION:
                return new OrganizationSection(
                        readList(dis, () -> new Organization(new Link(dis.readUTF(), dis.readUTF()),
                                readList(dis, () -> new Organization.Position(dis.readUTF(), dis.readUTF(), readLocalDate(dis), readLocalDate(dis))))));
            default:
                throw new IllegalStateException();
        }
    }

    private <T> void writeCollection(DataOutputStream dos, Collection<T> collection, ElementWriter<T> writer) throws IOException {
        dos.writeInt(collection.size());
        for (T item : collection) {
            writer.writeElement(item);
        }
    }

    private void readCollection(DataInputStream dis, ElementProcessor processor) throws IOException {
        int size = dis.readInt();

        for (int i = 0; i < size; i++) {
            processor.process();
        }
    }

    private <T> List<T> readList(DataInputStream dis, ElementReader<T> reader) throws IOException {
        int size = dis.readInt();
        List<T> list = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            list.add(reader.read());
        }
        return list;
    }

    private void writeLocalDate(DataOutputStream dos, LocalDate localDate) throws IOException {
        dos.writeInt(localDate.getYear());
        dos.writeInt(localDate.getMonth().getValue());
    }

    private LocalDate readLocalDate(DataInputStream dis) throws IOException {
        return LocalDate.of(dis.readInt(), dis.readInt(), 1);
    }
}