package gui;

import javax.swing.*;

public class VistaCoche {

    JPanel panel;
    JLabel label_matricula;
    JLabel label_modelo;
    JLabel label_fecha;
    JLabel label_potencia;
    public JButton boton_nuevo;
    public JButton boton_guardar;
    public JButton boton_modificar;
    public JButton boton_eliminar;
    public JButton boton_primero;
    public JButton boton_anterior;
    public JButton boton_siguiente;
    public JButton boton_ultimo;
    public JButton boton_cancelar;
    public JButton boton_buscar;
    public JTextField input_matricula;
    public JTextField input_modelo;
    public JTextField input_fecha;
    public JTextField input_potencia;
    public JTextField input_buscar;


    public VistaCoche(String titulo) {
        JFrame frame = new JFrame(titulo);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciarComponentes(frame);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //addActionListener(this);
    }

    public void iniciarComponentes(JFrame frame) {
        frame.setLayout(null);
        label_matricula = new JLabel("Matricula");
        label_matricula.setBounds(20, 10, 120, 25);
        frame.add(label_matricula);

        input_matricula = new JTextField();
        input_matricula.setBounds(200, 10, 250, 25);
        frame.add(input_matricula);

        label_modelo = new JLabel("Modelo");
        label_modelo.setBounds(20, 50, 120, 25);

        frame.add(label_modelo);

        input_modelo = new JTextField();
        input_modelo.setBounds(200, 50, 250, 25);
        frame.add(input_modelo);

        label_fecha = new JLabel("Fecha Compra");
        label_fecha.setBounds(20, 100, 120, 25);
        frame.add(label_fecha);

        input_fecha = new JTextField();
        input_fecha.setBounds(200, 100, 250, 25);
        frame.add(input_fecha);

        label_potencia = new JLabel("Potencia");
        label_potencia.setBounds(20, 150, 120, 25);
        frame.add(label_potencia);

        input_potencia = new JTextField();
        input_potencia.setBounds(200, 150, 250, 25);
        frame.add(input_potencia);

        //BOTONES CRUD
        boton_nuevo = new JButton("Nuevo");
        boton_nuevo.setBounds(20, 200, 100, 25);
        frame.add(boton_nuevo);

        boton_guardar = new JButton("Guardar");
        boton_guardar.setBounds(120, 200, 100, 25);
        frame.add(boton_guardar);

        boton_modificar = new JButton("Modificar");
        boton_modificar.setBounds(220, 200, 100, 25);
        frame.add(boton_modificar);

        boton_eliminar = new JButton("Eliminar");
        boton_eliminar.setBounds(320, 200, 100, 25);
        frame.add(boton_eliminar);

        boton_cancelar = new JButton("Cancelar");
        boton_cancelar.setBounds(420, 200, 100, 25);
        frame.add(boton_cancelar);

        //Botones control vista
        boton_primero = new JButton("|<");
        boton_primero.setBounds(20, 250, 100, 25);
        frame.add(boton_primero);

        boton_anterior = new JButton("<");
        boton_anterior.setBounds(120, 250, 100, 25);
        frame.add(boton_anterior);

        boton_siguiente = new JButton(">");
        boton_siguiente.setBounds(220, 250, 100, 25);
        frame.add(boton_siguiente);

        boton_ultimo = new JButton(">|");
        boton_ultimo.setBounds(320, 250, 100, 25);
        frame.add(boton_ultimo);

        input_buscar = new JTextField();
        input_buscar.setBounds(20, 300, 300, 25);
        frame.add(input_buscar);

        boton_buscar = new JButton("Buscar");
        boton_buscar.setBounds(350, 300, 100, 25);
        frame.add(boton_buscar);

    }

}
