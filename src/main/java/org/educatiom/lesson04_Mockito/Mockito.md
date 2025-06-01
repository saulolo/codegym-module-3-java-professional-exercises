# 🧪 GUÍA RÁPIDA DE MOCKITO: PRUEBAS EFICIENTES EN JAVA 🚀

Mockito es una biblioteca estándar para pruebas en Spring, y un
estándar de la industria en el desarrollo de aplicaciones Java en el backend.
Su objetivo principal es permitir la sustitución de objetos reales por
"mocks" (objetos virtuales) en el código, especialmente útil en pruebas
unitarias para aislar el componente que se está probando.

---
## 1. CONCEPTOS FUNDAMENTALES DE MOCKITO 💡

-   MOCKING DE OBJETOS:
    -   Se trata de crear "objetos virtuales" (mocks) que imitan el
        comportamiento de objetos reales. Esto permite
        controlar cómo responden los objetos de los que depende la clase
        que estás probando.

-   DEPENDENCIA (Maven/Gradle):
    -   Para usar Mockito, debes agregar la siguiente dependencia a tu
        archivo `pom.xml` si usas Maven:
        ```xml
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <version>4.2.0</version> <scope>test</scope>
        </dependency>
        ``` 
    -   El `scope` `test` asegura que esta dependencia solo esté disponible
        durante la fase de pruebas.

---
## 2. TIPOS DE OBJETOS MOCK EN MOCKITO 🧬


Mockito ofrece dos formas principales de trabajar con objetos simulados:

-   CREAR UN OBJETO COMPLETAMENTE VIRTUAL (MOCK PURO):
    -   Útil cuando no necesitas el comportamiento original de la clase,
        sino que quieres definirlo completamente.
    -   Sintaxis básica: `List mockList = Mockito.mock(ArrayList.class);`
    -   Usando la anotación `@Mock`:
        ```java
        @RunWith(MockitoJUnitRunner.class)
        class Test {
            @Mock
            List mockList; // mockList es un mock puro
            // ...
        }
        ``` 

-   ENVOLVER UN OBJETO EXISTENTE (SPY):
    -   Permite utilizar clases existentes e interceptar invocaciones de
        métodos y accesos a variables, modificando su comportamiento según sea
        necesario.
    -   Por defecto, el spy redirige las llamadas al objeto original.
    -   Sintaxis básica: `ClassName variableName = Mockito.spy(ClassName.class);`
    -   Usando la anotación `@Spy`:
        ```java
        @RunWith(MockitoJUnitRunner.class)
        class Test {
            @Spy
            List mockList = new ArrayList<String>(); // mockList envuelve un ArrayList real
            // ...
        }
        ``` 

---
## 3. DEFINIR COMPORTAMIENTOS (STUBBING) 🎯


Mockito permite definir cómo un objeto simulado (mock o spy) debe
comportarse cuando se invoca un método específico.

-   DEVOLVER UN VALOR ESPECÍFICO:
    -   `Mockito.doReturn(result).when(object).methodName();` 
        -   Ideal para métodos que devuelven `void` o cuando la invocación real
            del método podría tener efectos secundarios no deseados antes del stubbing.
    -   `Mockito.when(object.methodName()).thenReturn(result);` 
        -   Más común para la mayoría de los casos.
        -   **Limitaciones de `when().thenReturn()`:** No funciona si el método
            `methodName()` devuelve `void`. La invocación dentro de `when()`
            puede ser confusa.

-   LANZAR UNA EXCEPCIÓN:
    -   `Mockito.doThrow(Exception.class).when(object).methodName();` 
    -   `Mockito.when(object.methodName()).thenThrow(Exception.class);`
    -   Para una instancia específica de excepción:
        `Mockito.doThrow(new Exception()).when(result).methodName();` 

-   COMPORTAMIENTO COMPLEJO (`doAnswer()`):
    -   Permite definir un comportamiento personalizado para un método virtual
        que puede depender de los parámetros de entrada o realizar lógica
        más compleja (ej. convertir una cadena a mayúsculas).
    -   Sintaxis: `Mockito.doAnswer(function).when(object).methodName(parameter);`
        -   El `function` es un `Answer` que define la lógica.

---
## 4. LLAMADAS A MÉTODOS CON PARÁMETROS 🕵️


Puedes definir reglas de comportamiento basadas en los parámetros de la invocación.

-   VALOR ESPECÍFICO DEL PARÁMETRO:
    -   `Mockito.doReturn(result).when(object).methodName(parameter);`

-   PLANTILLAS DE PARÁMETROS (`Argument Matchers`):
    -   Para aplicar una regla a un método con *cualquier* argumento o argumentos
        de un tipo específico.
    -   **¡Importante!** Si usas un `any*()` matcher, **todos los argumentos**
        deben ser matchers, o ninguno.
    -   Métodos comunes de `Mockito.any()`: 

| Método             | Tipo de parámetro                              |
| :----------------- | :--------------------------------------------- |
| `any()`            | `Object`, incluyendo `null`                    |
| `any(ClassName.class)` | Una clase específica (`ClassName`)             |
| `anyInt()`         | `int`                                          |
| `anyBoolean()`     | `boolean`                                      |
| `anyDouble()`      | `double`                                       |
| `anyList()`        | `List`                                         |
| `anyString()`      | `String`                                       |
| `eq(valor)`        | Un valor exacto para un tipo específico (cuando se mezclan matchers) |

---
## 5. VERIFICAR COMPORTAMIENTOS (VERIFICATION) ✅


`Mockito.verify()` asegura que los métodos correctos fueron llamados en los objetos
esperados, con la frecuencia y parámetros correctos.

