package com.healthifymeal.healthifymeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class generateMealPlan1 extends AppCompatActivity {


    TextView txt1, txt2, txt3, txt4;
    RadioGroup radioGroupDiet, radioGroupGoal;
    RadioButton radioButton1, radioButton2;
    Button generateMealPlan;
    String url;
    String x,y,x1,y1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_generate_meal_plan1);

        url = "https://healthifymealapp.herokuapp.com/predict";
        radioGroupDiet = findViewById(R.id.diet);
        radioGroupGoal = findViewById(R.id.goal);
        generateMealPlan = findViewById(R.id.generate_meal_plan_now);
        txt1 = findViewById(R.id.meal_plan1);
        txt2 = findViewById(R.id.meal_plan2);
        txt3 = findViewById(R.id.meal_plan3);
        txt4 = findViewById(R.id.meal_plan4);

        int dietID = radioGroupDiet.getCheckedRadioButtonId();
        radioButton1=findViewById(dietID);
        int goalID = radioGroupGoal.getCheckedRadioButtonId();
        radioButton2=findViewById(goalID);

        generateMealPlan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                txt1.setText("Your Meal Plans: ");
                txt2.setVisibility(View.GONE);
                radioGroupDiet.setVisibility(View.GONE);
                radioGroupGoal.setVisibility(View.GONE);
                generateMealPlan.setText("Regenerate");

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    String data1 = jsonObject.getString("1");
                                    txt3.setText(data1);
                                    String data2 = jsonObject.getString("2");
                                    txt4.setText(data2);
                                    String data3 = jsonObject.getString("3");
                                    //txt.setText(data);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(generateMealPlan1.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }){
                    @Override
                    protected Map<String,String> getParams(){
                        Map<String,String> params = new HashMap<String,String>();
                        params.put("diet", "veg");
                        params.put("goal", "1");
                        return params;
                    }
                };
                RequestQueue queue = Volley.newRequestQueue(generateMealPlan1.this);
                queue.add(stringRequest);

            }
        });



    }

    public void callBMIScreen(View view) {
        Intent intent = new Intent(generateMealPlan1.this, BMI.class);
        startActivity(intent);

    }

//    public void callDisplayMealPlan(View view) {
//
//        int dietID = radioGroupDiet.getCheckedRadioButtonId();
//        radioButton1=findViewById(dietID);
//        int goalID = radioGroupGoal.getCheckedRadioButtonId();
//        radioButton2=findViewById(goalID);
//
//        String x = radioButton1.getText().toString().trim();
//        String y = radioButton2.getText().toString().trim();
//
//    }

}