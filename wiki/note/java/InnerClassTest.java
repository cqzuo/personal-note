package cn.edu.hust.cm.test;

 

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

import java.awt.Toolkit;

import javax.swing.JOptionPane;

import javax.swing.Timer;

public class InnerClassTest {

       public InnerClassTest() {

              super();

              // TODO Auto-generated constructor stub

       }

       public static void main(String[] args) {

        Court court=new Court(10000,true);

        court.start();

        JOptionPane.showMessageDialog(null,"Í£Ö¹Ã´£¬CMTobby?");

        System.exit(0);

       }

}

 

class Court{

       public Court(int interval,boolean beep){

              this.interval=interval;

              this.beep=beep;

       }

       public void start(){

              TimerPrinter action=new TimerPrinter();

              Timer t=new Timer(interval,action);

              t.start();

       }

       private int interval;

       private boolean beep;

 

       private class TimerPrinter implements ActionListener{

              public void actionPerformed(ActionEvent e){

                     System.out.println("Cindyelf,would you be my mm?");

                     if(beep) Toolkit.getDefaultToolkit().beep();

              }

       }

}
