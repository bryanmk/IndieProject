package categories.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Categories{

	@JsonProperty("_links")
	private Links links;

	@JsonProperty("quests")
	private List<QuestsItem> quests;

	@JsonProperty("id")
	private int id;

	@JsonProperty("category")
	private String category;

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

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	@Override
 	public String toString(){
		return 
			"Categories{" + 
			"_links = '" + links + '\'' + 
			",quests = '" + quests + '\'' + 
			",id = '" + id + '\'' + 
			",category = '" + category + '\'' + 
			"}";
		}
}