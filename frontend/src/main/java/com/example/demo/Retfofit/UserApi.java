package com.example.demo.Retfofit;

import com.example.demo.Entity.User;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface UserApi {
    @GET("/api/users")
    Call<List<User>> getAllUser();

    @POST("/api/users")
    Call<User> createUser(@Body User user);

    @DELETE("/api/users/{id}")
    Call<Void>deleteUser(@Path("id") int id);

    @PUT("/api/users/{id}")
    Call<Void>updateUser(@Path("id") int id,@Body User user);
}
