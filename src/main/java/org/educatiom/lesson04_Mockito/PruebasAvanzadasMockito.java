package org.educatiom.lesson04_Mockito;

public class PruebasAvanzadasMockito {

    public static void main(String[] args) {

        System.out.println("--------------------- Pruebas avanzadas con Mockito ---------------------------");
        //Biblioteca Mockito
        /*Primero, esta biblioteca es un estándar en las pruebas de Spring . Que es en realidad el estándar en la
        industria de desarrollo de back-end de Java.
        En segundo lugar, deberá escribir pruebas para su código Spring . La única forma de entender que el backend que
        escribió funciona como debería es llamar a los métodos de su API . Y hacerlo con pruebas es 10 veces más fácil
        que sin ellas. Lo verás por ti mismo.

        Dependencia de Mockito:
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-junit-jupiter</artifactId>
            <version>4.2.0</version>
            <scope>test</scope>
        </dependency>
        Te permite crear objetos virtuales de los que el compilador no tiene quejas.
        Dichos objetos virtuales se denominan simulacros (de la palabra simulacro - diseño). La biblioteca de Mockito
        pudo llevar el trabajo con estos simulacros a una altura sin precedentes.


        //@ExtendWith
        La biblioteca de Mockito funciona muy bien con JUnit, incluso puede considerarse una extensión de la misma.
        Hay dos formas de habilitar la biblioteca de Mockito en sus pruebas unitarias. La primera forma es agregar una anotación especial:

        @ExtendWith(MockitoExtension.class)
        public class MockitoAnnotationTest {
            ...
        }
        La segunda forma es habilitar su trabajo llamando al method openMocks():

        public class MockitoAnnotationTest {
         @BeforeEach
            public void init() {
         MockitoAnnotations.openMocks(this);
           }
        }
        La mayoría de las veces, verá la primera opción, pero a veces es útil saber que hay una segunda.


        //@Mock
        Hay dos formas de trabajar con objetos simulados en Mockito. El primero es crear un objeto completamente virtual,
        el segundo es envolver un objeto existente en un envoltorio.
        Para crear un objeto completamente virtual, debe escribir el código:
        ClassName variable name = Mockito.mock(ClassName.class);

        En el segundo caso, MockitoExtensionanalizará el propio código de la clase y creará los stubs necesarios.
        No es necesario llamar al method Mockito.mock(). Una anotación y el objeto virtual está listo.


       //@Spy
       Son envoltorios sobre objetos existentes.

       ClassName variable name = Mockito.spy(an object);

        */


        System.out.println("--------------------- Objetos de Mockito ---------------------------");
        //doReturn()
        /*La biblioteca Mockito le permite agregar el comportamiento deseado a un objeto simulado.
        Si desea que un objeto simulado devuelva un determinado resultado cuando se llama a un determinado method,
        entonces esta "regla" se puede agregar al objeto usando el código:

        Mockito.doReturn(result).when(an object).method name();*/

        //when()
        /*Es otra forma de agregar una regla de comportamiento a un objeto simulado:
        Mockito.doReturn(result).when(an object).method name();
         */

        //doThrow()
        /*¿Cómo puedo hacer que arroje una excepción específica? Enviarlo a doReturn()?
         Mockito.when(an object.method name()).thenThrow(exception.class);
        */

        //Parámetros del method
        /*Si desea que el method devuelva algo específico con un determinado parámetro, la regla se puede escribir así:
         Mockito.doReturn(result).when(an object).method name(parameter);
         Qué pasa si el method requiere argumentos, pero para cualquier valor debe devolver el mismo resultado?:"
         Mockito.any()

         //Parametros del tipo any:

         method	                         Tipo de parámetro
        any()	                    Objeto incluyendo nulo
        any(NombreClase.clase)	    nombre de la clase
        anyInt()	                En t
        anyBooleano()	            booleano
        anyDoble()	                doble
        anyList()	                Lista

        //doAnswer()
         Llegamos al complejo comportamiento de los métodos virtuales. Tarde o temprano habrá una situación en la que
         desee que este method virtual tenga un comportamiento complejo. Por ejemplo, debería devolver valores
         dependiendo de los parámetros, convertir la cadena a mayúsculas.

         Mockito.doAnswer(function).when(an object).method name(parameter);

         //verify()
         Además de crear objetos virtuales, a menudo surge otra tarea interesante: asegurarse de que la clase bajo
         prueba llame a los métodos correctos de los objetos correctos. Además, llamó la cantidad requerida de veces,
         con los parámetros correctos y similares.
         Para esto, Mockito también tiene algo de magia: una familia de métodos Mockito.verify(…). La regla general que
         especifica la verificación de llamadas a métodos es:
         Mockito.verify(an object).method name(parameter);

         A veces hay escenarios de verificación más complejos. Por ejemplo, debe verificar no solo el hecho de que se
         llamó al method, sino, por ejemplo, que se llamó 3 veces. O lo llamó usted en un ciclo y, por lo tanto, debería
         haberlo llamado N veces.

         Existen métodos especiales con los que puede configurar varios escenarios:

            method	               Descripción
            never()	            El method nunca debe ser llamado
            times()	            n veces
            atLeast(n)	        n o más veces
            atLeastOnce()	        1 o más veces
            atMost(n)	        n o menos veces
            only()	            Debe haber una sola llamada y solo a este method.

            //Orde de llamada de los methods
            hay situaciones en las que el orden de las llamadas a métodos es importante, y Mockito también tiene una
            solución para esto.
            Se puede especificar un orden estricto de llamadas a métodos utilizando un objeto especial InOrder. Primero
            necesitas crearlo:

            InOrder inOrder = Mockito.inOrder(an object);

            //assertThrows()
            Para comprobar excepciones.
            Assertions.assertThrows(exception.class, () -> an object.methodname());

            //mockStatic()
            Para mockear objetos estaticos se agerga la siguiente dependencia:
            <dependency>
                <groupId>org.mockito</groupId>
                <artifactId>mockito-inline</artifactId>
                <version>4.2.0</version>
                <scope>test</scope>
            </dependency>
         */

    }
}
