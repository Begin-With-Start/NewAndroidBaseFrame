package demo.minifly.com.newandroidframe.activity;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import demo.minifly.com.newandroidframe.R;
import demo.minifly.com.newandroidframe.annotation.BindEventBus;
import demo.minifly.com.newandroidframe.base.BaseActivity;

@BindEventBus
public class MainActivity extends BaseActivity {


    @BindView(R.id.main_activity_txtid)
    TextView mainActivityTxtid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    @OnClick(R.id.main_activity_txtid)
    public void onClick() {

    }

}
