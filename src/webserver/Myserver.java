package webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Myserver {
	ServerSocket serversocker;

	Myserver() {
		try {

			serversocker = new ServerSocket(9918);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			while (true) {
				System.out.println("等待客户端连接");
				/* 创建一个线程处理客户端连接 */
				Socket socket = serversocker.accept();
				ClientInServer client = new ClientInServer(socket);
				Thread t = new Thread(client);
				t.start();
				System.out.println("有一个客户端连接了");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Myserver ms = new Myserver();
		ms.run();

	}

}
