�򵥵Ĵ����ͼ
�ڴ����Ͻ��л�ͼ�����ַ�ʽ��һ����ͨ����дpaint����ʵ���Զ����ͼ��paint�������ṩ�˿�������Ļ�ϻ�ͼ��ͼ���豸�ӿ����������һ�ַ�ʽ��ͨ��ֱ�ӻ�ȡ��ǰ��Ļ��ͼ���豸�ӿ��������С����⣬Ҳ���Ը�������Ӵ��л�ͼ�����ʵ�ִ����ͼ��
1.��дpaint���������ӣ�
import java.awt.*;
import javax.swing.*;

public class exec //��main������ʵ��������
{
        public static void main(String args[])
        {
                MyFrame m=new MyFrame("OK");
                m.setSize(200,400);
                m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                m.setVisible(true);
        }
}

class MyFrame extends JFrame//�����Լ���Ҫ����

        public MyFrame(String title)//���캯��
        {
                super(title);
        }
        
        public void paint(Graphics g)//��дpaint����
        {
                setBackground(Color.yellow);//setBackground���ñ���ɫ��Graphicsͼ���豸�ӿ�������setColor��������ǰ��ɫ��drawLineΪ����ֱ�ߣ������ĸ������ֱ�Ϊ��ʼ���x��yֵ����ֹ���x��yֵ
                g.setColor(Color.red);
                g.drawLine(0,0,100,100);
        }
}
2.ֱ�ӻ�ȡ��ǰ��Ļͼ���豸�ӿ���Ļ�ͼ��ʽ
����Ҫ������getGraphics()��������ȡ�ģ����ַ�ʽ�����Ը�������ʵ�ֻ�ͼ
import java.awt.*;
import java.awt.event.*;//�ó������¼�����
import javax.swing.*;

public class exec 
{
        public static void main(String args[])//��main������ʵ����MyFrame�����
        {
                MyFrame m=new MyFrame("OK");
                m.setSize(300,400);
                m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ڳ����˳�ʱ�Ķ���
                m.setVisible(true);
        }
}

class MyFrame extends JFrame implements ActionListener//��JFrame�����࣬ʵ����ActionListener�ӿ�
{       
        Button b=new Button("Draw Line");//���������ϵİ�ť
        
        public MyFrame(String title)
        {
                super(title);
                getContentPane().setLayout(new FlowLayout());//��ťҪ����JFrame�����ϣ�����Ҫ����ʽ����
                getContentPane().add(b);//����ť��ӵ�JFrame��
                b.addActionListener(this);//�����������ڰ�ť��      
        }
        
        public void actionPerformed(ActionEvent e)//ʵ��ActionListener�ӿڱ�����дactionPerformed()����
        {               
                Graphics g=getGraphics();//��ȡһ��Graphics����
                g.drawLine(0,0,100,100);//Graphics�����drawLine����
        }
}
3.�����ʵ�ֻ�ͼ����
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class exec //��������ִ�в���
{
        public static void main(String args[])
        {
                MyFrame m=new MyFrame("OK");//ʵ�������࣬����
                m.setSize(200,400);
                m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                m.setVisible(true);
        }
}

class MyFrame extends JFrame//������ػ�ͼ��崰��
{
        public MyFrame(String title)
        {
                super(title);
                getContentPane().add(new MyPanel());//�������ӵ�������
        }
}

class MyPanel extends JPanel//���ػ�ͼ�����������
{
        public void paintComponent(Graphics g)//��д����JPanel��paintComponent()����
        {
                super.paintComponent(g);
                setBackground(Color.yellow);
                g.setColor(Color.red);
                g.drawLine(0,0,100,100);
        }
}
4.�û������µĻ�ͼ
import java.awt.*;
import java.awt.event.*;//���¼�����
import javax.swing.*;

public class contral//һ��public����ִ�в���
{
        public static void main(String args[])
        {
                MyFrame m=new MyFrame("OK");//ʵ�����Զ�����࣬���ô����С
                m.setSize(300,400);
                m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                m.setVisible(true);
        }
}

class MyFrame extends JFrame//�����Զ��崰����
{       
        public MyFrame(String title)
        {
                super(title);
                getContentPane().add(new MyPanel()); //�Զ��崰����JFrame������Զ��������JPanel����           
        }
}

class MyPanel extends JPanel implements ActionListener//JPanel�����ʵ��ActionListener�ӿ�
{
        Button b=new Button("Draw Line");//�����еİ�ť���������û�����
        
        public MyPanel()
        {
                add(b);//����ť��ӵ������
                b.addActionListener(this);//���������Ӽ�����
        }
        
