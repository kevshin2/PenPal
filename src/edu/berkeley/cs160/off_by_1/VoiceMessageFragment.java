	package edu.berkeley.cs160.off_by_1;

	import android.app.Fragment;
	import android.os.Bundle;
import android.util.Log;
	import android.view.LayoutInflater;
	import android.view.View;
import android.view.ViewGroup;

public class VoiceMessageFragment extends Fragment {
		    @Override
		    public View onCreateView(LayoutInflater inflater, ViewGroup container,
		                             Bundle savedInstanceState) {
		        // Inflate the layout for this fragment
		    	Log.d("debug", "inflating voice message");
		        return inflater.inflate(R.layout.voice_message, container, false);
		    }
		}
