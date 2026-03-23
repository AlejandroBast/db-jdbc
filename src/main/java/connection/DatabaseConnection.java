package connection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    private static String url;
    private static String user;
    private static String password;

    static {
        loadProperties();
    }

    private DatabaseConnection(){}

    private static void loadProperties(){

        Properties props = new Properties();

        try (InputStream is = DatabaseConnection.class.getClassLoader().getResourceAsStream("db.properties")){
            if(is == null){
                throw new RuntimeException("No se encontró el archivo db.properties");
            }

            props.load(is);

            url = props.getProperty("db.url");
            user = props.getProperty("db.user");
            password = props.getProperty("db.password");

        } catch (Exception e){
            throw new RuntimeException("Error cargando propiedades", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}