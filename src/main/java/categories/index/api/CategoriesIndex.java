package categories.index.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CategoriesIndex{

	@JsonProperty("_links")
	private Links links;

	@JsonProperty("categories")
	private List<CategoriesItem> categories;

	public void setLinks(Links links){
		this.links = links;
	}

	public Links getLinks(){
		return links;
	}

	public void setCategories(List<CategoriesItem> categories){
		this.categories = categories;
	}

	public List<CategoriesItem> getCategories(){
		return categories;
	}

	@Override
 	public String toString(){
		return 
			"CategoriesIndex{" + 
			"_links = '" + links + '\'' + 
			",categories = '" + categories + '\'' + 
			"}";
		}
}