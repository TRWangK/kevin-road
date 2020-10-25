package go.kevin.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author Tianrui Wang
 * @date 2020-09-03 16:07
 **/
public class NettyServer {
	public static void main(String[] args) throws InterruptedException {

		// 负责管理TCP连接
		EventLoopGroup bossGroup = new NioEventLoopGroup(1);

		// 负责每一个连接的具体工作
		EventLoopGroup workerGroup = new NioEventLoopGroup();

		try{
			ServerBootstrap serverBootstrap = new ServerBootstrap();
			serverBootstrap
					.group( bossGroup, workerGroup )
					.channel(NioServerSocketChannel.class)
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						public void initChannel(SocketChannel socketChannel) throws Exception {
							ChannelPipeline channelPipeline = socketChannel.pipeline();
							channelPipeline.addLast( new NettyServerHandler() );
						}
					});

			ChannelFuture channelFuture = serverBootstrap.bind(8080).sync();
			channelFuture.channel().closeFuture().sync();
		}finally{
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
}
