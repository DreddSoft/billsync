import java.util.List;
import java.util.Set;

public class MenuGrupo extends Menu {

    public static final String RESET = "\033[0m";
    public static final String ANSI_BLUE_LIGHT = "\033[94m";  // Azul claro
    public static final String ANSI_BLUE_DARK = "\033[34m";    // Azul oscuro
    public static final String ANSI_GRAY = "\033[90m";        // Gris
    public static final String ANSI_WHITE = "\033[97m";        // Blanco
    public static final String ANSI_ORANGE = "\u001B[38;5;208m"; // Naranja (aproximación)
    public static final String ANSI_YELLOW = "\u001B[33m"; // Amarillo
    public static final String ANSI_PURPLE = "\u001B[35m"; // Morado
    public static final String ANSI_CYAN = "\u001B[36m"; // Azul cielo
    public static final String ANSI_BOLD = "\u001B[1m"; // Negrita

    @Override
    public void tituloSecundario() {

    }

    public void verInformacion(String nombreGrupo, String admin, Set<String> Miembros, List Eventos) {
        System.out.println(ANSI_YELLOW + "Nombre del Grupo: " + RESET + nombreGrupo);
        System.out.println(ANSI_PURPLE + "Administrador: " + RESET + admin);
        Miembros.stream()
                .forEach(entry -> System.out.println(ANSI_CYAN + "Miembro: " + RESET + entry));
        Eventos.stream()
                .forEach(entry -> System.out.println(ANSI_BLUE_LIGHT + "Evento: " + RESET + entry));
    }

    @Override
    public void subtitulo() {
        System.out.println(ANSI_BLUE_LIGHT + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ██████╗ ██████╗ ██╗   ██╗██████╗  ██████╗ ");
        System.out.println(ANSI_BLUE_LIGHT + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ██╔════╝ ██╔══██╗██║   ██║██╔══██╗██╔═══██╗");
        System.out.println(ANSI_BLUE_LIGHT + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ██║  ███╗██████╔╝██║   ██║██████╔╝██║   ██║");
        System.out.println(ANSI_BLUE_LIGHT + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ██║   ██║██╔══██╗██║   ██║██╔═══╝ ██║   ██║");
        System.out.println(ANSI_BLUE_LIGHT + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ╚██████╔╝██║  ██║╚██████╔╝██║     ╚██████╔╝");
        System.out.println(ANSI_BLUE_LIGHT + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ╚═════╝ ╚═╝  ╚═╝ ╚═════╝ ╚═╝      ╚═════╝ ");
    }

    @Override
    public void subtitulo2() {

    }

    @Override
    public void mensajeInicio() {
        System.out.println(ANSI_ORANGE + ANSI_BOLD + "Mensaje de inicio: " + RESET);
    }

    @Override
    public void mensajeFin() {
        System.out.println(ANSI_BLUE_LIGHT + ANSI_BOLD + "Mensaje de fin: " + RESET);
    }

    public void añadirMiembro() {
        System.out.println(ANSI_ORANGE + ANSI_BOLD + "Añadir Miembro: " + RESET);
    }

    public void elminarMiembro() {
        System.out.println(ANSI_CYAN + ANSI_BOLD + "Eliminar Miembro: " + RESET);
    }
}
