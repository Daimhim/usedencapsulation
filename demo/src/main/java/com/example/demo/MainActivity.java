package com.example.demo;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.used.baseadapter.ExpandableRecyclerAdapter;
import com.example.used.baseadapter.RecyclerAdapterClick;
import com.example.used.decoration.DecorationBuilder;
import com.example.used.decoration.LinearDecoration;
import com.example.used.toolset.Dimension;
import com.example.used.view.RadioGroupFlowLayout;
import com.example.xuyuan.adapter.BaseAdaptyer;

import java.util.ArrayList;
import java.util.List;

import static android.util.TypedValue.COMPLEX_UNIT_PX;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv_tonew;
    TextView tv_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_tonew = (TextView) findViewById(R.id.tv_tonew);
        tv_show = (TextView) findViewById(R.id.tv_show);
        tv_tonew.setOnClickListener(this);
        int pid = android.os.Process.myPid();//获取进程pid
        String processName = null;
        ActivityManager am = (ActivityManager)this.getSystemService(Context.ACTIVITY_SERVICE);//获取系统的ActivityManager服务
        for (ActivityManager.RunningAppProcessInfo appProcess : am.getRunningAppProcesses()){
            if(appProcess.pid == pid){
                processName = appProcess.processName;
                Log.i("zx_MainActivity","processName:"+processName);
                break;
            }
        }
        tv_show.setText(processName);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_tonew:
                startActivity(new Intent(this,DemoActivity.class));
                break;
        }
    }
}
