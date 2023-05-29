import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main{
    
    final int salarioNormal_Hora=25;
    final double salarioExtra_Hora=37.5;
    final int costoEsperaCamion_Hora=100;
    final int costoOperacionAlmacen_Hora=500;

    static int precision = 5;
    static DecimalFormat decimalFormat = new DecimalFormat("#." + "0".repeat(precision));

    static int camionesEsperando(float rnd){
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

    static int tiempoEntreLlegadas(float rnd){
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

    static int tiempoDeServicioTres(float rnd){
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

    static int tiempoDeServicioCuatro(float rnd){
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

    static int tiempoDeServicioCinco(float rnd){
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

    static int tiempoDeServicioSeis(float rnd){
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

    static int determinarTamañoDeLaCola(ArrayList<Camion> colaCamiones, int reloj){
        int contador=0;
        for(int i=1; i<colaCamiones.size(); i++){
            if(colaCamiones.get(i).getTiempoDeLlegada() <= reloj){
                contador++;
            }
        }
        return contador;
    }

    public static void main(String[] args) {
        ArrayList<Camion> colaCamiones=new ArrayList<>();
        ArrayList<Camion> listaCamiones=new ArrayList<>();
        ArrayList<Empleado> listaEmpleados=new ArrayList<>();
        System.out.println("CASO 3 EMPLEADOS\n");
        for(int i=0; i<60; i++){
            colaCamiones.clear();
            int reloj=0;
            boolean receso=false;
            System.out.format("%1s %20s %15s %15s %15s %15s %15s %15s %15s %15s", "#alea1", "TentreLLegada", "TdeLLegada", 
            "IniciaServicio", "#alea2", "TdeServ", "TermServ", "Ocio", "TEspC", "LC\n");
            int camionesEsperando=camionesEsperando((float)Math.random());
            if(camionesEsperando>0){
                for(int j=0; j<camionesEsperando-1; j++){
                    colaCamiones.add(new Camion("Camion", 0, 0, 0, 0, 0, 0));
                }
            }
            colaCamiones.add(new Camion("Camion", 0, 0, 0, 0, 0, 0));

            int guardaIniciaServicio=0;
            //REVISAR
            int j=0;
            //
            do{
                if(reloj>=270 && !receso){
                    reloj+=30;
                    receso=true;
                }
                float random1=(float)Math.random();
                Camion camion1=new Camion("Camion", 0, 0, 0, 0, 0, 0);
                camion1.setTiempoEntreLlegada(tiempoEntreLlegadas(random1));
                if(colaCamiones.isEmpty()){
                    camion1.setTiempoDeLlegada(guardaIniciaServicio+camion1.getTiempoEntreLlegada());
                }
                else{
                    camion1.setTiempoDeLlegada(colaCamiones.get(colaCamiones.size()-1).getTiempoDeLlegada()+camion1.getTiempoEntreLlegada());
                }
                colaCamiones.add(camion1);
                Camion camion2=colaCamiones.get(0);
                if(reloj<camion2.getTiempoDeLlegada()){
                    camion2.setIniciaServicio(camion2.getTiempoDeLlegada());
                }
                else{
                    camion2.setIniciaServicio(reloj);
                }
                guardaIniciaServicio=camion2.getIniciaServicio();
                float random2=(float)Math.random();
                camion2.setTDescarga(tiempoDeServicioTres(random2));
                camion2.setTerminaServicio(camion2.getIniciaServicio() + camion2.getTDescarga());
                int ocio=0;
                if(reloj<camion2.getTiempoDeLlegada()){
                    ocio=camion2.getTiempoDeLlegada()-reloj;
                }
                camion2.setTiempoEspera(camion2.getIniciaServicio()-camion2.getTiempoDeLlegada());
                reloj=camion2.getTerminaServicio();
                int tamañoCola=determinarTamañoDeLaCola(colaCamiones, reloj);
                colaCamiones.remove(0);
                System.out.format("%1s %20s %15s %15s %15s %15s %15s %15s %15s %15s", decimalFormat.format(random1), camion2.getTiempoEntreLlegada(), camion2.getTiempoDeLlegada(), 
                camion2.getIniciaServicio(), decimalFormat.format(random2), camion2.getTDescarga(), camion2.getTerminaServicio(), ocio, camion2.getTiempoEspera(), tamañoCola +"\n");
                listaCamiones.add(camion2);
                
            }while(reloj<=510);
            colaCamiones.clear();
            System.out.println();

        }    

        System.out.println("CASO 4 EMPLEADOS\n");
        for(int i=0; i<60; i++){
            colaCamiones.clear();
            int reloj=0;
            boolean receso=false;
            System.out.format("%1s %20s %15s %15s %15s %15s %15s %15s %15s %15s", "#alea1", "TentreLLegada", "TdeLLegada", 
            "IniciaServicio", "#alea2", "TdeServ", "TermServ", "Ocio", "TEspC", "LC\n");
            int camionesEsperando=camionesEsperando((float)Math.random());
            if(camionesEsperando>0){
                for(int j=0; j<camionesEsperando-1; j++){
                    colaCamiones.add(new Camion("Camion", 0, 0, 0, 0, 0, 0));
                }
            }
            colaCamiones.add(new Camion("Camion", 0, 0, 0, 0, 0, 0));

            int guardaIniciaServicio=0;
            //REVISAR
            int j=0;
            //
            do{
                if(reloj>=270 && !receso){
                    reloj+=30;
                    receso=true;
                }
                float random1=(float)Math.random();
                Camion camion1=new Camion("Camion", 0, 0, 0, 0, 0, 0);
                camion1.setTiempoEntreLlegada(tiempoEntreLlegadas(random1));
                if(colaCamiones.isEmpty()){
                    camion1.setTiempoDeLlegada(guardaIniciaServicio+camion1.getTiempoEntreLlegada());
                }
                else{
                    camion1.setTiempoDeLlegada(colaCamiones.get(colaCamiones.size()-1).getTiempoDeLlegada()+camion1.getTiempoEntreLlegada());
                }
                colaCamiones.add(camion1);
                Camion camion2=colaCamiones.get(0);
                if(reloj<camion2.getTiempoDeLlegada()){
                    camion2.setIniciaServicio(camion2.getTiempoDeLlegada());
                }
                else{
                    camion2.setIniciaServicio(reloj);
                }
                guardaIniciaServicio=camion2.getIniciaServicio();
                float random2=(float)Math.random();
                camion2.setTDescarga(tiempoDeServicioCuatro(random2));
                camion2.setTerminaServicio(camion2.getIniciaServicio() + camion2.getTDescarga());
                int ocio=0;
                if(reloj<camion2.getTiempoDeLlegada()){
                    ocio=camion2.getTiempoDeLlegada()-reloj;
                }
                camion2.setTiempoEspera(camion2.getIniciaServicio()-camion2.getTiempoDeLlegada());
                reloj=camion2.getTerminaServicio();
                int tamañoCola=determinarTamañoDeLaCola(colaCamiones, reloj);
                colaCamiones.remove(0);
                System.out.format("%1s %20s %15s %15s %15s %15s %15s %15s %15s %15s", decimalFormat.format(random1), camion2.getTiempoEntreLlegada(), camion2.getTiempoDeLlegada(), 
                camion2.getIniciaServicio(), decimalFormat.format(random2), camion2.getTDescarga(), camion2.getTerminaServicio(), ocio, camion2.getTiempoEspera(), tamañoCola +"\n");
                listaCamiones.add(camion2);
                
            }while(reloj<=510);
            colaCamiones.clear();
            System.out.println();

        }  
        
        System.out.println("CASO 5 EMPLEADOS\n");
        for(int i=0; i<60; i++){
            colaCamiones.clear();
            int reloj=0;
            boolean receso=false;
            System.out.format("%1s %20s %15s %15s %15s %15s %15s %15s %15s %15s", "#alea1", "TentreLLegada", "TdeLLegada", 
            "IniciaServicio", "#alea2", "TdeServ", "TermServ", "Ocio", "TEspC", "LC\n");
            int camionesEsperando=camionesEsperando((float)Math.random());
            if(camionesEsperando>0){
                for(int j=0; j<camionesEsperando-1; j++){
                    colaCamiones.add(new Camion("Camion", 0, 0, 0, 0, 0, 0));
                }
            }
            colaCamiones.add(new Camion("Camion", 0, 0, 0, 0, 0, 0));

            int guardaIniciaServicio=0;
            //REVISAR
            int j=0;
            //
            do{
                if(reloj>=270 && !receso){
                    reloj+=30;
                    receso=true;
                }
                float random1=(float)Math.random();
                Camion camion1=new Camion("Camion", 0, 0, 0, 0, 0, 0);
                camion1.setTiempoEntreLlegada(tiempoEntreLlegadas(random1));
                if(colaCamiones.isEmpty()){
                    camion1.setTiempoDeLlegada(guardaIniciaServicio+camion1.getTiempoEntreLlegada());
                }
                else{
                    camion1.setTiempoDeLlegada(colaCamiones.get(colaCamiones.size()-1).getTiempoDeLlegada()+camion1.getTiempoEntreLlegada());
                }
                colaCamiones.add(camion1);
                Camion camion2=colaCamiones.get(0);
                if(reloj<camion2.getTiempoDeLlegada()){
                    camion2.setIniciaServicio(camion2.getTiempoDeLlegada());
                }
                else{
                    camion2.setIniciaServicio(reloj);
                }
                guardaIniciaServicio=camion2.getIniciaServicio();
                float random2=(float)Math.random();
                camion2.setTDescarga(tiempoDeServicioCinco(random2));
                camion2.setTerminaServicio(camion2.getIniciaServicio() + camion2.getTDescarga());
                int ocio=0;
                if(reloj<camion2.getTiempoDeLlegada()){
                    ocio=camion2.getTiempoDeLlegada()-reloj;
                }
                camion2.setTiempoEspera(camion2.getIniciaServicio()-camion2.getTiempoDeLlegada());
                reloj=camion2.getTerminaServicio();
                int tamañoCola=determinarTamañoDeLaCola(colaCamiones, reloj);
                colaCamiones.remove(0);
                System.out.format("%1s %20s %15s %15s %15s %15s %15s %15s %15s %15s", decimalFormat.format(random1), camion2.getTiempoEntreLlegada(), camion2.getTiempoDeLlegada(), 
                camion2.getIniciaServicio(), decimalFormat.format(random2), camion2.getTDescarga(), camion2.getTerminaServicio(), ocio, camion2.getTiempoEspera(), tamañoCola +"\n");
                listaCamiones.add(camion2);
                
            }while(reloj<=510);
            colaCamiones.clear();
            System.out.println();

        }

        System.out.println("CASO 6 EMPLEADOS\n");
        for(int i=0; i<60; i++){
            colaCamiones.clear();
            int reloj=0;
            boolean receso=false;
            System.out.format("%1s %20s %15s %15s %15s %15s %15s %15s %15s %15s", "#alea1", "TentreLLegada", "TdeLLegada", 
            "IniciaServicio", "#alea2", "TdeServ", "TermServ", "Ocio", "TEspC", "LC\n");
            int camionesEsperando=camionesEsperando((float)Math.random());
            if(camionesEsperando>0){
                for(int j=0; j<camionesEsperando-1; j++){
                    colaCamiones.add(new Camion("Camion", 0, 0, 0, 0, 0, 0));
                }
            }
            colaCamiones.add(new Camion("Camion", 0, 0, 0, 0, 0, 0));

            int guardaIniciaServicio=0;
            //REVISAR
            int j=0;
            //
            do{
                if(reloj>=270 && !receso){
                    reloj+=30;
                    receso=true;
                }
                float random1=(float)Math.random();
                Camion camion1=new Camion("Camion", 0, 0, 0, 0, 0, 0);
                camion1.setTiempoEntreLlegada(tiempoEntreLlegadas(random1));
                if(colaCamiones.isEmpty()){
                    camion1.setTiempoDeLlegada(guardaIniciaServicio+camion1.getTiempoEntreLlegada());
                }
                else{
                    camion1.setTiempoDeLlegada(colaCamiones.get(colaCamiones.size()-1).getTiempoDeLlegada()+camion1.getTiempoEntreLlegada());
                }
                colaCamiones.add(camion1);
                Camion camion2=colaCamiones.get(0);
                if(reloj<camion2.getTiempoDeLlegada()){
                    camion2.setIniciaServicio(camion2.getTiempoDeLlegada());
                }
                else{
                    camion2.setIniciaServicio(reloj);
                }
                guardaIniciaServicio=camion2.getIniciaServicio();
                float random2=(float)Math.random();
                camion2.setTDescarga(tiempoDeServicioSeis(random2));
                camion2.setTerminaServicio(camion2.getIniciaServicio() + camion2.getTDescarga());
                int ocio=0;
                if(reloj<camion2.getTiempoDeLlegada()){
                    ocio=camion2.getTiempoDeLlegada()-reloj;
                }
                camion2.setTiempoEspera(camion2.getIniciaServicio()-camion2.getTiempoDeLlegada());
                reloj=camion2.getTerminaServicio();
                int tamañoCola=determinarTamañoDeLaCola(colaCamiones, reloj);
                colaCamiones.remove(0);
                System.out.format("%1s %20s %15s %15s %15s %15s %15s %15s %15s %15s", decimalFormat.format(random1), camion2.getTiempoEntreLlegada(), camion2.getTiempoDeLlegada(), 
                camion2.getIniciaServicio(), decimalFormat.format(random2), camion2.getTDescarga(), camion2.getTerminaServicio(), ocio, camion2.getTiempoEspera(), tamañoCola +"\n");
                listaCamiones.add(camion2);
                
            }while(reloj<=510);
            colaCamiones.clear();
            System.out.println();

        }
    }
}        
        