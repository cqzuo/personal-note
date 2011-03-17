��ν�ڲ���(Inner Class)������˼�壬����ָ����������һ�����е��࣬����ΪʲôҪ��ô���أ�Ϊʲô��ֱ�Ӷ�������Ҫ�ڱ�����ж���һ���ڲ����أ���������Ҫ����������ԭ��

1��  �ڲ���ķ������Է��������ڵ��ⲿ���е������򣬰���˽���ͱ�ģ�

2��  ����ͬһ�����е��������������صģ�

3��  �������ڲ�����������Ǻܷ���Ķ����¼���Ӧ(call back)������GUI����кܳ�����

һ���ڲ���(inner class)��η����ⲿ��(outer class)�е���

��Ϊ��ȫ���Ƶ�ԭ���ڲ���ͨ������Ϊprivate�����ˣ�ֻ�����ڲ������ڵ��ⲿ�в��ܹ������ڲ���Ķ��󣬶�����������������صġ����⣬ֻ���ڲ���Ż��õ�private���η���һ����������private���η���ᱨ��

���濴���µĴ��룺

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

        JOptionPane.showMessageDialog(null,"ֹͣô��CMTobby?");

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

ע�������ɫ�Ӵֲ��ֵĴ��룬��������beep����������ڲ���TimerPrinter�����ǲ�û����������ô�������Ժδ��أ���Ȼ���������ⲿ�ࡣһ����˵��һ��������ֱ��refer to�������Ķ����е������򣬶�һ���ڲ���ķ��������ֱ��refer to���������Լ����������ⲿ���е���������������ʾ��

��ʵ�ϣ���ÿһ���ڲ����ж�����һ��Ĭ�ϵ���ʽ��reference����ָ�򴴽�������ڲ����ʵ�����Ǹ��������Ǽ�������outer�����������ɫ�Ӵֲ��־��൱�ڣ�

if(outer.beep) Toolkit.getDefaultToolkit().beep();��Ok����Ȼ��������һ��reference����ôouter��ֵ����������õģ�ʵ���ϱ�������ϳ�һ�����췽�����������������������ʾ��

public TimePrinter(Court court) {

          outer = clock;
}

    ��δ����Ǳ���ʱ�Զ������ģ�����ǰ���������۵��Զ�����װ����һ������������

�������һЩ���롣Ȼ��������Court���start()�����д���TimerPrinterʵ����ʱ

�򣬱��������Զ���this��Ϊ�������ݹ�ȥ��Ч�������������ʾ��

    public void start(){

              TimerPrinter action=new TimerPrinter(this);//�������Զ����ϵ�

              Timer t=new Timer (interval,action);

              t.start ();

       }

    �����Ǳ������Զ������ϵģ������������ܡ�

�����ڲ����һЩ�����﷨����

    ǰ������˵��ÿһ���ڲ����ж�����һ��Ĭ�ϵ���ʽ��reference����ָ�򴴽��������

�����ʵ�����Ǹ����󣬲���������outer����ָ���������������ʽ��ָ���ð������µ�

�﷨��OuterClass.this������if(Court.this.beep) Toolkit.getDefaultToolkit().beep();��

    ���⣬��Ϊ���Ƕ�����ڲ���ͨ����private��������ͨ����ͨ���ⲿ��ķ�����������

�����е�start()�����������Ǹ���ʽ��reference��ָ�������start()�����Ķ��󣬾���this��

����ڲ�������Ϊpublic����ô���ǾͿ������κεط�ʵ����һ���ڲ��࣬��������룺

    Court court=new Court(10000,true);

    Court.TimerPrinter test=court.new TimerPrinter();

    ����������InnerClassTest��main�����У���ʱ���Ǹ���ʽ��reference��ֱ��ָ����

court����ע���﷨�ǣ�OuterClassName.InnerClassName

