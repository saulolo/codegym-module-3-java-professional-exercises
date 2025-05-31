
# 🎨 Guia Rápida de CSS: Estilos y Presentación 🎨

CSS (Cascading Style Sheets) se encarga de cómo se ve tu contenido. Separa la estructura del diseño.

## 1. Conceptos Fundamentales de CSS 💡

| Concepto/Propiedad | Descripción y Uso Principal                                                              | Ejemplo de Aplicación                                   |
| :----------------- | :--------------------------------------------------------------------------------------- | :------------------------------------------------------ |
| **Sintaxis Básica** | Un bloque de CSS consta de un `selector`, una `propiedad` y un `valor`.                 | `p { color: blue; }`                                    |
| `selector`         | Selecciona el elemento(s) HTML al que se aplicará el estilo.                             | `h1`, `.clase`, `#id`                                   |
| `propiedad`        | La característica del elemento que quieres cambiar (ej. `color`, `font-size`).         | `font-size: 16px;`                                      |
| `valor`            | El ajuste específico para la propiedad (ej. `red`, `20px`, `bold`).                      | `color: red;`                                           |
| **Regla CSS** | El conjunto completo de selector, propiedad y valor encerrado en llaves `{}`.            | `p { color: blue; font-size: 14px; }`                   |
| **Declaración** | Una sola pareja `propiedad: valor;` dentro de una regla CSS.                            | `color: blue;`                                          |

---
## 2. Formas de Incluir CSS 🔗

Existen tres métodos principales para añadir estilos CSS a una página HTML.

| Método    | Descripción y Uso Principal                                | Ejemplo de Código                                 |
| :-------- | :--------------------------------------------------------- | :------------------------------------------------ |
| **En línea** | Estilos aplicados directamente a un elemento HTML usando el atributo `style`. Útil para estilos únicos. | `<p style="color: red; font-size: 16px;">Texto</p>` |
| **Interno** | Estilos definidos dentro de la etiqueta `<style>` en la sección `<head>` del HTML. Bueno para una sola página. | `<head><style>p { color: blue; }</style></head>` |
| **Externo** | Estilos definidos en un archivo `.css` separado y enlazado al HTML. Mejor para proyectos grandes y reutilización. | `<link rel="stylesheet" href="styles.css">`      |

---
## 3. Selectores: La Magia para Apuntar a Tus Elementos 🎯

Dominar los selectores es crucial. Te permiten ser muy específico sobre qué elementos HTML quieres estilizar.

| Tipo de Selector          | Símbolo | Descripción                                                                   | Ejemplo de CSS           | Ejemplo de HTML Correspondiente       |
| :------------------------ | :------ | :-------------------------------------------------------------------------- | :----------------------- | :------------------------------------ |
| **Tipo/Elemento** | `tag`   | Selecciona todas las instancias de una etiqueta HTML específica.            | `p { color: red; }`      | `<p>Hola</p>`                         |
| **Clase** | `.`     | Selecciona elementos que tienen un atributo `class` dado. Útil para aplicar estilos a múltiples elementos no necesariamente del mismo tipo. | `.btn { display: block; }` | `<button class="btn">Click</button>` |
| **ID** | `#`     | Selecciona un *único* elemento con un atributo `id` específico. Los IDs deben ser únicos en toda la página. | `#header { height: 80px; }` | `<header id="header"></header>`       |
| **Descendiente** | ` `     | Selecciona un elemento que es descendiente (en cualquier nivel) de otro.    | `div p { font-size: 14px; }` | `<div><p>Texto</p></div>`             |
| **Hijo Directo** | `>`     | Selecciona un elemento que es *hijo directo* de otro.                      | `ul > li { padding: 5px; }` | `<ul><li>Item</li></ul>`             |
| **Adyacente Sibling** | `+`     | Selecciona un elemento que sigue inmediatamente a otro, y ambos comparten el mismo padre. | `h1 + p { margin-top: 0; }` | `<h1>Título</h1><p>Párrafo</p>`       |
| **General Sibling** | `~`     | Selecciona todos los elementos que son hermanos del primero y lo siguen en el código. | `h1 ~ p { color: gray; }` | `<h1>T</h1><p>P1</p><p>P2</p>`         |
| **Atributo** | `[]`    | Selecciona elementos basados en sus atributos (existencia, valor exacto, que contenga el valor, etc.). | `input[type="text"] { border: 1px; }` | `<input type="text">`                 |
| **Universal** | `*`     | Selecciona *todos* los elementos.            

