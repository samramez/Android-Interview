package com.apppartner.androidprogrammertest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.apppartner.androidprogrammertest.R;
import com.apppartner.androidprogrammertest.models.ChatData;

import java.util.List;

/**
 * Created on 12/23/14.
 *
 * @author Thomas Colligan
 */
public class ChatsArrayAdapter extends ArrayAdapter<ChatData>
{
    public ChatsArrayAdapter(Context context, List<ChatData> objects)
    {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ChatCell chatCell = new ChatCell();

        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.cell_chat, parent, false);

        chatCell.usernameTextView = (TextView) convertView.findViewById(R.id.usernameTextView);
        chatCell.messageTextView = (TextView) convertView.findViewById(R.id.messageTextView);
        chatCell.userImageView = (ImageView) convertView.findViewById(R.id.userImageView) ;

        ChatData chatData = getItem(position);

        // We want to specify the owner of the picture
        String owner = chatData.username;
        int picOwner = whosePicture(owner);

        chatCell.usernameTextView.setText(chatData.username);
        chatCell.messageTextView.setText(chatData.message);
        chatCell.userImageView.setBackgroundResource(picOwner);
        return convertView;
    }

    private static class ChatCell
    {
        TextView usernameTextView;
        TextView messageTextView;
        ImageView userImageView;
    }

    private int whosePicture(String userTextView){

        int[] imageIds = {
                R.drawable.justin,
                R.drawable.drew,
                R.drawable.greg,
                R.drawable.derrick
        };

        if( userTextView.contains("Justin") )
            return imageIds[0];
        else if(userTextView.contains("Drew") )
            return imageIds[1];
        else if( userTextView.contains("Greg") )
            return imageIds[2];
        else
            return imageIds[3];
    }


}
