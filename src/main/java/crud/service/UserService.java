package crud.service;

import crud.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    void remove(long id);

    void update(long id, User user);

    User getOneUser(long id);

    List<User> getAllUsers();
}
