java程序和网络上多台机器的c程序通讯的项目，遵循的是TCP/IP协议，用到了java的Socket编程。网络通讯是java的强项，用TCP/IP协议可以方便的和网络上的其他程序互通消息。 

先来介绍下网络协议： 
    TCP/IP 
        Transmission Control Protocol 传输控制协议 
        Internet Protocol 互联网协议 
    UDP 
        User Datagram Protocol 用户数据协议 

连接协议： 
    分为： 
    面向连接协议: Connection Oriented Protocol 
    非连接协议: Connectionless Protocol 

    1).面向连接协议是指两台电脑在传输数据前，先会建立一个专属的连接。就如电信局的交换机会为打电话双方提供专属连接一样。 
    Internet上的面向连接协议就是TCP/IP 
    特点：确认回应；分组序号；流量控制。 
    TCP/IP属于可靠性传输，适合不容许有传输错误的网络程序设计使用 

    2).非连接协议：无专属连接，无分组，容错，距离短，可同时对多台电脑进行数据传输 
    Internet上的非连接协议就是UDP 

    TCP在网络通信上有极强的生命力，例如远程连接（Telnet）和文件传输（FTP）都需要不定长度的数据被可靠地传输。相比之下UDP操作简单，而且仅需要较少的监护，因此通常用于局域网高可靠性的分散系统中client/server应用程序。 


Socket 是程序与网络间的一种接口，大部分网络应用程序都是点对点的，所谓点就是服务器端和客户端所执行的程序。Socket是用来接收和传送分组的一个端点。 

java的Socket编程要用到java.net包，最常用的是net包下的6个类：InetAddress(互联网协议 (IP) 地址)类，Socket(套接字)类，ServerSocket(套接字服务器)类，DatagramSocket(发送和接收数据报包的套接字)类，DatagramPacket(数据报包)类，MulticastSocket(多播数据报套接字类用于发送和接收 IP 多播包)类，其中InetAddress、Socket、ServerSocket类是属于TCP面向连接协议，DatagramSocket、DatagramPacket和MulticastSocket类则属于UDP非连接协议的传送类。 

本项目因为使用TCP/IP协议，主要用到Socket和ServerSocket类 

项目代码如下 

Java代码 
package com.sse.monitor.serv;  
  
import java.io.DataInputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  
import java.io.BufferedOutputStream;  
  
import java.net.InetAddress;  
import java.net.InetSocketAddress;  
import java.net.Socket;  
import java.net.UnknownHostException;  
import java.util.ArrayList;  
  
import com.sse.monitor.bean.Message;  
import com.sse.monitor.bean.MessageHead;  
import com.sse.monitor.bean.ResponseMessage;  
import com.sse.monitor.form.ListenerInvoke;  
import com.sse.monitor.form.MainForm;  
import com.sse.monitor.util.SwingUtils;  
  
/** 
 * Socket套接字工厂，对外接口是静态方法request(String, String) 
 * Copyright: Copyright (c) 2008 
 * @author cuishen 
 * @version 1.0 
 */  
public class SocketFactory {  
    private Socket socket = null;  
    private String targetIpAddress = null;  
    private int targetPort = 0;  
    private InetAddress localIpAddress = null;  
      
