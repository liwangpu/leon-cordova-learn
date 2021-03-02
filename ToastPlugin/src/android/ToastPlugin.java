package cxist.xcloud.toast;

import android.widget.Toast;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class ToastPlugin extends CordovaPlugin {

  @Override
  public boolean execute(
    String action,
    JSONArray args,
    CallbackContext callbackContext
  )
    throws JSONException {
    if (action.equals("show")) {
      String message = args.getString(0);
      this.show(message, callbackContext);
      return true;
    }
    return false;
  }

  private void show(String message, CallbackContext callbackContext) {
    Toast
      .makeText(
        this.cordova.getActivity().getApplicationContext(),
        message,
        Toast.LENGTH_SHORT
      )
      .show();
  }
}
