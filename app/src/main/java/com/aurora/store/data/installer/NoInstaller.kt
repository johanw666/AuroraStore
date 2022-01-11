package com.aurora.store.data.installer

import android.content.Context
import com.aurora.store.R
import com.aurora.store.data.event.InstallerEvent
import com.aurora.store.util.Log
import org.greenrobot.eventbus.EventBus

class NoInstaller(context: Context) : InstallerBase(context) {

    override fun install(packageName: String, files: List<Any>) {
        Log.i("$packageName no automatic install")
        postReady(packageName, context.getString(R.string.installer_status_ready))
        removeFromInstallQueue(packageName)
    }

    open fun postReady(packageName: String, extra: String?) {
        val event = InstallerEvent.Success(packageName, extra)
        EventBus.getDefault().post(event)
    }

}
