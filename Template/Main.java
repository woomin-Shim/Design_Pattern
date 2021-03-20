
public class Main {
	public static void main(String[] args) {
		AbstractDisplay d1 = new charDisplay('H');
		AbstractDisplay d2 = new stringDisplay("Hello, world.");
		AbstractDisplay d3 = new stringDisplay("안녕하세요.");
		
		d1.display();  //d1, d2, d3는 모두 상속 받은 하위 클래스의 instance 
		d2.display();  //상속받은 display method를 문제없이 호출 가능 
		d3.display();
	}
}
