package menu;

import mongo.CrudHospitalService;
import org.bson.Document;

import java.util.List;
import java.util.Scanner;

public class MenuHospital {

    private final Scanner scanner = new Scanner(System.in);
    private final CrudHospitalService service = new CrudHospitalService();

    public void iniciar() {
        int opcion;

        do {
            System.out.println("\n===== MENU HOSPITAL MONGODB =====");
            System.out.println("1. CRUD Consultas");
            System.out.println("2. CRUD Habitaciones");
            System.out.println("3. CRUD Hospitalizaciones");
            System.out.println("4. CRUD Medicos");
            System.out.println("5. CRUD Pacientes");
            System.out.println("6. CRUD Tratamientos");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1 -> menuCrud("Consultas");
                case 2 -> menuCrud("Habitaciones");
                case 3 -> menuCrud("Hospitalizaciones");
                case 4 -> menuCrud("Medicos");
                case 5 -> menuCrud("Pacientes");
                case 6 -> menuCrud("Tratamientos");
                case 0 -> System.out.println("Hasta luego");
                default -> System.out.println("Opcion invalida");
            }
        } while (opcion != 0);
    }

    private void menuCrud(String coleccion) {
        int opcion;

        do {
            System.out.println("\n--- " + coleccion + " ---");
            System.out.println("1. Crear");
            System.out.println("2. Listar");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("0. Volver");
            System.out.print("Elige una opcion: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1 -> crear(coleccion);
                case 2 -> listar(coleccion);
                case 3 -> actualizar(coleccion);
                case 4 -> eliminar(coleccion);
                case 0 -> System.out.println("Regresando");
                default -> System.out.println("Opcion invalida");
            }
        } while (opcion != 0);
    }

    private void crear(String coleccion) {
        System.out.print("Id: ");
        String id = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        service.crear(coleccion, id, nombre);
    }

    private void listar(String coleccion) {
        List<Document> docs = service.listar(coleccion);

        if (docs.isEmpty()) {
            System.out.println("No hay registros");
            return;
        }

        for (Document doc : docs) {
            System.out.println(doc.toJson());
        }
    }

    private void actualizar(String coleccion) {
        System.out.print("Id a actualizar: ");
        String id = scanner.nextLine();

        System.out.print("Nuevo nombre: ");
        String nuevoNombre = scanner.nextLine();

        service.actualizar(coleccion, id, nuevoNombre);
    }

    private void eliminar(String coleccion) {
        System.out.print("Id a eliminar: ");
        String id = scanner.nextLine();

        service.eliminar(coleccion, id);
    }

    private int leerEntero() {
        while (true) {
            try {
                int valor = Integer.parseInt(scanner.nextLine());
                return valor;
            } catch (Exception e) {
                System.out.print("Ingresa un numero valido: ");
            }
        }
    }
}
