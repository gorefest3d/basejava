package com.urise.webapp;

import com.urise.webapp.model.*;
import com.urise.webapp.util.DateUtil;

import java.time.Month;

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
                "Java Online Projects", "Java", new Position("Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок.", DateUtil.of(2010, Month.JANUARY), DateUtil.of(2021, Month.AUGUST))),
                new Organization(
                        "Wrike", "Wrike", new Position("Старший разработчик.", "Проектирование и разработка онлайн платформы.", DateUtil.of(2014, Month.OCTOBER), DateUtil.of(2016, Month.JANUARY))),
                new Organization("RIT Center", "RIT Center", new Position("Java архитектор.", "Организация процесса разработки системы ERP.", DateUtil.of(2012, Month.APRIL), DateUtil.of(2014, Month.OCTOBER)))));
        resumeOne.addSection(SectionType.EDUCATION, new OrganizationSection(new Organization(
                "Coursera", "Coursera", new Position("Functional Programming Principles in Scala\" by Martin Odersky", null, DateUtil.of(2013, Month.MARCH), DateUtil.of(2013, Month.MAY))),
                new Organization("Luxoft", "Luxoft", new Position("Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"", null, DateUtil.of(2011, Month.MARCH), DateUtil.of(2011, Month.APRIL)))));

        System.out.println(resumeOne.getFullName());
        System.out.println();
        resumeOne.getContacts();
        System.out.println();
        resumeOne.getSections();
    }
}
