# clean-services-app-back
This application is the front-end part of the clean-services app made using react native framework, the idea of the project if to manage the mobile clean services, like car cleaning, carpets, houses,....The application manage all type of users clients, workers, admins and make the communication between the worker and the clients easier by generating automessages and use whatsapp directly to connect and many features.

# Requirements
- java 1.8.0_202
- Spring boot: 4.0.0

# Instruction to install the application
```
git clone ...
cd clean-services-app-back
```

# usage
> Copy the application.properties.example.  
> Rename the file to application.properties.  
> Complete the between {} by your data.
```
spring.datasource.url=jdbc:mysql://localhost:3306/{your_database_name}
spring.datasource.username={your_username}
spring.datasource.password={your_password}
server.port={your_port}
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.servlet.multipart.max-file-size=50MB
spring.servlet.multipart.max-request-size=50MB
```

# Functionalities
- Search offers published, filter the offers.
- Search the offers directly on the map depeding on your actual position.
- Send demand without need to create an account using whatsapp and auto generated messages from the forms.
- Create a worker account to share job offers.
- Manage all the offers by switching the availibilty and precising all the work and rest times.
- Favortie list.
