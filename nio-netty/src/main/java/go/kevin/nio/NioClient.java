package go.kevin.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * @author Tianrui Wang
 * @date 2020-09-03 15:15
 **/
public class NioClient {
	public static void main(String[] args) throws IOException {

		//Selector selector = Selector.open();

		SocketChannel socketChannel = SocketChannel.open();

		socketChannel.configureBlocking(false);

		socketChannel.connect(new InetSocketAddress("127.0.0.1", 8080));

		//socketChannel.register(selector, SelectionKey.OP_CONNECT);

		socketChannel.finishConnect();

		String request = "hello nio!";
		byte[] requestBytes = request.getBytes();
		ByteBuffer requestBuffer = ByteBuffer.allocate(requestBytes.length);
		requestBuffer.put(requestBytes);
		requestBuffer.flip();
		socketChannel.write(requestBuffer);

		ByteBuffer responseBuffer = ByteBuffer.allocate(1024);
		int length = 0;
		while ( (length = socketChannel.read(responseBuffer)) > 0 ){
			responseBuffer.flip();
			System.out.println( "服务器返回数据: " + new String( responseBuffer.array(), 0, length ) );
			responseBuffer.clear();
		}

		socketChannel.close();

	}
}
