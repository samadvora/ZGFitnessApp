package com.example.zgfitness;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentItem extends Fragment implements AdapterView.OnItemClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Taking the XML Layout and parsing it to create a View.
        View view = inflater.inflate(R.layout.fragment_item, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Adding Data to the String Array.
        String[] shows = {"Open 24 Hours", "Weight Training", "Spinning Studio", "Zumba Aerobics", "Functional Training Area", "Steam & Sauna Rooms", "Yoga Classes", "Aerobics Classes", "Personal Training"};

        ListView listView = (ListView) view.findViewById(R.id.list);

        //Using ArrayAdapter to fill data in the UI component.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_expandable_list_item_1, shows);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    //Showing a Toast message on Click.
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
    {
        Intent intent = new Intent(getActivity(), MembershipList.class);
        startActivity(intent);
    }
}
