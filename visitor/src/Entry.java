import java.util.Iterator;

public abstract class Entry implements Element {
	public abstract String getName();
	public abstract int getSize();
	
	//add�� Iterator method�� Directory class������ ��ȿ�ϹǷ� ������ ó�� 
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
