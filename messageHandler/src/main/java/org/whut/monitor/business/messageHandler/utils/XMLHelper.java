package org.whut.monitor.business.messageHandler.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;

/**
 * Created by 涵 on 2015/4/20.
 */
public class XMLHelper {
    public static Document getDocument(File file){
        SAXReader saxReader =  new SAXReader();
        Document document = null;
        try {
            document = saxReader.read(file);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return document;
    }

    public static Object getObjectByClasspath(String classpath){
        Object object = null;
        try {
            Class clazz = Class.forName(classpath);
            object = clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return object;
    }

    public static String[] analyseMethod(String methodName){
        int index = methodName.lastIndexOf(".");
        String classPath = methodName.substring(0,index);
        String method = methodName.substring(index+1,methodName.length());
        String[] strings = new String[2];
        strings[0] = classPath;
        strings[1] = method;
        return strings;
    }
}
