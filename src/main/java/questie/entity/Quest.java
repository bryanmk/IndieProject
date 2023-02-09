package questie.entity;

/**
 * Quest Javabean.
 */
public class Quest {

    private int questId;
    private String questName;
    private int questLevelRequirement;
    private String questArea;
    private int questXP;
    private String questReward;

    /**
     * Instantiates a new Quest.
     */
    public Quest() {
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
}
