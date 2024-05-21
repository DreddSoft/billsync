import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

public class Gasto {
    private String titulo;
    private String descripcion;
    private LocalDate fechaCreacion;
    private double coste;
    private Usuario pagador;
    private Set<Usuario> participantes;

    //CONSTRUCTORES
    public Gasto(String titulo, String descripcion, double coste, Usuario pagador) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.coste = coste;
        this.pagador = pagador;
        fechaCreacion = LocalDate.now();
        participantes = new TreeSet<Usuario>();
    }
    public Gasto() {
    }

    //GETTERS Y SETTERS
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getCoste() {
        return coste;
    }
    public void setCoste(double coste) {
        this.coste = coste;
    }
    public Usuario getPagador() {
        return pagador;
    }
    public void setPagador(Usuario pagador) {
        this.pagador = pagador;
    }
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public Set<Usuario> getParticipantes() {
        return participantes;
    }
    public void setParticipantes(Set<Usuario> participantes) {
        this.participantes = participantes;
    }

    //MÉTODOS
    public void agregaParticipante(Usuario participante) {
        participantes.add(participante);

        //Revisar la sentencia SQL (No se han tenido en cuenta la introducción de claves foráneas, faltaría el idGrupo y el pagadorid)
        String sentenciaSQL = "INSERT INTO Gastos (titulo, descripcion, coste, fecha) VALUES (" + '\"' + titulo + "\", " + '\"' + descripcion + "\", " + '\"' + coste + "\", " + '\"' + fechaCreacion + "\")";
        BaseDeDatos.iniciarSesion();
        BaseDeDatos.insertarValores(sentenciaSQL);
        BaseDeDatos.cerrarSesion();
    }
    public void eliminaParticipante(Usuario participante) {
        participantes.remove(participante);
    }

    public void establecePago() {
        pagador.generarPago(coste);
    }
    public  void estableceDeuda() {
        participantes.iterator().next().generaGasto(coste/participantes.size());
    }
}
