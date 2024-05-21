import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Gasto {
    private int idGasto;
    private String titulo;
    private String categoria;
    private String descripcion;
    private LocalDate fechaCreacion;
    private Set<Usuario> participantes;
    private double coste;
    private double deudaIndividual;
    private Usuario pagador;
    private int idGrupo;
    private BaseDeDatos bd;

    //CONSTRUCTORES
    public Gasto(String titulo, String descripcion, double coste, TreeSet<Usuario> participantes, Usuario pagador, int idGrupo, int idCategoria) {
        this.idGasto = bd.agregarGasto(idGrupo, titulo, descripcion, coste, participantes, bd.obtenerIdUsuario(pagador.getNombre()), idCategoria);
        this.titulo = titulo;
        this.categoria = bd.obtenerNombreCategoria(idCategoria);
        this.descripcion = descripcion;
        fechaCreacion = LocalDate.now();
        this.participantes = participantes;
        this.coste = coste;
        deudaIndividual = this.coste/participantes.size();
        this.pagador = pagador;
        this.idGrupo = idGrupo;
    }
    public Gasto() {
        this.idGasto = 0;
        this.titulo = "Nuevo Gasto";
        this.categoria = "Sin Categoría";
        this.descripcion = "";
        this.fechaCreacion = LocalDate.now();
        this.participantes = new TreeSet<Usuario>();
        this.coste = 0;
        this.deudaIndividual = this.coste/participantes.size();
        this.pagador = null;
        this.idGrupo = 0;
    }

    //GETTERS Y SETTERS
    public int getIdGasto() {
        return idGasto;
    }
    public void setIdGasto(int idGasto) {
        this.idGasto = idGasto;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
    public double getDeudaIndividual() {
        return deudaIndividual;
    }
    public void setDeudaIndividual(double deudaIndividual) {
        this.deudaIndividual = deudaIndividual;
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
    public int getIdGrupo() {
        return idGrupo;
    }
    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }
    public BaseDeDatos getBd() {
        return bd;
    }
    public void setBd(BaseDeDatos bd) {
        this.bd = bd;
    }

    //MÉTODOS de la clase "Grupo"
    //Añadir el total del gasto al total del pagador (admin)
    public void establecerPago() {
        pagador.generarPago(coste);
    }
    //Añadir la parte proporcional del gasto al total de cada participante (incluido el pagador)
    public void establecerDeuda() {
        participantes.iterator().next().generarGasto(deudaIndividual);
    }

    //MÉTODOS de la clase "BaseDeDatos"
    public void agregarParticipanteBDD(Usuario participante) throws SQLException {
        bd.agregarParticipante(participante.getId, idGasto);
        actualizarConjuntoParticipantes();
    }
    public void eliminaParticipanteBDD(Usuario participante) throws SQLException {
        bd.eliminarParticipante(participante.getId);
        actualizarConjuntoParticipantes();
    }
    public void actualizarConjuntoParticipantes() throws SQLException {
        participantes = bd.obtenerParticipantes();
        actualizarDeudaIndividualBDD();
    }
    private void actualizarDeudaIndividualBDD() throws SQLException {
        bd.actualizarDeudaIndividual(deudaIndividual);
        establecerDeuda();
        establecerPago();
    }
    public void actualizarCategoria() throws SQLException {
        categoria = bd.obtenerNombreCategoria(bd.obtenerCategoriaDeGasto(idGasto));
    }

//    public void agregarParticipante(Usuario participante) throws UserInvalidException, SQLException {
//        if (participantes.contains(participante)) {
//            throw new UserInvalidException("El usuario especificado ya existe");
//        }
//        participantes.add(participante);
//        bd.agregarParticipante(participante.getId(), getIdGasto());
//        bd.actualizarDeudaIndividual(deudaIndividual);
//    }


}
