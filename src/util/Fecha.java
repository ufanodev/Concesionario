package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Fecha {

    //Convierte una fecha SQL a String
    public static String sqlDateToString(java.sql.Date lafecha){
        String sfecha="";
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sfecha = sdf.format(lafecha);
        return sfecha;
    }

    //Convierte una fecha String a SQL
    public static java.sql.Date stringToSQLDate(String fecha){
        java.sql.Date sqlDate = java.sql.Date.valueOf(fecha);
        return sqlDate;
    }

    //Convierte una fecha String a Util.Date
    public static Date stringToDate(String fecha) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date mifecha = sdf.parse(fecha);
        return mifecha;
    }

    //Convierte una fecha util.Date to String
    public static String dateToString(Date lafecha){
        String sfecha="";
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sfecha = sdf.format(lafecha);
        return sfecha;
    }


}
