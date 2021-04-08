package warehouse;
import java.util.*;


public class RackDao {
	
	private static LinkedHashSet<Rack>  racks = new LinkedHashSet<>();
	
	static{
		List<String> articleName = new ArrayList<>();
		
		articleName.add("Article1");
		articleName.add("Article2");
		
		Map<String, Integer> connectingNode = new HashMap<>();
		
		connectingNode.put("Rack2", 4);
		connectingNode.put("Rack4", 6);
		connectingNode.put("Rack5", 8);
		
		
		Rack  rack1=  new Rack("Rack1",articleName,connectingNode);
		racks.add(rack1);
		
		List<String> articleName1 = new ArrayList<>();
		
		articleName1.add("Article3");
		articleName1.add("Article4");
		
		Map<String, Integer> connectingNode1 = new HashMap<>();

		connectingNode1.put("Rack5", 5);
		
		
		Rack  rack2=  new Rack("Rack2",articleName1,connectingNode1);
		racks.add(rack2);
		
		
		List<String> articleName2 = new ArrayList<>();
		
		articleName2.add("Article5");
		articleName2.add("Article6");
		
		Map<String, Integer> connectingNode2 = new HashMap<>();

		connectingNode2.put("NO", 0);
		
		
		Rack  rack3=  new Rack("Rack3",articleName2,connectingNode2);
		racks.add(rack3);
		
		
		List<String> articleName3 = new ArrayList<>();
		
		articleName3.add("Article7");
		articleName3.add("Article8");
		
		Map<String, Integer> connectingNode3 = new HashMap<>();

		connectingNode3.put("Rack3", 10);
		
		
		Rack  rack4=  new Rack("Rack4",articleName3,connectingNode3);
		racks.add(rack4);
		
		List<String> articleName4 = new ArrayList<>();
		
		articleName4.add("Article9");
		articleName4.add("Article10");
		
		Map<String, Integer> connectingNode4 = new HashMap<>();

		connectingNode4.put("NO", 0);
		
		
		Rack  rack5=  new Rack("Rack5",articleName4,connectingNode4);
		racks.add(rack5);
		
		
	}
	
	public void addRacks(Rack rack) {
	
		racks.add(rack);
	}

	public static  LinkedHashSet<Rack> getRacks() {
		return racks;
	}

	public static void setRacks(LinkedHashSet<Rack> racks) {
		RackDao.racks = racks;
	}
	
	public Rack getRackByName(String rack) {
		
		System.out.println("dao rack"+rack);
		for(Rack rack1: racks) {
			if(rack1.getRack().equalsIgnoreCase(rack)) {
				return rack1;
			}
		}
		return null;
	}
}


