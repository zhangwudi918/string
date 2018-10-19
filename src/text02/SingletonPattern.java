package text02;

public class SingletonPattern {
	// 饿汉
	private SingletonPattern() {
	}

	private SingletonPattern sp = new SingletonPattern();

	public SingletonPattern getobj() {
		return sp;
	}

}
