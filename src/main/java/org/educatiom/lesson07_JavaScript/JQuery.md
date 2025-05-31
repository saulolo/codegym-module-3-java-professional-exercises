# ⚡ GUÍA RÁPIDA DE JQUERY: SIMPLIFICANDO JAVASCRIPT WEB 🚀

jQuery es una biblioteca de JavaScript rápida, pequeña y rica en características.
Simplifica enormemente la forma en que interactuamos con el HTML, manipulamos
el DOM, manejamos eventos, realizamos animaciones y hacemos llamadas AJAX.
Su filosofía "write less, do more" (escribe menos, haz más) la hizo muy popular.

---
## 1. CONCEPTOS FUNDAMENTALES DE JQUERY 💡

jQuery es un archivo JavaScript que descargas y enlazas a tu HTML. Una vez cargado,
añade funcionalidades al objeto global `jQuery` (alias `$`).

-   SINTAXIS BÁSICA: `$(selector).accion()`
    -   `$`: Alias para jQuery.
    -   `selector`: Permite encontrar elementos HTML (similar a CSS).
    -   `accion()`: La función de jQuery a ejecutar en los elementos seleccionados.

-   EL OBJETO JQUERY:
    -   Cuando seleccionas un elemento con `$()`, no obtienes directamente el elemento
        HTML, sino un "objeto jQuery" que encapsula esos elementos y les añade
        métodos jQuery.

-   DOCUMENT READY:
    -   Esencial para asegurar que el DOM está completamente cargado antes
        de ejecutar tu código jQuery.
    -   `$(document).ready(function() { // Tu código jQuery aquí });`
    -   Forma corta: `$(function() { // Tu código jQuery aquí });` (RECOMENDADO)

---
## 2. CÓMO INCLUIR JQUERY EN HTML 🔗

jQuery es una biblioteca externa, por lo que siempre se enlaza a tu HTML
usando la etiqueta `<script>`.

-   DESDE UN CDN (Content Delivery Network - RECOMENDADO):
    -   Más rápido, aprovecha el caché del navegador, sin necesidad de descargar.
    -   Siempre incluye el script en el `<head>` o justo antes de la etiqueta
        de cierre `</body>`.
    ```html
    <script src="[https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js](https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js)"></script>
    ```

-   LOCALMENTE:
    -   Descarga el archivo `jquery.min.js` y guárdalo en tu proyecto.
    -   Enlázalo usando una ruta relativa:
    ```html
    <script src="js/jquery.min.js"></script>
    ```

---
## 3. SELECTORES JQUERY: EL CORAZÓN DE LA SELECCIÓN DE ELEMENTOS 🎯

Los selectores jQuery son muy potentes y se basan en la sintaxis CSS.
Permiten seleccionar elementos de forma muy eficiente.

| Tipo de Selector          | Sintaxis JQ         | Descripción                                     | Ejemplo HTML     |
| :------------------------ | :------------------ | :---------------------------------------------- | :--------------- |
| Elemento                  | `$('p')`            | Selecciona todas las etiquetas `<p>`.           | `<p>Texto</p>`  |
| ID                        | `$('#miId')`        | Selecciona el elemento con `id="miId"`.        | `<div id="miId"></div>` |
| Clase                     | `$('.miClase')`     | Selecciona todos los elementos con `class="miClase"`. | `<span class="miClase"></span>` |
| Universal                 | `$( '*')`           | Selecciona todos los elementos en el DOM.       | (Todos)          |
| Atributo                  | `$('input[type="text"]')` | Elementos con un atributo específico.           | `<input type="text">` |
| Descendiente              | `$('div p')`        | `<p>` dentro de un `<div>`.                    | `<div><p></p></div>` |
| Hijo Directo              | `$('ul > li')`      | `<li>` que son hijos directos de `<ul>`.      | `<ul><li></li></ul>` |
| Primer/Último Hijo (CSS)  | `$('li:first-child')` | El primer `<li>` dentro de su padre.           | `<ul><li></li><li></li></ul>` |
| N-ésimo Hijo (CSS)        | `$('li:nth-child(2)')` | El segundo `<li>` dentro de su padre.          | `<ul><li></li><li></li></ul>` |
| visible/oculto (Pseudo-Clase)| `$('div:visible')` | Elementos visibles.                             | `<div style="display: block;"></div>` |
| Input type                | `$('input:text')`   | Atajo para `input[type="text"]`.               | `<input type="text">` |
| Vacío                     | `$('div:empty')`    | Elementos que no tienen hijos (ni texto).       | `<div></div>`    |

---
## 4. MANIPULACIÓN DEL DOM CON JQUERY 🛠️

jQuery simplifica la adición, eliminación y modificación de elementos y atributos.

-   CONTENIDO:
    -   `html()` / `html('nuevo')`: Obtiene/establece el HTML.
    -   `text()` / `text('nuevo')`: Obtiene/establece el texto.
    -   `val()` / `val('valor')`: Obtiene/establece el valor de campos de formulario.

-   ATRIBUTOS:
    -   `attr('src')` / `attr('src', 'nueva.jpg')`: Obtiene/establece un atributo.
    -   `removeAttr('src')`: Elimina un atributo.
    -   `prop('checked')` / `prop('checked', true)`: Obtiene/establece propiedades (ej. checked, disabled).