        public void actionPerformed(ActionEvent e)//ʵ��ActionListener�ӿڣ���дactionPerformed����
        {               
                Graphics g=getGraphics();
                g.drawLine(0,0,100,100);//�ڼ������е���Graphics���drawLine������ͼ(��ʾ��x1,y1��x2,y2��ͼ)
        }
}
6.������
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class huaxian 
{
        public static void main(String args[])//��public class��main��ִ��ʵ�����Ͳ���
        {
                MyFrame m=new MyFrame("OK");
                m.setSize(200,400);
                m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                m.setVisible(true);
        }
}

class MyFrame extends JFrame//����һ������������MyPanel���
{
        public MyFrame(String title)
        {
                super(title);
                getContentPane().add(new MyPanel());
        }
}

class MyPanel extends JPanel//����JPanel����MyPanel����ͼ
{
        public void paintComponent(Graphics g)
        {
                super.paintComponent(g);
                
                for(int i=0;i<=this.getSize().width;i+=10)//this��MyPanel����
                {
                        g.drawLine(i,0,i,this.getSize().height);
                }
                for(int i=0;i<=this.getSize().height;i+=10)
                {
                        g.drawLine(0,i,this.getSize().width,i);                 
                }
                
        }
}
7.��һ������
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class juxing 
{
        public static void main(String args[])//��public class juxing ��main�����г�ʼ���Զ�����ࣻ
        {
                MyFrame m=new MyFrame("OK");
                m.setSize(200,400);
                m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                m.setVisible(true);
        }
}

class MyFrame extends JFrame//�Զ���һ��������̳���JFrame�࣬���������һ���µ�������
{
        public MyFrame(String title)
        {
                super(title);
                getContentPane().add(new MyPanel());
        }
}

class MyPanel extends JPanel//�Զ���һ��������̳���JPanel��
{
        public void paintComponent(Graphics g)//��дpaintComponent����������ΪGraphics���� g;
        {
                super.paintComponent(g);//���ø����paintComponent����;
                for(int i=0;i<=300;i+=50)
                {
                        g.drawLine(i,0,i,300);
                        g.drawLine(0,i,300,i);
                }
                g.setColor(Color.green);//���þ��α߿����ɫ
                g.drawRect(50,50,100,100);//��x1 y1 ��x2 y2Ϊ�Խ��߻�����
                
                g.setColor(Color.red);//������ɫ
                g.fillRect(100,100,50,50);//��x1 y1Ϊ��㣬x2 y2Ϊ���������
        }
}
8.��һ��Բ��
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
                g.drawOval(50,50,100,100);//��x1 y1Ϊ��㣬x2 y2Ϊ��߻���Բ
                g.fillOval(150,150,100,100);//��x1 y1Ϊ��㣬x2 y2Ϊ��������Բ
                g.setColor(new Color(0,0,255));
                g.fillOval(150,50,50,100);
        }
}
9.Բ��������
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
                g.drawArc(100,100,100,100,45,90);//ǰ�ĸ�����Ϊ�����ڵ�Բ�����ݣ���5��Ϊ��ʼ�Ƕȣ���6��Ϊ��Խ�Ƕ�����
                g.fillArc(200,200,100,100,225,90);//ǰ�ĸ�����Ϊ�����ڵ�Բ�����ݣ���5��Ϊ��ʼ�Ƕȣ���6��Ϊ��Խ�Ƕ�����
        }
}
10.̫��ͼ
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
11.����ͼƬ
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
                m=Toolkit.getDefaultToolkit().getImage("pic.gif");//Toolkit����Ҫʵ����ֱ��ʹ�ã���ȡToolkit��Ĭ�Ϲ�����getDefaultToolkit()������������ͼƬ�ķ���getImage(),
                g.drawImage(m,10,10,this);//�������ͼƬ��ʾ��x1 y1������֪꣬ͨthis����
        }
}
12.��������
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
                g.drawString("��ð�",100,50);//��x1 y1λ�û�������
        }
}
13.��������
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
                Font f=new Font("TimesRoman",Font.BOLD,72);//���嶨��
                g.setFont(f);//��������
                g.drawString("��ð�",10,100);
        }
}
14.����
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

class MyPanel extends JPanel implements ActionListener//��JPanel������MyPanel����Ӽ�������ʵ��ActionListener�ӿ�
{
        int i=0;//��������ͼƬ��λ��        
        Button b=new Button("Start!");
        Canvas c=new Canvas();//Canvas �����ʾ��Ļ��һ���հ׾�������Ӧ�ó�������ڸ������ڻ�ͼ�����߿��ԴӸ����򲶻��û��������¼�
        
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