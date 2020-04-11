package rdpw;

public class Partidos {
    private int id_partido;
    private int id_local;
    private int id_visitante;
    private int goles_local;
    private int goles_visitante;
    String tipo_partido;

    public Partidos() {

    }

    public String getTipo_partido() {
        return tipo_partido;
    }

    public void setTipo_partido(String tipo_partido) {
        this.tipo_partido = tipo_partido;
    }
    
    public int getId_partido() {
        return id_partido;
    }

    public void setId_partido(int id_partido) {
        this.id_partido = id_partido;
    }

    public int getId_local() {
        return id_local;
    }

    public void setId_local(int id_local) {
        this.id_local = id_local;
    }

    public int getId_visitante() {
        return id_visitante;
    }

    public void setId_visitante(int id_visitante) {
        this.id_visitante = id_visitante;
    }

    public int getGoles_local() {
        return goles_local;
    }

    public void setGoles_local(int goles_local) {
        this.goles_local = goles_local;
    }

    public int getGoles_visitante() {
        return goles_visitante;
    }

    public void setGoles_visitante(int goles_visitante) {
        this.goles_visitante = goles_visitante;
    }
    
    public void showPartidos(){
        
        System.out.println(this.id_partido);
        System.out.println(this.id_local);
        System.out.println(this.id_visitante);
        System.out.println(this.goles_local);
        System.out.println(this.goles_visitante);
    }
    
    
    
}
