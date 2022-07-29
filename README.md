# cloud-estacionamento

##Run Docker Database

docker run --name estacionamento-db -p 5432:5432 -e POSTGRES_DB=estacionamento -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=123 -d postgres:10-alpine

## <center>START and STOP Database</center>

#COMANDO PARA PARADA (STOP)
docker stop estacionamento-db

#COMANDO PARA INICIAR (START)
docker start estacionamento-db

## <center> LINK PARA ACESSAR O ESTACIONAMENTO </center>
https://cloud-estacionamento.herokuapp.com/swagger-ui.html

## USER E PASSWORD
<li><b>usuário</b>: user</li>
<li><b>senha</b>: mmg@13579</li>