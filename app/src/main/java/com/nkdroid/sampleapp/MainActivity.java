package com.nkdroid.sampleapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    private ImageView logo;
    private Bitmap borderPatern;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = (ImageView) findViewById(R.id.logo);
        borderPatern= BitmapFactory.decodeResource(getResources(), R.drawable.pattern_02);
        BitmapDrawable drawable = (BitmapDrawable) logo.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        Bitmap bm1= mergeImages(bitmap);

        logo.setImageBitmap(bm1);
    }
    public Bitmap mergeImages(Bitmap paramBitmap)
    {
        if (borderPatern == null) {
            return paramBitmap;
        }
        Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth()+ 2*2, paramBitmap.getHeight() + 2*2 , paramBitmap.getConfig());
        Canvas localCanvas = new Canvas(localBitmap);
        Paint localPaint = new Paint();
        localPaint.setShader(new BitmapShader(borderPatern, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
        localCanvas.drawPaint(localPaint);
        localCanvas.drawBitmap(paramBitmap, 2, 2, null);
        return localBitmap;
    }
}
