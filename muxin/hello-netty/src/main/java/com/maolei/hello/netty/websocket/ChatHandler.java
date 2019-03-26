package com.maolei.hello.netty.websocket;

import java.time.LocalDateTime;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * <h3>处理消息的Handler</h3>
 * <p>
 * TextWebSocketFrame: 在netty中，是用于为websocket专门处理文本的对象，frame是消息的载体
 * </p>
 * 
 * @author maolei
 *
 */
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

	// 用于记录和管理所有客户端的Channe
	private static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
		// 获取客户端传输过来的消息
		String content = msg.text();
		System.out.println(ctx.channel().remoteAddress() + ": " + content);

		for (Channel channel : group) {
			channel.writeAndFlush(new TextWebSocketFrame("[服务器收到消息: " + content + "] " + LocalDateTime.now()));
		}
	}

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		group.add(ctx.channel());
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		group.remove(ctx.channel());
	}

}
