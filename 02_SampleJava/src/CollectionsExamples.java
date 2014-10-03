import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CollectionsExamples {
	private static final int SIZE = 5;
	
	public static void main(String[] args){
		array();
		list();
		map();
		
	}
	
	private static void array(){
		final int a[] = new int[SIZE];
		for(int i = 0; i < SIZE; i++){
			a[i] = i+1;
			System.out.println(a[i]);
		}
	}
	
	private static void list(){
		final List<String> list = new ArrayList<String>();
		list.add("First Element");
		
		for(String next : list){
			System.out.println(next);
		}
	}
	
	public static void map(){
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("Bulgaria", 7);
		m.put("Germany", 80);
		
		System.out.println(m.get("Bulgaria"));
		
		
	}
}
