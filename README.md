# Clinical-Data-Collection-and-reporting
# To dockerize this app with following steps
Setup the mysql container:

docker run -d -p 6666:3306 --name=docker-mysql --env="MYSQL_ROOT_PASSWORD=test1234" --env="MYSQL_DATABASE=clinicals" mysql

//To create tables and insert the data
docker exec -i docker-mysql mysql -uroot -ptest1234 clinicals <clinicals.sql


Application Container and testing:

docker build -f Dockerfile -t clinicals_app .

docker run -t --link docker-mysql:mysql -p 10555:8080 clinicals_app

http://localhost:10555/clinicalservices/api/patients
