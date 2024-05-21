import java.sql.*;

public class BaseDeDatos {
    private static Connection connection;
    private static String url;

    BaseDeDatos() {
        url = "jdbc:mysql://localhost:3337/tricount";
    }

    //Iniciar la conexión con la base de datos
    public static void iniciarSesion() {
        connection = null;
        try {
            connection = DriverManager.getConnection(url, "root", "root");
            System.out.println("Conexion establecida");
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error al conectarse");
        }
    }

    //Finalizar la conexión con la base de datos
    public static void cerrarSesion() {
        try {
            connection.close();
            System.out.println("Conexion cerrada");
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error al cerrar la sesión");
        }
    }

    //Insertar valores en la base de datos
    public static void insertarValores(String sentencia) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sentencia);
            System.out.println("Datos insertados correctamente");
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error al introducir los datos");
        }

    }

    //* Métodos de la base de datos
    // Obtener Lista con los nombres de los usuarios
    public List<Usuario> obtenerListaUsuarios () throws SQLException {

        // Inicia conexion bd
        iniciarSesion();

        // Sentencia de captura
        String sql = "SELECT * FROM usuarios";
        Statement sentencia = connection.createStatement();

        // captura informacion
        ResultSet usuarios = sentencia.executeQuery(sql);

        // Declaramos la lista
        List<Usuario> list = new ArrayList<>();

        // Recorremos el ResultSet añadiendo los valores a la lista
        while (usuarios.next()) {
            list.add(new Usuario(usuarios.getString("nombre"), usuarios.getString("password")));
        }

        usuarios.close();
        sentencia.close();

        cerrarSesion();

        return list;
    }
}
