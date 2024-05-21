import java.sql.*;
import java.util.*;

public class Grupo  {

    /* ---- VARIABLES ---- */
    private int idGrupo;
    private String nombre;
    private Usuario admin;
    private Set<Usuario> miembros;
    private List<Gasto> gastos;

    private BaseDeDatos bd;

    /* ---- CONSTRUCTORES ---- */
    public Grupo(String nombre, Usuario admin) throws SQLException {
        // TODO: crear un método de bd: que cree el grupo y devuelva el idGrupo
        this.idGrupo = bd.crearGrupo(nombre, admin);
        this.nombre = nombre;
        this.admin = admin;
        this.miembros = inicializarMiembros();
        this.gastos = new ArrayList<>();
    }
    public Grupo() throws SQLException {
    }
    /* ---- GETTERS Y SETTERS ---- */

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

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

    /* ---- toString ---- */
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
    private Set<Usuario> actualizarMiembros() {
        // Declaramos un Set
        Set<Usuario> base = new TreeSet<>();

        // Obtener de la base de datos los miembros actualizados (Sólo nombre)
        base = bd.obtenerUsuariosPorGrupo(int idGrupo);

        // Devolvemos el Set
        return base;
    }

    private List<Gasto> actualizarGastos() {
        // Declaramos un List
        List<Gasto> gastos = new ArrayList<>();

        // Obtenemos la lista con los gastos de la bd
        gastos = bd.obtenerGastosPorGrupo(int idGrupo);

        // Retornamos la lista
        return gastos;
    }
    public void estableceNombreDeGrupo() {

        // TODO: insertar método static MenuGrupo inicio

        // añadir método nombreGrupochico de MenuGrupo
        System.out.print("Introduce el nombre del grupo: ");
        String nombre = scannerString();

        // Establecer el nombre del grupo
        // Aunque se supone que el nombre ya esta definido, esto sería para cambiar
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

        // Introducimos el miembro en el grupo usando BD
        bd.insertarUsuarioEnGrupo(u, this.idGrupo);

        System.out.println("El miembro ha sido añadido al grupo.");
        // Actualizamos el Set de miembros con el método de la base de datos
        miembros = actualizarMiembros();

        // Mensaje informativo
        System.out.println("El miembro ha sido añadido al grupo.");

    }
    public void eliminaMiembro(Usuario u) {

        // TODO: añadir titulo de yasir

        // Mensaje informativo
        System.out.println("Se procede a eliminar un usuario del grupo");

        // Comprobamos que el usuario estuviera en el grupo
        if (!miembros.contains(u))
            System.out.println("El usuario no está en el grupo.");

        else {
            // Eliminamos el usuario del grupo usando BD
            bd.eliminarUsuarioDeGrupo(u, this.idGrupo);

            // Actualizamos el Set de miembros con el método de la base de datos
            miembros = actualizarMiembros();

            System.out.println("Miembro eliminado correctamente");
        }
    }

    public void agregaGasto() {

        // TODO: titulo de yasir

        // Mensaje informativo
        System.out.println("Se procede a agregar un gasto.");

        // ? pedir datos del gasto??
        System.out.print("Introduce un titulo para el gasto: ");
        String titulo = scannerString();

        System.out.print("Introduce una descripción para el gasto: ");
        String descripcion = scannerString();

        System.out.print("Introduce un coste para el gasto: ");
        double coste = scannerDouble();

        Gasto gasto = new Gasto(titulo, descripcion, coste);

        // TODO: metodos para introducir miembros en el gasto
        // TODO: código para establecer el pagador del Gasto

    }

    public void eliminarGasto() {

        // TODO: titulos

        // Mensaje informativo
        System.out.println("Se procede a eliminar un gasto.");

        // Mostrar los gastos
        System.out.println("Los gastos del grupo son: ");
        for (Gasto x : gastos) {
            System.out.println("Id: " + x.getId() + ", titulo: " + x.getTitulo());
        }

        System.out.print("Introduce el ID del gasto a eliminar: ");
        int id = scannerEntero();

        // Eliminamos el gasto de la tabla gruposGastos
        bd.eliminarGastoGrupo(idGrupo, id);

        // Actualizar la lista de gastos
        gastos = actualizarGastos();

        // Mensaje informativo
        System.out.println("El gasto ha sido eliminado.");

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
