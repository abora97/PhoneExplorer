package com.abora.phoneexplorer.ui.activity.main;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.abora.phoneexplorer.R;
import com.abora.phoneexplorer.model.PhoneResponse;
import com.abora.phoneexplorer.ui.fragment.compare.CompareFragment;
import com.abora.phoneexplorer.ui.fragment.explore.ExploreFragment;
import com.abora.phoneexplorer.ui.fragment.settings.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);
        openFragment(new ExploreFragment(), "home");
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.navHome:
                openFragment(new ExploreFragment(), "home");
                break;
            case R.id.navCompare:
                openFragment(new CompareFragment(), "CompareFragment");
                break;
            case R.id.navSettings:
                openFragment(new SettingsFragment(), "SettingsFragment");
                break;
        }
        return true;
    }

    private void openFragment(Fragment fragment, String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.findFragmentByTag(tag) == null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.nav_host_fragment, fragment, tag).commit();
        }
        List<Fragment> fragments = fragmentManager.getFragments();
        Log.e("Fragments Quantity", String.valueOf(fragments.size()));
       // removeFragments(fragments);
        fragmentManager.beginTransaction().show(fragment).commit();

    }


}