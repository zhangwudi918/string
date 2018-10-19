package text02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FileFinder {
	private Map<String, Integer> map = new HashMap<String, Integer>();
	private FileInputStream in;
	private final String author="Author:";
	private final String fileAddress="list-Develop/log.txt";
	private final int authorLength=7;
	public void start() {
		
		try {
			 in = new FileInputStream(fileAddress);
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			String line;

			while ((line = br.readLine()) != null) {

				if (line.startsWith(author)) {

					line = line.substring(authorLength);

					if (map.containsKey(line)) {
						Integer i = map.get(line) + 1;
						map.put(line, i);

					} else {
						map.put(line, 1);
					}

				}

			}

		} catch (IOException e) {

			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public static void main(String[] args) {
		FileFinder ff = new FileFinder();
		ff.start();
		System.out.println(ff.map.size());
	}

}
