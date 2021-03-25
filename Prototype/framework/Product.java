package framework;

public interface Product extends Cloneable {  //To use Clone method
	public abstract void use(String s);
	public abstract Product createClone();
}
