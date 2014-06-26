package jp.caliconography.android.util;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

import java.util.Hashtable;

public class CachedTypefaces {
    private static final String TAG = "CachedTypefaces";

    private static final Hashtable<String, Typeface> cache = new Hashtable<String, Typeface>();

    public static Typeface get(Context context, String assetPath) {
        synchronized (cache) {
            if (!cache.containsKey(assetPath)) {
                try {
                    Typeface t = Typeface.createFromAsset(context.getAssets(), assetPath);
                    cache.put(assetPath, t);
                } catch (Exception e) {
                    Log.d(TAG, "Could not get typeface '" + assetPath + "' because " + e.getMessage());
                    return null;
                }
            }
            return cache.get(assetPath);
        }
    }
}