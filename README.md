# Spring_main_project
## Цель:
Целью данного проекта является создание WEB-MVC приложения с применением практических навыков следующего списка аспектов Spring:
1) :white_check_mark:Spring IoC, DI;
2) :black_square_button:Spring AOP;
3) :white_check_mark:Hibernate;
4) :white_check_mark:Hibernate Validator;
5) :white_check_mark:Spring MVC;
6) :black_square_button:Spring Security;
7) :black_square_button:Spring Boot

## Краткая реализация проекта:
Основная конфигурация *Front Controller* и *applicationContex* происходит в **web.xml** (path: Spring_main_project/src/main/webapp/WEB-INF/web.xml) и в **applicationContex.xml** (path: Spring_main_project/src/main/webapp/WEB-INF/applicationContext.xml) соотвтственно.

В качестве серверной части исполюзую **Tomcat 9.0.58**, в качестве БД **MySQL**.

*Принципы взаимодействия с БД (согласно принципам MVC):*
>**View** - В качетсве view использую html страницы представленные в пакете (path: Spring_main_project/src/main/webapp/WEB-INF/view/) в формате *.jsp, доступ ко вью имеет только контроллер, любой редирект из view происходит с указанием имени @RequestMapping(..) метода контроллера;

>**Controller** - контроллер(ы) представлен в пакете (path: Spring_main_project/src/main/java/com/guzanov/spring/controllers/), основные задачи контроллера:
>+ предоставление актуальных view и их обновление согласно входящим реквестам;
>+ взаимодействие с БД по средствам сервиса (MyService.class).

>**Model** - контейнер с данными, в роле модели выступает каждая отдельно взятая сущность (Entity).
>
>>**Entity** - сущность, конкретное представление отдельной таблицы в виде Java-класса. Место нахождения (path: Spring_main_project/src/main/java/com/guzanov/spring/entity/).
>>
>>**Service** - сервис выступает в роле прослойки между DAO классами и Controller'ами, нужны для упрощения взаимодействия с DAO (меньше кода в классах контроллера, не нужно создавать экземпляр каждого используемого DAO класса, достаточно реализовать Сервис-класс в котором описано взаимодействие с каждым DAO-классом). Место нахождения (path: Spring_main_project/src/main/java/com/guzanov/spring/services/).
>>
>>**DAO (паттерн)** - классы для коннекта к БД, каждый отдельный DAO класс создается под соответствующую сущность, т.е. DAO-классы реализуют взаимодействие с каждой конкретной таблицей базы данных. Место нахождения (path: Spring_main_project/src/main/java/com/guzanov/spring/dao/).

**View <--> Controler <--> MyService<-->DAO's<--(Entity по средствам CRUD)-->DB**;


