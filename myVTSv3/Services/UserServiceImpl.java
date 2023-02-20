package gr.hua.dit.dsteam39.myVTSv3.Services;

import gr.hua.dit.dsteam39.myVTSv3.Entities.User;
import gr.hua.dit.dsteam39.myVTSv3.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Greg Lefkelis lef
 * DS Team id: 39
 * @project myVTSv3
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user !=null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
