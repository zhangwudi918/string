package text02;

public class SingletonPattern2 {
	// 懒汉

	private  SingletonPattern2() {
	}

	private static SingletonPattern2 sp2;

	public static SingletonPattern2 getobj() {
		if (sp2 == null) {
			synchronized (sp2) {
				if (sp2 == null) {
					sp2 = new SingletonPattern2();
				}
			}
		}

		return sp2;
	}
}
