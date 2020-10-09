package cl.carreno.evaluacion_appdragonball;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import cl.carreno.evaluacion_appdragonball.adapter.Adapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import cl.carreno.evaluacion_appdragonball.model.Character;


import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private static final String URL="https://dragon-ball-api.herokuapp.com/api/character/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadinformation();
    }



    public void loadinformation(){
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(URL, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String data = new String(responseBody);
                Log.d("INFO",data);
                processCharacter(data);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public void processCharacter(String data) {
        try {
            JSONArray root = new JSONArray(data);


            List<Character> list = new ArrayList<>();

            for (int i = 0; i < root.length(); i++){
                JSONObject character1 = root.getJSONObject(i);
                String name = character1.getString("name");
                String gender = character1.getString("gender");
                String originPlanet = character1.getString("originPlanet");
                String species = character1.getString("species");
                String image = character1.getString("image");

                Character character = new Character(name, gender, originPlanet, species, image);
                list.add(character);
            }
            RecyclerView rc = findViewById(R.id.rc_character);
            Adapter ad= new Adapter(this,list,R.layout.item_character);
            LinearLayoutManager lm = new LinearLayoutManager(this);
            lm.setOrientation(RecyclerView.VERTICAL);
            rc.setLayoutManager(lm);
            rc.setAdapter(ad);



        }catch (JSONException e) {
            e.printStackTrace();
        }
    }

}