package com.example.testiebaw;

import java.util.concurrent.ExecutionException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
 
public class MainActivity extends Activity {
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         
       Httpres hooman = new Httpres(this);
       hooman.execute();
       try {
		String tmp = hooman.get();
		//Toast.makeText(this, tmp, Toast.LENGTH_SHORT).show();
		JSONObject myjson = new JSONObject(tmp);
		//myjson.getBoolean("done");
		JSONObject t1 = new JSONObject(myjson.getString("task"));
		
		TextView test = (TextView) findViewById(R.id.mytext);
		test.setText(t1.getString("title"));
       		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
       		e.printStackTrace();} 
       		catch (ExecutionException e) {
		// TODO Auto-generated catch block
       		e.printStackTrace();
       	} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    
 
}