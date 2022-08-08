package crud.dao;

import crud.model.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface UserDao {

    void add(User user);

    void remove(long id);

    void update(long id, User user);

    User getOneUser(long id);

    List<User> getAllUsers();
}
