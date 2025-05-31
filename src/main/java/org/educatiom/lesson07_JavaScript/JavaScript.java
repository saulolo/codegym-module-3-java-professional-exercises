package org.educatiom.lesson07_JavaScript;


public class JavaScript {

    public static void main(String[] args) {

        System.out.println("--------------------- JavaScript ---------------------------");
        //l atributo de estilo de una etiqueta
        /*Se escribio en apenas unos meses. Y el objetivo principal de este lenguaje era agregar animación primitiva a
        las páginas HTML.
        Es el único idioma que se ejecuta dentro del navegador.
        Lo primero que debe saber sobre JavaScript es que no tiene nada que ver con Java. Sí, su sintaxis es similar en
        algunos lugares, pero esto es simplemente una consecuencia del hecho de que a principios de los 90 el lenguaje
        de programación más popular era C ++ y ambos lenguajes lo tomaron como base.
        JavaScript originalmente se llamaba LiveScript, un lenguaje de secuencias de comandos para animar páginas.
        Pero debido al rápido crecimiento de la popularidad de Java a finales de los 90, pasó a llamarse JavaScript.
        JavaScript es un lenguaje de scripting, está diseñado para escribir pequeños scripts dentro de páginas HTML .
        Carece de tipos de variables, clases, ámbitos, colecciones estándar. Sin estándares.

        Para reducir de alguna manera el desorden en sus proyectos, los desarrolladores front-end escriben
        constantemente nuevos marcos que simplifican sus vidas. Y, por supuesto, estos marcos se vuelven obsoletos
        literalmente en 3-5 años. Si hace 5 años decidiste escribir tu proyecto en un marco ultramoderno, ¡hoy dirán
        que es tan antiguo como los mamuts

        Pero hay buenas noticias: se ha inventado un nuevo lenguaje para reemplazar JavaScript: se trata de TypeScript .
        Es muy bueno, tiene digitación, clases, alcances. Y además, hay un compilador especial que puede compilar
        TypeScript a JavaScript.

        Todos los principales proyectos frontend usan TypeScript en lugar de JavaScript . Además, muchos marcos frontend
        modernos usan TypeScript en lugar de JavaScript. Por ejemplo, Angular, en el que está escrito el front-end de CodeGym.
        */

        System.out.println("--------------------- Conceptos básicos en JavaScript ---------------------------");
        //Variables:
        /*JavaScript tiene variables, pero esas variables no tienen un tipo. A cualquier variable se le puede asignar
        absolutamente cualquier valor. Parece inocuo o incluso práctico hasta que necesite los tipos.

        La palabra clave se utiliza para declarar una variable var
        var name;
        var name = value;

        */

        System.out.println("--------------------- Escribir en JavaScript ---------------------------");
        /*
        Como se mencionó anteriormente, las variables en el lenguaje JavaScript no tienen tipo.
        Pero los valores de las variables tienen tipos. Estos son los 5 tipos más comunes en JavaScript:



        La palabra clave typeof se utiliza para determinar el tipo de un objeto, por ejemplo:

        var s = "134";
        var x = (typeof s == "String") ? s*1 : s;

        */

        System.out.println("--------------------- Funciones y retornos ---------------------------");
        /*No hay clases, por lo que las funciones se pueden declarar en cualquier parte del código. Incluso en otras
        funciones. El formato general es:
        function name(a, b, c) {
          // function code
           return result;
        }
        Al llamar a una función, puede pasar cualquier número de parámetros de cualquier tipo . El exceso se desechará,
        los faltantes serán iguales null.

        */

        System.out.println("--------------------- Arreglos en JavaScript ---------------------------");
        /*Los arreglos en JavaScript son muy similares a los arreglos en Java. Ejemplos:
        var array = [1, 2, 3, 4, 5];
        array[3] = array[2];
        console.log (array[0]);

        Pueden tener valores de cualquier tipo, incluso otros arreglos
        Además, las matrices también se comportan como colecciones: puede agregarles elementos dinámicamente:
        var array = [];
        array.push(100);
        array.push(101);
        array.push(102);

        array[1] = array[2];
        console.log (array[0]);
         */

        System.out.println("--------------------- Objetos JavaScript ---------------------------");
        /*Los objetos en JavaScript son muy similares a HashMap en Java: contienen pares clave-valor. Ejemplo:
        var obj = {
         name: "Bill Gates",
         age: 67,
         company: "Microsoft"
        };

        console.log (obj.age);

        Al igual que con HashMap, los campos se pueden crear y eliminar.

         */
        System.out.println("--------------------- Operadores en JavaScript ---------------------------");
        //Sentencias if-else
        /*El operador más común en JavaScript, al igual que en Java, es if-else. Funciona exactamente igual.
        if-elsepuede estar anidado y elsepuede faltar el bloque. Tod es igual que en Java.
         */

        //Bucles for, while, for in
        /*El bucle for en JavaScript funciona de la misma manera que en Java, también tiene los operadores break y
        continue
        También hay ciclos whiley do.while. Funcionan exactamente igual que en Java y C++.
        De lo interesante: hay un análogo del ciclo for each, llamado for in. Esto es lo que parece:
        var obj = {a: 1, b: 2, c: 3};
         for (var key in obj)
             console.log( obj[key] );

        A diferencia del lenguaje Java, aquí la variable keytoma secuencialmente los valores de las claves del objeto obj.
        Para obtener un valor por clave, debe escribirobj[key];

        //Excepciones
        avaScript admite el trabajo con excepciones, pero dado que no hay escritura normal, todas las excepciones tienen
        exactamente un tipo: Error.
        Para trabajar con excepciones, existe un operador try-catch-finallyque funciona de manera similar al operador de Java.

        */

        System.out.println("--------------------- Interacción del código JavaScript con el navegador ---------------------------");
        //Objetos del navegador
        /*Como ya sabes, el lenguaje JavaScript funciona dentro del navegador, por lo que de alguna manera necesita
        interactuar con este mismo navegador. Para ello, el navegador dispone de varios objetos y funciones que están
        disponibles desde JavaScript.

        El primero es an object window, que describe la ventana del navegador.
        describe la pestaña actual del navegador en la que se carga la página con el script.

        En segundo lugar, este es an object documentel responsable del documento que se muestra en la pestaña.

        En tercer lugar, este es an object consoleel responsable de la salida a la consola del navegador. se abre cn F12

        */

        System.out.println("--------------------- Diálogos en JavaScript ---------------------------");
        //alert()
        /*Le permite mostrar un cuadro de diálogo con un mensaje para el usuario.*/

        //prompt()
        /* función con la que puede pedirle al usuario que ingrese algún valor.*/

        //confirm
        /*Puede mostrar un cuadro de diálogo con dos botones Ok: Cancelpregunte al usuario sobre alguna acción.*/

        //onload
        /*La ventana del navegador tiene un evento que se activa cuando el documento está completamente cargado*/

        //onclick
        /* Lo cual ocurre en cualquier elemento en el que el usuario hizo clic.*/

        System.out.println("--------------------- Trabajar con el model objeto document (DOM) ---------------------------");
        //document.getElementById()
        /*Para cambiar el color de un elemento, primero debe encontrar este elemento. Para hacer esto, hay una función.
        Después de que el usuario hace clic en la imagen, se llama a la función changeImge(). Dentro de él, obtenemos
        el elemento imagepor su ID, y luego cambiamos el valor de su atributo src a uno nuevo. Lo que hará que el
        elemento imgcargue una nueva imagen.

        //documento.createElement()
        también podemos crear nuevos elementos y eliminar los existentes.

        //window.navigate()
        Con él, puede obligar al navegador a cargar una nueva página en lugar de la actual. Simplemente páselo URLa este
        méthod y llámelo

        //currentURL
        A veces, un script necesita saber la URL de la página actual. Por ejemplo, el mismo script se puede agregar a
        diferentes páginas. ¿Cómo hacerlo?
        Hay una propiedad especial para esto.document.location.href
        */

        System.out.println("--------------------- Trabajar con el model objeto document (DOM) ---------------------------");
        //Diferentes formas de declarar funciones
        /*- La forma más estándar es esta: palabra clave function y Name.
         function print(data)
           {
             console.log(data);
           }

         - La segunda forma es declarar primero una variable y luego asignarle una función anónima.
         window.print = function(data)
         {
             console.log(data);
         }

         //Funciones anónimas
         ¿Por qué se necesita tal función? ¿Cómo llamarla?
         Y la cosa es que puedes llamarlo inmediatamente. Digamos que declaramos una función tempe inmediatamente
         la llamamos:
         var temp = function(data)
            {
                console.log(data);
            }

        temp("some info");

        También puede declararlo e inmediatamente llamarlo:
         (function(data)
            {
                console.log(data);
            })("some info");

          //eval()
          En JavaScript, simplemente puede ejecutar el código dado como una cadena. Hay una función especial para esto
          eval()(de evaluación). El formato de llamada general se ve así:
          var result = eval("code or expression");


        */
    }
}
