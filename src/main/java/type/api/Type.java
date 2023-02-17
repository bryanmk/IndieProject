package type.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Type{

	@JsonProperty("_links")
	private Links links;

	@JsonProperty("quests")
	private List<QuestsItem> quests;

	@JsonProperty("id")
	private int id;

	@JsonProperty("type")
	private String type;

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

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"Type{" + 
			"_links = '" + links + '\'' + 
			",quests = '" + quests + '\'' + 
			",id = '" + id + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}