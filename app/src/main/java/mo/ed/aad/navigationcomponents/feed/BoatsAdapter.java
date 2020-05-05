package mo.ed.aad.navigationcomponents.feed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import mo.ed.aad.navigationcomponents.FeedFragment;
import mo.ed.aad.navigationcomponents.HomeFragmentDirections;
import mo.ed.aad.navigationcomponents.R;

public class BoatsAdapter extends RecyclerView.Adapter<BoatsAdapter.BoatsViewHolder> {


    private final Context mContext;
    private final List<Boat> mBoatsList;

    public BoatsAdapter(Context context, List<Boat> boats){
        this.mContext=context;
        this.mBoatsList=boats;
    }

    @NonNull
    @Override
    public BoatsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(mContext).inflate(R.layout.item_boat,parent,false);

        return new BoatsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BoatsViewHolder holder, int position) {
        if (mBoatsList!=null){
            if (mBoatsList.size()>0){
                Boat boat=mBoatsList.get(position);
                holder.nameTextView.setText(boat.getName());
                holder.locationTextView.setText(boat.getLocation());
                holder.priceTextView.setText(boat.getPrice());
                Glide.with(mContext)
                        .load(boat.getPicture())
                        .centerCrop()
                        .placeholder(R.drawable.loading)
                        .into(holder.boatImageView);
                holder.boatItemContainer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBoatClick(boat.getID(),v);
                    }
                });
            }
        }

    }

    public void onBoatClick(int boatId, View view){
        HomeFragmentDirections.ActionHomeFragmentToBoatFragment action = HomeFragmentDirections.actionHomeFragmentToBoatFragment(boatId);
        action.setId(boatId);
        Navigation.findNavController(view).navigate(action);
    }

    @Override
    public int getItemCount() {
        return mBoatsList.size();
    }

    public class BoatsViewHolder extends RecyclerView.ViewHolder {

        private final TextView nameTextView;
        private final ImageView boatImageView;
        private final TextView priceTextView;
        private final TextView locationTextView;
        private final ConstraintLayout boatItemContainer;

        public BoatsViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView= (TextView) itemView.findViewById(R.id.nameTextView);
            locationTextView= (TextView)itemView.findViewById(R.id.locationTextView);
            priceTextView= (TextView)itemView.findViewById(R.id.priceTextView);
            boatImageView=(ImageView) itemView.findViewById(R.id.imageView2);
            boatItemContainer=(ConstraintLayout) itemView.findViewById(R.id.boatItemContainer);
        }
    }
}
