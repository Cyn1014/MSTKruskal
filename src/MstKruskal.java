import java.util.ArrayList;
public class MstKruskal {

	private ArrayList<Vlist> graph;
	private ArrayList<float[]> weight;
	private ArrayList<Vlist> mst;
	
	public MstKruskal(ArrayList<Vlist> graph,ArrayList<float[]> weight){
		this.graph=graph;
		this.weight=weight;
		mst=new ArrayList<Vlist>();
		for(Vlist vl:graph){
			Vlist v=new Vlist(vl.getParent());
			mst.add(v);
		}
	}
	
	public ArrayList<Vlist> getMST(){
		for(int i=0;i<graph.size();i++){
			SetOperation.makeset(graph.get(i).getParent());
		}
		ArrayList<Edge> edges=sort(weight);
		for(Edge e:edges){
			if(!SetOperation.findset(e.getStart()).equals(SetOperation.findset(e.getEnd()))){
				mst.get(e.getStart().getValue()).add(e.getEnd().getValue());
				SetOperation.union(e.getStart(), e.getEnd());
			}
		}
		return mst;
	}
	
	private ArrayList<Edge> sort(ArrayList<float[]> weight){
	     ArrayList<Edge> edges=new ArrayList<Edge>();
	     for(int j=0;j<weight.size();j++){
	    	 for(int i=0;i<weight.get(j).length;i++){
	    		 Edge e=new Edge();
	    		 e.setStart(graph.get(j).getParent());
	    		 e.setEnd(graph.get(i).getParent());
	    		 e.setWeigh(weight.get(j)[i]*graph.get(j).find(i));
	    		 if(e.getWeigh()==0)
	    			 e.setWeigh(Float.MAX_VALUE);
	    		 edges.add(e);
	    	 }
	     }
	     for(int i=0;i<edges.size()-1;i++){
	    	 for(int j=i+1;j<edges.size();j++){
	    		 Edge e1=edges.get(i);
	    		 Edge e2=edges.get(j);
	    		 if(e1.getWeigh()>e2.getWeigh()){
	    			edges.set(i, e2);
	    			edges.set(j, e1);
	    		 }
	    	 }
	     }
	     
	     for(Edge e:edges){
	    	 System.out.println(e.getStart().getValue()+","+e.getEnd().getValue()+":"+e.getWeigh());
	     }
	     return edges;		
	}
}
