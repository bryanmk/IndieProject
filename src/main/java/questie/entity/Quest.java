package questie.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

/**
 * Quest Javabean.
 */
@Entity(name = "Quest")
@Table(name = "Quest")
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name= "quest_name")
    private String questName;
    @Column(name= "quest_level_requirement")
    private int questLevelRequirement;
    @Column(name= "quest_xp")
    private int questXP;
    @Column(name= "quest_area")
    private String questArea;
    @Column(name= "quest_reward")
    private String questReward;

//    @OneToMany(mappedBy = "quest", fetch = FetchType.EAGER)
//    private Set<FavoriteQuest> favorites = new HashSet<>();

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
        this.questName = questName;
        this.questLevelRequirement = questLevelRequirement;
        this.questXP = questXP;
        this.questArea = questArea;
        this.questReward = questReward;
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
        this.id = questId;
        this.questName = questName;
        this.questLevelRequirement = questLevelRequirement;
        this.questXP = questXP;
        this.questArea = questArea;
        this.questReward = questReward;
    }

    /**
     * Gets quest id.
     *
     * @return the quest id
     */
    public int getQuestId() {
        return id;
    }

    /**
     * Sets quest id.
     *
     * @param questId the quest id
     */
    public void setQuestId(int questId) {
        this.id = questId;
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

//    /**
//     * Gets favorites.
//     *
//     * @return the favorites
//     */
//    public Set<FavoriteQuest> getFavorites() {
//        return favorites;
//    }
//
//    /**
//     * Sets favorites.
//     *
//     * @param favorites the favorites
//     */
//    public void setFavorites(Set<FavoriteQuest> favorites) {
//        this.favorites = favorites;
//    }

    @Override
    public String toString() {
        return "Quest{" +
                "questId=" + id +
                ", questName='" + questName + '\'' +
                ", questLevelRequirement=" + questLevelRequirement +
                ", questArea='" + questArea + '\'' +
                ", questXP=" + questXP +
                ", questReward='" + questReward + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quest quest = (Quest) o;
        return id == quest.id && questLevelRequirement == quest.questLevelRequirement && questXP == quest.questXP && Objects.equals(questName, quest.questName) && Objects.equals(questArea, quest.questArea) && Objects.equals(questReward, quest.questReward);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, questName, questLevelRequirement, questXP, questArea, questReward);
    }
}
