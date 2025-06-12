# 🚀 GUÍA RÁPIDA DE JSP Y JSTL: DESARROLLO WEB DECLARATIVO EN JAVA 🌐

Las JavaServer Pages (JSP) son una tecnología de Java para crear páginas web
dinámicas. Permiten incrustar código Java directamente en páginas HTML (o XML),
facilitando la separación entre la lógica de negocio y la presentación. JSTL
(JSP Standard Tag Library) es una colección de etiquetas estándar que
simplifican aún más el desarrollo en JSP al evitar el uso de scriptlets Java.


---
## 1. INTRODUCCIÓN A JSP Y SU RELEVANCIA 📚

-   **Definición de JSP**: Una JSP es una página HTML con fragmentos de código Java
    incrustados en ella. Permite a los desarrolladores web crear contenido
    dinámico de manera más fácil y visual que los Servlets puros.
-   **Funcionamiento**: Cuando el servidor web (contenedor de servlets/JSP como Tomcat)
    encuentra un archivo `.jsp`, lo compila en un Servlet Java clásico. Este Servlet
    es luego ejecutado para generar la respuesta HTML que se envía al cliente.
    Este proceso de compilación ocurre la primera vez que se solicita la JSP,
    o cuando la JSP se ha modificado.
-   **Ventajas**:
    -   **Separación de Responsabilidades (parcial)**: Aunque se puede mezclar lógica
        y presentación, JSP promueve una mayor separación que los Servlets puros.
    -   **Desarrollo Rápido**: Más fácil para diseñadores web trabajar con HTML y
        añadir lógica simple.
    -   **Reutilización**: Se pueden incluir otras JSP, usar JavaBeans, etc.
-   **Relación con Servlets**: Una JSP es, en esencia, un Servlet disfrazado. El
    contenedor JSP/Servlet convierte la JSP en un `.java` (Servlet) y luego lo
    compila a `.class`.


---
## 2. ESTRUCTURA BÁSICA DE UN ARCHIVO JSP 📄

Un archivo JSP combina HTML estático con elementos JSP que contienen lógica Java.
Los elementos clave son:

-   **Directivas (`<%@ ... %>`)**: Proporcionan instrucciones al contenedor JSP
    sobre cómo procesar la página. Se ejecutan en tiempo de compilación.
    -   `page`: Configuración global de la página (lenguaje, imports, manejo de errores).
    -   `include`: Incluye el contenido de otro archivo en tiempo de compilación.
    -   `taglib`: Declara el uso de una biblioteca de etiquetas.
-   **Scriptlets (`<% ... %>`)**: Bloques de código Java que se ejecutan cada vez
    que se procesa la página. **Su uso debe ser mínimo** (se prefiere JSTL o EL).
-   **Expresiones (`<%= ... %>`)**: Evalúan una expresión Java y su resultado
    se inserta directamente en la salida HTML. Equivalente a `out.print()`.
-   **Declaraciones (`<%! ... %>`)**: Declaran variables y métodos a nivel de clase
    dentro del Servlet compilado. No es recomendado para variables de instancia
    debido a problemas de concurrencia.
-   **Comentarios JSP (`<%-- ... --%>`)**: Comentarios que son ignorados por el
    contenedor JSP y no aparecen en el HTML generado.
-   **Elementos de Acción Estándar (`<jsp: ... >`)**: Proporcionan funcionalidades comunes.
    -   `<jsp:include>`: Incluye otra JSP/Servlet en tiempo de ejecución.
    -   `<jsp:forward>`: Redirige la solicitud a otra JSP/Servlet.
    -   `<jsp:useBean>`, `<jsp:setProperty>`, `<jsp:getProperty>`: Para trabajar con JavaBeans.
-   **Expression Language (EL) (`${ ... }`)**: Simplifica el acceso a datos
    de JavaBeans, objetos de alcance (scope) y colecciones.

