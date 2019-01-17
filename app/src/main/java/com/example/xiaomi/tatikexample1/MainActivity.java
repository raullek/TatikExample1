package com.example.xiaomi.tatikexample1;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity  implements OnFragmentInteraction{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragment();


    }

    private void initFragment () {
        EditFragment editFragment = new EditFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, editFragment);
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(User user) {
        TextFragment textFragment = new TextFragment();

        Bundle args = new Bundle();
        args.putParcelable("userKey",user);
        textFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, textFragment);
        transaction.commit();

    }
}
