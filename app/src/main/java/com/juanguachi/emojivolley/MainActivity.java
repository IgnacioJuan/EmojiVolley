package com.juanguachi.emojivolley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.juanguachi.emojivolley.model.Emoji;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter arrayAdapter;
    ArrayList<String> datos= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listemojis);
        arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,datos);
        listView.setAdapter(arrayAdapter);
        //Recibir datos desde api.
        getdatos();
    }

    private  void getdatos(){
        String url ="https://emojihub.herokuapp.com/api/all";
        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(url, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                //Recibir el Json y pasar a Publicacion.
                pasarJson(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //MANEJAMOS EL ERROR.
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
            }
        }
        );
        //Enviamos una peticion tipo get al endpoiint
        Volley.newRequestQueue(this).add(jsonArrayRequest);
    }

    private void pasarJson( JSONArray array){

        for(int i=0;i<array.length();i++){
            JSONObject json=null;
            Emoji emoji = new Emoji();

            try {
                json=array.getJSONObject(i);

                emoji.setCategory(json.getString("category"));
                emoji.setGroup(json.getString("group"));
                //emoji.setHtmlCode((List<String>) json.getJSONArray("htmlCode"));
                emoji.setName(json.getString("name"));
                //emoji.setUnicode((List<String>) json.getJSONArray("unicode"));
                datos.add(emoji.getName());
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        arrayAdapter.notifyDataSetChanged();
    }
}