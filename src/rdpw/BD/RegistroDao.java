package rdpw.BD;

import rdpw.BD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import rdpw.Equipo;
import rdpw.Partidos;


public class RegistroDao {
    public static ArrayList<Partidos> traerPartidos(){
        Conexion db_conect = new Conexion();
        ArrayList<Partidos> partidos = new ArrayList();
        Partidos partidoaux = new Partidos();
        
        PreparedStatement ps= null;
        ResultSet rs = null;
        
        try(Connection conexion = db_conect.get_connection()){
            String query ="SELECT * FROM partidos";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){   
                
                partidoaux.setId_partido(rs.getInt("id_partido"));
                partidoaux.setId_local(rs.getInt("id_local"));
                partidoaux.setId_visitante(rs.getInt("id_visitante"));
                partidoaux.setGoles_local(rs.getInt("goles_local"));
                partidoaux.setGoles_visitante(rs.getInt("goles_visitante"));
                
                partidos.add(partidoaux);
                
            }
            
        }catch(SQLException e){
            System.out.println("No se pudieron recuperar los datos");
            System.out.println(e);
        }
        
        
        return partidos;
    }
    
    public static void subirPartidoDB(Partidos partido){
        Conexion db_conect = new Conexion();
        
        try(Connection conexion = db_conect.get_connection()){
            PreparedStatement ps= null;
            try{
                //haciendo el query
                String query = "INSERT INTO partidos (id_partido, id_local, id_visitante, goles_local, goles_visitante, tipo_partido)"
                        + " VALUES (NULL, ?, ?, ?, ?, ?)";
                ps=conexion.prepareStatement(query);
                //agregando los calores del equipo qeu viene por parametro
                ps.setInt(1, partido.getId_local());
                ps.setInt(2, partido.getId_visitante());
                ps.setInt(3, partido.getGoles_local());
                ps.setInt(4, partido.getGoles_visitante());
                ps.setString(5, partido.getTipo_partido());
                ps.executeUpdate();
                System.out.println("Partido subido");
            }catch(SQLException ex){
                System.out.println(ex);
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void borrarPartidoDB(Partidos partido){
        Conexion db_conect = new Conexion();
                
        try(Connection conexion = db_conect.get_connection()){
            PreparedStatement ps= null;
            try{
                
                String query = "DELETE FROM partidos WHERE id_partido = ?";
                ps=conexion.prepareStatement(query);
                ps.setInt(1, partido.getId_partido());
                ps.executeUpdate();
                System.out.println("el partido ha sido borrado");
                
            }catch(SQLException ex){
            System.out.println("no se pudo borrar el partido");
            System.out.println(ex);
            }
            
        }catch(SQLException e){
            System.out.println("");
            System.out.println(e);
        
        }
    }
    
    public static ArrayList<Equipo> traerEquipo(){
        Conexion db_conect = new Conexion();
        ArrayList<Equipo> equipos = new ArrayList();
        
        
        PreparedStatement ps= null;
        ResultSet rs = null;
        
        try(Connection conexion = db_conect.get_connection()){
            String query ="SELECT * FROM equipos";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){   
                Equipo equipoaux = new Equipo();
                equipoaux.setId_equipo(rs.getInt("id_equipo"));
                equipoaux.setNombre(rs.getString("nombre"));
                equipoaux.setPartidos_jugados(rs.getInt("partidos_jugados"));
                equipoaux.setPartidos_ganados(rs.getInt("partidos_ganados"));
                equipoaux.setPartidos_empatados(rs.getInt("partidos_empatados"));
                equipoaux.setPartidos_perdidos(rs.getInt("partidos_perdidos"));
                equipoaux.setGoles_a_favor(rs.getInt("goles_a_favor"));
                equipoaux.setGoles_en_contra(rs.getInt("partidos_ganados"));
                
                equipos.add(equipoaux);
                
            }
            
        }catch(SQLException e){
            System.out.println("No se pudieron recuperar los datos");
            System.out.println(e);
        }
        
        
        return equipos;
    }
     
    public static void subirEquipoDB(Equipo equipo){
        Conexion db_conect = new Conexion();
        
        try(Connection conexion = db_conect.get_connection()){
            PreparedStatement ps= null;
            try{
                //haciendo el query
                String query = "INSERT INTO equipos (id_equipo, nombre, partidos_jugados, partidos_ganados, partidos_empatados, partidos_perdidos, goles_a_favor, goles_en_contra)"
                        + " VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";
                ps=conexion.prepareStatement(query);
                //agregando los calores del equipo qeu viene por parametro
                ps.setString(1, equipo.getNombre());
                ps.setInt(2, equipo.getPartidos_jugados());
                ps.setInt(3, equipo.getPartidos_ganados());
                ps.setInt(4, equipo.getPartidos_empatados());
                ps.setInt(5, equipo.getPartidos_perdidos());
                ps.setInt(6, equipo.getGoles_a_favor());
                ps.setInt(7, equipo.getGoles_en_contra());
                
                ps.executeUpdate();
                System.out.println("equipo subido");
            }catch(SQLException ex){
                System.out.println(ex);
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void editarEquipoDB(Equipo equipo){
       Conexion db_conect = new Conexion();
               System.out.println("0");

         try(Connection conexion = db_conect.get_connection()){
             PreparedStatement ps= null;
             try{
                String query = "UPDATE equipos SET nombre = ?, partidos_jugados = ?, partidos_ganados = ?, partidos_empatados = ?, partidos_perdidos = ?, goles_a_favor = ?, goles_en_contra = ? WHERE id_equipo = ?";
                ps=conexion.prepareStatement(query);
                ps.setString(1, equipo.getNombre());
                ps.setInt(2, equipo.getPartidos_jugados());
                ps.setInt(3, equipo.getPartidos_ganados());
                ps.setInt(4, equipo.getPartidos_empatados());
                ps.setInt(5, equipo.getPartidos_perdidos());
                ps.setInt(6, equipo.getGoles_a_favor());
                ps.setInt(7, equipo.getGoles_en_contra());
                ps.setInt(8, equipo.getId_equipo());
                ps.executeUpdate();
                System.out.println("equipo actualizado!");
                
            }catch(SQLException ex){
            System.out.println("no se pudo actualizar el equipo");
            }
         }catch(SQLException ex){
            System.out.println("");
            System.out.println(ex);
        
            }
    }
    
    public static void borrarEquipoDB(Equipo equipo){
    Conexion db_conect = new Conexion();
                
        try(Connection conexion = db_conect.get_connection()){
            PreparedStatement ps= null;
            try{
                
                String query = "DELETE FROM equipos WHERE id_equipo = ?";
                ps=conexion.prepareStatement(query);
                ps.setInt(1, equipo.getId_equipo());
                ps.executeUpdate();
                System.out.println("elequipo ha sido borrado");
                
            }catch(SQLException ex){
            System.out.println("no se pudo borrar el equipo");
            System.out.println(ex);
            }
            
        }catch(SQLException e){
            System.out.println("");
            System.out.println(e);
        
        }
    }
 }

