import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class Countries {

	public static void main(String[] args) {
		mapHomework();
	}
	
	private static void mapHomework() {
		final Map<String, Integer> m = new HashMap<String, Integer>();
		
		m.put("Bulgaria", 7);
		m.put("Germany", 80);
		m.put("China", 1367);
		m.put("USA", 319);
		m.put("Sri Lanka", 20);
		m.put("Burkina Faso", 17);
		m.put("Netherlands", 16);
		m.put("Mali", 15);
		m.put("Zimbabwe", 13);
		m.put("Greece", 11);
		m.put("Austria", 9);
		m.put("Israel", 8);
		m.put("Honk Kong", 7);
		m.put("Moldova", 4);
		m.put("Timor-Leste", 1);
		m.put("Malta", 1);

		for (Entry<String, Integer> next : m.entrySet()) {
			int next_pop = next.getValue();
			if(next_pop > 10)
				System.out.println("The population of " +next.getKey() + " is " + next_pop + " million");
		}
	}

}