-   VERIFICACIÓN BÁSICA (UNA VEZ):
    -   `Mockito.verify(object).methodName(parameter);` 
        -   Verifica que el método fue llamado al menos una vez con los parámetros dados.
        -   La verificación real ocurre *después* de la ejecución del método de prueba.

-   VERIFICAR NÚMERO DE INVOCACIONES:
    -   `Mockito.verify(object, quantity).methodName(parameter);` 
    -   `quantity` es un objeto especial para patrones de invocación, no un `int`.

| Patrón de Cantidad      | Descripción                                   |
| :---------------------- | :-------------------------------------------- |
| `never()`               | Verifica que el método *nunca* fue llamado.   |
| `times(n)`              | Verifica que el método fue llamado `n` veces. |
| `atLeast(n)`            | Verifica que el método fue llamado `n` o más veces.  |
| `atLeastOnce()`         | Verifica que el método fue llamado 1 o más veces.  |
| `atMost(n)`             | Verifica que el método fue llamado `n` o menos veces.  |
| `only()`                | Solo esta invocación y solo a este método.  |

-   ORDEN DE INVOCACIÓN:
    -   Para verificar un orden estricto de llamadas a métodos.
    -   1. Crea un objeto `InOrder`:
           `InOrder inOrder = Mockito.inOrder(object1, object2, ...);` 
    -   2. Agrega las reglas de verificación en el orden deseado usando `inOrder.verify()`:
           `inOrder.verify(object).methodName1();` 
           `inOrder.verify(object).methodName2();`

-   COMPROBAR EXCEPCIONES LANZADAS:
    -   Similar a la verificación de invocaciones, pero usando `thenThrow()`.
    -   `Mockito.verify(object.methodName()).thenThrow(Exception.class);` 

---
## 6. SIMULACIÓN DE MÉTODOS ESTÁTICOS (`mockStatic()`) ⚙️


Mockito permite simular métodos estáticos (a partir de la versión 3.4.0+).
Requiere un enfoque ligeramente diferente.

-   1. CREAR UN OBJETO SIMULADO ESPECIAL:
       `MockedStatic<ClassName> controlObject = Mockito.mockStatic(ClassName.class);` [cite: 51]

-   2. AGREGAR REGLAS DE COMPORTAMIENTO:
    -   Las reglas se adjuntan a este `controlObject`.
    -   `controlObject.when(ClassName::methodName).thenReturn(result);` 

-   3. ENVOLVER EN `try-with-resources`:
    -   Es CRÍTICO usar un bloque `try-with-resources` para asegurar que el
        mock estático se limpie correctamente y Mockito pueda borrar las reglas
        asociadas después de la prueba.
```java
try (MockedStatic<MiClaseEstatica> mockedStatic = Mockito.mockStatic(MiClaseEstatica.class)) {
    mockedStatic.when(MiClaseEstatica::metodoEstatico).thenReturn("Mocked");
    // ... tu código de prueba que llama al método estático ...
} // El mock se cierra automáticamente aquí
```

---
## 7. CHEATSHEET RÁPIDA DE MÉTODOS CLAVE DE MOCKITO 🎯


| Método / Anotación  | Descripción                                | Uso Principal (Ejemplo)                      |
| :------------------ | :----------------------------------------- | :------------------------------------------- |
| `Mockito.mock()`    | Crea un objeto mock puro.                  | `List mockList = Mockito.mock(List.class);`  |
| `@Mock`             | Anotación para inyectar un mock puro.      | `@Mock List mockList;`                       |
| `Mockito.spy()`     | Envuelve un objeto real para espiar.       | `List spyList = Mockito.spy(new ArrayList());` |
| `@Spy`              | Anotación para inyectar un spy.             | `@Spy List spyList = new ArrayList<>();`     |
| `doReturn().when()` | Define un retorno, ideal para void/spies.  | `doReturn(true).when(mock).metodo();`        |
| `when().thenReturn()`| Define un retorno para métodos con retorno. | `when(mock.metodo()).thenReturn("valor");` |
| `doThrow().when()`  | Hace que un método lance una excepción.    | `doThrow(Exception.class).when(mock).metodo();` |
| `when().thenThrow()`| Hace que un método lance una excepción.    | `when(mock.metodo()).thenThrow(new RuntimeException());` |
| `doAnswer().when()` | Define comportamiento complejo con lógica. | `doAnswer(invocation -> "Hola").when(mock).saludar();` |
| `Mockito.verify()`  | Verifica que un método fue invocado.       | `verify(mock).metodoLlamado();`              |
| `times(n)`          | Con `verify`, verifica `n` invocaciones.   | `verify(mock, times(2)).metodo();`           |
| `never()`           | Con `verify`, verifica que nunca fue llamado. | `verify(mock, never()).otroMetodo();`        |
| `any()`, `anyInt()` etc.| Matchers para cualquier argumento.       | `when(mock.metodo(anyString())).thenReturn("OK");` |
| `Mockito.inOrder()` | Para verificar el orden de invocaciones.   | `InOrder io = inOrder(mock); io.verify(mock).m1(); io.verify(mock).m2();` |
| `Mockito.mockStatic()` | Crea un mock para métodos estáticos.     | `try(MockedStatic<MyClass> m = mockStatic(MyClass.class))` |

---
### METADATOS DEL DOCUMENTO 📄

| Campo           | Detalles                                          |
| :-------------- |:--------------------------------------------------|
| **Título** | GUÍA RÁPIDA DE MOCKITO: PRUEBAS EFICIENTES EN JAVA        |
| **Autor(es)** | Saul Echeverri                                    |
| **Versión** | 1.0.0                                             |
| **Fecha de Creación** | 31 de Mayo de 2025                                |
| **Última Actualización** | 31 de Mayo de 2025                                |
| **Notas Adicionales**  | Documento base para referencia rápida de Mockito. |

---

