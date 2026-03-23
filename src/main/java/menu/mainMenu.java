package menu;

import dao.StudentDAO;
import model.Student;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class mainMenu {

    private final Scanner scanner = new Scanner(System.in);
    private final StudentDAO studentDAO = new StudentDAO();

    public void start(){

        int option;

        do {

            System.out.println("\n===== MENU ESTUDIANTES =====");
            System.out.println("1. Insertar estudiante");
            System.out.println("2. Listar estudiantes");
            System.out.println("3. Eliminar estudiante");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch(option){

                case 1 -> insertStudent();
                case 2 -> listStudents();
                case 3 -> deleteStudent();
                case 4 -> editStudent();

                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida");

            }

        } while(option != 0);

    }

    private void insertStudent(){

        try{

            Student student = new Student();

            System.out.print("Nombre: ");
            student.setName(scanner.nextLine());

            System.out.print("Apellido: ");
            student.setLastname(scanner.nextLine());

            System.out.print("Email: ");
            student.setEmail(scanner.nextLine());

            System.out.print("ID de carrera: ");
            student.setCareerId(scanner.nextInt());
            scanner.nextLine();

            studentDAO.insert(student);

            System.out.println("Estudiante insertado con ID: " + student.getId());

        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    private void listStudents(){

        try{

            List<Student> students = studentDAO.listAll();

            System.out.println("\n===== LISTA DE ESTUDIANTES =====");

            for(Student s : students){

                System.out.println(
                        s.getId() + " - " +
                                s.getName() + " " +
                                s.getLastname() +
                                " | Email: " + s.getEmail() +
                                " | Carrera ID: " + s.getCareerId()
                );

            }

        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    private void deleteStudent(){
        try {

            System.out.println("Ingrese el id del estudiante a eliminar: ");
            int idEliminar = scanner.nextInt();
            studentDAO.detele(idEliminar);

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void editStudent(){

        try{

            Student student = new Student();

            System.out.print("Nombre: ");
            student.setName(scanner.nextLine());

            System.out.print("Apellido: ");
            student.setLastname(scanner.nextLine());

            System.out.print("Email: ");
            student.setEmail(scanner.nextLine());

            System.out.print("ID de carrera: ");
            student.setCareerId(scanner.nextInt());
            scanner.nextLine();

            studentDAO.insert(student);

            System.out.println("Estudiante insertado con ID: " + student.getId());

        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}