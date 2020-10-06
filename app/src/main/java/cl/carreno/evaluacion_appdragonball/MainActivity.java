package cl.carreno.evaluacion_appdragonball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private static final String URL="https://dragon-ball-api.herokuapp.com/api/character/";
    EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.user);
        loadinformation();
    }

    public void Login(View view) {
        if (txt.getText().toString().isEmpty()){
            Toast.makeText(this,"Please complete your user",Toast.LENGTH_LONG).show();
        }else {
            Intent intent = new Intent(this, CoffeeActivity.class);
            startActivity(intent);
        }
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
            JSONObject root = new JSONObject(data);
            JSONArray character = root.getJSONArray("character");
        }catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public void Creator(View view) {
        Toast.makeText(this,"Creadores: Cristobal Canales, Felipe Carreño",Toast.LENGTH_LONG).show();
    }
}