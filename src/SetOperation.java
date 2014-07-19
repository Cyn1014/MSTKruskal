
public class SetOperation {

	public static void makeset(SetNode x){
		x.setParent(x);
		x.setRank(0);
	}
	
	public static SetNode findset(SetNode x){
		if(!x.getParent().equals(x)){
			findset(x.getParent());
		}
		return x.getParent();
	}
	
	public static void link(SetNode x,SetNode y){
		if(x.getRank()>y.getRank())
			y.setParent(x);
		else {
			x.setParent(y);
			if(x.getRank()==y.getRank())
				y.setRank(y.getRank()+1);
		}
		
	}
	
	public static void union(SetNode x,SetNode y){
		link(findset(x),findset(y));
	}
}
