package teste;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, Employee> map = new HashMap<>();

		Employee employee1 = new Employee(1, "Mher");
		map.put(employee1.getName(), employee1);
		Employee employee2 = new Employee(22, "Annie");
		map.put(employee2.getName(), employee2);
		Employee employee3 = new Employee(8, "John");
		map.put(employee3.getName(), employee3);
		Employee employee4 = new Employee(2, "George");
		map.put(employee4.getName(), employee4);
	
		TreeMap<String, Employee> sorted = new TreeMap<>(map);
		
		for (Entry<String, Employee> entry : sorted.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue().getName();

		    System.out.printf("%s : %s\n", key, value);
		}

		
	}

}
