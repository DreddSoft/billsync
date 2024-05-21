import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BaseDeDatos {
    private static Connection connection;
    private static String url;

    BaseDeDatos() {
        url = "jdbc:mysql://localhost:3337/tricount";
    }

    //Getters y Setters de la URL
    public static String getUrl() {
        return url;
    }
    public static void setUrl(String url) {
        BaseDeDatos.url = url;
    }

    //MÉTODOS

    //Iniciar la conexión con la base de datos
    private static void iniciarSesion() {
        connection = null;
        try {
            connection = DriverManager.getConnection(url, "root", "root");
            System.out.println("Conexion establecida");
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error al conectarse");
        }
    }
    //Finalizar la conexión con la base de datos
    private static void cerrarSesion() {
        try {
            connection.close();
            System.out.println("Conexion cerrada");
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error al cerrar la sesión");
        }
    }

    //Insertar valores en la base de datos
//    public static int insertarValores(String sentencia) {
//        Statement statement = null;
//        int id = 0;
//
//        iniciarSesion();
//        try {
//            statement = connection.createStatement();
//            id = statement.executeUpdate(sentencia);
//            System.out.println("Datos insertados correctamente");
//        } catch (SQLException e) {
//            System.out.println("Ha ocurrido un error al introducir los datos");
//        }
//        cerrarSesion();
//
//        return id;
//    }

    //Métodos de la tabla "gastos"
    public int agregarGasto(int idGrupo, String titulo, String descripcion, double coste, LocalDate fecha, int idPagador, int idCategoria) throws SQLException {
        String sentenciaSQL = "INSERT INTO gastos (idGrupo, titulo, descripcion, coste, fecha, idPagador, idCategoria)" + "VALUES (?,?,?,?,?,?,?)";

        iniciarSesion();
        PreparedStatement sentencia = connection.prepareStatement(sentenciaSQL);

        sentencia.setInt(1, idGrupo);
        sentencia.setString(2, titulo);
        sentencia.setString(3, descripcion);
        sentencia.setDouble(4, coste);
        sentencia.setDate(5, Date.valueOf(fecha));
        sentencia.setInt(6, idPagador);
        sentencia.setInt(7, idCategoria);

        int filaAfectada = sentencia.executeUpdate();
        System.out.printf("El gasto ha sido agregado correctamente");

        ResultSet rs = sentencia.getGeneratedKeys();
        int idGasto = 0;
        while (rs.next()) {
            idGasto = rs.getInt(1);
        }
        cerrarSesion();

        return idGasto;
    }

    //Métodos de la tabla "categorias"
    public int agregarCategoria(String nombreCat) throws SQLException {
        String sentenciaSQL = "INSERT INTO categorias (nombre)" +
                "VALUES(?)";

        iniciarSesion();
        PreparedStatement sentencia = connection.prepareStatement(sentenciaSQL);
        sentencia.setString(1, nombreCat);

        int filaAfectada = sentencia.executeUpdate();
        System.out.printf("La categoría ha sido agregada correctamente");

        ResultSet rs = sentencia.getGeneratedKeys();
        int idCategoria = 0;

        while (rs.next()) {
            idCategoria = rs.getInt(filaAfectada);
        }
        cerrarSesion();

        return idCategoria;
    }
    public String obtenerNombreCategoria(int idCategoria) throws SQLException {
        String sentenciaSQL = "SELECT nombre FROM categorias" +
                "WHERE id = " + idCategoria;

        iniciarSesion();
        Statement sentencia = connection.createStatement();
        ResultSet rs = sentencia.executeQuery(sentenciaSQL);
        String nombreCat = rs.getString(1);
        cerrarSesion();

        return nombreCat;
    }
    public int obtenerIdCategoria(String nombreCat) throws SQLException {
        String sentenciaSQL = "SELECT id FROM categorias" +
                "WHERE nombre = " + nombreCat;

        iniciarSesion();
        Statement sentencia = connection.createStatement();
        ResultSet rs = sentencia.executeQuery(sentenciaSQL);
        int idCat = rs.getInt(1);
        cerrarSesion();

        return idCat;
    }
    public List<String> obtenerListaCategoria () throws SQLException {
        iniciarSesion();

        // Captura de información
        String sentenciaSQL = "SELECT nombre FROM categorias";
        Statement sentencia = connection.createStatement();
        ResultSet rs = sentencia.executeQuery(sentenciaSQL);

        // Declaramos la lista y Recorremos el ResultSet añadiendo los valores a la lista
        List<String> listaCategorias = new ArrayList<>();
        while (rs.next()) {
            listaCategorias.add(rs.getString(1));
        }

        rs.close();
        sentencia.close();
        cerrarSesion();

        return listaCategorias;
    }
    public int obtenerCategoriaDeGasto(int idGasto) throws SQLException {
        String sentenciaSQL = "SELECT categorias.id FROM categorias" +
                "LEFT JOIN gastos ON categorias.id = gastos.idCategoria";

        iniciarSesion();
        Statement sentencia = connection.createStatement();
        ResultSet rs = sentencia.executeQuery(sentenciaSQL);
        int idCat = rs.getInt(1);
        cerrarSesion();

        return idCat;
    }

    //Métodos de la tabla "gastosUsuarios"
    public int agregarParticipante(int idUsuario, int idGasto) throws SQLException {
        String sentenciaSQL = "INSERT INTO gastosUsuarios (idUsuario, idGasto, costeIndividual)" +
                "VALUES (?,?,0)";

        iniciarSesion();
        PreparedStatement sentencia = connection.prepareStatement(sentenciaSQL);

        sentencia.setInt(1, idUsuario);
        sentencia.setInt(2, idGasto);

        int filaAfectada = sentencia.executeUpdate();
        System.out.println("El participante ha sido agregado al gasto correctamente");

        ResultSet rs = sentencia.getGeneratedKeys();
        int idGastoUsuario = 0;

        while (rs.next()) {
            idGastoUsuario = rs.getInt(filaAfectada);
        }
        cerrarSesion();

        return idGastoUsuario;
    }
    public void eliminarParticipante(int idUsuario) throws SQLException {
        String sentenciaSQL = "DELETE FROM gastosUsuarios WHERE idUsuario = ?";

        iniciarSesion();
        PreparedStatement sentencia = connection.prepareStatement(sentenciaSQL);

        sentencia.setInt(1, idUsuario);
        sentencia.executeUpdate();
        System.out.println("El usuario ha sido eliminado correctamente");
        cerrarSesion();
    }
    public Set<Usuario> obtenerParticipantes() throws SQLException {
        String sentenciaSQL = "SELECT U.nombre FROM gastosUsuarios AS GU" +
                "LEFT JOIN usuarios AS U ON U.id = GU.idUsuario";

        iniciarSesion();
        Statement sentencia = connection.createStatement();
        ResultSet rs = sentencia.executeQuery(sentenciaSQL);

        Set<Usuario> participantes = new TreeSet<>();

        while (rs.next()) {
            participantes.add(new Usuario(rs.getString("nombre")));
        }
        cerrarSesion();

        return participantes;
    }
    public void actualizarDeudaIndividual(double coste) throws SQLException {
        String sentenciaSQL = "UPDATE gastosUsuarios SET costeIndividual = ?";

        iniciarSesion();
        PreparedStatement sentencia = connection.prepareStatement(sentenciaSQL);

        sentencia.setDouble(1, coste);
        sentencia.executeUpdate();
        System.out.println("El coste individual del participante ha sido modificado correctamente");
        cerrarSesion();
    }

    //Métodos de la tabla "usuarios"
    public List<Usuario> obtenerListaUsuarios () throws SQLException {
        iniciarSesion();

        // Captura de informacion
        String sentenciaSQL = "SELECT * FROM usuarios";
        Statement sentencia = connection.createStatement();
        ResultSet rs = sentencia.executeQuery(sentenciaSQL);

        // Declaramos la lista
        List<Usuario> list = new ArrayList<>();

        // Recorremos el ResultSet añadiendo los valores a la lista
        while (rs.next()) {
            list.add(new Usuario(rs.getString("nombre"), rs.getString("password")));
        }

        rs.close();
        sentencia.close();
        cerrarSesion();

        return list;
    }
    public int obtenerIdUsuario(String nombreUsuario) throws SQLException {
        String sentenciaSQL = "SELECT id FROM usuarios WHERE nombre = " + '\"' + nombreUsuario + '\"';
        int id = 0;

        iniciarSesion();

        //Instrucciones para extraer el ID del usuario especificado por parámetro de la BD
        Statement sentencia = connection.createStatement();
        ResultSet idResultado = sentencia.executeQuery(sentenciaSQL);

        //Bucle para iterar y obtenerlo
        while (idResultado.next()) {
            id = idResultado.getInt("id");
        }

        cerrarSesion();
        return id;
    }

}
