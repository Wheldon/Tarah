package mark.programs.com.sqllab;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler db= new DatabaseHandler(this);
        Log.d("Insert: ", "Inserting....");
        db.addContact(new Contacts("Ravi", "9100000000"));
        db.addContact(new Contacts("Srinivac", "9199999999"));
        db.addContact(new Contacts("Tommy", "9522222222"));
        db.addContact(new Contacts("Karshik", "9533333333"));

        Log.d(" Reading: "," Reading all contacts...");
        List<Contacts> contacts=db.getAllContacts();
        for (Contacts cn : contacts){
            String log= "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: "+cn.getPhoneNumber();
            Log.d(" Name: " ,log);
        }
        Log.d("Insert:","Inserting....");
        db.addUser(new People("Ravi", "Male"));
        db.addUser(new People("Srinivac", "Female"));
        db.addUser(new People("Tommy", "Male"));
        db.addUser(new People("Karshik", "Female"));

        Log.d(" Reading: "," Reading all users...");
        List<People> peoples=db.getAllPeople();
        for (People p : peoples){
            String log1="Id: "+p.getID()+" ,Name: " + p.getName() + " ,Gender: "+p.getGender();
            Log.d(" Name: " ,log1);
        }


       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
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
