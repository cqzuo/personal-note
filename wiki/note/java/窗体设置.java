简单的窗体绘图
在窗体上进行绘图有两种方式，一种是通过改写paint方法实现自定义绘图，paint方法中提供了可以在屏幕上绘图的图形设备接口类对象，另外一种方式是通过直接获取当前屏幕的图形设备接口类来进行。另外，也可以给窗体添加带有绘图的面板实现窗体绘图。
1.改写paint方法的例子：
import java.awt.*;
import javax.swing.*;

public class exec //在main方法中实例化对象
{
        public static void main(String args[])
        {
                MyFrame m=new MyFrame("OK");
                m.setSize(200,400);
                m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                m.setVisible(true);
        }
}

class MyFrame extends JFrame//构造自己想要的类

        public MyFrame(String title)//构造函数
        {
                super(title);
        }
        
        public void paint(Graphics g)//重写paint方法
        {
                setBackground(Color.yellow);//setBackground设置背景色，Graphics图形设备接口类对象的setColor方法设置前景色，drawLine为绘制直线，它的四个参数分别为起始点的x和y值和终止点的x和y值
                g.setColor(Color.red);
                g.drawLine(0,0,100,100);
        }
}
2.直接获取当前屏幕图形设备接口类的绘图方式
这主要是利用getGraphics()方法来获取的，这种方式将可以更加灵活的实现绘图
import java.awt.*;
import java.awt.event.*;//该程序有事件动作
import javax.swing.*;

public class exec 
{
        public static void main(String args[])//在main方法中实例化MyFrame类对象
        {
                MyFrame m=new MyFrame("OK");
                m.setSize(300,400);
                m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置在程序退出时的动作
                m.setVisible(true);
        }
}

class MyFrame extends JFrame implements ActionListener//是JFrame的子类，实现了ActionListener接口
{       
        Button b=new Button("Draw Line");//建立界面上的按钮
        
        public MyFrame(String title)
        {
                super(title);
                getContentPane().setLayout(new FlowLayout());//按钮要放在JFrame对象上，所以要用流式布局
                getContentPane().add(b);//将按钮添加到JFrame中
                b.addActionListener(this);//将监听器放在按钮上      
        }
        
        public void actionPerformed(ActionEvent e)//实现ActionListener接口必须重写actionPerformed()方法
        {               
                Graphics g=getGraphics();//获取一个Graphics对象
                g.drawLine(0,0,100,100);//Graphics对象的drawLine动作
        }
}
3.面板上实现画图方法
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class exec //该类用于执行操作
{
        public static void main(String args[])
        {
                MyFrame m=new MyFrame("OK");//实例化该类，设置
                m.setSize(200,400);
                m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                m.setVisible(true);
        }
}

class MyFrame extends JFrame//构造承载画图面板窗体
{
        public MyFrame(String title)
        {
                super(title);
                getContentPane().add(new MyPanel());//将面板添加到窗体中
        }
}

class MyPanel extends JPanel//承载画图方法的面板类
{
        public void paintComponent(Graphics g)//重写父类JPanel的paintComponent()方法
        {
                super.paintComponent(g);
                setBackground(Color.yellow);
                g.setColor(Color.red);
                g.drawLine(0,0,100,100);
        }
}
4.用户控制下的绘图
import java.awt.*;
import java.awt.event.*;//有事件发生
import javax.swing.*;

public class contral//一个public类来执行操作
{
        public static void main(String args[])
        {
                MyFrame m=new MyFrame("OK");//实例化自定义的类，设置窗体大小
                m.setSize(300,400);
                m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                m.setVisible(true);
        }
}

class MyFrame extends JFrame//构造自定义窗体类
{       
        public MyFrame(String title)
        {
                super(title);
                getContentPane().add(new MyPanel()); //自定义窗体类JFrame中添加自定义面板类JPanel对象           
        }
}

class MyPanel extends JPanel implements ActionListener//JPanel子类和实现ActionListener接口
{
        Button b=new Button("Draw Line");//界面中的按钮，来交与用户控制
        
        public MyPanel()
        {
                add(b);//将按钮添加到面板中
                b.addActionListener(this);//在面板中添加监听器
        }
        
