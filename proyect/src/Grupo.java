import java.sql.*;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Grupo  {

    /* ---- VARIABLES ---- */
    private String nombre;
    private Usuario admin;
    private Set<Usuario> miembros;
    private List<Gasto> gastos;

    private BaseDeDatos bd;

    /* ---- CONSTRUCTORES ---- */
    public Grupo(String nombre, Usuario admin, Set<Usuario> miembros, List<Gasto> gastos) throws SQLException {
        this.nombre = nombre;
        this.admin = admin;
        this.miembros = miembros;
        this.gastos = gastos;
    }
    public Grupo() throws SQLException {
    }
    /* ---- GETTERS Y SETTERS ---- */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getAdmin() {
        return admin;
    }

    public void setAdmin(Usuario admin) {
        this.admin = admin;
    }

    public Set<Usuario> getMiembros() {
        return miembros;
    }

    public void setMiembros(Set<Usuario> miembros) {
        this.miembros = miembros;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }
    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    /* ---- GETTERS Y SETTERS ---- */
    @Override
    public String toString() {
        String result = "";

        result = "Nombre del grupo: " + this.nombre + "" +
                "\nAdministrador del grupo: " + this.admin.getNombre() +
                "\nUsuarios: ";

        // For each para poner los nombres de los usuarios
        for (Usuario x : miembros) {
            result += x.getNombre() + ", ";
        }

        result += "\nGastos: ";

        // For each para poner los gastos del grupos
        for(Gasto x : gastos) {
            result += x.getNombre() + ", ";

        }

        return result;
    }

    /* ---- METODOS PROPIOS ---- */
    public void estableceNombreDeGrupo() {

        // TODO: insertar método static MenuGrupo inicio

        // añadir método nombreGrupochico de MenuGrupo
        System.out.print("Introduce el nombre del grupo: ");
        String nombre = scannerString();

        // Establecer el nombre del grupo
        setNombre(nombre);

    }
    public void agregaMiembro(Usuario u) throws UserInvalidException {

        // TODO: añadir titulo de yasir

        // Mensaje informativo
        System.out.println("Se procede a introducir un usuario en el grupo");

        // Tengo que comprobar que no este ya registrado en el grupo
        if (miembros.contains(u)) {
            System.out.println("El usuario ya esta registrado en el grupo.");
            throw new UserInvalidException("El usuario ya esta registrado en el grupo.");
        }

        System.out.println("El miembro ha sido añadido al grupo.");
        // si no esta registrado agrego miembro a Set
        miembros.add(u);


    }
    public void eliminaMiembro(Usuario u) {
        this.miembros.remove(u);
    }

    // Scanner
    public String scannerString() {
        // Scanner
        return new Scanner(System.in).nextLine();
    }
    public int scannerEntero() {
        // Scanner
        return new Scanner(System.in).nextInt();
    }
    public double scannerDouble() {
        return new Scanner(System.in).nextDouble();
    }


}
