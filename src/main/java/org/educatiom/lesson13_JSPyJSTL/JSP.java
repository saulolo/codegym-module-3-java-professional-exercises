package org.educatiom.lesson13_JSPyJSTL;

public class JSP {

    public static void main(String[] args) {

        System.out.println("--------------------- JSP ---------------------------");
        //Introducción a JSP
        /*Hay dos formas populares de escribir un servlet: imperativo y declarativo . Ya hemos tratado con el primero:
        este es, de hecho, un Servlet. El segundo se llama JSP (Java Server Pages), y ahora nos familiarizaremos con él.

        Ejemplo de servlet JSP:

        <html>
            <body>
                <% out.print(2*5); %>
            </body>
         </html>

         JSP es una página HTML con inserciones de código Java

         El servidor web, después de encontrar un archivo JSP, lo compila en un servlet clásico.
        */

        System.out.println("--------------------- Estructura Archivos JSP ---------------------------");
        //Directivas JSP
        /*Dado que descubrimos que el archivo JSP se convierte en un servlet normal, puede escribir código Java normal
        en él. Y en este código Java, puede usar varias clases (Math por ejemplo). ¡Esto es aún mejor! Pero
        podemos ver que tod el código se ha movido a un doGet()métod de servlet. Y esto plantea inmediatamente varias
        preguntas:
        - ¿Cómo hacer que el código se mueva al métod doPost()?
        - ¿Cómo agregar su propio código al métod init()?
        - ¿Cómo al final registrar las importaciones de clase?
        directivas JSP. Tod el código que no sea HTML dentro de un JSP debe encerrarse entre corchetes especiales <%y %>.
        Todas las directivas JSP están dadas por una plantilla:
        <%@ directive %>

        Atributo                Ejemplo                                             Descripción
        import          <%@ page import="java.util.Date" %>                 Importa una clase
        contentType     <%@ page contentType=text/html %>                   Establece el tipo de contenido
        extends         <%@ page extends="Object" %>                        Puedes establecer la clase base
        info            <%@ page info=”Автор: Пётр Иванович; версия:1.0” %> Define los datos para getServletInfo()
        buffer          <%@ page buffer="16kb" %>                           Establece el tamaño del búfer de respuesta
        language        <%@ page language=”java” %>                         Configura el lenguaje para la página, siendo Java el predeterminado
        isELIgnored     <%@ page isELIgnored="true" %>                      Permite desactivar las expresiones de EL (Expression Language)
        isThreadSafe    <%@ page isThreadSafe="false" %>                    Indica si la página JSP es segura para subprocesos (thread-safe)
        autoFlush       <%@ page autoFlush="false" %>                       Controla el almacenamiento en búfer de la respuesta
        session         <%@ page session="false" %>                         Es posible desactivar la sesión para una página
        pageEncoding    <%@ page pageEncoding="UTF-8"%>                     Puedes establecer la codificación de la página
        errorPage       <%@ page errorPage="errorpage.jsp" %>               Se puede configurar la página de error


        //Insertar scripts en JSP
        //Guiones <%
        ¿Qué se puede insertar en un archivo JSP?
        Primero, código Java. Si desea insertar código Java en su JSP, la plantilla proporciona el formato general:

         <%
            Java code
         %>A
          <%
           Beginning of Java Code
         %>
          HTML-code
        <%
           End of Java Code
         %>

         Ejemplo:
             <html>
            <body>
            <%
                double num = Math.random(); if (num > 0.95) {
             %>
                 <h2> You are lucky, user!</h2><p>(<%= num %>)</p>
            <%
             } else {
             %>
                 <h2> Today is not your day, user!</h2><p>(<%= num %>)</p>
            <%  } %> </body> </html>


          //Expresión <%=
            También puede insertar cualquier expresión calculada en el archivo JSP. Al mismo tiempo, el propio analizador
            JSP se asegurará de que no solo se calcule, sino que también se asigne cuando sea necesario. La expresión
            dentro del código viene dada por una plantilla:

            <%= expression %>
            Tenga en cuenta que el punto y coma no es necesario aquí.

            Ejemplo de servlet JSP con múltiples expresiones:

            <p>root of 10 equals <%= Math.sqrt(10) %></p>
            <h5><%= item[10] %></h5>
            <p>current time: <%=  new java.util.Date() %></p>

            ¡Importante! En tu código Java y expresiones, puedes utilizar variables predefinidas como
            request, response, session, out, etc.


            //Comentarios JSP vs HTML
            Otro punto importante son los comentarios en JSP. Siempre en el proceso de desarrollo, existe la necesidad
            de comentar algo o dejar un recuerdo para aquellos valientes que respaldarán nuestro código después de que
            entre en producción.
            para esto necesita usar "paréntesis" especiales:
            <%-- a comment --%>

            Tod el código dentro de dichos corchetes se ignorará al convertir JSP a Servlet.

            Por cierto, no confunda este código con un comentario HTML que, como recordatorio, tiene este aspecto:

            <!-- HTML comment _ -->

            El código HTML se comentará, pero el código Java dentro de dichos comentarios aún se ejecutará.

            //include
            Le permite insertar otro archivo en el lugar de la página donde se indica. El formato general de dicha directiva es:

            <%@ include file="url"%>
            Puede especificar no solo un archivo, sino, por ejemplo, otro jsp-servlet o incluso una URL.
            Puede, por ejemplo, colocar la parte superior de todas las páginas del sitio en header.jsp y la parte
            inferior en footer.jsp y recopilar todas las páginas como un constructor.

            //forward
            ¿Recuerdas que los servlets clásicos tienen la capacidad de redirigir o reenviar a otra URL? En JSP, esto
            también es posible y existe una acción especial para ello. Su apariencia es ligeramente diferente de lo que
            viste antes:
            <jsp:forward page="url"/>

            También hay una opción más avanzada, con parámetros:
            <jsp:forward page="url" >
                 <jsp:param name="Name" value="meaning"/>
                 <jsp:param name="Name" value="meaning"/>
                 <jsp:param name="Name" value="meaning"/>
            </jsp:forward>

            //redirectURL
            No hay una directiva especial para una redirección, pero se puede hacer llamando al código Java.
            Ejemplo:
            <body>
                 <%
                 String redirectURL = "https://codegym.cc/";
                 response.sendRedirect(redirectURL);
                 %>
            </body>
        */

        System.out.println("--------------------- JavaBeans ---------------------------");
        //¿Qué son los JavaBeans?
        /*Ya a finales de los 90, el lenguaje Java comenzó a usarse activamente para aplicaciones de servidores grandes,
        donde el número de clases se mide en decenas y cientos de miles. Fue entonces cuando surgió la idea de
        estandarizar el aspecto de los objetos de Java.

        No se tocó tod el lenguaje Java, para no privarlo de flexibilidad. Bueno, retrocompatibilidad y todo eso.
        Luego desarrollaron una serie de criterios para los objetos Java de nueva generación y los llamaron Java Beans.
        Java lleva el nombre de una popular marca de café, por lo que Java Beans se traduce literalmente como "granos de
        café".

        Los criterios más importantes fueron:
        - El acceso a los campos internos de la clase pasa por el getProperty().
        - La escritura de datos en campos de clase pasa por el setProperty(value).
        - La clase debe tener un constructor público sin parámetros .
        - La clase debe ser serializable.
        - La clase debe tener anulados los métodos equals(), hashCode()y toString().

        Este enfoque hizo que las aplicaciones fueran menos coherentes. Siempre claro:

        - cómo crear un objeto: hay un constructor público predeterminado;
        - cómo obtener/establecer el valor de la propiedad;
        - cómo transferir/guardar un objeto (usamos serialización);
        - cómo comparar objetos (usando equals() y hashCode());
        - cómo mostrar información sobre el objeto en el registro (use toString).

        Ahora es en realidad el estándar de la industria, pero alguna vez fue una nueva tendencia. Parece que ya tod el
        mundo escribe así.

        Dichos objetos son ampliamente utilizados donde su principal carga semántica es el almacenamiento de datos.
        Por ejemplo, en GUI, bases de datos y páginas JSP.

        //JSP y JavaBeans
        Una de las razones del JSP fue que podría subcontratarse a desarrolladores front-end. ¿Y qué? Tiene una persona
        que entiende HTML, déjelo escribir JSP. Los programadores de Java escriben su parte, los desarrolladores front-end escriben la suya, todo está bien.

        Y tod estuvo bien hasta que los desarrolladores front-end tuvieron que entender el código Java escrito incrustado
        en el JSP. O, peor aún, escriba dicho código usted mismo.

        Los programadores de Java tampoco estaban contentos con esto ya que tod el paradigma de la programación dice que
        mezclar diferentes lenguajes en un solo archivo es una mala forma.

        Entonces surgió la idea que dicen de darle a los desarrolladores front-end la oportunidad de trabajar con
        objetos Java, como con código HTML. Cada etiqueta HTML es también un objeto con sus propios campos, ¿por qué no
        trabajar con objetos Java de forma similar?

        Dicho y hecho. Se agregaron etiquetas especiales y listo.

        Creación de objetos:
        <jsp:useBean id="Name" class="Object type" scope="session"/>
        Este comando creó un objeto con el tipo objecty lo puso sessionbajo el nombre Name.

        */

    }
}
