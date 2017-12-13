package personal.chencs.practice.shiro;

import org.apache.shiro.authz.Permission;

public class MyPermission implements Permission {

    private String resource;
    private String operation;
    private String instance;

    @Override
    public boolean implies(Permission p) {
        if (!(p instanceof MyPermission))
            return false;

        MyPermission myPermission = (MyPermission) p;
        if (!"*".equals(getResource()) && !getResource().equals(myPermission.getResource()))
            return false;

        if (!"*".equals(getOperation()) && !getOperation().equals(myPermission.getOperation()))
            return false;

        if (!"*".equals(getInstance()) && !getInstance().equals(myPermission.getInstance()))
            return false;

        return true;
    }

    public MyPermission(String permissionString) {
        String[] strs = permissionString.split("\\+");

        if (1 < strs.length) {
            setResource(strs[1]);
        }
        if (null == getResource() || "".equals(getResource())) {
            setResource("*");
        }

        if (2 < strs.length) {
            setOperation(strs[2]);
        }

        if (3 < strs.length) {
            setInstance(strs[3]);
        }
        if (null == getInstance() || "".equals(getInstance())) {
            setInstance("*");
        }

        System.out.println(this);
    }

    public MyPermission() {
    }

    @Override
    public String toString() {
        return "MyPermission{" +
                "resource='" + resource + '\'' +
                ", operation='" + operation + '\'' +
                ", instance='" + instance + '\'' +
                '}';
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }
}
