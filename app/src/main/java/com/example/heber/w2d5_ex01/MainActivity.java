package com.example.heber.w2d5_ex01;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 2;
    public static final String MAIN_ACTIVITY_EXTRA = "com.example.heber.w2d5_ex01.MAIN_ACTIVITY_EXTRA";
    private ImageView imageView;
    private Bitmap photo;
    private EditText et_Name;
    private EditText et_Lastname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.iv_displayPicture);
    }

    public void LaunchCamera(View view) {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }

    public void ToDetailsActivity(View view) {
        et_Name = (EditText) findViewById(R.id.et_name);
        et_Lastname = (EditText) findViewById(R.id.et_lastname);

        String name = et_Name.getText().toString();
        String lastname = et_Lastname.getText().toString();
        ImageDetail image_detail = new ImageDetail(photo, name, lastname);

        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra(MAIN_ACTIVITY_EXTRA, image_detail);
        startActivity(intent);
    }


}
