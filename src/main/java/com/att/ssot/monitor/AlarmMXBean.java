package com.att.ssot.monitor;

import java.util.List;

public interface AlarmMXBean {
	public List<String> getActiveAlarms();
	public List<String> getPendingAlarms();
	public List<String> getProcessedAlarms();
	public List<String> updateProcessedAlarms(String id);
    public int numberOfAlarms();
}
