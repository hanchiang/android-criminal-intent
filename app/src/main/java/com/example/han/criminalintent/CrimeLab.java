package com.example.han.criminalintent;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

// Singleton
public class CrimeLab {
    private static final String TAG = "crimelab";

    private static CrimeLab sCrimeLab;
    private List<Crime> mCrimes;
    private LinkedHashMap<UUID, Crime> mCrimesMap;

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
        mCrimesMap = new LinkedHashMap<>();
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0);
            crime.setRequiresPolice(i % 2 == 0);
            mCrimes.add(crime);
            mCrimesMap.put(crime.getId(), crime);
        }
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {
        return mCrimesMap.get(id);
    }
}
