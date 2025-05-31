package org.educatiom.lesson07_JavaScript;


public class JQuery {

    public static void main(String[] args) {

        System.out.println("--------------------- jQuery ---------------------------");
        //Conectando jQuery
        /*En el momento de escribir este artículo, ya está obsoleto y casi nunca se utiliza en nuevos proyectos.
        Pero en un momento fue muy popular, muy bien documentado, y hay muchos ejemplos en Internet con su uso.
        Para utilizar las miles de funciones de jQuery, solo necesita incluirlo en su página. Puedes hacerlo así:
        <head>
         <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        </head>

        Trabajar con jQuery se puede dividir en dos tipos.
        Primero, puede obtener un objeto de biblioteca jQuery, que es un elemento HTML regular envuelto en un objeto
        jQuery personalizado.
        En segundo lugar, jQuery tiene varios objetos globales que no están vinculados a elementos HTML. También
        necesitan ser utilizados.
        Comencemos con el primero.

        //Trabajar con selectores
        En jQuery, si desea seleccionar algún objeto o grupo de objetos, debe configurar su selector

        	Código	                        Descripción	                                                            Nota
        1	$("div")	        Selecciona todos los objetos con una etiqueta DIV	                            muchos objetos
        2	$("img.#imagen123")	Selecciona todos los objetos con etiqueta IMG e ID == image123	                un objeto
        3	$("#imagen123")	        Selecciona todos los objetos con ID == image123	                            un objeto
        4	$("div.articulo")	Selecciona todos los objetos con una etiqueta DIV que tienen artículo de clase	muchos objetos


        Otra cosa buena de jQuery es que su código es fácil de leer. No hace falta mucho para darse cuenta de cómo
        funciona tod.
        Si hay un código que funciona, entonces es bastante fácil entender lo que hace.

        //Trabajar con elementos de document
        Tambien se puede utilizar jQuery en document.

        */

        System.out.println("--------------------- Redes en jQuery ---------------------------");
        //objeto y métod ajax en jQuery
        /*jQuery también tiene un objeto global especial para trabajar con la red. Como puedes adivinar, se llama $ajax.
        Sí, ese es el nombre. Pero es simple y conveniente.
        Supongamos que desea enviar una solicitud a una API en su JavaScript y procesar la respuesta recibida.
        $.ajax({
          type: "POST",
          url: "api.codegym.cc",
          data: {name: 'Bill', location: 'Radmond'},
          success: function(msg){ alert( "Person found: " + msg ); }
        });
        - El campo type especifica el tipo de solicitud HTTP: GEToPOST
        - El campo url especifica urla quién se enviará la solicitud.
        - El campo data especifica los datos de la solicitud en formato JSON
        - El campo de succes especifica una función que se llamará después de una respuesta exitosa del servidor.

        */

    }
}
