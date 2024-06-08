package com.example.androidassignments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class ChatWindow extends AppCompatActivity {

    private ListView chatListView;
    private EditText chatText;
    private Button sendButton;
    private ArrayList<String> chatMsgs;
    public String tag = "ChatWindow";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chat_window);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        chatText = (EditText) findViewById(R.id.chat_input_edit_text);
        chatListView = (ListView) findViewById(R.id.chat_list_view);
        sendButton = (Button) findViewById(R.id.send_button);
        chatMsgs = new ArrayList<>();

        ChatAdapter messageAdapter =new ChatAdapter(this);
        chatListView.setAdapter(messageAdapter);

        sendButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i(tag, "onClick Initiated");
                        String message = (String) chatText.getText().toString();
                        //String message = (String) ((EditText) findViewById(R.id.chat_input_edit_text)).getText().toString();
                        if(!message.isEmpty()){
                            chatMsgs.add(message);
                            Log.i(tag,message);
                        }
                        chatText.setText("");
                        messageAdapter.notifyDataSetChanged();

                    }
                }
        );


    }
    /*private class ChatAdapter extends ArrayAdapter<String> {

    }

    public ChatAdapter(Context ctx) {
        super(ctx, 0);
    }*/
    private class ChatAdapter extends ArrayAdapter<String> {
        public ChatAdapter(Context ctx) {
            super(ctx,0);
        }

        public int getCount(){
            return chatMsgs.size();
        }

        public String getItem(int pos){
            return chatMsgs.get(pos);
        }

        public View getView(int pos, View convertView, ViewGroup parent){
            LayoutInflater inflater = ChatWindow.this.getLayoutInflater();
            View result = null ;
            Log.i(tag, "Attempted from getView");
            if(pos%2 == 0)
                result = inflater.inflate(R.layout.chat_row_incoming, null);

            else
                result = inflater.inflate(R.layout.chat_row_outgoing, null);
            TextView message = (TextView)result.findViewById(R.id.message_text);
            message.setText(getItem(pos)); // get the string at position
            return result;
        }
    }

}
