
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
		for(int i=0; i<width; i++) {  //�����ڷ� �Է¹��� ������ ����Ʈ�� ��ŭ "-" ���
			System.out.print("-");
		}
		System.out.println("+");
	}
}
