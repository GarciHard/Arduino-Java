package numeros;


/**
 * Hecho con <3 por:
 * @author GarciHard
 */

public class GeneradorAleatorio {
    public static void main(String[] args) {
        int temperatura;
        int humedadAmbiente;
        int humedadTierra;
        
        temperatura = (int) (Math.random() * (26 - 8) + 8);
        humedadAmbiente = (int) (Math.random() * (81 - 61) + 61);
        humedadTierra = (int) (Math.random() * (8 - 1) + 1);
        
        System.out.println("temp1 : " + temperatura);
        System.out.println("huma1 : " + humedadAmbiente);
        System.out.println("humt1 : " + humedadTierra);
        
    }

}
