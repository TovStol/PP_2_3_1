package web.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;


import javax.persistence.EntityManager;


import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    private final EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveUser(User user) {

        entityManager.persist(user);

    }

    @Override
    public void removeUserById(long id) {

        User user = entityManager.find(User.class, id);
        entityManager.remove(user);

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User").getResultList();

    }


    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserById(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.detach(user);
        return user;
    }
}
