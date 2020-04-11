package rdpw;

import static java.lang.System.in;
import java.util.ArrayList;
import java.util.Scanner;
import rdpw.BD.RegistroDao;

public class Registro {
    //en este metodo registramos un nuevo partido modificanto a su vez las estadisticas de los equipos que juegan
    public static Partidos nuevoRegistroPartido(Equipo local, Equipo visitante, int goles_local, int goles_visitante, String tipo_partido){
        Partidos pAux = new Partidos();
        
            //creando el partido
            pAux.setId_local(local.getId_equipo());
            pAux.setId_visitante(visitante.getId_equipo());
            pAux.setGoles_local(goles_local);
            pAux.setGoles_visitante(goles_visitante);
            pAux.setTipo_partido(tipo_partido);
            //agregando estadisticas al equipo
            local.setPartidos_jugados((local.getPartidos_jugados()+1));
            visitante.setPartidos_jugados((visitante.getPartidos_jugados()+1));
            local.setGoles_a_favor(local.getGoles_a_favor() + goles_local);
            visitante.setGoles_a_favor(visitante.getGoles_a_favor() + goles_visitante);
            local.setGoles_en_contra(local.getGoles_en_contra() + goles_visitante);
            visitante.setGoles_en_contra(visitante.getGoles_en_contra() + goles_local);
            //verificando el ganador y agregando las estadisticas al equipo
            if(goles_local > goles_visitante){
                local.setPartidos_ganados((local.getPartidos_ganados()+1));
                visitante.setPartidos_perdidos((local.getPartidos_perdidos()+1));
            }else if(goles_local < goles_visitante){
                local.setPartidos_perdidos((local.getPartidos_perdidos()+1));
                visitante.setPartidos_ganados((local.getPartidos_ganados()+1));
            }else if(goles_local == goles_visitante){
                local.setPartidos_jugados((local.getPartidos_jugados()+1));
                visitante.setPartidos_jugados((local.getPartidos_jugados()+1));
            }
        /*RegistroDao.editarEquipoDB(local);
        RegistroDao.editarEquipoDB(visitante);
        RegistroDao.subirPartidoDB(pAux);*/
        //retorna el partido jugado
        return pAux;
        
    }
    
    public static void borrarRegistro(ArrayList<Partidos> partidos, ArrayList<Equipo> equipos){
        Scanner sc = new Scanner(in);
        System.out.println("Elija el id del partido que quire borrar");
        mostrarPartidos(partidos, equipos);
        int id = Integer.valueOf(sc.nextLine());
        
        Partidos partidoAux = seachPartidoById(id, partidos);
        Equipo local = seachEquipoById(partidoAux.getId_local(), equipos);
        Equipo visitante = seachEquipoById(partidoAux.getId_visitante(), equipos);
        //Editando estadisticas el local 
        local.setPartidos_jugados(local.getPartidos_jugados()-1);
        local.setGoles_a_favor(local.getGoles_a_favor() - partidoAux.getGoles_local());
        local.setGoles_en_contra(local.getGoles_en_contra() - partidoAux.getGoles_visitante());
        //Editando estadisticas del visitante
        visitante.setPartidos_jugados(visitante.getPartidos_jugados()-1);
        visitante.setGoles_a_favor(visitante.getGoles_a_favor() - partidoAux.getGoles_visitante());
        visitante.setGoles_en_contra(visitante.getGoles_en_contra() - partidoAux.getId_local());
        //verificando resultado del partido para editar estadisticas de equipos
        if(partidoAux.getGoles_local() > partidoAux.getGoles_visitante()){
            local.setPartidos_ganados(local.getPartidos_ganados() - 1);
            visitante.setPartidos_perdidos(visitante.getPartidos_perdidos() - 1);
        } else if(partidoAux.getGoles_local() < partidoAux.getGoles_visitante()){
            local.setPartidos_perdidos(local.getPartidos_perdidos()-1);
            visitante.setPartidos_ganados(visitante.getPartidos_ganados() -1);
        }else if(partidoAux.getGoles_local() == partidoAux.getGoles_visitante()){
            local.setPartidos_empatados(local.getPartidos_empatados()-1);
            visitante.setPartidos_empatados(visitante.getPartidos_empatados() -1);
        }
        
        /*borrarPartido(partidoAux);
        editarEquipo(local);
        editarEquipo(visitante);*/
        
    }
    
