package darrengillespie.coursework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Exam extends Activity implements View.OnClickListener
{
    Button addButton, refreshButton, removeButton;
    String examName, examDateDay, examDateMonth, examDateYear, examSubject;
    boolean removeOrAdd;
    boolean arrayInitialised = false;
    TextView examNameLabel1, examNameLabel2, examNameLabel3, examNameLabel4, examNameLabel5, examNameLabel6, examNameLabel7;
    TextView examDayLabel1, examDayLabel2, examDayLabel3, examDayLabel4, examDayLabel5, examDayLabel6, examDayLabel7;
    TextView examMonthLabel1, examMonthLabel2, examMonthLabel3, examMonthLabel4, examMonthLabel5, examMonthLabel6, examMonthLabel7;
    TextView examYearLabel1, examYearLabel2, examYearLabel3, examYearLabel4, examYearLabel5, examYearLabel6, examYearLabel7;
    TextView examSubjectLabel1, examSubjectLabel2, examSubjectLabel3, examSubjectLabel4, examSubjectLabel5, examSubjectLabel6, examSubjectLabel7;
    String[][] examList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        initialiseArray();

        addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(this);
        removeButton = (Button) findViewById(R.id.removeButton);
        removeButton.setOnClickListener(this);
        refreshButton = (Button) findViewById(R.id.refreshButton);
        refreshButton.setOnClickListener(this);

        examNameLabel1 = (TextView) findViewById(R.id.examListName1);
        examNameLabel2 = (TextView) findViewById(R.id.examListName2);
        examNameLabel3 = (TextView) findViewById(R.id.examListName3);
        examNameLabel4 = (TextView) findViewById(R.id.examListName4);
        examNameLabel5 = (TextView) findViewById(R.id.examListName5);
        examNameLabel6 = (TextView) findViewById(R.id.examListName6);
        examNameLabel7 = (TextView) findViewById(R.id.examListName7);

        examDayLabel1 = (TextView) findViewById(R.id.examListDay1);
        examDayLabel2 = (TextView) findViewById(R.id.examListDay2);
        examDayLabel3 = (TextView) findViewById(R.id.examListDay3);
        examDayLabel4 = (TextView) findViewById(R.id.examListDay4);
        examDayLabel5 = (TextView) findViewById(R.id.examListDay5);
        examDayLabel6 = (TextView) findViewById(R.id.examListDay6);
        examDayLabel7 = (TextView) findViewById(R.id.examListDay7);

        examMonthLabel1 = (TextView) findViewById(R.id.examListMonth1);
        examMonthLabel2 = (TextView) findViewById(R.id.examListMonth2);
        examMonthLabel3 = (TextView) findViewById(R.id.examListMonth3);
        examMonthLabel4 = (TextView) findViewById(R.id.examListMonth4);
        examMonthLabel5 = (TextView) findViewById(R.id.examListMonth5);
        examMonthLabel6 = (TextView) findViewById(R.id.examListMonth6);
        examMonthLabel7 = (TextView) findViewById(R.id.examListMonth7);

        examYearLabel1 = (TextView) findViewById(R.id.examListYear1);
        examYearLabel2 = (TextView) findViewById(R.id.examListYear2);
        examYearLabel3 = (TextView) findViewById(R.id.examListYear3);
        examYearLabel4 = (TextView) findViewById(R.id.examListYear4);
        examYearLabel5 = (TextView) findViewById(R.id.examListYear5);
        examYearLabel6 = (TextView) findViewById(R.id.examListYear6);
        examYearLabel7 = (TextView) findViewById(R.id.examListYear7);

        examSubjectLabel1 = (TextView) findViewById(R.id.examListSubject1);
        examSubjectLabel2 = (TextView) findViewById(R.id.examListSubject2);
        examSubjectLabel3 = (TextView) findViewById(R.id.examListSubject3);
        examSubjectLabel4 = (TextView) findViewById(R.id.examListSubject4);
        examSubjectLabel5 = (TextView) findViewById(R.id.examListSubject5);
        examSubjectLabel6 = (TextView) findViewById(R.id.examListSubject6);
        examSubjectLabel7 = (TextView) findViewById(R.id.examListSubject7);

        refreshPage();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1)
        {
            if (resultCode == RESULT_OK)
            {
                examName = data.getStringExtra("Exam Name");
                examDateDay = data.getStringExtra("Exam Date Day");
                examDateMonth = data.getStringExtra("Exam Date Month");
                examDateYear = data.getStringExtra("Exam Date Year");
                examSubject = data.getStringExtra("Exam Subject");
                removeOrAdd = data.getBooleanExtra("Remove Or Add", false);
                addToList(examName, examDateDay, examDateMonth, examDateYear, examSubject);
            }
        }
        if (requestCode == 2)
        {
            Log.d("returning from ", "remove");
            Log.d("returning from ", "remove");
            examName = data.getStringExtra("Exam Name");
            removeFromList(examName);
        }
    }

    private void initialiseArray()
    {
        examList = new String[8][5];
       for (int i = 0; i < examList.length; i++)
       {
           for (int j = 0; j < examList[0].length; j++)
           {
               examList[i][j] = "";
           }
       }
        arrayInitialised = true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_exam, menu);
        return true;
    }

    public void addToList(String examName, String examDateDay, String examDateMonth, String examDateYear, String examSubject)
    {
        if ((examName != null) && (examDateDay != null) && (examDateMonth != null) && (examDateYear != null) && (examSubject != null))
        {
            for (int i = 0; i < examList.length; i ++)
            {
                if ((examList[i][0].length() == 0) && (examList[i][1].length() == 0) && (examList[i][2].length() == 0) && (examList[i][3].length() == 0) && (examList[i][4].length() == 0))
                {
                    examList[i][0] = examName;
                    examList[i][1] = examDateDay;
                    examList[i][2] = examDateMonth;
                    examList[i][3] = examDateYear;
                    examList[i][4] = examSubject;
                    refreshPage();
                    return;
                }
            }
        }
    }

    public void removeFromList(String examName)
    {
        boolean isFound = false;
        int arrayPlace = 0;

        for (int i = 0; i < examList.length; i ++)
        {
            if (examList[i][0].matches(examName))
            {
                arrayPlace = i;
                Log.d("found point ", "" + arrayPlace);
                isFound = true;
            }
        }

        if (isFound == false)
        {
            return;
        }

        for (int i = arrayPlace; i < examList.length - 1; i++)
        {
            examList[i] = examList[i + 1];
        }

        refreshPage();
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

    public void refreshPage()
    {
        if (isLineNull(0) == false)
        {
            examNameLabel1.setText(examList[0][0] + ",  ");
            examDayLabel1.setText(examList[0][1] + ",  ");
            examMonthLabel1.setText(examList[0][2] + ", ");
            examYearLabel1.setText(examList[0][3]);
            examSubjectLabel1.setText(examList[0][4] + ",  ");
        }
        else
        {
            examNameLabel1.setText(examList[0][0]);
            examDayLabel1.setText(examList[0][1]);
            examMonthLabel1.setText(examList[0][2]);
            examYearLabel1.setText(examList[0][3]);
            examSubjectLabel1.setText(examList[0][4]);
        }

        if (isLineNull(1) == false)
        {
            examNameLabel2.setText(examList[1][0] + ",  ");
            examDayLabel2.setText(examList[1][1] + ",  ");
            examMonthLabel2.setText(examList[1][2] + ", ");
            examYearLabel2.setText(examList[1][3]);
            examSubjectLabel2.setText(examList[1][4] + ",  ");
        }
        else
        {
            examNameLabel2.setText(examList[1][0]);
            examDayLabel2.setText(examList[1][1]);
            examMonthLabel2.setText(examList[1][2]);
            examYearLabel2.setText(examList[1][3]);
            examSubjectLabel2.setText(examList[1][4]);
        }

        if (isLineNull(2) == false)
        {
            examNameLabel3.setText(examList[2][0] + ",  ");
            examDayLabel3.setText(examList[2][1] + ",  ");
            examMonthLabel3.setText(examList[2][2] + ", ");
            examYearLabel3.setText(examList[2][3]);
            examSubjectLabel3.setText(examList[2][4] + ",  ");
        }
        else
        {
            examNameLabel3.setText(examList[2][0]);
            examDayLabel3.setText(examList[2][1]);
            examMonthLabel3.setText(examList[2][2]);
            examYearLabel3.setText(examList[2][3]);
            examSubjectLabel3.setText(examList[2][4]);
        }

        if (isLineNull(3) == false)
        {
            examNameLabel4.setText(examList[3][0] + ",  ");
            examDayLabel4.setText(examList[3][1] + ",  ");
            examMonthLabel4.setText(examList[3][2] + ", ");
            examYearLabel4.setText(examList[3][3]);
            examSubjectLabel4.setText(examList[3][4] + ",  ");
        }
        else
        {
            examNameLabel4.setText(examList[3][0]);
            examDayLabel4.setText(examList[3][1]);
            examMonthLabel4.setText(examList[3][2]);
            examYearLabel4.setText(examList[3][3]);
            examSubjectLabel4.setText(examList[3][4]);
        }

        if (isLineNull(4) == false)
        {
            examNameLabel5.setText(examList[4][0] + ",  ");
            examDayLabel5.setText(examList[4][1] + ",  ");
            examMonthLabel5.setText(examList[4][2] + ", ");
            examYearLabel5.setText(examList[4][3]);
            examSubjectLabel5.setText(examList[4][4] + ",  ");
        }
        else
        {
            examNameLabel5.setText(examList[4][0]);
            examDayLabel5.setText(examList[4][1]);
            examMonthLabel5.setText(examList[4][2]);
            examYearLabel5.setText(examList[4][3]);
            examSubjectLabel5.setText(examList[4][4]);
        }

        if (isLineNull(5) == false)
        {
            examNameLabel6.setText(examList[5][0] + ",  ");
            examDayLabel6.setText(examList[5][1] + ",  ");
            examMonthLabel6.setText(examList[5][2] + ", ");
            examYearLabel6.setText(examList[5][3]);
            examSubjectLabel6.setText(examList[5][4] + ",  ");
        }
        else
        {
            examNameLabel6.setText(examList[5][0]);
            examDayLabel6.setText(examList[5][1]);
            examMonthLabel6.setText(examList[5][2]);
            examYearLabel6.setText(examList[5][3]);
            examSubjectLabel6.setText(examList[5][4]);
        }

        if (isLineNull(6) == false)
        {
            examNameLabel7.setText(examList[6][0] + ",  ");
            examDayLabel7.setText(examList[6][1] + ",  ");
            examMonthLabel7.setText(examList[6][2] + ", ");
            examYearLabel7.setText(examList[6][3]);
            examSubjectLabel7.setText(examList[6][4] + ",  ");
        }
        else
        {
            examNameLabel7.setText(examList[6][0]);
            examDayLabel7.setText(examList[6][1]);
            examMonthLabel7.setText(examList[6][2]);
            examYearLabel7.setText(examList[6][3]);
            examSubjectLabel7.setText(examList[6][4]);
        }
    }

    public boolean isLineNull(int i)
    {
        if ((examList[i][0].length() == 0) && (examList[i][1].length() == 0) && (examList[i][2].length() == 0) && (examList[i][3].length() == 0) && (examList[i][4].length() == 0))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public void onClick(View object)
    {
        Intent i;
        if (object == addButton)
        {
            i = new Intent(this, AddExam.class);
            startActivityForResult(i, 1);
        }
        else if (object == removeButton)
        {
            i = new Intent (this, RemoveExam.class);
            startActivityForResult(i, 2);
        }
        else if (object == refreshButton)
        {
            refreshPage();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle state)
    {
        super.onSaveInstanceState(state);
        state.putSerializable("Exam List", examList);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        examList = (String[][]) savedInstanceState.getSerializable("Exam List");
        refreshPage();
    }
}
