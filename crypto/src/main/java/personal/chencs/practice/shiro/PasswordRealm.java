package personal.chencs.practice.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PasswordRealm extends AuthorizingRealm {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = token.getPrincipal().toString();
        String password = new String((char[]) token.getCredentials());
        String saltValue = "shiro";

        logger.info("username:{}, password:{}", username, password);

        if (!"chencs".equals(username)) throw new UnknownAccountException("username not exists");

        String cipherText = new Md5Hash(password, saltValue).toHex();

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, cipherText, getName());
        info.setCredentialsSalt(ByteSource.Util.bytes(saltValue));
        return info;
    }
}
