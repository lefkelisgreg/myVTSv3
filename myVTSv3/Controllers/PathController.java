package gr.hua.dit.dsteam39.myVTSv3.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Greg Lefkelis lef
 * DS Team id: 39
 * @project myVTSv3
 */
@Controller
public class PathController {

    @GetMapping("/")
    public String index() {return "index";}

     @GetMapping("/registration")
    public String signUp() {
        return "register";
    }

    @GetMapping("/notification")
    public String notifyBuyer() {
        return "notification";
    }

    @GetMapping("/offices")
    public String govOffices() {
        return "offices";
    }

    @GetMapping("/adminpanel")
    public String admin() {
        return "sysadmin";
    }
}
