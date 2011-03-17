<?xml version="1.0" encoding="UTF-8" standalone="no"?>
 <name >
  <first>1</first>
  <last info="非机动车">2</last>
 </name>
怎样读取 info 的值和修改它的值!!!!! 
我用的Dom4j，源码如下
import java.io.*;
import java.util.*;
import org.dom4j.*;
import org.dom4j.io.*;
public class Dom4jTester {
//属性为要设置和修改的info
    public static String info;
//
    public static void main(String[] args) {
        modiXml("机动车辆");
        loadXml();
        System.out.println("info = " + info);
    }

    /*读取
        用SAXReader对象的read()来读取xml文件,存储在Document对象中
        用Document对象的selectNodes()方法将节点上的信息存储到List集合中
    */
    public static void loadXml() {
        SAXReader saxReader = null;
        Document doc = null;
        try {
            saxReader = new SAXReader();
            doc = saxReader.read("test.xml");

            List<Element> list = doc.selectNodes("//name//last");
            Element last = null;
            for (Iterator<Element> i = list.iterator(); i.hasNext();) {
                last = i.next();
                info = last.attributeValue("info");
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    //修改
    public static void modiXml(String newInfo) {
        SAXReader saxReader = null;
        Document doc = null;
        try {
            saxReader = new SAXReader();
            doc = saxReader.read("test.xml");

            List<Element> list = doc.selectNodes("//name//last");
            Element last = null;
            for (Iterator<Element> i = list.iterator(); i.hasNext();) {
                last = i.next();
                last.attribute("info").setValue(newInfo);
            }

            XMLWriter writer = new XMLWriter();
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("GBK");
            writer = new XMLWriter(new FileWriter(new File("test.xml")));

            writer.write(doc);
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} 
