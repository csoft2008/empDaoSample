import java.io.UnsupportedEncodingException;

public class Test {
    public void toHex(byte[] bytes){
        for(byte b :bytes){
            System.out.printf("%x",b);
            System.out.print(" ");
        }
        System.out.println("");
    }
    public void test() throws UnsupportedEncodingException {
        String hello = "Hello 中国";
        byte[] bytes;

        System.out.println(hello);

        System.out.println("US-ASCII");
        bytes = hello.getBytes("US-ASCII");
        toHex(bytes);
        System.out.println("ISO-8859-1");
        bytes = hello.getBytes("ISO-8859-1");
        toHex(bytes);
        System.out.println("GB2312");
        bytes = hello.getBytes("GB2312");
        toHex(bytes);
        System.out.println("GBK");
        bytes = hello.getBytes("GBK");
        toHex(bytes);
        System.out.println("GB18030");
        bytes = hello.getBytes("GB18030");
        toHex(bytes);
        System.out.println("Big5");
        bytes = hello.getBytes("Big5");
        toHex(bytes);
        System.out.println("UTF-8");
        bytes = hello.getBytes("UTF-8");
        toHex(bytes);
        System.out.println("UTF-16BE");
        bytes = hello.getBytes("UTF-16BE");
        toHex(bytes);
        System.out.println("UTF-16LE");
        bytes = hello.getBytes("UTF-16LE");
        toHex(bytes);
        System.out.println("UTF-16");
        bytes = hello.getBytes("UTF-16");
        toHex(bytes);
        System.out.println("UTF-32");
        bytes = hello.getBytes("UTF-32");
        toHex(bytes);
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        new Test().test();
    }
}
