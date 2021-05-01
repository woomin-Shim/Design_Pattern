import java.util.Iterator;

public class ListVisitor extends Visitor{
	private String currentdir = "";  //���� �ָ��ϰ� �ִ� directory 
	
	//file�� �湮�� �� ȣ�� 
	public void visit(File file) {
		System.out.println(currentdir + "/" + file);
	}
	
	//directory �湮�� �� ȣ�� 
	public void visit(Directory directory) {
		System.out.println(currentdir + "/" + directory);
		String savedir = currentdir;
		currentdir = currentdir + "/" + directory.getName();   //���� Directory ��η� ����
		Iterator it = directory.iterator();  //Directory Iterator 
		while(it.hasNext()) {
			Entry entry = (Entry)it.next();
			entry.accept(this);
		}
		
		currentdir = savedir;
	}
	
	
}
