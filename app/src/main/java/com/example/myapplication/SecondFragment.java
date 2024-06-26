package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.myapplication.databinding.FragmentSecondBinding;

import java.util.Random;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        int count = SecondFragmentArgs.fromBundle(getArguments()).getCount();
        String countText = getString(R.string.random_heading, count);
        TextView headerView = binding.textViewHeader;
        headerView.setText(countText);

        Random random = new java.util.Random();
        int randomNumber = 0;

        randomNumber = random.nextInt(count + 1);

        setCount(view, randomNumber);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    private void setCount(View v, int randomNumber){
        String count = String.valueOf(randomNumber);
        // Display the new value in the text view.
        binding.textViewRandom.setText("" + count);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}