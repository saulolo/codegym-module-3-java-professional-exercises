package org.educatiom.lesson02_MavenParte2_Avanzado;

public class AppWebConSpringBoot {

    public static void main(String[] args) {

        System.out.println("--------------------- App Web Con Spring Boot ---------------------------");
        //Construyendo una aplicación web basada en SpringBoot

        /*
        1. Crear un proyecto web Maven vacío con IDEA.
        2. Agregue dependencias de Spring a su pom.xml:
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
            <scope>provided</scope>
        </dependency>

        3. Cree una clase com.codegym.spring.MainController . Debe colocarse en la carpeta src/main/java:
        @Controller
        public class MainController {

            @GetMapping("/")
            public String viewIndexPage(Model model) {
                model.addAttribute("header", "Maven Generate War");
                return "index";
            }
        }

        Descripción:
        - @Controller:  le dice al marco SpringBoot que esta clase se usará para atender las solicitudes web entrantes.
        - @GetMapping indica que se llamará a nuestro método para atender una solicitud GET en el URI raíz - /
        - Tercero, el método devuelve la cadena "index" . Esto le dice al marco SpringBoot que devuelva el contenido
          del archivo index.html como respuesta .

          4. Debe agregar un archivo index.html al proyecto con el siguiente contenido:
            <!DOCTYPE html>
            <html lang="en" xmlns:th="http://www.thymeleaf.org">
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <title>Index</title>
                <!-- Bootstrap core CSS -->
                <link th:href="@{/css/bootstrap.min.css}" rel="stylesheet">
            </head>
            <body>
                <nav class="navbar navbar-light bg-light">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="#">
                            CodeGym Tutorial
                        </a>
                    </div>
                </nav>
                <div class="container">
                    <h1>[[${header}]]</h1>
                </div>
            </body>
            </html>

      5. Configure el plugin en pom.xml:
      <plugin>
        <artifactId>maven-war-plugin</artifactId>
        <version>3.3.1</version>
      </plugin>




        */

    }
}
