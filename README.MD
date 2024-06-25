# BackPack 📚🎒

Bienvenido a la documentación de la aplicación BackPack. A continuación, se proporciona el manual de usuario de la aplicación, así como una guía detallada sobre su uso y un enlace para su instalación. También se explican detalladamente los endpoints de la API, sus funcionalidades, tipos de entidad y métodos. Además, se incluyen ejemplos para facilitar la implementación de cada endpoint.

### Contenidos

##### Manual de usuario

- 🏠 Welcome page
- 📜 Remember page
- 🔑 Login
- 📝 Register
- 🏠 Homepage
- 👤 Profile
- ⭐ Favorites
- ⚠️ Report
- 📤 Add material
- 🚀 Nav bar

##### Post

##### User

##### Materias

##### Usos de Endpoints

- 🔍 GET
- ➕ POST
- 🛠️ PATCH
- 🗑️ DELETE

## Manual de usuario 📘

Para instalar nuestra aplicación debes ingresar al siguiente enlace: Enlace de descarga. Este enlace te dirigirá al sitio donde puedes instalar el APK de la aplicación BackPack.

## 🏠 Welcome

El apartado de bienvenida le muestra al usuario una introducción a BackPack. Aquí, los usuarios nuevos pueden comenzar a familiarizarse con la aplicación.

## 📜 Remember

Este apartado le muestra al usuario de qué consta BackPack y cómo puede ser útil para sus necesidades educativas y de gestión de materiales.

## 🔑 Login

En este apartado, debes iniciar sesión en BackPack. Si no tienes una cuenta, tendrás que registrarte proporcionando la información precisa que te pida el formulario.

## 📝 Register

En este apartado, debes rellenar cada campo del formulario con la información necesaria. Cuando te hayas asegurado de que la información es correcta, encontrarás un botón con un icono de "+" para registrarte en BackPack y otro botón con el icono de un basurero para borrar todo el formulario si es necesario.

## 🏠 Homepage

En la parte superior de la pantalla, hay un buscador donde puedes filtrar las materias que aparecen por su nombre. A continuación, verás un mosaico con las categorías disponibles (materias).

## 👤 Profile

En este apartado, el usuario verá su foto de perfil y la información personal que completó en el formulario de registro. Aquí aparecerán el nombre, carrera, número de materiales marcados como favoritos, contribuciones, correo electrónico y carrera. También hay un botón para desvincular la cuenta del usuario de la aplicación.

## ⭐ Favorites

En este apartado, también hay una sección de búsqueda donde el usuario puede filtrar la información por materia. En la página principal de favoritos, solo aparecerán las publicaciones que el usuario haya marcado con un corazón.

## ⚠️ Report

En este apartado, la parte superior proporciona la información necesaria para identificar la publicación que el usuario está reportando. Luego, aparecerá un formulario con textos que el usuario puede seleccionar según considere que la publicación incumple. Finalmente, debe presionar el botón enviar para hacer la petición de reporte.

## 📤 Add material

En este apartado, el usuario debe rellenar cuatro campos para validar la subida del archivo: título del material, año del material, ciclo del material y una breve descripción del contenido del documento. Al presionar "Select file", se abrirá el explorador de archivos para seleccionar el archivo a subir. Después de seleccionar el archivo, el usuario debe presionar el botón de "Subir publicación" para que su publicación sea visible al público.

# 🚀 Nav bar

Esta herramienta contiene cuatro iconos:

- 🏠: Redirige a la Home Page.
- 📝: Contiene los materiales que el usuario ha subido.
- ⭐: Redirige a la pantalla donde están las publicaciones marcadas como favoritas.
- 👤: Redirige a la pantalla donde se puede visualizar el perfil de usuario.

# API End points 🌐

### Post 📝

| Endpoint                                      | Funcionalidad                    | Entidad | Tipo de Endpoint           | Método |
| --------------------------------------------- | -------------------------------- | ------- | -------------------------- | ------ |
| http://domain/api/post/                       | Obtener todos los posts          | Post    | Consumo                    | GET    |
| http://domain/api/post/own                    | Obtener los posts propios        | Post    | Consumo                    | GET    |
| http://domain/api/post/saved                  | Obtener los posts favoritos      | Post    | Consumo                    | GET    |
| http://domain/api/post/user/:identifier       | Obtener los posts de un usuario  | Post    | Consumo                    | GET    |
| http://domain/api/post/subject/:identifier    | Obtener los posts de una materia | Post    | Consumo                    | GET    |
| http://domain/api/post/:identifier            | Obtener un post por id           | Post    | Consumo                    | GET    |
| http://domain/api/post/                       | Guardar/Crear un post            | Post    | Creación y Mantenimiento   | POST   |
| http://domain/api/post/visibility/:identifier | Hacer visible/invisible un post  | Post    | Modificación e Interacción | PATCH  |
| http://domain/api/post/like/:identifier       | Dar like a un post               | Post    | Modificación e Interacción | PATCH  |
| http://domain/api/post/save/:identifier       | Dar favorito a un post           | Post    | Modificación e Interacción | PATCH  |
| http://domain/api/post/comment/:identifier    | Comentar un post                 | Post    | Modificación e Interacción | PATCH  |
| http://domain/api/post/:identifier            | Borrar un post                   | Post    | Eliminar                   | DELETE |

