package webworks.phone;

import org.w3c.dom.Document;

import webworks.phone.impl.PhoneListenerManager; 
import webworks.phone.namespace.PhoneListenerNamespace;

import net.rim.device.api.browser.field2.BrowserField;
import net.rim.device.api.script.ScriptEngine;
import net.rim.device.api.web.WidgetConfig;
import net.rim.device.api.web.WidgetExtension;



public class PhoneListenerExtension implements WidgetExtension {

    
	public String[] getFeatureList() {
		return new String[] { PhoneListenerNamespace.NAME };
	}

	public void loadFeature(String feature, String version, Document doc, ScriptEngine scriptEngine) throws Exception {
		if(scriptEngine == null) {
			throw new IllegalArgumentException("scriptEngine should not be null");
		}
		
		if(PhoneListenerNamespace.NAME.equals(feature)) {
			scriptEngine.addExtension(PhoneListenerNamespace.NAME, new PhoneListenerNamespace(new PhoneListenerManager()));
		}

	}

	public void register(WidgetConfig widgetConfig, BrowserField browserField) {
		//Nothing to do here...
	}

	public void unloadFeatures(Document doc) {
		//Nothing to do here either...
	}

}
