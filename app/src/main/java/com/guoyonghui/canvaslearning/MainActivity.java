package com.guoyonghui.canvaslearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.guoyonghui.canvaslearning.view.StatisticsView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.statistics)
    StatisticsView mStatisticsView;

    @BindView(R.id.show_base)
    Button mBaseButton;

    @BindView(R.id.show_top)
    Button mTopButton;

    @BindView(R.id.show_bottom)
    Button mBottomButton;

    @BindView(R.id.show_ascent)
    Button mAscentButton;

    @BindView(R.id.show_descent)
    Button mDescentButton;

    @BindView(R.id.show_text)
    Button mTextButton;

    @BindView(R.id.reset)
    Button mResetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick({R.id.show_base, R.id.show_top, R.id.show_bottom, R.id.show_ascent, R.id.show_descent, R.id.show_text, R.id.reset})
    public void onClick(View view) {
        if(view == mBaseButton) {
            mStatisticsView.drawBaseline();
        } else if(view == mTopButton) {
            mStatisticsView.drawTop();
        } else if(view == mBottomButton) {
            mStatisticsView.drawBottom();
        } else if(view == mAscentButton) {
            mStatisticsView.drawAscent();
        } else if(view == mDescentButton) {
            mStatisticsView.drawDescent();
        } else if(view == mTextButton) {
            mStatisticsView.drawText("Hello World! 比利");
        } else if(view == mResetButton) {
            mStatisticsView.reset();
        }
    }
}
