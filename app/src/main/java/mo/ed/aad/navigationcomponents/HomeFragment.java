package mo.ed.aad.navigationcomponents;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        BottomNavigationView bottomNavigationView=(BottomNavigationView) view.findViewById(R.id.bottomNavigationView);
//        NavHostFragment navHostFragment=(NavHostFragment) getActivity().getSupportFragmentManager()
//                .findFragmentById(R.id.nav_host_fragment_container);
        NavHostFragment navHostFragment=(NavHostFragment) getChildFragmentManager().findFragmentById(R.id.fragment_container);
//
        NavigationUI.setupWithNavController(bottomNavigationView,
                navHostFragment.getNavController());
//
//        // TODO: 5/4/20  // just display text on toolbar and hide back button
//
        final androidx.appcompat.widget.Toolbar toolbar=(Toolbar) view.findViewById(R.id.toolbar);
        navHostFragment.getNavController().addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                toolbar.setTitle(destination.getLabel());
            }
        });
        return view;
    }
}