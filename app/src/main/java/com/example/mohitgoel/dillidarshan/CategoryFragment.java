package com.example.mohitgoel.dillidarshan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mohitgoel.dillidarshan.adapters.CategoryListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mohit Goel on 14-Oct-18.
 */


public class CategoryFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    @BindView(R.id.fragment_recycler_view)
    RecyclerView mFragmentRecyclerView;

    private int mPage;

    public static CategoryFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        CategoryFragment fragment = new CategoryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
//        TextView textView = (TextView) view;
//        textView.setText("Fragment #" + mPage);
        ButterKnife.bind(this, view);

        mFragmentRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));
        CategoryListAdapter adapter = new CategoryListAdapter(getActivity());
        mFragmentRecyclerView.setAdapter(adapter);
        return view;
    }
}
