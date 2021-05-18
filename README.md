# Conexión a Base de Datos con JDBC
## Motor de BD utilizada [**SQLite**](https://www.sqlite.org/index.html)

![JAVA-->JDBC](https://raw.githubusercontent.com/jsamperevazquez/AngelBD/master/src/com/angel/bd/imagenes/jdbc.jpg)


### Estructura del proyecto

1. Acceso
    - Conexion
 
2. Entidades
    - Clientes
    - Vehiculos
    - Venta
    
3. Imagenes

4. Negocio
    - ClienteBL
    - VehiculoBL
    - VentaBL
    
### Base de Datos de Ángel
Tenemos una base de datos relacional, compuesta por tres tablas que se relacionan entre sí de la siguiente manera:
![Angel-->BD](https://raw.githubusercontent.com/jsamperevazquez/AngelBD/master/src/com/angel/bd/imagenes/AngelBD.png)

### SQLlite
SQLite es un sistema de gestión de bases de datos relacional compatible con ACID, contenida en una relativamente pequeña ​ biblioteca escrita en C.

### JDBC
API que permite la ejecución de operaciones sobre bases de datos desde el lenguaje de programación Java, independientemente del sistema operativo donde se ejecute o de la base de datos a la cual se accede, utilizando el dialecto SQL del modelo de base de datos que se utilice.
[Driver JDBC SQLite](https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc/3.34.0)
