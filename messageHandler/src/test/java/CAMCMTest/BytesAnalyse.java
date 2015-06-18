package CAMCMTest;

import org.whut.monitor.business.messageHandler.entity.FrameUnit;
import org.whut.monitor.business.messageHandler.analyse.Analyse;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by 涵 on 2015/5/11.
 */
public class BytesAnalyse {
    public static List<FrameUnit> analyseBytes(byte[] bytes) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Analyse analyse = new Analyse();
        List<FrameUnit> frameUnits = analyse.analyse("monitor-1.1-1.xml",bytes);
        return frameUnits;
    }
}
