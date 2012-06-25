package webworks.phone.namespace;

import webworks.phone.functions.FunctionStartListening;
import webworks.phone.functions.FunctionStopListening;
import webworks.phone.impl.PhoneListenerManager;
import net.rim.device.api.script.Scriptable;

public class PhoneListenerNamespace extends Scriptable {

	public static final String NAME = "webworks.phone";
	
	private FunctionStartListening _funcStartListening;
	private FunctionStopListening _funcStopListening;
	private PhoneListenerManager _manager;
	
	public PhoneListenerNamespace(PhoneListenerManager phoneListenerManager) {
		
		_manager = phoneListenerManager;
		
		_funcStartListening = new FunctionStartListening(phoneListenerManager);
		_funcStopListening = new FunctionStopListening(phoneListenerManager);
	}
	
	public Object getField(String name) throws Exception {
		
		if(FunctionStartListening.NAME.equals(name)) {
			return _funcStartListening;
		} else if(FunctionStopListening.NAME.equals(name)) {
			return _funcStopListening;
		} else {
			return super.getField(name);
		}
	}
}