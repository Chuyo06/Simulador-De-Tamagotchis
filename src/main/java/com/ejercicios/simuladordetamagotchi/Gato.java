///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.ejercicios.simuladordetamagotchi;
//
///**
// *
// * @author jalex
// */
//public class Gato extends Tamagotchi implements TamagotchiActions , Runnable{
//
//    public Gato(String nombre) {
//        super(nombre);
//    }
//    
//    
//    @Override
//    public void comportamientoEspecifico() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public void alimentar() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public void jugar() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public void dormir() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    
//    
//    @Override
//    public void mostrarEstado() {
//            System.out.println("Nombre: " +nombre);
//            System.out.println("Felicidad: "+felicidad);
//            System.out.println("Hambre: "+hambre);
//            System.out.println("Energia: "+energia);
//            System.out.println("Dormido: "+estaDormido);
//            System.out.println("Vivo: "+estaVivo);
//            
//            
//    }
//
//    @Override
//    public void run() {
//        
//        while(estaVivo)
//        {
//           try {
//           if(!estaDormido)
//           {
//              
//                   Thread.sleep(2000);
//                   actualizarEstado();
//                   verificarEstado();
//                   mostrarEstado();
//                   System.out.println("");
//           }
//                    
//               } 
//           catch (InterruptedException e) {
//                   estaVivo = false;
//
//           }
//           
//        }
//        
//    }
//    
//    public void actualizarEstado()
//    {
//            felicidad -=4;
//            energia-=5;
//            hambre-=10;
//    }
//    
//    public void verificarEstado()
//    {
//        if(hambre == 0 || energia == 0 | felicidad == 0)
//        {
//            estaVivo = false;
//            System.out.println("Tu Tamagotchi se ha muerto");
//            
//        }
//    }
//}
