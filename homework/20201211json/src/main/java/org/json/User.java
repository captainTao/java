package org.json;

public class User {
    private String key;
    private String header;
    private int width;
    private boolean allowSort;
    private boolean hidden;

    public User(String key, String header, int width, boolean allowSort, boolean hidden) {
        this.key = key;
        this.header = header;
        this.width = width;
        this.allowSort = allowSort;
        this.hidden = hidden;
    }

    public User(String key, String header, int width, boolean allowSort) {
        this.key = key;
        this.header = header;
        this.width = width;
        this.allowSort = allowSort;
    }

    public User(String key, String header, boolean hidden) {
        this.key = key;
        this.header = header;
        this.hidden = hidden;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean getAllowSort() {
        return allowSort;
    }

    public void setAllowSort(boolean allowSort) {
        this.allowSort = allowSort;
    }

    public boolean getHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }


    @Override
    public String toString() {
        return "\n\t\t{key : " + key +
                "\n\t\theader : " + header +
                "\n\t\thidden : " + hidden +
                "\n\t\twidth : " + width +
                "\n\t\tallowSort : " + allowSort + " }";
    }

}
