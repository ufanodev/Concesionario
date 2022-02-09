package modelos;

import modelos.Combustible.Energia;

import java.io.Serializable;
import java.util.Date;

public class Coche implements Serializable {

    private static final long serialVersionUID = 1L;
    //Atributos
    private String matricula;
    private String modelo;
    private Date fechaCompra;
    private float potencia;
    private Energia combustible;
    private boolean hibrido;

    //Constructores

    public Coche(String matricula, String modelo, Date fechaCompra, float potencia, Energia combustible, boolean hibrido) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.fechaCompra = fechaCompra;
        this.potencia = potencia;
        this.combustible = combustible;
        this.hibrido = hibrido;
    }

    public Coche() {
    }

    //Getters & Setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public float getPotencia() {
        return potencia;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }

    public Energia getCombustible() {
        return combustible;
    }

    public void setCombustible(Energia combustible) {
        this.combustible = combustible;
    }

    public boolean isHibrido() {
        return hibrido;
    }

    public void setHibrido(boolean hibrido) {
        this.hibrido = hibrido;
    }

    //Info
    public String info(){
        String info = "COCHE **********"+
                "\nMATRICULA: "+this.getMatricula()+
                "\nMODELO: "+this.getModelo()+
                "\nFECHA COMPRA: "+this.getFechaCompra()+
                "\nPOTENCIA: "+this.getPotencia()+
                "\nCOMBUSTIBLE: "+this.getCombustible()+
                "\nHIBRIDO: "+this.isHibrido()+"\n";
        return info;
    }
}
