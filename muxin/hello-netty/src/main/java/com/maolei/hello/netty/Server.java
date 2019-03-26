package com.maolei.hello.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Server {
    
    public static void main(String[] args) throws Exception {
        EventLoopGroup master = new NioEventLoopGroup();
        EventLoopGroup slave = new NioEventLoopGroup();

        try {
            ServerBootstrap server = new ServerBootstrap();
            server.group(master, slave)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ServerInitializer());

            ChannelFuture future = server.bind(8088).sync();

            future.channel().closeFuture().sync();
        } finally {
            master.shutdownGracefully();
            slave.shutdownGracefully();
        }
    }
}
