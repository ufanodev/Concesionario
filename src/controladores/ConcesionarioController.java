package controladores;

import gui.VistaCoche;
import mensajes.Mensaje;
import modelos.Coche;
import modelos.Combustible;
import servicios.VentanaModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

public class ConcesionarioController implements ActionListener, KeyListener {

    private VentanaModel model;
    private VistaCoche view;

    private int posicion;


    public ConcesionarioController(VentanaModel model, VistaCoche view) {
        this.model = model;
        this.view = view;

        anadirActionListener(this);
        anadirKeyListener(this);

        posicion = 0;
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        String actionCommand = event.getActionCommand();
        Coche coche = null;
        switch (actionCommand) {
            case "Nuevo":
                view.input_matricula.setText("");
                view.input_modelo.setEditable(true);
                view.input_fecha.setEnabled(true);
                view.input_fecha.setMaxSelectableDate(new Date());
                view.input_potencia.setText("");
                view.combo_motor.setEditable(true);
                view.check_hibrido.setEnabled(true);

                view.boton_guardar.setEnabled(true);
                break;
            case "Guardar":
                if (view.input_matricula.getText().equals("")) {
                    Mensaje.mensajeError("El nombre es un campo obligatorio", "Nuevo Coche");
                    return;
                }

                coche = new Coche();
                coche.setModelo(view.input_modelo.getText());
                coche.setMatricula(view.input_matricula.getText());
                coche.setFechaCompra(view.input_fecha.getDate());
                String energia = view.combo_motor.getSelectedItem().toString();
                coche.setCombustible(Combustible.Energia.valueOf(energia));

                model.altaCoche(coche);

                view.boton_guardar.setEnabled(false);
                break;

            case "Modificar":
                coche = new Coche();
                coche.setModelo(view.input_modelo.getText());
                coche.setMatricula(view.input_matricula.getText());
                coche.setFechaCompra(view.input_fecha.getDate());
                energia = view.combo_motor.getSelectedItem().toString();
                coche.setCombustible(Combustible.Energia.valueOf(energia));

                model.modificarCoche(coche,coche.getMatricula());
                break;

            case "Cancelar":
                view.input_modelo.setEditable(false);
                view.input_matricula.setEditable(false);
                view.input_fecha.setEnabled(false);
                view.input_potencia.setEditable(false);
                view.combo_motor.setEditable(false);
                view.check_hibrido.setEnabled(false);

                coche = model.getActual();
                cargar(coche);

                view.boton_guardar.setEnabled(false);
                break;
            case "Eliminar":
                if (JOptionPane.showConfirmDialog(null, "¿Está seguro?", "Eliminar", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
                    return;

                model.eliminaCoche(view.input_matricula.getText());
                coche = model.getActual();
                cargar(coche);
                break;
            case "Buscar":
                coche = model.obtenerCoche(view.input_buscar.getText());
                if (coche == null) {
                    Mensaje.mensajeInformacion("No se ha encontrado ningún coche con esa matricula", "Buscar");
                    return;
                }
                cargar(coche);
                break;
            case "|<":
                coche = model.getPrimero();
                cargar(coche);
                break;
            case "<":
                coche = model.getAnterior();
                cargar(coche);
                break;
            case ">":
                coche = model.getSiguiente();
                cargar(coche);
                break;
            case ">|":
                coche = model.getUltimo();
                cargar(coche);
                break;
            default:
                break;
        }

    }

    private void cargar(Coche coche) {
        if (coche == null)
            return;

        view.input_modelo.setText(coche.getModelo());
        view.input_matricula.setText(coche.getMatricula());
        view.input_fecha.setDate(coche.getFechaCompra());
        view.combo_motor.setSelectedItem(coche.getCombustible());
        view.check_hibrido.setSelected(coche.isHibrido());
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == view.input_buscar) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                view.boton_buscar.doClick();
            }
        }
    }

    private void anadirKeyListener(KeyListener listener) {
        view.input_buscar.addKeyListener(listener);
    }

    private void anadirActionListener(ActionListener listener) {

        view.boton_nuevo.addActionListener(listener);
        view.boton_guardar.addActionListener(listener);
        view.boton_modificar.addActionListener(listener);
        view.boton_eliminar.addActionListener(listener);
        view.boton_primero.addActionListener(listener);
        view.boton_anterior.addActionListener(listener);
        view.boton_siguiente.addActionListener(listener);
        view.boton_ultimo.addActionListener(listener);
        view.boton_buscar.addActionListener(listener);
    }



}
