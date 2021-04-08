package warehouse;

public class Result {
	
	private boolean found ;
	private String path;
	private Integer distance;
	
	public Result() {
		
	}
	
	public Result(boolean found, String path, Integer distance) {
		super();
		this.found = found;
		this.path = path;
		this.distance = distance;
	}
	
	public boolean isFound() {
		return found;
	}
	public void setFound(boolean found) {
		this.found = found;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Integer getDistance() {
		return distance;
	}
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	
	
	

}
