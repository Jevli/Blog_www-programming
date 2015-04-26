spring-webapp
=============

Spring web app for www-programming course



INSTALLATION

See:
webapp/src/main/resources/application.properties

Create database with a name and either use root or create user to access that database.
In the example at the application.properties the database name, user and password are all the same:
www2015


You need to install mysql. If you install XAMPP to windows, it will install MySQL.
To Linux use apt-get to install:
https://ariejan.net/2007/12/12/how-to-install-mysql-on-ubuntudebian/


RUN

mvn clean package tomcat7:run

Open in browser
http://localhost:8080


