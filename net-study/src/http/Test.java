package http;

import java.io.InputStream;

public class Test {
    public static void main(String[] args) {
        // 现在的写法是把编译的源文件夹作为相对路径，这是不对的
//        File f = new File("../../webapp/login.html");
        // 应该以编译输出文件夹作为相对路径,不推荐new File()这种做法
//        File f = new File("../login.html");
        // class.getResourceAsStream()是以具体的这个类编译出来的class文件路径作为相对路径的标准
        // class的做法不推荐使用
        InputStream is2 = Test.class.getResourceAsStream("../login.html");
        System.out.println(is2);
        // 推荐使用ClassLoader.getResourceAsStream()作为资源文件输出流读取操作
        InputStream is = Test.class.getClassLoader().getResourceAsStream("login.html");
        System.out.println(is);
    }
}
