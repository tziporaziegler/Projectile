package ziegler.projectile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    EditText angleText;
    EditText velocityText;
    EditText timeText;
    Button calculateButton;
    TextView answerView;
    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        angleText = (EditText) findViewById(R.id.angle);
        velocityText = (EditText) findViewById(R.id.velocity);
        timeText = (EditText) findViewById(R.id.time);
        answerView = (TextView) findViewById(R.id.answer);
        pic = (ImageView) findViewById(R.id.pic);

        calculateButton = (Button) findViewById(R.id.calculate);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Projectile proj = new Projectile(Double.valueOf(angleText.getText().toString()),
                        Double.valueOf(velocityText.getText().toString()),
                        Double.valueOf(timeText.getText().toString()));
                String answer = "(" + proj.getX() + ", " + proj.getY() + ")";
                answerView.setText(answer);
            }
        });

        Picasso.with(this).load("https://upload.wikimedia.org/wikipedia/commons/thumb/6/61/Ideal_projectile_motion_for_different_angles.svg/350px-Ideal_projectile_motion_for_different_angles.svg.png").into(pic);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
