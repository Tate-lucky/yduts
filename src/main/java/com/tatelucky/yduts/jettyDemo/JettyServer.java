package com.tatelucky.yduts.jettyDemo;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.util.thread.ExecutorThreadPool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author tangsheng
 * @since 2020-03-06
 */
public class JettyServer {

    public JettyServer() {
    }


    public void start() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {


            }
        });

        thread.setDaemon(true);
        thread.start();
    }

//    public void destory() {
//        if(null != server){
//            try {
//                server.stop();
//                server.destroy();
//            } catch (Throwable e) {
//                System.out.println("销毁失败!");
//                e.printStackTrace();
//            }
//        }
//
//        if(thread.isAlive()){
//            thread.interrupt();
//        }
//        System.out.println("destory");
//    }

    public static class HelloHandler extends AbstractHandler {
        @Override
        public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
                throws IOException, ServletException {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);

            PrintWriter out = response.getWriter();

            out.println("<h1>Hello world</hello>");
            baseRequest.setHandled(true);
        }
    }


    public static void main(String[] args) {
        //1 创建server   线程池是一个LinkedBlockingQueue
        Server server = new Server(new ExecutorThreadPool());

        //服务端连接器,负责去监听你的端口，去接收客户端的请求
        ServerConnector serverConnector = new ServerConnector(server);
        //设置host
        serverConnector.setHost("127.0.0.1");
        //设置端口
        serverConnector.setPort(10086);

        //2 装载connection
        server.setConnectors(new Connector[]{serverConnector});

        //3 加载handles，handle是用来处理请求的
        //  如果没有的话，就等于只是开启了一个端口，拿到的结果都是404罢了
        HandlerCollection hc = new HandlerCollection();
        hc.setHandlers(new Handler[]{new HelloHandler()});
        server.setHandler(hc);

        //4 启动 可能会有异常
        try {
            server.start();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("start正常");

        //5 加入服务器 可能会有异常
        try {
            //阻塞的作用
            server.join();
        } catch (Throwable e) {
            e.printStackTrace();
        }


//        try {
//            server.stop();
//        } catch (Throwable e) {
//            System.out.println("stop 失败");
//            e.printStackTrace();
//        }
//
//        server.destroy();
    }
}
