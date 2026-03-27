import com.mongodb.client.*;
import org.bson.Document;
import java.util.ArrayList;

public class MongoDBQuery {
    private final MongoDatabase dbClientes;
    private final MongoDatabase dbVentas;

    public MongoDBQuery(MongoClient mongoClient) {
        this.dbClientes = mongoClient.getDatabase("clientes");
        this.dbVentas = mongoClient.getDatabase("ventas");
    }

    // Opción 5: consulta combinada
    public void showCombinedData() {
        MongoCollection<Document> usuarios = dbClientes.getCollection("usuarios");
        MongoCollection<Document> ordenes = dbVentas.getCollection("ordenes");

        for (Document orden : ordenes.find()) {
            Integer usuarioId = orden.getInteger("usuarioId");
            Document usuario = usuarios.find(new Document("_id", usuarioId)).first();

            if (usuario != null) {
                System.out.println("Usuario: " + usuario.getString("nombre") +
                        " | Orden Nº: " + orden.getInteger("numero") +
                        " | Producto: " + orden.getString("producto"));
            } else {
                System.out.println("Orden sin usuario asociado: " + orden.toJson());
            }
        }
    }

    // Opción 6: consulta tipo join
    public void showUserWithOrders() {
        MongoCollection<Document> usuarios = dbClientes.getCollection("usuarios");
        MongoCollection<Document> ordenes = dbVentas.getCollection("ordenes");

        for (Document usuario : usuarios.find()) {
            Integer userId = usuario.getInteger("_id");
            var userOrders = ordenes.find(new Document("usuarioId", userId)).into(new ArrayList<>());

            Document combined = new Document("usuario", usuario)
                    .append("ordenes", userOrders);

            System.out.println(combined.toJson());
        }
    }
}

