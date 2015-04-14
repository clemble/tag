FROM java:8-jre
MAINTAINER antono@clemble.com

EXPOSE 10016

ADD target/tag-*-SNAPSHOT.jar /data/tag.jar

CMD java -jar -Dspring.profiles.active=cloud -Dserver.port=10016 /data/tag.jar
