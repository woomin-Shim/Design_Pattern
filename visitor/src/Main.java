import java.util.Iterator;

public class Main {
	public static void main(String[] args) { 
		try {
			Directory rootdir = new Directory("root");
			Directory bindir = new Directory("bin");
			Directory tmpdir = new Directory("tmp");
			Directory usrdir = new Directory("usr");
			
			rootdir.add(bindir);
			rootdir.add(tmpdir);
			rootdir.add(usrdir);
			
			bindir.add(new File("vi",10000));
			bindir.add(new File("latex", 20000));
			
			Directory Kim = new Directory("Kim");
			Directory Lee = new Directory("Lee");
			Directory Park = new Directory("Park");
			usrdir.add(Kim);
			usrdir.add(Lee);
			usrdir.add(Park);
			Kim.add(new File("diary.html",100));
			Kim.add(new File("composite.java",200));
			Kim.add(new File("hyejaKim.txt", 700));
			Lee.add(new File("memo.tex", 300));
			Lee.add(new File("hyejaKim.txt", 700));
			Park.add(new File("game.doc", 400));
			Park.add(new File("juck.mail", 500));
			Park.add(new File("hyejaKim.txt", 700));
			 	
			FileNameFindVisitor fnfv = new FileNameFindVisitor("hyeja");
			rootdir.accept(fnfv);  //ListVisitor instance를 사용하지 않고 FileNameFindVisitor를 사용
			
			System.out.println("hyeja files are");
			Iterator it = fnfv.getFoundFiles();
			while(it.hasNext()) {
				File file = (File)it.next();
				System.out.println(file.toString());
			}
		}catch(FileTreatmentException e) {
			e.printStackTrace();
		}
	}
}
