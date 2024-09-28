
# Clinical-Data-Collection-and-reporting
Clinical Data Collection and reporting

## To dockerize this app with following steps
Setup the mysql container:

```bash
  docker run -d -p 6666:3306 --name=docker-mysql --env="MYSQL_ROOT_PASSWORD=test1234" --env="MYSQL_DATABASE=clinicals" mysql
```
To create tables and insert the data:
```bash
  docker exec -i docker-mysql mysql -uroot -ptest1234 clinicals <clinicals.sql
```
Application Container and testing:
```bash
  docker build -f Dockerfile -t clinicals_app .
```
Runt he clinical app with mysql connection:
```bash
  docker run -t --link docker-mysql:mysql -p 10555:8080 clinicals_app
```
Test on below url:

http://localhost:10555/clinicalservices/api/patients
