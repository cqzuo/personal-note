�����ĸ��������У�InputStream��Reader��������ȫ��ͬ�Ľӿڣ�

int read()
int read(char cbuf[])
int read(char cbuf[], int offset, int length) 

��OutputStream��WriterҲ����ˣ�

int write(int c) 
int write(char cbuf[])
int write(char cbuf[], int offset, int length) 

��������������������ģ�read()��write()ͨ����������������дһ���ֽڣ�����һ���ֽ����顣

���������Ĺ����������ǵ�������������ɵġ�֪����Java��������Ļ�����νṹ�Ժ󣬱���������������һЩ�Ժ���Է���Ӧ�����ӣ��������������ϸ�ڼ��书�ܲ�����ϸ���ۡ�

import java.io.*;

public class IOStreamDemo {

      public void samples() throws IOException {

           //1. ���ǴӼ��̶���һ������,���ص���һ���ַ���
           BufferedReader stdin =new BufferedReader(new InputStreamReader(System.in)); 
           System.out.print("Enter a line:");
           System.out.println(stdin.readLine());

           //2. ���Ǵ��ļ������ж������� 

           BufferedReader in = new BufferedReader(new FileReader("IOStreamDemo.java"));
           String s, s2 = new String();
           while((s = in.readLine())!= null)
                       s2 += s + "\n";
            in.close();


           //3. ���Ǵ�һ���ַ�������������ֽ� 
           StringReader in1 = new StringReader(s2);
           int c;
           while((c = in1.read()) != -1)
                      System.out.print((char)c);


           //4. ���ǽ�һ���ַ���д���ļ� 
           try {
                      BufferedReader in2 = new BufferedReader(new StringReader(s2));
                      PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter("IODemo.out")));
                      int lineCount = 1;
                      while((s = in2.readLine()) != null )
                                  out1.println(lineCount++ + ": " + s);
                       out1.close();
            } catch(EOFException e) {
                      System.err.println("End of stream");
            }
       } 

}
 

������������ӣ���Ҫ˵���������¼��㣺

1. BufferedReader��Reader��һ�����࣬�����л�������ã�������Ƶ���Ĵ������豸�ж�ȡ��Ϣ�����������������캯����

BufferedReader(Reader in) 
BufferedReader(Reader in, int sz)  

�����sz��ָ���������Ĵ�С��

���Ļ���������

void close() //�ر��� 

           void mark(int readAheadLimit) //��ǵ�ǰλ��

           boolean markSupported() //�Ƿ�֧�ֱ��

           int read() //�̳���Reader�Ļ�������

           int read(char[] cbuf, int off, int len) //�̳���Reader�Ļ�������

           String readLine() //��ȡһ�����ݲ����ַ�����ʽ����

           boolean ready() //�ж����Ƿ��Ѿ����ö����׼��

           void reset() //���赽�����һ�����

           long skip(long n) //����ָ���������ַ���ȡ 

2. InputStreamReader��InputStream��Reader֮�������������System.in���ֽ�������Ҫ��������װ֮���Ϊ�ַ�������             BufferedReaderʹ�á�


3. PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter("IODemo.out")));

��仰������Java�������ϵͳ��һ���ص㣬Ϊ�˴ﵽĳ��Ŀ�ģ���Ҫ��װ�ü��㡣���ȣ����Ŀ�ĵ����ļ�IODemo.out���������ڲ��װ����FileWriter������һ������ļ�����������������ϣ��������ǻ���ģ�������BufferedWriter����װ���ԴﵽĿ�ģ����������Ҫ��ʽ�������������ǽ�PrintWriter��������㡣


Java�ṩ������һ�����ܣ�����׼�����������ת��Ҳ����˵�����ǿ��Խ�ĳ������������Ϊ��׼������������������������ӣ�

import java.io.*;

public class Redirecting {

