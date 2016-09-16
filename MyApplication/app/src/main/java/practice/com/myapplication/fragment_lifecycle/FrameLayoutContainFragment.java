package practice.com.myapplication.fragment_lifecycle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import practice.com.myapplication.MainActivity;
import practice.com.myapplication.R;


/**
 * Created by dinesh.sengar on 08-08-2016.
 */
public class FrameLayoutContainFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("Fragment","onAttach");
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Fragment","onCreate");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("Fragment","onStart");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("Fragment","onCreateView");

        View  view =inflater.inflate(R.layout.frame_fragment,container,false);

        Button  btnNext=(Button)view.findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent=new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        return view;

    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i("Fragment","onViewCreated");
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("Fragment","onActivityCreated");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("Fragment","onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("Fragment","onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("Fragment","onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("Fragment","onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("Fragment","onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("Fragment","onDeAttache");
    }
}
