package org.whut.monitor.business.messageHandler.service;

import org.dom4j.Document;
import org.dom4j.Element;
import org.whut.monitor.business.messageHandler.entity.FrameUnit;
import org.whut.monitor.business.messageHandler.entity.Message;
import org.whut.monitor.business.messageHandler.utils.Print;
import org.whut.monitor.business.messageHandler.utils.XMLHelper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 涵 on 2015/4/22.
 */
public class AnalyseXMLNodes {
    private List<Element> elementList;
    public List<Element> getElementList() {
        return elementList;
    }
    public void setElementList(List<Element> elementList) {
        this.elementList = elementList;
    }
    public AnalyseXMLNodes() {
        this.elementList = new ArrayList<Element>();
    }

    public Message analyseXMLRoot(Document document){
        Message message = new Message();
        Element root =  document.getRootElement();
        int mId = Integer.parseInt(root.attribute("mId").getValue());
        Print.print("mid", String.valueOf(mId));
        String mName = root.attribute("mName").getValue();
        Print.print("mName",mName);
        String protocol = root.attributeValue("protocol");
        Print.print("protocol",protocol);
        String version = root.attributeValue("version");
        Print.print("version",version);
        String classPath = root.attributeValue("classPath");
        Print.print("classPath",classPath);
        message.setmId(mId);
        message.setmName(mName);
        message.setProtocol(protocol);
        message.setVersion(version);
        return message;
    }
    public void analyseXMLElements(Element root){
        Iterator<Element> it = root.elementIterator();
        while(it.hasNext()){
            Element e = it.next();
            if(e.elements().size()!=0){
                analyseXMLElements(e);
            }
            else {
                elementList.add(e);
            }
        }
    }
    public List<FrameUnit> analyseNodes(){
        List<FrameUnit> list = new ArrayList<FrameUnit>();
        List<Element> elements = this.getElementList();
        Iterator<Element> iterator = elements.iterator();
        while (iterator.hasNext()){
            Element element = iterator.next();
            int byteNumber= Integer.parseInt(element.attributeValue("byteNum"));
            String byteToData = element.attributeValue("byteToData");
            String[] strings1 = XMLHelper.analyseMethod(byteToData);
            String byteToDataClasspath = strings1[0];
            String byteToMethodName = strings1[1];
            String dataToByte = element.attributeValue("dataToByte");
            String[] strings2 = XMLHelper.analyseMethod(dataToByte);
            String dataToByteClasspath = strings2[0];
            String dataToByteMethod = strings2[1];
            FrameUnit frameUnit = new FrameUnit();
            frameUnit.setByteNumber(byteNumber);
            frameUnit.setByteToDataClasspath(byteToDataClasspath);
            frameUnit.setByteToDataMethodName(byteToMethodName);
            frameUnit.setDataToByteClasspath(dataToByteClasspath);
            frameUnit.setDataToByteMethodName(dataToByteMethod);
            list.add(frameUnit);
        }
        return list;
    }
    public Element analyseRootElement(Document document){
        return document.getRootElement();
    }
}
