package personal.chencs.practice.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyRealm extends AuthorizingRealm {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = token.getPrincipal().toString();
        String password = new String((char[]) token.getCredentials());

        logger.info("username:{}, password:{}", username, password);

        if (!"chencs".equals(username)) throw new UnknownAccountException("username not exists");

        if (!"123456".equals(password)) throw new IncorrectCredentialsException("error password");

        AuthenticationInfo info = new SimpleAuthenticationInfo("chencs0603@gmail.com", password, getName());
        return info;
    }
}
