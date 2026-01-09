# order-notification-svc
Order notification service using Webhook. A project to learn practical usage of web hooks.

# How to run the app
### pre-requisite 
Java 17 or higher

### to compile and build
`mvn clean install`

### to run the app
`mvn spring-boot:run`

Once app starts verify that app is running successfully by checking healthcheck at http://localhost:8080/health

Verify database tables via H2 console
go to http://localhost:8080/h2-console

Settings:
JDBC URL: `jdbc:h2:mem:orderdb`
User: `sa`
Password: (blank)

You should see following tables:
`ORDERS`
`WEBHOOK_EVENTS`

NOTE: this app uses H2 in memory database. H2 in-memory DB resets on restart. If you want persistence across restarts:
update this line in application.yaml:
    `url: jdbc:h2:mem:orderdb`
to
   `url=jdbc:h2:file:./data/orderdb`  
