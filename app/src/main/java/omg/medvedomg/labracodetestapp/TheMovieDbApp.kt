package omg.medvedomg.labracodetestapp

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import omg.medvedomg.labracodetestapp.di.AppComponent
import omg.medvedomg.labracodetestapp.di.AppModule
import omg.medvedomg.labracodetestapp.di.DaggerAppComponent
import omg.medvedomg.labracodetestapp.di.NetworkModule
import omg.medvedomg.labracodetestapp.other.network.Api
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by medvedomg on 16.07.17.
 */
class TheMovieDbApp : Application(), HasActivityInjector{

    companion object {
        lateinit var graph: AppComponent
    }

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

}