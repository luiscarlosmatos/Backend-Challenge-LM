# **Consults Management**

### **What this is**

Http REST API that allows Consult management to a hospital.

### **API Documentation**
#### **Offline**
   * go to https://editor.swagger.io/
   * past the file content of apiDoc.yml
#### **Online**
Once the application starts go to
http://localhost:8080/challenge/swagger-ui/index.html#/



### **Requirements**

 - Maven
 - Java 17
 - Docker

### **Start-up**

Run the following commands in the command line:

    - mvn clean install 
    - docker build -t challenge-1.0.0.jar .
    - docker-compose up

or by single click on:
* ###### run.bat (windows)
* ###### run.sh (linux)

On start up, some data will be populated on the database using flyway migration tool.

