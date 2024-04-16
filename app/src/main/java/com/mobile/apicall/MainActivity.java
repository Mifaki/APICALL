package com.mobile.apicall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvTodoContainer;
    private TodoAdapter todoAdapter;
    private List<Todo> todoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvTodoContainer = findViewById(R.id.rvTodoContainer);
        rvTodoContainer.setLayoutManager(new LinearLayoutManager(this));

        todoList = new ArrayList<>();
        todoAdapter = new TodoAdapter(todoList);
        rvTodoContainer.setAdapter(todoAdapter);

        fetchData();
    }
    private void fetchData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://mgm.ub.ac.id/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<Todo>> call = apiService.getTodoList();
        call.enqueue(new Callback<List<Todo>>() {
            @Override
            public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    todoList.clear();
                    todoList.addAll(response.body());
                    todoAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Todo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}