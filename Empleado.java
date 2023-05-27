public class Empleado {
    private String nombre;
    private int salario;

    public Empleado(String nombre, int salario){
        this.nombre=nombre;
        this.salario=salario;
    }

    public String getNombre(){
        return nombre;
    }

    public int getSalario(){
        return salario;
    }

    public void setSalario(int salario){
        this.salario=salario;
    }
}
