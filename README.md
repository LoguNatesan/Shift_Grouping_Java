# Shift_Grouping_Java
Implementing Shift Grouping in a Maven project with SpringBoot Framework,JPA, Hibernate, H2 Database &amp; Tomcat Server

# Pre-requisites/Environment

* Spring/SpringBoot framework
* Spring Tool Suite 4 - STS(ver: 4.7.0.RELEASE)
* JPA 
* Hibernate
* H2 database (embedded in Spring framework)
* JAVA - version 1.8 
* Maven Plugin
* ThymeLeaf - Serverside JAVA template engine (for UI)

# Relationship between tables

* In the schema provided, there is a **Many to Many relationship** between the tables "_shift_" and "_shift_group_".
  * i.e., Bothsides of the relationship can have multiple references to each other. 
* "_shift_grouping_" is a join table with 2 foreign keys between "_shift_" and "_shift_group_"
  * _shift_group_code_ : primary key of shift_group table 
  * _shift_code_ : primary key of shift table

* A join table is necessary to facilitate many to many relationship. Both Foreign keys together create composite primary key for _shift_grouping_.

* _Shift_group_ table has relationship with both _shift_group_code_ & _shift_code_ keys in _shift_grouping_ table whereas _Shift_ table has relationship with only _shift_code_ key in _shift_grouping_ table. This represents that there is **unidirectional relationship** which means, with _shift_group_ object related _shift_ objects (collection) can be retrieved but vice_versa is not possible.

# Assumptions

* _Shift_ table data: (with 3 shifts)
 * M-01 - Morning Shift
 * E-02 - Evening Shift
 * N-03 - Night Shift

* Shift_group table data: (only 6 groups with 3 people each)
 * Groups - A,B,C,D,E,F (Total members - 6 * 3 = 18)
 
# Decisions
 
* Implemented mapping & method as a Maven project using SpringBoot framework with JPA, Hibernate, H2 (Embedded Database) & Tomcat Server (Embedded Server) in Eclipse IDE
* SpringBoot avoids lot of boilerplate code, Annotations and XML configuration. It also provides easy integration with Spring Ecosystem like Spring ORM, Spring Data etc... and embedded HTTP servers and DataBase(Tomcat, H2). 
* In order to check 'doesShiftBelongToGroup' accessing only _shift_group_ object is enough because _Shift_ (collection) is stored inside _shift_group_ object. 
* Used HashSet to store the collection of shift objects instead of ArrayList, since it helps JPA & Hibernate to handle DML operations efficiently. 

 ## Delpoyment to Production environment, 
 * Creating as a Maven(build tool) project will facilitate Dependency Management, Transitive Dependency and minimal configuration.
 * With Many to Many mapping implemented in the application using JPA & Hibernate for Object Relational Mapping(ORM), SpringBoot framework will automatically create tables in H2 database and store datas.
