package quest.index.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Areas{

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
			"Areas{" + 
			"href = '" + href + '\'' + 
			"}";
		}
}