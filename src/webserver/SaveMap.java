package webserver;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SaveMap {
	public static Map<String, String> lexicon = new HashMap<String, String>();
	private static char[] table = "0123456789abcdefghijklnmopqrstuvwxyzABCDEFGHIJKLNMOPQRSTUVWXYZ".toCharArray();

	public static synchronized String savemessage(String message) {
		System.out.println("开始查找表格");
		// 遍历集合，判断键值对中value的值和这次客户端输入的信息是否相同
		Set<Entry<String, String>> set = lexicon.entrySet();
		for (Entry<String, String> e : set) {
			if (e.getValue().equals(message)) {

				return "该词已存在，序号为：" + e.getKey();
				// 若存在，程序到此结束
			}
		}
		// 若不存在，根据集合内键值对数量生成key值，然后存入集合
		int len = lexicon.size();
		StringBuilder sb = new StringBuilder();
		while (len / 62 >= 1) {
			sb.append(table[len % 62]);
			len = len / 62;

		}
		String key = sb.append(table[len % 62]).reverse().toString();
		lexicon.put(key, message);
		return "提交成功! 序号为：" + key;

	}

}
