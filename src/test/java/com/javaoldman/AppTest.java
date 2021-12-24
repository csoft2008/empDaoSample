package com.javaoldman;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    public void test() throws UnsupportedEncodingException {
        String hello = "Hello 中国";
        byte[] b;

        System.out.println(hello);

        System.out.println("US-ASCII");
        b = hello.getBytes("US-ASCII");
        toHex(b);
        System.out.println("ISO-8859-1");
        b = hello.getBytes("ISO-8859-1");
        toHex(b);
        System.out.println("GB2312");
        b = hello.getBytes("GB2312");
        toHex(b);
        System.out.println("GBK");
        b = hello.getBytes("GBK");
        toHex(b);
        System.out.println("GB18030");
        b = hello.getBytes("GB18030");
        toHex(b);
        System.out.println("Big5");
        b = hello.getBytes("Big5");
        toHex(b);
        System.out.println("UTF-8");
        b = hello.getBytes("UTF-8");
        toHex(b);
        System.out.println("UTF-16BE");
        b = hello.getBytes("UTF-16BE");
        toHex(b);
        System.out.println("UTF-16LE");
        b = hello.getBytes("UTF-16LE");
        toHex(b);
        System.out.println("UTF-16");
        b = hello.getBytes("UTF-16");
        toHex(b);
        System.out.println("UTF-32");
        b = hello.getBytes("UTF-32");
        toHex(b);

    }
    public void toHex(byte[] b){
        for(byte b1 :b){
            System.out.printf("%x",b1);
            System.out.print(" ");
        }
        System.out.println("");
    }
}
