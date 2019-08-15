package com.teknoarktik.fragmentintro;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentB extends Fragment {
    private FragmentBListener listener;
    private EditText editText;
    private Button button;

    public interface FragmentBListener {
        void onInputBSent(CharSequence input);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b,container,false);

        editText = view.findViewById(R.id.FragmentB_edit_textInput);
        button = view.findViewById(R.id.FragmentB_btn_ok);
        button.setOnClickListener( v->{
            CharSequence in = editText.getText();
            listener.onInputBSent(in);
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if( context instanceof FragmentBListener)
            listener = (FragmentBListener)context;
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
