
public class Singleton {
	private static Singleton singleton = new Singleton(); 
	private Singleton() { //private -> 외부에서 생성자의 호출 금지 
		System.out.println("인스턴스를 생성했습니다.");
	}
	public static Singleton getInstance() {
		return singleton;
	}
}
