package gr.hua.dit.dsteam39.myVTSv3.Services;

import gr.hua.dit.dsteam39.myVTSv3.Entities.User;

/**
 * @author Greg Lefkelis lef
 * DS Team id: 39
 * @project myVTSv3
 */
public interface UserService {
    User registerUser(User user);

    User loginUser(String username, String password);
}
