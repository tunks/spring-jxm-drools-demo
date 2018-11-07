package com.att.ssot.monitor;

public interface RuleEngineXMBean<T> {
    public void insertObject(T incident);
    public Object getLiveObjects();
    public boolean openQuery();
    public  boolean closeQuery();
}
