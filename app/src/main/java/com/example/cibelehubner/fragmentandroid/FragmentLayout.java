package com.example.cibelehubner.fragmentandroid;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

/**
 * Created by CIBELE HUBNER on 25/05/2017.
 */

public class FragmentLayout extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_layout);
    }






    public boolean isMultiPane() {
        return getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;
    }

    public void showDetails(int index) {
        if (isMultiPane()) {
            DetailsFragment details = (DetailsFragment) getFragmentManager()
                    .findFragmentById(R.id.details);

            if (details == null || details.getShownIndex() != index) {
                details = DetailsFragment.newInstance(index);

                FragmentTransaction ft = getFragmentManager()
                        .beginTransaction();
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.replace(R.id.details, details);
                ft.addToBackStack("details");
                ft.commit();
            }
        } else {
            Intent intent = new Intent();
            intent.setClass(this, DetailsActivity.class);
            intent.putExtra("index", index);
            startActivity(intent);
        }
    }
}