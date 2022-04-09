package peaksoft.nurlan1.api;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import peaksoft.nurlan1.models.User;
import peaksoft.nurlan1.responce.Response;
import peaksoft.nurlan1.services.UserService;

import java.util.List;


@Controller
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserApi {

    private final UserService userService;



    @PostMapping
    public Response saveUser(@RequestBody User user) {
      return userService.saveUser(user);


    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAllUser();

    }


    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable ("id") Long id) {
        return userService.findByUserId(id);
    }

    @DeleteMapping("/deleteUser/{id}")
    public Response deleteUserById(@PathVariable("id") Long id) {
        return userService.deleteUserById(id);
    }






}
