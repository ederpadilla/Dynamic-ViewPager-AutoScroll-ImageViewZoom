package development.uble.android.com.i.dynamic_viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by ederpadilla on 14/01/17.
 */

public class MyFragment extends Fragment {

    PhotoViewAttacher mAttacher;

    ImageView tvTitle;

    public static Fragment newInstance(String title) {
        MyFragment myFragment = new MyFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        myFragment.setArguments(args);
        return myFragment;
    }

    public MyFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my, container, false);

        tvTitle = (ImageView) view.findViewById(R.id.tv_title);
        Glide.with(getActivity())
                .load(getArguments().getString("title"))
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(tvTitle);
        mAttacher = new PhotoViewAttacher(tvTitle);
        //tvTitle.setText(getArguments().getString("title"));


        return view;
    }
}
