import java.util.Scanner;

public class MenuInicio {
    private final MongoDBInitializer initializer;
    private final MongoDBQuery query;

    public MenuInicio(MongoDBInitializer initializer, MongoDBQuery query) {
        this.initializer = initializer;
        this.query = query;
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1. Borrar bases de datos");
            System.out.println("2. Insertar datos de ejemplo");
            System.out.println("3. Insertar usuario manualmente");
            System.out.println("4. Insertar orden manualmente");
            System.out.println("5. Consultar datos combinados");
            System.out.println("6. Consultar usuarios con sus órdenes (join)");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            // aquí se imprime un espacio
            System.out.println();

            switch (opcion) {
                case 1:
                    initializer.dropDatabases();
                    break;
                case 2:
                    initializer.setupDatabases();
                    break;
                case 3:
                    initializer.insertUsuarioManual(scanner);
                    break;
                case 4:
                    initializer.insertOrdenManual(scanner);
                    break;
                case 5:
                    query.showCombinedData();
                    break;
                case 6:
                    query.showUserWithOrders();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
            // aquí se imprime siempre un espacio, sin importar la opción
            System.out.println();
        } while (opcion != 0);

        scanner.close();
    }
}

