//�Ϲ� text�� ����ؼ� ������ ����
public class TextBuilder extends Builder { //abstract class�� Builder�� ���
	private StringBuffer buffer = new StringBuffer(); //�ʵ� ���� ����
	public void makeTitle(String title) {  //Title of normal Text
		buffer.append("==============================\n");
		buffer.append("��" + title + "��\n");
		buffer.append("\n");
	}
	public void makeString(String str) {  //String of normal Text
		buffer.append("��" + str + "\n");
		buffer.append("\n");
	}
	public void makeItems(String[] items) {
		for(int i=0; i<items.length; i++) {
			buffer.append(" ��" + items[i] + "\n");
			buffer.append("\n");
		}
	}
	public void close() {
		buffer.append("==============================\n");
	}
	public String getResult() {
		return buffer.toString();  //�ϼ��� ���� String buffer return 
	}
}
