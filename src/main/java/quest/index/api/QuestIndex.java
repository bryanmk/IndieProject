package quest.index.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestIndex{

	@JsonProperty("types")
	private Types types;

	@JsonProperty("_links")
	private Links links;

	@JsonProperty("areas")
	private Areas areas;

	@JsonProperty("categories")
	private Categories categories;

	public void setTypes(Types types){
		this.types = types;
	}

	public Types getTypes(){
		return types;
	}

	public void setLinks(Links links){
		this.links = links;
	}

	public Links getLinks(){
		return links;
	}

	public void setAreas(Areas areas){
		this.areas = areas;
	}

	public Areas getAreas(){
		return areas;
	}

	public void setCategories(Categories categories){
		this.categories = categories;
	}

	public Categories getCategories(){
		return categories;
	}

	@Override
 	public String toString(){
		return 
			"QuestIndex{" + 
			"types = '" + types + '\'' + 
			",_links = '" + links + '\'' + 
			",areas = '" + areas + '\'' + 
			",categories = '" + categories + '\'' + 
			"}";
		}
}