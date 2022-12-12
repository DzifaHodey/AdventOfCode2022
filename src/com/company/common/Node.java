package com.company.common;

import java.util.Map;

public class Node<T> {

    private final T data;
    private final Map children;
    private final Node<T> parent;

    public Node(T data, Map children, Node<T> parent) {
        this.data = data;
        this.children = children;
        this.parent = parent;
    }

    public Node(T data, Map children) {
        this(data, children, null);
    }

    public T getData() {
        return data;
    }

    public Map getChildren() {
        return children;
    }
}
