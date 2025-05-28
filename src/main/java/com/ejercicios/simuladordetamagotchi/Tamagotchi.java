/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejercicios.simuladordetamagotchi;

/**
 *
 * @author jalex
 */
abstract class Tamagotchi implements TamagotchiActions {

    //Cuando es una clase abstracta los atributos deben ser protegidos
    protected String nombre;
    protected int hambre;
    protected int energia;
    protected int felicidad;
    protected boolean estaDormido;
    protected boolean estaVivo;

    public Tamagotchi(String nombre) {
        this.nombre = nombre;
        this.estaDormido = false;
        this.estaVivo = true;
        this.felicidad = 100;
        this.hambre = 100;
        this.energia = 100;
    }

    //metodos para dormir
    public void dormir() {
        this.estaDormido = true;
        //Si se duerme va aumentar 20 en su energia hasta llegar a 100
        this.energia = Math.min(100, this.energia + 20);
    }

    public void levantar() {
        this.estaDormido = false;
    }

    public String getNombre() {
        return nombre;
    }

    public int getHambre() {
        return hambre;
    }

    public int getEnergia() {
        return energia;
    }

    public int getFelicidad() {
        return felicidad;
    }

    public boolean isEstaDormido() {
        return estaDormido;
    }

    public boolean isEstaVivo() {
        return estaVivo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHambre(int hambre) {
        this.hambre = hambre;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public void setFelicidad(int felicidad) {
        this.felicidad = felicidad;
    }

    public void setEstaDormido(boolean estaDormido) {
        this.estaDormido = estaDormido;
    }

    public void setEstaVivo(boolean estaVivo) {
        this.estaVivo = estaVivo;
    }

    public void iniciarVida() {

    }

    public void iniciarCicloDeVida() {
        //Se crea un hilo con Thread para llevar a cabo el ciclo
        Thread hilo = new Thread(() -> {
            //Verificar si esta vivo
            while (estaVivo) {
                try {
                    Thread.sleep(5000); //esperar 5 segundos por cada disminucion de accion

                    //Modificaciones a su estado solamente si esta despierto el tamgotchi
                    if (estaDormido) {
                        energia = Math.min(100, energia + 5);

                        //Si el tamagotchi llega a 100 dewberia de levantarse
                        if (energia >= 100) {
                            estaDormido = false;
                        }

                    } else {
                        hambre = Math.max(0, hambre - 5);
                        energia = Math.max(0, energia - 4);
                        felicidad = Math.max(0, felicidad - 8);
                    }
                    // Si se llega a cero en algun estado, se muere
                    if (hambre == 0 || energia == 0 || felicidad == 0) {
                        estaVivo = false;
                        System.out.println(nombre + " ha muerto.");
                    }

                } catch (InterruptedException e) {
                    System.out.println("El hilo del tamagotchi " + nombre + " fue interrumpido.");
                }
            }
        });

        hilo.start(); //Se inicia el hilo
    }

    //Metodo abstracto
    public abstract String comportamientoEspecifico();

    public abstract String comportamientoEspecificoDos();

    public abstract String comportamientoEspecificoTres();

    public String obtenerEstadoAnimo() {

        if (!estaVivo) {
            return "muerto";
        }

        if (hambre <= 50 && felicidad >= 40) {
            return "Hambriento";
        }

        if (felicidad <= 80 && energia >= 30) {
            return "Triste";
        }

        if (energia <= 30) {
            return "Agotado";
        }

        return "Normal";
    }

}
