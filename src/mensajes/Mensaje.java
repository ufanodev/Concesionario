package mensajes;

import javax.swing.*;

public class Mensaje {

    public static void mensajeError(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }

    public static void mensajeInformacion(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
    public static int mensajeConfirmar(String mensaje, String titulo) {
        int resp =JOptionPane.showConfirmDialog(null, mensaje,titulo,JOptionPane.INFORMATION_MESSAGE);
        return resp;
    }

}
