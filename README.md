# Bar-Tender
<h2>Ejecución</h2>

1. En el terminal como administrador ir hasta la ruta donde está el proyecto.

_Optional:_ primera vez 

```bash
.\mvnw.cmd clean package
```

2. seguidamente se ejecuta el siguiente comando para inicializar la aplicación:

```bash
 java -jar .\target\demo-0.0.1-SNAPSHOT.jar
```

3. el puerto por defecto es :8080

<h2>Pruebas</h2>

Para la realización de la prueba se creo el siguiente Enpoint:

Metodo GET
url: localhost:8080/v1/retirarVasos/{q}/{pila}

-donde: 

q => son las iteraciones

pila => identificador del registro de la BD

-Ejemplo:
localhost:8080/v1/retirarVasos/3/1
 
 .Respuesta:
 ```bash
 {
    "msg": "Proceso terminado.",
    "cuerpo": "8,6,4,2,5,7"
}
 ```
 
 <h2>Herramientas y tecnologías utilizadas</h2>

* Spring Boot
* Java 1.8
* Maven
* JPA
* Lombok
* Junit
* Mockito
* Jacoco
* Principios Solid
* Clean Architecture
* Acceso a BD en memoria H2
