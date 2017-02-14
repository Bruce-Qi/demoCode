package wwtao.demo.demo_activityrouter.activities;

import com.chenenyu.router.annotation.Route;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import wwtao.demo.demo_activityrouter.R;

/**
 * Created by wangweitao04 on 17/2/8.
 */
@Route({"detail", "http://mall/detail?{code}&{ua}&{city}"})
public class ActivityC extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        TextView mTextView = (TextView) findViewById(R.id.activityNormalTv);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("code:" + bundle.getString("code") + "\n");
            stringBuilder.append("ua:" + bundle.getString("ua") + "\n");
            stringBuilder.append("city:" + bundle.getString("city") + "\n");
            mTextView.setText(stringBuilder.toString());
        }
    }

    public void onClickReturn(View view) {
        finish();
    }

    public void onClickSetResultOk(View view) {
        setResult(RESULT_OK);
        finish();
    }
}
