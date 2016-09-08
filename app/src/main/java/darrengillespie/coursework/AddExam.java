package darrengillespie.coursework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddExam extends Activity implements View.OnClickListener
{
    String examName, examDateDay, examDateMonth, examDateYear, examSubject;
    TextView examNameTextView, examDateDayTextView, examDateMonthTextView, examDateYearTextView, examSubjectTextView;
    Button addExam;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exam);

        addExam = (Button) findViewById(R.id.addExamButton);
        addExam.setOnClickListener(this);
        examNameTextView = (TextView) findViewById(R.id.examNameText);
        examDateDayTextView = (TextView) findViewById(R.id.dateDayText);
        examDateMonthTextView = (TextView) findViewById(R.id.dateMonthText);
        examDateYearTextView = (TextView) findViewById(R.id.dateYearText);
        examSubjectTextView = (TextView) findViewById(R.id.examSubjectText);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_exam, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v)
    {
        examName = examNameTextView.getText().toString();
        examDateDay = examDateDayTextView.getText().toString();
        examDateMonth = examDateMonthTextView.getText().toString();
        examDateYear = examDateYearTextView.getText().toString();
        examSubject = examSubjectTextView.getText().toString();

        Intent i = new Intent();
        i.putExtra("Exam Name", examName);
        i.putExtra("Exam Date Day", examDateDay);
        i.putExtra("Exam Date Month", examDateMonth);
        i.putExtra("Exam Date Year", examDateYear);
        i.putExtra("Exam Subject", examSubject);
        setResult(RESULT_OK, i);
        finish();
    }
}
