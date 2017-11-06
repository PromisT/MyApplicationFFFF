package com.example.nyamundapt.myapplicationffff;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ProfileAdapter extends ArrayAdapter<ProfList> {

    private Activity context;
    private List<ProfList> profList;

    public ProfileAdapter(Activity context, List<ProfList> profList) {
        super(context,R.layout.activity_profile,profList);
        this.context = context;
        this.profList = profList;
    }



    @Override
    public int getCount()
    {
        return profList.size();
    }


    @Override
    public ProfList getItem(int position)
    {
        return profList.get(position);
    }
    @Override
    public long getItemId(int position)
    {
        return position;
    }




    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       // View listItemView = convertView;
        if (convertView ==null)
        {
            convertView=  LayoutInflater.from(context).inflate(R.layout.customprofilelist,parent,false);

        }


        TextView eName=(TextView)convertView.findViewById(R.id.profileName);
        TextView eDescription=(TextView)convertView.findViewById(R.id.profileDob);
        ImageView ePic = (ImageView)convertView.findViewById(R.id.pic);
//        TextView eName=(TextView)convertView.findViewById(R.id.eventName);
//        TextView eName=(TextView)convertView.findViewById(R.id.eventName);
//        TextView eName=(TextView)convertView.findViewById(R.id.eventName);
//        TextView eName=(TextView)convertView.findViewById(R.id.eventName);
//        TextView eName=(TextView)convertView.findViewById(R.id.eventName);
//        TextView eName=(TextView)convertView.findViewById(R.id.eventName);
//        TextView eName=(TextView)convertView.findViewById(R.id.eventName);


        final ProfList profList=this.getItem(position);

//        eDescription.setText(profList.getChildsSurname());
//        eName.setText(profList.getChildsAge());
        eDescription.setText(profList.getChildsDob());
        eName.setText(profList.getChildsName());
        ePic.setImageResource(profList.getPhoto());
//        eName.setText(profList.getChildsAddress());
//        eName.setText(profList.getChildsAllergies());
//        eName.setText(profList.getChildsFavmeal());
//        eName.setText(profList.getChildsPname());
//        eName.setText(profList.getChildsPcontact());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,profList.getChildsName(),Toast.LENGTH_LONG).show();
            }
        });
        return convertView;
    }
}
