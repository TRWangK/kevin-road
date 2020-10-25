package go.kevin.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

/**
 * @author Tianrui Wang
 * @date 2020-09-03 16:23
 **/
@ChannelHandler.Sharable
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		try{
			ByteBuf message = (ByteBuf) msg;
			System.out.println("Server - received message from client: " + message.toString(CharsetUtil.UTF_8));
			ctx.writeAndFlush(Unpooled.copiedBuffer("received and handle done!", CharsetUtil.UTF_8));
		}finally{
			ReferenceCountUtil.release(msg);
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
