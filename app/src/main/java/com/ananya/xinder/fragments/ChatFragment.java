package com.ananya.xinder.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thecode.tinderclone.R;
import com.ananya.xinder.activities.TinderCloneMainActivity;
import com.ananya.xinder.adapters.LikeAdapter;
import com.ananya.xinder.adapters.MessageListAdapter;
import com.ananya.xinder.entities.Like;
import com.ananya.xinder.entities.MessageItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment {


    View rootLayout;
    private static final String TAG = TinderCloneMainActivity.class.getSimpleName();
    private List<MessageItem> messageList;
    private List<Like> likeList;
    private MessageListAdapter mAdapter;
    private String[] messages = {"Let's Hangout", "You are so handsome", "Hey!", "Call me soon", "Give me your number, I will call you"};
    private int[] counts = {0, 3, 0, 0, 1};
    private int[] messagePictures = {R.drawable.user_woman_3, R.drawable.user_woman_4, R.drawable.user_woman_5, R.drawable.user_woman_6 , R.drawable.user_woman_7};
    private int[] likePictures = {R.drawable.user_woman_1, R.drawable.user_woman_2};
    private String[] messageNames = {"Riya", "Priya", "Tina", "Prite", "Meena"};
    private String[] likeNames = {"Muskaan", "Priya"};

    public ChatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootLayout = inflater.inflate(R.layout.fragment_chat, container, false);

        RecyclerView recyclerView = rootLayout.findViewById(R.id.recycler_view_messages);
        messageList = new ArrayList<>();
        mAdapter = new MessageListAdapter(getContext(), messageList, (TinderCloneMainActivity) getActivity());

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        prepareMessageList();


        prepareContactList();
        LikeAdapter contactAdapter = new LikeAdapter(getContext(), likeList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerViewContact =  rootLayout.findViewById(R.id.recycler_view_likes);
        recyclerViewContact.setLayoutManager(layoutManager);
        recyclerViewContact.setAdapter(contactAdapter);
        //new HorizontalOverScrollBounceEffectDecorator(new RecyclerViewOverScrollDecorAdapter(recyclerViewContact));


        return rootLayout;
    }


    private void prepareMessageList(){

        Random rand = new Random();
        int id = rand.nextInt(100);
        int i;
        for(i=0; i<5; i++) {
            MessageItem message = new MessageItem(id, messageNames[i], messages[i], counts[i], messagePictures[i]);
            messageList.add(message);
        }
    }

    private void prepareContactList(){
        likeList = new ArrayList<>();
        Random rand = new Random();
        int id = rand.nextInt(100);
        int i;
        for(i=0; i<2; i++) {
            Like like = new Like(id, likeNames[i], likePictures[i]);
            likeList.add(like);
        }
    }


}
