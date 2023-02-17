package type.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestsItem{

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private int id;

	@JsonProperty("key")
	private Key key;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setKey(Key key){
		this.key = key;
	}

	public Key getKey(){
		return key;
	}

	@Override
 	public String toString(){
		return 
			"QuestsItem{" + 
			"name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",key = '" + key + '\'' + 
			"}";
		}
}