package questie.persistence;

import questie.entity.Quest;
import quest.api.QuestAPI;
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
     * Gets quests by quest name
     * @return quests by quest name
     */
    public List<QuestAPI> getByQuestName(String questName) {

        logger.debug("Searching for: {}", questName );

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<QuestAPI> query = builder.createQuery(QuestAPI.class);
        Root<QuestAPI> root = query.from(QuestAPI.class);
        Expression<String> propertyPath = root.get("title");
        query.where(builder.like(propertyPath, "%" + questName + "%"));
        List<QuestAPI> quests = session.createQuery(query).getResultList();
        session.close();
        return quests;
    }
}
