package CAMCMTest;

import org.whut.monitor.business.messageHandler.entity.FrameUnit;

import javax.print.DocFlavor;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 涵 on 2015/5/11.
 */
public class DataStructure {
    public static String structure(List<FrameUnit> frameUnits){
        StringBuffer stringBuffer = new StringBuffer();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(frameUnits.size()==4){
            stringBuffer.append("{sensorNum:\"");
            String sensorNum = frameUnits.get(0).getData();
            stringBuffer.append("21000000000"+sensorNum+"\"");
            stringBuffer.append(",dataType:\"");
            int dataTypeIndex= Integer.parseInt(frameUnits.get(1).getData());
            String dataType = String.valueOf(DataTypeEnum.values()[dataTypeIndex]);
            stringBuffer.append(dataType+"\"");
            long time = Long.parseLong(frameUnits.get(2).getData());
            Date date = new Date(time);
            String t = format.format(date);
            stringBuffer.append(",time:\"");
            stringBuffer.append(t+"\"");
            String data = frameUnits.get(3).getData();
            stringBuffer.append(",data:\"");
            stringBuffer.append(data+"\"}");
        }
        else{
            stringBuffer.append("");
            System.out.println("error structure!");
        }
        String json=stringBuffer.toString();
        return json;
    }
}
