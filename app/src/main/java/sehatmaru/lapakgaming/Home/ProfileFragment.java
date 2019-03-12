package sehatmaru.lapakgaming.Home;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;

import sehatmaru.lapakgaming.Helper.LoginActivity;
import sehatmaru.lapakgaming.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    Button btnLogout;
    Context context;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        context = getActivity().getApplicationContext();

        btnLogout = (Button) v.findViewById(R.id.buttonLogOut);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logoutDialog();
            }
        });

        return v;
    }

    private void signOut(){
        Intent intent = new Intent(getActivity().getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        Toast.makeText(getActivity().getApplicationContext(), "Logout Successfully", Toast.LENGTH_LONG).show();
    }

    private void logoutDialog() {
        MaterialDialog dialog = new MaterialDialog.Builder(getActivity())
                .title(R.string.title_logout)
                .content(R.string.content_logout)
                .positiveText(R.string.yes)
                .negativeText(R.string.no)
                .onPositive((dialog1, which) -> {
                    signOut();
                })
                .onNegative((dialog1, which) -> {

                })
                .build();
        dialog.show();
    }

}
