package com.example.xiaomi.tatikexample1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TextFragment extends Fragment {
    private static final String TAG = "TextFragment";
    TextView tvFirstName, tvLastName;
    private User mUser;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null){
            mUser = bundle.getParcelable("userKey");
            Log.d(TAG, "onCreate: incoming data");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.text_fragment,container,false);
        Log.d(TAG, "onCreateView: started");

        tvFirstName = (TextView) view.findViewById(R.id.text_view_firstname);
        tvLastName = (TextView) view.findViewById(R.id.text_view_lastname);

        tvFirstName.setText(mUser.getFirstName());
        tvLastName.setText(mUser.getLastName());

        return view;
    }
}
