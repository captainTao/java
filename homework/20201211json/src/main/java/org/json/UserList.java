package org.json;

import java.util.ArrayList;

public class UserList {
    private String id;
    private String key;
    private String tableName;
    private String className;
    private ArrayList<User> column;

    public UserList(String id, String key, String tableName, String className, ArrayList<User> column) {
        this.id = id;
        this.key = key;
        this.tableName = tableName;
        this.className = className;
        this.column = column;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public ArrayList<User> getColumn() {
        return column;
    }

    public void setColumn(ArrayList<User> column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "\n\t{id : " + id +
                "\n\tkey : " + key +
                "\n\ttableName : " + tableName +
                "\n\tclassName : " + className +
                "\n\tcolumn : " + column + " }";
    }
}
