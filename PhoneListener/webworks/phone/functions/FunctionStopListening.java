package webworks.phone.functions;

import blackberry.core.FunctionSignature;
import blackberry.core.ScriptableFunctionBase;
import webworks.phone.impl.PhoneListenerManager;
import net.rim.device.api.script.ScriptableFunction;

public class FunctionStopListening extends ScriptableFunctionBase {
	
	public static final String NAME = "stopListening";
	
	private PhoneListenerManager _manager;

	public FunctionStopListening(PhoneListenerManager phoneListenerManager) {
		_manager = phoneListenerManager;
	}
	
	 public Object execute( Object thiz, Object[] args ) throws Exception {
	    	
 		if(isNullOrEmpty(args)) {
 			throw new IllegalArgumentException("Missing arguments: expecting name of callback function.");
 		}
 		
 		_manager.stopListening((ScriptableFunction)args[0]);
 	
 	return UNDEFINED;
 }
	 private boolean isNullOrEmpty(Object[] args) {
			return args == null || args.length == 0;
		}
		
	    /**
	     * @see net.rim.device.api.web.jse.base.ScriptableFunctionBase
	     */
	    protected FunctionSignature[] getFunctionSignatures() {
	    	FunctionSignature fs = new FunctionSignature(1);
	        fs.addParam(ScriptableFunction.class, false);
	        return new FunctionSignature[] { fs };
	    } 

}
