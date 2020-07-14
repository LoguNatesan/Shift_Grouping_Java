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

* In the schema provided, there is a Many to Many relationship between the tables "_shift_" and "_shift_group_".
  * i.e., Bothsides of the relationship can have multiple references to each other. 
* "_shift_grouping_" is a join table with 2 foreign keys between "_shift_" and "_shift_group_"
  * _shift_group_code_ : primary key of shift_group  
  * _shift_code_ : primary key of shift 

* A join table is necessary to facilitate many to many relationship. Both Foreign keys together create composite primary key for _shift_grouping_.

* Since only _shift_group_ table has relationship with both _shift_group_code_ & _shift_code_, keys in _shift_grouping_, shift table has relationship with only _shift_code_ key in _shift_grouping_. This represents that there is unidirectional relationship which means with shift_group object, related shift objects(collection)can be retrieved but vice_versa is not possible.

* In shift_grouping table, many instances of shift_group(shift_group_code) and many instances of shift(shift_code) will be pointing towards a single instance of shift_group table.Then many instances of shift(shift_code)in shift_grouping table will be pointing towards a single instance of shift table.
