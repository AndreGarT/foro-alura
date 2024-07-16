# Introducción

Foro Alura es una plataforma API REST desarrollada con Spring Boot, diseñada para facilitar la gestión de tópicos en una comunidad virtual.
Permite a los usuarios autenticarse, crear, listar y eliminar tópicos de discusión de manera eficiente y segura mediante autentificación JWT.

# Pre requisitos

## Variables de Entorno

Deberás agregar las siguientes variables de entorno para que la aplicación pueda funcionar. A continuación, el nombre que cada variable de entorno debe tener:

| VARIABLE       | DESCRIPCIÓN                           |
|----------------|---------------------------------------|
| USER_MYSQL     | usuario de la base de datos           |
| PASS_MYSQL     | password de acceso a la base de datos |
| JWT_SECRET     | tu key para ser usado en JWT          |

## Instalación y Ejecución

1. **Clonar el repositorio**:
    ```sh
    git clone https://github.com/AndreGarT/foro-alura.git
    ```

2. **Navegar al directorio del proyecto**:
    ```sh
    cd apiforo
    ```
3. **Creacion de la base de datos**: Crear base de datos llamada literalura (para el challengue se utilizó PostgreSQL)
   ```sh
    CREATE DATABASE foro_alura
    ```
   
4. **Configurar la base de datos**: En caso no quieras configurar las variables de entorno. Asegúrate de configurar tu archivo `application.properties` con las credenciales correctas para la conexión a la base de datos.
   Solo reemplaza las variables con tus credenciales.
   
5. **Compilar y ejecutar la aplicación**:


# Para probar la API REST

## Agregar registros a tabla de usuarios
    ```sh
    INSERT INTO `foro_alura`.`usuarios` (`nombre`, `correo`, `contrasena`) VALUES ('usuario', 'usuario@alura.foro', '$2a$10$JZpsi8L8IlS77lnjHFcHau.uHaB0sTh7RHGXEOuD2Gm1ForWJJsIW');
    ```
    Las credenciales de ese usuario son : 
      ```sh
       {
         "nombre":"usuario",
         "contrasena":"123456"
       }
      ```
# End Points disponibles

- **Nuevo Topico**: http://localhost:8080/topicos - Metodo POST
    Json de ejemplo para nuevo topico:
    ```sh
      {
         "idUsuario": "1",
         "mensaje":"Curso de React js",
         "curso":"REACT",
         "titulo":"React para ingenieros"
      }
     ```

    Los cursos disponibles al momento de agregar son: REACT, JAVA, SPRINGBOOT y JAVASCRIPT.
  
- **Listar Topicos**: http://localhost:8080/topicos?sort=fecha&page=0 - Metodo GET
- **Eliminar Topico**: http://localhost:8080/topicos/{id} - Metodo DELETE
- **Buscar Topico por ID**: http://localhost:8080/topicos/{id} - Metodo GET
- **Editar Topico**: http://localhost:8080/topicos/{id} - Metodo PUT
- **Login**: http://localhost:8080/login - Metodo POST

**NO OLVIDAR**: Poner el token generado cuando te autenticas, en cada peticion que deseas realizar, en la pestaña de Autorizacion Bearer Token

