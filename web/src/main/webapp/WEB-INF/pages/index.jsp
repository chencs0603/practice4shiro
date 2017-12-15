<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<html>
<body>
<h2>
    <shiro:user>
        hello, <shiro:principal/>!<br>
        <a href="/logout">logout</a>
    </shiro:user>
</h2>
</body>
</html>
