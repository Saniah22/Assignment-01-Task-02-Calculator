package pk.edu.pucit.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

//import android.content.Context;

public class MainActivity extends AppCompatActivity
{
    TextView tv_equation,tv_result,tv_AC,tv_div,tv_mul,tv_sub,tv_add,tv_del,tv_dot,tv_equal,tv_percent;
    TextView tv_7,tv_8,tv_9,tv_4,tv_5,tv_6,tv_1,tv_2,tv_3,tv_0,tv_00;
    String process;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // setupUIViews();

        tv_00=(TextView) findViewById(R.id.tv_00);
        tv_0=(TextView) findViewById(R.id.tv_0);
        tv_1=(TextView) findViewById(R.id.tv_1);
        tv_2=(TextView) findViewById(R.id.tv_2);
        tv_3=(TextView) findViewById(R.id.tv_3);
        tv_4=(TextView) findViewById(R.id.tv_4);
        tv_5=(TextView) findViewById(R.id.tv_5);
        tv_6=(TextView) findViewById(R.id.tv_6);
        tv_7=(TextView) findViewById(R.id.tv_7);
        tv_8=(TextView) findViewById(R.id.tv_8);
        tv_9=(TextView) findViewById(R.id.tv_9);
        tv_AC=(TextView) findViewById(R.id.tv_AC);
        tv_div=(TextView) findViewById(R.id.tv_div);
        tv_del=(TextView) findViewById(R.id.tv_del);
        tv_dot=(TextView) findViewById(R.id.tv_dot);
        tv_mul=(TextView) findViewById(R.id.tv_mul);
        tv_sub=(TextView) findViewById(R.id.tv_sub);
        tv_add=(TextView) findViewById(R.id.tv_add);
        tv_equal=(TextView) findViewById(R.id.tv_equal);
        tv_result=(TextView) findViewById(R.id.tv_result);
        tv_percent=(TextView) findViewById(R.id.tv_percent);
        tv_equation=(TextView) findViewById(R.id.tv_equation);




        tv_AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_equation.setText("");
                tv_result.setText("");
            }
        });
        tv_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv_equation.getText().toString();
                tv_equation.setText(process + "0");
            }
        });
        tv_00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv_equation.getText().toString();
                tv_equation.setText(process + "00");
            }
        });

        tv_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv_equation.getText().toString();
                tv_equation.setText(process + "1");
            }
        });

        tv_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv_equation.getText().toString();
                tv_equation.setText(process + "2");
            }
        });

        tv_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv_equation.getText().toString();
                tv_equation.setText(process + "3");
            }
        });

        tv_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv_equation.getText().toString();
                tv_equation.setText(process + "4");
            }
        });

        tv_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv_equation.getText().toString();
                tv_equation.setText(process + "5");
            }
        });

        tv_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv_equation.getText().toString();
                tv_equation.setText(process + "6");
            }
        });


        tv_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv_equation.getText().toString();
                tv_equation.setText(process + "7");
            }
        });

        tv_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv_equation.getText().toString();
                tv_equation.setText(process + "8");
            }
        });

        tv_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv_equation.getText().toString();
                tv_equation.setText(process + "9");
            }
        });

        tv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv_equation.getText().toString();
                tv_equation.setText(process + "+");
            }
        });


        tv_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv_equation.getText().toString();
                tv_equation.setText(process + "-");
            }
        });

        tv_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv_equation.getText().toString();
                tv_equation.setText(process + "×");
            }
        });

        tv_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv_equation.getText().toString();
                tv_equation.setText(process + "÷");
            }
        });

        tv_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv_equation.getText().toString();
                tv_equation.setText(process + ".");
            }
        });

        tv_percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv_equation.getText().toString();
                tv_equation.setText(process + "%");
            }
        });


        tv_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tv_equation.getText().toString();

                process = process.replaceAll("×","*");
                process = process.replaceAll("%","/100");
                process = process.replaceAll("÷","/");

                Context rhino = Context.enter();

                rhino.setOptimizationLevel(-1);

                String finalResult = "";

                try {

                    Scriptable scriptable = rhino.initStandardObjects();
                    finalResult = rhino.evaluateString(scriptable,process,"javascript",1,null).toString();
                }catch (Exception e){
                    finalResult="0";
                }

                tv_result.setText(finalResult);
            }
        });


    }

}
