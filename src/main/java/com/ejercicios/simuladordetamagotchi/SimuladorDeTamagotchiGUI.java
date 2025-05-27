/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejercicios.simuladordetamagotchi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

/**
 *
 * @author jalex
 */
//Usaremos un Frame para mostrar todo
public class SimuladorDeTamagotchiGUI extends JFrame {

    //Maps para guardar las imagenes de los tamagotchis
    private Map<Tamagotchi, JLabel> imagenesTamagotchi = new HashMap<>();
    private Map<Tamagotchi, JLabel> estadosTamagotchi = new HashMap<>();

    //Guardar en un map tambien las barras
    private Map<Tamagotchi, JProgressBar[]> barrasTamagotchi = new HashMap<>();

    //Paneles necesarios
    private JPanel panelPrincipal;//Panel que va contenr todo
    private JPanel panelIzquierdo; //Panel para los tamagotchis
    private JPanel panelDerecho; //Panel para crear
    private JScrollPane scrollPane; //Panel con scroll

    //ArrayListque a contener todos los Tamagotchis creados
    private ArrayList<Tamagotchi> tamagotchisPanel; //Cada tamagotchi tendra un panel
    private int contadorTamagotchis = 0;

    public SimuladorDeTamagotchiGUI() {
        inicializarGUI();

        //creamos un temporizador para que se ejecute cada 1 segundo
        Timer timer = new Timer(1000, e -> {

            // en este forEach, se recorren los paneles para ver que tamagotchis se han creado
            for (Tamagotchi t : tamagotchisPanel) {
                //Si el tamagotchi esta vivo va tomar la imagen y el estado del tamgotchi
                //y la va actualizar ene el panel
                if (t.isEstaVivo()) {
                    JLabel labelImg = imagenesTamagotchi.get(t);
                    JLabel labelEstado = estadosTamagotchi.get(t);
                    if (labelImg != null && labelEstado != null) {
                        actualizarImagenTamagotchi(labelImg, t);
                        actualizarEstadoAnimoDeTamagotchi(labelEstado, t);
                    }

                    //Aqui obtienes las barras correspondientes del map en donde estan guardadas
                    JProgressBar[] barras = barrasTamagotchi.get(t);
                    //Si existen valores en el map los actualiza
                    if (barras != null) {
                        barras[0].setValue(t.getHambre());//Barra de hambre
                        barras[1].setValue(t.getEnergia());//Barra de energia
                        barras[2].setValue(t.getFelicidad());//Barra de felicidad
                    }

                }
            }
        });
        timer.start();

        tamagotchisPanel = new ArrayList<>();

    }

    public void inicializarGUI() {

        setTitle("Simulador de TAMAGOTCHIS interactivos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);

        //BorderLayout para organizar todo dentro de ese panel
        panelPrincipal = new JPanel(new BorderLayout());

        //BoxLayout para organizar los paneles en vertical u horizontal
        panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));
        panelIzquierdo.setBackground(new Color(240, 248, 255));
        panelIzquierdo.setBorder(BorderFactory.createTitledBorder("Mis Tamagotchis"));