---
## 4. Propiedades CSS Esenciales (¡Las Que Usarás Constantemente!) 🛠️

### **4.1. El Modelo de Caja (Box Model): ¡Fundamental para el Layout!** 📦

Todo elemento HTML se renderiza como una caja rectangular. Entender cómo se comportan estas cajas y sus componentes es crítico para la disposición y el espaciado.

| Propiedad   | Descripción                                                        | Valor Típico     |
| :---------- | :----------------------------------------------------------------- | :--------------- |
| `content`   | El contenido real del elemento (texto, imagen, etc.).              | (Determinado por el contenido) |
| `padding`   | Espacio **interno** entre el contenido y el borde del elemento.    | `10px`, `1em`, `5%` |
| `border`    | Línea que rodea el `padding` y el contenido.                       | `1px solid black`|
| `margin`    | Espacio **externo** alrededor del borde del elemento, separándolo de otros. | `20px auto`      |
| `width`     | Ancho del área de contenido del elemento.                          | `100%`, `300px`  |
| `height`    | Altura del área de contenido del elemento.                         | `auto`, `200px`  |
| `box-sizing`| Controla cómo se calculan `width` y `height` en relación con padding y border. `border-box` es muy común y útil. | `content-box`, `border-box` |

**Concepto Clave: `box-sizing: border-box;`**
Esta es una propiedad que a menudo se establece globalmente (`* { box-sizing: border-box; }`). Hace que el `padding` y 
el `border` se incluyan *dentro* del `width` y `height` definidos, lo que simplifica enormemente el cálculo de los tamaños 
de los elementos y previene desbordamientos inesperados.

###  **4.2. Propiedades de Texto y Fuente** ✍️

| Propiedad        | Descripción                                             | Valores Comunes                        |
| :--------------- | :------------------------------------------------------ | :------------------------------------- |
| `color`          | Define el color del texto.                              | `blue`, `#336699`, `rgb(255,0,0)`      |
| `font-family`    | Establece la fuente (tipo de letra).                    | `'Arial'`, `'Helvetica'`, `serif`      |
| `font-size`      | Controla el tamaño del texto.                           | `16px`, `1.2em`, `small`, `120%`       |
| `font-weight`    | Define el grosor o audacia de la fuente.                | `normal`, `bold`, `400`, `700`         |
| `text-align`     | Alinea el texto dentro de su contenedor.                | `left`, `center`, `right`, `justify`   |
| `line-height`    | Establece el espacio entre líneas de texto.             | `1.5`, `20px`, `150%`                  |
| `text-decoration`| Añade o quita decoraciones al texto.                    | `none`, `underline`, `overline`, `line-through` |
| `text-transform` | Controla la capitalización del texto.                   | `none`, `uppercase`, `lowercase`, `capitalize` |

### **4.3. Propiedades de Fondo y Color** 🌈

| Propiedad         | Descripción                                        | Valores Comunes                                     |
| :---------------- | :------------------------------------------------- | :-------------------------------------------------- |
| `background-color`| Establece el color de fondo de un elemento.        | `red`, `#FF0000`, `rgba(255,0,0,0.5)`               |
| `background-image`| Define una imagen como fondo.                      | `url('ruta/imagen.png')`, `linear-gradient(...)`    |
| `background-repeat`| Cómo se repite la imagen de fondo.                 | `no-repeat`, `repeat-x`, `repeat-y`, `repeat`       |
| `background-position`| Posición inicial de la imagen de fondo.            | `center`, `top left`, `50% 50%`, `10px 20px`        |
| `background-size` | Tamaño de la imagen de fondo.                      | `auto`, `cover`, `contain`, `50%`, `200px 100px`    |

