package com.example.ggis_starr;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class SimpleLogger
{
    SimpleLogger()
    {
    }

    void showinfo(Context context, String info, int duration)
    {
        Toast.makeText(context, info, duration).show();
    }

    void showinfo(Context context, int resource_id, int duration)
    {
        Toast.makeText(context, context.getString(resource_id), duration).show();
    }

    void loginfo(Context context, String function_name, String log_title, String data)
    {
        String msg = "Function Name: " + function_name + "\nTitle: " + log_title + "\n Data: " + data + "\nEND!";
        Log.i(context.getClass().getSimpleName(), msg);
    }

    void logerror(Context context, String function_name, String log_title, String data, Error error)
    {
        String msg = "Function Name: " + function_name + "\nTitle: " + log_title + "\n Data: " + data + "\nEND!";
        msg += "\n Error Message: " + error.getMessage();
        error.printStackTrace();
        Log.e(context.getClass().getSimpleName(), msg);
    }

    void logerror(Context context, String function_name, String log_title, String data, String error)
    {
        String msg = "Function Name: " + function_name + "\nTitle: " + log_title + "\n Data: " + data + "\nEND!";
        msg += "\n Error Message: " + error;
        Log.e(context.getClass().getSimpleName(), msg);
    }
}
