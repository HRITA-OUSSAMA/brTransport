
FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD=root-password

COPY ./schema.sql /docker-entrypoint-initdb.d/

EXPOSE 3306

