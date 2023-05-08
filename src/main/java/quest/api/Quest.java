package quest.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quest{

	@JsonProperty("area")
	private Area area;

	@JsonProperty("requirements")
	private Requirements requirements;

	@JsonProperty("_links")
	private Links links;

	@JsonProperty("description")
	private String description;

	@Id
	@JsonProperty("id")
	private int id;

	@JsonProperty("title")
	private String title;

	@JsonProperty("rewards")
	private Rewards rewards;

	public void setArea(Area area){
		this.area = area;
	}

	public Area getArea(){
		return area;
	}

	public void setRequirements(Requirements requirements){
		this.requirements = requirements;
	}

	public Requirements getRequirements(){
		return requirements;
	}

	public void setLinks(Links links){
		this.links = links;
	}

	public Links getLinks(){
		return links;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setRewards(Rewards rewards){
		this.rewards = rewards;
	}

	public Rewards getRewards(){
		return rewards;
	}

	@Override
 	public String toString(){
		return
			"Quest{" +
			"area = '" + area + '\'' +
			",requirements = '" + requirements + '\'' +
			",_links = '" + links + '\'' +
			",description = '" + description + '\'' +
			",id = '" + id + '\'' +
			",title = '" + title + '\'' +
			",rewards = '" + rewards + '\'' +
			"}";
		}
}