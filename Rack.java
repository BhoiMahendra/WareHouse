package warehouse;

import java.util.List;
import java.util.Map;

public class Rack {

	private String rack;
	private List<String> articleName;
	private Map<String, Integer> connectingNode;
	
	
	
	public Rack(String rack, List<String> articleName, Map<String, Integer> connectingNode) {
		super();
		this.rack=rack;
		this.articleName = articleName;
		this.connectingNode = connectingNode;
	}
	
	public List<String> getArticleName() {
		return articleName;
	}
	public void setArticleName(List<String> articleName) {
		this.articleName = articleName;
	}
	public Map<String, Integer> getConnectingNode() {
		return connectingNode;
	}
	public void setConnectingNode(Map<String, Integer> connectingNode) {
		this.connectingNode = connectingNode;
	}

	public String getRack() {
		return rack;
	}

	public void setRack(String rack) {
		this.rack = rack;
	}
	
	
	
}
