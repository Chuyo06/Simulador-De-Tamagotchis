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
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author jalex
 */
//Usaremos un Frame para mostrar todo
public class SimuladorDeTamagotchiGUI extends JFrame{
    
    
    //Paneles necesarios
    private JPanel panelPrincipal ;//Panel que va contenr todo
    private JPanel panelIzquierdo ; //Panel para los tamagotchis
    private JPanel panelDerecho ; //Panel para crear
    private JScrollPane scrollPane ; //Panel con scroll
    
    
    //ArrayListque a contener todos los Tamagotchis creados
    private ArrayList<Tamagotchi>  tamagotchisPanel; //Cada tamagotchi tendra un panel
    private int contadorTamagotchis = 0;

    public SimuladorDeTamagotchiGUI() {
        inicializarGUI();
        tamagotchisPanel = new ArrayList<>();
        
    }
    
    
    public void inicializarGUI()
    {
     
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
        panelPrincipal.add(scrollPane , BorderLayout.CENTER);
        panelPrincipal.add(panelDerecho , BorderLayout.CENTER);
        
        add(panelPrincipal);
        
    }
    
    private JPanel panelDeControl() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(300, 750));
        panel.setBackground(new Color(255, 248, 240));
        panel.setBorder(BorderFactory.createTitledBorder("Crear Nuevo Tamagotchi"));
        
        // Titulo del panel de crear tamagotchis
        JLabel titleLabel = new JLabel("Crea tu Tamagotchi!!!!!!!");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // botones para crear los diferentes tipos de tama
        JButton btnPerro = estiloBoton("Crear Perro", new Color(255, 200, 150));
        JButton btnGato = estiloBoton("Crear Gato", new Color(200, 255, 200));
        JButton btnMuneca = estiloBoton("Crear Muñeca", new Color(255, 200, 255));
        JButton btnCuyo = estiloBoton("Crear Cuyo", new Color(200, 200, 255));
        
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
    
    
    //Metodo para dar color y el texto al boton
     private JButton estiloBoton(String text, Color color) {
        JButton button = new JButton(text);
        button.setMaximumSize(new Dimension(250, 40));
        button.setPreferredSize(new Dimension(250, 40));
        button.setBackground(color);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createRaisedBevelBorder());
        return button;
    }
    
     
}
