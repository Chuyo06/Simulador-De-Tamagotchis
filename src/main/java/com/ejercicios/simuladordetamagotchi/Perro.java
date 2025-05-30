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
    //Se usan la clase Math.max y Math.min, con la cual
    //se "limita" a un rango de datos
    public void alimentar(String tipoAlimento) {
        if (!estaVivo) {
            return;//Si el tamagotchi murio no se modificaran sus estados
        }
        switch (tipoAlimento.toLowerCase()) {
            case "croquetas" -> {
                hambre = Math.min(100, hambre + 15);
                energia = Math.min(100, energia + 5);
            }
            case "sobresito" -> {
                hambre = Math.min(100, hambre + 20);
                energia = Math.min(100, energia + 10);
            }
            case "galleta" -> {
                hambre = Math.min(100, hambre + 5);
                felicidad = Math.min(100, felicidad + 10);
            }

        }
    }

    @Override
    public void jugar(String tipoJuego) {
        if (!estaVivo) {
            return;//Si el tamagotchi murio no se modificaran sus estados
        }
        //Se usan la clase Math.max y Math.min, con la cual
        //se "limita" a un rango de datos
        switch (tipoJuego.toLowerCase()) {
            case "pasear" -> {
                energia = Math.max(0, energia - 25);
                felicidad = Math.min(100, felicidad + 20);
            }

            case "pelota" -> {
                energia = Math.max(0, energia - 10);
                felicidad = Math.min(100, felicidad + 15);
            }

            case "cuerda" -> {
                energia = Math.max(0, energia - 5);
                felicidad = Math.min(100, felicidad + 10);
            }
        }
    }

    public void dormir() {
        if (!estaVivo) {
            return;//Si el tamagotchi murio no se modificaran sus estados
        }
        this.estaDormido = true;
        this.energia = Math.min(100, this.energia + 20);
    }

    @Override
    public String comportamientoEspecifico() {
        return "esta ladrando";
    }

    @Override
    public String comportamientoEspecificoDos() {
        return "esta persiguiendo su cola";
    }

    @Override
    public String comportamientoEspecificoTres() {
        return " esta oliendo su comida";
    }

}