        public void actionPerformed(ActionEvent e)//实现ActionListener接口，重写actionPerformed方法
        {               
                Graphics g=getGraphics();
                g.drawLine(0,0,100,100);//在监听器中调用Graphics类的drawLine方法画图(表示从x1,y1到x2,y2画图)
        }
}
6.画网格
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class huaxian 
{
        public static void main(String args[])//在public class的main中执行实例化和操作
        {
                MyFrame m=new MyFrame("OK");
                m.setSize(200,400);
                m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                m.setVisible(true);
        }
}

class MyFrame extends JFrame//构造一个窗体来承载MyPanel组件
{
        public MyFrame(String title)
        {
                super(title);
                getContentPane().add(new MyPanel());
        }
}

class MyPanel extends JPanel//构造JPanel子类MyPanel来画图
{
        public void paintComponent(Graphics g)
        {
                super.paintComponent(g);
                
                for(int i=0;i<=this.getSize().width;i+=10)//this是MyPanel对象
                {
                        g.drawLine(i,0,i,this.getSize().height);
                }
                for(int i=0;i<=this.getSize().height;i+=10)
                {
                        g.drawLine(0,i,this.getSize().width,i);                 
                }
                
        }
}
7.画一个矩形
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class juxing 
{
        public static void main(String args[])//在public class juxing 的main方法中初始化自定义的类；
        {
                MyFrame m=new MyFrame("OK");
                m.setSize(200,400);
                m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                m.setVisible(true);
        }
}

class MyFrame extends JFrame//自定义一个窗体类继承自JFrame类，其中添加了一个新的面板组件
{
        public MyFrame(String title)
        {
                super(title);
                getContentPane().add(new MyPanel());
        }
}

class MyPanel extends JPanel//自定义一个组件，继承自JPanel类
{
        public void paintComponent(Graphics g)//重写paintComponent方法，参数为Graphics对象 g;
        {
                super.paintComponent(g);//调用父类的paintComponent方法;
                for(int i=0;i<=300;i+=50)
                {
                        g.drawLine(i,0,i,300);
                        g.drawLine(0,i,300,i);
                }
                g.setColor(Color.green);//设置矩形边框的颜色
                g.drawRect(50,50,100,100);//以x1 y1 到x2 y2为对角线画矩形
                
                g.setColor(Color.red);//设置颜色
                g.fillRect(100,100,50,50);//以x1 y1为起点，x2 y2为宽高填充矩形
        }
}
8.画一个圆形
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class yuan 
{
        public static void main(String args[])
        {
                MyFrame m=new MyFrame("OK");
                m.setSize(300,400);
                m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                m.setVisible(true);
        }
}

class MyFrame extends JFrame
{
        public MyFrame(String title)
        {
                super(title);
                getContentPane().add(new MyPanel());
        }
}

class MyPanel extends JPanel
{
        public void paintComponent(Graphics g)
        {
                super.paintComponent(g);
                for(int i=0;i<=300;i+=50)
                {
                        g.drawLine(i,0,i,300);
                        g.drawLine(0,i,300,i);
                }
                g.setColor(new Color(255,255,0));
                g.drawOval(50,50,100,100);//以x1 y1为起点，x2 y2为宽高画椭圆
                g.fillOval(150,150,100,100);//以x1 y1为起点，x2 y2为宽高填充椭圆
                g.setColor(new Color(0,0,255));
                g.fillOval(150,50,50,100);
        }
}
9.圆弧和扇形
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class yuanhu 
{
        public static void main(String args[])
        {
                MyFrame m=new MyFrame("OK");
                m.setSize(300,400);
                m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                m.setVisible(true);
        }
}

class MyFrame extends JFrame
{
        public MyFrame(String title)
        {
                super(title);
                getContentPane().add(new MyPanel());
        }
}

class MyPanel extends JPanel
{
        public void paintComponent(Graphics g)
        {
                super.paintComponent(g);
                for(int i=0;i<=300;i+=100)
                {
                        g.drawLine(i,0,i,300);
                        g.drawLine(0,i,300,i);
                }
                g.setColor(Color.red);
                g.drawArc(100,100,100,100,45,90);//前四个数据为弧所在的圆的数据，第5个为起始角度，第6个为跨越角度数；
                g.fillArc(200,200,100,100,225,90);//前四个数据为弧所在的圆的数据，第5个为起始角度，第6个为跨越角度数；
        }
}
10.太极图
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class taiji 
{
        public static void main(String args[])
        {
                MyFrame m=new MyFrame("OK");
                m.setSize(300,400);
                m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                m.setVisible(true);
        }
}