### **4.4. Propiedades de Display (Disposición)** 🧱

La propiedad `display` es una de las más importantes para controlar el flujo de los elementos en la página.

| Propiedad     | Descripción                                                            | Valores Comunes                                            |
| :------------ | :--------------------------------------------------------------------- | :--------------------------------------------------------- |
| `block`       | El elemento ocupa todo el ancho disponible y comienza en una nueva línea (ej. `div`, `p`, `h1`). Permite configurar `width`, `height`, `margin`, `padding`. | `div { display: block; }`                                  |
| `inline`      | El elemento ocupa solo el espacio que necesita y no comienza en una nueva línea (ej. `span`, `a`, `img`). `width` y `height` no tienen efecto, `margin-top` y `margin-bottom` tampoco. | `span { display: inline; }`                                |
| `inline-block`| Como `inline`, pero permite configurar `width`, `height`, y `margin`/`padding` verticales. No comienza en una nueva línea. | `button { display: inline-block; padding: 10px; }`         |
| `none`        | El elemento se oculta por completo y no ocupa espacio en el layout.    | `div.oculto { display: none; }`                            |
| `flex`        | Convierte un elemento en un contenedor flex, habilitando un poderoso modelo de diseño unidimensional para sus hijos directos. | `div.contenedor { display: flex; }`                        |
| `grid`        | Convierte un elemento en un contenedor grid, habilitando un poderoso modelo de diseño bidimensional para sus hijos directos. | `div.galeria { display: grid; grid-template-columns: 1fr 1fr; }` |

### **4.5. Propiedades de Posicionamiento** 📍

La propiedad `position` te permite controlar la ubicación exacta de un elemento en la página, sacándolo del flujo normal del documento o ajustándolo con relación a otros.

| Propiedad   | Descripción                                                        | Valores             |
| :---------- | :----------------------------------------------------------------- | :------------------ |
| `position`  | Define el método de posicionamiento de un elemento.                | `static`, `relative`, `absolute`, `fixed`, `sticky` |
| `top`       | Posiciona el elemento desde el borde superior.                     | `10px`, `2em`, `25%` |
| `bottom`    | Posiciona el elemento desde el borde inferior.                     | `10px`, `2em`, `25%` |
| `left`      | Posiciona el elemento desde el borde izquierdo.                    | `10px`, `2em`, `25%` |
| `right`     | Posiciona el elemento desde el borde derecho.                      | `10px`, `2em`, `25%` |
| `z-index`   | Controla el orden de apilamiento de los elementos posicionados (qué elemento está "encima" de otro). | `auto`, `1`, `100`  |

**Valores Clave de `position`:**
* `static`: (Valor por defecto) El elemento sigue el flujo normal del documento. `top`, `bottom`, `left`, `right` no tienen efecto.
* `relative`: El elemento se posiciona con respecto a su posición original en el flujo normal. `top`, `bottom`, `left`, `right` lo mueven desde esa posición.
* `absolute`: El elemento se posiciona con respecto a su ancestro posicionado más cercano (que no sea `static`). Si no hay ancestro posicionado, se posiciona con respecto al `<body>`. Se retira del flujo normal.
* `fixed`: El elemento se posiciona con respecto a la ventana del navegador. Permanece fijo incluso al hacer scroll.
* `sticky`: Alterna entre `relative` y `fixed` dependiendo de la posición de scroll del usuario.


### **4.6. Flexbox (Modelo de Caja Flexible): ¡Para Layouts Responsivos!** ↔️↕️

Flexbox es un módulo de diseño unidimensional que permite organizar elementos en filas o columnas de manera muy eficiente, especialmente útil para distribuir espacio y alinear contenido.

