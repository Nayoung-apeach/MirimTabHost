package kr.hs.emirim.s2019w04.mirimtabhost;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabSpecJun = tabHost.newTabSpec("Jun").setIndicator("김준규");
        tabSpecJun.setContent(R.id.linear_jun);
        tabHost.addTab(tabSpecJun);

        TabHost.TabSpec tabSpecJi = tabHost.newTabSpec("Jun").setIndicator("박지훈");
        tabSpecJi.setContent(R.id.linear_ji);
        tabHost.addTab(tabSpecJi);

        TabHost.TabSpec tabSpecYo = tabHost.newTabSpec("Jun").setIndicator("요시");
        tabSpecYo.setContent(R.id.linear_yo);
        tabHost.addTab(tabSpecYo);

        tabHost.setCurrentTab(0);
    }
}