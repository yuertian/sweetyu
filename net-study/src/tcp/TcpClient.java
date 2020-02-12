package tcp;

import java.io.*;
import java.net.Socket;

public class TcpClient {
    private static final String HOST = "localHost";

    private static final int PORT = 9999;
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(HOST, PORT);

        InputStream is = socket.getInputStream();//获取到的是socket帮我们包装的是一个输入字节流
        //缓冲字符流BufferReader/BufferWriter
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

        OutputStream os = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
//        bw.write("hello!我来了\n");
//        bw.flush();
        PrintWriter pw = new PrintWriter(os, true);
        pw.println("hello，我来了");
    }
}
