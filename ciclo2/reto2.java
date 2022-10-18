import java.util.ArrayList;
import java.util.Scanner;

public class reto2 {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int cantidadCuerposAgua = sc.nextInt();
        sc.nextLine();

        double requiereAccion = 0;
        double ircaMenor = -1;
        ArrayList<String> riesgoAgua = new ArrayList<String>();
        ArrayList<Double> id = new ArrayList<Double>();
        ArrayList<Double> riesgoMedio = new ArrayList<Double>();

        for (int i = 0; i < cantidadCuerposAgua; i++) {
            String input = sc.nextLine();
            String arrayInput[] = input.split(" ");

            CuerpoDeAgua cuerpoAgua = new CuerpoDeAgua(arrayInput[0], Double.parseDouble(arrayInput[1]), arrayInput[2],
                    Double.parseDouble(arrayInput[3]));

            String[] nivelEntidad = cuerpoAgua.nivel();
            riesgoAgua.add(nivelEntidad[0]);
            id.add(cuerpoAgua.getId());

            if (nivelEntidad[1] == "ALCALDIA" || nivelEntidad[1] == "GOBERNACION") {
                requiereAccion++;
            }

            if (nivelEntidad[0] == "MEDIO") {
                riesgoMedio.add(cuerpoAgua.getIRCA());
            }

            if (ircaMenor == -1) {
                ircaMenor = cuerpoAgua.getIRCA();
            }

            if (cuerpoAgua.getIRCA() < ircaMenor) {
                ircaMenor = cuerpoAgua.getIRCA();
            }

        }

        sc.close();

        // outputs

        for (int i = 0; i < riesgoAgua.size(); i++) {
            System.out.println(riesgoAgua.get(i) + " " + String.format("%.2f", id.get(i)));
        }

        System.out.println(String.format("%.2f", requiereAccion));

        if (riesgoMedio.size() != 0) {
            for (int i = 0; i < riesgoMedio.size(); i++) {
                System.out.print(String.format("%.2f", riesgoMedio.get(i)) + " ");
            }
            System.out.println();
        } else {
            System.out.println("NA");
        }

        System.out.println(String.format("%.2f", ircaMenor));

    }

    public void nivel() {

    }
}
