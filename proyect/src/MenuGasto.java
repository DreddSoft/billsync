import java.time.LocalDate;
import java.util.Set;

public class MenuGasto extends Menu{
    public static final String RESET = "\033[0m";
    public static final String ANSI_BLUE_DARK = "\033[34m";    // Azul oscuro
    public static final String ANSI_RED = "\u001B[31m";         //Rojo
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BOLD = "\u001B[1m";         //Negrita
    public static final String ANSI_YELLOW = "\u001B[33m";//Amarillo
    public static final String ANSI_ORANGE = "\u001B[38;5;208m"; // 208 es un valor aproximado para el color naranja
    public static final String ANSI_PURPLE = "\u001B[38;5;201m"; // 201 es un valor aproximado para el color morado
    public static final String ANSI_UNDERLINE = "\u001B[4m"; // Subrayado
    public static final String ANSI_AZUL_CIELO = "\u001B[96m";



    @Override
    public void tituloSecundario() {

    }

    @Override
    public void subtitulo() {
        System.out.println(
                ANSI_BLUE_DARK+"\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ██████╗  █████╗ ███████╗████████╗ ██████╗ \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ██╔════╝ ██╔══██╗██╔════╝╚══██╔══╝██╔═══██╗\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ██║  ███╗███████║███████╗   ██║   ██║   ██║\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ██║   ██║██╔══██║╚════██║   ██║   ██║   ██║\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ╚██████╔╝██║  ██║███████║   ██║   ╚██████╔╝\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ╚═════╝ ╚═╝  ╚═╝╚══════╝   ╚═╝    ╚═════╝");
    }

    @Override
    public void subtitulo2() {

    }

    @Override
    public void mensajeInicio() {

    }

    @Override
    public void mensajeFin() {

    }

    public static void iniciaGasto(String tituloGasto, String descripcion, double coste, LocalDate fecha, String pagador, Set<String> participantes) {
        // Imprimir el encabezado de la factura
        System.out.println(ANSI_BOLD + "\t\t\tFACTURA" + RESET);
        System.out.println(ANSI_BOLD + "------------------------------------" + RESET);

        // Detalles del gasto
        System.out.println(ANSI_BLUE_LIGHT + "Título del gasto: " + RESET + tituloGasto);
        System.out.println(ANSI_YELLOW + "Descripción: " + RESET + descripcion);
        System.out.println(ANSI_AZUL_CIELO + "Fecha: " + RESET + fecha);
        // Resaltando el pagador con un color diferente
        System.out.println(ANSI_UNDERLINE + ANSI_PURPLE + "Pagador: " + pagador + RESET);

        // Participantes
        System.out.println(ANSI_BOLD + "Participantes:" + RESET);
        participantes.forEach(participante -> System.out.println("   - " + participante));

        // Total
        System.out.println(ANSI_BOLD + "------------------------------------" + RESET);
        System.out.println(ANSI_GREEN + ANSI_BOLD + "Total: " + coste + "€" + RESET);
        System.out.println();
    }

    public void finalizaGasto(){
        System.out.println(RESET+ANSI_GREEN+ANSI_BOLD+ANSI_UNDERLINE+"\uD835\uDC6E\uD835\uDC82\uD835\uDC94\uD835\uDC95\uD835\uDC90 \uD835\uDC87\uD835\uDC8A\uD835\uDC8F\uD835\uDC82\uD835\uDC8D\uD835\uDC8A\uD835\uDC9B\uD835\uDC82\uD835\uDC85\uD835\uDC90");
    }
}
