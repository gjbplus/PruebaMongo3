import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class Main {

    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        MongoDBInitializer initializer = new MongoDBInitializer(mongoClient);
        MongoDBQuery query = new MongoDBQuery(mongoClient);

        MenuInicio menu = new MenuInicio(initializer, query);
        menu.mostrarMenu();

        mongoClient.close();
    }
}
