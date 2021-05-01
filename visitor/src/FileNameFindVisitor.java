import java.util.Iterator;
import java.util.ArrayList;

public class FileNameFindVisitor extends Visitor{
	private String name;
	private ArrayList arr = new ArrayList();  //���� ����
	public FileNameFindVisitor(String name) {
		this.name = name;
	}
	
	//name���� �� file(arr�� �����) ��� ���� Iterator return
	public Iterator getFoundFiles() {
		return arr.iterator();
	}
	
	//file �湮 �� �� 
	public void visit(File file) {
		if(file.getName().contains(name))  //�����ڷ� ���� name�� �����ϰ� �ִ��� ���� 
			arr.add(file);
	}
	
	//Directory �湮 �� ��
	public void visit(Directory dir) {
		Iterator it = dir.iterator();
		while(it.hasNext()) {
			Entry entry = (Entry)it.next();
			entry.accept(this);
		}
	}
	
}
