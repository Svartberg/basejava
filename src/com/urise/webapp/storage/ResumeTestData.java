package com.urise.webapp.storage;

import com.urise.webapp.model.*;

import java.time.Month;

public class ResumeTestData {

    public static void main(String[] args) {
        System.out.println(createResume("uuid1", "Григорий Кислин"));
    }

    public static Resume createResume(String uuid, String fullName) {

        Resume resume = new Resume(uuid, fullName);

        resume.addContact(ContactType.PHONE, " +7(921) 855-0482\n");
        resume.addContact(ContactType.MAIL, " gkislin@yandex.ru\n");
        resume.addContact(ContactType.GITHUB, " https://github.com/gkislin\n");
        resume.addContact(ContactType.HOME_PAGE, " http://gkislin.ru\n");
        resume.addContact(ContactType.LINKEDIN, " https://www.linkedin.com/in/gkislin\n");
        resume.addContact(ContactType.SKYPE, " grigory.kislin\n");
        resume.addContact(ContactType.STATCKOVERFLOW, " https://stackoverflow.com/users/548473/grigory-kislin\n");

        resume.addSection(TypeSection.OBJECTIVE, new TextSection("Objective1"));
        resume.addSection(TypeSection.PERSONAL, new TextSection("Personal data"));
        resume.addSection(TypeSection.ACHIEVEMENT, new ListSection("Achievement11", "Achievement12", "Achievement13"));
        resume.addSection(TypeSection.QUALIFICATIONS, new ListSection("Java", "SQL", "JavaScript"));
        resume.addSection(TypeSection.EXPERIENCE,
                new HistorySection(
                        new Organization("Organization11", "http://organization11.ru",
                                new Organization.Position(2005, Month.JANUARY, "position1", "content1"),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "position2", "content2"))));
        resume.addSection(TypeSection.EDUCATION,
                new HistorySection(
                        new Organization("Institute", null,
                                new Organization.Position(1996, Month.JANUARY, 2000, Month.DECEMBER, "aspirant", null),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "student", "IT facultet")),
                        new Organization("Organization12", "http://organization12.ru")));
        resume.addContact(ContactType.SKYPE, "skype2");
        resume.addContact(ContactType.PHONE, "22222");
        resume.addSection(TypeSection.EXPERIENCE,
                new HistorySection(
                        new Organization("Organization2", "http://organization2.ru",
                                new Organization.Position(2015, Month.JANUARY, "position1", "content1"))));
        return resume;
    }
}