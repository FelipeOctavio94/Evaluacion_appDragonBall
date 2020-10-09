package cl.carreno.evaluacion_appdragonball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txt = findViewById(R.id.user);
    }

    public void Login(View view) {
        if (txt.getText().toString().isEmpty()){
            Toast.makeText(this,"Please complete parameters",Toast.LENGTH_LONG).show();
        }else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    public void Creator(View view) {
        Intent intent = new Intent(LoginActivity.this, CreatorActivity.class);
        startActivity(intent);
    }
}