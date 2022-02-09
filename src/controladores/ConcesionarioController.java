package controladores;

import gui.VistaCoche;
import mensajes.Mensaje;
import modelos.Coche;
import modelos.Combustible;
import servicios.VentanaModel;

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
                cargar(animal);

                view.boton_guardar.setEnabled(false);
                break;
            default:
                break;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
