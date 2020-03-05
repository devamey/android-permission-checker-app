package in.arjsna.permissionchecker;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.MenuItem;
import com.github.fernandodev.easyratingdialog.library.EasyRatingDialog;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import in.arjsna.permissionchecker.basemvp.BaseActivity;
import in.arjsna.permissionchecker.permissiongrouplist.PermissionListFragment;
import javax.inject.Inject;

public class MainActivity extends BaseActivity implements HasAndroidInjector {

  private EasyRatingDialog ratingDialog;

  @Inject DispatchingAndroidInjector<Object> androidInjector;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    if (savedInstanceState == null) {
      getSupportFragmentManager().beginTransaction()
          .add(R.id.permission_container, new PermissionListFragment())
          .commit();
    }
    ratingDialog = new EasyRatingDialog(this);
  }

  @Override protected void onStart() {
    super.onStart();
    ratingDialog.onStart();
  }

  @Override
  protected void onResume() {
    super.onResume();
    ratingDialog.showIfNeeded();
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        onBackPressed();
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return androidInjector;
    }

//  @Override public AndroidInjector<Fragment> supportFragmentInjector() {
//    return androidInjector;
//  }

}
