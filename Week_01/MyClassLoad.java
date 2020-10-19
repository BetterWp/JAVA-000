package com.central.esso.web.rpc;

import org.apache.commons.io.IOUtils;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/**
 * @Description: MyClassLoad
 * @Date: 2020/10/17 16:39
 **/
public class MyClassLoad extends ClassLoader{

    String path = "D:\\Hello.xlass";

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = decode(path);
        return defineClass(name,bytes,0,bytes.length);
    }

    public byte[] decode(String url){
        InputStream in = null;
        try {
            in = new FileInputStream(url);
            byte[] bytes = IOUtils.toByteArray(in);
            for (int i=0;i<bytes.length;i++){
                bytes[i] = (byte) (255 - bytes[i]);
            }
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            MyClassLoad myClassLoad = new MyClassLoad();
            Class<?> cl = myClassLoad.findClass("Hello");
            Object obj = cl.newInstance();
            Method method = cl.getMethod("hello");
            method.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
