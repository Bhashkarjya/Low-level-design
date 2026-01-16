package splitwise.users;

import java.util.ArrayList;
import java.util.List;
public class UserController {
    private List<User> users;

    public UserController() {
        this.users = new ArrayList<>();
    }

    public User createUser(String name) {
        User user = new User(name);
        this.users.add(user);
        return user;
    }

    public User getUser(int userId) {
        for(User user : this.users) {
            if(userId == user.getUserId()) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        return this.users;
    }
}
