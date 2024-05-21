
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Usuario implements Comparable<Usuario> {

    //atributos
    private String nombre;
    private String password;
    private double balance;
    private int idUsusario;
    private DaseDatos bd;

    //constructor
    public Usuario() {
        this.balance = 0;
    }

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public Usuario(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
        this.idUsuario = bd.obtenerIdUsuario(this.nombre);
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
    public int getIdUsusario() {
        return idUsusario;
    }
    public void setIdUsusario(int idUsusario) {
        this.idUsusario = idUsusario;
    }
    public DaseDatos getBd() {
        return bd;
    }
    public void setBd(DaseDatos bd) {
        this.bd = bd;
    }

    //metodos
    //metodo que define el nombre
    public void definirNombre(String nombre) throws UserInvalidException {
        Scanner sc = new Scanner(System.in); //creamos un objeto de tipo scanner
        System.out.println("Introduce tu nombre de usuario:"); //pedimos el nombre
        nombre = sc.nextLine(); //leemos el nombre

        //comprobacion de si el nombre es valido, para ello verificamos que no haya numeros nicaracteres

        if (esNombreValido(nombre)) {//si el nombre es valido
            this.setNombre(nombre);//asignamos el nombre
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
    public void definirPassword(String password) {
        try {
            if (esContraValida(password)) { //si la contraseña es valida
                this.setPassword(password); //asignamos la contraseña
                System.out.println("Contraseña correcta"); //mostramos mensaje
            }else {
                System.out.println("No se ha construido bien"); //lanzamos excepcion
            }
        } catch (PassInvalidaException e) { //capturamos la excepcion
            System.out.println(e.getMessage()); //si no es valida, mostramos mensaje
        }

    }

    //metodo privado que comprueba si la contraseña es valida
    private boolean esContraValida(String pass) throws PassInvalidaException {
        if (pass.length() < 8 || pass.length() >16) { //suponemos que la contraseña debe tener entre 8 y 16 caracteres
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

    public void generarDeuda(double cantidad) { //metodo que genera un gasto
        this.balance -= cantidad; //restamos la cantidad al balance
    }

    public void generarPago(double cantidad) { //metodo que genera un pago
        this.balance += cantidad; //sumamos la cantidad al balance
    }

    @Override
    public int compareTo(Usuario o) { //metodo que compara dos usuarios
        return this.nombre.compareTo(o.nombre); //comparamos los nombres
    }

    public List<Usuario> obtenerListaUsuarios() { //metodo que obtiene una lista de usuarios
        return bd.obtenerListaUsuarios(); //devolvemos la lista de usuarios
    }

    //Que compruebe si el nombre de usuario y que no coincida con otro
    public void anadirUsuario() { //metodo que añade un usuario
        try {
            definirNombre(this.nombre); //definimos el nombre
            definirPassword(this.password); //definimos la contraseña
            anadirUsuario(new Usuario(this.nombre, this.password)); //añadimos el usuario
        } catch (UserInvalidException e) { //capturamos la excepcion
            System.out.println(e.getMessage()); //mostramos mensaje
        }
    }
    public void anadirUsuario(Usuario u) { //metodo que añade un usuario
        bd.insertarUsuario(u); //añadimos el usuario a la base de datos
    }
    //metodo para comprobar si el nombre de usuario esta y que no coincida con otro
    public boolean comprobarNombreUsuario(String nombre) {
        List<Usuario> listaUsuarios = bd.obtenerListaUsuarios(); //obtenemos la lista de usuarios
        for (Usuario u : listaUsuarios) { //recorremos la lista
            if (u.getNombre().equals(nombre)) { //si el nombre coincide con alguno de la lista
                return false; //devolvemos false
            }
        }
        return true; //si no coincide, devolvemos true
    }
    //metodo para comprobar actualizar la contraseña de usuario
    public void actualizarPass(String nombre, String contrasena) {
        List<Usuario> listaUsuarios = bd.obtenerListaUsuarios(); //obtenemos la lista de usuarios
        for (Usuario u : listaUsuarios) { //recorremos la lista
            if (u.getNombre().equals(nombre)) { //si el nombre coincide con alguno de la lista
                u.setPassword(contrasena); //actualizamos la contraseña
                bd.actualizarUsuario(u); //actualizamos el usuario en la base de datos
            }
        }
    }
}
