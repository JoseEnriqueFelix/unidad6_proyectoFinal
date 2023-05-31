import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main{
    
    static final int SALARIONORMALHORA=25;
    static final double SALARIOEXTRAHORA=37.5;
    static final int COSTOESPERACAMIONHORA=100;
    static final int COSTOOPERACIOALMACENHORA=500;
    static final int NUMERODETURNOS=60;

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
        ArrayList<Camion> listaCamiones3=new ArrayList<>();
        ArrayList<Empleado> listaEmpleados3=new ArrayList<>();
        int [] camionesPorTurno3=new int [NUMERODETURNOS];
        System.out.println("CASO 3 EMPLEADOS\n");
        for(int i=0; i<NUMERODETURNOS; i++){
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
                if(camion2.getTiempoDeLlegada()>510){
                    break;
                }
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
                if(reloj>510){
                    Empleado empleado=new Empleado(0);
                    empleado.setTiempoExtra(reloj-510);
                    listaEmpleados3.add(empleado);
                }
                int tamañoCola=determinarTamañoDeLaCola(colaCamiones, reloj);
                colaCamiones.remove(0);
                System.out.format("%1s %20s %15s %15s %15s %15s %15s %15s %15s %15s", decimalFormat.format(random1), camion2.getTiempoEntreLlegada(), camion2.getTiempoDeLlegada(), 
                camion2.getIniciaServicio(), decimalFormat.format(random2), camion2.getTDescarga(), camion2.getTerminaServicio(), ocio, camion2.getTiempoEspera(), tamañoCola +"\n");
                listaCamiones3.add(camion2);
                camionesPorTurno3[i]++;
                
            }while(reloj<=510);
            colaCamiones.clear();
            System.out.println();

        }   
        double promedioTiempoExtra3=0;
        for(int i=0; i<listaEmpleados3.size(); i++){
            promedioTiempoExtra3+=listaEmpleados3.get(i).getTiempoExtra();
        }
        promedioTiempoExtra3/=NUMERODETURNOS;

        double promedioCamionesPorTurno3=0;
        for(int i=0; i<camionesPorTurno3.length; i++){
            promedioCamionesPorTurno3+=camionesPorTurno3[i];
        }
        promedioCamionesPorTurno3/=camionesPorTurno3.length;

        double promedioTiempoEspera3=0;
        for(int i=0; i<listaCamiones3.size(); i++){
            promedioTiempoEspera3+=listaCamiones3.get(i).getTiempoEspera();
        }
        promedioTiempoEspera3=(promedioTiempoEspera3/listaCamiones3.size())*promedioCamionesPorTurno3;

        ArrayList<Camion> listaCamiones4=new ArrayList<>();
        ArrayList<Empleado> listaEmpleados4=new ArrayList<>();
        int [] camionesPorTurno4=new int [NUMERODETURNOS];
        System.out.println("CASO 4 EMPLEADOS\n");
        for(int i=0; i<NUMERODETURNOS; i++){
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
                if(camion2.getTiempoDeLlegada()>510){
                    break;
                }
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
                if(reloj>510){
                    Empleado empleado=new Empleado(0);
                    empleado.setTiempoExtra(reloj-510);
                    listaEmpleados4.add(empleado);
                }
                int tamañoCola=determinarTamañoDeLaCola(colaCamiones, reloj);
                colaCamiones.remove(0);
                System.out.format("%1s %20s %15s %15s %15s %15s %15s %15s %15s %15s", decimalFormat.format(random1), camion2.getTiempoEntreLlegada(), camion2.getTiempoDeLlegada(), 
                camion2.getIniciaServicio(), decimalFormat.format(random2), camion2.getTDescarga(), camion2.getTerminaServicio(), ocio, camion2.getTiempoEspera(), tamañoCola +"\n");
                listaCamiones4.add(camion2);
                camionesPorTurno4[i]++;
                
            }while(reloj<=510);
            colaCamiones.clear();
            System.out.println();

        }  

        double promedioTiempoExtra4=0;
        for(int i=0; i<listaEmpleados4.size(); i++){
            promedioTiempoExtra4+=listaEmpleados4.get(i).getTiempoExtra();
        }
        promedioTiempoExtra4/=NUMERODETURNOS;

        double promedioCamionesPorTurno4=0;
        for(int i=0; i<camionesPorTurno4.length; i++){
            promedioCamionesPorTurno4+=camionesPorTurno4[i];
        }
        promedioCamionesPorTurno4/=camionesPorTurno4.length;

        double promedioTiempoEspera4=0;
        for(int i=0; i<listaCamiones4.size(); i++){
            promedioTiempoEspera4+=listaCamiones4.get(i).getTiempoEspera();
        }
        promedioTiempoEspera4=(promedioTiempoEspera4/listaCamiones4.size())*promedioCamionesPorTurno4;
        
        ArrayList<Camion> listaCamiones5=new ArrayList<>();
        ArrayList<Empleado> listaEmpleados5=new ArrayList<>();
        int [] camionesPorTurno5=new int [NUMERODETURNOS];
        System.out.println("CASO 5 EMPLEADOS\n");
        for(int i=0; i<NUMERODETURNOS; i++){
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
                if(camion2.getTiempoDeLlegada()>510){
                    break;
                }
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
                if(reloj>510){
                    Empleado empleado=new Empleado(0);
                    empleado.setTiempoExtra(reloj-510);
                    listaEmpleados5.add(empleado);
                }
                int tamañoCola=determinarTamañoDeLaCola(colaCamiones, reloj);
                colaCamiones.remove(0);
                System.out.format("%1s %20s %15s %15s %15s %15s %15s %15s %15s %15s", decimalFormat.format(random1), camion2.getTiempoEntreLlegada(), camion2.getTiempoDeLlegada(), 
                camion2.getIniciaServicio(), decimalFormat.format(random2), camion2.getTDescarga(), camion2.getTerminaServicio(), ocio, camion2.getTiempoEspera(), tamañoCola +"\n");
                listaCamiones5.add(camion2);
                camionesPorTurno5[i]++;
                
            }while(reloj<=510);
            colaCamiones.clear();
            System.out.println();

        }

        double promedioTiempoExtra5=0;
        for(int i=0; i<listaEmpleados5.size(); i++){
            promedioTiempoExtra5+=listaEmpleados5.get(i).getTiempoExtra();
        }
        promedioTiempoExtra5/=NUMERODETURNOS;

        double promedioCamionesPorTurno5=0;
        for(int i=0; i<camionesPorTurno5.length; i++){
            promedioCamionesPorTurno5+=camionesPorTurno5[i];
        }
        promedioCamionesPorTurno5/=camionesPorTurno5.length;

        double promedioTiempoEspera5=0;
        for(int i=0; i<listaCamiones5.size(); i++){
            promedioTiempoEspera5+=listaCamiones5.get(i).getTiempoEspera();
        }
        promedioTiempoEspera5=(promedioTiempoEspera5/listaCamiones5.size())*promedioCamionesPorTurno5;

        ArrayList<Camion> listaCamiones6=new ArrayList<>();
        ArrayList<Empleado> listaEmpleados6=new ArrayList<>();
        int [] camionesPorTurno6=new int [NUMERODETURNOS];
        System.out.println("CASO 6 EMPLEADOS\n");
        for(int i=0; i<NUMERODETURNOS; i++){
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
                if(camion2.getTiempoDeLlegada()>510){
                    break;
                }
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
                if(reloj>510){
                    Empleado empleado=new Empleado(0);
                    empleado.setTiempoExtra(reloj-510);
                    listaEmpleados6.add(empleado);
                }
                int tamañoCola=determinarTamañoDeLaCola(colaCamiones, reloj);
                colaCamiones.remove(0);
                System.out.format("%1s %20s %15s %15s %15s %15s %15s %15s %15s %15s", decimalFormat.format(random1), camion2.getTiempoEntreLlegada(), camion2.getTiempoDeLlegada(), 
                camion2.getIniciaServicio(), decimalFormat.format(random2), camion2.getTDescarga(), camion2.getTerminaServicio(), ocio, camion2.getTiempoEspera(), tamañoCola +"\n");
                listaCamiones6.add(camion2);
                camionesPorTurno6[i]++;
                
            }while(reloj<=510);
            colaCamiones.clear();
            System.out.println();

        }

        double promedioTiempoExtra6=0;
        for(int i=0; i<listaEmpleados6.size(); i++){
            promedioTiempoExtra6+=listaEmpleados6.get(i).getTiempoExtra();
        }
        promedioTiempoExtra6/=NUMERODETURNOS;

        double promedioCamionesPorTurno6=0;
        for(int i=0; i<camionesPorTurno6.length; i++){
            promedioCamionesPorTurno6+=camionesPorTurno6[i];
        }
        promedioCamionesPorTurno6/=camionesPorTurno6.length;

        double promedioTiempoEspera6=0;
        for(int i=0; i<listaCamiones6.size(); i++){
            promedioTiempoEspera6+=listaCamiones6.get(i).getTiempoEspera();
        }
        promedioTiempoEspera6=(promedioTiempoEspera6/listaCamiones6.size())*promedioCamionesPorTurno6;

        System.out.format("%1s %20s %20s %20s %20s %20s", "TamañoEquipo", "SalarioNormal", "SalarioExtra", "OcioCamion", 
            "OperacionAlmacen", "CostosTotales\n");
        for (int i=3; i<=6; i++){
            double salarioExtra=0;
            double ocioCamion=0;
            if(i==3){
                salarioExtra=(promedioTiempoExtra3/60)*SALARIOEXTRAHORA;
                ocioCamion=(promedioTiempoEspera3/60)*COSTOESPERACAMIONHORA;
            }else if(i==4){
                salarioExtra=(promedioTiempoExtra4/60)*SALARIOEXTRAHORA;
                ocioCamion=(promedioTiempoEspera4/60)*COSTOESPERACAMIONHORA;
            }else if(i==5){
                salarioExtra=(promedioTiempoExtra5/60)*SALARIOEXTRAHORA;
                ocioCamion=(promedioTiempoEspera5/60)*COSTOESPERACAMIONHORA;
            }else{
                salarioExtra=(promedioTiempoExtra6/60)*SALARIOEXTRAHORA;
                ocioCamion=(promedioTiempoEspera6/60)*COSTOESPERACAMIONHORA;
            }
            System.out.format("%12s %20s %20s %20s %20s %20s", i, i*8*SALARIONORMALHORA, salarioExtra*i, ocioCamion, 
            "OperacionAlmacen", "CostosTotales\n");
        }
    }
}        
        