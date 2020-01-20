FROM openjdk:8-jre
COPY ./svc /svc
RUN ls -la
EXPOSE 9000 9443
CMD /svc/bin/start -Dhttps.port=9443 -Dplay.http.secret.key=5349g34t50gj249j4fjergjwg3pfk34t
