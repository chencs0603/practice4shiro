<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<html>
<body>
    <nav>
        hello, <strong><shiro:principal/></strong> |
        <a href="/logout"><strong>logout</strong></a>
    </nav>

    <ul>
        <li><a href="/user/list">listUser</a> </li>
        <li><a href="/user/create">createUser</a> </li>
        <li><a href="/user/delete">deleteUser</a> </li>
        <li><a href="/admin">admin</a> </li>
    </ul>
</body>
</html>