    public SocketFactory(String targetIpAddress, int targetPort) {  
        try {  
            connect(targetIpAddress, targetPort);  
        } catch (UnknownHostException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
          
    /** 
     * 建立一条TCP/IP连接 
     * @param targetIpAddress String 目标ip地址 
     * @param targetPort String 目标端口 
     * @throws UnknownHostException 
     * @throws IOException 
     */  
    private void connect(String targetIpAddress, int targetPort) throws UnknownHostException, IOException {  
        if(socket != null && socket.isConnected() && ifConnectIpEqualsTargetIp(targetIpAddress)) {  
            return;  
        }  
        setTargetIpAddress(targetIpAddress);  
        setTargetPort(targetPort);  
        localIpAddress = convertIpAddress(ReadConfig.localIpAddress);  
        if(socket == null) {  
            socket = new Socket(targetIpAddress, targetPort, localIpAddress, ReadConfig.localClientPort);  
            return;  
        }  
        socket.connect(new InetSocketAddress(convertIpAddress(targetIpAddress), targetPort));  
    }  
      
    /** 
     * 判断已连接ip和传的参数是否是同一个ip地址 
     * @param targetIpAddress String 
     * @return 
     */  
    private boolean ifConnectIpEqualsTargetIp(String targetIpAddress) {  
        InetAddress connectIp = socket.getInetAddress();  
        InetAddress targetIp = null;  
        try {  
            targetIp = convertIpAddress(targetIpAddress);  
        } catch (UnknownHostException e) {  
            e.printStackTrace();  
        }  
        return connectIp.equals(targetIp) ? true : false;  
    }  
      
    /** 
     * 暴露给用户的接口，发送命令，并接收反馈和message 
     * @param commandType String 命令类型 
     * @param commandContent String 命令内容 
     */  
    public static void request(String commandType, String commandContent) {  
        SocketFactory sf = new SocketFactory(ReadConfig.targetIpAddress, ReadConfig.targetPort);  
          
        sf.sendRequest(commandType, commandContent);  
        sf.new ServerThread(sf, commandType);  
    }  
      
    /** 
     * 发送请求 
     * @param commandType String 命令类型 
     * @param commandContent String 命令内容 
     */  
    private void sendRequest(String commandType, String commandContent) {  
        OutputStream os = null;  
        BufferedOutputStream bs = null;  
        try {  
            os = socket.getOutputStream();  
            bs = new BufferedOutputStream(os);  
            char[] message = MessageFactory.makeRequestMessage(targetIpAddress, commandType, commandContent, MessageFactory.COMMAND_TRADE_CODE, MessageFactory.RIGHT_COMMAND, MessageFactory.MESSAGE_END_FLAG);  
            for(int i = 0; i < message.length; i++)  
                bs.write(new String(message).getBytes(), i, 1);  
            bs.flush();  
            SwingUtils.appendLog(MainForm.jTextArea, "发送请求：'" + commandType + "' '" + commandContent + "'", ReadConfig.commandStateShowLineCount);  
        } catch (IOException e) {  
            SwingUtils.appendLog(MainForm.jTextArea, "Error!!! 发送请求：'" + commandType + "' '" + commandContent + "'失败！！ " + e.getMessage(), ReadConfig.commandStateShowLineCount);  
            e.printStackTrace();  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            //closeOutputStream(os, bs);  
        }  
    }  
      
    /** 
     * 获得反馈 
     * @return 如果成功获得反馈，则返回true；否则返回false 
     */  
    private boolean getResponse() {  
        InputStream is = null;  
        DataInputStream di = null;  
        boolean returnFlag = false;  
        try {  
            is = socket.getInputStream();  
            di = new DataInputStream(is);  
            byte[] temp = new byte[1];  
            int flag = 0;  
            ArrayList tempByteList = new ArrayList();  
            int i = 0;  
            while(flag != -1) {  
                i++;  
                flag = di.read(temp = new byte[1]);  
                if(flag != -1) tempByteList.add(temp);  
                if(i == 38) break;  
            }  
            if(i == 1) {  
                SwingUtils.Error("未收到response!!!");  
                return false;  
            }  
            MessageHead messageHead = MessageFactory.readHead(tempByteList);  
              
            SwingUtils.appendLog(MainForm.jTextArea, "收到 response", ReadConfig.commandStateShowLineCount);            
            tempByteList = new ArrayList();  
            i = 0;  
            while(flag != -1) {  
                i++;  
                flag = di.read(temp = new byte[1]);  
                if(flag != -1) tempByteList.add(temp);  
                if(i == 26) break;  
            }  
            byte[] length = new byte[4];  
            di.read(length);  
            int len = Integer.parseInt(new String(length, MessageFactory.DEFAULT_CHAR_SET).trim());  
            flag = 0;  
            for(int j = 0; j < (len + 37); j++) {  
                flag = di.read(temp = new byte[1]);  
                if(flag == -1) break;  
                tempByteList.add(temp);  
            }  
              
            ResponseMessage rm = MessageFactory.readResponseMessage(tempByteList, len);       
            if(messageHead.getErrorCode().equals(MessageFactory.SUCCESS)) returnFlag = true;  
            else SwingUtils.Error("errorCode: " + messageHead.getErrorCode() + "; content: " + rm.getCommandContent());  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            //closeInputStream(is, di);  
        }  
        return returnFlag;  
    }  
      
    /** 
     * 分发消息的方法,将消息按进程名发送到对应的消息缓存 
     * 消息缓存ListenerInvoke.messageMap，key = machineName + '|' + programName + '|' + processId, value = messageList 
     * 存放messageMap里面的键名的List -- ListenerInvoke.messageMapKeyList 
     * 进程状态缓存ListenerInvoke.processStateMap, key = machineName + '|' + programName + '|' + processId, value = String 
     * @param message Message 
     */  
    private void distributeMess(Message message) {  
        String machineName = message.getMachineName();  
        String programName = message.getProgramName();  
        String processId = message.getProcessId();  
        String messGrade = message.getMessageGrade();  
        String content = message.getContent();  
        String key = machineName + '|' + programName + '|' + processId;  
        ArrayList messageList = (ArrayList) ListenerInvoke.messageMap.get(key);           
        if(messageList == null) {  
            messageList = new ArrayList();  
            messageList.add(content);  
            ListenerInvoke.messageMap.put(key, messageList);   
        } else {  
            synchronized(messageList) {  
                messageList.add(content);  
                if(!ReadConfig.threadDeleteMessCacheOrFIFO && messageList.size() >= ReadConfig.messageCacheSizeLimit)  
                    messageList.remove(0);  
            }  
        }  
        ListenerInvoke.processStateMap.put(key, messGrade);  
        if(!ListenerInvoke.messageMapKeyList.contains(key))   
            ListenerInvoke.messageMapKeyList.add(key);  
    }  
      
    /** 
     * 接收message 
     * @return Message 
     */  
    private Message getMessage() {  
        InputStream is = null;  
        DataInputStream di = null;  
        Message message = null;  
        try {  
            is = this.socket.getInputStream();  
            di = new DataInputStream(is);  
            byte[] temp = new byte[1];  
            int flag = 0;  
            ArrayList tempByteList = new ArrayList();  
            int i = 0;  
            while(flag != -1) {  
                i++;  
                flag = di.read(temp = new byte[1]);  
                if(flag != -1) tempByteList.add(temp);  
                if(i == 38) break;  
            }  
            if (i == 1) return null;                         tempByteList = new ArrayList();  
            i = 0;  
            while(flag != -1) {  
                i++;  
                flag = di.read(temp = new byte[1]);  
                if(flag != -1) tempByteList.add(temp);  
                if(i == 74) break;  
            }  
            byte[] length = new byte[4];  
            di.read(length);  
            int len = Integer.parseInt(new String(length, MessageFactory.DEFAULT_CHAR_SET).trim());  
            //System.out.println("len ==== > " + len);  
            flag = 0;  
            for(int j = 0; j < len; j++) {  
                flag = di.read(temp = new byte[1]);  
                if(flag == -1) break;  
                tempByteList.add(temp);  
            }  
            message = MessageFactory.readMessage(tempByteList, len);  
            SwingUtils.appendLog(MainForm.jTextArea, "收到新 Message", ReadConfig.commandStateShowLineCount);            
            distributeMess(message);//分发message  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
        }  
        return message;  
    }  
  
    /** 
     * 内部线程类，将接收反馈和消息放进内部线程处理，防止主线程阻塞或挂死 
     * @author cuishen 
     * @version 1.0 
     */  
    class ServerThread implements Runnable {  
        SocketFactory socketFactory;  
        String commandType = null;  
        Thread t;  
        boolean flag = false;  
        boolean ifFirstExec = true;  
        private boolean ifGetMessage = true;  
          
        public ServerThread(SocketFactory socketFactory, String commandType) {  
            this.socketFactory = socketFactory;  
            this.commandType = commandType;  
            t = new Thread(this);  
            t.start();  
        }  
  
        public void run() {  
            try {  
                while(ifGetMessage) {  
                    if(ifFirstExec) {  
                        flag = socketFactory.getResponse();  
                        ifFirstExec = false;  
                    }  
                    if(flag) {  
                        if(commandType.equalsIgnoreCase(MessageFactory.SCAN_COMMAND) && socket != null) socketFactory.getMessage();  
                        else {  
                            stopThread();  
                        }  
                    } else {  
                        stopThread();  
                    }  
                    Thread.sleep(ReadConfig.getMessageThreadSleep);  
                }  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }   
        }  
        public void stopThread() {  
            try {  
                socketFactory.closeSocket();  
                socketFactory = null;  
                ifGetMessage = false;  
                this.t.join(100);  
            } catch (InterruptedException ex) {  
                System.out.println("socket服务器线程终止异常！！！");  
            } finally {  
                t = null;  
            }  
        }  
    }  
  
      
    /** 
     * 将String转换为InetAddress 
     * @param ipAddress String 
     * @return InetAddress 
     * @throws UnknownHostException 
     */  
    private InetAddress convertIpAddress(String ipAddress) throws UnknownHostException {  
          
        byte[] temp = new byte[4];  
        String [] tempIp = ipAddress.trim().split("\\.");  
        for(int i = 0; i < tempIp.length; i++) {  
            temp[i] = (byte)(Integer.parseInt(tempIp[i]));  
        }  
        return InetAddress.getByAddress(temp);  
    }  
          
    /** 
     * 关闭套接字 
     */  
    private void closeSocket() {  
        try {  
            if(!socket.isClosed()) socket.close();  
            socket = null;  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  
    /** 
     * @return the targetIpAddress 
     */  
    public String getTargetIpAddress() {  
        return targetIpAddress;  
    }  
  
    /** 
     * @param targetIpAddress the targetIpAddress to set 
     */  
    public void setTargetIpAddress(String targetIpAddress) {  
        this.targetIpAddress = targetIpAddress;  
    }  
  
    /** 
     * @return the targetPort 
     */  
    public int getTargetPort() {  
        return targetPort;  
    }  
  
    /** 
     * @param targetPort the targetPort to set 
     */  
    public void setTargetPort(int targetPort) {  
        this.targetPort = targetPort;  
    }  
      
}  


以上是Socket编程，ServerSocket在项目里没有用到，但是我也写了个包装类供参考 
Java代码 
package com.sse.monitor.serv;  
  
import java.io.IOException;  
import java.net.ServerSocket;  
import java.net.Socket;  
  
/** 
 * 服务器套接字工厂 
 * Copyright: Copyright (c) 2008 
 * @author cuishen 
 * @version 1.0 
 */  
public class ServerSocketFactory {  
    private static ServerSocket server;  
    private static Socket client;  
    public static boolean ifRunServer = true;  
      
    public void runServer(int port) throws IOException {  
        //本地建立一个套接字服务器，等待其他机器访问  
        server = new ServerSocket(port);  
        System.out.println("Socket Server Start...");  
        new ServerThread();  
    }  
      
  
    class ServerThread implements Runnable {  
        Thread t;  
          
        public ServerThread() {  
            t = new Thread(this);  
            t.start();  
        }  
  
        public void run() {  
            try {  
                while(ifRunServer) {  
                    if(client == null) client = server.accept();  
                    if(client != null) //getMessage();  
                    Thread.sleep(ReadConfig.serverThreadSleep);  
                }  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }   
            catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        public void stopThread() {  
            try {  
                ifRunServer = false;  
                this.t.join(100);  
            } catch (InterruptedException ex) {  
                System.out.println("socket服务器线程终止异常！！！");  
            } finally {  
                t = null;  
            }  
        }  
    }  
}  


以上代码很简单吧，相信你一看就懂，Socket编程就是运用Socket或者ServerSocket类搭配线程来使用(为了防止主线程挂死，接收消息的方法要放进子线程里)，可以同时开发个Message类来封装打包和解包消息的方法，方便调用

