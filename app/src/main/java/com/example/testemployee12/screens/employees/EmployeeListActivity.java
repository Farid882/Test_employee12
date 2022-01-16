package com.example.testemployee12.screens.employees;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.testemployee12.R;
import com.example.testemployee12.adapters.EmployeeAdapter;
import com.example.testemployee12.api.ApiFactory;
import com.example.testemployee12.api.ApiService;
import com.example.testemployee12.pojo.Employee;
import com.example.testemployee12.pojo.EmployeeResponse;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class EmployeeListActivity extends AppCompatActivity implements EmployeeListView {
    private RecyclerView recyclerViewEmployee;
    private EmployeeAdapter adapter;
    private EmployeeListPattern pattern;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewEmployee=findViewById(R.id.recyclerViewEmployee);
        recyclerViewEmployee.setLayoutManager(new LinearLayoutManager(this));
        adapter=new EmployeeAdapter();
        adapter.setEmployees(new ArrayList<>());
        pattern=new EmployeeListPattern(this);
        recyclerViewEmployee.setAdapter(adapter);
        pattern.loadData();
    }

    @Override
    protected void onDestroy() {
        pattern.disposeDisposable();
        super.onDestroy();
    }

    @Override
    public void showData(List<Employee> employees) {
        adapter.setEmployees(employees);
    }

    @Override
    public void showError() {
        Toast.makeText(EmployeeListActivity.this, "Error", Toast.LENGTH_SHORT).show();
    }
}