package mo.ed.aad.navigationcomponents;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragment extends Fragment {

    private EditText editTextEmail;
    private String Email;
    private EditText editTextPassword;
    private String Password;
    private NavHostFragment mNavHostFragment;

    public WelcomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNavHostFragment=(NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view= inflater.inflate(R.layout.fragment_welcome, container, false);

        editTextEmail=(EditText)view.findViewById(R.id.editTextEmail);
        editTextPassword=(EditText)view.findViewById(R.id.editTextPassword);
        view.findViewById(R.id.button_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Email=editTextEmail.getText().toString();
                Password=editTextPassword.getText().toString();
                if (!Email.isEmpty() && !Password.isEmpty()){
                    mNavHostFragment.getNavController().navigate(R.id.action_registrationFragment_to_homeFragment);
                }
            }
        });

        view.findViewById(R.id.button_registration).setOnClickListener(Navigation.createNavigateOnClickListener(
                R.id.action_welcomeFragment_to_registrationFragment
        ));

        return  view;
    }
}