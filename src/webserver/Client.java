package webserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	Socket socket;

	Client() {
		try {
			socket = new Socket("localhost", 9918);
			System.out.println("已连接。。。。。。。");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		// 创建一个线程来读取客户端反馈的信息
		ClientInput client = new ClientInput();
		Thread t = new Thread(client);
		t.start();

		try {
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");
			BufferedWriter bw = new BufferedWriter(osw);
			PrintWriter pw = new PrintWriter(bw, true);
			// 循环读取Scanner输入的字符串并通过流传给服务端 可通过判断Scanner输入的字符串等于某字符串来关闭socket，代码里没加
			while (true) {
				System.out.println("请输入：");
				String str = sc.nextLine();
				pw.println(str);

				System.out.println("客户端写出完毕");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private class ClientInput implements Runnable {
		// 读取服务端的反馈信息
		public void run() {
			try {
				InputStream in = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(in, "utf-8");
				BufferedReader br = new BufferedReader(isr);
				String message;

				while ((message = br.readLine()) != null) {
					System.out.println("服务端：" + message);

				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		Client c = new Client();
		c.run();
	}

}
