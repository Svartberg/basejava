package com.urise.webapp;

import com.urise.webapp.model.ContactType;
import com.urise.webapp.model.Resume;

public class ResumeTestData {


    public static void main(String[] args) {
        System.out.println(createResume("uuid1", "Andrey Konstantinov"));
    }

    private static Resume createResume(String uuid, String fullName) {

        Resume resume = new Resume(uuid, fullName);

        resume.setContact(ContactType.PHONE, " +7(921) 855-0482\n");
        resume.setContact(ContactType.MAIL, " gkislin@yandex.ru\n");
        resume.setContact(ContactType.GITHUB, " https://github.com/gkislin\n");
        resume.setContact(ContactType.HOME_PAGE, " http://gkislin.ru\n");
        resume.setContact(ContactType.LINKEDIN, " https://www.linkedin.com/in/gkislin\n");
        resume.setContact(ContactType.SKYPE, " grigory.kislin\n");
        resume.setContact(ContactType.STATCKOVERFLOW, " https://stackoverflow.com/users/548473/grigory-kislin\n");

        return resume;
    }
}
