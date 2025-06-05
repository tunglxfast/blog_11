# my_blog
Assignment 11

-------------------------------Requirement------------------------------------------
- Java 21
- IDEA like IntelliJ

-------------------------------Run Application--------------------------------------
- Run application (MyblogApplication.java)
- Open in browser: http://localhost:8080/

-------------------------------Init database (if needed)--------------------------
- Run application (MyblogApplication.java)
- Open in browser: http://localhost:8080/h2-console
- Edit Login info (see in application.properties):
  + Driver Class: org.h2.Driver
  + JDBC Url: jdbc:h2:file:./database/h2_blog
  + User name: sa
  + No password
- Copy code in file "sql code.txt" then run it to init database.