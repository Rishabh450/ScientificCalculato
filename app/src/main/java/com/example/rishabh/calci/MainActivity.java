package com.example.rishabh.calci;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.VibrationEffect;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{



    Button plus,minus,multiply,divide,clear,equals,bc,sin,cos,tan,log,ln,power,e,pi,inverse,spk;
    EditText editText;Double op1,op2; int pid;
    TextToSpeech t1;
    public void speak(View view)
    {
        if(editText.getText().toString().compareTo("")!=0)
        t1.speak("the answer is "+editText.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
    }
    protected void exitByBackKey() {

        AlertDialog alertbox = new AlertDialog.Builder(this)
                .setMessage("Do you want to exit calci?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {

                        finish();
                        //close();


                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                })
                .show();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        plus.setOnClickListener(MainActivity.this);
        minus.setOnClickListener(MainActivity.this);
        multiply.setOnClickListener(MainActivity.this);
        divide.setOnClickListener(MainActivity.this);
        clear.setOnClickListener(MainActivity.this);
        equals.setOnClickListener(MainActivity.this);
        cos.setOnClickListener(MainActivity.this);
        sin.setOnClickListener(MainActivity.this);
        tan.setOnClickListener(MainActivity.this);
        log.setOnClickListener(MainActivity.this);
        ln.setOnClickListener(MainActivity.this);
        power.setOnClickListener(MainActivity.this);
        e.setOnClickListener(MainActivity.this);
        inverse.setOnClickListener(MainActivity.this);
        pi.setOnClickListener(MainActivity.this);
        if(editText.getText().toString().compareTo("")!=0) {
            spk.setEnabled(false);
            spk.setBackground(getDrawable(R.drawable.button_disa));
        }
        t1= new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                t1.setLanguage(Locale.ENGLISH);
                t1.setSpeechRate(0.5f);
            }


        });





    }

    void init()
    {
        plus=findViewById(R.id.btn_plus);
        minus=findViewById(R.id.btn_minus);
        multiply=findViewById(R.id.btn_mul);
        divide=findViewById(R.id.btn_div);
        clear=findViewById(R.id.btn_clr);
        equals=findViewById(R.id.btn_equal);
        editText=findViewById(R.id.edit_text);
        log=findViewById(R.id.log);
        ln=findViewById(R.id.ln);
        cos=findViewById(R.id.cos);
        sin=findViewById(R.id.sin);
        tan=findViewById(R.id.tan);
        power=findViewById(R.id.power);
        inverse=findViewById(R.id.inverse);
        e=findViewById(R.id.e);
        pi=findViewById(R.id.pi);
        spk=findViewById(R.id.speak);



    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        Double ans=0.0;
        if(id==R.id.e)
            editText.setText(String.valueOf(Math.E));
        if(id==R.id.pi)
            editText.setText(String.valueOf(Math.PI));


        if(editText.getText().toString().compareTo("")!=0){
            if(id==R.id.sin)
            {
                op1=new Double(editText.getText().toString())*Math.PI/180;
                ans=Math.sin(op1);
                editText.setText(String.valueOf(ans));
            }
            if(id==R.id.cos)
            {
                op1=new Double(editText.getText().toString())*Math.PI/180;
                ans=Math.cos(op1);
                editText.setText(String.valueOf(ans));
            }
            if(id==R.id.tan)
            {
                op1=new Double(editText.getText().toString())*Math.PI/180;
                ans=Math.tan(op1);
                editText.setText(String.valueOf(ans));
            }
            if(id==R.id.log)
            {
                op1=new Double(editText.getText().toString());
                ans=Math.log10(op1);
                editText.setText(String.valueOf(ans));
            }
            if(id==R.id.ln)
            {
                op1=new Double(editText.getText().toString());
                ans=Math.log(op1);
                editText.setText(String.valueOf(ans));
            }
            if(id==R.id.inverse)
            {
                op1=new Double(editText.getText().toString());
                ans=1.0/op1;
                editText.setText(String.valueOf(ans));
            }





        if(id==R.id.btn_plus||id==R.id.btn_minus||id==R.id.btn_mul||id==R.id.btn_div||id==R.id.power)
        {op1=new Double(editText.getText().toString());editText.setText("");pid=id;}



        else if(id==R.id.btn_clr){ op1=null;op2=null;editText.setText("");}
        else if(id==R.id.btn_equal){ if(op1 !=null)
            op2=new Double(editText.getText().toString());


            if(pid==R.id.btn_plus)
                ans=op1+op2;
            if(pid==R.id.btn_minus)
                ans=op1+op2;
            if(pid==R.id.btn_mul)
                ans=op1*op2;
            if(pid==R.id.btn_div)
                ans=op1/op2;
            if(pid==R.id.power)
                ans=Math.pow(op1,op2);






        editText.setText(String.valueOf(ans));

        }




        }



}

}

