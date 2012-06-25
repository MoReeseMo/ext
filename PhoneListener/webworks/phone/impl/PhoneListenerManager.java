package webworks.phone.impl;

import net.rim.blackberry.api.phone.AbstractPhoneListener;
import net.rim.blackberry.api.phone.Phone;
import net.rim.blackberry.api.phone.PhoneCall;

import net.rim.device.api.script.ScriptableFunction;
import net.rim.device.api.system.Application;

public class PhoneListenerManager {
      
	private PhoneListener _listener;
    private Application _appObject;
    private ScriptableFunction _callBack;
     
    public PhoneListenerManager() {
		_appObject = Application.getApplication();
    }
      
    public void startListening(ScriptableFunction callback) {
        try {
        	_callBack = callback;
        	_listener = new PhoneListener();
        	Phone.addPhoneListener(_listener);
		}catch (Exception ex){
		}
    }

    public void stopListening(ScriptableFunction callback) {
		Phone.removePhoneListener(_listener);
		_listener = null;		
    }
      
    protected void notifyCallListened(final Object call){
          final ScriptableFunction sf = (ScriptableFunction)_callBack;
          _appObject.invokeLater(new Runnable() {
              public void run() {
                    try {
                        sf.invoke(null, new Object[] {call});
                    } catch (Exception e) {
                          System.out.println("Error invoking callback: " + e.getMessage());
                          throw new RuntimeException("Error invoking callback: " + e.getMessage());
                    }
              }
        });
    }

    private class PhoneListener extends AbstractPhoneListener {
         public void callIncoming(int callId) {
        	 PhoneCall phoneCall = Phone.getCall(callId);
        	 PhoneCallPropObj callObj = new PhoneCallPropObj();
        	 
        	 callObj.displayphoneno = phoneCall.getDisplayPhoneNumber();
        	 callObj.phoneno = phoneCall.getPhoneNumber();
        	 callObj.isoutgoing = new Boolean(phoneCall.isOutgoing());
        	 callObj.phoneevent = "callIncoming";
        	 
        	 notifyCallListened(callObj);
         }
	
         public void callInitiated(int callId) {
        	 PhoneCall phoneCall = Phone.getCall(callId);
        	 PhoneCallPropObj callObj = new PhoneCallPropObj();
        	 
        	 callObj.displayphoneno = phoneCall.getDisplayPhoneNumber();
        	 callObj.phoneno = phoneCall.getPhoneNumber();
        	 callObj.isoutgoing = new Boolean(phoneCall.isOutgoing());
        	 callObj.phoneevent = "callInitiated";
        	 
        	 notifyCallListened(callObj);
         }

         public void callConnected(int callId) {
        	 //to be implemented
         }
         
         public void callDisconnected(int callId)    {
        	//to be implemented
        	//Note: Since call is disconnected, PhoneCall object is null
         }
	}
}	
