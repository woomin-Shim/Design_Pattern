import java.util.Iterator;

public class ListVisitor extends Visitor{
	private String currentdir = "";  //현재 주목하고 있는 directory 
	
	//file을 방문할 때 호출 
	public void visit(File file) {
		System.out.println(currentdir + "/" + file);
	}
	
	//directory 방문할 때 호출 
	public void visit(Directory directory) {
		System.out.println(currentdir + "/" + directory);
		String savedir = currentdir;
		currentdir = currentdir + "/" + directory.getName();   //현재 Directory 경로로 수정
		Iterator it = directory.iterator();  //Directory Iterator 
		while(it.hasNext()) {
			Entry entry = (Entry)it.next();
			entry.accept(this);
		}
		
		currentdir = savedir;
	}
	
	
}
