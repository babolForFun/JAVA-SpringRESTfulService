# JAVA-SpringRESTfulService

Real base RESTful service using JAVA (Spring).

  - MySQL
  - Spring 4.2.5
  - Eclipse Java EE Mars.2
  - Tomcat v8.0

Basic RESTful sevice that allows CRUD operations to MySQL database. 

### Version
1.0.2

### CURL

Add user
```sh
$ curl --data "name=name&Surname=surname&age=yourage&address=address&extra=extraAttribute" http://localhost:[PORT]/[ProjectName]/rest/methods/addUser
```