    public static void crearPartido(ArrayList<Partidos> partidos, ArrayList<Equipo> equipos){
        boolean tipoPartidoValido;
                Equipo local = new Equipo();
                Equipo visitante = new Equipo();
                String tipoPartido = "";
                int opcion;
                int golesLocal;
                int golesVisitante;
                Scanner sc = new Scanner(System.in);
                do{
                    tipoPartidoValido = false;
                    System.out.println("Elija el tipo de partido: ");
                    System.out.println("1. versus/amistoso ");
                    System.out.println("2. copa ");
                    System.out.println("3. liga ");
                    opcion = Integer.valueOf(sc.nextLine());
                    if(opcion == 1){
                         
                        tipoPartido = "versus/amistoso";
                        tipoPartidoValido = true;
                    }else if(opcion == 2){
                        tipoPartido = "copa ";
                        tipoPartidoValido = true;
                    }else if(opcion == 3){
                        tipoPartido = "liga ";
                        tipoPartidoValido = true;
                    }
                }while(!tipoPartidoValido);
                System.out.println("elije el id del local: ");
                Registro.mostrarEquipos(equipos);
                opcion = Integer.valueOf(sc.nextLine());
                local = seachEquipoById(opcion, equipos);
                
                System.out.println("elije el id del visitante: ");
                Registro.mostrarEquipos(equipos);
                opcion = Integer.valueOf(sc.nextLine());
                visitante = seachEquipoById(opcion, equipos);
                
                System.out.println("indique goles local: ");
                golesLocal = Integer.valueOf(sc.nextLine());
                System.out.println("indique goles visitante: ");
                golesVisitante = Integer.valueOf(sc.nextLine());
                
                System.out.println(tipoPartido);
                partidos.add(nuevoRegistroPartido(local, visitante, golesLocal, golesVisitante, tipoPartido));
                
    }
    
    public static void mostrarPartidos(ArrayList<Partidos> partidos, ArrayList<Equipo> equipos){
        for(Partidos p: partidos){
            //obteniendo los nombres de local y visitante
            Equipo local = seachEquipoById(p.getId_local(), equipos);
            Equipo visitante = seachEquipoById(p.getId_visitante(), equipos);
            
            System.out.println("id: " + p.getId_partido() + " "
                              + local.getNombre() +": "+ p.getGoles_local() + " " 
                              + visitante.getNombre() +": " + p.getGoles_visitante()
                              +"\ntipo partido: " + p.getTipo_partido());
        }
    }
    
    public static Partidos seachPartidoById(int id, ArrayList<Partidos>partidos){
        int i = 0;
        for(Partidos p: partidos){
            i++;
            if(partidos.get(i-1).getId_partido() == id){
                return p;
            }         
        }
        System.out.println("No se encontro el partido");
        return null;
    }
    
    public static boolean borrarPartido(Partidos partido){
        System.out.println("Seguro quire borrar el partido");
        System.out.println("'1' para continuar/'2' para cancelar");
        Scanner sc = new Scanner(in);
        int option = Integer.valueOf(sc.nextLine());
        if(option == 1){
            //RegistroDao.borrarPartidoDB(partido);
            return true;
        }else{
            System.out.println("se a canselado");
           return false;
        }
    }
  
    public static void crearEquipo(ArrayList<Equipo> equipos,String name){
          
        Equipo equipo = new Equipo(name);
        //RegistroDao.subirEquipoDB(equipo);
        //ArrayList<Equipo> eAux =RegistroDao.traerEquipo();
        //equipos.add(eAux.get(eAux.size()-1));
        equipo.setId_equipo(equipos.size());
        equipos.add(equipo);
    }
    
    public static void editarEquipo(Equipo e){
        Scanner sc = new Scanner(in);
        System.out.println("Ingrese nombre del equipo");
        String nombre = sc.nextLine();
        e.setNombre(nombre);
        //RegistroDao.editarEquipoDB(e);
    }   
    
    public static void mostrarEquipos(ArrayList<Equipo> equipos){
     for(Equipo e: equipos){
            System.out.println("id: " + e.getId_equipo() + " nombre: " + e.getNombre());
        }
    }
    
    public static void mostrarEstadisticasEquipo(Equipo e){
        
            System.out.println("id: " + e.getId_equipo() + " nombre: " + e.getNombre() + "\n partidos" + ""
            + "\n jugados: " + e.getPartidos_jugados()
            + " ganados: " + e.getPartidos_ganados()
            + " empatados: " + e.getPartidos_empatados()
            + " perdidos: " + e.getPartidos_perdidos()
            + "\n Goles"
            + "\n a favor: " + e.getGoles_a_favor()
            + " en contra: " + e.getGoles_en_contra());
        
    }
    
    public static Equipo seachEquipoById(int id, ArrayList<Equipo>equipos){
        int i = 0;
        for(Equipo e: equipos){
            i++;
            if(equipos.get(i-1).getId_equipo() == id){
                return e;
            }         
        }
        System.out.println("No se encontro el equipo");
        return null;
    }
    
    public static boolean borrarEquipo(Equipo e){
        System.out.println("Seguro quire borrar el equipo");
        System.out.println("'1' para continuar/'2' para cancelar");
        Scanner sc = new Scanner(in);
        int option = Integer.valueOf(sc.nextLine());
        if(option == 1){
            //RegistroDao.borrarEquipoDB(e);
            return true;
        }else{
            System.out.println("se a canselado");
           return false;
        }
    }
}
