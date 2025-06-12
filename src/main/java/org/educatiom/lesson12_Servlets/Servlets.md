# 🚀 GUÍA RÁPIDA DE SERVLETS EN JAVA (API DE SERVLET) 🌐

Un Servlet es un componente Java basado en clases que se ejecuta en un servidor
para extender las capacidades de un servidor, alojando aplicaciones en la web.
Permiten a los desarrolladores manejar solicitudes HTTP y generar respuestas
dinámicas, lo que los convierte en la base de la mayoría de las aplicaciones
web Java.

---
## 1. INTRODUCCIÓN A SERVLETS Y SU IMPORTANCIA 📚

-   **Definición**: Un Servlet es un "plugin" de Java que se integra en un servidor web
    Java (como Apache Tomcat) para ejecutar código Java en respuesta a
    solicitudes de páginas específicas.
-   **Función**: Procesan solicitudes HTTP y generan respuestas dinámicas (HTML, JSON, XML, etc.).
    Son la interfaz entre las solicitudes HTTP y el código Java de la aplicación.
-   **Contenedor de Servlets**: El servidor web (ej., Tomcat) es el "contenedor de servlets".
    Es responsable de cargar, inicializar, ejecutar y destruir los servlets, así como
    de manejar el mapeo de URL a servlets.
-   **Evolución**: Aunque los Servlets fueron la tecnología original para el desarrollo
    web en Java, hoy en día a menudo se utilizan frameworks como Spring MVC que los
    abstraen, pero la comprensión de Servlets sigue siendo fundamental.

---
## 2. CICLO DE VIDA DE UN SERVLET 🔄

El ciclo de vida de un servlet es gestionado por el contenedor de servlets y consta
principalmente de tres métodos:

1.  **Instanciación y `init()`**:
    -   Cuando el contenedor de servlets necesita cargar un servlet (generalmente la
        primera vez que se solicita, o al inicio del servidor si `loadOnStartup` está configurado),
        crea una instancia del servlet.
    -   Inmediatamente después de la instanciación, el contenedor llama al método `init()`
        del servlet. Este método se ejecuta **solo una vez** durante la vida útil del servlet
        y se utiliza para inicializar recursos (conexiones a bases de datos, etc.).
2.  **`service()` (Manejo de Solicitudes)**:
    -   Una vez que el servlet está inicializado, el contenedor llama al método `service()`
        para cada nueva solicitud entrante al servlet.
    -   El método `service()` examina el tipo de solicitud HTTP (GET, POST, etc.) y
        generalmente delega la llamada a métodos específicos como `doGet()`, `doPost()`, etc.
    -   `HttpServlet` (la clase más común para servlets HTTP) implementa `service()` para
        hacer esta delegación automáticamente.
3.  **`destroy()`**:
    -   Cuando el contenedor de servlets necesita descargar un servlet (ej., al apagar
        el servidor, al reiniciar la aplicación, o si el servlet está inactivo por mucho tiempo),
        llama al método `destroy()`.
    -   Este método se ejecuta **solo una vez** y se utiliza para liberar recursos que
        el servlet pudo haber adquirido durante `init()` o su ejecución (cerrar conexiones, etc.).

**Diagrama de Flujo del Ciclo de Vida:**
```
Servlet Loaded/Requested
       |
       V
  Instantiate Servlet
       |
       V
  call init() method (once)
       |
       V
 Servlet Ready to handle requests
       |
       V (For each client request)
  call service() method
       | (delegates to)
       V
  doGet()/doPost()/... methods
       |
       V (Container decides to unload)
  call destroy() method (once)
       |
       V
Servlet Unloaded/Garbage Collected
```
---
## 3. CLASES CLAVE DE SERVLETS (API DE SERVLET) 🧩

