package com.urise.webapp;

import com.urise.webapp.model.*;

import java.time.LocalDate;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resumeOne = new Resume("UUID1", "Григорий Кислин");

        resumeOne.addContact(ContactType.MOBILE_HONE, "+7(921) 855-0482");
        resumeOne.addContact(ContactType.SKYPE, "grigory.kislin");
        resumeOne.addContact(ContactType.MAIL, "gkislin@yandex.ru");
        resumeOne.addContact(ContactType.LINKEDIN, "Профиль LinkedIn");
        resumeOne.addContact(ContactType.GITHUB, "Профиль GitHub");
        resumeOne.addContact(ContactType.STACKOVERFLOW, "Профиль Stackoverflow");
        resumeOne.addContact(ContactType.HOME_PAGE, "Домашняя страница");
        resumeOne.addSection(SectionType.OBJECTIVE, new SingleLineSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));
        resumeOne.addSection(SectionType.PERSONAL, new SingleLineSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
        resumeOne.addSection(SectionType.ACHIEVEMENT, new BulletedListSection(
                "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven.\"",
                "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike",
                "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM",
                "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA",
                "Создание JavaEE фреймворка для отказоустойчивого взаимодействия",
                "Реализация протоколов по приему платежей всех основных платежных систем"));
        resumeOne.addSection(SectionType.QUALIFICATIONS, new BulletedListSection("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
                "Version control: Subversion, Git, Mercury, ClearCase, Perforce",
                "DB: PostgreSQL(наследование, pgplsql, PL/Python",
                "MySQL, SQLite, MS SQL, HSQLDB",
                "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy",
                "Родной русский, английский \"upper intermediate\""));
        resumeOne.addSection(SectionType.EXPERIENCE, new OrganizationSection(new Organization(
                "Java Online Projects", "Java", "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок.", LocalDate.of(2013, 10, 1), LocalDate.of(2021, 8, 12)),
                new Organization(
                        "Wrike", "Wrike", "Старший разработчик.", "Проектирование и разработка онлайн платформы.", LocalDate.of(2014, 10, 1), LocalDate.of(2016, 1, 1)),
                new Organization("RIT Center", "RIT Center", "Java архитектор.", "Организация процесса разработки системы ERP.", LocalDate.of(2012, 4, 1), LocalDate.of(2014, 10, 1))));
        resumeOne.addSection(SectionType.EDUCATION, new OrganizationSection(new Organization(
                "Coursera", "Coursera", "Functional Programming Principles in Scala\" by Martin Odersky", "", LocalDate.of(2013, 3, 1), LocalDate.of(2013, 5, 1)),
                new Organization("Luxoft", "Luxoft", "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"", "", LocalDate.of(2011, 3, 1), LocalDate.of(2011, 4, 1))));

        System.out.println(resumeOne.getFullName());
        System.out.println();
        resumeOne.getContacts();
        System.out.println();
        resumeOne.getSections();
    }
}
