package com.hangu.framework.vo;

import java.io.Serializable;

public class Message implements Serializable {

    private static final long serialVersionUID = 2885287921533717080L;

    public Message(String content) {
        this(content, (Object[]) null);
    }

    public Message(String content, Object... values) {
        this.content = content;
        this.values = values;
        this.resource = true;
    }

    public Message(String content, boolean resource) {

        this.content = content;
        this.resource = resource;

    }

    protected String content = null;

    protected Object[] values = null;

    protected boolean resource = true;

    public String getContent() {

        return (this.content);

    }

    public Object[] getValues() {

        return (this.values);

    }

    public boolean isResource() {

        return (this.resource);

    }
}
