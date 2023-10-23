package org.example;

import org.example.modelos.Empresa;
import org.example.modelos.EmpresaCultural;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el NIT de la entidad");
        String nit = scanner.nextLine();

        System.out.println("Ingrese la Mision de la empresa");
        String descripcion = scanner.nextLine();

        System.out.println("Ingrese la direccion de la empresa");
        String ubicacion = scanner.nextLine();

        System.out.println("Ingrese el correo electronico");
        String emailContacto = scanner.nextLine();

    }
}