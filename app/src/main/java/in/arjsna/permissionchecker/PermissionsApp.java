package in.arjsna.permissionchecker;

import android.app.Activity;
import android.app.Application;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import in.arjsna.permissionchecker.di.components.DaggerApplicationComponent;
import javax.inject.Inject;

public class PermissionsApp extends Application implements HasAndroidInjector {

  @Inject DispatchingAndroidInjector<Object> dispatchingAndroidInjector;

  @Override public void onCreate() {
    super.onCreate();
    DaggerApplicationComponent.builder().application(this).build().inject(this);
  }

//  @Override public AndroidInjector<Activity> activityInjector() {
//    return dispatchingAndroidInjector;
//  }

  @Override
  public AndroidInjector<Object> androidInjector() {
    return dispatchingAndroidInjector;
  }
}
