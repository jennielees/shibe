package com.jennielees.shibe;

import android.graphics.Typeface;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class WowActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wow);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new TextSelectFragment())
                    .commit();
        }

}


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class TextSelectFragment extends Fragment {

        private EditText txt1;
        private EditText txt2;
        private EditText txt3;
        private EditText txt4;
        private EditText txt5;

        private EditText[] texts = {txt1, txt2, txt3, txt4, txt5};
        private String[] prefixes = {"so", "very", "much", "such", "nice", "omg"};
        private String[] suffices = {"shibe", "doge", "bark", "fur", "woof", "wag", "meme"};


        public TextSelectFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_wow, container, false);

            RelativeLayout rootLayout = (RelativeLayout) getView().findViewById(R.id.wow_layout);
            Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "2086.ttf");

            for (int i=0; i<texts.length; i++) {
                texts[i] = (EditText) rootLayout.getChildAt(i);
                texts[i].setTypeface(font);
            }

            generateShibeWords();

            return rootView;
        }


        protected String pickRandomPrefix() {
            double r = Math.random() * prefixes.length;
            long i = Math.round(r);
            return prefixes[(int)i];
        }

        protected String pickRandomSuffix() {
            double r = Math.random() * suffices.length;
            long i = Math.round(r);
            return suffices[(int)i];
        }

        protected void generateShibeWords() {
            for (int i=0; i<texts.length-1; i++) {
                texts[i].setText(pickRandomPrefix() + " " + pickRandomSuffix());
            }
            txt5.setText("wow");
        }


    }

}
