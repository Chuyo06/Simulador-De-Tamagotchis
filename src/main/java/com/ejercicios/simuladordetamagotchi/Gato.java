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
public class Gato extends Tamagotchi implements TamagotchiActions {

    public Gato(String nombre) {
        super(nombre);

    }

    //Metodo para alimentar al tamagotchi
    @Override
    //Se usan la clase Math.max y Math.min, con la cual
    //se "limita" a un rango de datos
    public void alimentar(String tipoAlimento) {
        switch (tipoAlimento.toLowerCase()) {
            case "croquetas" -> {
                hambre = Math.min(100, hambre + 15);
                energia = Math.min(100, energia + 5);
            }
            case "pescado" -> {
                hambre = Math.min(100, hambre + 20);
                energia = Math.min(100, energia + 10);
            }
            case "whiskas" -> {
                hambre = Math.min(100, hambre + 5);
                felicidad = Math.min(100, felicidad + 10);
            }

        }
    }

    @Override
    public void jugar(String tipoJuego) {
        //Se usan la clase Math.max y Math.min, con la cual
        //se "limita" a un rango de datos
        switch (tipoJuego.toLowerCase()) {
            case "estambre" -> {
                energia = Math.max(0, energia - 25);
                felicidad = Math.min(100, felicidad + 20);
            }

            case "caña de pescar" -> {
                energia = Math.max(0, energia - 10);
                felicidad = Math.min(100, felicidad + 15);
            }

            case "pelota" -> {
                energia = Math.max(0, energia - 5);
                felicidad = Math.min(100, felicidad + 10);
            }
        }
    }

    public void dormir() {
        this.estaDormido = true;
        this.energia = Math.min(100, this.energia + 20);
    }

    @Override
    public String comportamientoEspecifico() {
        return " esta ronroneando";
    }

    @Override
    public String comportamientoEspecificoDos() {
        return " esta maullando";
    }

    @Override
    public String comportamientoEspecificoTres() {
        return " esta dormido boca arriba";
    }
}
