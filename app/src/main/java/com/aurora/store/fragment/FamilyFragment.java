package com.aurora.store.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.aurora.store.R;
import com.aurora.store.activity.CategoriesActivity;
import com.aurora.store.view.FeaturedAppsView;
import com.google.android.material.chip.Chip;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FamilyFragment extends BaseFragment implements BaseFragment.EventListenerImpl {

    @BindView(R.id.bulk_layout)
    LinearLayout bulk_layout;
    @BindView(R.id.all_chip)
    Chip allChip;

    private Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_family, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bulk_layout.addView(new FeaturedAppsView(context, "Education", "FAMILY_EDUCATION"));
        bulk_layout.addView(new FeaturedAppsView(context, "Brain Games", "FAMILY_BRAINGAMES"));
        bulk_layout.addView(new FeaturedAppsView(context, "Creativity", "FAMILY_CREATE"));
        allChip.setOnClickListener(v -> {
            Intent intent = new Intent(context, CategoriesActivity.class);
            intent.putExtra("INTENT_CATEGORY", "FAMILY");
            context.startActivity(intent);
        });
    }

    @Override
    public void onLoggedIn() {

    }

    @Override
    public void onLoginFailed() {

    }

    @Override
    public void onNetworkFailed() {

    }
}