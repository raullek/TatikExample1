package com.example.xiaomi.tatikexample1;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class EditFragment extends Fragment {
    OnFragmentInteraction mListener;
    private static final String TAG = "EditFragment";
    EditText editFirstName,editLastName;
    Button sendBtn;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.edit_fragment,container,false);
        Log.d(TAG, "onCreateView: started");
        editFirstName = (EditText)view.findViewById(R.id.edit_first_name);
        editLastName = (EditText)view.findViewById(R.id.edit_last_name);
        sendBtn = (Button) view.findViewById(R.id.send_btn);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendingData();

            }
        });
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (OnFragmentInteraction) context;
    }

    private void sendingData () {
        Log.d(TAG, "sendingData: sending");
        String firstName = editFirstName.getText().toString();
        String lastName = editLastName.getText().toString();
        User user = new User(firstName,lastName);
        mListener.onFragmentInteraction(user);
    }
}
