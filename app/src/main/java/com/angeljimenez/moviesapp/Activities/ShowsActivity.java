package com.angeljimenez.moviesapp.Activities;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.angeljimenez.moviesapp.R;
import com.angeljimenez.moviesapp.adapter.ShowAdapter;
import com.angeljimenez.moviesapp.Utils.Total;
import com.angeljimenez.moviesapp.databinding.ActivityShowsBinding;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShowsActivity extends AppCompatActivity {
    private ActivityShowsBinding binding;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        leerDatos();

    }

    private void leerDatos() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String ruta = Total.rutaServicio+"movies.php";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, ruta,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("DATOS",response);
                        LlenarLista(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("DATOS",error.getMessage());
            }
        }){

        };

        queue.add(stringRequest);

    }

    private void LlenarLista(String response) {
        ArrayList arrayList = new ArrayList<HashMap<String,String>>();
        try {
            JSONArray jsonArray = new JSONArray(response);
            for(int i = 0;i< jsonArray.length();i++){
                String id = jsonArray.getJSONObject(i).getString("id");
                String nombre = jsonArray.getJSONObject(i).getString("nombre");
                String rating = jsonArray.getJSONObject(i).getString("rating");
                String description = jsonArray.getJSONObject(i).getString("description");
                String genre = jsonArray.getJSONObject(i).getString("genre");
                String duration = jsonArray.getJSONObject(i).getString("duration");
                String image = jsonArray.getJSONObject(i).getString("image");
                HashMap<String,String> map = new HashMap<>();
                map.put("id",id);
                map.put("nombre",nombre);
                map.put("rating",rating);
                map.put("description",description);
                map.put("genre",genre);
                map.put("duration",duration);
                map.put("image",image);
                arrayList.add(map);
            }

            ShowAdapter showAdapter = new ShowAdapter(arrayList);
            binding.rvWatched.setAdapter(showAdapter);

            binding.rvWatched.setLayoutManager(new GridLayoutManager(this,2));
            /*
            ShowAdapter showAdapter = new ShowAdapter(arrayList);
            binding.rvWatched.setAdapter(showAdapter);
            //binding.rvEmployees.setLayoutManager(new LinearLayoutManager(this));

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            binding.rvWatched.setLayoutManager((linearLayoutManager));*/
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}