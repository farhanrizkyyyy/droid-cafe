package lat.pam.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Spinner citySpinner = findViewById(R.id.city_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.city_array, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        citySpinner.setAdapter(adapter);

        Intent intent = getIntent();
        String msg = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView ordered = findViewById(R.id.order_textview);
        ordered.setText(msg);
    }

    public void onRadioButtonClicked(View v) {
        boolean isChecked = ((RadioButton) v).isChecked();

        switch (v.getId()) {
            case R.id.sameday:
                if (isChecked) {
                    displayToast(getString(R.string.same_day));
                    break;
                }
            case R.id.nextday:
                if (isChecked) {
                    displayToast(getString(R.string.next_day));
                    break;
                }
            case R.id.pickup:
                if (isChecked) {
                    displayToast(getString(R.string.pick_up));
                    break;
                }
            default:
                break;
        }
    }

    public void displayToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

}