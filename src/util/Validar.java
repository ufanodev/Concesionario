package util;

public class Validar {

    public static boolean esMatricula(String matricula){
        boolean ok = false;
        if (matricula.toUpperCase().matches("^[0-9]{4}[A-Z]{3}$"))
            ok = true;
        return ok;
    }

}
