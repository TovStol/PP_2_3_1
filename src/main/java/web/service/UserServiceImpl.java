package web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {

        this.userDao = userDao;
    }
    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }
    @Transactional
    @Override
    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }
    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
    @Transactional
    @Override
    public void updateUser(Long id, User user) {

        User existUser = userDao.getUserById(id);
        existUser.setId(id);
        existUser.setName(user.getName());
        existUser.setLastName(user.getLastName());
        existUser.setAge(user.getAge());
        userDao.updateUser(user);
    }
    @Transactional(readOnly = true)
    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

}
