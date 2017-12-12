package personal.chencs.practice.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: chencs
 * @date: 2017/12/1
 * @description:
 */
public class MainClass {

    private final static Logger logger = LoggerFactory.getLogger(MainClass.class);

    public static void main(String[] arg) {
        SecurityManager manager = new IniSecurityManagerFactory().getInstance();
        SecurityUtils.setSecurityManager(manager);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("chencs", "123456");

        try {
            subject.login(token);

            logger.info(subject.getPrincipal().toString() + " login success");

            PrincipalCollection principalCollection = subject.getPrincipals();
            logger.info(principalCollection.getRealmNames().toString());
            logger.info(principalCollection.asList().toString());
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
    }

}
