package com.example.android.navigationdrawerexample;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;

public class Httpres extends AsyncTask<Void, Void, String>
{

	private Context con;
	public static String tnam;
	public static String unam;
	public static String pnum;
	
	private static String server_add = "http://192.168.56.1:5000/todo/api/v1.0/....../?teamName="+tnam+"&userName="+unam+"&phone="+pnum;

	public Httpres(Context cn) {
		// TODO Auto-generated constructor stub
		con = cn;
	}


	public void setContext(Context context)
	{
		con = context;
	}

	
	@Override
	public String doInBackground(Void... params) 
	{
        HttpResponse response = null;
        InputStream in = null;
        String line = null;
		try 
		{
			response = new DefaultHttpClient().execute(new HttpGet(server_add));
			in = response.getEntity().getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	        StringBuilder str = new StringBuilder();
	        while((line = reader.readLine()) != null)
			    str.append(line);
	        in.close();
	      //  destory();
	        return str.toString();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		//	destory();
			return "";
		}
	}

}
