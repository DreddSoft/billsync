import java.util.Scanner;

public class AppTricount {

    // Atributo privado
    private BaseDeDatos bd;

    public static void main(String[] args) {

    }

    // MENU PRINCIPAL
    private static void iniProgram() {

        // TODO: gráfica iniciar programa

        // condicion inicioSesion
        boolean check = false;

        do {

            check = iniciarSesion();

            if (!check) {

            }

        } while(!check);

    }

    private static boolean iniciarSesion() {

        // TODO: gráfica iniciar sesión

        System.out.println("Introduzca su nombre de usuario: ");
        String usuario = scannerString();

        System.out.println("Introduzca su contraseña: ");
        String contra = scannerString();

        // Sacamos lista de usuarios
        List<Usuario> listaUsuarios = bd.obtenerListaUsuarios();

        // Comprobamos que el usuario se encuentra en la lista
        // TODO: Comprobar que los campos nombre y contraseña coinciden
        // retornamos true

        // else: return false;
    }

    private static void crearUsuario() {

        System.out.println("Su usuario no está registrado, ¿desea crear un nuevo usuario?");
        System.out.println("1) Si." +
                "\n2) No.");
        System.out.print("Introduzca su opción: ");
        int op = scannerEntero();

        

    }

    private static void endProgram() {

        // TODO: gráfica finalizar programa
    }

    public static void menu() {

        // condicion salir
        salir = false;

        // TODO: Gráfica MENU

        do {

            // opciones de menu


        } while(!salir)

    }

    public static void opcionesMenu() {



    }

    public static void TricountExe() {

        // Iniciar programa
        iniProgram();

        // Menú
        menu();

        // Finalizar programa
        endProgram();

    }

    // Diferentes clases Scanner
    public static String scannerString() {
        // Scanner
        return new Scanner(System.in).nextLine();
    }
    public static int scannerEntero() {
        // Scanner
        return new Scanner(System.in).nextInt();
    }
}




