package a2018.by.step.myquiz

import android.app.Application
import android.os.Debug
import timber.log.Timber

class QuizApp:Application(){
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

    }
}