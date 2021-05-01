import java.util.Iterator;

public abstract class Entry implements Element {
	public abstract String getName();
	public abstract int getSize();
	
	//add와 Iterator method는 Directory class에서만 유효하므로 에러로 처리 
	public Entry add(Entry entry) throws FileTreatmentException {
		throw new FileTreatmentException();
	}
	public Iterator iterator() throws FileTreatmentException {
		throw new FileTreatmentException();
	}
	public String toString() {
		return getName() + " (" + getSize() + ")";
	}
}
