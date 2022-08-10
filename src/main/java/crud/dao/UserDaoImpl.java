package crud.dao;

import crud.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void remove(long id) {
        entityManager.remove(getOneUser(id));
    }
    @Override
    public void update(long id, User user) {
        entityManager.merge(user);
    }
    @Override
    public User getOneUser(long id) {
        return entityManager.find(User.class, id);
    }
    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("SELECT U FROM User U", User.class);
        return query.getResultList();
    }
}
