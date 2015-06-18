package org.whut.monitor.business.messageHandler.utils;

import org.apache.commons.lang3.StringUtils;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.io.File;

/**
 * Created by 涵 on 2015/4/20.
 */
public class FileHelper {
    public String getResourcePath() {
        String path = this.getClass().getClassLoader().getResource("").getPath();
        path = StringUtils.replace(path, "%20", " ");
        return StringUtils.removeStart(path, "/");
    }

    public File getFile(String fileName){
        String classNamePath=getResourcePath();
        String filePath = classNamePath+"messages/"+fileName;
        File file = new File(filePath);
        return file;
    }
}
