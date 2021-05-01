
public class Main {
	public static void main(String[] args) { 
		try {
			System.out.println("Making root entries...");
			Directory rootdir = new Directory("root");
			Directory bindir = new Directory("bin");
			Directory tmpdir = new Directory("tmp");
			Directory usrdir = new Directory("usr");
			
			//Add to Directory(rootdir) ArrayList
			rootdir.add(bindir);
			rootdir.add(tmpdir);
			rootdir.add(usrdir);
			
			bindir.add(new File("vi",1000));
			bindir.add(new File("latex", 20000));
			
			//directory 내용을 표시하기 위해, ListVisiton instance 사용 
			rootdir.accept(new ListVisitor());
			
			System.out.println("");
			System.out.println("Making user entries...");
			Directory Kim = new Directory("Kim");
			Directory Lee = new Directory("Lee");
			Directory Park = new Directory("Park");
			usrdir.add(Kim);
			usrdir.add(Lee);
			usrdir.add(Park);
			Kim.add(new File("diary.html",100));
			Kim.add(new File("composite.java",200));
			Lee.add(new File("memo.tex", 300));
			Park.add(new File("game.doc", 400));
			Park.add(new File("juck.mail", 500));
			rootdir.accept(new ListVisitor());
		}catch(FileTreatmentException e) {
			e.printStackTrace();
		}
	}
}
