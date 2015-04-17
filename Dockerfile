FROM java:8-jre
MAINTAINER antono@clemble.com

EXPOSE 10016

ADD ./buildoutput/tag-*-SNAPSHOT.jar /data/tag.jar

CMD java -jar -Dspring.profiles.active=cloud -Dlogging.config=classpath:logback.cloud.xml -Dserver.port=10016 /data/tag.jar
