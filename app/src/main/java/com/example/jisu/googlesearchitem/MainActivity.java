package com.example.jisu.googlesearchitem;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button; //리사이클 추가 버튼
    private Adapter adapter;
    private EditText edttext;
    private LinearLayoutManager manager;
    private RecyclerView recyclerView;
    private ArrayList<String> list =new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        button=findViewById(R.id.button);
        edttext=findViewById(R.id.edttext);
        adapter=new Adapter(R.layout.item_list,list);
        manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new  RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                String str=list.get(position);
                Uri uri = Uri.parse("https://www.google.com/search?q="+str+"&oq="+str+"&aqs=chrome");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("com.android.chrome");
                   startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                list.add(edttext.getText().toString());
                adapter.notifyDataSetChanged();
                break;
        }
    }
}
