package com.att.ssot.monitor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AlarmStore {
    static List<String>  processedAlarms = new ArrayList();
	static List<String>  activeAlarms = new ArrayList();
	static List<String>  pendingAlarms = new ArrayList();
	
	static {
		activeAlarms.add("al_0");
		activeAlarms.add("al_1");
		
		pendingAlarms.add("pending_2");
		pendingAlarms.add("pending_3");
		
		processedAlarms.add("proc_2");
		processedAlarms.add("proc_3");
	}
	public List<String> getProcessedAlarms() {
		return processedAlarms;
	}
	public void setProcessedAlarms(List<String> processedAlarms) {
		this.processedAlarms = processedAlarms;
	}
	public List<String> getActiveAlarms() {
		return activeAlarms;
	}
	public void setActiveAlarms(List<String> activeAlarms) {
		this.activeAlarms = activeAlarms;
	}
	public List<String> getPendingAlarms() {
		return pendingAlarms;
	}
	public void setPendingAlarms(List<String> pendingAlarms) {
		this.pendingAlarms = pendingAlarms;
	}
	
	
}
