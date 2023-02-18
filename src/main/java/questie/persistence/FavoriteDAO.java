package questie.persistence;

import questie.entity.Favorite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

public class FavoriteDAO {

    private final Logger logger = LogManager.getLogger(this.getClass());

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets all favorites
     * @return all the favorites
     */
    public List<Favorite> getAll() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Favorite> query = builder.createQuery(Favorite.class);
        Root<Favorite> root = query.from(Favorite.class);
        List<Favorite> favorites = session.createQuery(query).getResultList();
        session.close();
        return favorites;
    }

    /**
     * Gets favorites by last name
     * @return favorites by last name
     */
    public List<Favorite> getByLastName(String lastName) {

        logger.debug("Searching for: {}", lastName );

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Favorite> query = builder.createQuery(Favorite.class);
        Root<Favorite> root = query.from(Favorite.class);
        Expression<String> propertyPath = root.get("lastName");
        query.where(builder.like(propertyPath, "%" + lastName + "%"));
        List<Favorite> favorites = session.createQuery(query).getResultList();
        session.close();
        return favorites;
    }

    /**
     * Gets a favorite by Id
     * @return favorite
     */
    public Favorite getById(int id) {
        Session session = sessionFactory.openSession();
        Favorite favorite = session.get(Favorite.class, id);
        session.close();
        return favorite;
    }

    /**
     * update favorite
     * @param favorite  Favorite to be inserted or updated
     */
    public void saveOrUpdate(Favorite favorite) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(favorite);
        transaction.commit();
        session.close();
    }

    /**
     * update favorite
     * @param favorite  Favorite to be inserted or updated
     */
    public int insert(Favorite favorite) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(favorite);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a favorite
     * @param favorite Favorite to be deleted
     */
    public void delete(Favorite favorite) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(favorite);
        transaction.commit();
        session.close();
    }


    /**
     * Get favorite by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<Favorite> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for favorite with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Favorite> query = builder.createQuery( Favorite.class );
        Root<Favorite> root = query.from( Favorite.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Favorite> favorites = session.createQuery( query ).getResultList();

        session.close();
        return favorites;
    }

    /**
     * Get favorite by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<Favorite> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for favorite with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Favorite> query = builder.createQuery( Favorite.class );
        Root<Favorite> root = query.from( Favorite.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<Favorite> favorites = session.createQuery( query ).getResultList();
        session.close();
        return favorites;
    }

}
