package mongo;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class CrudHospitalService {

    private final MongoDatabase database;

    public CrudHospitalService() {
        this.database = ConexionMongo.getDatabase();
    }

    public void crear(String coleccion, String id, String nombre) {
        MongoCollection<Document> col = database.getCollection(coleccion);

        Document doc = new Document("id", id)
                .append("nombre", nombre);

        col.insertOne(doc);
        System.out.println("Registro creado");
    }

    public List<Document> listar(String coleccion) {
        MongoCollection<Document> col = database.getCollection(coleccion);
        return col.find().into(new ArrayList<>());
    }

    public void actualizar(String coleccion, String id, String nuevoNombre) {
        MongoCollection<Document> col = database.getCollection(coleccion);

        long cambios = col.updateOne(Filters.eq("id", id), Updates.set("nombre", nuevoNombre)).getModifiedCount();

        if (cambios == 0) {
            System.out.println("No se encontro registro con ese id");
            return;
        }

        System.out.println("Registro actualizado");
    }

    public void eliminar(String coleccion, String id) {
        MongoCollection<Document> col = database.getCollection(coleccion);

        long eliminados = col.deleteOne(Filters.eq("id", id)).getDeletedCount();

        if (eliminados == 0) {
            System.out.println("No se encontro registro con ese id");
            return;
        }

        System.out.println("Registro eliminado");
    }
}
