package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    private static final int PORT = 9999;

    public static void main(String[] args) throws IOException {
        //启动TCP服务器
        ServerSocket serverSocket = new ServerSocket(PORT);

        //循环获取新的客户端连接
        while (true) {
            //阻塞，等待新的客户端连接
            Socket socket = serverSocket.accept();

            //处理这个客户连接的业务，这个业务可能会发生阻塞
            //先不考虑阻塞的实现
            InputStream is = socket.getInputStream();//获取到的是socket帮我们包装的是一个输入字节流
            //缓冲字符流BufferReader/BufferWriter
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            OutputStream os = socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

            //1.先接收客户端传过来的数据，并打印
            //2.响应给客户端一个数据，我已经接收到了***消息
            String line;
            //阻塞等待客户端
            while ((line = br.readLine()) != null) {//如果line没有更新，就继续阻塞等待
                System.out.println("服务端接收到数据：" + line);
                //write操作是指将数据写入缓冲区
                bw.write("我已经接收到了" + line + "消息");
                //bw.write("..");
                //需要刷新一下缓冲区,这是才会将数据发送到对端
                bw.flush();
            }
        }
    }
}
//1.TCP是面向字节流的，可以获取到Socket对象中的输入输出字节流，
// 而且可以在一个连接中不断地发送/接收数据
//
//2.