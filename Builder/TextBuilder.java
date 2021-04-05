//일반 text를 사용해서 문서를 구축
public class TextBuilder extends Builder { //abstract class인 Builder를 상속
	private StringBuffer buffer = new StringBuffer(); //필드 문서 구축
	public void makeTitle(String title) {  //Title of normal Text
		buffer.append("==============================\n");
		buffer.append("♥" + title + "♥\n");
		buffer.append("\n");
	}
	public void makeString(String str) {  //String of normal Text
		buffer.append("★" + str + "\n");
		buffer.append("\n");
	}
	public void makeItems(String[] items) {
		for(int i=0; i<items.length; i++) {
			buffer.append(" ＊" + items[i] + "\n");
			buffer.append("\n");
		}
	}
	public void close() {
		buffer.append("==============================\n");
	}
	public String getResult() {
		return buffer.toString();  //완성된 문서 String buffer return 
	}
}
