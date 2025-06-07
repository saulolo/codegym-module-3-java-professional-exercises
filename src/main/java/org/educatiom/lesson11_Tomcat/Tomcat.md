# 🚀 GUÍA RÁPIDA DE APACHE TOMCAT: EL SERVIDOR WEB PARA JAVA 🌐

Apache Tomcat es un servidor web y un contenedor de servlets de código abierto,
desarrollado por la Apache Software Foundation. Es ampliamente utilizado para
desplegar y servir aplicaciones web basadas en Java, como Servlets, JavaServer Pages (JSP)
y Java Expression Language (JEL). Tomcat actúa como un "motor" que permite
que las aplicaciones Java interactúen con el protocolo HTTP.

---
## 1. ¿QUÉ ES TOMCAT Y POR QUÉ ES IMPORTANTE? 📚

Tomcat es esencialmente un **servidor de aplicaciones web ligero** que implementa
las especificaciones Java Servlet, JavaServer Pages (JSP), Java Expression Language (JEL),
y Java WebSocket.

-   **Servidor Web**: Se encarga de las tareas rutinarias relacionadas con el protocolo HTTP:
    -   Servir archivos estáticos (HTML, CSS, JavaScript).
    -   Gestionar los derechos de acceso a los recursos.
    -   Manejar la carga, ejecución y descarga de aplicaciones web.
    -   Registrar informes de errores.
    -   Habilitar la interacción entre aplicaciones web y más.
-   **Contenedor de Servlets**: Su función principal es proporcionar un entorno de
    ejecución para los Servlets y JSPs. Cuando una solicitud HTTP llega a Tomcat,
    este la dirige al Servlet o JSP adecuado, que procesa la solicitud y genera la respuesta.
-   **Popularidad**: Es el servidor web más popular para aplicaciones web escritas en Java,
    siendo un estándar de facto en la industria.

---
## 2. ARQUITECTURA BÁSICA DE TOMCAT 🏗️


Tomcat se organiza jerárquicamente con componentes principales:

-   **`Server`**: Es el elemento de nivel superior en el archivo `server.xml`. Representa
    la instancia de Tomcat completa y contiene uno o más servicios.
-   **`Service`**: Agrupa un **`Connector`** (que maneja las conexiones de red) y un **`Engine`**
    (que procesa las solicitudes). Un `Server` puede tener múltiples `Service`s.
-   **`Connector`**: Es el componente que recibe las solicitudes HTTP (o AJP, etc.) y las
    pasa al `Engine`. Escucha en un puerto específico (por defecto 8080 para HTTP).
    Puede haber múltiples `Connector`s para diferentes protocolos o puertos.
-   **`Engine`**: Procesa las solicitudes recibidas del `Connector`. Representa el
    procesador de solicitudes de Tomcat y puede contener uno o más `Host`s.
-   **`Host`**: Representa un *virtual host* o un dominio específico. Un `Engine`
    puede contener múltiples `Host`s. Cada `Host` puede contener múltiples `Context`s.
-   **`Context`**: Representa una aplicación web individual (Web Application). Es el
    componente más bajo en la jerarquía que un desarrollador de aplicaciones Java
    web manipula directamente. Contiene servlets, JSPs, recursos estáticos, etc.
    Cada `Context` tiene su propio classpath y sus archivos están típicamente en
    un directorio `.war` o una estructura de directorios expandida.

**Diagrama simplificado:**

```
Server
  └─ Service
       ├─ Connector (e.g., HTTP on port 8080)
       └─ Engine
            └─ Host (e.g., localhost)
                 └─ Context (e.g., /myWebApp)
                      └─ Servlets, JSPs, Static Files
```
---
## 3. ESTRUCTURA DE UNA APLICACIÓN WEB (WEBAPP) EN TOMCAT 📂


Una aplicación web en Tomcat sigue una estructura de directorios estándar:

```
webapp_name/
├── META-INF/
│   └── MANIFEST.MF
└── WEB-INF/
    ├── web.xml           <-- Descriptor de despliegue (obligatorio en versiones antiguas, opcional con anotaciones)
    ├── classes/          <-- Archivos .class de Servlets, utilidades, etc.
    └── lib/              <-- Archivos JAR con librerías externas (dependencias)
├── index.html / index.jsp / index.
└── other_static_files/  <-- HTML, CSS, JavaScript, imágenes

```

