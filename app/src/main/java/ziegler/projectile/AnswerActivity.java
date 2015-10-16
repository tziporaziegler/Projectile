package ziegler.projectile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


/**
 * Created by Tzipora Ziegler on 10/15/2015.
 */
public class AnswerActivity extends AppCompatActivity {

    private TextView answerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        answerView = (TextView) findViewById(R.id.answer);

        Intent intent = getIntent();
        double angle = intent.getDoubleExtra("ANGLE", 0.0); //give default value just in case ANGLE isn't there
        double velocity = intent.getDoubleExtra("VELOCITY", 0.0);
        double time = intent.getDoubleExtra("TIME", 0.0);

        Projectile proj = new Projectile(angle, velocity, time);
        String answer = "(" + proj.getX() + ", " + proj.getY() + ")";
        answerView.setText(answer);
    }
}
