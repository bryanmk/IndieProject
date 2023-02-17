package quest.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Rewards{

	@JsonProperty("reputations")
	private List<ReputationsItem> reputations;

	@JsonProperty("money")
	private Money money;

	@JsonProperty("experience")
	private int experience;

	public void setReputations(List<ReputationsItem> reputations){
		this.reputations = reputations;
	}

	public List<ReputationsItem> getReputations(){
		return reputations;
	}

	public void setMoney(Money money){
		this.money = money;
	}

	public Money getMoney(){
		return money;
	}

	public void setExperience(int experience){
		this.experience = experience;
	}

	public int getExperience(){
		return experience;
	}

	@Override
 	public String toString(){
		return 
			"Rewards{" + 
			"reputations = '" + reputations + '\'' + 
			",money = '" + money + '\'' + 
			",experience = '" + experience + '\'' + 
			"}";
		}
}