-   **`WEB-INF/`**: Directorio especial que no es directamente accesible desde el cliente.
    Contiene la configuración crucial y las clases Java.
-   **`web.xml`**: El *Deployment Descriptor* tradicional. Configura servlets, filtros,
    listeners, mapeos de URL, parámetros de inicialización, etc. Aunque ahora muchas
    configuraciones se pueden hacer con anotaciones (`@WebServlet`, `@WebFilter`),
    `web.xml` sigue siendo relevante para configuraciones más complejas o específicas.
-   **`classes/`**: Contiene los archivos `.class` compilados de Servlets, JavaBeans,
    y otras clases Java de la aplicación.
-   **`lib/`**: Almacena todos los archivos `.jar` de librerías externas que la aplicación
    necesita para funcionar.

---
## 4. DESPLIEGUE (DEPLOYMENT) DE APLICACIONES 🚀

Desplegar una aplicación web en Tomcat implica colocarla en el directorio adecuado para que
el servidor la detecte y la cargue.

-   **Directorio `webapps`**: Es el directorio predeterminado donde Tomcat busca las
    aplicaciones web. Se encuentra en la instalación de Tomcat ( `$CATALINA_HOME/webapps` ).
-   **Tipos de Despliegue**:
    -   **WAR (Web Application Archive)**: El método más común. Es un archivo `.war`
        que contiene toda la estructura de la aplicación comprimida. Tomcat lo descomprime
        automáticamente en un directorio con el mismo nombre y lo despliega.
        Ejemplo: `myApp.war` se despliega como `/myApp`.
    -   **Directorio Expandido**: Colocar la estructura de directorios de la aplicación
        directamente en `webapps`.
    -   **Despliegue a través del Manager App**: Tomcat incluye una aplicación web de gestión
        (`Manager App`) que permite desplegar, iniciar, detener y recargar aplicaciones
        remotamente a través de una interfaz web.

---
## 5. SERVLETS Y SUS ANOTACIONES PRINCIPALES 🧩


Los Servlets son las clases Java que procesan las solicitudes HTTP. Con la introducción
de Servlet API 3.0 (y posteriores), se pueden configurar usando anotaciones.

| Anotación             | Descripción                                                          | Atributos Comunes (en `@WebServlet`)                               |
| :-------------------- | :------------------------------------------------------------------- | :---------------------------------------------------------------- |
| `@WebServlet`         | Marca una clase como un Servlet y lo mapea a URL.                    | `name`: Nombre único del servlet (opcional).                      |
|                       |                                                                      | `value` / `urlPatterns`: Lista de patrones URL a los que responde el servlet. |
|                       |                                                                      | `loadOnStartup`: Orden de inicialización del servlet (entero, 0 o más). |
|                       |                                                                      | `initParams`: Parámetros de inicialización como `@WebInitParam`.  |
|                       |                                                                      | `asyncSupported`: Indica si el servlet soporta operación asíncrona. |
| `@WebFilter`          | Marca una clase como un Filtro y lo mapea a URL o Servlets.          | `filterName`, `value`/`urlPatterns`, `servletNames`, `initParams`, `asyncSupported` |
| `@WebListener`        | Marca una clase como un Listener para eventos del ciclo de vida de la aplicación. | (No tiene atributos específicos de configuración en la anotación misma) |
| `@WebInitParam`       | Usado dentro de `@WebServlet` o `@WebFilter` para definir parámetros de inicialización. | `name`: Nombre del parámetro.                                     |
|                       |                                                                      | `value`: Valor del parámetro.                                     |

**Ciclo de vida de un Servlet (Métodos clave):**

-   **`init()`**: Se llama una vez cuando el servlet se carga (después de la instanciación).
    Usado para inicializaciones únicas.
-   **`service(ServletRequest req, ServletResponse res)`**: El método principal que Tomcat
    llama para cada solicitud HTTP. A menudo se delega a `doGet()`, `doPost()`, etc.
-   **`doGet(HttpServletRequest req, HttpServletResponse res)`**: Maneja solicitudes HTTP GET.
-   **`doPost(HttpServletRequest req, HttpServletResponse res)`**: Maneja solicitudes HTTP POST.
-   **`destroy()`**: Se llama una vez cuando el servlet se va a descargar (antes de la destrucción de la instancia).
    Usado para liberar recursos.

