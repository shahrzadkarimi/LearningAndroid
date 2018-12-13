package basic.LearningAndroid.utils;

import android.content.Context;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.orhanobut.hawk.Hawk;

public class PublicMethods {
    public static void toast(Context mContext,String msg)
    {
        Toast.makeText(mContext,msg, Toast.LENGTH_SHORT).show();
    }

    public static void saveData(Context mContext,String key,String value)
    {
      //  PreferenceManager.getDefaultSharedPreferences(mContext).edit()
      //          .putString(key, value).apply();
        Hawk.put(key,value);
    }

    public static String getData(Context mContext, String key, String defValue)
    {
        return Hawk.get(key,defValue);
        //return PreferenceManager.getDefaultSharedPreferences(mContext)
        //       .getString(key,defValue);
    }
}
