package go.kevin.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Tianrui Wang
 * @date 2020-09-03 14:36
 **/
public class NioServer {
	public static void main(String[] args) throws IOException {

		Selector selector = Selector.open();

		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

		serverSocketChannel.bind( new InetSocketAddress(8080));

		serverSocketChannel.configureBlocking(false);

		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

		while (true){
			selector.select(1000);
			Set<SelectionKey> selectionKeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = selectionKeys.iterator();

			while (iterator.hasNext()){
				SelectionKey selectionKey = iterator.next();

				if(selectionKey.isReadable()){

					SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
					ByteBuffer buffer = ByteBuffer.allocate(2048);
					int length = 0;

					while ( (length = socketChannel.read(buffer)) > 0 ){
						buffer.flip();
						System.out.println( new String( buffer.array(), 0, length ) );
						buffer.clear();
					}

					String response = "received, handle done";
					byte[] responseBytes = response.getBytes();
					ByteBuffer responseBuffer = ByteBuffer.allocate(responseBytes.length);
					responseBuffer.put(responseBytes);
					responseBuffer.flip();
					socketChannel.write( responseBuffer );

					socketChannel.close();

				}else if (selectionKey.isWritable()){

				}else if (selectionKey.isConnectable()){

				}else if (selectionKey.isAcceptable()){

					ServerSocketChannel ssc = (ServerSocketChannel) selectionKey.channel();
					SocketChannel socketChannel = ssc.accept();
					System.out.println( "accept new connection: " + socketChannel.getRemoteAddress() );
					socketChannel.configureBlocking(false);
					socketChannel.register(selector, SelectionKey.OP_READ);
					
				}

				iterator.remove();
			}

		}

	}
}
