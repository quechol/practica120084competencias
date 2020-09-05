/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica120084competencias;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;


/**
 *
 * @author Gerardo Miguel Quechol Zarate
 */
public class Practica120084Competencias extends JFrame {

//public class Practica1_20084_Competencias extends JFrame{
    private JButton bRun, bPausa, bDetener, bSeguir;
    private JLabel etihilo1, etihilo2;
    private JTextArea areaHilo1, areaHilo2;
    private JScrollPane jspHilo1, jspHilo2;
    private Hilo1 t1;
    private Hilo2 t2;
    public boolean pausa = false;
    public boolean parar = false;

    public Practica120084Competencias(){
        setSize(400,400);
        setTitle("Condiciones de competecnia");
        MisComponentes();
    }


    private void MisComponentes(){
        bRun = new JButton("Run.");
        bPausa = new JButton ("Pause.");
        bSeguir = new JButton("Resume");
        bDetener = new JButton ("Stop.");
        etihilo1 = new JLabel("Thread 1");
        etihilo2 = new JLabel("Thread 2");
        areaHilo1 = new JTextArea();
        areaHilo2 = new JTextArea();
        jspHilo1 = new JScrollPane(areaHilo1); 
        jspHilo2 = new JScrollPane(areaHilo2);
        t1 = new Hilo1(areaHilo1);
        t2 = new Hilo2(areaHilo2);
        
        setLayout(null);
        bRun.setBounds(10,100,100,25);
        bPausa.setBounds(10,150,100,25);
        bSeguir.setBounds(10,200,100,25);
        bDetener.setBounds(10,250,100,25);
        etihilo1.setBounds(150,10,100,25);
        etihilo2.setBounds(250,10,100,25);
        jspHilo1.setBounds(150,50,100,300);
        jspHilo2.setBounds(250,50,100,300);
        
        add(bRun);
        add(bPausa);
        add(bSeguir);
        add(bDetener);
        add(etihilo1);
        add(etihilo2);
        add(jspHilo1);
        add(jspHilo2);
        
        bRun.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
                t1.play();
                t2.play();
           }
        });
        
        
         bPausa.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
                    t1.pausar();
                    t2.pausar();
           }
        });
         
         
         bSeguir.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               t1.reanudar();
               t2.reanudar();
           }
        });
                   
          bDetener.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               t1.parar();
               t2.parar();
           }
        });
        
    }
    
    public static void main(String[] args){ 
        Practica120084Competencias fr = new Practica120084Competencias();
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

