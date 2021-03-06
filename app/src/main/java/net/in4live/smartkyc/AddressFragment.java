package net.in4live.smartkyc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.goka.walker.WalkerFragment;
import com.goka.walker.WalkerLayout;

import net.in4live.farmersdata.R;

/**
 * Created by Jaymo on 02/07/2016.
 */
public class AddressFragment extends WalkerFragment {
    public static final String TAG = AddressFragment.class.getSimpleName();

    public static final int PAGE_POSITION = 2;
    private WalkerLayout walkerLayout;

    public static AddressFragment newInstance() {
        Bundle args = new Bundle();
        AddressFragment fragment = new AddressFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.address_form, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        walkerLayout = (WalkerLayout) view.findViewById(R.id.walker);
        walkerLayout.setAnimationType(WalkerLayout.AnimationType.Custom);
        walkerLayout.setCustomAnimationListener(new WalkerLayout.CustomAnimationListener() {
            @Override
            public void animate(int index, float offset, WalkerLayout.Direction direction) {
                View child = walkerLayout.getChildAt(index);
                String tag = String.valueOf(child.getTag());
                switch (tag) {
                    case "1":
                        child.setRotation((180.0f) * (1.0f - offset));
                        break;
                    case "2":
                        child.setTranslationX(0.0f);
                        child.setTranslationY((1.0f - offset) * 200);
                        break;
                }
            }
        });
        walkerLayout.setup();
    }

    @Override
    protected int getPagePosition() {
        return PAGE_POSITION;
    }

    @Override
    protected WalkerLayout getWalkerLayout() {
        return walkerLayout;
    }
}