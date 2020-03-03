package http;

import java.io.IOException;
import java.net.Socket;

public class HTTPTask implements Runnable {

    private Request request;
//    private Socket socket;

    private Response response;

    public HTTPTask(Socket socket) {
//        socket = this.socket;
        try {
            //通过客户端发送报文的输入流（请求数据）创建HTTP请求对象
            request = Request.buildRequest(socket.getInputStream());
            response = Response.buildResponse(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("客户端连接的IO流出错", e);
        }
    }

    @Override
    public void run() {

    }
}