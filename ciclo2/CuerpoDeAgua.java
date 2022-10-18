public class CuerpoDeAgua {

    private String nombre;
    private double id;
    private String municipio;
    private double IRCA;

    public CuerpoDeAgua(String nombre, double id, String municipio, double IRCA) {
        this.nombre = nombre;
        this.id = id;
        this.municipio = municipio;
        this.IRCA = IRCA;
    }

    public String[] nivel() {

        String nivelRiesgo = "";
        String entidadNotificar = "";

        if (this.IRCA >= 80.1 && this.IRCA <= 100) {
            nivelRiesgo = "INVIABLE SANITARIAMENTE";
            entidadNotificar = "GOBERNACION";
        } else if (this.IRCA >= 35.1 && this.IRCA <= 80) {
            nivelRiesgo = "ALTO";
            entidadNotificar = "ALCALDIA";
        } else if (this.IRCA >= 14.1 && this.IRCA <= 35) {
            nivelRiesgo = "MEDIO";
            entidadNotificar = "PERSONA PRESTADORA";
        } else if (this.IRCA >= 5.1 && this.IRCA <= 14) {
            nivelRiesgo = "BAJO";
            entidadNotificar = "PERSONA PRESTADORA";
        } else if (this.IRCA >= 0 && this.IRCA <= 5) {
            nivelRiesgo = "SIN RIESGO";
            entidadNotificar = "CONTINUAR VIGILANCIA";
        }

        String[] array = new String[2];
        array[0] = nivelRiesgo;
        array[1] = entidadNotificar;

        return array;

    }

    public double getId() {
        return this.id;
    }

    public double getIRCA() {
        return this.IRCA;
    }

}