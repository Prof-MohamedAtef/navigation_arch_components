package mo.ed.aad.navigationcomponents;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import mo.ed.aad.navigationcomponents.feed.Boat;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class BoatFragment extends Fragment {

    private Boat mBoat;
    private int boatIndex;

    public BoatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_boat, container, false);

        Bundle bundle = getArguments();
        if (bundle!=null){
            if (bundle.getString("id_dl")!=null){
                boatIndex= Integer.valueOf(bundle.getString("id_dl"));
            }
        }else {
            boatIndex =BoatFragmentArgs.fromBundle(getArguments()).getId();
        }

        mBoat= Boat.getBoat(boatIndex);
        Button button=(Button) view.findViewById(R.id.button);
        TextView priceText=(TextView) view.findViewById(R.id.priceTextView);
        TextView locationText=(TextView)view.findViewById(R.id.locationTextView);
        TextView nameText=(TextView)view.findViewById(R.id.nameTextView);
        ImageView imageView2=(ImageView) view.findViewById(R.id.imageView2);
        priceText.setText(mBoat.getPrice());
        locationText.setText(mBoat.getLocation());
        nameText.setText(mBoat.getName());
        Glide.with(getActivity())
                .load(mBoat.getPicture())
                .centerCrop()
                .placeholder(R.drawable.loading)
                .into(imageView2);
        
        return view;
    }
}
