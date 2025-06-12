package org.educatiom.lesson13_JSPyJSTL;

public class JSTL {

    public static void main(String[] args) {

        System.out.println("--------------------- TagLib ---------------------------");
        /*A todos les gustó el código que utiliza etiquetas en lugar de código Java, por lo que decidieron ampliar el
        alcance. Pero la programación no se limita a crear objetos y leer sus propiedades. Debe llamar a métodos de
        objetos, trabajar con la base de datos y otros servicios.

        Los programadores permitieron agregar cualquier etiqueta al código. En principio, no hay nada de qué preocuparse:
        JSP es un estándar extensible. Pero fueron más allá y lanzaron JSP Standard Tag Library - JSTL.

        Ejemplo:
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

        //Funciones JSTL
        Las funciones JSTL se dividen en 5 categorías:

        - Etiquetas principales;
        - Etiquetas de formato;
        - Etiquetas SQL;
        - Etiquetas XML;
        - Funciones de llamada.

        Etiquetas    principales:
        Etiqueta                        Descripción
        <c:out>	        Muestra la expresión especificada, equivalente a <%= %>
        <c:set>	        Escribe el resultado de una expresión en una variable.
        <c:remove>	    Elimina una variable
        <c:catch>	    Atrapa excepciones
        <c:if>	        Análogo de si
        <c:choose>	    Interruptor analógico
        <c:when>	    Se usa junto con elegir
        <c:otherwise>	Se usa junto con elegir
        <c:import>	    Le permite incluir contenido en el código (equivalente a la directiva de importación)
        <c:forEach>	    Para cada bucle
        <c:param>	    Le permite establecer opciones para importar
        <c:redirect>	redirigir
        <c:url>	        Crea una URL con parámetros

        Piénselo, escribimos código Java en forma de etiquetas, de modo que el analizador JSP luego convierta estas
        etiquetas en código Java. Algo en este mundo ha ido mal.

        Por cierto, puede escribir sus propias bibliotecas de etiquetas. Incluso una vez trabajé en un proyecto donde
        estaban ellos. Impresionante experiencia. Tan pronto como se realizan cambios en la biblioteca, todo el jsp se
        rompe inmediatamente.

        ¿Qué deseas? El compilador no realiza un seguimiento de dichos cambios. Solo se pueden encontrar visualmente al
        ver las páginas HTML generadas. Y si estos son algunos escenarios raros que surgen en situaciones no triviales

        */


    }
}