| Clase/Interfaz      | Descripción                                                          | Notas Clave                                                         |
| :------------------ | :------------------------------------------------------------------- | :------------------------------------------------------------------ |
| **`Servlet` (Interfaz)** | Interfaz raíz para todos los servlets. Define los métodos del ciclo de vida (`init`, `service`, `destroy`). | Implementación de bajo nivel. `HttpServlet` es la más común para HTTP. |
| **`GenericServlet`** | Clase abstracta que implementa `Servlet` y `ServletConfig`, pero es independiente del protocolo. | Util para servlets no HTTP.                                         |
| **`HttpServlet`** | Clase abstracta que extiende `GenericServlet` y proporciona métodos específicos para HTTP. | La clase base para la mayoría de los servlets web. Delega a `doGet`, `doPost`, etc. |
| **`HttpServletRequest`** | Objeto que encapsula la solicitud HTTP del cliente. | Proporciona acceso a parámetros, encabezados, cookies, sesión, etc. |
| **`HttpServletResponse`** | Objeto que permite construir la respuesta HTTP al cliente. | Permite establecer tipo de contenido, encabezados, escribir el cuerpo de la respuesta. |
| **`ServletContext`** | Proporciona información sobre la aplicación web (contexto) y acceso a recursos. | Un único objeto `ServletContext` por aplicación web. Permite comunicación entre servlets. |
| **`ServletConfig`** | Permite acceder a parámetros de inicialización específicos de un servlet. | Se obtiene a través del método `getServletConfig()`.                 |

---
## 4. MÉTODOS IMPORTANTES DE `HttpServlet` ✅

Los métodos `doXxx()` son invocados por el método `service()` de `HttpServlet`
basado en el método HTTP de la solicitud.

| Método                                    | Descripción                                                                 | Uso Principal                                     |
| :---------------------------------------- | :-------------------------------------------------------------------------- | :-------------------------------------------------- |
| `void init(ServletConfig config) throws ServletException` | Se llama una vez, después de la instanciación. Para inicializar recursos. | Configuración inicial.                              |
| `void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException` | El método principal para cada solicitud. Delega a `doGet`, `doPost`, etc. | No suele sobrescribirse directamente.               |
| `void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException` | Maneja solicitudes HTTP GET.                                        | Recuperación de datos, visualización de páginas.    |
| `void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException` | Maneja solicitudes HTTP POST.                                       | Envío de datos de formularios, creación de recursos. |
| `void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException`  | Maneja solicitudes HTTP PUT.                                        | Actualización completa de recursos.                 |
| `void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException` | Maneja solicitudes HTTP DELETE.                                     | Eliminación de recursos.                            |
| `void destroy()`                          | Se llama una vez, antes de la destrucción del servlet. Para liberar recursos. | Limpieza de recursos.                               |

---
## 5. CONFIGURACIÓN DE SERVLETS (ANOTACIONES Y `web.xml`) 🛠️

Desde Servlet API 3.0, la configuración de servlets se puede hacer con anotaciones,
reduciendo la necesidad del `web.xml`.

**a) Anotaciones (@WebServlet)**

| Atributo (de `@WebServlet`) | Descripción                                                          | Ejemplo de Uso                                     |
| :------------------------- | :------------------------------------------------------------------- | :------------------------------------------------- |
| `name` (opcional)          | Nombre lógico y único del servlet.                                   | `@WebServlet(name = "MiPrimerServlet")`          |
| `value` o `urlPatterns`    | **Obligatorio**. Uno o más patrones de URL a los que responde el servlet. | `@WebServlet("/hola")` o `@WebServlet(urlPatterns = {"/path1", "/path2"})` |
| `loadOnStartup`            | Entero que define el orden de inicialización. Si es `>=0`, el servlet se carga al inicio del servidor. | `@WebServlet(value = "/initServlet", loadOnStartup = 1)` |
| `initParams`               | Arreglo de `@WebInitParam` para parámetros de inicialización del servlet. | `@WebServlet(urlPatterns = "/params", initParams = {@WebInitParam(name="clave", value="valor")})` |
| `asyncSupported`           | `boolean`. Indica si el servlet soporta operación asíncrona.          | `@WebServlet(value = "/async", asyncSupported = true)` |
| `displayName`, `description`, `smallIcon`, `largeIcon` | Para metadatos de la aplicación web.                                | (Self-explanatory)                                 |

**Ejemplo de Servlet con Anotaciones:**

