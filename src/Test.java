import java.util.ArrayList;
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayList<Vlist> graph=new ArrayList<Vlist>();
		ArrayList<float[]> weight=new ArrayList<>();
		
		Vnode vn1=new Vnode();
		vn1.setValue(0);
		Vnode vn2=new Vnode();
		vn2.setValue(1);
		Vnode vn3=new Vnode();
		vn3.setValue(2);
		Vnode vn4=new Vnode();
		vn4.setValue(3);
		Vlist v1=new Vlist(vn1);
		Vlist v2=new Vlist(vn2);
		Vlist v3=new Vlist(vn3);
		Vlist v4=new Vlist(vn4);
		v1.add(1);
		v1.add(2);
		v1.add(3);
		v2.add(0);
		v2.add(2);
		v2.add(3);
		v3.add(0);
		v3.add(1);
		v4.add(0);
		v4.add(1);
		graph.add(v1);
		graph.add(v2);
		graph.add(v3);
		graph.add(v4);
		
		float[] w1={0,1,2,3};
		float[] w2={1,0,3,4};
		float[] w3={2,3,0,5};
		float[] w4={3,4,5,0};
		weight.add(w1);
		weight.add(w2);
		weight.add(w3);
		weight.add(w4);
		MstKruskal mst=new MstKruskal(graph,weight);
		ArrayList<Vlist> tree=mst.getMST();
		for(Vlist edge:tree){
			System.out.println(edge.print());
		}
	}

}
