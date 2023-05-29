import java.time.LocalTime;

public class Camion {
    private String nombre;
    private int tDescarga;
    private int tiempoEntreLlegada;
    private int tiempoDeLlegada;
    private int iniciaServicio;
    private int terminaServicio;
    private int tiempoEspera;

    public Camion(String nombre, int tDescarga, int tiempoEntreLlegada, int tiempoDeLlegada, int iniciaServicio, 
    int terminaServicio, int tiempoEspera){
        this.nombre=nombre;
        this.tDescarga=tDescarga;
        this.tiempoEntreLlegada=tiempoEntreLlegada;
        this.tiempoDeLlegada=tiempoDeLlegada;
        this.iniciaServicio=iniciaServicio;
        this.terminaServicio=terminaServicio;
        this.tiempoEspera=tiempoEspera;
    }

    public String getNombre(){
        return nombre;
    }

    public int getTDescarga(){
        return tDescarga;
    }

    public void setTDescarga(int tDescarga){
        this.tDescarga=tDescarga;
    }

    public int getTiempoEntreLlegada(){
        return tiempoEntreLlegada;
    }

    public void setTiempoEntreLlegada(int tiempoEntreLlegada){
        this.tiempoEntreLlegada=tiempoEntreLlegada;
    }

    public int getTiempoDeLlegada(){
        return tiempoDeLlegada;
    }

    public void setTiempoDeLlegada(int tiempoDeLlegada){
        this.tiempoDeLlegada=tiempoDeLlegada;
    }

    public int getIniciaServicio(){
        return iniciaServicio;
    }

    public void setIniciaServicio(int iniciaServicio){
        this.iniciaServicio=iniciaServicio;
    }

    public int getTerminaServicio(){
        return terminaServicio;
    }

    public void setTerminaServicio(int terminaServicio){
        this.terminaServicio=terminaServicio;
    }

    public int getTiempoEspera(){
        return tiempoEspera;
    }

    public void setTiempoEspera(int tiempoEspera){
        this.tiempoEspera=tiempoEspera;
    }
}
