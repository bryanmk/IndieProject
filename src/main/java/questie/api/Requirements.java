package questie.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Requirements{

	@JsonProperty("min_character_level")
	private int minCharacterLevel;

	@JsonProperty("max_character_level")
	private int maxCharacterLevel;

	@JsonProperty("faction")
	private Faction faction;

	public void setMinCharacterLevel(int minCharacterLevel){
		this.minCharacterLevel = minCharacterLevel;
	}

	public int getMinCharacterLevel(){
		return minCharacterLevel;
	}

	public void setMaxCharacterLevel(int maxCharacterLevel){
		this.maxCharacterLevel = maxCharacterLevel;
	}

	public int getMaxCharacterLevel(){
		return maxCharacterLevel;
	}

	public void setFaction(Faction faction){
		this.faction = faction;
	}

	public Faction getFaction(){
		return faction;
	}

	@Override
 	public String toString(){
		return 
			"Requirements{" + 
			"min_character_level = '" + minCharacterLevel + '\'' + 
			",max_character_level = '" + maxCharacterLevel + '\'' + 
			",faction = '" + faction + '\'' + 
			"}";
		}
}