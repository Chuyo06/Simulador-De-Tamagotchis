/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejercicios.simuladordetamagotchi;

/**
 *
 * @author jalex
 */
abstract class Tamagotchi implements TamagotchiActions{
    //Cuando es una clase abstracta los atributos deben ser protegidos
    protected String nombre ; 
    protected int hambre ;
    protected int energia ;
    protected int felicidad ;
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
    public void dormir()
    {
        this.estaDormido = true;
        //Si se duerme va aumentar 20 en su energia hasta llegar a 100
        this.energia = Math.min(100, this.energia + 20);
    }
    
    public void levantar()
    {
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
    
    
    
    //Metodo abstracto
    public abstract  void comportamientoEspecifico();
    
    
}
