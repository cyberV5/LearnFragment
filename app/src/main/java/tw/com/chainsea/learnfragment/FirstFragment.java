package tw.com.chainsea.learnfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * FirstFragment
 * Created by Fleming on 2016/8/22.
 */
public class FirstFragment extends Fragment {

    OnReceivedListener mCallback;
    private TextView tvResult;
    private Button clickBtn;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnReceivedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container, false);
        clickBtn = (Button) view.findViewById(R.id.bt_receive);
        tvResult = (TextView) view.findViewById(R.id.tv_result);

        Bundle bundle = getArguments();
        String s = bundle.getString("hello");
        Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();

        clickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallback.onReceived(tvResult.getText().toString());
            }
        });

        return view;
    }

    public interface OnReceivedListener {
        void onReceived(String result);
    }
}
