package go.kevin;

import io.grpc.ManagedChannel;
import io.grpc.netty.NettyChannelBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Tianrui Wang
 * @date 2020-08-19 11:00
 **/
@SpringBootApplication
public class GrpcClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrpcClientApplication.class, args);



	}

}
