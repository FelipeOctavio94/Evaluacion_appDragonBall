package cl.carreno.evaluacion_appdragonball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.user);
    }

    public void Login(View view) {
        if (txt.getText().toString().isEmpty()){
            Toast.makeText(this,"Please complete your user",Toast.LENGTH_LONG).show();
        }else {
            Intent intent = new Intent(this, CoffeeActivity.class);
            startActivity(intent);
        }
    }
}