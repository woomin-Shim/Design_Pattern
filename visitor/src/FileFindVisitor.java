import java.util.Iterator;
import java.util.ArrayList;

public class FileFindVisitor extends Visitor{
	private String extension;  //Ȯ����
	private ArrayList ext = new ArrayList(); //Ȯ���� ���� 
	public FileFindVisitor(String extension) {
		this.extension = extension;
	}
	
	//Ȯ���� ������ ��� ���� Iterator return
	public  Iterator getFoundFiles() {
		return ext.iterator();
	}
	
	public void visit(File file) {
		if(file.getName().endsWith(extension))
			ext.add(file);
	}
	public void visit(Directory dir) {
		Iterator it = dir.iterator();
		while(it.hasNext()) {
			Entry entry = (Entry)it.next();
			entry.accept(this);
		}
	}
}
