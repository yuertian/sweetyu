package http;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HTTPServer {

    private static final int PORT = 80;

    private static final ExecutorService POOL = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(PORT);

        while(true) {
            //阻塞等待获取到新的客户端的连接
            Socket socket = server.accept();
            POOL.execute(new HTTPTask(socket));
        }
    }
}
