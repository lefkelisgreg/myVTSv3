package gr.hua.dit.dsteam39.myVTSv3.Repository;

import gr.hua.dit.dsteam39.myVTSv3.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Greg Lefkelis lef
 * DS Team id: 39
 * @project myVTSv3
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    List<User> findByEmail(String email);

    List<User> findByVATnumber(int VATnumber);
}

