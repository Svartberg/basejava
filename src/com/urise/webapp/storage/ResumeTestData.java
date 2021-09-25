package com.urise.webapp.storage;

import com.urise.webapp.model.*;

import java.time.Month;

public class ResumeTestData {

    public static void main(String[] args) {
        System.out.println(createResume("uuid1", "Григорий Кислин"));
    }

    public static Resume createResume(String uuid, String fullName) {

        Resume resume = new Resume(uuid, fullName);

        resume.setContact(ContactType.PHONE, " +7(921) 855-0482\n");
        resume.setContact(ContactType.MAIL, " gkislin@yandex.ru\n");
        resume.setContact(ContactType.GITHUB, " https://github.com/gkislin\n");
        resume.setContact(ContactType.HOME_PAGE, " http://gkislin.ru\n");
        resume.setContact(ContactType.LINKEDIN, " https://www.linkedin.com/in/gkislin\n");
        resume.setContact(ContactType.SKYPE, " grigory.kislin\n");
        resume.setContact(ContactType.STATCKOVERFLOW, " https://stackoverflow.com/users/548473/grigory-kislin\n");

        resume.setSection(TypeSection.OBJECTIVE, new TextSection("Objective1"));
        resume.setSection(TypeSection.PERSONAL, new TextSection("Personal data"));
        resume.setSection(TypeSection.ACHIEVEMENT, new ListSection("Achievement11", "Achievement12", "Achievement13"));
        resume.setSection(TypeSection.QUALIFICATIONS, new ListSection("Java", "SQL", "JavaScript"));
        resume.setSection(TypeSection.EXPERIENCE,
                new HistorySection(
                        new Organization("Organization11", "http://organization11.ru",
                                new Organization.Position(2005, Month.JANUARY, "position1", "content1"),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "position2", "content2"))));
        resume.setSection(TypeSection.EDUCATION,
                new HistorySection(
                        new Organization("Institute", null,
                                new Organization.Position(1996, Month.JANUARY, 2000, Month.DECEMBER, "aspirant", null),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "student", "IT facultet")),
                        new Organization("Organization12", "http://organization12.ru")));
        resume.setContact(ContactType.SKYPE, "skype2");
        resume.setContact(ContactType.PHONE, "22222");
        resume.setSection(TypeSection.EXPERIENCE,
                new HistorySection(
                        new Organization("Organization2", "http://organization2.ru",
                                new Organization.Position(2015, Month.JANUARY, "position1", "content1"))));
        return resume;
    }
}