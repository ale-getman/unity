package dev.klippe.unity.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;

import dev.klippe.unity.R;

/**
 * Created by user on 21.07.2017.
 */

public class MaskImage {

    public Context context;

    public MaskImage(Context context) {
        this.context = context;
    }

    public Bitmap getBitmap(){

        Bitmap original = BitmapFactory.decodeResource(context.getResources(), R.drawable.opacity);
        Bitmap mask = BitmapFactory.decodeResource(context.getResources(),R.drawable.mask);
        Bitmap result = Bitmap.createBitmap(mask.getWidth(), mask.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas mCanvas = new Canvas(result);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        mCanvas.drawBitmap(original, 0, 0, null);
        mCanvas.drawBitmap(mask, 0, 0, paint);
        paint.setXfermode(null);
        return result;
    }
}
