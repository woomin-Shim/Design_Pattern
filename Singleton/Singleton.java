
public class Singleton {
	private static Singleton singleton = new Singleton(); 
	private Singleton() { //private -> �ܺο��� �������� ȣ�� ���� 
		System.out.println("�ν��Ͻ��� �����߽��ϴ�.");
	}
	public static Singleton getInstance() {
		return singleton;
	}
}
