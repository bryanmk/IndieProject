package quest.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Money{

	@JsonProperty("units")
	private Units units;

	@JsonProperty("value")
	private int value;

	public void setUnits(Units units){
		this.units = units;
	}

	public Units getUnits(){
		return units;
	}

	public void setValue(int value){
		this.value = value;
	}

	public int getValue(){
		return value;
	}

	@Override
 	public String toString(){
		return 
			"Money{" + 
			"units = '" + units + '\'' + 
			",value = '" + value + '\'' + 
			"}";
		}
}