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
}
