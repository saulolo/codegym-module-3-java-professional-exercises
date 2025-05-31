====================================================================
# 💻 GUÍA RÁPIDA DE JAVASCRIPT: LÓGICA Y DINAMISMO PARA LA WEB 💻
====================================================================

JavaScript es el lenguaje de programación esencial para la interactividad
en la web. Permite que tus páginas cobren vida, reaccionen a los usuarios
y manipulen el contenido de forma dinámica. Es el "cerebro" de la web.

---
## 1. CONCEPTOS FUNDAMENTALES DE JAVASCRIPT 💡


JS es dinámicamente tipado (no declaras el tipo de variable explícitamente),
interpretado y soporta paradigmas de programación variados (orientado a objetos,
funcional).

-   VARIABLES: Contenedores para almacenar datos.
    -   `var`: Alcance de función (antiguo).
    -   `let`: Alcance de bloque (moderno, preferido).
    -   `const`: Alcance de bloque, valor no reasignable (preferido para constantes).

-   TIPOS DE DATOS BÁSICOS:
    -   String (texto): "Hola", 'Mundo'
    -   Number (números): 10, 3.14
    -   Boolean (verdadero/falso): true, false
    -   Null (ausencia intencional de valor)
    -   Undefined (valor no asignado)
    -   Symbol (únicos e inmutables, ES6+)
    -   BigInt (números enteros grandes, ES2020+)

-   ESTRUCTURAS DE DATOS COMPLEJAS:
    -   Arrays (Arreglos): Colecciones ordenadas de elementos.
        `[1, "hola", true]`
    -   Objects (Objetos): Colecciones de pares clave-valor.
        `{ nombre: "Juan", edad: 30 }`

-   OPERADORES BÁSICOS:
    -   Aritméticos: `+`, `-`, `*`, `/`, `%` (módulo)
    -   Asignación: `=`, `+=`, `-=`, `*=`
    -   Comparación: `==` (igual valor), `===` (igual valor y tipo), `!=`, `!==`, `>`, `<`, `>=`, `<=`
    -   Lógicos: `&&` (AND), `||` (OR), `!` (NOT)

---
## 2. CÓMO INCLUIR JAVASCRIPT EN HTML 🔗

JavaScript se inserta en un documento HTML usando la etiqueta `<script>`.

-   EN LÍNEA (EVITAR): Para funciones muy pequeñas y específicas.
    ` <button onclick="alert('Hola!');">Haz clic</button> `

-   INTERNO: Dentro de la etiqueta `<script>` en la sección `<head>` o `<body>`.
    ` <script> console.log("Hola desde JS interno"); </script> `
    (Idealmente al final del <body> para no bloquear el renderizado.)

-   EXTERNO (RECOMENDADO): En un archivo .js separado.
    ` <script src="mi-script.js"></script> `
    (Permite reutilización y mantiene el HTML limpio.)

---
## 3. MANIPULACIÓN DEL DOM (Document Object Model) 🌳


El DOM es la interfaz de programación para documentos HTML. Permite a JS
acceder y modificar el contenido, estructura y estilo de una página.

-   SELECCIONAR ELEMENTOS:
    -   `document.getElementById('miId')`           👉 Selecciona por ID (único).
    -   `document.querySelector('.miClase')`         👉 Primer elemento que coincide con un selector CSS.
    -   `document.querySelectorAll('div.clase')`     👉 Todos los elementos que coinciden.
    -   `document.getElementsByClassName('clase')`   👉 Colección de elementos por clase.
    -   `document.getElementsByTagName('p')`         👉 Colección de elementos por etiqueta.

-   MODIFICAR CONTENIDO:
    -   `elemento.textContent = 'Nuevo Texto';`    👉 Cambia solo el texto.
    -   `elemento.innerHTML = '<b>HTML Nuevo</b>';` 👉 Cambia el contenido (incluye HTML).

-   MODIFICAR ATRIBUTOS/ESTILOS:
    -   `elemento.setAttribute('src', 'nuevaImagen.jpg');` 👉 Establece un atributo.
    -   `elemento.classList.add('clase-activa');`         👉 Añade una clase CSS.
    -   `elemento.classList.remove('clase-activa');`      👉 Quita una clase CSS.
    -   `elemento.style.color = 'red';`                    👉 Cambia estilos CSS directamente.

-   CREAR/ELIMINAR ELEMENTOS:
    -   `document.createElement('div')`   👉 Crea un nuevo elemento.
    -   `padre.appendChild(hijo)`         👉 Añade un hijo al final del padre.
    -   `padre.removeChild(hijo)`         👉 Elimina un hijo.

