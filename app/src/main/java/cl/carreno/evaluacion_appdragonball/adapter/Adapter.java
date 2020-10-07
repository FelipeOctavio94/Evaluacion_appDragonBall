package cl.carreno.evaluacion_appdragonball.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import cl.carreno.evaluacion_appdragonball.DetailActivity;
import cl.carreno.evaluacion_appdragonball.MainActivity;
import cl.carreno.evaluacion_appdragonball.model.Character;

import cl.carreno.evaluacion_appdragonball.R;

public class Adapter extends RecyclerView.Adapter<Adapter.CharacterHolder> {

    public Activity activity;
    public List<Character> characterList;
    public int item_character;

    public Adapter(Activity activity, List<Character> characterList, int item_character) {
        this.activity = activity;
        this.characterList = characterList;
        this.item_character = item_character;
    }

    public Adapter(MainActivity mainActivity, List<java.lang.Character> list, int item_character) {

    }

    @NonNull
    @Override
    public CharacterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                item_character, parent, false
        );
        return new CharacterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterHolder holder, int position) {
        Character character = characterList.get(position);

        holder.item_name.setText(character.name);
        Glide.with(activity).load(character.image).into(holder.item_img);


        holder.gender=character.gender;
        holder.originPlanet=character.originPlanet;
        holder.species=character.species;
        holder.uimage=character.image;
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

    public class CharacterHolder extends RecyclerView.ViewHolder{

            public ImageView item_img;
            public TextView item_name;
            public String gender, originPlanet, species, uimage;
            public RelativeLayout item_panel;

        public CharacterHolder(@NonNull View itemView) {
            super(itemView);
            item_img = itemView.findViewById(R.id.item_img);
            item_name = itemView.findViewById(R.id.item_name);

            item_panel = itemView.findViewById(R.id.item_panel);

            item_panel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(activity, DetailActivity.class);

                    intent.putExtra("NAME",item_name.getText().toString());
                    intent.putExtra("GENDER",gender);
                    intent.putExtra("ORIGINPLANET",originPlanet);
                    intent.putExtra("SPECIES",species);
                    intent.putExtra("IMAGE",uimage);

                    activity.startActivity(intent);
                }
            });




        }
    }

}
