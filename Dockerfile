FROM java:8-jre
MAINTAINER antono@clemble.com

EXPOSE 8080

ADD target/tag-0.17.0-SNAPSHOT.jar /data/tag.jar

CMD java -jar -Dspring.profiles.active=cloud /data/tag.jar
