package questie.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Quest Javabean.
 */
@Entity(name = "Quest")
@Table(name = "Quest")
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int quest_id;
    @Column(name= "quest_name")
    private String quest_name;
    @Column(name= "quest_level_requirement")
    private int quest_level_requirement;
    @Column(name= "quest_xp")
    private int quest_xp;
    @Column(name= "quest_area")
    private String quest_area;
    @Column(name= "quest_reward")
    private String quest_reward;

    /**
     * Instantiates a new Quest.
     */
    public Quest() {
    }

    /**
     * Instantiates a new Quest.
     *
     * @param questName             the quest name
     * @param questLevelRequirement the quest level requirement
     * @param questXP               the quest xp
     * @param questArea             the quest area
     * @param questReward           the quest reward
     */
    public Quest(String questName, int questLevelRequirement, int questXP, String questArea, String questReward) {
        this.quest_name = questName;
        this.quest_level_requirement = questLevelRequirement;
        this.quest_xp = questXP;
        this.quest_area = questArea;
        this.quest_reward = questReward;
    }

    /**
     * Instantiates a new Quest.
     *
     * @param questId               the quest id
     * @param questName             the quest name
     * @param questLevelRequirement the quest level requirement
     * @param questXP               the quest xp
     * @param questArea             the quest area
     * @param questReward           the quest reward
     */
    public Quest(int questId, String questName, int questLevelRequirement, int questXP, String questArea, String questReward) {
        this.quest_id = questId;
        this.quest_name = questName;
        this.quest_level_requirement = questLevelRequirement;
        this.quest_xp = questXP;
        this.quest_area = questArea;
        this.quest_reward = questReward;
    }

    /**
     * Gets quest id.
     *
     * @return the quest id
     */
    public int getQuestId() {
        return quest_id;
    }

    /**
     * Sets quest id.
     *
     * @param questId the quest id
     */
    public void setQuestId(int questId) {
        this.quest_id = questId;
    }

    /**
     * Gets quest name.
     *
     * @return the quest name
     */
    public String getQuestName() {
        return quest_name;
    }

    /**
     * Sets quest name.
     *
     * @param questName the quest name
     */
    public void setQuestName(String questName) {
        this.quest_name = questName;
    }

    /**
     * Gets quest level requirement.
     *
     * @return the quest level requirement
     */
    public int getQuestLevelRequirement() {
        return quest_level_requirement;
    }

    /**
     * Sets quest level requirement.
     *
     * @param questLevelRequirement the quest level requirement
     */
    public void setQuestLevelRequirement(int questLevelRequirement) {
        this.quest_level_requirement = questLevelRequirement;
    }

    /**
     * Gets quest area.
     *
     * @return the quest area
     */
    public String getQuestArea() {
        return quest_area;
    }

    /**
     * Sets quest area.
     *
     * @param questArea the quest area
     */
    public void setQuestArea(String questArea) {
        this.quest_area = questArea;
    }

    /**
     * Gets quest xp.
     *
     * @return the quest xp
     */
    public int getQuestXP() {
        return quest_xp;
    }

    /**
     * Sets quest xp.
     *
     * @param questXP the quest xp
     */
    public void setQuestXP(int questXP) {
        this.quest_xp = questXP;
    }

    /**
     * Gets quest reward.
     *
     * @return the quest reward
     */
    public String getQuestReward() {
        return quest_reward;
    }

    /**
     * Sets quest reward.
     *
     * @param questReward the quest reward
     */
    public void setQuestReward(String questReward) {
        this.quest_reward = questReward;
    }

    /**
     * Creates a string representation of a quest object.
     * @return string representation of a quest object.
     */
    @Override
    public String toString() {
        return "Quest{" +
                "questId=" + quest_id +
                ", questName='" + quest_name + '\'' +
                ", questLevelRequirement=" + quest_level_requirement +
                ", questArea='" + quest_area + '\'' +
                ", questXP=" + quest_xp +
                ", questReward='" + quest_reward + '\'' +
                '}';
    }
}
