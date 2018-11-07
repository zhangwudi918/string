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

public class ClientInServer implements Runnable {
	Socket socket;

	ClientInServer(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {

			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			InputStreamReader isr = new InputStreamReader(in, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");
			BufferedWriter bw = new BufferedWriter(osw);
			PrintWriter pw = new PrintWriter(bw, true);

			String message;
			while ((message = br.readLine()) != null) {
				/* 通过BufferedReader按行读取客户端输入的信息，写入SaveMap类中的表格当中 */

				String str = SaveMap.savemessage(message);
				/* 根据SaveMap中方法判断Map中是否存在这次客户端输入的信息，并将结果返回给客户端 */
				pw.println(str);

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
