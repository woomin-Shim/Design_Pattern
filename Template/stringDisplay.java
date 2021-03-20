
public class stringDisplay extends AbstractDisplay {
	private String string;
	private int width;
	public stringDisplay(String string) {
		this.string = string;
		this.width = string.getBytes().length;
	}
	public void open() {
		printLine();
	}
	public void print() {
		System.out.println("|" + string + "|");
	}
	public void close() {
		printLine();
	}
	public void printLine() {
		System.out.print("+");
		for(int i=0; i<width; i++) {  //생성자로 입력받은 문자의 바이트열 만큼 "-" 출력
			System.out.print("-");
		}
		System.out.println("+");
	}
}
