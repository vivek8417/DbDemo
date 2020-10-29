package com.example.dbdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dbdemo.data.MyDbHandler;
import com.example.dbdemo.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //ListView listView;
    Button addButton,allContactButton,deleteButton,updateButton;
    EditText name,Phone,id,updateName,updatePhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        Phone=findViewById(R.id.phone);
        id=findViewById(R.id.id);
        updateName=findViewById(R.id.updateName);
        updatePhone=findViewById(R.id.updatePhone);
        addButton=findViewById(R.id.addButton);
        allContactButton=findViewById(R.id.allContactButton);
        deleteButton=findViewById(R.id.deleteButton);
        updateButton=findViewById(R.id.updateButton);
        MyDbHandler db= new MyDbHandler(MainActivity.this);

        allContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AllContacts.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "All Contacts", Toast.LENGTH_SHORT).show();
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDbHandler db= new MyDbHandler(MainActivity.this);
                Contact contact=new Contact();
                contact.setName(name.getText().toString());
                contact.setPhoneNumber(Phone.getText().toString());
                db.addContact(contact);
                Toast.makeText(MainActivity.this, "Add contact", Toast.LENGTH_SHORT).show();
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDbHandler db= new MyDbHandler(MainActivity.this);
                Contact contact=new Contact();
                contact.setName(name.getText().toString());
                contact.setPhoneNumber(Phone.getText().toString());
                db.deleteContact(name.getText().toString());
                Toast.makeText(MainActivity.this, "Delete contact", Toast.LENGTH_SHORT).show();
            }
        });
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDbHandler db= new MyDbHandler(MainActivity.this);
                Contact contact=new Contact();
                contact.setId(Integer.parseInt(id.getText().toString()));
                contact.setName(updateName.getText().toString());
                contact.setPhoneNumber(updatePhone.getText().toString());
                db.updateContact(contact);
                Toast.makeText(MainActivity.this, "Update Contact", Toast.LENGTH_SHORT).show();
            }
        });
      /*  Contact contact=new Contact();
        int affectedRows=db.updateContact(contact);

*/
      /*  Contact contact=new Contact();
        contact.setId(contact.getId()+1);
        contact.setName("Vivek");
        contact.setPhoneNumber("1234567890");
        db.addContact(contact);
        Log.d("database", "name: "+contact.getName()+contact.getPhoneNumber());

        Contact contact_2=new Contact();
        contact_2.setName("Singh");
        contact_2.setPhoneNumber("111111111111");
        db.addContact(contact_2);
        Log.d("database", "name: "+contact_2.getName()+contact_2.getPhoneNumber());
        //update
        contact_2.setId(13);
        contact_2.setName("Changed Singh");
        contact_2.setPhoneNumber("0000000000");
        int affectedRows=db.updateContact(contact_2);
        //deletion
        db.deleteContactById(1);
        db.deleteContactById(2);
        db.deleteContactById(3);


        Log.d("database", "No of affected rows: "+affectedRows);*/
        //ArrayList<String> contacts=new ArrayList<>();
      //  listView=findViewById(R.id.listView);
        //get the contact
       /* List<Contact> allContact=db.getAllContact();
        for(Contact contact1: allContact )
        {
            Log.d("Database", "Id: "+contact1.getId()+"\n"+"Name: "+contact1.getName()+"\n"+"Phone: "+contact1.getPhoneNumber()+"\n");
          //  contacts.add(contact1.getName()+"("+contact1.getPhoneNumber()+")");
        }*/
        //ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,contacts);
        //listView.setAdapter(arrayAdapter);
        Log.d("database", "I have "+db.getCount()+" contacts in database");
    }
}