---
## 4. EVENTOS: HACIENDO LA WEB INTERACTIVA ⚡


Los eventos son acciones del usuario o del navegador a las que JS puede
responder (clics, teclado, carga de página, etc.).

-   ASIGNAR MANEJADORES DE EVENTOS:
    -   `elemento.onclick = function() { ... };` (Método antiguo)
    -   `elemento.addEventListener('click', function() { ... });` (RECOMENDADO)
        -   `'click'`, `'mouseover'`, `'keydown'`, `'submit'`, `'load'`, `'change'`, etc.

-   EVENTOS COMUNES:
    -   `click`: Cuando se hace clic en un elemento.
    -   `mouseover`/`mouseout`: Cursor entra/sale de un elemento.
    -   `keydown`/`keyup`: Tecla presionada/soltada.
    -   `submit`: Envío de un formulario.
    -   `load`: La página o un recurso ha terminado de cargar.

---
## 5. FUNCIONES: BLOQUES DE CÓDIGO REUTILIZABLES 🔄


Las funciones son el corazón de la programación. Agrupan código que puedes
ejecutar repetidamente.

-   DECLARACIÓN DE FUNCIÓN:
    ```
    function saludar(nombre) {
        return "Hola, " + nombre + "!";
    }
    ```
-   EXPRESIÓN DE FUNCIÓN:
    ```
    const despedir = function(nombre) {
        console.log("Adiós, " + nombre);
    };
    ```
-   FUNCIONES FLECHA (Arrow Functions - ES6+): Sintaxis más concisa.
    ```
    const sumar = (a, b) => a + b;
    const decirHola = () => console.log("Hola!");
    ```

---
## 6. ESTRUCTURAS DE CONTROL DE FLUJO 🚦


Controlan el orden en que se ejecutan las instrucciones de tu código.

-   CONDICIONALES:
    -   `if / else if / else`:
        ```
        if (condicion) { // código }
        else if (otraCondicion) { // código }
        else { // código }
        ```
    -   `switch`: Para múltiples opciones basadas en un valor.
        ```
        switch (valor) {
            case 1: // código; break;
            default: // código;
        }
        ```

-   BUCLES (LOOPS):
    -   `for`: Repite un bloque de código un número específico de veces.
        ```
        for (let i = 0; i < 5; i++) { // código }
        ```
    -   `while`: Repite mientras una condición sea verdadera.
        ```
        while (condicion) { // código }
        ```
    -   `do...while`: Ejecuta el bloque al menos una vez, luego repite mientras la condición sea verdadera.
        ```
        do { // código } while (condicion);
        ```
    -   `for...of` (ES6+): Itera sobre los elementos de colecciones (Arrays, Strings).
        ```
        for (const item of miArray) { // código }
        ```
    -   `for...in`: Itera sobre las propiedades de un objeto.
        ```
        for (const key in miObjeto) { // código }
        ```

---
## 7. ASINCRONÍA EN JAVASCRIPT (BASES) ⏳


JS es de un solo hilo, pero maneja operaciones que toman tiempo (ej. peticiones de red)
de forma no bloqueante usando callbacks, promesas y async/await.

-   `setTimeout(funcion, milisegundos)`: Ejecuta una función una vez después de un retardo.
-   `setInterval(funcion, milisegundos)`: Ejecuta una función repetidamente cada cierto tiempo.
-   PROMESAS (`Promise`): Manejan resultados de operaciones asíncronas que pueden
    tener éxito (`.then()`) o fallar (`.catch()`).
    ```
    fetch('url').then(response => response.json()).catch(error => console.error(error));
    ```
-   `async / await` (ES2017+): Sintaxis más legible para trabajar con promesas.
    ```
    async function obtenerDatos() {
        try {
            const respuesta = await fetch('url');
            const datos = await respuesta.json();
            console.log(datos);
        } catch (error) {
            console.error('Error:', error);
        }
    }
    ```

---
## 8. CONSOLA DEL NAVEGADOR: TU MEJOR AMIGA PARA DEPURAR 🐞


Usa la consola del navegador (F12 o Ctrl+Shift+I) para ver mensajes, errores
y probar código JavaScript.

-   `console.log('Mensaje');`             👉 Imprime información general.
-   `console.warn('Advertencia!');`       👉 Imprime advertencias.
-   `console.error('¡Error crítico!');`   👉 Imprime errores.
-   `console.table(miArrayOObjeto);`      👉 Imprime datos en formato de tabla.

