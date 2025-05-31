package org.educatiom.lesson06_HTMLyCSS;


public class CSS {

    public static void main(String[] args) {

        System.out.println("--------------------- CSS ---------------------------");
        //El atributo de estilo de una etiqueta
        /*A medida que la web comenzó a ganar popularidad, hubo una creciente demanda de páginas web con un diseño
        hermoso o muy hermoso. Este problema se resolvió utilizando el style .

        La forma general de este atributo tiene el siguiente formato:
        <tag style="name=value;name2=value2;nameN=valueN">

        */

        System.out.println("--------------------- Estilos CSS populares ---------------------------");
        /*A continuación se muestran los 10 más comunes para los desarrolladores de back-end:

        +----+-------------------+--------------------+---------------------------------------------------------------+
        | #  | Propiedad CSS     | Ejemplo            | Descripción                                                   |
        +----+-------------------+--------------------+---------------------------------------------------------------+
        | 1  | width             | width: 100px;      | Ancho del elemento en píxeles.                                |
        +----+-------------------+--------------------+---------------------------------------------------------------+
        | 2  | height            | height: 50%;       | Altura del elemento como porcentaje (del ancho del padre).    |
        +----+-------------------+--------------------+---------------------------------------------------------------+
        | 3  | display           | display: none;     | Controla cómo se muestra un elemento (no mostrar elemento).   |
        +----+-------------------+--------------------+---------------------------------------------------------------+
        | 4  | visibility        | visibility: hidden;| Visibilidad del elemento (el elemento está oculto, pero el   |
        |    |                   |                    | espacio está reservado para él).                              |
        +----+-------------------+--------------------+---------------------------------------------------------------+
        | 5  | color             | color: red;        | Color de texto.                                               |
        +----+-------------------+--------------------+---------------------------------------------------------------+
        | 6  | background-color  | background-color:  | Color de fondo.                                               |
        |    |                   | #eee;              |                                                               |
        +----+-------------------+--------------------+---------------------------------------------------------------+
        | 7  | border            | border: 1px solid  | Borde (ancho 1px, color negro, línea continua).               |
        |    |                   | black;             |                                                               |
        +----+-------------------+--------------------+---------------------------------------------------------------+
        | 8  | font              | font: verdana      | Fuente: verdana, tamaño 10pt.                                 |
        |    |                   | 10pt;              |                                                               |
        +----+-------------------+--------------------+---------------------------------------------------------------+
        | 9  | text-align        | text-align: center;| Alineación de texto horizontalmente.                          |
        +----+-------------------+--------------------+---------------------------------------------------------------+
        | 10 | margin            | margin: 2px;       | Relleno *fuera* del elemento.                                 |
        +----+-------------------+--------------------+---------------------------------------------------------------+

         */

        System.out.println("--------------------- Atributo de clase ---------------------------");
        //El atributo de clase y la etiqueta de estilo
        /*Después de que se inventaron cientos de "estilos", surgió la pregunta: ¿cómo usarlos? Y luego se les ocurrió
        la idea de agruparlos en “clases”. Estas, por supuesto, no son las mismas clases que en Java. Solo grupos de
        estilos especiales.

        antes de usar clases:
        <img src="logo.png" style="width=100px;height=100px;opacity=0.5">

        Ahora podría escribirse como usando clases:
        <img src="logo.png" class="picture">
        <style>
            img.picture {
         width=100px;
         height=100px;
         opacity=0.5
            }
        </style>

        //Selector, tipos de selectores
        Estos estilos, representados por separado, se conocieron como classeso selectors. Tienen varias características
        importantes.
        Uno html-elementpuede tener múltiples selectores. Sus nombres se indican con un espacio. Ejemplo:
        <img src="logo.png" class="picture main">

        Aquí hay una breve lista de ellos:
        +----+---------------------+-------------------------------+-------------------------------------------------------------------------------------------------+
        | #  | Selector            | Ejemplo                       | Descripción                                                                                     |
        +----+---------------------+-------------------------------+-------------------------------------------------------------------------------------------------+
        | 1  | Universal Selector  | * {                           | Se aplica a todos los elementos de un documento HTML.                                           |
        |    |                     |   margin: 0;                  |                                                                                                 |
        |    |                     |   padding: 0;                 |                                                                                                 |
        |    |                     | }                             |                                                                                                 |
        +----+---------------------+-------------------------------+-------------------------------------------------------------------------------------------------+
        | 2  | ID Selector         | #img123 {                     |  El `#` va seguido del ID del elemento al que se va a aplicar el estilo dado.                   |
        |    |                     |   width:100px;                |                                                                                                 |
        |    |                     |   height:100px;               |                                                                                                 |
        |    |                     | }                             |                                                                                                 |
        +----+---------------------+-------------------------------+-------------------------------------------------------------------------------------------------+
        | 3  | Tag Selector        | table {                       | Se aplica a todas las tablas del documento.                                                     |
        |    |                     |   color: black;               |                                                                                                 |
        |    |                     | }                             |                                                                                                 |
        +----+---------------------+-------------------------------+-------------------------------------------------------------------------------------------------+
        | 4  | Tag.Class Selector  | table.important {             | Se aplica a todas las tablas de documentos que tienen el atributo de clase especificado.        |
        |    |                     |   color: red;                 |                                                                                                 |
        |    |                     | }                             |                                                                                                 |
        +----+---------------------+-------------------------------+-------------------------------------------------------------------------------------------------+
        | 5  | Class Selector      | .picture {                    |Se aplica a todos los elementos que tienen el atributo de clase especificado. Cualquier etiqueta.|
        |    |                     |   opacity: 0.5;               |                                                                                                 |
        |    |                     | }                             |                                                                                                 |
        +----+---------------------+-------------------------------+-------------------------------------------------------------------------------------------------+
        | 6  | Descendant Selector | main article {                |   Se aplica a todos los elementos `<article>` que son descendientes de un elemento `<main>`.    |
        |    | (Parent Child)      |   color: blue;                |                                                                                                 |
        |    |                     | }                             |                                                                                                 |
        +----+---------------------+-------------------------------+-------------------------------------------------------------------------------------------------+
        | 7  | Pseudoclass :link   | a:link {                      |La pseudoclase `:link` se utiliza para diseñar enlaces en los que el usuario aún no ha .         |
        |    |                     |   color: blue;                |hecho clic                                                                                       |                                                                   |
        |    |                     | }                             |                                                                                                 |
        +----+---------------------+-------------------------------+-------------------------------------------------------------------------------------------------+
        | 8  | Pseudoclass :visited| a:visited {                   |La pseudoclase `:visited` se utiliza para diseñar enlaces en los que el usuario ya ha hecho clic.|
        |    |                     |   color: red;                 |                                                                                                 |
        |    |                     | }                             |                                                                                                 |
        +----+---------------------+-------------------------------+-------------------------------------------------------------------------------------------------+
        | 9  | Pseudoclass :checked| input[type=radio]:checked {   | Esta pseudoclase seleccionará solo los elementos de la interfaz de usuario marcados: botones    |
        |    |                     |   border: 1px solid black;    | de radio o casillas de verificación.                                                            |
        |    |                     | }                             |                                                                                                 |
        +----+---------------------+-------------------------------+-------------------------------------------------------------------------------------------------+
        | 10 | Pseudoclass :hover  | div:hover {                   | Esta pseudoclase le permite cambiar el estilo de un elemento al pasar el mouse sobre él.        |
        |    |                     |   background: red;            |                                                                                                 |
        |    |                     | }                             |                                                                                                 |
        +----+---------------------+-------------------------------+-------------------------------------------------------------------------------------------------+
        | 11 | Pseudoclass         | ul li:first-child {           | Esta pseudoclase solo permitirá seleccionar el primer elemento secundario.                      |
        |    | :first-child        |   border-top: none;           |                                                                                                 |
        |    |                     | }                             |                                                                                                 |
        +----+---------------------+-------------------------------+-------------------------------------------------------------------------------------------------+

        */

    }
}
