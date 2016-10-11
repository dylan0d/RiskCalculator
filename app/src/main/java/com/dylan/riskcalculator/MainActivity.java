package com.dylan.riskcalculator;

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

public class MainActivity extends AppCompatActivity {

    public int intAttackers = 0;
    public int intDefenders = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        EditText numAttackers = (EditText)findViewById(R.id.numAttackers);
        EditText numDefenders = (EditText)findViewById(R.id.numDefenders);
        String attackers = numAttackers.getText().toString();
        String defenders = numDefenders.getText().toString();


        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;
        int width = displaymetrics.widthPixels;

     /*   View barChartView = new BarChart(this);
        setContentView(barChartView);
        barChartView.setBackgroundColor(Color.WHITE);*/

        Paint paint = new Paint();
        Bitmap bg = Bitmap.createBitmap(480, 800, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bg);
        paint.setColor(Color.parseColor("#0000FF"));
        canvas.drawRect(0, 0, width / 2 - width / 4 + width / 12, height, paint);
        paint.setColor(Color.parseColor("#FF0000"));
        canvas.drawRect(width/2-width/4+width/12 +5, 0, width, height, paint);

        LinearLayout ll = (LinearLayout) findViewById(R.id.rect);
        ll.setBackgroundDrawable(new BitmapDrawable(bg));


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText numAttackers = (EditText)findViewById(R.id.numAttackers);
                EditText numDefenders = (EditText)findViewById(R.id.numDefenders);
                Snackbar.make(view, R.string.numbersreset, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                numAttackers.setText("", TextView.BufferType.EDITABLE);
                numDefenders.setText("", TextView.BufferType.EDITABLE);
            }
        });
    }

    public void oneEach(View view)
    {
        EditText numAttackers = (EditText)findViewById(R.id.numAttackers);
        EditText numDefenders = (EditText)findViewById(R.id.numDefenders);
        String attackers = numAttackers.getText().toString();
        String defenders = numDefenders.getText().toString();
        if(!defenders.equals("") && !attackers.equals("") && isNumeric(defenders) && isNumeric(attackers)) {
            numAttackers.setText(Integer.toString(Integer.parseInt(attackers) - 1));
            numDefenders.setText(Integer.toString(Integer.parseInt(defenders) - 1));
            if (numDefenders.getText().toString().equals("0")){
                dLoss();
            }
            if (numAttackers.getText().toString().equals("0")){
                aLoss();
            }
        }
        else
        {
            Snackbar.make(view, R.string.wronggeneral, Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }

    }

    public void attackersLose(View view)
    {
        EditText numAttackers = (EditText)findViewById(R.id.numAttackers);
        String attackers = numAttackers.getText().toString();
        if(!attackers.equals("") && isNumeric(attackers))
        {
            numAttackers.setText(Integer.toString(Integer.parseInt(attackers) - 2));
            if (numAttackers.getText().toString().equals("0")){
                aLoss();
            }
        }
        else
        {
            Snackbar.make(view, R.string.wrongattack, Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }

    public void defendersLose(View view)
    {
        EditText numDefenders = (EditText)findViewById(R.id.numDefenders);
        String defenders = numDefenders.getText().toString();
        if(!defenders.equals("")&&isNumeric(defenders))
        {
            numDefenders.setText(Integer.toString(Integer.parseInt(defenders)-2));
            if (numDefenders.getText().toString().equals("0")){
                dLoss();
            }
        }
        else
        {
            Snackbar.make(view, R.string.wrongdefence, Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }

    public void defendersLose1(View view)
    {
        EditText numDefenders = (EditText)findViewById(R.id.numDefenders);
        String defenders = numDefenders.getText().toString();
        if(!defenders.equals("")&&isNumeric(defenders))
        {
            numDefenders.setText(Integer.toString(Integer.parseInt(defenders)-1));
            if (numDefenders.getText().toString().equals("0")){
                dLoss();
            }
        }
        else
        {
            Snackbar.make(view, R.string.wrongdefence, Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }

    public void attackersLose1(View view)
    {
        EditText numAttackers = (EditText)findViewById(R.id.numAttackers);
        String attackers = numAttackers.getText().toString();
        if(!attackers.equals("") && isNumeric(attackers))
        {
            numAttackers.setText(Integer.toString(Integer.parseInt(attackers) - 1));
            if (numAttackers.getText().toString().equals("0")){
                aLoss();
            }
        }
        else
        {
            Snackbar.make(view, R.string.wrongattack, Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }

    public void dLoss()
    {
        EditText numDefenders = (EditText)findViewById(R.id.numDefenders);
        EditText numAttackers = (EditText)findViewById(R.id.numAttackers);
        numDefenders.setText(R.string.defenderslosefinal);
        numAttackers.setText(R.string.attackerswinfinal);
    }

    public void aLoss()
    {
        EditText numDefenders = (EditText)findViewById(R.id.numDefenders);
        EditText numAttackers = (EditText)findViewById(R.id.numAttackers);
        numDefenders.setText(R.string.defenderswinfinal);
        numAttackers.setText(R.string.attackerslosefinal);
    }

    public static boolean isNumeric(String str)
    {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
}
