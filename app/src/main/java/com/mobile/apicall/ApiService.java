package com.mobile.apicall;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("todo.php")
    Call<List<Todo>> getTodoList();
}