-   CLASES CSS:
    -   `addClass('clase')`: Añade una clase.
    -   `removeClass('clase')`: Elimina una clase.
    -   `toggleClass('clase')`: Añade/elimina una clase (alternar).
    -   `hasClass('clase')`: Comprueba si tiene una clase.

-   CSS DIRECTO:
    -   `css('color')` / `css('color', 'red')`: Obtiene/establece una propiedad CSS.
    -   `css({ 'font-size': '16px', 'color': 'blue' })`: Establece múltiples propiedades.

-   AÑADIR/MOVER ELEMENTOS:
    -   `append(contenido)`: Inserta contenido al final del elemento.
    -   `prepend(contenido)`: Inserta contenido al principio del elemento.
    -   `after(contenido)`: Inserta contenido después del elemento.
    -   `before(contenido)`: Inserta contenido antes del elemento.
    -   `remove()`: Elimina el elemento y sus hijos.
    -   `empty()`: Elimina los hijos del elemento, pero no el elemento en sí.

---
## 5. EVENTOS CON JQUERY: RESPONDIENDO A LA INTERACCIÓN ⚡

jQuery facilita la gestión de eventos, incluso para elementos creados dinámicamente.

-   ASIGNAR EVENTOS (MÁS COMÚN):
    -   `$(selector).click(function() { ... });`
    -   `$(selector).on('click', function() { ... });` (Más flexible, permite delegación)

-   DELEGACIÓN DE EVENTOS (PARA ELEMENTOS DINÁMICOS):
    -   `$(padre).on('click', selectorHijo, function() { ... });`
        (El evento se escucha en 'padre' pero se dispara para 'selectorHijo'.)

-   EVENTOS COMUNES:
    -   `click()`: Clic de ratón.
    -   `dblclick()`: Doble clic.
    -   `mouseenter()` / `mouseleave()`: Cursor entra/sale.
    -   `hover(entrar, salir)`: Atajo para mouseenter/mouseleave.
    -   `keydown()` / `keyup()`: Tecla presionada/soltada.
    -   `submit()`: Envío de formulario.
    -   `change()`: Valor de input/select/textarea cambia.
    -   `focus()` / `blur()`: Elemento recibe/pierde el foco.
    -   `ready()`: Cuando el DOM está cargado (ver arriba).

---
## 6. ANIMACIONES Y EFECTOS JQUERY ✨


jQuery ofrece métodos sencillos para crear efectos visuales.

-   VISIBILIDAD:
    -   `hide()`: Oculta el elemento.
    -   `show()`: Muestra el elemento.
    -   `toggle()`: Alterna entre ocultar/mostrar.
    -   (Todos aceptan duración: `hide(500)`, `'slow'`, `'fast'`)

-   FADES:
    -   `fadeIn()`: Aparece gradualmente.
    -   `fadeOut()`: Desaparece gradualmente.
    -   `fadeToggle()`: Alterna fade-in/fade-out.
    -   `fadeTo(duracion, opacidad)`: Ajusta opacidad.

-   SLIDES:
    -   `slideDown()`: Muestra deslizando hacia abajo.
    -   `slideUp()`: Oculta deslizando hacia arriba.
    -   `slideToggle()`: Alterna slide-down/slide-up.

-   ANIMACIÓN PERSONALIZADA:
    -   `animate({ propiedades }, duracion, callback)`: Anima propiedades CSS.
    ```javascript
    $('div').animate({
        left: '250px',
        opacity: '0.5',
        height: '150px'
    }, 'slow');
    ```

---
## 7. AJAX CON JQUERY: CARGANDO CONTENIDO DINÁMICAMENTE 🌐


Simplifica las peticiones asíncronas HTTP (AJAX) para cargar datos sin
recargar la página.

-   `$.get(url, callback)`: Petición GET simple.
    `$.get('data.json', function(data) { console.log(data); });`

-   `$.post(url, data, callback)`: Petición POST simple.
    `$.post('api/users', { name: 'Saul' }, function(response) { console.log(response); });`

-   `$.ajax({ opciones })`: La más versátil para peticiones HTTP completas.
    ```javascript
    $.ajax({
        url: 'api/items',
        type: 'GET', // o 'POST', 'PUT', 'DELETE'
        dataType: 'json', // tipo de dato esperado de respuesta
        success: function(data) { console.log(data); },
        error: function(xhr, status, error) { console.error(error); }
    });
    ```

---
### METADATOS DEL DOCUMENTO 📄


| Campo           | Detalles                                                   |
| :-------------- |:-----------------------------------------------------------|
| **Título** | GUÍA RÁPIDA DE JQUERY: SIMPLIFICANDO JAVASCRIPT WE         |
| **Autor(es)** | Saul Echeverri                                             |
| **Versión** | 1.0.0                                                      |
| **Fecha de Creación** | 30 de Mayo de 2025                                         |
| **Última Actualización** | 30 de Mayo de 2025                                         |
| **Notas Adicionales**  | Documento base para referencia rápida de jQuery            |

---