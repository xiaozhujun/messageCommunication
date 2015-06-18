package org.whut.monitor.business.messageHandler.analyse;

import org.dom4j.Document;
import org.whut.monitor.business.messageHandler.messageHandleInterface.AnalyseInterface;
import org.whut.monitor.business.messageHandler.messageHandle.SensorDataAnalyse;
import org.whut.monitor.business.messageHandler.entity.FrameUnit;
import org.whut.monitor.business.messageHandler.service.AnalyseXMLNodes;
import org.whut.monitor.business.messageHandler.utils.XMLHelper;
import org.whut.monitor.business.messageHandler.utils.FileHelper;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by 涵 on 2015/5/1.
 */
public class Analyse implements AnalyseInterface{
    @Override
    public List<FrameUnit> analyse(String fileName, byte[] bytes) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        File file = new FileHelper().getFile(fileName);
        Document document = XMLHelper.getDocument(file);
        AnalyseXMLNodes analyseXMLNodes = new AnalyseXMLNodes();
        analyseXMLNodes.analyseXMLElements(analyseXMLNodes.analyseRootElement(document));
        List<FrameUnit> frameUnits = analyseXMLNodes.analyseNodes();
        SensorDataAnalyse sensorDataAnalyse = new SensorDataAnalyse();
        frameUnits=sensorDataAnalyse.fillBytes(bytes,frameUnits);
        frameUnits=sensorDataAnalyse.dataAnalyse(frameUnits);
        return frameUnits;
    }
}
