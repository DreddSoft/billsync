import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Usuario user1 = new Usuario();

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la contraseña entre 8 y 16");
        String nombre = sc.nextLine();

        user1.definirPassword(nombre);

        System.out.println(user1.getPassword());
    }

}
