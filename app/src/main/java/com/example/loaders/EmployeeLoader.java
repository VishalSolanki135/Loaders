package com.example.loaders;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.ArrayList;
import java.util.List;

public class EmployeeLoader extends AsyncTaskLoader<List<Employee>> {
    public EmployeeLoader(Context context) {
        super(context);
    }

    @Override
    public List<Employee> loadInBackground() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("emp1", "Vishal"));
        list.add(new Employee("emp2", "Kajal"));
        list.add(new Employee("emp3", "Harshit"));
        return list;
    }
}
