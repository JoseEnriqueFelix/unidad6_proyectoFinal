public class Main{
    
    final int salarioNormal_Hora=25;
    final double salarioExtra_Hora=37.5;
    final int costoEsperaCamion_Hora=100;
    final int costoOperacionAlmacen_Hora=500;

    static int camionesEsperando(double rnd){
        if(rnd<=0.5){
            return 0;
        }
        else if(rnd>0.5 && rnd<=0.75){
            return 1;
        }
        else if(rnd>0.75 && rnd<=0.9){
            return 2;
        }
        else{
            return 3;
        }
    }

    static int tiempoEntreLlegadas(double rnd){
        if(rnd<=0.02){
            return 20;
        }
        else if(rnd>0.2 && rnd<=0.1){
            return 25;
        }
        else if(rnd>0.1 && rnd<=0.22){
            return 30;
        }
        else if(rnd>0.22 && rnd<=0.47){
            return 35;
        }
        else if(rnd>0.47 && rnd<=0.67){
            return 40;
        }
        else if(rnd>0.67 && rnd<=0.82){
            return 45;
        }
        else if(rnd>0.82 && rnd<=0.92){
            return 50;
        }
        else if(rnd>0.92 && rnd<=0.97){
            return 55;
        }
        else{
            return 60;
        }
    }

    static int tiempoDeServicioTres(double rnd){
        if(rnd<=0.05){
            return 20;
        }
        else if(rnd>0.05 && rnd<=0.15){
            return 25;
        }
        else if(rnd>0.15 && rnd<=0.35){
            return 30;
        }
        else if(rnd>0.35 && rnd<=0.6){
            return 35;
        }
        else if(rnd>0.6 && rnd<=0.72){
            return 40;
        }
        else if(rnd>0.72 && rnd<=0.82){
            return 45;
        }
        else if(rnd>0.82 && rnd<=0.9){
            return 50;
        }
        else if(rnd>0.9 && rnd<=0.96){
            return 55;
        }
        else{
            return 60;
        }
    }

    static int tiempoDeServicioCuatro(double rnd){
        if(rnd<=0.05){
            return 15;
        }
        else if(rnd>0.05 && rnd<=0.2){
            return 20;
        }
        else if(rnd>0.2 && rnd<=0.4){
            return 25;
        }
        else if(rnd>0.4 && rnd<=0.6){
            return 30;
        }
        else if(rnd>0.6 && rnd<=0.75){
            return 35;
        }
        else if(rnd>0.75 && rnd<=0.87){
            return 40;
        }
        else if(rnd>0.87 && rnd<=0.95){
            return 45;
        }
        else if(rnd>0.95 && rnd<=0.99){
            return 50;
        }
        else{
            return 55;
        }
    }

    static int tiempoDeServicioCinco(double rnd){
        if(rnd<=0.1){
            return 10;
        }
        else if(rnd>0.1 && rnd<=0.28){
            return 15;
        }
        else if(rnd>0.28 && rnd<=0.5){
            return 20;
        }
        else if(rnd>0.5 && rnd<=0.68){
            return 25;
        }
        else if(rnd>0.68 && rnd<=0.78){
            return 30;
        }
        else if(rnd>0.78 && rnd<=0.86){
            return 35;
        }
        else if(rnd>0.86 && rnd<=0.92){
            return 40;
        }
        else if(rnd>0.92 && rnd<=0.97){
            return 45;
        }
        else{
            return 50;
        }
    }

    static int tiempoDeServicioSeis(double rnd){
        if(rnd<=0.12){
            return 5;
        }
        else if(rnd>0.12 && rnd<=0.27){
            return 10;
        }
        else if(rnd>0.27 && rnd<=0.53){
            return 15;
        }
        else if(rnd>0.53 && rnd<=0.68){
            return 20;
        }
        else if(rnd>0.68 && rnd<=0.8){
            return 25;
        }
        else if(rnd>0.8 && rnd<=0.88){
            return 30;
        }
        else if(rnd>0.88 && rnd<=0.94){
            return 35;
        }
        else if(rnd>0.94 && rnd<=0.98){
            return 40;
        }
        else{
            return 45;
        }
    }

    public static void main(String[] args) {
        
    }
}