| Propiedad en **Contenedor Flex** (`display: flex;`) | Descripción                                                         | Valores Clave                                           |
| :------------------------------------------------ | :------------------------------------------------------------------ | :------------------------------------------------------ |
| `flex-direction`                                 | Define la dirección principal del eje (horizontal o vertical).      | `row` (default), `column`, `row-reverse`, `column-reverse` |
| `justify-content`                                | Alinea ítems a lo largo del eje principal.                          | `flex-start`, `flex-end`, `center`, `space-between`, `space-around`, `space-evenly` |
| `align-items`                                    | Alinea ítems a lo largo del eje transversal.                        | `flex-start`, `flex-end`, `center`, `stretch`, `baseline` |
| `flex-wrap`                                      | Controla si los ítems deben ajustarse a la siguiente línea si no caben. | `nowrap` (default), `wrap`, `wrap-reverse`              |
| `gap` (o `column-gap`, `row-gap`)                | Espacio entre ítems flex.                                           | `10px`, `1em`                                           |

| Propiedad en **Ítems Flex** (Hijos del contenedor) | Descripción                                                         | Valores Clave                                         |
| :------------------------------------------------- | :------------------------------------------------------------------ | :---------------------------------------------------- |
| `flex-grow`                                        | Cuánto crecerá el ítem si hay espacio extra.                        | `0` (default), `1`, `2`                               |
| `flex-shrink`                                      | Cuánto se encogerá el ítem si no hay suficiente espacio.            | `1` (default), `0`                                    |
| `flex-basis`                                       | Tamaño inicial de un ítem antes de que el espacio restante se distribuya. | `auto` (default), `100px`, `20%`                      |
| `flex`                                             | Atajo para `flex-grow`, `flex-shrink`, `flex-basis`.                 | `1 1 auto`                                            |
| `align-self`                                       | Sobrescribe el `align-items` del contenedor para un ítem específico. | `auto`, `flex-start`, `flex-end`, `center`, `stretch`, `baseline` |

---

## 5. La Cascada y la Especificidad: ¿Por qué mis estilos no se aplican? 🌊

CSS se llama "Cascading" (en cascada) porque las reglas se "desbordan" y se combinan. Cuando múltiples reglas intentan estilizar el mismo elemento, CSS tiene un sistema para decidir cuál aplicar:

1.  **Origen:**
    * **Estilos del navegador (User Agent Stylesheets):** Los estilos por defecto que el navegador aplica (ej. los enlaces son azules y subrayados). Son la base sobre la que se construyen los demás estilos.
    * **Estilos del usuario (User Stylesheets):** Estilos que el usuario puede definir en su navegador para personalizar la visualización de las páginas (poco común en el uso diario, pero importante para la accesibilidad).
    * **Estilos del autor (Author Stylesheets):** ¡Tus estilos! Son la gran mayoría de las reglas CSS que escribes para tu sitio web.
    * **Estilos `!important`:** Una declaración con `!important` sobrescribe casi todo lo demás, independientemente de la especificidad. Se debe usar con mucha precaución y solo cuando es estrictamente necesario, ya que dificulta enormemente la depuración y el mantenimiento del CSS.

