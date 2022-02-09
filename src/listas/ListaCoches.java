package listas;

import modelos.Coche;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ListaCoches implements Serializable {

    private static final long serialVersionUID = 1L;

    Map<String, Coche> lista = new HashMap<>();

    public boolean insertarVehiculo(Coche coche){
        boolean ok=false;
        if(coche!=null){
            lista.put(coche.getMatricula(),coche);
            ok=true;
        }
        return ok;
    }

    public Coche buscarVehiculo(String matricula){
        Coche coche = null;
        coche = lista.get(matricula);
        return coche;
    }

    public Coche posicionVehiculo(Integer posicion){
        Coche coche = null;
        coche = lista.get(posicion);
        return coche;
    }

    public boolean existeMatricula(String matricula){
        boolean ok=false;
        ok=lista.containsKey(matricula);
        return ok;
    }
    public boolean existeCoche(Coche coche){
        boolean ok=false;
        ok=lista.containsValue(coche);
        return ok;
    }
    public Collection todosCoches(){
        Collection loscoches = lista.values();
        return loscoches;
    }
    public ArrayList<Coche> buscarCoches(String busqueda){
        ArrayList<Coche> listaEncontrados = new  ArrayList<>();
        Collection<Coche> listaActual = todosCoches();
        for (Coche coche : listaActual) {
            if ((coche.getMatricula().contains(busqueda))
                    || (coche.getModelo().contains(busqueda))) {
                listaEncontrados.add(coche);
            }
        }
        return listaEncontrados;
    }
    public boolean borrarVehiculo(String matricula){
        boolean ok = false;
        ok = existeMatricula(matricula);
        if(ok!=false){
            lista.remove(matricula);
        }
        return ok;
    }
    public boolean estaVacia(){
        boolean ok = false;
        if (lista.isEmpty()) {
            ok=true;
            System.out.println("La lista de coches esta vacia");
        }
        return ok;
    }
    public boolean vaciarLista(){
        boolean ok = false;
        lista.clear();
        if (lista.isEmpty()) {
            ok=true;
            System.out.println("La lista de coches ha sido vaciada");
        }
        return ok;
    }

}
