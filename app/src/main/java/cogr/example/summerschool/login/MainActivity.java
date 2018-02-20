package cogr.example.summerschool.login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submit;
    EditText username;
    EditText password;

    Button cancel;
    TextView attempts;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.txtUsername);
        password = (EditText) findViewById(R.id.txtPassword);
        submit = (Button) findViewById(R.id.btnSubmit);

        cancel = (Button) findViewById(R.id.btnCancel);
        attempts = (TextView) findViewById(R.id.textView3);
        attempts.setVisibility(View.GONE);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){

                    Toast.makeText(MainActivity.this,"Redirecting...",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this,"Username and Password is Incorrect!",Toast.LENGTH_SHORT).show();

                    attempts.setVisibility(View.VISIBLE);
                    attempts.setBackgroundColor(Color.RED);
                    attempts.setTextColor(Color.WHITE);
                    counter--;
                    attempts.setText(Integer.toString(counter));

                    if (counter == 0) {
                        submit.setEnabled(false);
                    }
                }

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
            }
        });
    }
}
