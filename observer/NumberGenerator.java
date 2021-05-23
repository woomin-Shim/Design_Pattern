import java.util.ArrayList;
import java.util.Iterator;

public abstract class NumberGenerator {
	private ArrayList observers = new ArrayList();  //save observer 
	public void addObserver(Observer observer) {  //add observer
		observers.add(observer);
	}
	public void deleteObserver(Observer observer) {//delete observer
		observers.remove(observer);
	}
	public void notifyObservers() {  //notify changes to observer 
		Iterator it = observers.iterator();
		while(it.hasNext()) {
			Observer o = (Observer)it.next();
			o.update(this);
		}
	}
	public abstract int getNumber();   //get number
	public abstract void execute();    //make number 
	
}