2.  **Especificidad:**
    Es el sistema de puntuación que CSS utiliza para decidir qué regla es "más importante" cuando varias reglas apuntan al mismo elemento. Una regla más específica anula una menos específica. La puntuación se calcula de la siguiente manera:

    * **IDs:** Tienen la mayor puntuación (se les asigna un valor de 100). Cada ID en un selector suma 100 puntos.
        * `#miElemento { ... }` -> Puntuación: (1,0,0)
    * **Clases, pseudo-clases, atributos:** Tienen una puntuación media (se les asigna un valor de 10). Cada clase, pseudo-clase o atributo en un selector suma 10 puntos.
        * `.miClase { ... }` -> Puntuación: (0,1,0)
        * `a:hover { ... }` -> Puntuación: (0,1,0)
        * `input[type="text"] { ... }` -> Puntuación: (0,1,0)
    * **Elementos, pseudo-elementos:** Tienen la menor puntuación (se les asigna un valor de 1). Cada etiqueta HTML o pseudo-elemento en un selector suma 1 punto.
        * `p { ... }` -> Puntuación: (0,0,1)
        * `::before { ... }` -> Puntuación: (0,0,1)

    * **Estilos en Línea:** Los estilos definidos directamente en el atributo `style=""` de una etiqueta HTML tienen la mayor especificidad de todas (equivalente a 1,0,0,0, o simplemente la más alta, anulando incluso IDs en hojas de estilo externas).

    **Orden de Especificidad (de mayor a menor impacto, si los orígenes son los mismos):**
    `Estilos en Línea` > `IDs` > `Clases / Atributos / Pseudo-clases` > `Elementos / Pseudo-elementos`

3.  **Orden de Declaración:**
    Si dos reglas tienen exactamente la misma especificidad (y provienen del mismo origen, por ejemplo, ambas son de tu hoja de estilos externa), la última regla declarada en el código CSS (o en el orden en que se cargan los archivos `<link>`) es la que "gana" y se aplica al elemento.

**Consejo Importante:** Entender la cascada y la especificidad es fundamental para depurar por qué un estilo no se está aplicando como esperas. Utiliza las herramientas de desarrollador de tu navegador (inspector de elementos) para ver qué estilos se están aplicando a un elemento, de dónde provienen y por qué se están sobrescribiendo o aplicando.

---

## 6. Un Truco Esencial: Las Clases para Agrupar Estilos (¡Recomendado!) ⭐

Olvídate de `style=""` en cada etiqueta HTML. La forma moderna y eficiente de trabajar con CSS es a través de las **clases**.

* **¿Cómo funciona?**
    1.  Define un conjunto de estilos en tu archivo `.css` bajo un nombre de clase (que empieza con un punto `.`):
        ```css
        .tarjeta-producto {
            border: 1px solid #ccc;
            padding: 15px;
            box-shadow: 2px 2px 5px rgba(0,0,0,0.1);
        }
        .texto-principal {
            font-size: 1.2em;
            color: #333;
        }
        ```
    2.  Luego, en tu HTML, simplemente añade el atributo `class` con el nombre de la clase (o clases, separadas por espacios) al elemento deseado:
        ```html
        <div class="tarjeta-producto">
            <h2 class="texto-principal">Mi Producto</h2>
            <p class="texto-principal">Descripción del producto.</p>
        </div>
        ```
* **Beneficios:**
    * **Mantenibilidad:** Si cambias un estilo en la clase CSS, se actualiza automáticamente en *todos* los elementos HTML que usan esa clase. Esto reduce errores y tiempo de desarrollo.
    * **Reutilización:** Define estilos una vez y úsalos en cualquier parte de tu HTML. Promueve un código más conciso y evita la duplicidad.
    * **Legibilidad:** Tu HTML se mantiene limpio y centrado en la estructura del contenido, no en la presentación. Esto mejora la comprensión y colaboración.
    * **Consistencia:** Aseguras que los elementos con la misma clase tengan el mismo aspecto en todo tu sitio, facilitando la creación de un diseño uniforme.
    * **Mejor práctica:** Es el método estándar y más profesional para aplicar estilos en el desarrollo web moderno, compatible con metodologías de desarrollo como BEM, OOCSS, etc.
---

## 📄 Metadatos del Documento

| Campo           | Detalles                                      |
| :-------------- |:----------------------------------------------|
| **Título** | Guia Rápida de CSS: Estilos y Presentación    |
| **Autor(es)** | Saul Echeverri                                |
| **Versión** | 1.0.0                                         |
| **Fecha de Creación** | 30 de Mayo de 2025                            |
| **Última Actualización** | 30 de Mayo de 2025                            |
| **Notas Adicionales**  | Documento base para referencia rápida de CSS. |

---


