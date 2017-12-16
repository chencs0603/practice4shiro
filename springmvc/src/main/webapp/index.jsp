<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<html>
<body>
    <nav>
        hello, <strong><shiro:principal/></strong> |
        <a href="/logout"><strong>logout</strong></a>
    </nav>
</body>
</html>