**Ejemplo Básico de JSP:**

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mi Primera JSP</title>
</head>
<body>
    <h1>Hola desde JSP!</h1>

    <%-- Un comentario JSP, no se verá en la salida HTML --%>

    <%
        // Esto es un scriptlet Java
        String nombre = "Mundo";
        out.println("<p>La fecha actual es: " + new java.util.Date() + "</p>");
    %>

    <p>Saludos, <%= nombre %>!</p>

    <%-- Uso de Expression Language (EL) --%>
    <p>El valor de 'nombre' usando EL es: ${nombre}</p>

</body>
</html>
```

---
## 3. DIRECTIVAS DE JSP ⚙️

| Directiva   | Atributo           | Descripción                                                          | Ejemplo de Uso                                     |
| :---------- | :----------------- | :------------------------------------------------------------------- | :------------------------------------------------- |
| `page`      | `language`         | Lenguaje de scripting (generalmente `java`).                         | `<%@ page language="java" %>`                     |
|             | `contentType`      | Tipo MIME y codificación de la respuesta.                            | `<%@ page contentType="text/html; charset=UTF-8" %>` |
|             | `pageEncoding`     | Codificación de caracteres del archivo JSP.                          | `<%@ page pageEncoding="UTF-8" %>`                |
|             | `import`           | Importa clases Java. Múltiples clases separadas por coma.            | `<%@ page import="java.util.Date, java.io.*" %>`  |
|             | `errorPage`        | Ruta a la página de error para esta JSP.                             | `<%@ page errorPage="/error.jsp" %>`              |
|             | `isErrorPage`      | `true` si esta JSP es una página de error.                           | `<%@ page isErrorPage="true" %>`                  |
|             | `session`          | `true` para acceso implícito al objeto `session`, `false` para deshabilitar. | `<%@ page session="true" %>`                      |
|             | `isELIgnored`      | `true` para ignorar EL, `false` para habilitarlo.                    | `<%@ page isELIgnored="false" %>`                 |
| `include`   | `file`             | Ruta relativa del archivo a incluir en la compilación.             | `<%@ include file="header.jspf" %>`               |
| `taglib`    | `uri`              | URI que identifica la biblioteca de etiquetas.                       | `<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>` |
|             | `prefix`           | Prefijo a usar para las etiquetas de esta biblioteca.                | `(en el ejemplo anterior, c)`                      |


---
## 4. EXPLICIT OBJECTS / OBJETOS IMPLÍCITOS EN JSP 💡

El contenedor JSP proporciona automáticamente varios objetos a los que se puede
acceder directamente en los scriptlets y expresiones, sin necesidad de declararlos:

| Objeto Implícito | Tipo                  | Descripción                                                          | Alcance      |
| :--------------- | :-------------------- | :------------------------------------------------------------------- | :----------- |
| `request`        | `HttpServletRequest`  | Representa la solicitud HTTP entrante del cliente.                   | Request      |
| `response`       | `HttpServletResponse` | Permite construir la respuesta HTTP al cliente.                      | Page         |
| `out`            | `JspWriter`           | Flujo de salida para escribir contenido en la respuesta.             | Page         |
| `session`        | `HttpSession`         | Representa la sesión del usuario.                                    | Session      |
| `application`    | `ServletContext`      | Representa el contexto de la aplicación web.                         | Application  |
| `config`         | `ServletConfig`       | Objeto de configuración del servlet para la página JSP.              | Page         |
| `pageContext`    | `PageContext`         | Encapsula todos los objetos implícitos y proporciona acceso a los atributos en diferentes alcances. | Page         |
| `page`           | `Object`              | Representa la instancia del servlet generado por la JSP.             | Page         |
| `exception`      | `Throwable`           | Disponible solo en páginas de error (`isErrorPage="true"`). Contiene la excepción que causó el error. | Page (Error) |


---
## 5. JSTL (JSP STANDARD TAG LIBRARY) ✨

JSTL es una colección de etiquetas personalizadas para tareas comunes en JSP.
Su objetivo principal es eliminar el código Java (scriptlets) de las páginas JSP,
haciéndolas más limpias, legibles y fáciles de mantener.

**Categorías de JSTL**:

1.  **Etiquetas Core (`c:`)**: Para flujo de control, iteraciones, variables.
    -   URL: `http://java.sun.com/jsp/jstl/core` (para JSTL 1.0/1.1)
    -   URL: `http://xmlns.jcp.org/jsp/jstl/core` (para JSTL 1.2+)
