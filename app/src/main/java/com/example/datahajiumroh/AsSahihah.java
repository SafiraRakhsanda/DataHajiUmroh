package com.example.datahajiumroh;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

public class AsSahihah extends AppCompatActivity {

    private Context mContext;
    private RelativeLayout mRelative;
    private Button mButton;
    private PopupWindow mPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide2);

        mContext = getApplicationContext();
        mRelative = findViewById(R.id.rlassahihah);
        mButton = findViewById(R.id.assahihah1200);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
                View customView = inflater.inflate(R.layout.assahihah, null);

                mPopup = new PopupWindow(
                        customView,
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );

                if (Build.VERSION.SDK_INT >= 21) {
                    mPopup.setElevation(5.0f);
                }

                ImageButton closeButton = customView.findViewById(R.id.close5);
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPopup.dismiss();
                    }
                });

                mPopup.showAtLocation(mRelative, Gravity.CENTER, 0, 0);

            }
        });
    }

}
