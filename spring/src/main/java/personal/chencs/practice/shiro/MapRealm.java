package personal.chencs.practice.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: chencs
 * @date: 2017/12/1
 * @description:
 */
public class MapRealm implements Realm {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static Map users;

    static {
        users = new HashMap();
        users.put("chencs", "123456");
    }

    @Override
    public String getName() {
        return "mapRealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = token.getPrincipal().toString();
        String password = new String((char[]) token.getCredentials());

        logger.info("username:{}, password:{}", username, password);

        if (!users.containsKey(username)) throw new UnknownAccountException("username not exists");

        if (!password.equals(users.get(username))) throw new IncorrectCredentialsException("error password");

        AuthenticationInfo info = new SimpleAuthenticationInfo(username, password, getName());
        return info;
    }
}
