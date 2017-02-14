package wwtao.demo.demo_activityrouter;

import com.chenenyu.router.RouteCallback;
import com.chenenyu.router.Router;
import com.jakewharton.rxbinding.widget.RxTextView;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import wwtao.demo.demo_activityrouter.activities.ActivityF;


public class MainActivity extends AppCompatActivity {
    @BindView(R.id.mainActivityEt)
    EditText etAddress;
    @BindView(R.id.mainActivityEtRequestCode)
    EditText etRequestCode;

    @BindView(R.id.mainActivityBtnGotoCustom)
    Button btnGotoCustom;
    @BindView(R.id.mainActivityBtnGotoCustomForResult)
    Button btnGotoCustomForResult;
    @BindView(R.id.mainActivityBtnGotoBaiDu)
    Button btnGotoBaidu;
    @BindView(R.id.mainActivityBtnGonfig)
    Button btnGotoConfig;
    @BindView(R.id.mainActivityBtnGotoOriginImplicit)
    Button btnGotoOriginImplicit;
    @BindView(R.id.mainActivityBtnGotoImplicit)
    Button btnGotoImplicit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        RxTextView.textChanges(etAddress).subscribe(charSequence -> {
            btnGotoCustom.setText(String.format("startActivity:%s", etAddress.getText().toString()));
            btnGotoCustomForResult.setText(String.format("startActivityFroResult:%s", etAddress.getText().toString()));
        });
        btnGotoCustom.setOnClickListener(v -> Router.build(etAddress.getText().toString())
                .callback(mRouteCallback).go(this));

        btnGotoCustomForResult.setOnClickListener(v -> {
            Router.build(etAddress.getText().toString())
                    .callback(mRouteCallback)
                    .requestCode(Integer.valueOf(etRequestCode.getText().toString())).go(this);
//            Intent intent = new Intent();
//            intent.setClass(this, ActivityA.class);
//            startActivity(intent);
        });

        btnGotoBaidu.setOnClickListener(v -> Router.build("http://www.baidu.com").callback(mRouteCallback).go(this));

        Router.addRouteTable(map -> map.put("configRoute", ActivityF.class));
        btnGotoConfig.setOnClickListener(v -> Router.build("configRoute").go(this));

        btnGotoOriginImplicit.setOnClickListener(v ->
                Router.build("wwtao://implicit1?arg1=value1&arg2=value2&arg3=value3").go(this));

        btnGotoImplicit.setOnClickListener(v -> Router.build("wwtao://implicit2?arg1=value1&arg2=value2&arg3=value3")
                .go(this));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "activity set result canceled", Toast.LENGTH_LONG).show();
        } else if (resultCode == RESULT_OK) {
            Toast.makeText(this, "activity set result OK with requestCode:" + requestCode, Toast.LENGTH_LONG).show();
        }
    }

    RouteCallback mRouteCallback = new RouteCallback() {
        @Override
        public void succeed(Uri uri) {
        }

        @Override
        public void error(Uri uri, String message) {
            Toast.makeText(MainActivity.this, String.format("uri:%s is error!", uri), Toast.LENGTH_LONG)
                    .show();
        }
    };
}
