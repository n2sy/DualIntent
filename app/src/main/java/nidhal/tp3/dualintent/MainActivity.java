package nidhal.tp3.dualintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //public static final String EXTRA_MESSAGE ="";
    private EditText msgTxt;
    private TextView headerMsg;
    private TextView reponseMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msgTxt = (EditText) findViewById(R.id.txt1);

        headerMsg = (TextView) findViewById(R.id.text_header);
        reponseMsg = (TextView) findViewById(R.id.text_message);
    }

    public void LaunchActivity(View v) {
        Intent i = new Intent(this, SecondActivity.class);
        String msg = msgTxt.getText().toString();
        i.putExtra("lfig3", msg);
        startActivityForResult(i, 24333);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent i) {
        super.onActivityResult(requestCode, resultCode, i);

        if (requestCode == 24333) {
            if (resultCode == RESULT_OK) {
                String reply = i.getStringExtra("lfigRep");
                reponseMsg.setVisibility(View.VISIBLE);
                reponseMsg.setText(reply);
            } else { //resultCode == RESULT_CANCELED
                Toast.makeText(getApplicationContext(), "Chaine vide", Toast.LENGTH_LONG).show();
            }
        }
    }
}
