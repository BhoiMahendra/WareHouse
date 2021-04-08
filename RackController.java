package warehouse;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class RackController {

	private boolean found = false;
	private StringBuffer path= new StringBuffer("Robot");
	//private StringBuffer shortPath= new StringBuffer("Robot");
	private int distance = 0;
	private String finalRack;
	boolean shortdistanceFlag =false;
	private int length =0;
	
	Map<String, Map<String,Integer>> pathDistance = new TreeMap<>();
	
	RackDao rackDao = new RackDao();
	
	
	public Result find(String articleNames) {
	
		Map<String,Integer> subPathDistance =new HashMap<>();
		
		Result result =  new Result();
		
		Set<Rack> racks = RackDao.getRacks();
		
		for(Rack rack: racks) {
			
			 List<String> articles = rack.getArticleName();
			 
			 path.append("->");
			 path.append(rack.getRack());
			 
			 if(!found) {
				 
				if(articles.contains(articleNames)) {
					
					found = true;
					finalRack=rack.getRack();
					System.out.println("element found in rack"+finalRack);
					
				}
				
			 }
		}
		
		if(found) {
			
			if(finalRack == "Rack1") {
				
				StringBuffer shortPath = new StringBuffer("Robot");
				distance = 1;
				shortPath.append("->");
				shortPath.append("Rack1");
				
				subPathDistance.put(shortPath.toString(), distance);
				pathDistance.put(articleNames, subPathDistance);
				
			}else {

				for(Rack rack: racks) {
					
					StringBuffer shortPath = new StringBuffer("Robot");
					
					Map<String, Integer> connectingNodes = rack.getConnectingNode();
					
					Set<String> rackk = connectingNodes.keySet();
					
					
					shortPath.append("->");
					shortPath.append(rack.getRack());
					
					
						if(rackk.contains(finalRack)) {
							
							shortdistanceFlag=true;
							distance = connectingNodes.get(finalRack);
							
							length +=distance; 

							subPathDistance.put(shortPath.toString(), length+1);
							pathDistance.put(articleNames, subPathDistance);
							
							shortPath.delete(0, shortPath.length());
						}else {

							for(String str: rackk) {
							
								if(str !="NO") {

								Rack rack3 = rackDao.getRackByName(str);

								Map<String, Integer> connectingNodes2 =  rack3.getConnectingNode();
								
								Set<String> rackk3 = connectingNodes2.keySet();
								
								shortPath.append("->");
								shortPath.append(rack3.getRack());
								
								for(String str1: rackk3) {
									
									if(str1 == finalRack) {
										
											
									}
									
								}
								
								if(rackk3.contains(finalRack)) {
									
									shortdistanceFlag=true;
									distance = connectingNodes.get(finalRack);
									length +=distance; 
									
									shortPath.append("->");
									shortPath.append(rack3.getRack());
								
									subPathDistance.put(shortPath.toString(), length+1);
									pathDistance.put(articleNames, subPathDistance);
									shortPath.delete(0, shortPath.length());
								}
							}
							}
							
						}
					
				}
			}

			
			
			
			for(String str:pathDistance.keySet() ) {
				
				System.out.println("Values"+pathDistance.get(str));
			}
			
			
			
		}else {
			
			System.out.println("Articles Not Found");
		}
		
		
		return result;
	}
	
	
	public void findRack(Set<String> racks, String finalRack) {
		
		if(racks.contains(finalRack)) {
			shortdistanceFlag = true;
			
		}
	
	}
	
	
	
	
}
