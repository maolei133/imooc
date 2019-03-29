package com.maolei.muxin.netty;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

@Component
public class WSServer {

    private static class SingletionWSServer {
        static final WSServer instance = new WSServer();
    }

    public static WSServer getInstance() {
        return SingletionWSServer.instance;
    }

    private EventLoopGroup master;
    private EventLoopGroup slave;
    private ServerBootstrap server;
    private ChannelFuture future;

    public WSServer() {
        this.master = new NioEventLoopGroup();
        this.slave = new NioEventLoopGroup();
        this.server = new ServerBootstrap();
        this.server.group(master, slave).channel(NioServerSocketChannel.class)
                .childHandler(new WSServerInitializer());
    }

    public void start() {
        this.future = server.bind(8088);
        System.err.println("netty websocket server 启动完毕...");
    }

    public static void main(String[] args) throws Exception {
       System.out.println(RandomStringUtils.randomNumeric(8));
    }

}
