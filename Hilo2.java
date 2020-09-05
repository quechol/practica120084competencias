/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica120084competencias;


/**
 *
 * @author Gerardo Miguel Quechol Zarate
 * 
 */

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Hilo2 extends Thread{
        private JTextArea area;
        private boolean pausa =  false;
        private boolean detener = false;
        
        public Hilo2(JTextArea area){
            this.area=area;
        }
        
        
    public synchronized void play() {
        pausa=false;
        detener = false;
        this.start();
    }     
    
    public synchronized void pausar (){
        pausa = true;
    }
    
    public synchronized void reanudar(){
        pausa = false;
        this.notify();
    }
    
    public synchronized void parar(){
        detener = true;
        System.out.println("Stopped");
    }
    
        
    public void run(){
    int i = 0;
    while (!detener) {
    try {
    synchronized (this) {
    if (pausa) {
    System.out.println("Paused");
    wait();
    System.out.println("Resumed");
            }
        }
     area.append(i+"\n");  
     i++;
    } catch (InterruptedException ex) {
        System.err.println(ex);
        }
    }
  }
}
