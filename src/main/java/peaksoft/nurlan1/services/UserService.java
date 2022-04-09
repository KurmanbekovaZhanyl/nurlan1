package peaksoft.nurlan1.services;
import peaksoft.nurlan1.models.User;
import peaksoft.nurlan1.responce.Response;

import java.util.List;


public interface UserService {

    Response saveUser(User user);

    User findByUserId(Long id);

    Response deleteUserById(Long id);

    List<User> getAllUser();
}
