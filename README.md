```markdown
# Proyecto PruebaMongo3

Aplicación de consola en **Java 21** con **Maven** que se conecta a **MongoDB** y permite 
gestionar usuarios y órdenes mediante un menú interactivo.

---

## 🚀 Requisitos

- **Java 21** instalado
- **Maven** instalado
- **MongoDB** corriendo en `localhost:27017`

---

## 📂 Estructura del proyecto

```text
PruebaMongo3/
├── pom.xml
└── src/
    └── main/
        └── java/
            ├── Main.java
            ├── MenuInicio.java
            ├── MongoDBInitializer.java
            └── MongoDBQuery.java
```

---

## ▶️ Ejecución desde terminal

1. Clonar el repositorio o descomprimir el proyecto.
2. Asegurarse de que MongoDB esté corriendo en `localhost:27017`.
3. Desde la raíz del proyecto, ejecutar:

```bash
mvn compile exec:java -Dexec.mainClass="Main"
```
## 💻 Ejecución en IntelliJ IDEA

1. Abrir **IntelliJ IDEA** y seleccionar **File → Open...**  
   Elegir la carpeta `PruebaMongo3` clonada.  
   IntelliJ detectará automáticamente el proyecto Maven.

2. **Configurar SDK**  
   Ir a **File → Project Structure → Project SDK** y seleccionar **Java 21**.

3. **Verificar dependencias Maven**  
   Si no se descargan automáticamente, clic derecho en `pom.xml` → **Add as Maven Project**.

4. **Ejecutar la aplicación**  
   Asegurarse de que **MongoDB** esté corriendo en `localhost:27017`.  
   Ir a `Main.java`, clic derecho → **Run 'Main.main()'**.

---

## 📖 Funcionalidades del menú

Al iniciar el programa se muestra un menú con las siguientes opciones:

1. **Borrar bases de datos** → elimina las bases `clientes` y `ventas`.
2. **Insertar datos de ejemplo** → carga usuarios y órdenes predefinidos.
3. **Insertar usuario manualmente** → permite ingresar un nuevo usuario desde consola.
4. **Insertar orden manualmente** → permite ingresar una nueva orden asociada a un usuario.
5. **Consultar datos combinados** → muestra usuarios junto con sus órdenes.
6. **Consultar usuarios con sus órdenes (join)** → genera un JSON con cada usuario y todas sus órdenes.
0. **Salir** → termina la aplicación.

---

## 🧩 Responsabilidades de cada clase

- **Main.java**  
  Punto de entrada del programa. Crea la conexión a MongoDB, inicializa las clases y lanza el menú.

- **MenuInicio.java**  
  Gestiona la interacción con el usuario mediante un menú en consola.  
  Se encarga de capturar la opción elegida y llamar al método correspondiente en las otras clases.

- **MongoDBInitializer.java**  
  Responsable de preparar y gestionar las bases de datos:
    - Borrar (`dropDatabases`)
    - Insertar datos de ejemplo (`setupDatabases`)
    - Insertar usuarios manualmente (`insertUsuarioManual`)
    - Insertar órdenes manualmente (`insertOrdenManual`)

- **MongoDBQuery.java**  
  Responsable de las consultas:
    - Mostrar datos combinados (`showCombinedData`)
    - Mostrar usuarios con sus órdenes en formato JSON (`showUserWithOrders`)

---

## 📦 Dependencias principales

Definidas en `pom.xml`:

- **MongoDB Driver Sync** (`org.mongodb:mongodb-driver-sync:5.1.1`)  
  Para conectarse y trabajar con MongoDB.

- **SLF4J API + Simple** (`org.slf4j:slf4j-api` y `slf4j-simple`)  
  Para manejar logs de manera sencilla en consola.

---

## ✨ Ejemplo de uso

```
=== MENÚ PRINCIPAL ===
1. Borrar bases de datos
2. Insertar datos de ejemplo
3. Insertar usuario manualmente
4. Insertar orden manualmente
5. Consultar datos combinados
6. Consultar usuarios con sus órdenes (join)
0. Salir
Elige una opción: 2
Datos de ejemplo insertados.

Elige una opción: 5
Usuario: Juan Pérez | Orden Nº: 101 | Producto: Laptop
Usuario: María Gómez | Orden Nº: 102 | Producto: Teléfono
```

---

## 👥 Autor

Este proyecto fue desarrollado por **Guillermo Jaurena**, como práctica y aprendizaje de **Java + MongoDB** con Maven.  
El diseño y la implementación fueron realizados íntegramente por el autor, contando con asistencia de **Microsoft Copilot** para la organización del código, documentación y buenas prácticas.

---

## 📌 Nota

El objetivo principal de este proyecto es servir como ejemplo educativo de integración entre **Java** y **MongoDB**, utilizando un menú interactivo en consola para gestionar usuarios y órdenes.  
No está destinado a producción, sino a fines de estudio y experimentación.

