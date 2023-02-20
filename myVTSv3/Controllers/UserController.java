package gr.hua.dit.dsteam39.myVTSv3.Controllers;

import gr.hua.dit.dsteam39.myVTSv3.Entities.User;
import gr.hua.dit.dsteam39.myVTSv3.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * @author Greg Lefkelis lef
 * DS Team id: 39
 * @project myVTSv3
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") @Valid User userform, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }

        User user = new User();
        user.setUsername(userform.getUsername());
        user.setPassword(userform.getPassword());
        user.setRole(userform.getRole());
        user.setFname(userform.getFname());
        user.setLname(userform.getLname());
        user.setEmail(userform.getEmail());
        user.setAddress(userform.getAddress());
        user.setPhone(userform.getPhone());
        user.setVATnumber(userform.getVATnumber());
        user.setBirthDate(userform.getBirthDate());

        userService.registerUser(user);

        return "redirect:/login";

    }
}
