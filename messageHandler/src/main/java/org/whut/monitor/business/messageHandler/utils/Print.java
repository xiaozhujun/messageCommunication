package org.whut.monitor.business.messageHandler.utils;

/**
 * Created by 涵 on 2015/4/23.
 */
public class Print{
    public static void print(String name,String value){
        System.out.println(name+":"+value );
    }
    public void test(){
        System.out.println("test");
    }
    public String test1(String s){
        System.out.println(s);
        return "ok";
    }
}
