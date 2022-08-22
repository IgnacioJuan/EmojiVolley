package com.juanguachi.emojivolley.model;

import java.util.List;

public class Emoji {
    private String name;
    private String category;
    private String group;
    private List<String> htmlCode = null;
    private List<String> unicode = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<String> getHtmlCode() {
        return htmlCode;
    }

    public void setHtmlCode(List<String> htmlCode) {
        this.htmlCode = htmlCode;
    }

    public List<String> getUnicode() {
        return unicode;
    }

    public void setUnicode(List<String> unicode) {
        this.unicode = unicode;
    }

    @Override
    public String toString() {
        return "Emoji{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", group='" + group + '\'' +
                ", htmlCode=" + htmlCode +
                ", unicode=" + unicode +
                '}';
    }
}
