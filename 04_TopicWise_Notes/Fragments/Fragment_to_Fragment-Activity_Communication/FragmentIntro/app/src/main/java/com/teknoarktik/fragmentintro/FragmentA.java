package com.teknoarktik.fragmentintro;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentA extends Fragment {
    private FragmentAListener listener;
    private EditText editText;
    private Button button;

    public interface FragmentAListener {
        void onInputASent(CharSequence input);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a,container,false);
        editText = view.findViewById(R.id.FragmentA_edit_textInput);
        button = view.findViewById(R.id.FragmentA_btn_ok);
        button.setOnClickListener( v->{
            CharSequence in = editText.getText();
            listener.onInputASent(in);
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if( context instanceof FragmentAListener )
            listener = (FragmentAListener)context;
        else
            throw new RuntimeException(context + " must implement FragmentBListener");

    }

    public void updateEditText(CharSequence text){
        editText.setText(text);
    }

    @Override
    public void onDetach() {
        super.onDetach();

        listener = null;
    }
}
