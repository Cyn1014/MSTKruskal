
public class Vnode extends SetNode{

	private Vnode next;
	private int value;
	
	public Vnode getNext() {
		return next;
	}
	public void setNext(Vnode next) {
		this.next = next;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
}
