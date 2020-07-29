package com.abora.phoneexplorer.ui.fragment.compare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.abora.phoneexplorer.R;
import com.abora.phoneexplorer.model.PhoneResponse;
import com.abora.phoneexplorer.ui.fragment.explore.PhoneAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CompareFragment extends Fragment implements View.OnClickListener {


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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_compare, container, false);
        ButterKnife.bind(this, view);
        compareViewModel = ViewModelProviders.of(this).get(CompareViewModel.class);
        ivSearch.setOnClickListener(this);
        initRecycle();
        return view;
    }

    private void initRecycle() {
        phoneAdapter = new PhoneAdapter(getActivity(), true);
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
        compareViewModel.getPhones(deviceName);
        compareViewModel.phoneResponseMutableLiveData.observe(getActivity(), new Observer<List<PhoneResponse>>() {
            @Override
            public void onChanged(List<PhoneResponse> phoneResponses) {
                progressPhone.setVisibility(View.GONE);
                phoneAdapter.setList(phoneResponses);
            }
        });
    }
}