```java
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
    name = "saludoServlet",
    urlPatterns = {"/saludo"},
    loadOnStartup = 1,
    initParams = {
        @WebInitParam(name = "mensajeInicio", value = "Servlet de Saludo Iniciado!")
    }
)
public class SaludoServlet extends HttpServlet {

    private String mensajeInicial;

    @Override
    public void init() {
        mensajeInicial = getServletConfig().getInitParameter("mensajeInicio");
        System.out.println(mensajeInicial);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>¡Hola desde el SaludoServlet!</h1>");
        out.println("<p>Parámetro inicial: " + mensajeInicial + "</p>");
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
        System.out.println("SaludoServlet destruido.");
    }
}
```
**b) Descriptor de Despliegue (`web.xml`)**

Aunque opcional con anotaciones, `web.xml` (en `WEB-INF/`) sigue siendo útil para:

-   Configuraciones complejas o dinámicas.
-   Mapeos de error (`<error-page>`).
-   Mapeos de bienvenida (`<welcome-file-list>`).
-   Definir Listeners y Filtros (aunque también tienen anotaciones).

**Ejemplo Básico de `web.xml` para un Servlet:**
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="[http://xmlns.jcp.org/xml/ns/javaee](http://xmlns.jcp.org/xml/ns/javaee)"
         xmlns:xsi="[http://www.w3.org/2001/XMLSchema-instance](http://www.w3.org/2001/XMLSchema-instance)"
         xsi:schemaLocation="[http://xmlns.jcp.org/xml/ns/javaee](http://xmlns.jcp.org/xml/ns/javaee) [http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd](http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd)"
         version="4.0">

    <servlet>
        <servlet-name>MiServletXML</servlet-name>
        <servlet-class>com.example.MiServlet</servlet-class>
        <init-param>
            <param-name>parametroXML</param-name>
            <param-value>Valor desde XML</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>MiServletXML</servlet-name>
        <url-pattern>/xmlservlet</url-pattern>
    </servlet-mapping>

    <welcome-file-list>
        <welcome-file>index.html</welcome-file>
        <welcome-file>index.jsp</welcome-file>
    </welcome-file-list>

