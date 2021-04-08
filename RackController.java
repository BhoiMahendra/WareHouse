package warehouse;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class RackController {

	private boolean found = false;
	private StringBuffer path = new StringBuffer("Robot");
	// private StringBuffer shortPath= new StringBuffer("Robot");
	private int distance = 0;
	private String finalRack;
	boolean shortdistanceFlag = false;
	private int length = 0;

	Map<String, Map<String, Integer>> pathDistance = new TreeMap<>();

	RackDao rackDao = new RackDao();

	public Result find(String articleNames) {

		Map<String, Integer> subPathDistance = new HashMap<>();

		Result result = new Result();

		Set<Rack> racks = RackDao.getRacks();

		for (Rack rack : racks) {

			List<String> articles = rack.getArticleName();

			path.append("->");
			path.append(rack.getRack());

			if (!found) {

				if (articles.contains(articleNames)) {

					found = true;
					finalRack = rack.getRack();
					System.out.println("element found in rack" + finalRack);

				}

			}
		}

		if (found) {

			if (finalRack == "Rack1") {

				StringBuffer shortPath = new StringBuffer("Robot");
				distance = 1;
				shortPath.append("->");
				shortPath.append("Rack1");

				subPathDistance.put(shortPath.toString(), distance);
				pathDistance.put(articleNames, subPathDistance);

			} else {

				for (Rack rack : racks) {

					StringBuffer shortPath = new StringBuffer("Robot");

					Map<String, Integer> connectingNodes = rack.getConnectingNode();// getting all the connecting nodes

					Set<String> rackk = connectingNodes.keySet();// geting the list of racks

					shortPath.append("->"); // add the path
					shortPath.append(rack.getRack());

					// check the connecting node if it has the link to the destination node

					// else check the connecting nodes, if they contain the destination node

					if (rackk.contains(finalRack)) {

						for (String str2 : rackk) {

							if (str2 == finalRack) {

								distance = connectingNodes.get(str2);
								length += distance;
								shortPath.append("->");
								shortPath.append(str2);

								subPathDistance.put(shortPath.toString(), length + 1);
								pathDistance.put(articleNames, subPathDistance);
								shortPath.delete(0, shortPath.length());
							}

						}

					} else {

						for (String str : rackk) {

							if (str != "NO") {

								Rack rack3 = rackDao.getRackByName(str);

								Map<String, Integer> connectingNodes2 = rack3.getConnectingNode();

								Set<String> rackk3 = connectingNodes2.keySet();

								shortPath.append("->");
								shortPath.append(rack3.getRack());

								for (String str1 : rackk3) {

									if (str1 == finalRack) {
										distance = connectingNodes2.get(str1);
										length += distance;
										shortPath.append("->");
										shortPath.append(str);

										subPathDistance.put(shortPath.toString(), length + 1);
										pathDistance.put(articleNames, subPathDistance);
										shortPath.delete(0, shortPath.length());
									}

								}

							}
						}

					}

				}
			}

			for (String str : pathDistance.keySet()) {

				System.out.println("Values" + pathDistance.get(str));
			}

		} else {

			System.out.println("Articles Not Found");
		}

		return result;
	}

	public void findRack(Set<String> racks, String finalRack) {

		if (racks.contains(finalRack)) {
			shortdistanceFlag = true;

		}

	}

}
