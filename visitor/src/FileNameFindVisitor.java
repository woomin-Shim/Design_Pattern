import java.util.Iterator;
import java.util.ArrayList;

public class FileNameFindVisitor extends Visitor{
	private String name;
	private ArrayList arr = new ArrayList();  //파일 집합
	public FileNameFindVisitor(String name) {
		this.name = name;
	}
	
	//name으로 된 file(arr에 저장된) 얻기 위한 Iterator return
	public Iterator getFoundFiles() {
		return arr.iterator();
	}
	
	//file 방문 할 때 
	public void visit(File file) {
		if(file.getName().contains(name))  //생성자로 받은 name을 포함하고 있는지 여부 
			arr.add(file);
	}
	
	//Directory 방문 할 때
	public void visit(Directory dir) {
		Iterator it = dir.iterator();
		while(it.hasNext()) {
			Entry entry = (Entry)it.next();
			entry.accept(this);
		}
	}
	
}