**Ejemplo de Servlet Básico:**

```java
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet", urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>¡Hola desde el Servlet de Tomcat!</h1>");
        out.println("</body></html>");
    }
}
```
---
## 6. ARCHIVO `server.xml` (CONFIGURACIÓN AVANZADA) ⚙️

El archivo `server.xml` (ubicado en `$CATALINA_HOME/conf/`) es el archivo de configuración
principal de Tomcat. Permite personalizar la arquitectura de Tomcat.

-   **Modificar el puerto HTTP:**
    ```xml
    <Connector port="8080" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" />
    ```
    Cambia `port="8080"` al puerto deseado (e.g., `80` para HTTP estándar).

-   **Configurar Host y Context:**
    ```xml
    <Engine name="Catalina" defaultHost="localhost">
        <Host name="localhost" appBase="webapps"
              unpackWARs="true" autoDeploy="true">
        </Host>
    </Engine>
    ```

-   **Habilitar HTTPS (SSL/TLS):** Implica añadir otro `Connector` con `protocol="org.apache.coyote.http11.Http11NioProtocol"` y configurar `SSLEnabled="true"`, `clientAuth`, `keystoreFile`, `keystorePass`.

---
## 7. CHEATSHEET RÁPIDA DE TOMCAT ⚡

| Elemento            | Descripción Breve                                  | Notas Clave                                                      |
| :------------------ | :------------------------------------------------- | :--------------------------------------------------------------- |
| **Tomcat** | Servidor Web y Contenedor de Servlets Java.        | Despliega Servlets, JSPs, WebSockets.                            |
| **`webapps`** | Directorio donde se despliegan las aplicaciones.   | `$CATALINA_HOME/webapps/`                                        |
| **WAR** | Formato de empaquetado de aplicaciones web (`.war`). | Despliegue estándar. Tomcat lo expande automáticamente.          |
| **`WEB-INF`** | Directorio seguro, no accesible directamente.      | Contiene `web.xml`, `classes`, `lib`.                            |
| **`web.xml`** | Descriptor de despliegue. Configura servlets/filtros. | Opcional con anotaciones en Servlet 3.0+.                        |
| **Servlets** | Clases Java que manejan solicitudes HTTP.          | `doGet()`, `doPost()`. Configurados con `@WebServlet`.          |
| **`@WebServlet`** | Anotación para mapear un Servlet a URLs.           | `urlPatterns={"/path"}`                                          |
| **`@WebFilter`** | Anotación para configurar un Filtro.               | Intercepta solicitudes/respuestas.                               |
| **`@WebListener`** | Anotación para escuchar eventos del ciclo de vida. | Para eventos de contexto, sesión, solicitud.                     |
| **`server.xml`** | Archivo de configuración principal de Tomcat.      | Configura `Connector`s (puertos), `Host`s, `Engine`s.            |
| **`Connector`** | Componente que recibe solicitudes (puertos).       | Por defecto HTTP en 8080. Se puede configurar para HTTPS (8443). |
| **`Context`** | Representa una aplicación web específica.          | Mapeado a una ruta (`/myApp`).                                   |
| **`init()`** | Método de ciclo de vida del Servlet (una vez al inicio). | Para inicialización de recursos.                                 |
| **`service()`** | Método de ciclo de vida del Servlet (por cada solicitud). | Llama a `doGet()`, `doPost()`, etc.                              |
| **`destroy()`** | Método de ciclo de vida del Servlet (una vez al cierre). | Para liberar recursos.                                           |


### METADATOS DEL DOCUMENTO 📄

| Campo           | Detalles                                         |
| :-------------- |:-------------------------------------------------|
| **Título** | GUÍA RÁPIDA DE APACHE TOMCAT: EL SERVIDOR WEB PARA JAVA      |
| **Autor(es)** | Saul Echeverri                                   |
| **Versión** | 1.0.0                                            |
| **Fecha de Creación** | 06 de Junio de 2025                              |
| **Última Actualización** | 0g de Junio de 2025                              |
| **Notas Adicionales**  | Documento base para referencia rápida de Tomcat. |

---