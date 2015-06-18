package CAMCMTest;

import java.util.Date;

/**
 * Created by 涵 on 2015/5/9
 */
public class DataGenerate {
    public static int len = 24;
    public static long sensorNum;
    public static int dataType;
    public static long time;
    public static int data;

    public static void  generateData(){
        long l = Math.round(Math.random()*10);
        sensorNum = 10000+l;
        dataType=1;
        time = new Date().getTime();
        data = (int) Math.round(Math.random()*600);
    }

    public static void main(String[] args){
        generateData();
        System.out.println(data);
    }

}
