
public class Main {
	public static void main(String[] args) {
		AbstractDisplay d1 = new charDisplay('H');
		AbstractDisplay d2 = new stringDisplay("Hello, world.");
		AbstractDisplay d3 = new stringDisplay("�ȳ��ϼ���.");
		
		d1.display();  //d1, d2, d3�� ��� ��� ���� ���� Ŭ������ instance 
		d2.display();  //��ӹ��� display method�� �������� ȣ�� ���� 
		d3.display();
	}
}
