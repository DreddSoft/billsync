import java.util.Scanner;

public class Escaner {
    private static Scanner escaner;

    public Escaner() {
        escaner = new Scanner(System.in);
    }

    public static String entradaCadena() {
        return escaner.nextLine();
    }
    public static String entradaTokken() {
        return escaner.next();
    }
    public static int entradaEntero() {
        return escaner.nextInt();
    }
    public static double entradaDecimal() {
        return escaner.nextDouble();
    }
}
