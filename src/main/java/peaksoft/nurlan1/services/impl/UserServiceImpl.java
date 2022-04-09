package peaksoft.nurlan1.services.impl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.nurlan1.exception.NotFoundException;
import peaksoft.nurlan1.models.User;
import peaksoft.nurlan1.repositories.UserRepo;
import peaksoft.nurlan1.responce.Response;
import peaksoft.nurlan1.services.UserService;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepo userRepo;

    @Override
    public Response saveUser(User user) {
    userRepo.save(user);
    return Response.builder().status(HttpStatus.CREATED).build();
    }

    @Override
    public User findByUserId(Long id) {
        User user= userRepo.findById(id)
                .orElseThrow(() -> {
                    throw new NotFoundException("no id");
                });
        return user;
    }

    @Override
    public Response deleteUserById(Long id) {

        userRepo.deleteById(id);
         return Response.builder().status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }


}
