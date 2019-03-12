package sehatmaru.lapakgaming.Helper;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;

import sehatmaru.lapakgaming.Home.HomeActivity;
import sehatmaru.lapakgaming.R;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.usernameField);
        password = (EditText) findViewById(R.id.passwordField);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);

        Button btnLogin = (Button) findViewById(R.id.lgnBtn);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }

    private void loginUser(){
        String user = username.getText().toString();
        String pass = password.getText().toString();

        if (user.equals("user") && pass.equals("user")){
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
//            startActivity(HomeActivity.createIntent(getApplicationContext()));
        }else{
            Snackbar.make(coordinatorLayout, "Username/password salah", 3000).show();
        }
    }
}
