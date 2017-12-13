package personal.chencs.practice.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author: chencs
 * @date: 2017/12/1
 * @description:
 */
public class MainClass {

    private final static Logger logger = LoggerFactory.getLogger(MainClass.class);

    public static void main(String[] arg) {
        Subject subject = login("chencs", "123456");
        System.out.println(subject.hasRole("user"));
        System.out.println(subject.hasAllRoles(Arrays.asList("user", "admin", "visitor")));
        System.out.println(subject.hasRoles(Arrays.asList("user", "admin", "visitor"))[0]);
        System.out.println(subject.hasRoles(Arrays.asList("user", "admin", "visitor"))[1]);
        System.out.println(subject.hasRoles(Arrays.asList("user", "admin", "visitor"))[2]);

        System.out.println(subject.isPermitted("user:create"));
        System.out.println(subject.isPermitted("user:update"));
        System.out.println(subject.isPermitted("admin:create"));
    }

    private static Subject login(String username, String password) {
        SecurityManager manager = new IniSecurityManagerFactory().getInstance();
        SecurityUtils.setSecurityManager(manager);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token);

            logger.info(subject.getPrincipal().toString() + " login success");
            return subject;
        } catch (UnknownAccountException unknownAccountException) {
            logger.info(unknownAccountException.getMessage());
            logger.warn("username not exists");
        } catch (IncorrectCredentialsException incorrectCredentialsException) {
            logger.info(incorrectCredentialsException.getMessage());
            logger.warn("error password");
        } catch (AuthenticationException authenticationException) {
            logger.info(authenticationException.getMessage());
            logger.warn("unknown error");
        }

        return null;
    }

}
