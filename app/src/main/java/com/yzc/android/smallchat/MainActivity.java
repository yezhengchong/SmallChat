package com.yzc.android.smallchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    RecyclerView recyclerView;
    EditText editText;
    Button button;
    ChatAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);

        editText = (EditText) findViewById(R.id.input_text);
        button = (Button) findViewById(R.id.send);
        button.setOnClickListener(this);
        mAdapter = new ChatAdapter(this);

        recyclerView.setAdapter(mAdapter);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        initMsgs();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.send) {
            String content = editText.getText().toString();
            int imageId = R.drawable.ic_launcher;
            Msg msg = new Msg(content, Msg.TYPE_SENT, imageId);
            mAdapter.addMsg(msg);
            editText.setText("");
            recyclerView.smoothScrollToPosition(mAdapter.getItemCount() - 1);
        }
    }

    private void initMsgs() {
        int imageId = R.drawable.ic_launcher;
        Msg msg1 = new Msg("Hello", Msg.TYPE_RECEIVED, imageId);
        mAdapter.addMsg(msg1);
        Msg msg2 = new Msg("Hello", Msg.TYPE_SENT, imageId);
        mAdapter.addMsg(msg2);
    }
}
