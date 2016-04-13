package newsapp.hugh.com.newsapplication.Applacation;

import android.app.Application;
import android.content.SharedPreferences;

/**
 * Created by hs on 2016/4/9.
 */
public class DataShare extends Application
{
    static SharedPreferences sp;
    private static SharedPreferences.Editor edit;

    @Override
    public void onCreate() {
        super.onCreate();
        sp = getSharedPreferences("DataRecord", MODE_PRIVATE);
    }

    public static void savebooleandata(String key, boolean value)
    {
        edit = sp.edit();
        edit.putBoolean(key, value);
        edit.commit();
    }

    public static boolean getbooleandata(String key, boolean defvalue)
    {
        boolean b = sp.getBoolean(key, defvalue);
        return b;
    }
}
