package com.example.dbdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.dbdemo.data.MyDbHandler;
import com.example.dbdemo.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class AllContacts extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_contacts);
        listView=findViewById(R.id.listView);
       // Intent intent=getIntent();
        get();
       /* MyDbHandler db= new MyDbHandler(AllContacts.this);
        ArrayList<String> contacts=new ArrayList<>();
        List<Contact> allContact=db.getAllContact();
        for(Contact contact1: allContact )
        {
            Log.d("Database", "Id: "+contact1.getId()+"\n"+"Name: "+contact1.getName()+"\n"+"Phone: "+contact1.getPhoneNumber()+"\n");
            //  contacts.add(contact1.getName()+"("+contact1.getPhoneNumber()+")");
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,contacts);
        listView.setAdapter(arrayAdapter);*/
    }
    public void get()
    {
        MyDbHandler db= new MyDbHandler(this);
        ArrayList<String> contacts=new ArrayList<>();
        List<Contact> allContact=db.getAllContact();

        for(Contact contact1: allContact )
        {
            Log.d("Database", "Id: "+contact1.getId()+"\n"+"Name: "+contact1.getName()+"\n"+"Phone: "+contact1.getPhoneNumber()+"\n");
            contacts.add(contact1.getName()+"("+contact1.getPhoneNumber()+")");
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,contacts);
        listView.setAdapter(arrayAdapter);
    }
}