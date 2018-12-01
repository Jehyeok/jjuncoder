package com.example.hyeonjehyeog.myapplication.network.basic

import android.os.AsyncTask
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class GetGithubLists(private val action: Action): AsyncTask<String, Void, String>() {
    override fun doInBackground(vararg params: String?): String {
        var result = ""

        try {
            val url = URL(params[0])
            val urlConnection = url.openConnection() as HttpURLConnection

            urlConnection.requestMethod = "GET"
            urlConnection.readTimeout = 15000
            urlConnection.connectTimeout = 15000
            urlConnection.connect()

            val streamReader = InputStreamReader(urlConnection.inputStream)
            result = streamReader.readLines().joinToString("")
            streamReader.close()
            //Set our result equal to our stringBuilder

            urlConnection.disconnect()
        } catch (t: Throwable) {
            t.printStackTrace()
        }

        return result
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)

        result?.let { action.run(it) }
    }
}