package com.example.addisu;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ContactListActivity extends AppCompatActivity {

    private DatabaseHandler dba;

    private ArrayList<Contact> contactList = new ArrayList<>(); private CustomListViewAdapter contactAdapter;
    private ListView listView;
    private Contact contact;
    private TextView totalCount;

    @Override

    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); setContentView(R.layout.activity_contact_list); listView = findViewById(R.id.list); totalCount = findViewById(R.id.totalCountTV);

        refreshData();
    }

    public void refreshData(){
        contactList.clear();

        dba = new DatabaseHandler(getApplicationContext()); ArrayList<Contact> contactsFromDB = dba.getContacts(); int totalContacts = dba.getTotalItems(); totalCount.setText(String.valueOf(totalContacts));

        for(int i = 0; i < contactsFromDB.size(); i ++){ String fname = contactsFromDB.get(i).getfName(); String lname = contactsFromDB.get(i).getlName(); String phoneN = contactsFromDB.get(i).getPhone(); String emailA = contactsFromDB.get(i).getEmail(); int contactId =

                contactsFromDB.get(i).getContactId();

            contact = new Contact();

            contact.setfName(fname);
            contact.setlName(lname);
            contact.setPhone(phoneN);
            contact.setEmail(emailA);

            contact.setContactId(contactId);

            contactList.add(contact);
        }

        dba.close();
        contactAdapter = new

                CustomListViewAdapter(ContactListActivity.this, R.layout.row, contactsFromDB);

        listView.setAdapter(contactAdapter);
    }

}
