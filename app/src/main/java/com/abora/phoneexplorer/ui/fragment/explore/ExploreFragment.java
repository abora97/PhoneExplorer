package com.abora.phoneexplorer.ui.fragment.explore;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.abora.phoneexplorer.R;
import com.abora.phoneexplorer.model.PhoneResponse;
import com.abora.phoneexplorer.util.Constants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExploreFragment extends Fragment {
    private static final String TAG = "ExploreFragment";
    int callLimited,updateLimited;
    @BindView(R.id.recPhone)
    RecyclerView recPhone;
    @BindView(R.id.progressPhone)
    ProgressBar progressPhone;
    private RecyclerView.LayoutManager layoutManager;
    private PhoneAdapter phoneAdapter;
    ExploreViewModel exploreViewModel;

    int countList = 10;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore, container, false);
        ButterKnife.bind(this, view);
        exploreViewModel = ViewModelProviders.of(this).get(ExploreViewModel.class);

        SharedPreferences sharedpreferences = getContext().getSharedPreferences(Constants.MyPREFERENCES, Context.MODE_PRIVATE);
        callLimited = sharedpreferences.getInt(Constants.LIMIT, 10);
        updateLimited = sharedpreferences.getInt(Constants.UPDATE_LIMITED, 10);

        initRecycle();
        checkBottomRecycle(updateLimited);
        init(callLimited);
        return view;
    }

    private void checkBottomRecycle(int updateLimited) {
        recPhone.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (!recyclerView.canScrollVertically(1)) {
                    exploreViewModel.getPhones(countList);
                    progressPhone.setVisibility(View.VISIBLE);
                    exploreViewModel.phoneResponseMutableLiveData.observe(getActivity(), new Observer<List<PhoneResponse>>() {
                        @Override
                        public void onChanged(List<PhoneResponse> phoneResponses) {
                            progressPhone.setVisibility(View.INVISIBLE);
                            phoneAdapter.setList(phoneResponses);
                        }
                    });
                    countList= countList+updateLimited;
                }
            }
        });
    }

    private void init(int phoneLimit) {
        exploreViewModel.getPhones(phoneLimit);
        exploreViewModel.phoneResponseMutableLiveData.observe(getActivity(), new Observer<List<PhoneResponse>>() {
            @Override
            public void onChanged(List<PhoneResponse> phoneResponses) {
                progressPhone.setVisibility(View.INVISIBLE);
                phoneAdapter.setList(phoneResponses);
            }
        });
    }

    private void initRecycle() {
        phoneAdapter = new PhoneAdapter(getActivity(), false);
        recPhone.setLayoutManager(getLayoutManager());
        recPhone.setAdapter(phoneAdapter);
    }

    private RecyclerView.LayoutManager getLayoutManager() {
        if (layoutManager == null) {
            layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        }
        return layoutManager;
    }

}