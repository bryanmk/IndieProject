package categories.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Key{

	@JsonProperty("href")
	private String href;

	public void setHref(String href){
		this.href = href;
	}

	public String getHref(){
		return href;
	}

	@Override
 	public String toString(){
		return 
			"Key{" + 
			"href = '" + href + '\'' + 
			"}";
		}
}