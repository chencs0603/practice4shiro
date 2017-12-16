package personal.chencs.practice.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyAccessControlFilter extends AccessControlFilter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        String username = request.getParameter("username");
        if (null == username || "".equals(username)) {
            return true;
        }

        logger.debug("login user: {}", username);
        if (!"chencs".equals(username)) {
            logger.warn("{} not access allowed", username);
            return false;
        }

        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        request.setAttribute("errorMsg", "only chencs can login success");
        request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);

        return true;
    }

}
