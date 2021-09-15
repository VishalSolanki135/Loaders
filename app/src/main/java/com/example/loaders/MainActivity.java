    package com.example.loaders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Employee>> {

    EmployeeAdapter employeeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        employeeAdapter = new EmployeeAdapter(this, new ArrayList<>());
        ListView listView = (ListView) findViewById(R.id.employees);
        listView.setAdapter(employeeAdapter);
        getSupportLoaderManager().initLoader(1, null, this).forceLoad();
    }

    public MainActivity() {
        super();
    }

    @Override
    public Loader<List<Employee>> onCreateLoader(int id,  Bundle args) {
        return new EmployeeLoader(MainActivity.this);
    }

    @Override
    public void onLoadFinished(Loader<List<Employee>> loader, List<Employee> data) {
        employeeAdapter.setEmployees(data);
    }

    @Override
    public void onLoaderReset( Loader<List<Employee>> loader) {
        employeeAdapter.setEmployees(new ArrayList<>());
    }
}