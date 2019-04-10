package com.edu.kiet.feedbacksignout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    int[] icons={R.drawable.ic_share_black_24dp,R.drawable.ic_announcement_black_24dp,R.drawable.ic_web_black_24dp,R.drawable.ic_star_border_black_24dp,R.drawable.ic_subdirectory_arrow_left_black_24dp};
    String[] settings = {"Share App","Feedback","About","Rate us on Google play","Sign out"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ListAdapter theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, settings);

        ListView theListView = findViewById(R.id.ListView);

        theListView.setAdapter(theAdapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 if(position==1){
                     Intent feedback=new Intent(view.getContext(), feedback.class);
                     startActivityForResult(feedback,0);

                 }

                 if(position==4){
                     FirebaseAuth.getInstance().signOut();
                     Toast.makeText(MainActivity.this,"Signed Out successfully",Toast.LENGTH_SHORT).show();
//                     finish();
//                     startActivity(new Intent(this,MainActivity.class));

                 }

            }
        });
    }

//    class CustomAdapter extends BaseAdapter{
//
//        @Override
//        public int getCount() {
//            return icons.length;
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return null;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return 0;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            convertView  =getLayoutInflater().inflate(R.layout.customlistlayout,null);
//            return null;
//        }
//    }
}
