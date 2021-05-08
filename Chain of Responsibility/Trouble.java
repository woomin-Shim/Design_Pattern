
public class Trouble {
	private int number;  //문제 번호
	public Trouble(int number) {
		this.number = number;
	}
	public int getNumber() {
		return number;
	}
	public String toString() {   //Trouble nymber를 나타내는 문자열 
		return "[Trouble " + number + "]";
	}
}
