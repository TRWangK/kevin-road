package go.kevin.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * .proto文件编译成Java文件
 * @author Tianrui Wang
 * @date 2020-08-19 09:43
 **/
public class ProtoBufToJavaUtil {

	/** 项目路径  */
	private static String url = System.getProperty("user.dir");

	/** 模块路径 */
	private static final String MODULE_NAME = "grpc-service";

	/** proto文件路径 */
	private static String proto_path = "\\src\\main\\resources\\proto";

	/** java文件输出路径 */
	private static String java_path = "\\src\\main\\java\\";

	/**
	 * 如果只是想要编译部分（指定）proto文件
	 * 子包下必须带路径，eg:\\user\\user.proto or \\user.proto
	 */
	private static final List<String> PROTO_FILES = new ArrayList<>();

	/**
	 * false: 编译部分（指定）proto文件，配合PROTO_FILES
	 * true: 编译 PROTO_PATH 路径下的所有.proto文件
	 */
	private static boolean isAllFiles = true;

	private static Runtime runtime = Runtime.getRuntime();

	public static void main(String[] args) {

		//指定部分proto文件
//		isAllFiles = false;
//		PROTO_FILES.add("\\a.proto");
//		PROTO_FILES.add("\\b.proto");

		transform();

	}

	private static void transform() {

		/*
		 * 这里要注意：
		 * 如果使用是idea里，有可能当前只是模块（module）而不是项目，获取到url可能只是项目路径
		 */
		if (!url.endsWith(MODULE_NAME)) {
			url = url + "\\" + MODULE_NAME;
		}
		proto_path = url + proto_path;
		java_path = url + java_path;
		System.out.println("JAVA_PATH:" + java_path);
		System.out.println("PROTO_PATH:" + proto_path);
		System.out.println("============================File out put===================================");

		String command = "";
		try {
			// 路径下全部
			if (isAllFiles) {
				File protoFile = new File(proto_path);

				if (protoFile.exists()) {
					File[] files = protoFile.listFiles();
					for (File file : files) {
						command = getCommand(file.getName());
						if (!command.isEmpty()) {
							outPutJava(command);
						}

					}
				}
			} else {
				// 指定.proto文件
				if (PROTO_FILES.size() > 0) {
					for (String protoFile : PROTO_FILES) {
						File file = new File(proto_path + protoFile);
						if (!file.exists()) {
							System.err.println("files is not exist : " + proto_path);
							continue;
						}
						command = getCommand(file.getName());
						if (!command.isEmpty()) {
							outPutJava(command);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

		/**
		 * 输出java文件
		 * @param command
		 * @throws IOException
		 */
		private static void outPutJava(String command) throws IOException {

			System.out.println(">>>:" + command);
			// 执行
			Process process = runtime.exec(command);
			// 打印结果
			InputStreamReader isr = new InputStreamReader(process.getErrorStream());
			BufferedReader br = new BufferedReader(isr);
			boolean isSuccess = true;
			String line = null;
			while ((line = br.readLine()) != null) {
				System.err.println("ERROR:" + line);
				isSuccess = false;
			}
			if (isSuccess) {
				System.out.println(">>>:success");
			}
			br.close();
			isr.close();
		}

		/**
		 * 获取CMD执行命令
		 * @param fileName
		 * @return
		 */
		private static String getCommand(String fileName) {
			StringBuffer command = new StringBuffer();
			command.append("D:\\protobuf\\bin\\protoc.exe")
					.append(" --java_out=").append(java_path)
					.append(" --proto_path=").append(proto_path)
					.append(" ").append(fileName);
			return command.toString();
		}


}