        //Scroll para mover el panel izquierdo y el tamanio el cual se va mover
        scrollPane = new JScrollPane(panelIzquierdo);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(800, 750));

        //Panel derecho donde habra botones de creacion
        panelDerecho = panelDeControl();

        //Agregar paneles al panel principal
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
        panelPrincipal.add(panelDerecho, BorderLayout.EAST);

        add(panelPrincipal);

    }

    private JPanel panelDeControl() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(300, 750));
        panel.setBackground(new Color(255, 248, 240));
        panel.setBorder(BorderFactory.createTitledBorder("Crear Nuevo Tamagotchi"));

        // Titulo del panel de crear tamagotchis
        JLabel titleLabel = new JLabel("Crea tu Tamagotchi!!!");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // botones para crear los diferentes tipos de tamagotchis
        JButton btnPerro = estiloBoton("Crear Perro", new Color(255, 200, 150), 250, 40);
        btnPerro.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del perro:");
            if (nombre != null && !nombre.trim().isEmpty()) {
                Perro nuevoPerro = new Perro(nombre);
                tamagotchisPanel.add(nuevoPerro); //guarda en la lista
                nuevoPerro.iniciarCicloDeVida();//se inicia el ciclo por hilo
                JPanel panelVisual = crearPanelTamagotchi(nuevoPerro); // la visualizacion

                panelVisual.setAlignmentX(Component.LEFT_ALIGNMENT);

                //panelIzquierdo.add(panelVisual, 0); // Agrega al principio (opcional)
                panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 10))); // espacio entre los paneles

                panelIzquierdo.add(panelVisual);
                panelIzquierdo.revalidate();
                panelIzquierdo.repaint();
            }
        });

        JButton btnGato = estiloBoton("Crear Gato", new Color(200, 255, 200), 250, 40);
        btnGato.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog(this, "Ingresa el nombre del gato:");
            if (nombre != null && !nombre.trim().isEmpty()) {
                Gato nuevoGato = new Gato(nombre);
                tamagotchisPanel.add(nuevoGato); //guarda en la lista
                nuevoGato.iniciarCicloDeVida();//se inicia el ciclo por hilo
                JPanel panelVisual = crearPanelTamagotchi(nuevoGato); // la visualizacion
                panelVisual.setAlignmentX(Component.LEFT_ALIGNMENT);
                //panelIzquierdo.add(panelVisual, 0); // Agrega al principio
                panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 10))); // espacio entre los paneles

                panelIzquierdo.add(panelVisual);
                panelIzquierdo.revalidate();
                panelIzquierdo.repaint();
            }
        });

        JButton btnMuneca = estiloBoton("Crear Muñeca", new Color(255, 200, 255), 250, 40);
        btnMuneca.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog(this, "Ingresa el nombre de tu muñeca:");
            if (nombre != null && !nombre.trim().isEmpty()) {
                Muñeca nuevoMuñeca = new Muñeca(nombre);
                tamagotchisPanel.add(nuevoMuñeca); //guarda en la lista
                nuevoMuñeca.iniciarCicloDeVida();//se inicia el ciclo por hilo
                JPanel panelVisual = crearPanelTamagotchi(nuevoMuñeca); // la visualizacion
                panelVisual.setAlignmentX(Component.LEFT_ALIGNMENT);
                //panelIzquierdo.add(panelVisual, 0); // Agrega al principio
                panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 10))); // espacio entre los paneles

                panelIzquierdo.add(panelVisual);
                panelIzquierdo.revalidate();
                panelIzquierdo.repaint();
            }
        });

        JButton btnCuyo = estiloBoton("Crear Cuyo", new Color(200, 200, 255), 250, 40);
        btnCuyo.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog(this, "Ingresa el nombre del cuyo:");
            if (nombre != null && !nombre.trim().isEmpty()) {
                Cuyo nuevoCuyo = new Cuyo(nombre);
                tamagotchisPanel.add(nuevoCuyo); //guarda en la lista
                nuevoCuyo.iniciarCicloDeVida();//se inicia el ciclo por hilo
                JPanel panelVisual = crearPanelTamagotchi(nuevoCuyo); // la visualizacion
                panelVisual.setAlignmentX(Component.LEFT_ALIGNMENT);
                //panelIzquierdo.add(panelVisual, 0); // Agrega al principio
                panelIzquierdo.add(Box.createRigidArea(new Dimension(0, 10))); // espacio entre los paneles
                panelIzquierdo.add(panelVisual);
                panelIzquierdo.revalidate();
                panelIzquierdo.repaint();
            }
        });


        // Acciones de los botones donde se utilizara Action Listeners
        // se agregan al panel los diferente botones para poner en vertical
        panel.add(Box.createVerticalStrut(20));
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(30));
        panel.add(btnPerro);
        panel.add(Box.createVerticalStrut(15));
        panel.add(btnGato);
        panel.add(Box.createVerticalStrut(15));
        panel.add(btnMuneca);
        panel.add(Box.createVerticalStrut(15));
        panel.add(btnCuyo);
        panel.add(Box.createVerticalGlue());

        return panel;
    }

    private JPanel crearPanelTamagotchi(Tamagotchi tamagotchi) {

        //Panel de diferentes
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setMaximumSize(new Dimension(750, 230));
        panel.setPreferredSize(new Dimension(750, 230));
        panel.setBorder(BorderFactory.createTitledBorder(tamagotchi.getNombre()));

        // Panel con imagen
        JLabel labelImagen = new JLabel();
        //Actualizar la imagen del tamgagotchi
        actualizarImagenTamagotchi(labelImagen, tamagotchi);
        imagenesTamagotchi.put(tamagotchi, labelImagen);//guardar las imagenes del tamagotchi en el Map

        // Barras que va mostrar como estan los estados del tamagotchi
        JProgressBar barraHambre = new JProgressBar(0, 100);
        JProgressBar barraEnergia = new JProgressBar(0, 100);
        JProgressBar barraFelicidad = new JProgressBar(0, 100);

        //Nombres que tendras las barras
        barraHambre.setString("Hambre");
        barraEnergia.setString("Energía");
        barraFelicidad.setString("Felicidad");

        barraHambre.setStringPainted(true);
        barraEnergia.setStringPainted(true);
        barraFelicidad.setStringPainted(true);

        // Panel que contendra las 3 barras, 1 fila y 3 columnas
        JPanel panelBarras = new JPanel(new GridLayout(3, 1, 5, 5));
        panelBarras.add(barraHambre);
        panelBarras.add(barraEnergia);
        panelBarras.add(barraFelicidad);

        // Guardamos las 3 barras en un arreglo y lo asociamos al tamagotchi actual
        barrasTamagotchi.put(tamagotchi, new JProgressBar[]{barraHambre, barraEnergia, barraFelicidad});

        JPanel panelImagen = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelImagen.setPreferredSize(new Dimension(200, 200)); // Evita que se colapse
        panelImagen.add(labelImagen);

        panel.add(panelImagen, BorderLayout.WEST);

        // Panel central
        JPanel panelCentral = new JPanel(new BorderLayout());

        // Botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panelCentral.add(panelBotones, BorderLayout.CENTER);

        // Estado de animo
        JLabel labelEstado = new JLabel();
        //Actualizar el estado de animo del tamagotchi
        actualizarEstadoAnimoDeTamagotchi(labelEstado, tamagotchi);
        estadosTamagotchi.put(tamagotchi, labelEstado); //Se agregan al Map para despues usarlas

        JButton btnAlimentar = estiloBoton("Alimentar", new Color(255, 200, 150), 110, 40);
        btnAlimentar.addActionListener(e -> {
            String[] opciones;
            if (tamagotchi instanceof Perro) {
                opciones = new String[]{"Croquetas", "Sobresito", "Galleta"};
            } else if (tamagotchi instanceof Gato) {
                opciones = new String[]{"Croquetas", "Pescado", "Whiskas"};
            } else if (tamagotchi instanceof Cuyo) {
                opciones = new String[]{"Zanahoria", "Heno", "Lechuga"};
            } else if (tamagotchi instanceof Muñeca) {
                opciones = new String[]{"Té", "Tacos", "Café"};
            } else {
                opciones = new String[]{"No hay alimento"};
            }

            JComboBox<String> combo = new JComboBox<>(opciones);
            int seleccion = JOptionPane.showConfirmDialog(this, combo, "Selecciona alimento", JOptionPane.OK_CANCEL_OPTION);
            if (seleccion == JOptionPane.OK_OPTION) {
                String alimento = (String) combo.getSelectedItem();
                tamagotchi.alimentar(alimento);
                actualizarEstadoAnimoDeTamagotchi(labelEstado, tamagotchi);
                actualizarImagenTamagotchi(labelImagen, tamagotchi);
            }
        });

        JButton btnJugar = estiloBoton("Jugar", new Color(255, 200, 150), 110, 40);
        btnJugar.addActionListener(e -> {
            String[] opciones;

            if (tamagotchi instanceof Perro) {
                opciones = new String[]{"Pasear", "Pelota", "Cuerda"};
            } else if (tamagotchi instanceof Gato) {
                opciones = new String[]{"Estambre", "Pelota", "Caña de pescar"};
            } else if (tamagotchi instanceof Cuyo) {
                opciones = new String[]{"Pelotita de heno", "Esconderse en su tunel", "Correr en su rueda"};
            } else if (tamagotchi instanceof Muñeca) {
                opciones = new String[]{"iPad", "Dibujar", "Leer"};
            } else {
                opciones = new String[]{"No hay que jugar"};
            }

                JComboBox<String> combo = new JComboBox<>(opciones);
                int seleccion = JOptionPane.showConfirmDialog(this, combo, "¿Que quieres jugar?", JOptionPane.OK_CANCEL_OPTION);
                if (seleccion == JOptionPane.OK_OPTION) {
                    String juego = (String) combo.getSelectedItem();
                    tamagotchi.jugar(juego);
                    actualizarEstadoAnimoDeTamagotchi(labelEstado, tamagotchi);
                    actualizarImagenTamagotchi(labelImagen, tamagotchi);
                }

        });

        JButton btnDormir = estiloBoton("Dormir", new Color(255, 200, 150), 110, 40);
        btnDormir.addActionListener(e -> {
            tamagotchi.dormir();
            actualizarEstadoAnimoDeTamagotchi(labelEstado, tamagotchi);
            actualizarImagenTamagotchi(labelImagen, tamagotchi);
        });

        JButton btnComportamiento = estiloBoton("Especifico", new Color(255, 200, 150), 130, 40);
        btnComportamiento.addActionListener(e -> {
            tamagotchi.comportamientoEspecifico();
            actualizarEstadoAnimoDeTamagotchi(labelEstado, tamagotchi);
            actualizarImagenTamagotchi(labelImagen, tamagotchi);
        });

        JButton btnComportamientoDos = estiloBoton("Especifico 2", new Color(255, 200, 150), 130, 40);
        btnComportamientoDos.addActionListener(e -> {
            tamagotchi.comportamientoEspecificoDos();
            actualizarEstadoAnimoDeTamagotchi(labelEstado, tamagotchi);
            actualizarImagenTamagotchi(labelImagen, tamagotchi);
        });

        JButton btnComportamientoTres = estiloBoton("Especifico 3", new Color(255, 200, 150), 130, 40);
        btnComportamientoTres.addActionListener(e -> {
            tamagotchi.comportamientoEspecificoTres();
            actualizarEstadoAnimoDeTamagotchi(labelEstado, tamagotchi);
            actualizarImagenTamagotchi(labelImagen, tamagotchi);
        });

        panelBotones.add(btnAlimentar);
        panelBotones.add(btnJugar);
        panelBotones.add(btnDormir);
        panelBotones.add(btnComportamiento);
        panelBotones.add(btnComportamientoDos);
        panelBotones.add(btnComportamientoTres);

        actualizarEstadoAnimoDeTamagotchi(labelEstado, tamagotchi);
        //Panel que va mostrar estado
        JPanel panelEstado = new JPanel();
        panelEstado.add(labelEstado);

        //Se agregan los paneles de estado y barras del al central
        panelCentral.add(panelEstado, BorderLayout.SOUTH);
        panelCentral.add(panelBarras, BorderLayout.NORTH);
        //panel central se agrega al panel principal
        panel.add(panelCentral, BorderLayout.CENTER);

        return panel;
    }

    private void actualizarImagenTamagotchi(JLabel labelImagen, Tamagotchi tamagotchi) {
        try {
            String tipo = tamagotchi.getClass().getSimpleName().toLowerCase();
            String estado = tamagotchi.obtenerEstadoAnimo().toLowerCase();

            String nombreImagen = determinarNombreImagen(tipo, estado);

            ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/" + nombreImagen));
            Image imagen = icono.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
            labelImagen.setIcon(new ImageIcon(imagen));

        } catch (Exception e) {
            labelImagen.setText("Imagen no encontrada");
            System.err.println("Error cargando imagen: " + e.getMessage());
        }
    }

    private void actualizarEstadoAnimoDeTamagotchi(JLabel labelImagen, Tamagotchi tamagotchi) {
        try {
            String estado = tamagotchi.obtenerEstadoAnimo().toLowerCase();
            labelImagen.setText(estado);

        } catch (Exception e) {
            labelImagen.setText("Texto no encontrado");
            System.err.println("Error cargar Texto " + e.getMessage());
        }
    }

    private String determinarNombreImagen(String tipo, String estado) {
        return tipo + "_" + estado + ".jpg";
    }

    //Metodo para dar color y el texto al boton
    private JButton estiloBoton(String text, Color color, int dimensionX, int dimensionY) {
        JButton button = new JButton(text);
        button.setMaximumSize(new Dimension(dimensionX, dimensionY));
        button.setPreferredSize(new Dimension(dimensionX, dimensionY));
        button.setBackground(color);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createRaisedBevelBorder());
        return button;
    }

}
