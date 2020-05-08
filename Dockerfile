FROM openjdk:8
EXPOSE 8080
ADD target/ticketBooking-0.0.1-SNAPSHOT.war ticketBooking-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java","-jar","/ticketBooking-0.0.1-SNAPSHOT.war"]
