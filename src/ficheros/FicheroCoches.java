package ficheros;

import listas.ListaCoches;

import java.io.*;

public class FicheroCoches {

    private final String RUTA_FICHERO ="coches.dat";

    public void guardarFichero(ListaCoches lista) throws IOException {

        ObjectOutputStream serializador = null;

        serializador = new ObjectOutputStream(new FileOutputStream(RUTA_FICHERO));
        serializador.writeObject(lista);
        if (serializador != null)
            serializador.close();
    }

    public ListaCoches cargarFichero() throws FileNotFoundException, ClassNotFoundException, IOException {

        ListaCoches lista = new ListaCoches();
        ObjectInputStream deserializador = null;

        deserializador = new ObjectInputStream(new FileInputStream(RUTA_FICHERO));
        lista = (ListaCoches) deserializador.readObject();


        if (deserializador == null)
            deserializador.close();

        return lista;
    }

    public boolean existeFichero() throws FileNotFoundException, IOException{
        boolean ok = true;
        ObjectInputStream deserializador = null;
        try{
            deserializador = new ObjectInputStream(new FileInputStream(RUTA_FICHERO));
            if (deserializador == null)
                deserializador.close();
        }catch(FileNotFoundException ex){
            ok=false;
            System.out.println("ERROR ARCHIVO "+ex);
            return ok;
        }
        return ok;
    }
}
