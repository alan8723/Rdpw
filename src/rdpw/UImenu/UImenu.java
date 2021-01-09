package rdpw.UImenu;

import java.util.ArrayList;
import java.util.Scanner;
import rdpw.BD.RegistroDao;
import rdpw.Equipo;
import rdpw.Partidos;
import rdpw.Registro;
import tools.Tools;

public class UImenu {
    public static void menuPrincipal(ArrayList<Equipo> e, ArrayList<Partidos> p){
        e = RegistroDao.traerEquipo();
        p = RegistroDao.traerPartidos();
        Scanner sc = new Scanner(System.in);
        int option;
        do{
        
        option = Tools.getInt("//*********************//" +
                             "\n\n   MENU PRINCIPAL" +
                             "\n1.Menu Equipos" +
                             "\n2.Menu Partidos" +
                             "\n3.Salir", "Seleccione una opcion valida");
        
        switch(option){
            case 1:
                menuEquipo(e);
                break;
            case 2:
                menuPartidos(p, e);
                break;
            case 3:
                 System.out.println("Adios!!");
                break;
            default:
                System.out.println("Opcion incorrecta \nSeleccione una opcion valida");
                
        }
        
        }while(option != 3);
        
    }
    
    public static void menuEquipo(ArrayList<Equipo> e){
         Scanner sc = new Scanner(System.in);
        int option;
        do{

        option = Tools.getInt("//*********************//"+
                "\n\n   MENU EQUIPO"+
                "\n1.Crear nuevo equipo"+
                "\n2.Editar nombre de un equipo"+
                "\n3.Ver estadisticas de un equipo"+
                "\n4.Borrar partido"+
                "\n0.Salir", "ingrese opcion valida");
        
        switch(option){
            case 1:
                String nombre = Tools.getString("Elija el nombre del nuevo equipo");
                Registro.crearEquipo(e, nombre);
                option = 0;
                break;
            case 2:
                Registro.mostrarEquipos(e);
                int id = Tools.getInt("Editar equipo, elija el id del equipo que quiere modificar:",
                        "Error al ingresar el id");
                Registro.editarEquipo(Registro.seachEquipoById(id, e));
                option = 0;
                break;
            case 3:
                Registro.mostrarEquipos(e);
                int idE = Tools.getInt("Elija el id del equipo que desea conocer las estadistecas",
                        "Error al ingresar el id");
                Registro.mostrarEstadisticasEquipo(Registro.seachEquipoById(idE, e));
                option = 0;
                break;
            case 4:
                
                Registro.mostrarEquipos(e);
                int idB = Tools.getInt("Elija el id del equipo que quire borrar", "Error al ingresar el id");
                if(Registro.borrarEquipo(Registro.seachEquipoById(idB, e))){
                    e.remove(Registro.seachEquipoById(idB, e));
                }
                option = 0;
            default:
                System.out.println("Opcion incorrecta \nSeleccione una opcion valida");
                option = 0;
                
        }
        
        }while(option != 0);
    }
    
    public static void menuPartidos(ArrayList<Partidos> p, ArrayList<Equipo> e){
        Scanner sc = new Scanner(System.in);
        int option;
        do{
        
        option = Tools.getInt("//*********************//"+
                "\n\n   MENU PARTIDOS"+
                "\n1.Jugar nuevo partido"+
                "\n2.Listar Partidos"+
                "\n3.Borrar partido"+
                "\n0.Salir", "ingrese opcion valida");
        
        switch(option){
            case 1:
                Registro.crearPartido(p, e);
                option = 0;
                break;
            case 2:
                Registro.mostrarPartidos(p, e);
                option = 0;
                break;
            case 3:
                Registro.mostrarPartidos(p, e);
                int idB = Tools.getInt("elija el id del partido que quiere borrar:",
                        "Error al ingresar el id");
                if(Registro.borrarEquipo(Registro.seachEquipoById(idB, e))){
                    e.remove(Registro.seachEquipoById(idB, e));
                }
                option = 0;
                break;
            default:
                System.out.println("Opcion incorrecta \nSeleccione una opcion valida");
                
        }
        
        }while(option != 0);
    }
}
