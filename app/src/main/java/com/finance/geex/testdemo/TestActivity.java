package com.finance.geex.testdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;


import com.finance.geex.testdemo.arithmetic.backtrack.NQueensProblem;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created on 2019/11/27 10:25.
 *
 * @author Geex302
 */
public class TestActivity extends AppCompatActivity {

    //UI
    private TextView tv_time;

    /**
     * 在还款中页面轮询状态7次，第一次轮询间隔5S，第二次间隔10S，第三次20S，40S，80S，160S，直到状态result_pay != PENDING
     */
    private int second = 5; //基础秒数
    private int time = 1; //次数
    //轮询
    private Timer timer;
    private TimerTask timerTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        //initIntent
        initIntent();

        //initView
        initView();

        //initListener
        initListener();

        //initData
        initData();

    }

    private void initData() {

//        RecursionMultiplication recursionMultiplication = new RecursionMultiplication();
//        int recursion = recursionMultiplication.multiplication(-5, -3);
//        Toast.makeText(this,String.valueOf(recursion),Toast.LENGTH_LONG).show();


//        int[] nums = {1,2};
//        BackTrackArithmetic backTrackArithmetic = new BackTrackArithmetic();
//        List<List<Integer>> permute = backTrackArithmetic.permute(nums);
//        Toast.makeText(this,String.valueOf(permute.size()),Toast.LENGTH_LONG).show();


        NQueensProblem nQueensProblem = new NQueensProblem();
        List<List<String>> lists = nQueensProblem.solveNQueens(8);
        List<String> list1 = lists.get(0);
        for (int i = 0; i < list1.size(); i++) {
            String s = list1.get(i);
            System.out.println(s);
        }
//        for (int i = 0; i < lists.size(); i++) {
//            List<String> list = lists.get(i);
//            for (int j = 0; j < list.size(); j++) {
//                String s = list.get(j);
//                System.out.println(s);
//            }
//            System.out.println();
//        }


//        timer = new Timer();
//
//
//        if (time < 7) { //轮询7次(包括初始化页面的那一次)
//            timerTask = new TimerTask() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(3 * 1000);
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                //主线程
//                                test();
//                            }
//                        });
//
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            };
//            timer.schedule(timerTask, second * 1000);
//            second = second * 2;
//            time++;
//        } else {
//            timer.cancel();
//            timer = null;
//        }

    }

    private void test() {

//        if (timer != null) {
//            //将原任务从队列中移除(timerTask只能一个),否则报错TimerTask is scheduled already
//            if (timerTask != null) {
//                timerTask.cancel();
//            }
//            if (time < 7) { //轮询7次(包括初始化页面的那一次)
//                timerTask = new TimerTask() {
//                    @Override
//                    public void run() {
//                        try {
//                            Thread.sleep(3 * 1000);
//                            test();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                };
//                timer.schedule(timerTask, second * 1000);
//                second = second * 2;
//                time++;
//                Log.d("wang", "test: "+time + "     " + second);
////                tv_time.setText(time + "     " + second);
//            } else {
//                timer.cancel();
//                timer = null;
//            }
//        }


    }

    private void initListener() {


    }

    private void initView() {

        tv_time = findViewById(R.id.tv_time);
        tv_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

    }

    private void initIntent() {


    }


}
