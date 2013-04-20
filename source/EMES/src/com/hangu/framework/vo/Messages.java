package com.hangu.framework.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 逻辑消息集合
 * 
 * @author 曹保利
 * 
 */
public class Messages implements Serializable {

    private static final long serialVersionUID = -7410826431026041043L;

    protected List<Message> list = new ArrayList<Message>();

    public Messages() {
        super();
    }

    public Messages(String messageContent) {
        super();
        list.add(new Message(messageContent));
    }

    public void add(String messageContent) {
        list.add(new Message(messageContent));
    }

    public void add(Message message) {
        this.list.add(message);
    }

    public List<Message> get() {
        return list;
    }

    public List<Message> getMessages() {
        return list;
    }

    public void clear() {
        this.list.clear();
    }

    public boolean isEmpty() {
        return (list.isEmpty());
    }

}
