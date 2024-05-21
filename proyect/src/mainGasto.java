import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class mainGasto {
    public static void main(String[] args) {

    MenuGasto menuGasto = new MenuGasto();
        menuGasto.titulo();
        menuGasto.creditos();
        menuGasto.subtitulo();
        menuGasto.subtitulo2();
        menuGasto.mensajeInicio();
        menuGasto.mensajeFin();
        Set<String> miembro = new HashSet<String>();
        miembro.add("Yasir");
        miembro.add("Mikel");
        miembro.add("Daniel");
        menuGasto.iniciaGasto("Comida","Reunion",120.57, LocalDate.now(),"Andres",miembro);
        menuGasto.finalizaGasto();
    }
}