2.  **Etiquetas de Formateo (`fmt:`)**: Para formateo de fechas, números, internacionalización.
3.  **Etiquetas SQL (`sql:`)**: Para acceso a bases de datos (no recomendado para aplicaciones de producción).
4.  **Etiquetas XML (`x:`)**: Para manipulación de documentos XML.
5.  **Etiquetas de Funciones (`fn:`)**: Colección de funciones de Expression Language para cadenas y colecciones.

**Etiquetas Core (`<c: >`) más populares en JSTL:**

| Etiqueta       | Descripción                                                          | Ejemplo de Uso                                     |
| :------------- | :------------------------------------------------------------------- | :------------------------------------------------- |
| `<c:out>`      | Imprime el valor de una expresión EL, con escape de HTML por defecto. | `<c:out value="${miVariable}" default="N/A"/>`   |
| `<c:set>`      | Almacena el resultado de una expresión en una variable (en un scope). | `<c:set var="usuario" value="Juan" scope="session"/>` |
| `<c:remove>`   | Elimina una variable de un scope especificado o de todos.            | `<c:remove var="usuario" scope="session"/>`       |
| `<c:catch>`    | Captura excepciones lanzadas dentro de su cuerpo.                    | `<c:catch var="ex">${10/0}</c:catch>`              |
| `<c:if>`       | Evalúa una condición. Similar a la declaración `if`.                 | `<c:if test="${saldo > 0}">Tienes fondos.</c:if>` |
| `<c:choose>`   | Contenedor para etiquetas `c:when` y `c:otherwise`. Similar a `switch`. | `<c:choose>`                                       |
| `<c:when>`     | Define una condición dentro de `c:choose`.                           | `<c:when test="${rol == 'admin'}">Admin</c:when>` |
| `<c:otherwise>`| Define el bloque por defecto si ninguna `c:when` coincide.           | `<c:otherwise>Usuario</c:otherwise>`               |
| `<c:forEach>`  | Itera sobre una colección o un rango de números.                     | `<c:forEach var="item" items="${lista}"> ${item} </c:forEach>` |
| `<c:forTokens>`| Itera sobre tokens de una cadena.                                    | `<c:forTokens items="a,b,c" delims="," var="token"> ${token} </c:forTokens>` |
| `<c:import>`   | Incluye contenido de otra URL (interna o externa).                   | `<c:import url="/WEB-INF/views/footer.jsp"/>`       |
| `<c:url>`      | Construye una URL con manejo de parámetros y reescritura de URL.     | `<c:url value="/pagina" var="link"><c:param name="id" value="1"/></c:url>` |
| `<c:redirect>` | Redirige el navegador a una nueva URL.                               | `<c:redirect url="/login.jsp"/>`                   |

**Ejemplo de Uso de JSTL Core:**