</web-app>
```

---
## 6.  FILTROS (FILTERS) EN SERVLETS 🛡️

Los filtros son componentes que pueden interceptar solicitudes antes de que lleguen
a un servlet o JSP, y respuestas antes de que sean enviadas al cliente. Son ideales
para tareas como:

-   **Logging**: Registrar todas las solicitudes (y respuestas) entrantes.
-   **Autenticación y Autorización**: Verificar si el usuario ha iniciado sesión o tiene permisos.
-   **Compresión/Encriptación**: Comprimir o encriptar datos de entrada/salida.
-   **Validación de Datos**: Validar los datos de la solicitud.
-   **Modificación de Encabezados**: Añadir o eliminar encabezados.
-   **Manejo de Codificación**: Establecer la codificación de caracteres.

**Métodos Clave de la Interfaz `Filter`:**

-   **`init(FilterConfig filterConfig)`**: Se llama una vez para inicializar el filtro.
-   **`doFilter(ServletRequest request, ServletResponse response, FilterChain chain)`**:
    El método principal para cada solicitud. Contiene la lógica del filtro.
    -   `chain.doFilter(request, response)`: Permite que la solicitud continúe por la cadena de filtros o al recurso de destino.
-   **`destroy()`**: Se llama una vez para liberar los recursos del filtro.

**Anotación `@WebFilter`:**

| Atributo (de `@WebFilter`) | Descripción                                                          |
| :------------------------- | :------------------------------------------------------------------- |
| `filterName`               | Nombre único del filtro.                                             |
| `value` o `urlPatterns`    | Patrones de URL a los que se aplica el filtro.                       |
| `servletNames`             | Nombres de servlets a los que se aplica el filtro (exclusivo con `urlPatterns`). |
| `dispatcherTypes`          | Tipos de `DispatcherType` para los que se invoca el filtro (REQUEST, FORWARD, INCLUDE, ERROR, ASYNC). |
| `initParams`               | Parámetros de inicialización como `@WebInitParam`.                 |

**Ejemplo de Filtro Básico:**
```java
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "logFilter", urlPatterns = "/*") // Aplica a todas las URL
public class LoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LoggingFilter inicializado.");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Lógica antes de que la solicitud llegue al servlet/JSP
        System.out.println("Solicitud interceptada por LoggingFilter para: " + request.getRemoteAddr());

        // Permite que la solicitud continúe a la siguiente cadena de filtros o al recurso objetivo
        chain.doFilter(request, response);

        // Lógica después de que la respuesta ha sido generada por el servlet/JSP
        System.out.println("Respuesta procesada por LoggingFilter.");
    }

    @Override
    public void destroy() {
        System.out.println("LoggingFilter destruido.");
    }
}
```

---
## 7 MANEJO DE SESIONES EN SERVLETS 🍪

Los Servlets pueden manejar sesiones para mantener el estado de un usuario a través
de múltiples solicitudes HTTP. Esto se logra a través del objeto `HttpSession`.

-   **Obtener la Sesión:**
    -   `HttpSession session = request.getSession();` (crea una nueva sesión si no existe)
    -   `HttpSession session = request.getSession(false);` (devuelve null si no existe)
-   **Almacenar Atributos:**
    -   `session.setAttribute("nombreUsuario", "Alice");`
-   **Recuperar Atributos:**
    -   `String usuario = (String) session.getAttribute("nombreUsuario");`
-   **Invalidar Sesión:**
    -   `session.invalidate();` (elimina la sesión y todos sus atributos)
-   **Tiempo de Inactividad:** Se puede configurar en `web.xml` (e.g., `<session-timeout>30</session-timeout>` para 30 minutos).


---
## 8. CHEATSHEET RÁPIDA DE SERVLETS ⚡

| Elemento            | Descripción Breve                                  | Notas Clave                                                      |
| :------------------ | :------------------------------------------------- | :--------------------------------------------------------------- |
| **Servlet** | Componente Java para procesar solicitudes HTTP.    | Base de apps web Java. Gestionado por contenedor (ej. Tomcat).   |
| **`HttpServlet`** | Clase abstracta para servlets HTTP.                | Métodos `doGet()`, `doPost()`, etc.                              |
| **`init()`** | Método de ciclo de vida. Se ejecuta **una vez** al inicio. | Inicialización de recursos.                                      |
| **`service()`** | Método de ciclo de vida. Se ejecuta por **cada solicitud**. | Delega al `doGet()`, `doPost()` apropiado.                       |
| **`destroy()`** | Método de ciclo de vida. Se ejecuta **una vez** al final.  | Liberación de recursos.                                          |
| **`doGet()`** | Maneja solicitudes HTTP GET.                       | Para recuperar/mostrar datos.                                    |
| **`doPost()`** | Maneja solicitudes HTTP POST.                      | Para enviar/procesar formularios.                                |
| **`HttpServletRequest`** | Objeto que representa la solicitud entrante.      | Acceso a parámetros (`getParameter`), encabezados, sesión.       |
| **`HttpServletResponse`** | Objeto para construir la respuesta saliente.       | `setContentType()`, `getWriter()`, `sendRedirect()`.             |
| **`@WebServlet`** | Anotación para mapear y configurar un Servlet.     | Atributos clave: `urlPatterns`, `name`, `loadOnStartup`.         |
| **`@WebFilter`** | Anotación para mapear y configurar un Filtro.      | Intercepta solicitudes/respuestas. Para logging, auth, etc.      |
| **`FilterChain`** | Parte del `doFilter()` en filtros.                 | `chain.doFilter()` pasa la solicitud al siguiente en la cadena.  |
| **`HttpSession`** | Objeto para mantener el estado de un usuario entre solicitudes. | Almacena atributos por usuario. `request.getSession()`.          |
| **`ServletContext`** | Proporciona acceso al contexto de la aplicación web. | Permite compartir información entre servlets de la misma app.    |
| **`web.xml`** | Descriptor de despliegue (opcional con anotaciones). | Configuración XML de servlets, filtros, listeners.               |

---
### METADATOS DEL DOCUMENTO 📄

| Campo           | Detalles                                           |
| :-------------- |:---------------------------------------------------|
| **Título** | GUÍA RÁPIDA DE SERVLETS EN JAVA (API DE SERVLET)   |
| **Autor(es)** | Saul Echeverri                                     |
| **Versión** | 1.0.0                                              |
| **Fecha de Creación** | 06 de Junio de 2025                                |
| **Última Actualización** | 06 de Junio de 2025                                |
| **Notas Adicionales**  | Documento base para referencia rápida de Servlets. |
