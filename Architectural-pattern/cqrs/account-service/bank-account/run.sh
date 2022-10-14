
# Run Kafka
docker-compose up

# Run MongoDB
docker run -it -d --name mongo-container \
-p 27017:27017 --network techbankNet \
--restart always \
-v mongodb_data_container:/data/db \
mongo:latest

# Run MySQL server
docker run -it -d --name mysql-container \
-p 3306:3306 --network techbankNet \
-e MYSQL_ROOT_PASSWORD=techbankRootPsw \
--restart always \
-v mysql_data_container:/var/lib/mysql  \
mysql:latest

# Run MySQL Client - Adminer
#docker run -it -d --name adminer \
#-p 8080:8080 --network techbankNet \
# -e ADMINER_DEFAULT_SERVER=mysql-container \
#--restart always adminer:latest