class MyFrame extends JFrame
{       
        public MyFrame(String title)
        {
                super(title);
                getContentPane().add(new MyPanel());            
        }
}

class MyPanel extends JPanel
{
        public void paintComponent(Graphics g)
        {
                super.paintComponent(g);
                this.setBackground(Color.white);
                Rectangle c=getBounds();
                int width=c.width*2/3;
                int left=c.width*1/6;
                int height=c.height*2/3;
                int top=c.height*1/6;
                
                g.setColor(Color.black);
                g.fillArc(left,top,width,height,90,180);
                
                g.setColor(Color.yellow);
                g.fillArc(left,top,width,height,270,180);
                
                g.setColor(Color.black);
                g.fillArc(left*2,top*3,width/2,height/2,270,180);
                
                g.setColor(Color.yellow);
                g.fillOval(left*2,top,width/2,height/2);
                
                g.setColor(Color.yellow);
                g.fillOval(left*2+left*3/4,top*3+top*3/4,width/8,height/8);
                
                g.setColor(Color.red);
                g.fillOval(left*2+left*3/4,top+top*3/4,width/8,height/8);
        }
}
11.载入图片
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class huatu 
{
        public static void main(String args[])
        {
                MyFrame m=new MyFrame("OK");
                m.setSize(300,400);
                m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                m.setVisible(true);
        }
}

class MyFrame extends JFrame
{       
        public MyFrame(String title)
        {
                super(title);
                getContentPane().add(new MyPanel());            
        }
}

class MyPanel extends JPanel
{
        Image m;
        
        public void paintComponent(Graphics g)
        {
                super.paintComponent(g);
                m=Toolkit.getDefaultToolkit().getImage("pic.gif");//Toolkit不需要实例化直接使用，获取Toolkit的默认工具箱getDefaultToolkit()，调用其载入图片的方法getImage(),
                g.drawImage(m,10,10,this);//将载入的图片显示在x1 y1起点坐标，通知this对象
        }
}
12.绘制文字
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class huizi 
{
        public static void main(String args[])
        {
                MyFrame m=new MyFrame("OK");
                m.setSize(200,400);
                m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                m.setVisible(true);
        }
}

class MyFrame extends JFrame
{
        public MyFrame(String title)
        {
                super(title);
                getContentPane().add(new MyPanel());
        }
}

class MyPanel extends JPanel
{
        public void paintComponent(Graphics g)
        {
                super.paintComponent(g);
                g.drawString("你好啊",100,50);//在x1 y1位置绘制文字
        }
}
13.字体设置
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ziti
{
        public static void main(String args[])
        {
                MyFrame m=new MyFrame("OK");
                m.setSize(200,400);
                m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                m.setVisible(true);
        }
}

class MyFrame extends JFrame
{
        public MyFrame(String title)
        {
                super(title);
                getContentPane().add(new MyPanel());
        }
}

class MyPanel extends JPanel
{
        public void paintComponent(Graphics g)
        {
                super.paintComponent(g);
                Font f=new Font("TimesRoman",Font.BOLD,72);//字体定义
                g.setFont(f);//设置字体
                g.drawString("你好啊",10,100);
        }
}
14.动画
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class donghua 
{
        public static void main(String args[])
        {
                MyFrame m=new MyFrame("OK");
                m.setSize(300,400);
                m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                m.setVisible(true);
        }
}

class MyFrame extends JFrame
{       
        public MyFrame(String title)
        {
                super(title);
                getContentPane().add(new MyPanel());            
        }
}

class MyPanel extends JPanel implements ActionListener//在JPanel的子类MyPanel中添加监听器，实现ActionListener接口
{
        int i=0;//用来调整图片的位置        
        Button b=new Button("Start!");
        Canvas c=new Canvas();//Canvas 组件表示屏幕上一个空白矩形区域，应用程序可以在该区域内绘图，或者可以从该区域捕获用户的输入事件
        
        public MyPanel()
        {
                c.setSize(50,50);
                c.setBackground(Color.red);
                add(b);
                add(c);
                b.addActionListener(this);
        }
        
        public void paint(Graphics g)
        {
                c.setLocation(i,100);
        }
        
        public void actionPerformed(ActionEvent e)
        {               
                for(;i<150;i++)
                {
                        for(int y=0;y<999999;y++);      
                                repaint();
                }
        }
}