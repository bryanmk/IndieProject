package quest.index.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Categories{

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
			"Categories{" + 
			"href = '" + href + '\'' + 
			"}";
		}
}