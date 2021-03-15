package xcloud.cxist.kttoast

import org.apache.cordova.*
import org.json.JSONArray
import org.json.JSONException
// import org.apache.cordova.CordovaArgs
// import org.apache.cordova.CordovaPlugin

/**
 * This class echoes a string called from JavaScript.
 */
class KTPlugin  : CordovaPlugin() {

    override fun execute(action: String, args: CordovaArgs, callbackContext: CallbackContext): Boolean {
        var result = true
        try {
            // if (action == "coolMethod") {
                // val input = data.getString(0)
                // val output = "Kotlin says \"$input\""
                callbackContext.success("I'm kotlin")
            // }
        } catch (e: Exception) {
           callbackContext.error(e.message)
           result = false
        }

        return result
    }
}
