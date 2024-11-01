### PARCIAL 2 CORTE- AREP

Este proyecto consiste en un sistema de microservicios que tiene un servicio para computar las funciones de ordenamiento linear Search.  El servicio de las funciones de ordenamiento debe estar desplegado en al menos dos instancias virtuales de EC2. 

Adicionalmente, implementa un service proxy que recibe las solicitudes de llamado desde los clientes  y se las delega a las dos instancias del servicio de ordenamiento usando un algoritmo de round-robin. El proxy  esta desplegado en otra máquina EC2. 

## Starting

En su computadora descargue o clone los siguientes repositorios.

[Repository Math Service](https://github.com/Richi025/examen.git) 

[Repository Proxy Server](https://github.com/Richi025/examenproxy.git) 

You can also clone the file using the following command.

```
https://github.com/Richi025/examen.git 

https://github.com/Richi025/examenproxy.git 
```

### Requerimientos previos

Necesita tener instalado los siguiente, si es posible en sus ultimas versiones

#### Maven
```
Descargue Maven en http://maven.apache.org/download.html 

Siga las instrucciones de http://maven.apache.org/download.html#Installation
```
#### Java

```
Descargue Java en https://www.java.com/es/download/ie_manual.jsp
```

### Instalación

Abra el repositorio ambos proyectos. 


#### Correr el servidor de proxy y el servicio matematico

1. Abra una terminal en el  proxy.

2. Use el comando.
    ```
    mvn clean compile
    ```
3. ahora genere al jar con el siguiente comando.

    ```
    mvn package
    ```

4. Corra la aplicación.

    ```
    java -jar target/examenproxy-0.0.1-SNAPSHOT.jar

    Ahora el servidor esta corriendo
    ```


5. Luego  abra dos terminales en el proyecto examen y en cada terminar ejecute los siguientes comando de esta menara levantara dos servidores matematicos.

    ```
        --- primera terminal ---

        mvn clean package

        java -jar target/examen-0.0.1-SNAPSHOT.jar --server.port=8080
    ```

    ```
         ---- segunda terminal ---

        mvn clean package

        java -jar target/examen-0.0.1-SNAPSHOT.jar --server.port=8081
    ```

    6. Ahora puede ingresar usando:

    http://localhost:35000/ 

    ![alt text](images/image.png)

## Arquitectura


![alt text](<images/Untitled Diagram.drawio.png>)

Implementa un service proxy que recibe las solicitudes de llamado desde los clientes  y se las delega a las dos instancias del servicio de ordenamiento usando un algoritmo de round-robin. El proxy  esta desplegado en otra máquina EC2. 
Los servicio de matematicos, son linearSearch y binarySearch. Para la coneccion se uso HTTP , para el browser HTML y JS, en el servicio matematico se uso java con spring-boot.

## DESPLIEGUE AWS

+ El despliegue se realiza en 3 maquinas EC2, dos con servidor Matematico y 1 con el proxy. En esta oportunidad tienen las siguientes url, teniendo en cuanta que estas cambian cada que se vuelven a iniciar las instancias.

```
    http://107.23.126.11:8080/

    http://3.81.98.92:8081/ 

```
    
+ A continuación video del despliegue.

![Diseño sin título (2)](https://github.com/user-attachments/assets/2f836c53-a960-4145-8627-b6a93470e8ec)


### FALTO POR REALIZAR

 + Se realizo el despliegue en AWS fuera de clase, falto documentar el codigo.

## Contruido con:

* [Maven](https://maven.apache.org/) - Dependency management
* [java](https://www.java.com/es/) - Programming language
* [Spring boot](https://start.spring.io/) - Framework

## Versionado

Se uso [Git](https://github.com/) como repositorio

## Autor

* **Jose Ricardo Vasquez Vega** - [Richi025](https://github.com/Richi025)

## Fecha

10/31/2024
