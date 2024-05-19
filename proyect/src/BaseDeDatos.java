import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {

    // Conexión con bd
    static String url = "jdbc:mysql://localhost:3337/prueba";
    static Connection con;

    static {
        try {
            con = DriverManager.getConnection(url, "root", "root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //* Métodos de la base de datos
    // Obtener Lista con los nombres de los usuarios
    public List<Usuario> obtenerListaUsuarios () throws SQLException {

        String sql = "SELECT * FROM usuarios";

        // Consulta bd tabla gruposUsuarios
        Statement sentencia = con.createStatement();
        ResultSet usuarios = sentencia.executeQuery(sql);

        // Declaramos la lista
        List<Usuario> list = new ArrayList<>();

        // Recorremos el ResultSet añadiendo los valores a la lista
        while (usuarios.next()) {
            list.add(new Usuario(usuarios.getString("nombre"), usuarios.getString("password")));
        }

        usuarios.close();
        sentencia.close();

        return list;
    }
}
