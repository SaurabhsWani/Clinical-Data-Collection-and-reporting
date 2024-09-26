FROM openjdk
VOLUME /tmp
ADD target/ClinicalsApi-0.0.1-SNAPSHOT.jar ClinicalsApi-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","ClinicalsApi-0.0.1-SNAPSHOT.jar"]