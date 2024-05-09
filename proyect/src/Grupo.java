import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Grupo {

    /* ---- VARIABLES ---- */
    private String nombre;
    private Usuario admin;
    private Set<Usuario> miembros;
    private List<Gasto> gastos;

    /* ---- CONSTRUCTORES ---- */
    public Grupo(String nombre, Usuario admin, Set<Usuario> miembros, List<Evento> eventos) {
        this.nombre = nombre;
        this.admin = admin;
        this.miembros = miembros;
        this.eventos = eventos;
    }
    public Grupo() {
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

    public List<Evento> getEventos() {
        return eventos;
    }
    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
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
    public String estableceNombreDeGrupo() {

        // TODO: añadir método nombreGrupochico de MenuGrupo
        System.out.print("Introduce el nombre del grupo: ");

    }

    public void agregaMiembro(Usuario u) {
        this.miembros.add(u);
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
