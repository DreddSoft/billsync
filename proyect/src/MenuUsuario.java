public class MenuUsuario extends Menu{

    /*Metodos*/
    /*Declarar colores para mayor comodidad*/
    public static final String RESET = "\033[0m";
    public static final String ANSI_BLUE_DARK = "\033[34m";    // Azul oscuro
    public static final String ANSI_RED = "\u001B[31m";         //Rojo
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BOLD = "\u001B[1m";         //Negrita
    public static final String ANSI_ORANGE = "\u001B[38;5;208m"; // 208 es un valor aproximado para el color naranja





    public void tituloSecundario(){}

    @Override
    public void subtitulo() {
        System.out.println(ANSI_BLUE_DARK+
                "\t\t\t\t\t\t\t\t\t\t\t\t\t ██╗   ██╗███████╗██╗   ██╗ █████╗ ██████╗ ██╗ ██████╗ \n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t ██║   ██║██╔════╝██║   ██║██╔══██╗██╔══██╗██║██╔═══██╗\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t ██║   ██║███████╗██║   ██║███████║██████╔╝██║██║   ██║\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t ██║   ██║╚════██║██║   ██║██╔══██║██╔══██╗██║██║   ██║\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t ╚██████╔╝███████║╚██████╔╝██║  ██║██║  ██║██║╚██████╔╝\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t  ╚═════╝ ╚══════╝ ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝ ╚═════╝ ");
    }
    @Override
    public void subtitulo2() {}

    @Override
    public void mensajeInicio() {
        System.out.println(ANSI_BLUE_DARK+
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ╔═╗╦═╗╔═╗╔═╗  ╔╦╗╦ ╦  ╦ ╦╔═╗╦ ╦╔═╗╦═╗╦╔═╗\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ║  ╠╦╝║╣ ╠═╣   ║ ║ ║  ║ ║╚═╗║ ║╠═╣╠╦╝║║ ║\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ╚═╝╩╚═╚═╝╩ ╩   ╩ ╚═╝  ╚═╝╚═╝╚═╝╩ ╩╩╚═╩╚═╝");
    }

    @Override
    public void mensajeFin() {}
    public void pedirNombre(){
        System.out.println(RESET+ANSI_ORANGE+"ɪɴᴛʀᴏᴅᴜᴢᴄᴀ sᴜ ᴜsᴜᴀʀɪᴏ﹕");
        //Usuario definirNombre
    }
    public void pedirPassword(){
        System.out.println(RESET+ANSI_ORANGE+"ɪɴᴛʀᴏᴅᴜᴢᴄᴀ sᴜ ᴄᴏɴᴛʀᴀsᴇɴ̃ᴀ﹕");
        //Usuario definirPassword
    }
    public void errorUsuarioNoCreado(){
        System.out.println(RESET+ANSI_RED+ANSI_BOLD+"Sᴇ ʜᴀ ᴘʀᴏᴅᴜᴄɪᴅᴏ ᴜɴ ᴇʀʀᴏʀ ᴀʟ ᴄʀᴇᴀʀ ᴇʟ ᴜsᴜᴀʀɪᴏ.");
        //Usuario error al crear el usuario
    }
    public void confirmarUsuarioCreado(){
        System.out.println(RESET+ANSI_GREEN+ANSI_BOLD+"Sᴇ ʜᴀ ᴄʀᴇᴀᴅᴏ ᴇʟ ᴜSᴜᴀʀɪᴏ ᴄᴏɴ ᴇXɪᴛᴏ﹗");
        //Usuario confirmacion de usuario creado
    }
}
