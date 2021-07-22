package com.urise.webapp;

import com.urise.webapp.model.ContactType;
import com.urise.webapp.model.Organization;
import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ResumeTestData {


    public static void main(String[] args) {
        System.out.println(createResume("uuid1", "Andrey Konstantinov"));
    }

    private static Resume createResume(String uuid, String fullName) {

        Resume resume = new Resume(uuid, fullName);

        resume.addContact(ContactType.PHONE, " +7(921) 855-0482\n");
        resume.addContact(ContactType.MAIL, " gkislin@yandex.ru\n");
        resume.addContact(ContactType.GITHUB, " https://github.com/gkislin\n");
        resume.addContact(ContactType.HOME_PAGE, " http://gkislin.ru\n");
        resume.addContact(ContactType.LINKEDIN, " https://www.linkedin.com/in/gkislin\n");
        resume.addContact(ContactType.SKYPE, " grigory.kislin\n");
        resume.addContact(ContactType.STATCKOVERFLOW, " https://stackoverflow.com/users/548473/grigory-kislin\n");

        return resume;
    }
}
