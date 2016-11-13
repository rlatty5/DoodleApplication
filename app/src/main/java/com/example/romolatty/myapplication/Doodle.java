package com.example.romolatty.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.ColorInt;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.thebluealliance.spectrum.SpectrumPalette;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by romolatty on 11/10/16.
 */

public class Doodle extends View {

    private Paint brush = new Paint();
    private Path path = new Path();
    Context context;
    public String size = "";
    public String redStr = "";
    public String greenStr = "";
    public String blueStr = "";
    ArrayList<Path> list = new ArrayList<Path>();

    public Doodle(Context context){
      super(context);
        this.context = context;
        init(null, 0);
    }

    public Doodle(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        this.context = context;
        init(attributeSet, 0);
    }

    public Doodle(Context context, AttributeSet attributeSet, int defStyle){
        super(context, attributeSet, defStyle);
        this.context = context;
        init(attributeSet, defStyle);
    }

    private void init(AttributeSet attributeSet, int defStyle){
        brush.setColor(Color.RED);
        brush.setStyle(Paint.Style.STROKE);
        brush.setAntiAlias(true);
    }

    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        //canvas.drawline(0, 0, getWidth(), getHeight(), brush);
        //canvas.drawLine(0,0,getWidth(),getHeight(), brush);
        canvas.drawPath(path, brush);
    }

    public boolean onTouchEvent(MotionEvent motionEvent){

        float xMotion = motionEvent.getX();
        float yMotion = motionEvent.getY();

        switch(motionEvent.getAction()){

            case MotionEvent.ACTION_UP:
                path.moveTo(xMotion,yMotion);
                break;
            case MotionEvent.ACTION_DOWN:
                path.moveTo(xMotion,yMotion);
                break;

            case MotionEvent.ACTION_MOVE:
                path.lineTo(xMotion, yMotion);

                break;
        }


        invalidate();
        return true;
    }

    public void increaseSize(){
        System.out.println("Working");
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Set Size of Brush (example 10, 20, ... 100)");

// Set up the input
        final EditText input = new EditText(this.context);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

// Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                size = input.getText().toString();
                System.out.println(size);
                brush.setStrokeWidth(Float.parseFloat(size));
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();


    }

    public void chooseColor(){
        System.out.println("Working");
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Set Color of Paint (example Red, Blue, Green: 21 44 55)");

        Context context = this.context;
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);




// Set up the input
        final EditText red = new EditText(this.context);
        red.setHint("red");
        final EditText blue = new EditText(this.context);
        blue.setHint("blue");
        final EditText green = new EditText(this.context);
        green.setHint("green");
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        red.setInputType(InputType.TYPE_CLASS_NUMBER);
        layout.addView(red);

        blue.setInputType(InputType.TYPE_CLASS_NUMBER);
        layout.addView(blue);

        green.setInputType(InputType.TYPE_CLASS_NUMBER);
        layout.addView(green);

        builder.setView(layout);


// Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                redStr = red.getText().toString();
                blueStr = blue.getText().toString();
                greenStr = green.getText().toString();
               // System.out.println(size);

                brush.setColor(Color.rgb(Integer.parseInt(redStr),
                        Integer.parseInt(blueStr),Integer.parseInt(greenStr)));
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();


    }



    public void changeOpacity(){
        System.out.println("Working");
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setTitle("Set Color of Paint (example Red, Blue, Green: 21 44 55)");

        Context context = this.context;
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);




// Set up the input
        final EditText red = new EditText(this.context);
        red.setHint("red");
        final EditText blue = new EditText(this.context);
        blue.setHint("blue");
        final EditText green = new EditText(this.context);
        green.setHint("green");
        final EditText opacity = new EditText(this.context);
        opacity.setHint("opacity");
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        red.setInputType(InputType.TYPE_CLASS_NUMBER);
        layout.addView(red);

        blue.setInputType(InputType.TYPE_CLASS_NUMBER);
        layout.addView(blue);

        green.setInputType(InputType.TYPE_CLASS_NUMBER);
        layout.addView(green);

        opacity.setInputType(InputType.TYPE_CLASS_NUMBER);
        layout.addView(opacity);

        builder.setView(layout);


// Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                redStr = red.getText().toString();
                blueStr = blue.getText().toString();
                greenStr = green.getText().toString();
                // System.out.println(size);


                brush.setColor(Color.argb(Integer.parseInt(opacity.getText().toString()),Integer.parseInt(redStr),
                        Integer.parseInt(blueStr),Integer.parseInt(greenStr)));
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();


    }

    public void clear(){
        path.reset();

    }
    public void undo(){
        path.rewind();
    }

    public void randomColor(){
        Random rn = new Random();
        int red = rn.nextInt(1000);
        int green = rn.nextInt(1000);
        int blue = rn.nextInt(1000);

       brush.setColor(Color.rgb(red, green, blue));
        System.out.println(red);
    }



}
