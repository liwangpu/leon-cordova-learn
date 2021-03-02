package xcloud.cxist.dialer;

import android.content.Intent;
import android.net.Uri;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class DialerPlugin extends CordovaPlugin {

  @Override
  public boolean execute(
    String action,
    JSONArray args,
    CallbackContext callbackContext
  )
    throws JSONException {
    if (action.equals("dial")) {
      String phoneNumber = args.getString(0);
      this.dial(phoneNumber, callbackContext);
      return true;
    }
    return false;
  }

  private void dial(String phoneNumber, CallbackContext callbackContext) {
    // callbackContext.success(message);
    // callbackContext.error("Expected one non-empty string argument.");
    try {
      Intent intent = new Intent();
      intent.setAction(Intent.ACTION_CALL);
      Uri data = Uri.parse("tel:" + phoneNumber);
      intent.setData(data);
      this.cordova.getActivity().startActivity(intent);
    } catch (Exception exp) {
      callbackContext.error(exp.getMessage());
    }
  }
}
