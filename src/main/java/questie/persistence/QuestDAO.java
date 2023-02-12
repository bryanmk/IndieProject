package questie.persistence;

import questie.entity.Quest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import questie.entity.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

public class QuestDAO {

    private final Logger logger = LogManager.getLogger(this.getClass());

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets all quests
     * @return all the quests
     */
    public List<Quest> getAll() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Quest> query = builder.createQuery(Quest.class);
        Root<Quest> root = query.from(Quest.class);
        List<Quest> quests = session.createQuery(query).getResultList();
        session.close();
        return quests;
    }

    /**
     * Gets quests by quest name
     * @return quests by quest name
     */
    public List<Quest> getByQuestName(String questName) {

        logger.debug("Searching for: {}", questName );

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Quest> query = builder.createQuery(Quest.class);
        Root<Quest> root = query.from(Quest.class);
        Expression<String> propertyPath = root.get("questName");
        query.where(builder.like(propertyPath, "%" + questName + "%"));
        List<Quest> quests = session.createQuery(query).getResultList();
        session.close();
        return quests;
    }

    /**
     * Gets a quest by Id
     * @return quest
     */
    public Quest getByQuestId(int id) {
        Session session = sessionFactory.openSession();
        Quest quest = session.get(Quest.class, id);
        session.close();
        return quest;
    }

    /**
     * insert quest
     * @param quest  Quest to be inserted or updated
     */
    public int insert(Quest quest) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(quest);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a quest
     * @param quest Quest to be deleted
     */
    public void delete(Quest quest) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(quest);
        transaction.commit();
        session.close();
    }

    /**
     * update quest
     * @param quest  Quest to be inserted or updated
     */
    public void saveOrUpdate(Quest quest) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(quest);
        transaction.commit();
        session.close();
    }

    /**
     * Get quest by property (exact match)
     * sample usage: getByPropertyEqual("questName", "A Dying World")
     */
    public List<Quest> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for quest with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Quest> query = builder.createQuery( Quest.class );
        Root<Quest> root = query.from( Quest.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Quest> quests = session.createQuery( query ).getResultList();

        session.close();
        return quests;
    }

    /**
     * Get quest by property (like)
     * sample usage: getByPropertyLike("questName", "the")
     */
    public List<Quest> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for user with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Quest> query = builder.createQuery( Quest.class );
        Root<Quest> root = query.from( Quest.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<Quest> quests = session.createQuery( query ).getResultList();
        session.close();
        return quests;
    }
}
