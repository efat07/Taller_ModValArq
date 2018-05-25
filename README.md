# Taller_ModValArq

RESUMEN:
Taller practico realizado para la clase de modelamiento y validacion de arquitectura en la Universidad Javeriana - 2018.
La aplicación permite realizar pago de factura de servicios por medio de una plataforma que se encarga de validar el cliente, el convenio, consultar el valor a pagar, y enviar el pago a las diferentes recaudadores de los diferentes convenios.

Patrones implementados:
Dispatcher: Se encarga de realizar el llamado a otro servicio para transformar el mensaje y posteriormente envia el mensaje al servicio exterior correpondiente de acuerdo al servicio que se esta recaudando.
Intermediate Routing: Se encarga de encontrar las rutas externas a los convenios.

Orquestación de servicios:
Se realiza una orquestación de servicios (composición de servicios) en donde el Coordinador de pagos es el servicio encargado de definirla lógica de la interacción entre los diferentes servicios creados para cumplir con la funcionalidad de realización de pagos a servicios públicos.

Herramientas:
JAVA: Lenguaje en el que se desarrolló la funcionalidad.
Archivo Servicios: Archivo con los servicios y sus respectivas URLs, en este archivo se crean y modifican los convenios para los cuales esta permitido el recaudo de los servicios.
WSO2: Herramienta utilizada para el gobierno de los servicios.

Servicios creados:
Usuario: Servicio encargado de validar los usuarios que acceden a realizar los pagos de servicios. 
Convenio: Servicio encargado de validar el convenio seleccionado por el usuario. 
MedioPago: Servicio que valida el medio de pago seleccionado por el cliente para hacer el pago (1-PSE, 2-PayPal, 3-PayU).
IntermediateRouting: Servicio que consulta en un archivo la url a la que se debe enrutar el pago dependiendo del convenio que se va a cancelar.
Transformador: Servicio que transforma los datos a la estructura de los servicios externos 
Dispatcher: Servicio que realiza el llamado al servicio transformador y posteriormengte llama a los servicios externos de los recaudadores para realizar el pago. 
Coordinador Pago: Servicio orquestador de servicios.

Ver imagen del Diagrama de arquitectura de servicios implementada.
