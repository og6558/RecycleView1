package com.example.recycleview1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ToggleButton tg;
    TextView tv5, tv6, tv7, tv8;
    Double [] arr2 = new Double[20];
    EditText et1,et2;
    RecyclerView recyclerView;
    List<item> items;
    MyAdapter adp;
    int count;
    double x1,x2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count =0;
        items = new ArrayList<item>();
        recyclerView = findViewById(R.id.rv);
        tg = (ToggleButton) findViewById(R.id.tg);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        tv5 = findViewById(R.id.tv5);
        tv6 = findViewById(R.id.tv6);
        tv7 = findViewById(R.id.tv7);
        tv8 = findViewById(R.id.tv8);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adp = new MyAdapter (getApplicationContext(), items, new ItemClickListner() {
            @Override
            public void onitemclick(int position) {
                if(count>0){
                    tv7.setText(Integer.toString(position));
                    double sum = arr2[0];
                    for(int k =1 ; k<position+1;k++){
                        sum = sum + arr2[k];
                    }
                    tv8.setText(Double.toString(sum));
                }

            }
        });
        recyclerView.setAdapter(adp);
        add1();


    }

    public void add1(){
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
        items.add(new item(""));
    }



    public void recyclestart(View view) {
        adp.notifyDataSetChanged();
        String st1 = et1.getText().toString();
        String st2 = et2.getText().toString();
        boolean dorrrl = dorel6969(st1);
        boolean dorrrl2 = dorel6969(st2);
        if(dorrrl==true && dorrrl2==true){
            count ++;
             x1 = Double.parseDouble(st1);
             x2 = Double.parseDouble(st2);
            boolean nom = tg.isChecked();
            if(nom == true){
                Mathemtical();
            }
            else

            {
                Geometrical();
            }
        }
        else{
            Toast.makeText(this, "you stupido!!", Toast.LENGTH_SHORT).show();
        }

    }

    public void Mathemtical(){
        for(int i=0; i<20;i++){
            arr2[i] = x1;
            int x  = dorelkrief(Double.toString(x1));
            String str1 = String.format("%.02f",x1);
            if(x>2){
                items.set(i,new item(str1 + "E" + Integer.toString(x-2)))  ;
            }
            else{
                items.set(i,new item(str1));
            }
            x1 = x1 + x2;
        }
    }

    public void Geometrical(){
        for(int ii=0; ii<20;ii++){
            arr2[ii] = x1;
            int y = dorelkrief(Double.toString(x1));
            String str4 = String.format("%.02f",x1);
            if(y>2){
                items.set(ii,new item(str4 + "E" + Integer.toString(y-2)));
            }
            else{
                items.set(ii, new item(str4)) ;
            }
            x1 = x1 * x2;
        }
    }

    public int dorelkrief(String lol){
        int q = lol.indexOf(".");
        int E = lol.indexOf("E");
        if(E==-1){
            return (lol.substring(q+1)).length();
        }
        else{
            return (lol.substring(q+1)).length()+Integer.parseInt(lol.substring(E+1));
        }
    }
    public static boolean dorel6969(String doreli){
        if(doreli.equals("") || doreli.equals(".") || doreli.equals("-.") || doreli.equals("-")){
            return(false);
        }
        else{
            return (true);
        }
    }


}