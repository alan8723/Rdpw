package rdpw;

public class Equipo {
    private int id_equipo;
    private String nombre;
    private int partidos_jugados;
    private int partidos_ganados;
    private int partidos_empatados;
    private int partidos_perdidos;
    private int goles_a_favor;
    private int goles_en_contra;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.partidos_jugados = 0;
        this.partidos_ganados = 0;
        this.partidos_empatados = 0;
        this.partidos_perdidos = 0;
        this.goles_a_favor = 0;
        this.goles_en_contra = 0;
    }
    
    public Equipo() {

    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPartidos_jugados() {
        return partidos_jugados;
    }

    public void setPartidos_jugados(int partidos_jugados) {
        this.partidos_jugados = partidos_jugados;
    }

    public int getPartidos_ganados() {
        return partidos_ganados;
    }

    public void setPartidos_ganados(int partidos_ganados) {
        this.partidos_ganados = partidos_ganados;
    }

    public int getPartidos_empatados() {
        return partidos_empatados;
    }

    public void setPartidos_empatados(int partidos_empatados) {
        this.partidos_empatados = partidos_empatados;
    }

    public int getPartidos_perdidos() {
        return partidos_perdidos;
    }

    public void setPartidos_perdidos(int partidos_pertidos) {
        this.partidos_perdidos = partidos_pertidos;
    }

    public int getGoles_a_favor() {
        return goles_a_favor;
    }

    public void setGoles_a_favor(int goles_a_favor) {
        this.goles_a_favor = goles_a_favor;
    }

    public int getGoles_en_contra() {
        return goles_en_contra;
    }

    public void setGoles_en_contra(int goles_en_contre) {
        this.goles_en_contra = goles_en_contre;
    }
    
    
    
    
}
