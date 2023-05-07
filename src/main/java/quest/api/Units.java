package quest.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Units{

	@JsonProperty("gold")
	private int gold;

	@JsonProperty("copper")
	private int copper;

	@JsonProperty("silver")
	private int silver;

	public void setGold(int gold){
		this.gold = gold;
	}

	public int getGold(){
		return gold;
	}

	public void setCopper(int copper){
		this.copper = copper;
	}

	public int getCopper(){
		return copper;
	}

	public void setSilver(int silver){
		this.silver = silver;
	}

	public int getSilver(){
		return silver;
	}

	@Override
 	public String toString(){
		return 
			"Units{" + 
			"gold = '" + gold + '\'' + 
			",copper = '" + copper + '\'' + 
			",silver = '" + silver + '\'' + 
			"}";
		}
}