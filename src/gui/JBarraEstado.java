package gui;

import javax.swing.*;

public class JBarraEstado {

    private JPanel panel1;
    private JLabel label_mensaje;
    private JLabel label_estado;

    public void setLabel_mensaje(String mensaje) {
        this.label_mensaje.setText(mensaje);
    }

    public void setLabel_estado(String estado) {
        this.label_estado.setText(estado);
    }

}
