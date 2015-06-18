package org.whut.monitor.business.messageHandler.messageHandle;

import org.whut.monitor.business.messageHandler.entity.FrameUnit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/**
 * Created by 涵 on 2015/4/30.
 */
public class SensorDataAnalyse{
    public List<FrameUnit> dataAnalyse(List<FrameUnit> frameUnits) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Iterator<FrameUnit> iterator = frameUnits.iterator();
        while(iterator.hasNext()){
            FrameUnit frameUnit = iterator.next();
            Class clazz = Class.forName(frameUnit.getByteToDataClasspath());
            Object object =clazz.newInstance();;
            Method method = clazz.getMethod(frameUnit.getByteToDataMethodName(),byte[].class);
            String data = (String) method.invoke(object,frameUnit.getBytes());
            frameUnit.setData(data);
            System.out.println("ok1...."+data);
        }
        return frameUnits;
    }

    public List<FrameUnit> fillBytes(byte[] bytes,List<FrameUnit> frameUnits){
        int index = 0;
        Iterator<FrameUnit> iterator = frameUnits.iterator();
        while(iterator.hasNext()){
            FrameUnit frameUnit=iterator.next();
            int byteNum = frameUnit.getByteNumber();
            byte[] bytes1 = new byte[byteNum];
            System.arraycopy(bytes,index,bytes1,0,byteNum);
            frameUnit.setBytes(bytes1);
            index += byteNum;
        }
        return frameUnits;
    }
}
