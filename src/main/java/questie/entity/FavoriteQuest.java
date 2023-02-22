package questie.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Favorite quest.
 */
public class FavoriteQuest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Id
    @ManyToOne
    @JoinColumn(name = "favorite_id", referencedColumnName = "id")
    private Favorite favorite;

    @Id
    @ManyToOne
    @JoinColumn(name = "quest_id", referencedColumnName = "id")
    private Quest quest;

    /**
     * Instantiates a new Favorite quest.
     */
    public FavoriteQuest() {
    }

    /**
     * Instantiates a new Favorite quest.
     *
     * @param favorite the favorite
     * @param quest    the quest
     */
    public FavoriteQuest(Favorite favorite, Quest quest) {
        this.favorite = favorite;
        this.quest = quest;
    }

    /**
     * Instantiates a new Favorite quest.
     *
     * @param id       the id
     * @param favorite the favorite
     * @param quest    the quest
     */
    public FavoriteQuest(int id, Favorite favorite, Quest quest) {
        this.id = id;
        this.favorite = favorite;
        this.quest = quest;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets favorite.
     *
     * @return the favorite
     */
    public Favorite getFavorite() {
        return favorite;
    }

    /**
     * Sets favorite.
     *
     * @param favorite the favorite
     */
    public void setFavorite(Favorite favorite) {
        this.favorite = favorite;
    }

    /**
     * Gets quest.
     *
     * @return the quest
     */
    public Quest getQuest() {
        return quest;
    }

    /**
     * Sets quest.
     *
     * @param quest the quest
     */
    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    @Override
    public String toString() {
        return "FavoriteQuest{" +
                "id=" + id +
                ", favorite=" + favorite +
                ", quest=" + quest +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavoriteQuest that = (FavoriteQuest) o;
        return id == that.id && Objects.equals(favorite, that.favorite) && Objects.equals(quest, that.quest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, favorite, quest);
    }
}
