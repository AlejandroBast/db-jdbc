package mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.io.InputStream;
import java.util.Properties;

public class ConexionMongo {

    private static final String uri;
    private static final String nombreDb;
    private static final MongoClient cliente;

    static {
        Properties props = new Properties();
        try (InputStream is = ConexionMongo.class.getClassLoader().getResourceAsStream("mongo.properties")) {
            if (is == null) {
                throw new RuntimeException("No se encontro mongo.properties");
            }
            props.load(is);
            uri = props.getProperty("mongo.uri");
            nombreDb = props.getProperty("mongo.database");
            cliente = MongoClients.create(uri);
        } catch (Exception e) {
            throw new RuntimeException("Error al iniciar MongoDB", e);
        }
    }

    private ConexionMongo() {
    }

    public static MongoDatabase getDatabase() {
        return cliente.getDatabase(nombreDb);
    }
}
