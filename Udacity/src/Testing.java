

import java.util.ArrayList;
import java.util.List;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> integers = new ArrayList<Integer>() {
			{add(3);add(5);add(4);add(1);add(7);add(9);add(3);add(5);add(8);}
		};
		
		int[] v1 = {1,3,5,4,1,7,9,3,5,8};
		int[] v2 = new int[v1.length];
		
		for (int i=0; i<v1.length; i++) {
			int min = 0;
			for (int j=0; j<v1.length; j++) if (v1[j] < v1[min]) min=j;
			System.out.print(min + " ");
			System.out.println();
			v2[i] = v1[min];
			v1[min] = Integer.MAX_VALUE;
		}
		for (int i=0; i<v2.length; i++) System.out.print(v2[i] + " ");
	}

}
