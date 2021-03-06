package darrengillespie.coursework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RemoveExam extends Activity implements View.OnClickListener
{
    String examName;
    Button removeButton;
    TextView examNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_exam);

        removeButton = (Button)findViewById(R.id.removeExamButton);
        removeButton.setOnClickListener(this);
        examNameTextView = (TextView)findViewById(R.id.examNameText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_remove_exam, menu);
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

        Intent i = new Intent();
        i.putExtra("Exam Name", examName);
        setResult(RESULT_OK, i);
        finish();
    }
}
