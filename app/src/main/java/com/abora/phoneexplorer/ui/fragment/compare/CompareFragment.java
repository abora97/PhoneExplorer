package com.abora.phoneexplorer.ui.fragment.compare;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.abora.phoneexplorer.R;
import com.abora.phoneexplorer.model.PhoneResponse;
import com.abora.phoneexplorer.ui.activity.compare.CompareActivity;
import com.abora.phoneexplorer.ui.fragment.explore.PhoneAdapter;
import com.abora.phoneexplorer.util.Constants;
import com.google.gson.Gson;

import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CompareFragment extends Fragment implements View.OnClickListener, PhoneAdapter.onItemsSelected {


    @BindView(R.id.recPhone)
    RecyclerView recPhone;
    @BindView(R.id.progressPhone)
    ProgressBar progressPhone;
    @BindView(R.id.editSearch)
    EditText editSearch;
    @BindView(R.id.ivSearch)
    ImageView ivSearch;
    private RecyclerView.LayoutManager layoutManager;
    private PhoneAdapter phoneAdapter;
    CompareViewModel compareViewModel;

    int countDevices = 0;
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;
    Gson gson;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_compare, container, false);
        ButterKnife.bind(this, view);
        compareViewModel = ViewModelProviders.of(this).get(CompareViewModel.class);
        ivSearch.setOnClickListener(this);
        init();
        initRecycle();
        return view;
    }

    private void init() {
        sharedpreferences = getContext().getSharedPreferences(Constants.COMPARE_PREFERENCES, Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
        gson = new Gson();
    }

    private void initRecycle() {
        phoneAdapter = new PhoneAdapter(getActivity(), true, this);
        recPhone.setLayoutManager(getLayoutManager());
        recPhone.setAdapter(phoneAdapter);

    }

    private RecyclerView.LayoutManager getLayoutManager() {
        if (layoutManager == null) {
            layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        }
        return layoutManager;
    }

    @Override
    public void onClick(View v) {
        String deviceName = editSearch.getText().toString();

        if (deviceName.equals(null) || deviceName.equals("")) {
            Toast.makeText(getContext(), "Please Enter Device Name", Toast.LENGTH_SHORT).show();
        } else {
            getDevices(deviceName);
        }
    }

    private void getDevices(String deviceName) {
        progressPhone.setVisibility(View.VISIBLE);
        compareViewModel.getPhones(deviceName);
        compareViewModel.phoneResponseMutableLiveData.observe(getActivity(), new Observer<List<PhoneResponse>>() {
            @Override
            public void onChanged(List<PhoneResponse> phoneResponses) {
                progressPhone.setVisibility(View.GONE);
                phoneAdapter.setList(phoneResponses);
            }
        });
    }


    @Override
    public void onItemChecked(PhoneResponse phoneResponse) {
        countDevices++;
        Toast.makeText(getContext(), "Add  Devices " + countDevices, Toast.LENGTH_SHORT).show();
        if (countDevices == 1) {
            editor.putString(Constants.DEVICE1, gson.toJson(phoneResponse));
            editor.commit();
        } else if (countDevices == 2) {
            editor.putString(Constants.DEVICE2, gson.toJson(phoneResponse));
            editor.commit();
            showFilterDialog();
        }
    }

    private void showFilterDialog() {
        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.dialog_compare);
        dialog.setCanceledOnTouchOutside(false);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);

        Button btnCancel = dialog.findViewById(R.id.btnCancel);
        Button btnOk = dialog.findViewById(R.id.btnOk);

        //btn
        btnCancel.setOnClickListener(v -> {
            countDevices = 0;
            dialog.dismiss();
        });

        btnOk.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), CompareActivity.class));
        });
        dialog.show();
    }
}