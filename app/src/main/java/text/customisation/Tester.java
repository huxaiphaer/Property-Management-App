package text.customisation;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by HUZY-KAMZ on 1/16/2016.
 */
public class Tester extends TextView {
    public Tester(Context context) {
        super(context);
        setFont();
    }
    public Tester(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont();
    }
    public Tester(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setFont();
    }

    private void setFont() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/Marigold-Regular.ttf");
        setTypeface(font, Typeface.NORMAL);
    }
}
