package demo.minifly.com.newandroidframe.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import demo.minifly.com.newandroidframe.R;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.main_activity_txtid)
    TextView mainActivityTxtid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.main_activity_txtid)
    public void onClick() {

    }
}
