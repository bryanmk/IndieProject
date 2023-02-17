package areas.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Areas{

	@JsonProperty("area")
	private String area;

	@JsonProperty("_links")
	private Links links;

	@JsonProperty("quests")
	private List<QuestsItem> quests;

	@JsonProperty("id")
	private int id;

	public void setArea(String area){
		this.area = area;
	}

	public String getArea(){
		return area;
	}

	public void setLinks(Links links){
		this.links = links;
	}

	public Links getLinks(){
		return links;
	}

	public void setQuests(List<QuestsItem> quests){
		this.quests = quests;
	}

	public List<QuestsItem> getQuests(){
		return quests;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"Areas{" + 
			"area = '" + area + '\'' + 
			",_links = '" + links + '\'' + 
			",quests = '" + quests + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}