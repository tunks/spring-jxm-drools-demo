package com.att.ssot.monitor;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.runtime.rule.Row;
import org.kie.api.runtime.rule.ViewChangedEventListener;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;
import com.att.ssot.model.Incident;
import com.att.ssot.web.DroolsEngine;

@Component
@ManagedResource(objectName = "bean:name=com.att.ssot.drools-engine")
public class DroolsRuleEngineBean implements RuleEngineXMBean<String>,InitializingBean {
	@Autowired
	private DroolsEngine droolsEngine;
	String QUERY_NAME = "getIncidentByName";

	final List updated = new ArrayList();
	final List removed = new ArrayList();
	final List added = new ArrayList();

	private ViewChangedEventListener listener = new ViewChangedEventListener() {
		public void rowUpdated(Row row) {
			System.out.println("Alarm count updated: " +row.get("$alarm_count"));
			updated.add(row.get("$alarm_count"));
		}
		
		@Override
		public void rowInserted(Row row) {
			System.out.println("Alarm count inserted: " +row.get("$alarm_count"));
			added.add(row.get("$alarm_count"));
		}

		@Override
		public void rowDeleted(Row row) {
			System.out.println("Alarm count removed: " +row.get("$alarm_count"));
			removed.add(row.get("$alarm_count"));
		}
	};
	
	@ManagedOperation(description="Insert incident object")
	@ManagedOperationParameters({
	    @ManagedOperationParameter(name = "name", description = "Incident name")})
	@Override
	public void insertObject(String name) {
		Incident incident = new Incident();
		incident.setName(name);
		incident.setNumberOfAlarms(100);
		incident.setEnetSwitch("et_1");
		System.out.println("incident created "+incident);
		droolsEngine.insertObject(incident);
	}

	@ManagedOperation(description="Get live objects")
	  @ManagedOperationParameters({})
	@Override
	public Object getLiveObjects() {
		return added;
	}

	@ManagedOperation(description="Open live objects")
	@Override
	public boolean openQuery() {
		String [] queryArguments= {"incident01"};
		return this.droolsEngine.openQuery(QUERY_NAME,queryArguments, listener);
	}

	@ManagedOperation(description="Close live objects")
	@Override
	public boolean closeQuery() {
		return this.droolsEngine.closeQuery(QUERY_NAME);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		droolsEngine.run();		
	}

	
}
