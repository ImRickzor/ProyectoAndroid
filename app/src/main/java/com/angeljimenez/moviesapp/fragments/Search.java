package com.angeljimenez.moviesapp.fragments;

        import android.os.Bundle;

        import androidx.fragment.app.Fragment;
        import androidx.fragment.app.FragmentTransaction;

        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import com.angeljimenez.moviesapp.R;
        import com.angeljimenez.moviesapp.databinding.FragmentSearchBinding;


public class Search extends Fragment implements View.OnClickListener {
    FragmentSearchBinding binding;
    public Search(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = FragmentSearchBinding.inflate(inflater,container, false);
        binding.rbOrdenar1.setOnClickListener(this);

        binding.rbOrdenar1.setChecked(true);
        mostrarOrdenar1();
        return binding.getRoot();

    }

    @Override
    public void onClick(View view) {
        mostrarOrdenar2();

    }

    private void mostrarOrdenar2() {
        VistaPelis2Fragment VistaPelis2Fragment = new VistaPelis2Fragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.contenedorPelis, VistaPelis2Fragment);
        transaction.commit();
    }

    private void mostrarOrdenar1() {
        VistaPelisProfileFragment VistaPelisProfileFragment = new VistaPelisProfileFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.contenedorPelis, VistaPelisProfileFragment);
        transaction.commit();
    }
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public static Search newInstance(String param1, String param2) {
        Search fragment = new Search();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    //@Override
    //public View onCreateView(LayoutInflater inflater, ViewGroup container,
     //                        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_search, container, false);
    }


