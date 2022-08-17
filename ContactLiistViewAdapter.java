package com.example.addisu;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListViewAdapter extends ArrayAdapter<Contact> {

    private int layoutResource;

    private Activity activity;
    private ArrayList<Contact> contactList = new ArrayList<>();

    public CustomListViewAdapter(Activity activity, int resource,
                                 ArrayList<Contact> contactList)
    {

        super(activity, resource, contactList);
        this.activity = activity;
        this.layoutResource = resource;

        this.contactList = contactList;
        notifyDataSetChanged();
    }

    @Override

    public int getCount() {
        return contactList.size();
    }


    @Override

    public Contact getItem(int position) { return contactList.get(position);
    }

    @Override

    public int getPosition(Contact item) { return super.getPosition(item);
    }

    @Override

    public long getItemId(int position) { return super.getItemId(position);
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;

        ViewHolder holder = null;

        if(row == null || (row.getTag() == null)){ LayoutInflater inflater =

                LayoutInflater.from(activity);
            row = inflater.inflate(layoutResource, null);

            holder = new ViewHolder();
            holder.name = (TextView)

                    row.findViewById(R.id.nameTVV); holder.phone = (TextView)

                    row.findViewById(R.id.phoneTVV); holder.email = (TextView)
                    row.findViewById(R.id.emailTVV);

            row.setTag(holder);

        } else{
            holder = (ViewHolder) row.getTag();

        }

        holder.contact = getItem(position);

        holder.name.setText(holder.contact.getfName() + " " + holder.contact.getlName());

        holder.phone.setText(holder.contact.getPhone()); holder.email.setText(holder.contact.getEmail());

        row.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

            }
        });

        return row;
    }

    public class ViewHolder{
        Contact contact;
        TextView name, phone, email;
    }
