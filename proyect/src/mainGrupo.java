import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class mainGrupo {
    public static void main(String[] args) {
        MenuGrupo menuGrupo = new MenuGrupo();
        menuGrupo.titulo();
        menuGrupo.creditos();
        menuGrupo.subtitulo();
        Set<String> miembro = new HashSet<String>();
        miembro.add("Yasir");
        miembro.add("Mikel");
        miembro.add("Daniel");
        List<String> eventos = new ArrayList<String>();
        eventos.add("Cena");
        eventos.add("Comida");
        eventos.add("Desayuno");
        menuGrupo.verInformacion("1DAW","Andres",miembro,eventos);
        menuGrupo.tituloSecundario();
        menuGrupo.mensajeInicio();
        menuGrupo.subtitulo2();
        menuGrupo.añadirMiembro();
        menuGrupo.elminarMiembro();
        menuGrupo.mensajeFin();

    }
}
