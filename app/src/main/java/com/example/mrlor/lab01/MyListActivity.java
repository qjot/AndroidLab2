package com.example.mrlor.lab01;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyListActivity extends ListActivity {

    private TextView text;
    private List<String> listValues;
    private ListView list;
    private ArrayAdapter<String> myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);
        list = getListView();
        listValues = new ArrayList<String>();
        seedData(listValues);
        myAdapter = new ArrayAdapter<String>(this, R.layout.activity_my_list, R.id.listLabel, listValues);

        list.setAdapter(myAdapter);
    }

    private void seedData(List<String> listValues) {
        Person temPerson1 = new Person("Karol", "Januszczak");
        Person temPerson2 = new Person("Krzysztof", "Głuszak");
        Person temPerson3 = new Person("Maciej", "Kit");
        Person temPerson4 = new Person("Bartłomiej", "Nowakowski");
        Person temPerson5 = new Person("Magdalena", "Pastuszak");

        listValues.add(temPerson1.toString());
        listValues.add(temPerson2.toString());
        listValues.add(temPerson3.toString());
        listValues.add(temPerson4.toString());
        listValues.add(temPerson5.toString());
    }
}