#### Usos

Obtener todos los post

<pre>GET http://domain/api/post/</pre>

Respuesta:

 <pre>[
    {
        "id": 1,
        "title": "Post de ejemplo",
        "content": "Contenido del post...",
        "author": "Usuario1"
    }
]
</pre>

Obtener los post favoritos

<pre>GET http://domain/api/post/saved
Authorization: Bearer <token>
</pre>

Respuesta:

<pre>[
    {
        "id": 3,
        "title": "Post favorito",
        "content": "Contenido favorito...",
        "author": "Usuario2"
    }
]
</pre>

Obtener los post de una materia:

<pre>GET http://domain/api/post/subject/456</pre>

Respuesta:

<pre>[
    {
        "id": 5,
        "title": "Post de Materia 456",
        "content": "Contenido...",
        "subject": "Materia456"
    }
]
</pre>

### Crear post ➕

<pre>POST http://domain/api/post/
Content-Type: application/json
Authorization: Bearer <token>
</pre>

#### Cuerpo de solicitud:

<pre>{
    "title": "Nuevo post",
    "content": "Contenido del nuevo post...",
    "author": "Usuario789"
}
</pre>

Respuesta:

 <pre>{
    "id": 7,
    "title": "Nuevo post",
    "content": "Contenido del nuevo post...",
    "author": "Usuario789"
}
</pre>

### User 👤

| Endpoint                        | Functionality            | Entity | Endpoint Type            | Method |
| ------------------------------- | ------------------------ | ------ | ------------------------ | ------ |
| http://domain/api/auth/register | Registrarse              | User   | Creación y Mantenimiento | POST   |
| http://domain/api/auth/login    | Inicio de sesión         | User   | Creación y Mantenimiento | POST   |
| http://domain/api/auth/whoami   | Obtener datos de usuario | User   | Consumo                  | GET    |

## Ejemplos de uso:

### Registrarse 📝

<pre>POST http://domain/api/auth/register
Content-Type: application/json
</pre>

Cuerpo de la solicitud:

<pre>{
    "username": "nuevo_usuario",
    "password": "contraseña_segura"
}
</pre>

Respuesta:

<pre>{
    "id": 1,
    "username": "nuevo_usuario",
    "token": "<token>"
}
</pre>

### Inicio de sesion 🔑

<pre>POST http://domain/api/auth/login
Content-Type: application/json
</pre>

Cuerpo de solicitud:

<pre>{
    "username": "usuario_existente",
    "password": "contraseña"
}
</pre>

Respuesta:

<pre>{
    "id": 1,
    "username": "usuario_existente",
    "token": "<token>"
}
</pre>

### Materias 📚

| Endpoint                         | Functionality                    | Entity   | Endpoint Type            | Method |
| -------------------------------- | -------------------------------- | -------- | ------------------------ | ------ |
| http://domain/api/subject/       | Obtener todas las materias       | Materias | Consumo                  | GET    |
| http://domain/api/subject/degree | Obtener las materias por carrera | Materias | Consumo                  | GET    |
| http://domain/api/subject/       | Guardar/Crear una materia        | Materias | Creación y Mantenimiento | POST   |

### Ejemplos de uso:

Obtener todas las materias:

<pre>GET http://domain/api/subject/</pre>

Respuesta:

<pre>[
    {
        "id": 1,
        "name": "Matemáticas",
        "degree": "Ingeniería"
    }
]
</pre>

Guardar materias:

<pre>POST http://domain/api/subject/
Content-Type: application/json
Authorization: Bearer <token>
</pre>

Cuerpo de solicitud:

<pre>{
    "name": "Física",
    "degree": "Ingeniería"
}
</pre>

Respuesta:

<pre>{
    "id": 2,
    "name": "Física",
    "degree": "Ingeniería"
}
</pre>

## Solicitudes PATCCH:

Marcar post como favorito:

<pre>PATCH http://domain/api/post/save/10
Authorization: Bearer <token>
</pre>

Borrar POST

<pre>DELETE http://domain/api/post/12
Authorization: Bearer <token>
</pre>

### Forma de uso

Para usar cualquiera de estos endpoints, debes realizar solicitudes HTTP a las URLs indicadas con los métodos HTTP apropiados (GET, POST, PATCH o DELETE). Asegúrate de incluir cualquier parámetro necesario tal como se especifica en la descripción del endpoint.

### Importante

- Asegúrate de tener la autenticación adecuada para acceder a los endpoints protegidos.
- Reemplaza :identifier con los identificadores reales al usar los endpoints.
- Los métodos POST, PATCH, y DELETE pueden requerir un payload o datos en el cuerpo; consulta las directrices específicas de la API para estos requisitos.
