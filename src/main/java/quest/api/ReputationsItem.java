package quest.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReputationsItem{

	@JsonProperty("reward")
	private Reward reward;

	@JsonProperty("value")
	private int value;

	public void setReward(Reward reward){
		this.reward = reward;
	}

	public Reward getReward(){
		return reward;
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
			"ReputationsItem{" + 
			"reward = '" + reward + '\'' + 
			",value = '" + value + '\'' + 
			"}";
		}
}