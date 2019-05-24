package sg.edu.rp.soi.p06_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNum1,etNum2;
    TextView textViewResult, textViewOperation;
    Button btnRest;
    int plus =0;
    int minus=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        textViewResult = findViewById(R.id.textViewResult);
        textViewOperation = findViewById(R.id.tvOperation);
        btnRest = findViewById(R.id.btnReset);

        registerForContextMenu(textViewOperation);

        btnRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNum1.setText("");
                etNum2.setText("");
                textViewResult.setText("");
            }
        });

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, 0, "+");
        menu.add(0, 1, 1, "-");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

        @Override
    public boolean onContextItemSelected(MenuItem item){
        int id = item.getItemId();
        int x=Integer.parseInt(etNum1.getText().toString());
        int y=Integer.parseInt(etNum2.getText().toString());

        if (id==0){
            plus = x+y;
            textViewResult.setText(plus+"");
            return true;
        }
        else if(id ==1){
            minus = x-y;
            textViewResult.setText(minus+"");
            return true;
        }
        return super.onContextItemSelected(item);
    }


}
