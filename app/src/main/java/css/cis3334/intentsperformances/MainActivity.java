package css.cis3334.intentsperformances;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.GregorianCalendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn1Web, but1Calendar, btn1Map;
    Button btn2Web, btn2Calendar, btn2Map;
    TextView textViewStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewStatus = (TextView) findViewById(R.id.textViewStatus);
        setupButtonClickEvents();



    }


    private void setupButtonClickEvents() {
        /**
         *   Set up button click event listener for the web info button for the first performance
         */
        btn1Web = (Button) findViewById(R.id.button1WebInfo);
        btn1Web.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Uri webpage = Uri.parse("http://www.css.edu/about/spotlight-arts-and-lectures.html");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                //textViewStatus.setText("Code should display website for performance 1");
                if (checkIntent(webIntent) == true) {
                    startActivity(webIntent);
                }
            }
        });

        /**
         *   Set up button click event listener for the celendar button for the first performance
         *       Use the calendar intent to set an event reminder on the calendar
         */
        but1Calendar = (Button) findViewById(R.id.button1Calendar);
        but1Calendar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                //textViewStatus.setText("Code should set a calendar event for performance 1");
                Intent calIntent = new Intent(Intent.ACTION_INSERT);
                calIntent.setType("vnd.android.cursor.item/event");
                calIntent.putExtra(CalendarContract.Events.TITLE, "SAL Colloquium 'The Robot Next Door'");
                calIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Tower Hall 4119");
                GregorianCalendar begDate = new GregorianCalendar(2017, 2, 24, 3, 40);
                GregorianCalendar endDate = new GregorianCalendar(2017, 2, 24, 4, 40);
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                        begDate.getTimeInMillis());
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                        endDate.getTimeInMillis());
                if (checkIntent(calIntent) == true) {
                    startActivity(calIntent);
                }

            }
        });

        /**
         *   Set up button click event listener for the web info button for the first performance
         */
        btn1Map = (Button) findViewById(R.id.button1map);
        btn1Map.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri location = Uri.parse("geo:0,0?q=1200+Kenwood+Ave,+Duluth,+Minnesota");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                //textViewStatus.setText("Code should display map for performance 1");
                if (checkIntent(mapIntent) == true) {
                    startActivity(mapIntent);
                }
            }
        });

        /**
         *   Set up button click event listener for the web info button for the second performance
         */
        btn2Web = (Button) findViewById(R.id.button2WebInfo);
        btn2Web.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Uri webpage = Uri.parse("http://www.css.edu/about/spotlight-arts-and-lectures/calendar.html?trumbaEmbed=eventid%3d124648615%26view%3devent%26-childview%3d");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                //textViewStatus.setText("Code should display website for performance 2");
                if (checkIntent(webIntent) == true) {
                    startActivity(webIntent);
                }
            }
        });

        /**
         *   Set up button click event listener for the celendar button for the second performance
         *       Use the calendar intent to set an event reminder on the calendar
         */
        btn2Calendar = (Button) findViewById(R.id.button2Calendar);
        btn2Calendar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                //textViewStatus.setText("Code should set a calendar event for performance 2");
                Intent calIntent = new Intent(Intent.ACTION_INSERT);
                calIntent.setType("vnd.android.cursor.item/event");
                calIntent.putExtra(CalendarContract.Events.TITLE, "Celebrate Spring");
                calIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Mitchell Auditorim");
                GregorianCalendar begDate = new GregorianCalendar(2018, 3, 8, 19, 30);
                GregorianCalendar endDate = new GregorianCalendar(2017, 2, 24, 21, 30);
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                        begDate.getTimeInMillis());
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                        endDate.getTimeInMillis());
                if (checkIntent(calIntent) == true) {
                    startActivity(calIntent);
                }

            }
        });

        /**
         *   Set up button click event listener for the web info button for second first performance
         */
        btn2Map = (Button) findViewById(R.id.button2map);
        btn2Map.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri location = Uri.parse("geo:0,0?q=1200+Kenwood+Ave,+Duluth,+Minnesota");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                //textViewStatus.setText("Code should display map for performance 2");
                if (checkIntent(mapIntent) == true) {
                    startActivity(mapIntent);
                }
            }
        });


    }

    /**
     * Check if there is an activity to handle the intent.
     * @param intent
     * @return
     */
    public boolean checkIntent (Intent intent){
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
        boolean isIntentSafe = activities.size() > 0;
        return isIntentSafe;
    }

}
