package tw.com.chainsea.learnfragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;

public class MainActivity extends FragmentActivity implements FirstFragment.OnReceivedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_add:
                FirstFragment fragment = new FirstFragment();
                Bundle bundle = new Bundle();
                bundle.putString("hello","hi,I am from activity");
                fragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().add(R.id.fragment, fragment).addToBackStack(null).commit();
                break;
            case R.id.bt_replace:
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fragment, new SecondFragment());
                transaction.addToBackStack(null);
                transaction.commit();
                break;
        }
    }

    @Override
    public void onReceived(String result) {
        Log.i("chen", "onReceived: "+result);
    }
}
