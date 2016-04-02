# JAVA-SpringRESTfulService

Real base RESTful service using JAVA (Spring).

  - MySQL
  - Spring 4.2.5
  - Eclipse Java EE Mars.2
  - Tomcat v8.0

Basic RESTful sevice that allows CRUD operations to MySQL database. 

### Version
1.0.2

### Database table

```sh
DROP TABLE IF EXISTS User;
CREATE TABLE User(
   _id   INT NOT NULL AUTO_INCREMENT,
   name VARCHAR(255) NOT NULL,
   surname VARCHAR(255) NOT NULL,
   age VARCHAR(255) NOT NULL,
   address VARCHAR(255) NOT NULL,
   extra VARCHAR(255) NOT NULL,
   PRIMARY KEY (_id)
);
```

### CURL

Create user
```sh
$ curl --data "name=[name]&Surname=[surname]&age=[age]&address=[address]&extra=[extra]" http://localhost:[PORT]/[ProjectName]/rest/methods/addUser
```

Read user
```sh
$ curl --data "_id=[user_id]" http://localhost:[PORT]/[ProjectName]/rest/methods/getUserById
```

Update user
```sh
$ curl --data "_id=[user_id]&age=[new_age]" http://localhost:[PORT]/[ProjectName]/rest/methods/update
```

Delete user
```sh
$ curl --data "_id=[user_id]" http://localhost:[PORT]/[ProjectName]/rest/methods/delete
```

User list
```sh
$ curl --data "name=name&Surname=surname&age=yourage&address=address&extra=extraAttribute" http://localhost:[PORT]/[ProjectName]/rest/methods/userlist
```

