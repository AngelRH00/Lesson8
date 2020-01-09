package com.example.lesson8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class QuizMenuActivity extends QuizActivity{
    ListView menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        menuList = findViewById(R.id.lista);
        String[] items = { getResources().getString(R.string.menu_item_play),
                getResources().getString(R.string.menu_item_scores),
                getResources().getString(R.string.menu_item_settings),
                getResources().getString(R.string.menu_item_help) };
        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this,
                R.layout.menu_item, items);
        menuList.setAdapter(adapt);
        toastear("MAZIONGA");

        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View itemClicked,
                                    int position, long id) {
                TextView textView = (TextView) itemClicked;
                String strText = textView.getText().toString();
                if (strText.equalsIgnoreCase(getResources().getString(
                        R.string.menu_item_play))) {
// Launch the Game Activity

                    startActivity(new Intent(QuizMenuActivity.this,
                            QuizGameActivity.class));
                    toastear("You selected BAZINGPLAY");
                } else if (strText.equalsIgnoreCase(getResources().getString(
                        R.string.menu_item_help))) {

// Launch the Help Activity
                    startActivity(new Intent(QuizMenuActivity.this,
                            QuizHelpActivity.class));
                    toastear("You selected BAZINGHELP");
                } else if (strText.equalsIgnoreCase(getResources().getString(
                        R.string.menu_item_settings))) {
// Launch the Settings Activity
                    startActivity(new Intent(QuizMenuActivity.this,
                            QuizSettingsActivity.class));
                    toastear("You selected BAZINGSETTINGS");
                } else if (strText.equalsIgnoreCase(getResources().getString(
                        R.string.menu_item_scores))) {
// Launch the Scores Activity
                    startActivity(new Intent(QuizMenuActivity.this,
                            QuizScoresActivity.class));
                    toastear("You selected BAZINGSCORES");
                }
            }
        });
    }

    public void toastear(String mensaje){
        Toast toast = Toast.makeText(this, mensaje,Toast.LENGTH_SHORT);
        toast.show();
    }

}
