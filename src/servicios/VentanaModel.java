package servicios;

import ficheros.FicheroCoches;
import listas.ListaCoches;
import modelos.Coche;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class VentanaModel {

    private ListaCoches coches;
    private FicheroCoches fichero = new FicheroCoches();

    private int posicion;

    public VentanaModel() throws ClassNotFoundException, IOException {
        if(fichero.existeFichero()){
            coches = fichero.cargarFichero();
        }else{
            System.out.println("EL FICHERO DE COCHES NO EXISTE");
            coches = new ListaCoches();
        }
        posicion = 0;
    }
    // ALTA DE UN VEHICULO
    public void altaCoche(Coche coche){
        coches.insertarVehiculo(coche);
        posicion++;
    }
    // MODIFICACION UN VEHICULO
    public void modificarCoche(Coche nuevoCoche, String matricula){

        Coche coche = coches.buscarVehiculo(matricula);
        coche.setMatricula(nuevoCoche.getMatricula());
        coche.setModelo(nuevoCoche.getModelo());
        coche.setFechaCompra(nuevoCoche.getFechaCompra());
        coche.setPotencia(nuevoCoche.getPotencia());
        coche.setCombustible(nuevoCoche.getCombustible());
        coche.setHibrido(nuevoCoche.isHibrido());
    }
    // ELIMINACIÖN DE UN COCHE
    public void eliminaCoche(String matricula){
        coches.borrarVehiculo(matricula);
    }
    //POSICION ACTUAL
    public Coche getActual(Integer posicion) {
        return coches.posicionVehiculo(posicion);
    }

    //BUSCAR COCHE POR MATRICULA
    public Coche obtenerCoche(String matricula){
        Coche coche = coches.buscarVehiculo(matricula);
        return coche;
    }
    public ArrayList<Coche> buscarCoches(String busqueda){
        ArrayList<Coche> lista = new ArrayList<>();
        Collection<Coche> listaActual = obtenerCoches();
        for (Coche coche : listaActual) {
            if ((coche.getMatricula().contains(busqueda))
                    || (coche.getModelo().contains(busqueda))) {
                lista.add(coche);
            }
        }
        return lista;
    }
    //EXISTE COCHE
    public boolean existeMatricula(String matricula){
        boolean ok = false;
        ok = coches.existeMatricula(matricula);
        return ok;
    }
    //TODOS LOS COCHES
    public ArrayList<Coche> obtenerCoches(String busqueda){
        ArrayList<Coche> listaEncontrados = new ArrayList<Coche>();
        listaEncontrados=coches.buscarCoches(busqueda);
        return listaEncontrados;
    }
    public Collection<Coche> obtenerCoches() {
        return coches.todosCoches();
    }
    //GUARDAR FICHERO
    public void guardarFichero() throws IOException{
        fichero.guardarFichero(coches);
    }
    //CARGAR FICHERO
    public void cargarFichero() throws IOException, FileNotFoundException, ClassNotFoundException{
        fichero.cargarFichero();
    }
    //POSICION ACTUAL
    public Coche getActual() {
        return coches.posicionVehiculo(posicion);
    }

}
