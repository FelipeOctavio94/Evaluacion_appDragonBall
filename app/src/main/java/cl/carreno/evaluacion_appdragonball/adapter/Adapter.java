package cl.carreno.evaluacion_appdragonball.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

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

        holder.name.setText(character.getName());
        Glide.with(activity).load(character.image).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

    public class CharacterHolder extends RecyclerView.ViewHolder{

            ImageView img;
            TextView name;

        public CharacterHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
        }
    }

}
