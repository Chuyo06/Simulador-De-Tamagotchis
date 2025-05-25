/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejercicios.simuladordetamagotchi;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jalex
 */
public class Perro extends Tamagotchi implements TamagotchiActions {
   
    
    public Perro(String nombre) {
        super(nombre);
        
    }

    //Metodo para alimentar al tamagotchi
       @Override
    public void alimentar(String tipoAlimento) {

        //Se usan la clase Math.max y Math.min, con la cual 
        //se "limita" a un rango de datos
        if(tipoAlimento.toLowerCase().equals("croquetas"))
        {
            hambre = Math.min(100, hambre + 15);//Sumara 15 pero no pasara del 100
        }
        
        if(tipoAlimento.toLowerCase().equals("sobresito"))
        {
            hambre = Math.min(100, hambre + 20);//Sumara 15 pero no pasara del 100
        }
        
        if(tipoAlimento.toLowerCase().equals("scooby-galleta"))
        {
            hambre = Math.min(100, hambre + 5);//Sumara 15 pero no pasara del 100
        }
 
    }

    @Override
    public void jugar(String tipoJuego) {
 //Se usan la clase Math.max y Math.min, con la cual 
        //se "limita" a un rango de datos
        if(tipoJuego.toLowerCase().equals("pasear"))
        {
            energia = Math.max(0, energia - 25);
            felicidad = Math.min(100, felicidad + 20);
        }
        
        if(tipoJuego.toLowerCase().equals("pelota"))
        {
            energia = Math.max(0, energia - 10);
            felicidad = Math.min(100, felicidad + 15);        
        }
        
        if(tipoJuego.toLowerCase().equals("cuerda"))
        {
            energia = Math.max(0, energia - 5);
            felicidad = Math.min(100, felicidad + 10);  
        }
    }
    
    
    @Override
    public void comportamientoEspecifico() {
        
    }
   
 
}
