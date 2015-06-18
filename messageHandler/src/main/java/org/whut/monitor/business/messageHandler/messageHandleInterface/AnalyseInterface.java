package org.whut.monitor.business.messageHandler.messageHandleInterface;

import org.whut.monitor.business.messageHandler.entity.FrameUnit;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by 涵 on 2015/5/1.
 */
public interface AnalyseInterface {
    public List<FrameUnit> analyse(String fileName,byte[] bytes) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
}
