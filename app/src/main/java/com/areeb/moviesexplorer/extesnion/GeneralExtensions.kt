package com.areeb.moviesexplorer.extesnion

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.areeb.moviesexplorer.core.HashMapParams
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.json.JSONObject
import timber.log.Timber


inline fun <reified T : AppCompatActivity> Fragment.castToActivity(
    callback: (T?) -> Unit,
): T? {
    return if (requireActivity() is T) {
        callback(requireActivity() as T)
        requireActivity() as T
    } else {
        callback(null)
        null
    }
}

fun CoroutineScope.delayWithAction(
    delayMillis: Long,
    action: () -> Unit
) {
    launch {
        delay(delayMillis)
        action()
    }
}


fun Any?.showLogMessage(tag: String? = null) = Timber.tag("Areeb_Tags $tag").e(this.toString())

fun HashMapParams?.toHashMapParams2(): HashMap<String?, String?>? {
    if (this == null) return null
    val params by lazy<HashMap<String?, String?>?> { HashMap() }
    try {
        JSONObject(Gson().toJson(dataClass())).let {
            if (it.names() != null)
                for (i in 0 until it.names()!!.length()) {
                    params?.set(
                        it.names()!!.getString(i),
                        it[it.names()!!.getString(i)].toString() + ""
                    )
                }
        }
    } catch (e: Exception) {
        e.message.showLogMessage("Hashmap")
        print(e)
    }
    return if (params!!.isEmpty()) null else params
}


fun HashMapParams?.toHashMapParams(): HashMap<String, String?>? {
    if (this == null) return null
    val params by lazy<HashMap<String, String?>> { HashMap() }
    try {
        JSONObject(Gson().toJson(dataClass())).let {
            if (it.names() != null)
                for (i in 0 until it.names()!!.length()) {
                    params[it.names()!!.getString(i)] =
                        it[it.names()!!.getString(i)].toString() + ""
                }
        }
    } catch (e: Exception) {
        e.message.showLogMessage("Hashmap")
        print(e)
    }
    return if (params.isEmpty()) null else params
}
