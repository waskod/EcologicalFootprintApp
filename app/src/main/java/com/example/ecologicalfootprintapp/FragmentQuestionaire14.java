package com.example.ecologicalfootprintapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FragmentQuestionaire14 extends Fragment {
    private static final String TAG = "FragmentQ14";

    private Button backButton, nextButton;
    private Spinner answerSpinner;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_q14_layout, container, false);
        Log.d(TAG, "onCreateView: started.");

        backButton = (Button) view.findViewById(R.id.back14);
        nextButton = (Button) view.findViewById(R.id.next14);

        answerSpinner = (Spinner) view.findViewById(R.id.answerSpinner);


        List<String> spinnerOptions = new ArrayList<>();
        spinnerOptions.add("Select an option");
        spinnerOptions.add("0 miles");
        spinnerOptions.add("50 miles");
        spinnerOptions.add("100 miles");
        spinnerOptions.add("150 miles");
        spinnerOptions.add("200 miles");
        spinnerOptions.add("250 miles");
        spinnerOptions.add("300 miles");
        spinnerOptions.add("350 miles");
        spinnerOptions.add("400 miles");
        spinnerOptions.add("450 miles");
        spinnerOptions.add("500 miles");








        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, spinnerOptions);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        answerSpinner.setAdapter(spinnerAdapter);

        answerSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemvalue = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).questionaire.setQ14(answerSpinner.getSelectedItemPosition());
                ((MainActivity)getActivity()).setViewPager(17);

            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).questionaire.setQ14(answerSpinner.getSelectedItemPosition());
                ((MainActivity)getActivity()).setViewPager(19);

            }
        });

        // update the value in the spinner
        resetSpinner();

        return view;
    }

    // helper class that changes the selected item if the question has already been completed
    public void resetSpinner()
    {
        int spinnerAnswer = ((MainActivity)getActivity()).questionaire.getQ14();
        //Toast.makeText(getActivity(), "Value is: "+spinnerAnswer, Toast.LENGTH_LONG);
        answerSpinner.setSelection(spinnerAnswer);
    }
}
