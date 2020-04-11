package rdpw;

import rdpw.BD.RegistroDao;
import java.util.ArrayList;
import rdpw.UImenu.UImenu;
import tools.Tools;
/**
 *<h1>Registro de partidos</h1>
 *permite registrar partidos y ver estedistica de los equipos 
 * 
 */
public class Rdpw {

    public static void main(String[] args) {
        int numero;
        
        ArrayList<Partidos> partidos = new ArrayList(); 
        ArrayList<Equipo> equipos = new ArrayList();  
        
        UImenu.menuPrincipal(equipos, partidos);        
        
    }
    
}
