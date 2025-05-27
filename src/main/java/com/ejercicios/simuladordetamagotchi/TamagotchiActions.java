    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
     */
    package com.ejercicios.simuladordetamagotchi;

    /**
     *
     * @author jalex
     */
    public interface TamagotchiActions {
        //Metodos qu e debe contener al menos los diferentes tamagotchis
        void alimentar(String tipoAlimento);//Alimentarlo, que va recibir que tipo
        void jugar(String tipoJuego);// Jugar con el, que habra 3 juegos
        void dormir();//Dormir para ganar energia
    }
