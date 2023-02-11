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
    private int questId;
    @Column(name= "quest_name")
    private String questName;
    @Column(name= "quest_level_requirement")
    private int questLevelRequirement;
    @Column(name= "quest_area")
    private String questArea;
    @Column(name= "quest_xp")
    private int questXP;
    @Column(name= "quest_reward")
    private String questReward;

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
     * @param questArea             the quest area
     * @param questXP               the quest xp
     * @param questReward           the quest reward
     */
    public Quest(String questName, int questLevelRequirement, String questArea, int questXP, String questReward) {
        this.questName = questName;
        this.questLevelRequirement = questLevelRequirement;
        this.questArea = questArea;
        this.questXP = questXP;
        this.questReward = questReward;
    }

    /**
     * Instantiates a new Quest.
     *
     * @param questId               the quest id
     * @param questName             the quest name
     * @param questLevelRequirement the quest level requirement
     * @param questArea             the quest area
     * @param questXP               the quest xp
     * @param questReward           the quest reward
     */
    public Quest(int questId, String questName, int questLevelRequirement, String questArea, int questXP, String questReward) {
        this.questId = questId;
        this.questName = questName;
        this.questLevelRequirement = questLevelRequirement;
        this.questArea = questArea;
        this.questXP = questXP;
        this.questReward = questReward;
    }

    /**
     * Gets quest id.
     *
     * @return the quest id
     */
    public int getQuestId() {
        return questId;
    }

    /**
     * Sets quest id.
     *
     * @param questId the quest id
     */
    public void setQuestId(int questId) {
        this.questId = questId;
    }

    /**
     * Gets quest name.
     *
     * @return the quest name
     */
    public String getQuestName() {
        return questName;
    }

    /**
     * Sets quest name.
     *
     * @param questName the quest name
     */
    public void setQuestName(String questName) {
        this.questName = questName;
    }

    /**
     * Gets quest level requirement.
     *
     * @return the quest level requirement
     */
    public int getQuestLevelRequirement() {
        return questLevelRequirement;
    }

    /**
     * Sets quest level requirement.
     *
     * @param questLevelRequirement the quest level requirement
     */
    public void setQuestLevelRequirement(int questLevelRequirement) {
        this.questLevelRequirement = questLevelRequirement;
    }

    /**
     * Gets quest area.
     *
     * @return the quest area
     */
    public String getQuestArea() {
        return questArea;
    }

    /**
     * Sets quest area.
     *
     * @param questArea the quest area
     */
    public void setQuestArea(String questArea) {
        this.questArea = questArea;
    }

    /**
     * Gets quest xp.
     *
     * @return the quest xp
     */
    public int getQuestXP() {
        return questXP;
    }

    /**
     * Sets quest xp.
     *
     * @param questXP the quest xp
     */
    public void setQuestXP(int questXP) {
        this.questXP = questXP;
    }

    /**
     * Gets quest reward.
     *
     * @return the quest reward
     */
    public String getQuestReward() {
        return questReward;
    }

    /**
     * Sets quest reward.
     *
     * @param questReward the quest reward
     */
    public void setQuestReward(String questReward) {
        this.questReward = questReward;
    }

    /**
     * Creates a string representation of a quest object.
     * @return string representation of a quest object.
     */
    @Override
    public String toString() {
        return "Quest{" +
                "questId=" + questId +
                ", questName='" + questName + '\'' +
                ", questLevelRequirement=" + questLevelRequirement +
                ", questArea='" + questArea + '\'' +
                ", questXP=" + questXP +
                ", questReward='" + questReward + '\'' +
                '}';
    }
}
