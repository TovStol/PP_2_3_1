package web.service;


import web.model.User;

import java.util.List;

public interface UserService {


    void saveUser(User user);

    void removeUserById(long id);

    List<User> getAllUsers();

    void updateUser(User user);

    User getUserById(long id);
}
