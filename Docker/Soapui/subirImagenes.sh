#!/bin/sh
***************************

Usuario
docker build -t usuario .
docker run -it --rm -d -p 8083:8080 --name contuse usuario
http://localhost:8083/Usuario/servicios/usuarios/validar
***************************
Convenio
docker build -t convenio .
docker run -it --rm -d -p 8084:8080 --name contconv convenio
***************************
Coordinador Pago
docker build -t coorpago .
docker run -it --rm -d -p 8088:8080 --name contcoord coorpago
***************************
Dispatcher
docker build -t dispach .
docker run -it --rm -d -p 8087:8080 --name contdisp dispach
***************************
IntermediateRouting
docker build -t interrou .
docker run -it --rm -d -p 8086:8080 --name continter interrou
***************************
MedioPago
docker build -t mediopag .
docker run -it --rm -d -p 8085:8080 --name contmedio mediopag
***************************
Transformador
docker build -t trasform .
docker run -it --rm -d -p 8089:8080 --name conttrasn trasform
***************************
W1-REST-Service
docker build -t rest .
docker run -it --rm -d -p 9090:8080 --name contrest rest

