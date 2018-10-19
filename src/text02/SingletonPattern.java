package text02;

public class SingletonPattern {
	// 饿汉
	private SingletonPattern() {
	}

	private static SingletonPattern sp = new SingletonPattern();

	public static  SingletonPattern getobj() {
		return sp;
	}

}
