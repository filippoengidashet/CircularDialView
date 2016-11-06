package org.dalol.oldcirculardialview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * Created by Filippo on 8/7/2016.
 */
public class ImageHelper {

    public static Bitmap getCircleBitmap(Bitmap bitmap, int radius) {

        bitmap = Bitmap.createScaledBitmap(bitmap, radius, radius, true);

//        if(bmp.getWidth() != radius || bmp.getHeight() != radius)
//            sbmp = Bitmap.createScaledBitmap(bmp, radius, radius, false);
//        else
//            sbmp = bmp;

        final Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(output);

        final int color = Color.RED;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawOval(rectF, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        bitmap.recycle();

        return output;
    }
}