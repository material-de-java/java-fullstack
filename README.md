# Fullstack (springboot, hibernate, JWT, API Rest)

Curso sobre como crear un sistema de usuario completo en Java con springboot, hibernate, JWT y API Rest.


## Base

Proyecto basado en: 'https://www.youtube.com/watch?v=7vHzVN0EiQc&ab_channel=ATLAcademy%28byLucasMoy%29'

## Contenido de aprenfizaje

1. Inyección de dependencias
2. Control de sesion de usuarios con estandar JWT
3. Servicios API-REST con SpringBoot 3.0.5 (springweb)
4. ORM con Hibernate
5. Inicializar proyecto con: 'https://start.spring.io/'
6. Dependencias con MAVEN (3.9.1) y Empaquetado WAR - openJDK 17.0.6
7. Front Booststrap

## Estructura de la aplicación

- M
- V
- C: Controlladores -> Se encarga de la gestion/logica cuando el usuario usa la url:'myappweb/usuario'
	- Los controladores vevuelven los recursos para trabajar en el front, ej: lista, datos
	- Notación Springboot para denotar que la clase es controller: `@RestController`
	- Notación Springboot para indicar el metodo que responde al resquest del front segun la url indicada: `@RequestMapping(value = "url indicada")` 
	

## Estrutura de archivos

1. POM.xml: Estructura del proyecto, definiciones y dependencias de maven
2. src: codigo
3. test: codigo para pruebas
4. main: codigo del proyecto
5. resources: archivos de configuración y archivos del front
6. resources/static: archivos de acceso publico: archivos multimedia, *.html o index.html
7. java: codigo fuente del proyecto

## Comandos Spring boot

- iniciar app web: `mvn spring-boot:run`
- limpiar proyecto para recompilar: `mvn:clean`

Aplicación: Apache Tomcat: puerto 8080

