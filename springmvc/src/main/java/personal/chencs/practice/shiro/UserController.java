package personal.chencs.practice.shiro;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequiresPermissions("user:list")
    @RequestMapping("/list")
    public String list() {
        return "listUser";
    }

    @RequiresPermissions("user:create")
    @RequestMapping("/create")
    public String create() {
        return "createUser";
    }

    @RequiresPermissions("user:delete")
    @RequestMapping("/delete")
    public String delete() {
        return "deleteUser";
    }

}
