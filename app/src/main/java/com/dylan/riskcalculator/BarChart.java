package com.dylan.riskcalculator;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.text.NumberFormat;
import java.text.ParsePosition;

/**
 * Created by dylan on 16/04/2016.
 */


public class BarChart extends View{
    private Paint paint;
    Bitmap bg = Bitmap.createBitmap(480, 800, Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bg);
    DisplayMetrics displaymetrics = new DisplayMetrics();
    int height = 0;
    int width = 0;


    public BarChart(Context context)
    {
        super(context);
        paint = new Paint();
        displaymetrics = Resources.getSystem().getDisplayMetrics();
        height = displaymetrics.heightPixels;
        width = displaymetrics.widthPixels;

    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        paint.setColor(Color.parseColor("#0000FF"));
        canvas.drawRect(0, 0, width / 2 - width / 4 + width / 12, height, paint);
        paint.setColor(Color.parseColor("#FF0000"));
        canvas.drawRect(width / 2 - width / 4 + width / 12 + 5, 0, width, height, paint);
        LinearLayout ll = (LinearLayout) findViewById(R.id.rect);
        ll.setBackgroundDrawable(new BitmapDrawable(bg));
    }

}
