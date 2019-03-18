package edu.cnm.deepdive.green_print.controller;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import edu.cnm.deepdive.green_print.R;

/**
 * A simple {@link Fragment} subclass. Activities that contain this fragment must implement the
 * {@link UpdateFragment.OnFragmentInteractionListener} interface to handle interaction events. Use
 * the {@link UpdateFragment#newInstance} factory method to create an instance of this fragment.
 */
public class UpdateFragment extends Fragment {

  // TODO: Rename parameter arguments, choose names that match
  // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
  private static final String ARG_PARAM1 = "param1";
  private static final String ARG_PARAM2 = "param2";

  // TODO: Rename and change types of parameters
  private String mParam1;
  private String mParam2;

  private OnFragmentInteractionListener mListener;

  public UpdateFragment() {
    // Required empty public constructor
  }

  /**
   * Use this factory method to create a new instance of this fragment using the provided
   * parameters.
   *
   * @param param1 Parameter 1.
   * @param param2 Parameter 2.
   * @return A new instance of fragment UpdateFragment.
   */
  // TODO: Rename and change types and number of parameters
  public static UpdateFragment newInstance(String param1, String param2) {
    UpdateFragment fragment = new UpdateFragment();
    Bundle args = new Bundle();
    args.putString(ARG_PARAM1, param1);
    args.putString(ARG_PARAM2, param2);
    fragment.setArguments(args);
    return fragment;
  }

  private Button updateButton;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      mParam1 = getArguments().getString(ARG_PARAM1);
      mParam2 = getArguments().getString(ARG_PARAM2);
    }


  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_update, container, false);
    updateButton = (Button) view.findViewById(R.id.update_button);

    updateButton.setOnClickListener(new View.OnClickListener(){

      @Override
      public void onClick(View view) {
//        View parentView;
//        EditText userInputText;
//        int numInputs = 20;
//        int[] inputValues = new int[numInputs];
//        String idStr;
//        String userInputStr;
//        int resID;

        Toast.makeText(getActivity(), "Update Clicked", Toast.LENGTH_SHORT).show();

/*
        for(int i = 1; i <= numInputs; i++){
          idStr = "answer_" + String.valueOf(i) + "_id";
          resID = getResources().getIdentifier(idStr, "id", getContext().getPackageName());

          parentView = (View)view.getParent();

          userInputText = parentView.findViewById(resID);
          userInputStr = userInputText.getText().toString();
          inputValues[i - 1] = Integer.parseInt(userInputStr);

        }
*/
        // this is so we can check connectivity to internet, must activate code above
//        int[] inputValues2 = new int[]{87113, 3, 2, 1, 1, 1700, 80, 40, 0, 11, 100, 200, 10000, 12, 5000, 17, 2000, 19, 0, 0};
//
//        CC_API ccApi = new CC_API();
//        float total_carbon_footprint = ccApi.calculateFootprint(inputValues2);
//
//        // Display total carbon footprint if available
//        if (total_carbon_footprint == -1) {
//          Toast.makeText(getActivity(), "*** Error: Can't Calculate Carbon Footprint. ***", Toast.LENGTH_SHORT).show();
//        } else {
//          String toastStr = "Footprint: " + String.valueOf(total_carbon_footprint) + "tons/year";
//          Toast.makeText(getActivity(), toastStr, Toast.LENGTH_SHORT).show();
//        }

      }
    });

    return view;

  }

  // TODO: Rename method, update argument and hook method into UI event
  public void onButtonPressed(Uri uri) {
    if (mListener != null) {
      mListener.onFragmentInteraction(uri);
    }
  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof OnFragmentInteractionListener) {
      mListener = (OnFragmentInteractionListener) context;
    } else {
      throw new RuntimeException(context.toString()
          + " must implement OnFragmentInteractionListener");
    }
  }

  @Override
  public void onDetach() {
    super.onDetach();
    mListener = null;
  }

  /**
   * This interface must be implemented by activities that contain this fragment to allow an
   * interaction in this fragment to be communicated to the activity and potentially other fragments
   * contained in that activity.
   * <p>
   * See the Android Training lesson <a href= "http://developer.android.com/training/basics/fragments/communicating.html"
   * >Communicating with Other Fragments</a> for more information.
   */
  public interface OnFragmentInteractionListener {

    // TODO: Update argument type and name
    void onFragmentInteraction(Uri uri);
  }
}


//    myCheck = (CheckBox) view.findViewById(R.id.myCheckBox1);
//   myCheck.isChecked(); <-- this the handle are you checked


// use for loop from SurveyFragment example with boolean []
// pass boolean [] to CC_API for recall.
