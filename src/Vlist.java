
public class Vlist {
	
	private Vnode parent;
	private Vnode head;
	
	public Vlist(Vnode p){
		head=new Vnode();
		parent=p;
		head.setNext(null);
		
	}
	
	public void add(int value){
		Vnode x=head.getNext();
		Vnode v=new Vnode();
		v.setValue(value);
		if(x!=null){
			v.setNext(x);
			head.setNext(v);
		}else head.setNext(v);
		
	}
	
	public void delete(){
		Vnode x=head.getNext();
		if(x!=null){
			head.setNext(x.getNext());
		}
	}
	
	public int find(int v){
		int n=0;
		Vnode c=head.getNext();
		while(c!=null && !(c.getValue()==v))
			c=c.getNext();
		if(c!=null)
		if(c.getValue()==v)
			n=1;
		return n;
	}

	public Vnode getParent() {
		return parent;
	}

	public void setParent(Vnode parent) {
		this.parent = parent;
	}

	public Vnode getHead() {
		return head;
	}
	
	public String print(){
		return print(head.getNext());
		
	}
	
	public String print(Vnode v){
		String edges="";
		if(v!=null){
			edges=edges+" ("+parent.getValue()+","+v.getValue()+")"+print(v.getNext());
		}
		return edges;
	}

}
