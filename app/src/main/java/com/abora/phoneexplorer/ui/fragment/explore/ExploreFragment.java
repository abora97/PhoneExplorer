package com.abora.phoneexplorer.ui.fragment.explore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.abora.phoneexplorer.R;
import com.abora.phoneexplorer.model.PhoneResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExploreFragment extends Fragment {
    private static final String TAG = "ExploreFragment";

    @BindView(R.id.recPhone)
    RecyclerView recPhone;
    @BindView(R.id.progressPhone)
    ProgressBar progressPhone;
    private RecyclerView.LayoutManager layoutManager;
    private PhoneAdapter phoneAdapter;
    ExploreViewModel exploreViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore, container, false);
        ButterKnife.bind(this, view);
        exploreViewModel = ViewModelProviders.of(this).get(ExploreViewModel.class);
        initRecycle();
        init();
        return view;
    }

    private void init() {
        exploreViewModel.getPhones();
        exploreViewModel.phoneResponseMutableLiveData.observe(getActivity(), new Observer<List<PhoneResponse>>() {
            @Override
            public void onChanged(List<PhoneResponse> phoneResponses) {
                progressPhone.setVisibility(View.GONE);
                phoneAdapter.setList(phoneResponses);
            }
        });

    }

    private void initRecycle() {
        phoneAdapter = new PhoneAdapter(getActivity());
        recPhone.setLayoutManager(getLayoutManager());
        recPhone.setAdapter(phoneAdapter);
    }

    private RecyclerView.LayoutManager getLayoutManager() {
        if (layoutManager == null) {
            //   layoutManager = new LinearLayoutManager(getActivity());
            layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        }
        return layoutManager;
    }

}