```java
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="[http://java.sun.com/jsp/jstl/core](http://java.sun.com/jsp/jstl/core)" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP con JSTL</title>
</head>
<body>
    <h1>Ejemplo de JSTL Core</h1>

    <c:set var="puntuacion" value="85" scope="request"/>
    <c:set var="usuarioActual" value="Ana" scope="session"/>
    <c:set var="esAdmin" value="true" />

    <p>Usuario: <c:out value="<span class="math-inline">\{usuarioActual\}"/\></p\>
<c\:if test\="</span>{puntuacion >= 90}">
<p>¡Excelente puntuación!</p>
</c:if>
<c:if test="<span class="math-inline">\{puntuacion < 90\}"\>
<p\>Buen esfuerzo, pero puedes mejorar\.</p\>
</c\:if\>
<h3\>Nivel de Acceso\:</h3\>
<c\:choose\>
<c\:when test\="</span>{esAdmin}">
<p>Acceso de Administrador</p>
</c:when>
<c:otherwise>
<p>Acceso de Usuario Estándar</p>
</c:otherwise>
</c:choose>

    <h3>Lista de Números:</h3>
    <ul>
        <c:forEach var="i" begin="1" end="5">
            <li>Número <c:out value="${i}"/></li>
        </c:forEach>
    </ul>

</body>
</html>
```

---
## 6. CHEATSHEET RÁPIDA DE JSP Y JSTL ⚡

| Elemento            | Descripción Breve                                  | Notas Clave                                                      |
| :------------------ | :------------------------------------------------- | :--------------------------------------------------------------- |
| **JSP** | Página HTML con código Java incrustado.            | Se compila a Servlet. Para contenido dinámico.                   |
| **Directiva** | `<%@ ... %>`                                       | Configuración global de la página (`page`, `include`, `taglib`). |
| **Scriptlet** | `<% ... %>`                                        | Bloque de código Java. Evitar su uso excesivo.                   |
| **Expresión** | `<%= ... %>`                                       | Evalúa e imprime una expresión Java.                             |
| **Declaración** | `<%! ... %>`                                       | Declara miembros de clase en el Servlet compilado.               |
| **Comentario JSP** | `<%-- ... --%>`                                    | No visible en la salida HTML.                                    |
| **EL (Expression Language)** | `${ ... }`                                   | Acceso simplificado a datos (beans, scopes).                     |
| **JSTL** | JSP Standard Tag Library                           | Conjunto de etiquetas estándar para evitar scriptlets.           |
| **`c:out`** | Etiqueta Core. Imprime valor con escape de HTML.   | `<c:out value="${var}"/>`                                        |
| **`c:set`** | Etiqueta Core. Define una variable en un alcance.  | `<c:set var="name" value="val" scope="scope"/>`                 |
| **`c:if`** | Etiqueta Core. Condicional `if`.                   | `<c:if test="${condicion}">...</c:if>`                           |
| **`c:choose`** | Etiqueta Core. Condicional `switch`.               | Contenedor para `c:when`, `c:otherwise`.                         |
| **`c:forEach`** | Etiqueta Core. Bucle de iteración.                 | Para colecciones o rangos numéricos.                             |
| **`c:import`** | Etiqueta Core. Incluye contenido de URL.           | Puede ser local o remota.                                        |
| **`fmt:` etiquetas**| JSTL Formateo.                                     | Para fechas, números, monedas.                                   |
| **`fn:` funciones** | JSTL Funciones.                                    | Funciones EL para cadenas (`fn:length`, `fn:contains`).          |
| **`request`** | Objeto Implícito. Solicitud HTTP.                  | Alcance: Request.                                                |
| **`response`** | Objeto Implícito. Respuesta HTTP.                  | Alcance: Page.                                                   |
| **`session`** | Objeto Implícito. Sesión del usuario.              | Alcance: Session.                                                |
| **`application`** | Objeto Implícito. Contexto de la aplicación.       | Alcance: Application.                                            |


---
### METADATOS DEL DOCUMENTO 📄

| Campo           | Detalles                                                      |
| :-------------- |:--------------------------------------------------------------|
| **Título** | GUÍA RÁPIDA DE JSP Y JSTL: DESARROLLO WEB DECLARATIVO EN JAVA |
| **Autor(es)** | Saul Echeverri                                                |
| **Versión** | 1.0.0                                                         |
| **Fecha de Creación** | 12 de Junio de 2025                                           |
| **Última Actualización** | 12 de Junio de 2025                                            |
| **Notas Adicionales**  | Documento base para referencia rápida de JSP y JSTL.          |
