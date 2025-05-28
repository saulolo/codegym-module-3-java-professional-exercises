package org.educatiom.lesson03_JUnit5;

public class AnotacionesUtilesJUnit {

    public static void main(String[] args) {

        System.out.println("--------------------- Anotaciones útiles en JUnit ---------------------------");
        //@Disabled
        /* le permite desactivar una prueba específica para que JUnit no la llame. */

        //@Nested
        /*Para llamar a los métodos de una clase anidada antes de su declaración, debe escribir dicha anotación*/

        //@ExtendWith
        /*JUnit es un marco poderoso que le permite escribir varios complementos (extensiones) para una personalización
        flexible de su trabajo. Algunas extensiones pueden recopilar estadísticas sobre las pruebas, otras pueden emular
        un sistema de archivos en memoria, otras pueden emular el trabajo dentro de un servidor web, etc.
        Si su código se ejecuta dentro de un marco (por ejemplo, Spring), casi siempre este marco administra la creación
         y configuración de objetos en su código . Por lo tanto, es indispensable un complemento de prueba especial.*/

        //@Timeout
        /*@Timeout(value = 100, unit = TimeUnit.MILLISECONDS). Le permite establecer el tiempo para ejecutar la prueba.
        Si la prueba tomó más tiempo del especificado en la anotación, entonces se considera fallida.*/

        System.out.println("--------------------- Pruebas parametrizadas en Junit ---------------------------");
        //@@ParameterizedTest
        /*A veces, solo desea llamar a la prueba varias veces con diferentes parámetros: diferentes valores, diferentes
        parámetros de entrada, diferentes nombres de usuario. JUnit tiene como objetivo hacer su vida más fácil, por lo
        que para este caso tiene pruebas parametrizadas.

        Para usar pruebas parametrizadas, debe agregar una dependencia más a su pom.xml:

        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-params</artifactId>
            <version>5.8.2</version>
            <scope>test</scope>
        </dependency>

        //@ValueSource
        es excelente para trabajar con primitivos y literales. Simplemente enumere los valores de los parámetros
        separados por comas y la prueba se llamará una vez para cada valor.

        //@NullSource
        Anotación especial para permitir nulos.

        ejemplo:
        @ParameterizedTest
        @ValueSource(ints = { 1, 2, 3 })
        void testMethod(int argument) {
            //test code
        }

        //@EnumSource
        Pasa todos los valores de un Enum específico al méthod

        enum Direction {
            EAST, WEST, NORTH, SOUTH
        }

        @ParameterizedTest
        @EnumSource(Direction.class)
        void testWithEnumSource(Direction d) {
            assertNotNull(d);
        }

        //@MethodSource
        Pero, ¿cómo pasar objetos como parámetros? Especialmente si tienen un algoritmo de construcción complejo. Para
        hacer esto, simplemente puede especificar un método auxiliar especial que devolverá una lista (Stream) de tales
        valores.

        @ParameterizedTest
        @MethodSource("argsProviderFactory")
        void testWithMethodSource(String argument) {
            assertNotNull(argument);
        }

        static Stream<String> argsProviderFactory() {
            return Stream.of("one", "two",  "three");
        }

        //@CSVSource
        Pasa varios parámetros al method, permite listar los valores de los parámetros del method simplemente separados
        por comas.
        @ParameterizedTest
        @CsvSource({
            "alex, 30, Programmer, Working",
            "brian, 35, Tester, Working",
            "charles, 40, manager, kicks"
        })
        void testWithCsvSource(String name, int age, String occupation, String status) {
            //method code
        }


        */

        System.out.println("--------------------- Assert JUnit ---------------------------");
        //assert
        /*Los assert (afirmaciones) son comprobaciones especiales que se pueden insertar en diferentes lugares del código.
        Su tarea es determinar que algo salió mal. O mejor dicho, para comprobar que va como debe. */

        //assertEquals
        /*Comprueba la igualdad de los objetos. Si los objetos no son iguales, se lanzará una excepción y la prueba fallará.
        El orden de comparación es importante aquí , porque JUnit en el informe final escribirá algo así como "valor 1
        recibido, pero se esperaba 3". El formato general para tal verificación es:

        assertEquals(standard , meaning

        @Test
        void mul() {
            int result = calculator.mul(4, 2);
            assertEquals(8, result);
        }

        //Metohos mas comunes para aserciones.

        assertEquals	    Comprueba que dos objetos son iguales
        assertArrayEquals	Comprueba si dos matrices contienen valores iguales
        assertNotNull	    Comprueba si el argumento no es nulo
        assertNull	        Comprueba si el argumento es nulo
        assertNotSame     	Comprueba que los dos argumentos no son el mismo objeto.
        assertSame      	Comprueba que los dos argumentos son el mismo objeto.
        assertTrue      	Comprueba si el argumento es verdadero
        assertFalse 	    Comprueba si el argumento es falso
        assertTimeout       Establece restricciones en la ejecución de alguna parte del código dentro del method
        assertThrows        Verifica que el código especificado arroje la excepción correcta.


        //assertAll()
        Si uno de los parámetros no coincide, el resto no se verificará. Pero me gustaría que aún ocurran y que sus
        resultados se registren en el registro. Pero al mismo tiempo, si al menos una verificación falló, la prueba aún
        falló.
        Address address = unitUnderTest.methodUnderTest();
        assertAll("Complex address comparison script",
            () -> assertEquals("Washington", address.getCity()),
            () -> assertEquals("Oracle Parkway", address.getStreet()),
            () -> assertEquals("500", address.getNumber())
        );

        //@Suite
        Las pruebas se pueden combinar en grupos. Hay una anotación especial para esto @Suite. Ejemplo:

        @Suite @SuiteDisplayName("JUnit Platform Suite Demo") @SelectPackages("com.codegym.test") @IncludeClassNamePatterns(".*Tests")
        class SuiteDemo {
        }

        En este caso, la anotación @Suite se combina con otras anotaciones.

        SuiteDisplayName– establece el nombre del grupo de prueba en el registro;
        SelectPackages- establece la lista de paquetes donde buscar clases de prueba;
        IncludeClassNamePatterns– establece el patrón de nombres de clase de prueba.

        //@TestMethodOrder.
        Le permite especificar el orden en que se llaman los métodos de prueba en la clase de prueba.
        @TestMethodOrder(OrderAnnotation.class)
        public class OrderAnnotationUnitTest {

         @Test @Order(1)
            public void firstTest() {
            }

         @Test @Order(2)
            public void secondTest() {
            }
        }

        //@DisplayName
        A cada prueba se le puede dar un nombre. Puede ser conveniente si hay muchas pruebas y crea escenarios
        especiales (subconjuntos) de pruebas.

        @DisplayName("Friendly name for the test")
        public class DisplayNameCustomTest {

         @Test @DisplayName("Input Validation")
            void inputData() {
            }

        //@DisplayNameGeneration
        Puede crear un método especial que generará los nombres de las pruebas y los métodos de prueba

        @DisplayNameGeneration(DisplayNameGeneratorUnitTest.ReplaceCamelCase.class)
        class DisplayNameGeneratorUnitTest {

         @Test
            void camelCaseName() {
            }
         */

    }
}
