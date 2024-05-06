
import java.util.Scanner;
import java.util.regex.Pattern;

public class Usuario {

    //variables
    private String nombre;
    private String password;
    private double balance;


    //constructor
    public Usuario(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
        this.balance = 0;
    }

    //getters y setters
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //metodos
    //metodo que define el nombre
    public void definirNombre(String nombre) throws UserInvalidException {
        Scanner sc = new Scanner(System.in); //creamos un objeto de tipo scanner
        System.out.println("Introduce tu nombre de usuario:"); //pedimos el nombre
        nombre = sc.nextLine(); //leemos el nombre

        //comprobacion de si el nombre es valido, para ello verificamos que no haya numeros nicaracteres

        if (esNombreValido(nombre)) {//si el nombre es valido
            this.nombre = nombre;//asignamos el nombre
        } else {
            System.out.println("El nombre no es válido"); //si no es valido, mostramos mensaje
        }
    }
    //metodo privado que comprueba si el nombre es valido
    private boolean esNombreValido(String nombre) throws UserInvalidException {
        if (nombre.length() < 3 || nombre.length() > 20) { //suponemos que el nombre debe tener entre 3 y 20 caracteres
            throw new UserInvalidException("El nombre debe tener entre 3 y 20 caracteres"); //lanzamos excepcion
        }

        for (char c : nombre.toCharArray()) { //recorremos el nombre y comprobamos si es letra
            if (!Character.isLetter(c)) { //si no es letra
                throw new UserInvalidException("El nombre no debe contener caracteres ni números"); //lanzamos excepcion
            }
        }

        return true; //si cumple todas las condiciones, es valido
    }
    //metodo que define la contraseña
    public void definirPassword(String password) throws PassInvalidaException {
        if (esContraValida(password)) { //si la contraseña es valida
            this.password = password; //asignamos la contraseña
        } else {
            throw new PassInvalidaException("La contraseña no es válida");//si no es valida, lanzamos excepcion
        }
    }
    //metodo privado que comprueba si la contraseña es valida
    private boolean esContraValida(String pass) throws PassInvalidaException {
        if (pass.length() < 8) { //suponemos que la contraseña debe tener al menos 8 caracteres
            return false;//si no tiene 8 caracteres, no es valida
        }
        boolean letraMayuscula = false; //suponemos que la contraseña debe tener al menos una letra mayuscula
        boolean caracterEspecial = false; //suponemos que la contraseña debe tener al menos una letra minuscula
        boolean numero = false; //suponemos que la contraseña debe tener al menos un numero

        for (char c : pass.toCharArray()) { //recorremos la contraseña
            if (Character.isUpperCase(c)) { //si es mayuscula
                letraMayuscula = true; //asignamos true
            }
            if (!Character.isDigit(c) && !Character.isLetter(c)) { //si no es letra ni numero
                caracterEspecial = true; //asignamos true
            }
            if (Character.isDigit(c)) { //si es numero
                numero = true; //asignamos true
            }
        }

        if (!letraMayuscula) { //si no tiene mayuscula
            throw new PassInvalidaException("La contraseña debe contener al menos una letra mayúscula"); //lanzamos excepcion
        }
        if (!numero) { //si no tiene numero
            throw new PassInvalidaException("La contraseña debe contener al menos un número"); //lanzamos excepcion
        }
        if (!caracterEspecial) { //si no tiene caracter especial
            throw new PassInvalidaException("La contraseña debe contener al menos un caracter especial"); //lanzamos excepcion
        }

        return true; //si cumple todas las condiciones, es valida
    }

    public void generaGasto(double cantidad) {
        this.balance -= cantidad;
    }

    public void generarPago(double cantidad) {
        this.balance += cantidad;
    }
}
