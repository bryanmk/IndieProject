package questie.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * The type Favorite.
 */
@Entity(name = "Favorite")
@Table(name = "Favorite")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
//    @OneToMany(mappedBy = "favorite", fetch = FetchType.EAGER)
//    private Set<FavoriteQuest> quests = new HashSet<>();

    /**
     * No argument constructor.
     */
    public Favorite() {
    }

    /**
     * Instantiates a new Favorite.
     *
     * @param user the user
     */
    public Favorite(User user) {
        this.user = user;
    }

    /**
     * Instantiates a new Favorite.
     *
     * @param id   the id
     * @param user the user
     */
    public Favorite(int id, User user) {
        this.id = id;
        this.user = user;
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
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

//    /**
//     * Gets quests.
//     *
//     * @return the quests
//     */
//    public Set<FavoriteQuest> getQuests() {
//        return quests;
//    }
//
//    /**
//     * Sets quests.
//     *
//     * @param quests the quests
//     */
//    public void setQuests(Set<FavoriteQuest> quests) {
//        this.quests = quests;
//    }

    /**
     * Add quest.
     *
     * @param quest the quest
     */
//    public void addQuest(Quest quest) {
//        FavoriteQuest favoriteQuest = new FavoriteQuest(this, quest);
//        quests.add(favoriteQuest);
//    }

    /**
     * Remove quest.
     *
     * @param quest the quest
     */
//    public void removeQuest(Quest quest) {
//        for (Iterator<FavoriteQuest> iterator = quests.iterator();
//            iterator.hasNext(); ) {
//            FavoriteQuest favoriteQuest = iterator.hasNext();
//
//            if (favoriteQuest.getQuest().equals(this) &&
//                    favoriteQuest.getFavorite().equals(quest)) {
//                iterator.remove();
//                favoriteQuest.getQuest().getFavorites().remove(favoriteQuest);
//                favoriteQuest.setQuest(null);
//                favoriteQuest.setFavorite(null);
//            }
//        }
//    }

    @Override
    public String toString() {
        return "Favorite{" +
                "id=" + id +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Favorite favorite = (Favorite) o;
        return id == favorite.id && Objects.equals(user, favorite.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user);
    }
}
