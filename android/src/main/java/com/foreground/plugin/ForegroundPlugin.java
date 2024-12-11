package com.foreground.plugin;

import android.content.Context;
import android.content.Intent;
import android.app.ActivityManager;
import com.getcapacitor.Plugin;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

@CapacitorPlugin(name = "ForegroundPlugin")
public class ForegroundPlugin extends Plugin {

    @PluginMethod
    public void bringToForeground(PluginCall call) {
        // Get the context and the activity manager
        getLogger().info("bringToForeground called"); // Debug log
        Context context = getContext();
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

        if (am != null) {
            for (ActivityManager.RunningTaskInfo task : am.getRunningTasks(Integer.MAX_VALUE)) {
                // Check if the task belongs to the current app
                if (context.getPackageName().equalsIgnoreCase(task.baseActivity.getPackageName())) {
                    // Bring the app to the foreground
                    Intent intent = new Intent(context, getActivity().getClass());
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    context.startActivity(intent);
                    call.resolve(); // Resolve the promise
                    return;
                }
            }
        }

        // Reject the call if unable to bring the app to the foreground
        call.reject("Unable to bring app to foreground");
    }
}
