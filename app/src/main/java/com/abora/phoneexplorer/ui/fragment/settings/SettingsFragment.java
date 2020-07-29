package com.abora.phoneexplorer.ui.fragment.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.abora.phoneexplorer.R;
import com.abora.phoneexplorer.util.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingsFragment extends Fragment implements View.OnClickListener {


    @BindView(R.id.edMaxNum)
    EditText edMaxNum;
    @BindView(R.id.btnSave)
    Button btnSave;

    SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        ButterKnife.bind(this, view);
        btnSave.setOnClickListener(this);
        SharedPreferences sharedpreferences = getContext().getSharedPreferences(Constants.MyPREFERENCES, Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();

        return view;
    }

    @Override
    public void onClick(View v) {
        int n = 10;
        String s = edMaxNum.getText().toString();
        if (s.equals(null) || s.equals("")) {
            Toast.makeText(getContext(), "please Enter Number", Toast.LENGTH_SHORT).show();
        } else {
            n = Integer.parseInt(s);
            if (n < 1 || n > 100) {
                Toast.makeText(getContext(), "Enter number between 1 and 100", Toast.LENGTH_SHORT).show();
                edMaxNum.setText("");
            }else {
                Toast.makeText(getContext(), "Saving", Toast.LENGTH_SHORT).show();
                editor.putInt(Constants.LIMIT, n);
                editor.commit();
            }
        }

    }
}