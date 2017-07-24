package com.example.heber.w2d5_ex01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private ImageView iv_DisplayPhoto;
    private TextView tv_Name;
    private TextView tv_Lastname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        iv_DisplayPhoto = (ImageView) findViewById(R.id.iv_displayPicture);
        tv_Name = (TextView) findViewById(R.id.tv_Name);
        tv_Lastname = (TextView) findViewById(R.id.tv_Lastname);

        loadDetails();
    }

    private void loadDetails() {
        Intent intent = getIntent();
        if(intent != null){
            ImageDetail image_detail = intent.getParcelableExtra(MainActivity.MAIN_ACTIVITY_EXTRA);

            iv_DisplayPhoto.setImageBitmap(image_detail.getPhoto());
            tv_Name.setText(image_detail.getName());
            tv_Lastname.setText(image_detail.getLastname());
        }
    }
}
