package com.urise.webapp;

import com.urise.webapp.model.ContactType;
import com.urise.webapp.model.Organization;
import com.urise.webapp.model.Resume;
import com.urise.webapp.model.SectionList;

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

        List<Organization> organizationList = new ArrayList<>();
        organizationList.add(new Organization("Java Online Projects", "https://javaops.ru/", "10.2013", "06.2021", "Автор проекта.", "Создание, организация и проведение Java онлайн проектов и стажировок.\n"));
        organizationList.add(new Organization("Wrike", "https://www.wrike.com/", "10.2014", "01.2016", "Старший разработчик (backend)", "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.\n"));
        organizationList.add(new Organization("RIT Center", " ", "04.2012", "10.2014", "Java архитектор", "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python\n"));
        organizationList.add(new Organization("Luxoft (Deutsche Bank)", "https://career.luxoft.com/locations/russia/", "12.2010", "04.2012", "Ведущий программист", "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.\n"));
        organizationList.add(new Organization("Yota", "https://www.yota.ru/", "06.2008", "12.2012", "Ведущий специалист", "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)\n"));
        organizationList.add(new Organization("Enkata", "https://www.pega.com", "03.2007", "06.2008", "Разработчик ПО", "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).\n"));
        organizationList.add(new Organization("Siemens AG", "https://new.siemens.com/", "01.2005", "02.2007", "Разработчик ПО", "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).\n"));
        organizationList.add(new Organization("Alcatel", "Alcatel", "09.1997", "01.2005", "Инженер по аппаратному и программному тестированию", "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).\n"));
        organizationList.add(new Organization("Coursera", "https://www.coursera.org/", "03.2013", "05.2013", "\"Functional Programming Principles in Scala\" by Martin Odersky\n", " "));
        organizationList.add(new Organization("Luxoft", "https://career.luxoft.com/locations/russia/", "03.2011", "04.2011", "Курс - Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\n", " "));
        organizationList.add(new Organization("Siemens AG", "https://new.siemens.com/", "01.2005", "04.2005", "3 месяца обучения мобильным IN сетям (Берлин)\n", ""));
        organizationList.add(new Organization("Alcatel", "http://www.alcatel.ru/", "09.1997", "03.1998", "6 месяцев обучения цифровым телефонным сетям (Москва)\n", " "));

        return resume;
    }
}
