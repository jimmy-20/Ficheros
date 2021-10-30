import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FileConnection fc = null;

        try {
            fc = new FileConnection(new File("Vehiculo.hd"), new File("Vehiculo.data"));

            System.out.println("Ingrese el nombre del cliente del vehiculo: ");
            String nombre = sc.nextLine();

            // Pedir al usuario todos los campos del la clase vehiculo
            System.out.println("Marca");
            String marca = sc.nextLine();

            System.out.println("Modelo");
            String modelo = sc.nextLine();

            System.out.println("Color");
            String color = sc.nextLine();

            System.out.println("Precio");
            float precio = sc.nextFloat();

            Vehiculo v = new Vehiculo(0, nombre, marca, modelo, color, precio);

            fc.create(v);

            System.out.println("");
            show(fc);


            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void show(FileConnection fc) {
        header();

        for (Vehiculo v : fc.findAll()) {
            System.out.format("%-10s %-20s %-20s %-15s %-15s %-10s\n", v.getId(),v.getNombre(),v.getMarca(),v.getModelo(),v.getColor(),v.getPrecio());
        }
    }

    public static void header(){
        System.out.format("%-10s %-20s %-20s %-15s %-15s %-10s\n", "ID", "Nombre", "Marca", "Modelo", "Color", "Precio");
    }
}