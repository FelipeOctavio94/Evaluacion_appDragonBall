package cl.carreno.evaluacion_appdragonball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    String name, gender, originPlanet, species, image;
    TextView c_name, c_gender, c_originPlanet, c_species;
    ImageView c_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        name = getIntent().getStringExtra("NAME");
        gender = getIntent().getStringExtra("GENDER");
        originPlanet = getIntent().getStringExtra("ORIGINALPLANET");
        species = getIntent().getStringExtra("SPECIES");
        image = getIntent().getStringExtra("IMAGE");

        c_name = findViewById(R.id.name_detail);
        c_gender = findViewById(R.id.gender_detail);
        c_originPlanet = findViewById(R.id.planet_detail);
        c_species = findViewById(R.id.species_detail);
        c_img= findViewById(R.id.img_gohan);

        c_name.setText(name);
        c_gender.setText(species);
        c_originPlanet.setText(originPlanet);
        c_species.setText(species);
        Glide.with(this).load(image).into(c_img);


    }
}