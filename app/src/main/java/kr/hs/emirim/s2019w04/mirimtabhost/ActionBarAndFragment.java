package kr.hs.emirim.s2019w04.mirimtabhost;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class ActionBarAndFragment extends AppCompatActivity {
    ActionBar.Tab tabJun, tabJi, tabYo; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
        tabJun = bar.newTab();
        tabJun.setText("김준규");
        tabJun.setTabListener(tabListener);
        bar.addTab(tabJun);

        tabJi = bar.newTab();
        tabJi.setText("박지훈");
        tabJi.setTabListener(tabListener);
        bar.addTab(tabJi);

        tabYo = bar.newTab();
        tabYo.setText("요시");
        tabYo.setTabListener(tabListener);
        bar.addTab(tabYo);
    }

    MyFragment myFrags[] = new MyFragment[3];

    ActionBar.TabListener tabListener = new ActionBar.TabListener() {
        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            MyFragment myFrag = null;
            if(myFrags[tab.getPosition()] == null){
                myFrag = new MyFragment();
                Bundle data = new Bundle();
                data.putString("tabName", tab.getText().toString());
                myFrag.setArguments(data);
                myFrags[tab.getPosition()] = myFrag;
            }else{
                myFrag = myFrags[tab.getPosition()];
            }

            ft.replace(android.R.id.content, myFrag);
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
        }
    };

    public static class MyFragment extends Fragment{
        String tabName;

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle data = getArguments();
            tabName = data.getString("tabName");
        }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInState) {
        LinearLayout linear = new LinearLayout(super.getActivity());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        linear.setLayoutParams(params);
        linear.setOrientation(LinearLayout.VERTICAL);
        if(tabName.equals("김준규"))
            linear.setBackgroundColor(Color.RED);
        if(tabName.equals("박지훈"))
            linear.setBackgroundColor(Color.YELLOW);
        if(tabName.equals("요시"))
            linear.setBackgroundColor(Color.BLUE);

        return linear;
    }
}
}