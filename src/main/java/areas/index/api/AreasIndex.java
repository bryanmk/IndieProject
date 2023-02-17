package areas.index.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AreasIndex{

	@JsonProperty("_links")
	private Links links;

	@JsonProperty("areas")
	private List<AreasItem> areas;

	public void setLinks(Links links){
		this.links = links;
	}

	public Links getLinks(){
		return links;
	}

	public void setAreas(List<AreasItem> areas){
		this.areas = areas;
	}

	public List<AreasItem> getAreas(){
		return areas;
	}

	@Override
 	public String toString(){
		return 
			"AreasIndex{" + 
			"_links = '" + links + '\'' + 
			",areas = '" + areas + '\'' + 
			"}";
		}
}