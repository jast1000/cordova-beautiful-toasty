package com.duckdns.jast.plugin.beautifultoasty;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import es.dmoral.toasty.Toasty;
import android.widget.Toast;

/**
 * This class echoes a string called from JavaScript.
 */
public class BeautifulToasty extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("showSuccess")) {
            String message = args.getString(0);
            this.showSuccess(message, callbackContext);
            return true;
        }
        return false;
    }

    private void showSuccess(String message, CallbackContext callbackContext) {
        if (message != null) {
            Toasty.success(this.cordova.getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT, true).show();
            callbackContext.success(message);
        } else {
            callbackContext.error("Message is required..");
        }
    }

}
