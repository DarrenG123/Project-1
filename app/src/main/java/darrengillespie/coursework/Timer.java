package darrengillespie.coursework;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Timer extends Activity implements View.OnClickListener
{
    Button startButton, resetButton;
    TextView timeInput, timeDisplay;
    CharSequence userInput;
    long number;
    long minute;
    long seconds;
    boolean option;
    CountDownTimer timer;
    boolean timerExists = false;
    long millis;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        timeDisplay = (TextView) findViewById(R.id.timeDisplay);
        timeInput = (TextView) findViewById(R.id.timeInput);
        resetButton = (Button) findViewById(R.id.resetButton);
        resetButton.setOnClickListener(this);
        startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_timer, menu);
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

    public void tickingClock(long number, boolean choice)
    {
        if (choice == true)
        {
            timerExists = true;
            timer = new CountDownTimer(number, 1000)
            {
                public void onTick(long millisUntilFinished)
                {
                    minute = millisUntilFinished / 60000;
                    seconds = millisUntilFinished % 60000;
                    millis = millisUntilFinished;
                    String newSeconds = String.valueOf(seconds);
                    newSeconds = newSeconds.substring(0, 2);

                    timeDisplay.setText(minute + ":" + newSeconds);
                }

                public void onFinish()
                {
                    timeDisplay.setText("00:00");
                }
            }.start();
        }
        else
        {
            timer.cancel();
            timer.onFinish();
            timerExists = false;
        }
    }

    @Override
    public void onClick(View object)
    {
        if (object == startButton)
        {
            if (timeInput.length() == 0)
            {
                userInput = "0";
            }
            else
            {
                userInput = timeInput.getText();
            }
            number = Integer.parseInt(userInput.toString());
            number = number * 60000;
            option = true;
            if (timerExists)
            {
                tickingClock(0, false);
            }
            tickingClock(number, true);
        }
        else if (object == resetButton)
        {
            if (timerExists)
            {
                tickingClock(0, false);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle state)
    {
        super.onSaveInstanceState(state);
        state.putSerializable("millis", millis);
        state.putSerializable("timer exists", timerExists);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        millis = (long) savedInstanceState.getSerializable("millis");
        timerExists = (boolean) savedInstanceState.getSerializable("timer exists");
        if (timerExists)
        {
            tickingClock(millis, true);
        }
        else
        {
            timeDisplay.setText("00:00");
        }
    }
}
