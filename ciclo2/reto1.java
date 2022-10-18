import java.awt.List;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

// irca es un array con los porcentajes del indice riesgo calidad agua

public class reto1 {

    public static String ClasificarUno(float e) {

        String riesgo = "";

        if (e >= 80.1 && e <= 100) {
            riesgo = "INVIABLE SANITARIAMENTE";
        } else if (e >= 35.1 && e <= 80) {
            riesgo = "ALTO";
        } else if (e >= 14.1 && e <= 35) {
            riesgo = "MEDIO";
        } else if (e >= 5.1 && e <= 14) {
            riesgo = "BAJO";
        } else if (e >= 0 && e <= 5) {
            riesgo = "SIN RIESGO";
        }

        return riesgo;
    }

    public static float[] hallarDeMedioAltoBajo(float[] irca) {

        float alto = 0;
        float bajo = 0;

        for (float e : irca) {
            if (e >= 80.1 && e <= 100) {
                // riesgo = "INVIABLE SANITARIAMENTE";
            } else if (e >= 35.1 && e <= 80) {
                // riesgo = "ALTO";
            } else if (e >= 14.1 && e <= 35) {

                // riesgo = "MEDIO";

                if (alto == 0 && bajo == 0) {
                    bajo = e;
                    alto = e;
                }

                if (e >= alto) {
                    alto = e;
                }
                if (e <= bajo) {
                    bajo = e;
                }

            } else if (e >= 5.1 && e <= 14) {
                // riesgo = "BAJO";
            } else if (e >= 0 && e <= 5) {
                // riesgo = "SIN RIESGO";
            }
        }

        float[] medio = new float[2];
        medio[0] = alto;
        medio[1] = bajo;

        return medio;

    }

    public static float PromediarIrca(float[] irca) {

        float promedio = 0;

        for (int i = 0; i < irca.length; i++) {
            promedio += irca[i];
        }

        promedio = promedio / irca.length;

        return promedio;
    }

    public static void main(String[] args) {

        try {

            Scanner sc = new Scanner(System.in);

            int quantity = sc.nextInt();
            sc.nextLine();

            float irca[] = new float[quantity];

            String data = sc.nextLine();
            String dataArray[] = data.split(" ");

            for (int i = 0; i < irca.length; i++) {
                irca[i] = Float.parseFloat(dataArray[i]);
            }

            sc.close();

            // for (var dt : irca) {
            // System.out.println(dt);
            // }

            float promedio = PromediarIrca(irca);
            String clasificacion = ClasificarUno(promedio);
            System.out.println(clasificacion);
            float[] altoBajo = hallarDeMedioAltoBajo(irca);
            float alto = altoBajo[0];
            float bajo = altoBajo[1];

            if (alto == 0 && bajo == 0) {
                System.out.println("NA");
                System.out.println("NA");
            } else {
                DecimalFormat numberFormat = new DecimalFormat("#.00");
                String a = numberFormat.format(alto);
                String b = numberFormat.format(bajo);
                System.out.println(b);
                System.out.println(a);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}