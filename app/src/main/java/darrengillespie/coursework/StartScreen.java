package darrengillespie.coursework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StartScreen extends Activity implements OnClickListener
{
    Button timetableButton, examButton, timerButton, homeworkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        timetableButton = (Button) findViewById(R.id.timetableButton);
        timetableButton.setOnClickListener(this);
        examButton  = (Button) findViewById(R.id.examButton);
        examButton.setOnClickListener(this);
        timerButton  = (Button) findViewById(R.id.timerButton);
        timerButton.setOnClickListener(this);
        homeworkButton  = (Button) findViewById(R.id.homeworkButton);
        homeworkButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View object)
    {
        Intent i = new Intent();
        if (object == timetableButton)
        {
            i = new Intent(StartScreen.this,Timetable.class);
        }
        else if (object == examButton)
        {
            i = new Intent(StartScreen.this,Exam.class);
        }
        else if (object == timerButton)
        {
            i = new Intent(StartScreen.this,Timer.class);
        }
        else if (object == homeworkButton)
        {
            i = new Intent(StartScreen.this,Homework.class);
        }

        if (i != null)
        {
            startActivity(i);
        }
    }
}
