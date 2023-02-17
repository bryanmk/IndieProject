package questie.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Faction{

	@JsonProperty("name")
	private String name;

	@JsonProperty("type")
	private String type;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
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
			"Faction{" + 
			"name = '" + name + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}