---
## 9. CHEATSHEET RÁPIDA DE MÉTODOS DE ARRAYS COMUNES 🎯

| Método                  | Descripción                                          | Ejemplo                                   |
| :---------------------- | :--------------------------------------------------- | :---------------------------------------- |
| `push()`                | Añade uno o más elementos al final.                  | `arr.push(5);`                             |
| `pop()`                 | Elimina y devuelve el último elemento.               | `arr.pop();`                              |
| `shift()`               | Elimina y devuelve el primer elemento.               | `arr.shift();`                            |
| `unshift()`             | Añade uno o más elementos al principio.              | `arr.unshift(0);`                         |
| `forEach()`             | Ejecuta una función para cada elemento.              | `arr.forEach(item => console.log(item));` |
| `map()`                 | Crea un nuevo array con los resultados de una función. | `arr.map(item => item * 2);`              |
| `filter()`              | Crea un nuevo array con elementos que pasan una prueba. | `arr.filter(item => item > 10);`          |
| `reduce()`              | Reduce el array a un único valor.                    | `arr.reduce((acc, val) => acc + val, 0);`  |
| `find()`                | Devuelve el primer elemento que satisface una prueba. | `arr.find(item => item > 5);`             |
| `findIndex()`           | Devuelve el índice del primer elemento que satisface una prueba. | `arr.findIndex(item => item === 7);`      |
| `includes()`            | Comprueba si un array incluye un elemento.           | `arr.includes('manzana');`                |
| `join()`                | Une todos los elementos en una cadena.               | `arr.join(', ');`                         |
| `slice(inicio, fin)`    | Crea una copia superficial de una porción del array. | `arr.slice(1, 3);`                        |
| `splice(idx, del, add)` | Cambia el contenido de un array eliminando o reemplazando. | `arr.splice(1, 1, 'nuevo');`              |

---
## 10. CHEATSHEET RÁPIDA DE MÉTODOS DE CADENAS (STRING) COMUNES 📖


| Método             | Descripción                                       | Ejemplo                                      |
| :----------------- | :------------------------------------------------ | :------------------------------------------- |
| `length`           | Longitud de la cadena (propiedad).                | `'hola'.length;` (4)                          |
| `toLowerCase()`    | Convierte a minúsculas.                           | `'HOLA'.toLowerCase();` ('hola')             |
| `toUpperCase()`    | Convierte a mayúsculas.                           | `'hola'.toUpperCase();` ('HOLA')             |
| `trim()`           | Elimina espacios en blanco de los extremos.       | `'  texto  '.trim();` ('texto')              |
| `indexOf(substring)`| Devuelve el índice de la primera ocurrencia.      | `'abc'.indexOf('b');` (1)                    |
| `includes(substring)`| Comprueba si la cadena contiene una subcadena.  | `'hola'.includes('la');` (true)              |
| `startsWith(prefix)`| Comprueba si la cadena comienza con un prefijo.  | `'hello'.startsWith('he');` (true)           |
| `endsWith(suffix)` | Comprueba si la cadena termina con un sufijo.   | `'world'.endsWith('ld');` (true)             |
| `substring(start, end)`| Extrae una porción de la cadena.                 | `'abcd'.substring(1, 3);` ('bc')             |
| `slice(start, end)`| Extrae una porción (permite índices negativos).   | `'abcd'.slice(-2);` ('cd')                  |
| `replace(old, new)`| Reemplaza la primera ocurrencia.                  | `'foo'.replace('o', 'a');` ('fao')           |
| `replaceAll(old, new)`| Reemplaza todas las ocurrencias (ES2021+).       | `'foo'.replaceAll('o', 'a');` ('faa')        |
| `split(delimiter)` | Divide la cadena en un array de subcadenas.       | `'a,b,c'.split(',');` (['a','b','c'])       |

---
###  METADATOS DEL DOCUMENTO 📄


| Campo           | Detalles                                                  |
| :-------------- |:----------------------------------------------------------|
| **Título** | GUÍA RÁPIDA DE JAVASCRIPT: LÓGICA Y DINAMISMO PARA LA WEB |
| **Autor(es)** | Saul Echeverri                                            |
| **Versión** | 1.0.0                                                     |
| **Fecha de Creación** | 30 de Mayo de 2025                                        |
| **Última Actualización** | 30 de Mayo de 2025                                        |
| **Notas Adicionales**  | Documento base para referencia rápida de JS.              |

---