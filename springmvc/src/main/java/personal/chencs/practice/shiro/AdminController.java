package personal.chencs.practice.shiro;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequiresRoles("admin")
    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

}
