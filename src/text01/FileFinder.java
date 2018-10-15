package text01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileFinder {
	public void start() {
		List<String> list = new ArrayList<String>();
		List<Integer> listnum = new ArrayList<Integer>();
		int fileNum=0;
		int authorNum=0;
		String str;
		String name = "Author:";
		FileInputStream in;
		try {
			in = new FileInputStream("./list-Develop/log.txt");
			InputStreamReader isr = new InputStreamReader(in,"utf-8");
			BufferedReader br = new BufferedReader(isr);
			while ((str = br.readLine()) != null) {
				if (str.contains(name)) {
					str = str.substring(name.length());
					fileNum++;
					if (!list.contains(str)) {
						list.add(str);
						authorNum++;
						listnum.add(1);

					} else {
						int i = list.indexOf(str);
						listnum.set(i, listnum.get(i) + 1);
					}

				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i) + "上传了" + listnum.get(i) + "次");
		}
		System.out.println("作者有"+authorNum+"人，文件有"+fileNum);
	}

	public static void main(String[] args) {
		FileFinder ff=new FileFinder();
		ff.start();
	}

}
