package com.example.Eric_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    RadioGroup radioGroup;
    private PaintView paintView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //建立paintview，所有繪圖行為都在上面執行
        paintView = findViewById(R.id.PaintView);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        paintView.init(metrics);

        radioGroup = findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(this);
    }

    //建立選單
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //建立選單選擇事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int res_id = item.getItemId();
        if (res_id == R.id.action_dot) {
            Toast.makeText(getApplicationContext(), "You select dot", Toast.LENGTH_LONG).show();
        }

        int id = item.getItemId();
        switch (id){
            case R.id.action_element1:
                Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_element2:
                Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_element3:
                Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
        }

        /*switch (item.getItemId()) {
            case R.id.action_element:
                break;
            case R.id.action_ele1:
                Toast.makeText(getApplicationContext(), "ele1", Toast.LENGTH_LONG).show();
            case R.id.action_ele2:
                Toast.makeText(getApplicationContext(), "ele2", Toast.LENGTH_LONG).show();
            case R.id.action_ele3:
                Toast.makeText(getApplicationContext(), "ele3", Toast.LENGTH_LONG).show();

        }*/
                switch (item.getItemId()) {
                    case R.id.Array:
                        Intent intent = new Intent(this, ArrayOutput.class);
                        intent.putExtra("points", paintView.points());
                        startActivity(intent);
                        return true;
                    case R.id.clear:
                        paintView.clear();
                        return true;

                }
                return super.onOptionsItemSelected(item);

        }
            @Override
            public void onCheckedChanged (RadioGroup radioGroup,int i){
                if (radioGroup.getCheckedRadioButtonId() == R.id.radioButton1) {
                    paintView.drawDot();
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.radioButton2) {
                    paintView.setElement();
                } else {
                }
            }
        }
