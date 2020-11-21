import com.urise.webapp.model.*;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume r = new Resume("Григорий Кислин");

        //Заполняем Контакты
        r.setContacts(ContactType.PHONE, "+7(921) 855-0482");
        r.setContacts(ContactType.SKYPE, "grigory.kislin");
        r.setContacts(ContactType.EMAIL, "gkislin@yandex.ru");
        r.setContacts(ContactType.LINKEDIN, "https://www.linkedin.com/in/gkislin");
        r.setContacts(ContactType.GITHUB, "https://github.com/gkislin");
        r.setContacts(ContactType.STACKOVERFLOW, "https://stackoverflow.com/users/548473");
        r.setContacts(ContactType.HOMEPAGE, "http://gkislin.ru/");

        //Заполняем секцию Позиция
        String description = "Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям";
        r.setSections(SectionType.OBJECTIVE, new SingleLineSection(description));


        //Заполняем секцию Личные качества
        description = "Аналитический склад ума, сильная логика, креативность, инициативность. " +
                "Пурист кода и архитектуры.";
        r.setSections(SectionType.PERSONAL, new SingleLineSection(description));

        /*Заполняем секцию Достижения*/
        List<String> achievements = new ArrayList<>();
        achievements.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", " +
                "\"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). " +
                "Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. " +
                "Более 1000 выпускников.");
        achievements.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. " +
                "Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        achievements.add("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. " +
                "Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: " +
                "Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, " +
                "интеграция CIFS/SMB java сервера.");
        achievements.add("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, " +
                "Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
        achievements.add("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов " +
                "(SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о " +
                "состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования " +
                "и мониторинга системы по JMX (Jython/ Django).");
        achievements.add("Реализация протоколов по приему платежей всех основных платежных системы России " +
                "(Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");

        r.setSections(SectionType.ACHIEVEMENT, new BulletedListSection(achievements));

        //Заполняем секцию Квалификация
        List<String> qualifications = new ArrayList<>();
        qualifications.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        qualifications.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        qualifications.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB");
        qualifications.add("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy, XML/XSD/XSLT, SQL, C/C++, Unix shell scripts");
        qualifications.add("Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), " +
                "JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, " +
                "Selenium (htmlelements).");
        qualifications.add("Python: Django.");
        qualifications.add("JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
        qualifications.add("Scala: SBT, Play2, Specs2, Anorm, Spray, Akka");
        qualifications.add("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, " +
                "JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.");
        qualifications.add("Инструменты: Maven + plugin development, Gradle, настройка Ngnix, администрирование Hudson/Jenkins, " +
                "Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer.");
        qualifications.add("Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, " +
                "UML, функционального программирования");
        qualifications.add("Родной русский, английский \"upper intermediate\"");

        r.setSections(SectionType.QUALIFICATIONS, new BulletedListSection(qualifications));

        //Заполняем секцию Опыт работы
        List<Experience> exp = new ArrayList<>();

        exp.add(new Experience("Java Online Projects", "http://javaops.ru/",
                YearMonth.of(2013, 10), YearMonth.now(),
                "Автор проекта.",
                "Создание, организация и проведение Java онлайн проектов и стажировок."));
        exp.add(new Experience("Wrike", "https://www.wrike.com/",
                YearMonth.of(2014, 10), YearMonth.of(2016, 1),
                "Старший разработчик (backend)",
                "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, " +
                        "Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, " +
                        "авторизация по OAuth1, OAuth2, JWT SSO."));
        exp.add(new Experience("RIT Center", "",
                YearMonth.of(2012, 4), YearMonth.of(2014, 10),
                "Java архитектор",
                "Организация процесса разработки системы ERP для разных окружений: релизная политика, " +
                        "версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), " +
                        "конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и " +
                        "серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, " +
                        "1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). " +
                        "Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. " +
                        "Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, " +
                        "Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting " +
                        "via ssh tunnels, PL/Python"));
        exp.add(new Experience("Luxoft (Deutsche Bank)", "http://www.luxoft.ru/",
                YearMonth.of(2010, 12), YearMonth.of(2012, 4),
                "Ведущий программист",
                "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, " +
                        "Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения " +
                        "для администрирования, мониторинга и анализа результатов в области алгоритмического " +
                        "трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5."));
        exp.add(new Experience("Yota", "https://www.yota.ru/",
                YearMonth.of(2008, 6), YearMonth.of(2010, 12),
                "Ведущий специалист",
                "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" " +
                        "(GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). " +
                        "Реализация администрирования, статистики и мониторинга фреймворка. Разработка online " +
                        "JMX клиента (Python/ Jython, Django, ExtJS)"));
        exp.add(new Experience("Enkata", "http://enkata.com/",
                YearMonth.of(2007, 3), YearMonth.of(2008, 6),
                "Разработчик ПО",
                "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) " +
                        "частей кластерного J2EE приложения (OLAP, Data mining)."));
        exp.add(new Experience("Siemens AG", "https://www.siemens.com/ru/ru/home.html",
                YearMonth.of(2005, 1), YearMonth.of(2007, 2),
                "Разработчик ПО",
                "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО " +
                        "на мобильной IN платформе Siemens @vantage (Java, Unix)."));
        exp.add(new Experience("Alcatel", "http://www.alcatel.ru/",
                YearMonth.of(1997, 9), YearMonth.of(2005, 1),
                "Инженер по аппаратному и программному тестированию",
                "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)."));

        r.setSections(SectionType.EXPERIENCE, new OrganizationSection(exp));


        //Заполняем секцию Образование
        List<Experience> edu = new ArrayList<>();

        edu.add(new Experience("Coursera", "https://www.coursera.org/course/progfun",
                YearMonth.of(2013, 3), YearMonth.of(2013, 5),
                "Functional Programming Principles in Scala\" by Martin Odersky", ""));
        edu.add(new Experience("Luxoft", "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366",
                YearMonth.of(2011, 3), YearMonth.of(2011, 4),
                "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"", ""));
        edu.add(new Experience("Siemens AG", "http://www.siemens.ru/",
                YearMonth.of(2005, 1), YearMonth.of(2005, 4),
                "3 месяца обучения мобильным IN сетям (Берлин)", ""));
        edu.add(new Experience("Alcatel", "http://www.alcatel.ru/",
                YearMonth.of(1997, 9), YearMonth.of(1998, 3),
                "6 месяцев обучения цифровым телефонным сетям (Москва)", ""));
        edu.add(new Experience("Санкт-Петербургский национальный исследовательский университет " +
                "информационных технологий, механики и оптики", "http://www.ifmo.ru/",
                YearMonth.of(1993, 9), YearMonth.of(1996, 7),
                "Аспирантура (программист С, С++)", ""));
        edu.add(new Experience("Санкт-Петербургский национальный исследовательский университет " +
                "информационных технологий, механики и оптики", "http://www.ifmo.ru/",
                YearMonth.of(1987, 9), YearMonth.of(1993, 7),
                "Инженер (программист Fortran, C)", ""));
        edu.add(new Experience("Заочная физико-техническая школа при МФТИ", "http://www.school.mipt.ru/",
                YearMonth.of(1984, 9), YearMonth.of(1987, 6),
                "Закончил с отличием", ""));

        r.setSections(SectionType.EDUCATION, new OrganizationSection(edu));

        //Вывод резюме в консоль
        System.out.println(r.getFullName());

        for (Map.Entry<ContactType, String> entry : r.getContacts().entrySet()) {
            System.out.println(entry.getKey().getTitle() + "" + entry.getValue());
        }

        for (Map.Entry<SectionType, AbstractSection> entry : r.getSections().entrySet()) {
            String sectionTitle = entry.getKey().getTitle();
            /*switch (sectionTitle) {
                case SectionType.PERSONAL.getTitle() : // ругается. Хотел switch использовать
            }*/

            if (sectionTitle.equals(SectionType.PERSONAL.getTitle()) ||
                    sectionTitle.equals(SectionType.OBJECTIVE.getTitle())) {
                System.out.println(sectionTitle + " " + ((SingleLineSection) entry.getValue()).getDescription());
            } else if (sectionTitle.equals(SectionType.ACHIEVEMENT.getTitle()) ||
                    sectionTitle.equals(SectionType.QUALIFICATIONS.getTitle())) {
                System.out.println(sectionTitle);
                BulletedListSection sectionContent = (BulletedListSection) entry.getValue();
                for (String element : sectionContent.getDescriptions()) {
                    System.out.println(element);
                }
            } else {
                System.out.println(sectionTitle);
                OrganizationSection sectionContent = (OrganizationSection) entry.getValue();
                for (Experience element : sectionContent.getExperience()) {
                    System.out.println(element);
                }
            }
        }
    }
}