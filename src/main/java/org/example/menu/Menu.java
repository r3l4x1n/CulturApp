package org.example.menu;

import org.example.controladores.ControladorEmpresaCultural;
import org.example.controladores.ControladorEmpresaPrivada;
import org.example.controladores.ControladorUsuarioMembresia;
import org.example.controladores.ControladorUsuarioXEvento;
import org.example.entidades.Oferta;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Esta clase representa un menú de opciones para interactuar con la aplicación CulturApp.
 * Permite registrar usuarios que pagan por membresía, usuarios que pagan por evento,
 * empresas culturales y empresas privadas, además de consultar los registros existentes.
 */
public class Menu {

    /**
     * Método principal que muestra un menú interactivo y gestiona la interacción del usuario
     * con la aplicación CulturApp.
     */
    public static void menu(){
        ControladorUsuarioMembresia controladorUsuarioMembresia = new ControladorUsuarioMembresia();
        ControladorUsuarioXEvento controladorUsuarioXEvento= new ControladorUsuarioXEvento();
        ControladorEmpresaCultural controladorEmpresaCultural = new ControladorEmpresaCultural();
        ControladorEmpresaPrivada controladorEmpresaPrivada = new ControladorEmpresaPrivada();
        Scanner scanner = new Scanner(System.in);
        String nombre = "Ingrese el nombre";
        String n;
        String documento = "Ingrese el documento";
        String d;
        String correo = "Ingrese el correo electronico";
        String c;
        String ubicacion = "Ingrese la ubicacion";
        String u;
        String costoMensual = "Ingrese el costo mensual que paga el usuario";
        Double cos;
        String invitado = "En caso de que desee referencia a alguien ingrese la cedula, en el caso " +
                "contrario ingrese el numero cero '0'";
        //Integer i;
        String i;
        String nit = "Ingrese el nit de la empresa";
        String ni;
        String descripcion = "Ingrese la descripcion de la empresa";
        String des;

        Integer opcionMenu;

        do{
            System.out.println("""
               ------Bienvenido a CulturApp------
                -------------------------------
                Este es nuestro menú:
                
                1. Registrar un usuario que paga por membresía
                2. Ver los usuarios que pagan por membresía registrados
                3. Registrar un usuario que paga por evento
                4. Ver los usuarios que pagan por evento registrados en la base de datos
                5. Registrar una empresa cultural
                6. Ver las empresas culturales registradas en la base de datos
                7. Registrar una empresa privada
                8. Ver las empresas privadas registradas en la base de datos
                0. Salir del menú""");
            opcionMenu = scanner.nextInt();
            switch (opcionMenu) {
                case 1 -> {
                    System.out.println("Ingrese los siguiente datos para registrar el usuario que paga por membresía");
                    System.out.println(nombre);
                    scanner.nextLine();
                    n = scanner.nextLine();

                    System.out.println(documento);
                    d = scanner.next();
                    System.out.println(correo);
                    c = scanner.next();
                    System.out.println(ubicacion);
                    u = scanner.next();
                    System.out.println(costoMensual);
                    cos = scanner.nextDouble();
                    System.out.println(invitado);
                    //i = scanner.nextInt();
                    i = scanner.next();
                    controladorUsuarioMembresia.agregarUsuario(n, d, c, u, cos, String.valueOf(i));
                    menu();
                    scanner.close();
                }
                case 2 -> {
                    System.out.println("Estos son los usuarios que pagan por membresía registrados");
                    controladorUsuarioMembresia.consultarUsuario();
                    menu();
                }
                case 3 -> {
                    System.out.println("Ingrese los siguiente datos para registrar el usuario que paga por evento");
                    System.out.println(nombre);
                    scanner.nextLine();
                    n = scanner.nextLine();
                    System.out.println(documento);
                    d = scanner.next();
                    System.out.println(correo);
                    c = scanner.next();
                    System.out.println(ubicacion);
                    u = scanner.next();
                    System.out.println("Ingrese el costo por evento");
                    Double dd = scanner.nextDouble();
                    controladorUsuarioXEvento.agregarUsuario(n, d, c, u, dd );
                    menu();
                }
                case 4 -> {
                    System.out.println("Estos son los usuarios que pagan por evento");
                    controladorUsuarioXEvento.consultarUsuario();
                    menu();
                }
                case 5 -> {
                    System.out.println("Ingrese los siguientes datos para registrar la empresa cultural");
                    System.out.println(nombre);
                    scanner.nextLine();
                    n = scanner.nextLine();
                    System.out.println(descripcion);
                    des = scanner.nextLine();
                    System.out.println(nit);
                    ni = scanner.next();
                    System.out.println(ubicacion);
                    u = scanner.next();
                    System.out.println("Ingrese el nombre de la entidad a la que pertenece");
                    scanner.nextLine();
                    String entidad = scanner.nextLine();
                    System.out.println("Ingrese la misión de su empresa");
                    String mision = scanner.nextLine();
                    System.out.println("Ingrese el email del responsable");
                    c = scanner.next();
                    System.out.println("Ingrese el numero de contecto del responsable");
                    String numero = scanner.next();
                    controladorEmpresaCultural.agregarEmpresa(ni, n, u, des, entidad, c, numero, mision);
                    menu();
                }
                case 6 -> {
                    System.out.println("Estos son las empresas culturales registradas");
                    controladorEmpresaCultural.consultarEmpresa();
                    menu();
                }
                case 7 -> {
                    System.out.println("Ingrese los siguientes datos para registrar la empresa privada");
                    System.out.println(nombre);
                    scanner.nextLine();
                    n = scanner.nextLine();
                    System.out.println(descripcion);

                    des = scanner.nextLine();
                    System.out.println(nit);
                    ni = scanner.next();
                    System.out.println(ubicacion);
                    scanner.nextLine();
                    u = scanner.nextLine();
                    System.out.println("Ingrese el nombre del representante legal");
                    String rep = scanner.nextLine();
                    System.out.println("Ingrese la cedula del representante legal");
                    String cedula = scanner.next();
                    controladorEmpresaPrivada.agregarEmpresa(ni, n, u, des, rep, cedula);
                    menu();
                }
                case 8 -> {
                    System.out.println("Estas son las empresas privadas registradas en la base de datos");
                    controladorEmpresaPrivada.consultarEmpresa();
                    menu();
                }
                case 0 ->{
                    System.out.println("Hasta luego!!");
                    scanner.close();
                }
                default -> {
                    System.out.println("Ingrese una opcion valida");
                }
            }
        } while (opcionMenu != 0);

    }
}
