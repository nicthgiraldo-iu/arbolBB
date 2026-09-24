import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArbolInventario arbol = new ArbolInventario();
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n--- DIRECTORIO DE PRODUCTOS ---");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Mostrar Inventario");
            System.out.println("3. Buscar Producto");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Entrada inválida. Debe ingresar un número.");
                sc.next(); // Limpia el Scanner
                // Vuelve a mostrar el menú
                continue;
            }

            switch (opcion) {
                case 1: // Registrar producto
                    System.out.print("Ingrese el ID del producto: ");
                    try {
                        // se capturan los datos de id y nombre para crear el nodo
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nombre del producto: ");
                        String nombre = sc.nextLine();
                        arbol.insertar(id, nombre);
                        System.out.println("Registrado con éxito.");
                    } catch (Exception e) {
                        System.out.println("ID debe ser un número válido.");
                        sc.next();
                    }
                    break;
                case 2: //mostrar inventario
                    if (arbol.estaVacio()) {
                        System.out.println("Sus productos: (vacío, aún no se han registrado productos)");
                        return;
                    }else{
                        arbol.mostrarInventario();
                    }
                    break;
                case 3:  //buscar producto 
                    System.out.print("Indica el ID del producto a buscar: ");
                    try {
                        int buscaId = sc.nextInt();
                        System.out.println(arbol.buscarPorID(buscaId));
                    } catch (Exception e) {
                        System.out.println("ID debe ser un número válido.");
                        sc.next();
                    }
                    break;
                default: // Opción no válida
                    System.out.println("Opción no válida.");
            }
        }
        sc.close();
    }
}