import java.io.File;
import java.io.PrintWriter;
import java.util.*;


public class ReadText {
	public static void main(String[] args) throws Exception {
		File textFile = new File("part-r-00000");
		Scanner scanner = new Scanner(textFile);
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		while (scanner.hasNextLine()) {
			String[] s = scanner.nextLine().split("\t");
			map.put(s[0], Integer.valueOf(s[1]));
		}
		scanner.close();
		ValueComparator bvc = new ValueComparator(map);
        TreeMap<String, Integer> sorted_map = new TreeMap(bvc);
        sorted_map.putAll(map);
        
        PrintWriter out = new PrintWriter("count.txt");
        for (Map.Entry<String, Integer> entry : sorted_map.entrySet()) {
		out.println(entry.getKey() + ", " + entry.getValue());
        }
		out.close();
		System.out.println("Done");
	}
	
	static class ValueComparator implements Comparator {
	    Map base;

	    public ValueComparator(Map base) {
	        this.base = base;
	    }

	    // Note: this comparator imposes orderings that are inconsistent with
	    // equals.
	    public int compare(Object a, Object b) {
	        if ((Integer)base.get((String)a) >= (Integer)base.get((String)b)) {
	            return -1;
	        } else {
	            return 1;
	        } // returning 0 would merge keys
	    }


	}
	
}




