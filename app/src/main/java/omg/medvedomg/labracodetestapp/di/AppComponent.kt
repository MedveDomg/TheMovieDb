package omg.medvedomg.labracodetestapp.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import omg.medvedomg.labracodetestapp.TheMovieDbApp
import omg.medvedomg.labracodetestapp.other.network.Api
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by medvedomg on 16.07.17.
 */
@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class,ActivityBuilder::class,AppModule::class,NetworkModule::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application) : Builder
//        @BindsInstance fun api() : Builder
        fun build() : AppComponent
    }



    fun inject(app: TheMovieDbApp)
}