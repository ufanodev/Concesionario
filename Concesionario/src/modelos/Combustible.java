package modelos;

public class Combustible {

    public enum Energia {Gasolina, Diesel, GLP, Electrico};

    public static Energia motorEnergia(String motor){
        Energia tipo = null;
        switch(motor){
            case "Gasolina":
                tipo = Energia.Gasolina;
                break;
            case "Diesel":
                tipo = Energia.Diesel;
                break;
            case "GLP":
                tipo = Energia.GLP;
                break;
            case "Electrico":
                tipo = Energia.Electrico;
                break;
            default:
                tipo = Energia.Gasolina;
                break;
        }
        return tipo;
    }
    public static String energiaMotor(Energia energia){
        String tipo = null;
        switch(energia){
            case Gasolina:
                tipo = "Gasolina";
                break;
            case Diesel :
                tipo = "Diesel";
                break;
            case GLP:
                tipo = "GLP";
                break;
            case Electrico:
                tipo = "Electrico";
                break;
            default:
                tipo = "Gasolina";
                break;
        }
        return tipo;
    }
}
