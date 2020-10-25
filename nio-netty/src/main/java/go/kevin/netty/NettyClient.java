package go.kevin.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.channel.socket.oio.OioSocketChannel;

/**
 * @author Tianrui Wang
 * @date 2020-09-03 16:36
 **/
public class NettyClient {
	public static void main(String[] args) throws InterruptedException {

		EventLoopGroup group = new NioEventLoopGroup();

		try{
			Bootstrap bootstrap = new Bootstrap();
			bootstrap
					.group(group)
					.channel(NioSocketChannel.class)
					.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						public void initChannel(SocketChannel socketChannel) throws Exception {
							ChannelPipeline channelPipeline = socketChannel.pipeline();
							channelPipeline.addLast( new NettyClientHandler() );
						}
					});

			ChannelFuture channelFuture = bootstrap
					.connect("127.0.0.1", 8080)
					.addListener( future -> {
						if (future.isSuccess()){
							System.out.println("connect server success");
						}else {
							System.out.println("connect server failed");
						}
					})
					.sync();
			channelFuture.channel().closeFuture().sync();

		}finally{
			group.shutdownGracefully();
		}

	}
}
