package webworks.phone.impl;


import net.rim.device.api.script.Scriptable;

public class PhoneCallPropObj extends Scriptable {

public static final String FIELD_PHONENO = "phoneno";
public static final String FIELD_ISOUTGOING = "isoutgoing";
public static final String FIELD_DISPLAYPHONENO = "displayphoneno";
public static final String FIELD_PHONEEVENT = "phoneevent";

public String phoneno = "";
public Boolean isoutgoing = new Boolean(false);
public String displayphoneno = "";
public String phoneevent = "";

/**
* @see net.rim.device.api.script.Scriptable#getField(java.lang.String)
*/
public Object getField( final String name ) throws Exception {
	if( name.equals( FIELD_PHONENO ) ) {
		return phoneno;
	} else if( name.equals( FIELD_ISOUTGOING ) ) {
		return isoutgoing;
	}else if( name.equals( FIELD_DISPLAYPHONENO ) ) {
		return displayphoneno;
	} else if( name.equals( FIELD_PHONEEVENT ) ) {
		return phoneevent;
	}
	
	return super.getField( name );
	}

}
