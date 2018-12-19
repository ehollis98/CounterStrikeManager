# Eric Hollis Individual Project 

### Problem Statement

Counter Strike Global Offensive is a popular videogame created by Valve that has a highly competitive online gaming scene. Steam, an online game distributor,
offers the ability to see when your friends are online, but one must be in-game in order to see statistics and match overviews. I wanted to create a place
where a user can see their friend group online and track their progress or compare inventory items, share crosshair types, see win/loss ratios, accuracy, and much more.

[AWS Link](http://18.191.99.172:8080/CounterStrikeManager/)
### Project Technologies/Techniques 

* Security/Authentication
  * Tomcat's JDBC Realm Authentication
  * Admin role: Create/read/update/deleting of all data
  * User role: create user, create friend group, edit data they have entered previously
  * Login required
* Database
  * MySQL
  * Store users and roles
  * Store all data for the users and statistic reports
* ORM Framework
  * Hibernate 5
* Dependency Management
  * Maven
* Web Services consumed using Java
* CSS 
  * Bootstrap
* Data Validation
  * Bootstrap Validator for front end
  * Explore Hibernate's validation
* Logging
  * Configurable logging using Log4J2
* Hosting
  * AWS
* Independent Research Topic/s
  * Steam integration
  * Hibernate Validation
  * Hibernate Search
* Unit Testing
  * JUnit tests to achieve 80%+ code coverage 
* IDE: IntelliJ IDEA

### Design

* [Screen Design](DesignDocuments/Screens.md)
* [Application Flow](DesignDocuments/applicationFlow.md)
* [Database Design](DesignDocuments/erdDiagram.png)

### [Project Plan](ProjectPlan.md)

### [Development Journal](Journal.md)
