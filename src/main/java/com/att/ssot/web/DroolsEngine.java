package com.att.ssot.web;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.LiveQuery;
import org.kie.api.runtime.rule.ViewChangedEventListener;
import org.springframework.stereotype.Component;

import com.att.ssot.model.Incident;

@Component("droolsEngine")
public class DroolsEngine {
   private KieServices ks = KieServices.Factory.get();
   private KieContainer kContainer = ks.getKieClasspathContainer();
   private KieSession kSession = kContainer.newKieSession("ksession-rules");
   private Map<String,LiveQuery> liveQueries = new HashMap();
   private ExecutorService executor = Executors.newSingleThreadExecutor();
   
   static {
	   
	    //System.setProperty("kie.mbeans", "enabled");
   }

   public void run() {
       try {
    	   executor.execute(new Runnable() {
			@Override
			public void run() {
				    System.out.println("Starting drools run engine");
		           kSession.fireUntilHalt();				
			}
    	   });
    	      
       } catch (Throwable t) {
           t.printStackTrace();
       }
   }
   
   public void insertObject(Incident incident) {
        kSession.insert(incident);
   }
   
   public boolean openQuery(String name, Object[] arguments, ViewChangedEventListener listener) {
	   if( !liveQueries.containsKey(name)) {
	      LiveQuery query = kSession.openLiveQuery(name, arguments,listener );
	      liveQueries.put(name, query);
	      return  true;
	   }
	   return false;
   }
   
   
   public boolean closeQuery(String name) {
	   if(liveQueries.containsKey(name)) {
		   LiveQuery query = liveQueries.get(name);
		   query.close();
		   return true;
	   }
	   return false;
   }
   
}