        public static void main(String[] args) throws IOException {
              PrintStream console = System.out;
              BufferedInputStream in = new BufferedInputStream( new FileInputStream( "Redirecting.java"));
              PrintStream out = new PrintStream( new BufferedOutputStream( new FileOutputStream("test.out")));
               System.setIn(in);
               System.setOut(out);

              BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
              String s;
              while((s = br.readLine()) != null)
                      System.out.println(s);
               out.close(); 
               System.setOut(console);
       } 
}
 

������java.lang.System�ľ�̬����

static void setIn(InputStream in) 
static void setOut(PrintStream out)  

�ṩ�����¶����׼����������ķ������������Ǻܷ���ģ�����һ������Ľ���кܶ࣬��ʱ������Ҫ��ҳ��ʾ�����������ڹۿ������������Ϳ��Խ���׼���������Ϊһ���ļ���������������֮�����Ӧ���ļ��ۿ��������ֱ������ࡣ

Java��������һ����Ҫ����;���Ǿ������ö������Զ���������л������潫��ʼ�����ⷽ������⡣

��һ���������е�ʱ�����еı��������Ǳ������ڴ��еģ�һ�����������Щ���ݽ����ᱻ���棬һ�ֽ���İ취�ǽ�����д���ļ�����Java���ṩ��һ�ֻ��ƣ������Խ������еĶ���д���ļ���֮���ٴ��ļ��аѶ�����������½������������ν�Ķ������л�Java����������Ҫ��Ϊ��RMI��Remote Method Invocation����Java Bean���ã�������ƽʱӦ���У���Ҳ�Ǻ����õ�һ�ּ�����

������Ҫʵ�ֶ������л��Ķ����������ʵ��Serializable�ӿڡ����濴һ�����ӣ�

import java.io.*;
import java.util.*;

public class Logon implements Serializable {

       private Date date = new Date();
       private String username;
       private transient String password;


        Logon(String name, String pwd) {
               username = name;
               password = pwd;
        }


       public String toString() {
              String pwd = (password == null) ? "(n/a)" : password;
               return "logon info: \n " + "username: " + username + "\n date: " + date + "\n password: " + pwd;
        }


        public static void main(String[] args) throws IOException, ClassNotFoundException {
              Logon a = new Logon("Morgan", "morgan83");
              System.out.println( "logon a = " + a);
              ObjectOutputStream o = new ObjectOutputStream( new FileOutputStream("Logon.out"));
               o.writeObject(a);
               o.close();

              int seconds = 5;
              long t = System.currentTimeMillis() + seconds * 1000;
              while(System.currentTimeMillis() < t) ;

              ObjectInputStream in = new ObjectInputStream( new FileInputStream("Logon.out"));
              System.out.println( "Recovering object at " + new Date());
               a = (Logon)in.readObject();
              System.out.println("logon a = " + a); 
        }
}
 

��Logon��һ����¼��¼��Ϣ���࣬�����û��������롣������ʵ���˽ӿ�Serializable����ͱ�־�������Ա����л���֮����main������ObjectOutputStream o = new ObjectOutputStream( new FileOutputStream("Logon.out"));�½�һ�������������װһ���ļ�������ʾ�������л���Ŀ�ĵ����ļ�Logon.out��Ȼ���÷���writeObject��ʼд�롣��Ҫ��ԭ��ʱ��Ҳ�ܼ�ObjectInputStream in = new ObjectInputStream( new FileInputStream("Logon.out"));�½�һ���������������ļ���Logon.outΪ������֮�����readObject�����Ϳ����ˡ�

��Ҫ˵��һ�㣬�������л���һ������֮�����ǣ���������һ�Ŷ�����������ǰҪ���л��Ķ����������е�����ָ��Ķ��󶼰�������һ��д�뵽�ļ�����Ϊ������ǣ������һ�����л��˺ü���������������ͬ�����ݽ��ᱻ����д�롣���ȷ��һ���ǳ��õĻ��ơ�����������ʵ����㿽�����й���㿽����������JavaWorld����һƪ�������˼���ʵ�ַ����Ľ��ܺͱȽϣ�����Ȥ�߿���ȥ������

�ؼ���transient�������ʾ��ǰ���ݽ��������л������������е����룬��Ҫ���ܣ�����û�б�д���ļ���


