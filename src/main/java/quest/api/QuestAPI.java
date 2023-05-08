package quest.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity (name = "QuestAPI")
@Table (name = "quest_api")
public class QuestAPI {

    @Id
    private int id;

    @Column
    private String title;

    @Column (name = "level_requirement")
    private int levelRequirement;

    @Column
    private String area;

    @Column
    private int experience;

    @Column
    private int gold;

    @Column
    private int silver;

    @Column
    private int copper;

    public QuestAPI() {
    }

    public QuestAPI(int id, String title, int levelRequirement, String area, int experience, int gold, int silver, int copper) {
        this.id = id;
        this.title = title;
        this.levelRequirement = levelRequirement;
        this.area = area;
        this.experience = experience;
        this.gold = gold;
        this.silver = silver;
        this.copper = copper;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLevelRequirement() {
        return levelRequirement;
    }

    public void setLevelRequirement(int levelRequirement) {
        this.levelRequirement = levelRequirement;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(int silver) {
        this.silver = silver;
    }

    public int getCopper() {
        return copper;
    }

    public void setCopper(int copper) {
        this.copper = copper;
    }

    @Override
    public String toString() {
        return "QuestAPI{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", levelRequirement=" + levelRequirement +
                ", area='" + area + '\'' +
                ", experience=" + experience +
                ", gold=" + gold +
                ", silver=" + silver +
                ", copper=" + copper +
                '}';
    }
}
