//방문자를 나타내는 클래스
public abstract class Visitor {
	//overload
	public abstract void visit(File file);
	public abstract void visit(Directory directory);
}
