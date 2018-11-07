package com.att.ssot.monitor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource(objectName="bean:name=MatchedAlarm")
public class MatchedAlarmBean implements AlarmMXBean {
	@Autowired
    private AlarmStore alarmStore;

	@Override
	public List<String> getActiveAlarms() {
		// TODO Auto-generated method stub
		return alarmStore.getActiveAlarms();
	}

	@ManagedAttribute(description="List of pending alarms")
	@Override
	public List<String> getPendingAlarms() {
		return alarmStore.getPendingAlarms();
	}

	@Override
	public List<String> getProcessedAlarms() {
		
		return alarmStore.getProcessedAlarms();
	}

	@Override
	@ManagedOperation(description="Remove alarm id from processed alarms")
	@ManagedOperationParameters({
	    @ManagedOperationParameter(name = "id", description = "Alarm id")})
	public List<String> updateProcessedAlarms(String id) {
		System.out.println("updated processing id : "+id);
		alarmStore.getProcessedAlarms().remove(id);
		return alarmStore.getProcessedAlarms();
	}
	
	@Override
	public int numberOfAlarms() {
		// TODO Auto-generated method stub
		return 0;
	}

}
