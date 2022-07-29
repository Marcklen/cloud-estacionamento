# cloud-estacionamento

##Run Docker Database

docker run --name estacionamento-db -p 5432:5432 -e POSTGRES_DB=estacionamento -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=123 -d postgres:10-alpine

## START and STOP Database

#COMANDO PARA PARADA (STOP)
docker stop estacionamento-db

#COMANDO PARA INICIAR (START)
docker start estacionamento-db