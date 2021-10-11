package net.noelli_network;

import android.util.Log;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

    }

    public void calculate(View view) {
        double result = 0;
        Spinner openSpinner = findViewById(R.id.oper);
        TextView top1 = (TextView) findViewById(R.id.op1);
        TextView top2 = (TextView) findViewById(R.id.op2);

        if(top1.getText().length() == 0 || top2.getText().length() == 0) {
            Snackbar.make(view, R.string.error_no_inputs, Snackbar.LENGTH_LONG).show();
            return;
        }
        double op1 = 0;
        double op2 = 0;
        try {
            op1 = Double.parseDouble(((TextView) findViewById(R.id.op1)).getText().toString());
            op2 = Double.parseDouble(((TextView) findViewById(R.id.op2)).getText().toString());
        } catch (NumberFormatException exception) {
            Snackbar.make(view, R.string.error_numberformat, Snackbar.LENGTH_LONG).show();
            return;
        }
        String oper = (String) openSpinner.getSelectedItem();

        switch (oper) {
            case "+":
                result = op1 + op2;
                break;
            case "-":
                result = op1 - op2;
                break;
            case "*":
                result = op1 * op2;
                break;
            case "/":
                if(op2 == 0.0) {
                    Snackbar.make(view, R.string.error_division_0, Snackbar.LENGTH_LONG).show();
                    return;
                }
                result = op1 / op2;
                break;
            case "^":
                result = Math.pow(op1, op2);

                break;
        }
        TextView textView = findViewById(R.id.result);
        CharSequence text = textView.getText();
        textView.setText(op1 + " " + oper  + " " + op2 + " = " + result + "\n" + text);
    }
    public String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }

    public String padLeft(String s, int n) {
        return String.format("%" + n + "s", s);
    }




}