package jp.caliconography.android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import jp.caliconography.android.util.CachedTypefaces;
import jp.caliconography.mosquito.app.R;

public class CustomFontTextView extends TextView {
    private static final String TAG = "CustomFontTextView";

    public CustomFontTextView(Context context) {
        super(context);
    }

    public CustomFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(context, attrs);
    }

    public CustomFontTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setCustomFont(context, attrs);
    }

    private void setCustomFont(Context ctx, AttributeSet attrs) {
        TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.CustomFontTextView);
        String customFont = a.getString(R.styleable.CustomFontTextView_customFont);
        setCustomFont(ctx, customFont);
        a.recycle();
    }

    public boolean setCustomFont(Context context, String asset) {
        Typeface tf = null;
        try {
            tf = CachedTypefaces.get(context, asset);
        } catch (Exception e) {
            Log.d(TAG, "Could not get typeface: " + e.getMessage());
            return false;
        }

        setTypeface(tf);
        return true;
    }

}