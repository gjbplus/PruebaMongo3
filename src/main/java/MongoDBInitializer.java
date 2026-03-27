import com.mongodb.client.*;
import org.bson.Document;
import java.util.Scanner;

public class MongoDBInitializer {
    private final MongoClient mongoClient;

    public MongoDBInitializer(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    // Opción 1: borrar bases
    public void dropDatabases() {
        mongoClient.getDatabase("clientes").drop();
        mongoClient.getDatabase("ventas").drop();
        System.out.println("Bases de datos borradas.");
    }

    // Opción 2: insertar datos de ejemplo
    public void setupDatabases() {
        MongoDatabase dbClientes = mongoClient.getDatabase("clientes");
        MongoDatabase dbVentas = mongoClient.getDatabase("ventas");

        MongoCollection<Document> usuarios = dbClientes.getCollection("usuarios");
        MongoCollection<Document> ordenes = dbVentas.getCollection("ordenes");

        if (usuarios.countDocuments() == 0) {
            usuarios.insertOne(new Document("_id", 1)
                    .append("nombre", "Juan Pérez")
                    .append("email", "juan@example.com")
                    .append("edad", 30));
            usuarios.insertOne(new Document("_id", 2)
                    .append("nombre", "María Gómez")
                    .append("email", "maria@example.com")
                    .append("edad", 25));
        }

        if (ordenes.countDocuments() == 0) {
            ordenes.insertOne(new Document("numero", 101)
                    .append("producto", "Laptop")
                    .append("precio", 1200)
                    .append("usuarioId", 1));
            ordenes.insertOne(new Document("numero", 102)
                    .append("producto", "Teléfono")
                    .append("precio", 800)
                    .append("usuarioId", 2));
        }

        System.out.println("Datos de ejemplo insertados.");
    }

    // Opción 3: insertar usuario manualmente
    public void insertUsuarioManual(Scanner scanner) {
        MongoDatabase dbClientes = mongoClient.getDatabase("clientes");
        MongoCollection<Document> usuarios = dbClientes.getCollection("usuarios");

        System.out.print("Ingrese ID del usuario: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese email: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese edad: ");
        int edad = scanner.nextInt();

        usuarios.insertOne(new Document("_id", id)
                .append("nombre", nombre)
                .append("email", email)
                .append("edad", edad));

        System.out.println("Usuario insertado correctamente.");
    }

    // Opción 4: insertar orden manualmente
    public void insertOrdenManual(Scanner scanner) {
        MongoDatabase dbVentas = mongoClient.getDatabase("ventas");
        MongoCollection<Document> ordenes = dbVentas.getCollection("ordenes");

        System.out.print("Ingrese número de orden: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese producto: ");
        String producto = scanner.nextLine();
        System.out.print("Ingrese precio: ");
        int precio = scanner.nextInt();
        System.out.print("Ingrese usuarioId asociado: ");
        int usuarioId = scanner.nextInt();

        ordenes.insertOne(new Document("numero", numero)
                .append("producto", producto)
                .append("precio", precio)
                .append("usuarioId", usuarioId));

        System.out.println("Orden insertada correctamente.");
    }
}
