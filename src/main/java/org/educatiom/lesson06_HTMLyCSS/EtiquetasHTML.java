package org.educatiom.lesson06_HTMLyCSS;


public class EtiquetasHTML {

    public static void main(String[] args) {

        System.out.println("--------------------- Etiquetas HTML ---------------------------");
        //Introducción a las etiquetas
        /*HTML-documentsEl marcado se basa en etiquetas .
        Las etiquetas se inventaron en los años 70 para que las personas pudieran agregar información de servicio a los
        documentos para los programas que procesan estos documentos.
        */

        System.out.println("--------------------- Tag ---------------------------");
        /*esta es una palabra clave (funcional), la mayoría de las veces en inglés, que se enmarcó entre paréntesis
        angulares (más y menos caracteres) para que los programas no confundan etiquetas y palabras comunes en inglés

        <a href="http://codegym.cc/about">
            Link to something interesting
        </a>

        */

        System.out.println("--------------------- Tipos de etiquetas ---------------------------");
        /*Las etiquetas son de diferentes tipos. En primer lugar, son individuales y dobles. Las más comunes son las
        etiquetas emparejadas . Y como probablemente ya hayas adivinado, siempre van en parejas. También se les llama
        apertura y cierre.

        La etiqueta de apertura es solo una palabra clave entre corchetes triangulares. Ejemplo:
        <h1>

        La etiqueta de cierre es similar a la etiqueta de apertura, pero la palabra clave está precedida por una barra
        inclinada. Ejemplo:
        </h1>

        Las etiquetas individuales no tienen una etiqueta de cierre. La lista de dichas etiquetas está definida por
        HTML-standard. Ejemplos de tales etiquetas:

        <br>- salto de línea;
        <img>- imagen.

        Por cierto, una etiqueta emparejada, si no contiene información dentro, se puede escribir en forma abreviada .
        Ejemplo:
        Etiqueta de par vacía
        <h1/>

        */

        System.out.println("--------------------- Árbol de etiquetas ---------------------------");
        /*cualquier texto dentro HTML-documentse puede enmarcar (envolver) con etiquetas, incluso si contiene otras etiquetas.
        <html>
            plain text
         <a href="http://codegym.cc/about">
                    Link to something interesting
         </a>
             some other text
        </html>



        */

        System.out.println("--------------------- Atributos ---------------------------");
        /* Estos atributos contienen información útil sobre el contenido de la etiqueta.
        Ejempplo:
        <tag name1="value1" name2="value2">
        Cada atributo se especifica como un par de Namey meaning. Puede haber cualquier número de atributos.

         ¿qué hacer si necesita usar texto que contiene caracteres o «>»comillas como valor de atributo ?

            Nombre del símbolo	        Símbolo
            comillas dobles	                "
            Y comercial	                    &
            Menor que       	            <
            Mayor que	                    >
            Espacio
            una frase	                    '

        */


        System.out.println("--------------------- Etiquetas HTML ---------------------------");
        /*¿Cuál es el comienzo de cualquier documento HTML? Cada documento HTML tiene una estructura que consta de tres
        etiquetas anidadas: html, heady body. Este es el ejemplo estándar:

        <!DOCTYPE html>
        <html>
         <head>
                Service tags
         </head>
         <body>
                Main document
         </body>
        </html>
        Tod lo que muestra el navegador está dentro de una etiqueta de par body(cuerpo del documento).
         Dentro de la etiqueta headhay etiquetas con información de servicio/auxiliar para el navegador.

         También es habitual (opcional) escribir el tipo de documento al principio del documento, DOCTYPEpara que el
         analizador comprenda mejor cómo interpretar los errores. Muchos navegadores pueden mostrar correctamente
         documentos rotos.

         O, por el contrario XHTML = XML+HTML, existe una norma en la que existen reglas más estrictas que en la habitual
         HTML. Pero dicha información le será útil cuando decida escribir su propio navegador, o al menos el suyo propio
         HTML-parser.

        */

        System.out.println("--------------------- head ---------------------------");
        /*Dentro de la etiqueta headse suelen ubicar las siguientes etiquetas: title, meta, style, ...
        La etiqueta <title> especifica el nombre del documento que se muestra en la pestaña del navegador.
        La etiqueta <meta>se utiliza para configurar información de varios servicios. Por ejemplo, puede ayudar al
        navegador a comprender la codificación de un documento HTML

         */

        System.out.println("--------------------- Etiquetas cuerpo, p, b ---------------------------");
        /*La etiqueta <body>contiene tod el texto html que mostrará el navegador. Las etiquetas más sencillas
        para mostrar un documento son: <h1>, <p>, <b>,<br>

        //<h1>
        <h1>- esta es una etiqueta de par, le permite establecer el título de su página / artículo. Si su artículo es
        largo y necesita subtítulos, entonces puede usar la etiqueta para este caso <h2>, <h3>y así sucesivamente hasta<h6>

        //<p>
         Simplemente envuelva el texto en etiquetas <p>y </p>el navegador lo mostrará como un párrafo separado.

         //<br>
         El navegador ignorará los saltos de línea y/o los espacios adicionales en su texto. Si desea agregar un salto
         de línea, inserte una sola etiqueta <br>(desde la línea de salto ) en el texto.

         //<b>
          Si desea poner el texto en negrita, envuélvalo en etiquetas <b> </b>
         */

        System.out.println("--------------------- Etiquetas <a>, href ---------------------------");
        /*Para crear enlaces en HTML, <a>se utiliza una etiqueta (de ancla, ancla).
          Ej:
          <a href="link-address">link text</a>

          */

        System.out.println("--------------------- Etiqueta <img> y atributo src ---------------------------");
        /* <img>Para insertar una imagen en una página HTML
        <img src="image link">
         */

        System.out.println("--------------------- Etiqueta <table> ---------------------------");
        /* Para agregar tabla de datos:
        una tabla tiene un encabezado, filas, columnas y celdas. A todos se les ocurrió sus propias etiquetas:

        <table> - la tabla en sí;
        <tr> (fila de tabla) – tabla de fila;
        <th> (encabezado de la tabla h) – celda del encabezado de la tabla;
        <td> (datos de la tabla) – celda de la tabla.

        Así es como se vería una tabla de 3 por 3 html(con una fila de encabezado adicional)
        <table>
         <tr> <th>Surname</th> <th>Name</th> <th>Surname</th> </tr>
         <tr> <td>Ivanov</td> <td>Ivan</td> <td>Ivanovich</td> </tr>
         <tr> <td>Petrov</td> <td>Peter</td> <td>Peterovich</td> </tr>
         <tr> <td>Sidorov</td> <td>Kolia</td> <td>Sidorenko</td> </tr>
        </table>

        */

        System.out.println("--------------------- Atributos de id y name ---------------------------");
        /*El atributo idde etiqueta le permite darle un nombre que es único dentro de todo el documento . Esto es útil
        si hay algo de JavaScript en el documento HTML que cambia el valor o los parámetros de la etiqueta dada. Luego,
        con la ayuda de Unique, idpuede referirse con precisión a la etiqueta deseada.

        Un atributo namerealiza una función similar, pero su valor no necesita ser único dentro de la página. Es decir,
        en teoría, puede haber varias etiquetas con los mismos nombres. Esto se hace para facilitar el trabajo con grupos
        de elementos.

        Cualquier etiqueta puede tener atributos idy name. Ejemplo:
        <img id="image123" name="avatar" src="link to picture">

        */

    }
}
