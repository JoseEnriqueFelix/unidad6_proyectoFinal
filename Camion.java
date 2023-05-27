public class Camion {
    private String nombre;
    private int tDescarga;

    public Camion(String nombre, int tDescarga){
        this.nombre=nombre;
        this.tDescarga=tDescarga;
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
}
