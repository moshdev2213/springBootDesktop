package com.example.demo;

import com.example.demo.Entity.User;
import com.example.demo.Entity.UserFX;
import com.example.demo.Retfofit.RetrofitService;
import com.example.demo.Retfofit.UserApi;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController {


    @FXML
    private Label welcomeText;

    @FXML
    private Label label;
    @FXML
    private TextField etName;
    @FXML
    private TextField etEmail;
    @FXML
    private TextField etStreet;
    @FXML
    private TextField etCity;
    @FXML
    private TextField etZip;
    @FXML
    private TextField etTel;
    @FXML
    private TextField etPass;
    @FXML
    private TextField etConfPass;
    @FXML
    private TableView<UserFX> table;
    @FXML
    private TableColumn<UserFX, String> NameColmn;
    @FXML
    private TableColumn<UserFX, String> EmailColmn;
    @FXML
    private TableColumn<UserFX, String> MobileColmn;
    @FXML
    private TableColumn<UserFX, String> CityColumn;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    private ObservableList<UserFX> usersObserve;
    private int myIndex=0;
    private String email ="";
    //Rest CAlling Starts Here

    @FXML
    public void Add(ActionEvent event){
        String etName,etEmail,etStreet,etCity,etZip,etTel,etPass,etConfPass;

        etName = this.etName.getText();
        etEmail = this.etEmail.getText();
        etStreet = this.etStreet.getText();
        etCity = this.etCity.getText();
        etZip = this.etZip.getText();
        etTel = this.etTel.getText();
        etPass = this.etPass.getText();
        etConfPass = this.etConfPass.getText();

        //alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);


        //api calling
        RetrofitService retrofitService = new RetrofitService();
        UserApi userApi= retrofitService.getRetrofit().create(UserApi.class);
        userApi.createUser(new User(
                etName,
                etEmail,
                etStreet,
                etCity,
                Integer.parseInt(etZip),
                etTel,
                etPass
        )).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Platform.runLater(() -> {
                    try {
                        alert.setTitle("User Registration");
                        table();

                        alert.setHeaderText("Record Added Success!");
                        alert.showAndWait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Platform.runLater(() -> {
                    try {
                        alert.setTitle("Student Registration");

                        alert.setHeaderText("Record Adding Failed!");
                        alert.showAndWait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

            }
        });
        table();
    }





    @FXML
    void Delete(ActionEvent event) {
        int userId=0;
        myIndex = table.getSelectionModel().getSelectedIndex();
        userId  = (table.getItems().get(myIndex).getId());
        //api calling
        RetrofitService retrofitService = new RetrofitService();
        UserApi userApi= retrofitService.getRetrofit().create(UserApi.class);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        userApi.deleteUser(userId).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Platform.runLater(() -> {
                    try {
                        alert.setTitle("User Registration");
                        table();

                        alert.setHeaderText("Record Deleted!");
                        alert.showAndWait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Platform.runLater(() -> {
                    try {
                        alert.setTitle("User Registration");

                        alert.setHeaderText("Record Deleted Failed!");
                        alert.showAndWait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

            }
        });
        table();
    }

    @FXML
    void Update(ActionEvent event) {

        int userId=0;
        myIndex = table.getSelectionModel().getSelectedIndex();
        userId  = (table.getItems().get(myIndex).getId());
        //api calling
        RetrofitService retrofitService = new RetrofitService();
        UserApi userApi= retrofitService.getRetrofit().create(UserApi.class);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        String etName,etEmail,etStreet,etCity,etZip,etTel,etPass,etConfPass;

        etName = this.etName.getText();
        etEmail = this.etEmail.getText();
        etStreet = this.etStreet.getText();
        etCity = this.etCity.getText();
        etZip = this.etZip.getText();
        etTel = this.etTel.getText();
        etPass = this.etPass.getText();
        etConfPass = this.etConfPass.getText();

        userApi.updateUser(userId,new User(
                etName,
                etEmail,
                etStreet,
                etCity,
                Integer.parseInt(etZip),
                etTel,
                etPass
        )).enqueue(new Callback<Void>() {

            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Platform.runLater(() -> {
                    try {
                        alert.setTitle("User Registration");
                        table();

                        alert.setHeaderText("Record Updated!");
                        alert.showAndWait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Platform.runLater(() -> {
                    try {
                        alert.setTitle("User Registration");
                        alert.setHeaderText("Update Failed!");
                        alert.showAndWait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        });
        table();

    }
    //Ends Here
    public void table()
    {
        etName.setText("");
        etCity.setText("");
        etEmail.setText("");
        etPass.setText("");
        etConfPass.setText("");
        etStreet.setText("");
        etZip.setText("");
        etTel.setText("");
        // Clear the existing data
        usersObserve.clear();

        //api calling
        RetrofitService retrofitService = new RetrofitService();
        UserApi userApi= retrofitService.getRetrofit().create(UserApi.class);

        userApi.getAllUser().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    // Convert the API response objects to the data model objects and add them to the ObservableList
                    List<User> users = response.body();
                    for (User user : users) {
                        UserFX userFX = new UserFX(user.getId(), user.getName(), user.getEmail(), user.getStreet(),user.getCity(),(user.getZipcode()),user.getTel(),user.getPassword());
                        usersObserve.add(userFX);
                    }
                } else {
                    // Handle the API error response
                    System.out.println("API call failed: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                // Handle the API call failure
                System.out.println("API call failed: " + t.getMessage());
            }
        });


    }

    @FXML
    public void initialize() {
        // Initialize the ObservableList
        usersObserve = FXCollections.observableArrayList();

        // Set the table items
        table.setItems(usersObserve);

        // Set the cell value factories
        EmailColmn.setCellValueFactory(f -> f.getValue().emailProperty());
        NameColmn.setCellValueFactory(f -> f.getValue().nameProperty());
        MobileColmn.setCellValueFactory(f -> f.getValue().telProperty());
        CityColumn.setCellValueFactory(f -> f.getValue().cityProperty());

        // Set the row factory
        table.setRowFactory(tv -> {
            TableRow<UserFX> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    myIndex = table.getSelectionModel().getSelectedIndex();
                    email = String.valueOf(table.getItems().get(myIndex).getEmail());
                    etName.setText(table.getItems().get(myIndex).getName());
                    etCity.setText(table.getItems().get(myIndex).getCity());
                    etEmail.setText(table.getItems().get(myIndex).getEmail());
                    etPass.setText(table.getItems().get(myIndex).getPassword());
                    etConfPass.setText(table.getItems().get(myIndex).getPassword());
                    etStreet.setText(table.getItems().get(myIndex).getStreet());
                    etZip.setText(String.valueOf(table.getItems().get(myIndex).getZipcode()));
                    etTel.setText(table.getItems().get(myIndex).getTel());
                }
            });
            return myRow;
        });

        // Populate the table initially
        table();
    }

}