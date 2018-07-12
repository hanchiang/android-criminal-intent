package com.example.han.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {
    private static final String TAG = "crime_activity";
    private static final String EXTRA_CRIME_ID = "com.example.han.criminalintent.crime_id";
    private static final String EXTRA_CRIME_POSITION = "com.example.han.criminalintent.crime_position";

    public static Intent newIntent(Context packageContext, UUID crimeId, int position) {
        Intent intent = new Intent(packageContext, CrimeActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);
        intent.putExtra(EXTRA_CRIME_POSITION, position);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        int position = getIntent().getIntExtra(EXTRA_CRIME_POSITION, 0);
        return CrimeFragment.newInstance(crimeId, position);
    }
}
