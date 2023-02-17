package type.index.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TypeIndex{

	@JsonProperty("types")
	private List<TypesItem> types;

	@JsonProperty("_links")
	private Links links;

	public void setTypes(List<TypesItem> types){
		this.types = types;
	}

	public List<TypesItem> getTypes(){
		return types;
	}

	public void setLinks(Links links){
		this.links = links;
	}

	public Links getLinks(){
		return links;
	}

	@Override
 	public String toString(){
		return 
			"TypeIndex{" + 
			"types = '" + types + '\'' + 
			",_links = '" + links + '\'' + 
			"}";
		}
}