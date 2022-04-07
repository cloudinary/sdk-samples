package com.example.cloudinarysampleapp_android.screens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.example.cloudinarysampleapp_android.R;
import java.util.ArrayList;
import java.util.List;

public class MainViewMvcImpl implements OnButtonClickListener, MainViewMvc {

    View rootView;

    private Button btnUpload;
    private Button btnTransform;
    private ImageView ivUpload;
    private ImageView ivTransform;
    private ImageView ivLocal;

private final List<Listener> listeners = new ArrayList<>(1);

    public MainViewMvcImpl(LayoutInflater inflater , ViewGroup parent) {
        rootView = inflater.inflate(R.layout.activity_main, parent, false);
        getViews();
        setLocalImage();
        setButtons();
    }

    @Override
    public void registerListener(Listener listener) {
        listeners.add(listener);
    }

    @Override
    public void unregisterListerner(Listener listener) {
        listeners.remove(listener);
    }

    @Override
    public View getRootView() {
        return rootView;
    }

    private void getViews() {
        btnUpload = findViewById(R.id.btnUpload);
        btnTransform = findViewById(R.id.btnTransform);
        ivUpload = findViewById(R.id.ivUpload);
        ivTransform = findViewById(R.id.ivTransform);
        ivLocal = findViewById(R.id.ivLocal);
    }

    private void setLocalImage() {
        ivLocal.setImageDrawable(getContext().getResources().getDrawable(R.drawable.cld_sample));
    }

    private void setButtons() {
        btnUpload.setOnClickListener(view -> {
            onButtonClick(btnUpload.getId());
        });

        btnTransform.setOnClickListener(view -> {
            onButtonClick(btnTransform.getId());
        });
    }

    private Context getContext() {
        return getRootView().getContext();
    }

    private <T extends View>T findViewById(int id) {
        return getRootView().findViewById(id);
    }

    public ImageView getImageView(ImageType type) {
        switch (type) {
            case Upload:
                return ivUpload;
            case Transform:
                return ivTransform;
            default:
                return null;
        }
    }

    @Override
    public void onButtonClick(int buttonId) {
        for (Listener listener : listeners) {
            listener.OnButtonClicked(buttonId);
        }
    }
}

enum ImageType {
    Upload,
    Transform
}
