package com.example.data.repository

import android.content.Context
import android.util.Log
import com.example.data.api.HeroApi
import com.example.data.api.IconApi
import com.example.data.mapper.mapToUsersList
import com.example.domain.model.dto.Hero
import com.example.domain.repository.HeroRepository
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.*
import javax.inject.Inject


class HeroRepositoryImpl @Inject constructor(
    private  val heroApi: HeroApi,
    private val iconApi: IconApi

): HeroRepository {
    override fun getUsers(): Single<List<Hero>> {
        return heroApi.getUsers().map { it.mapToUsersList() }
    }

    override fun downloadImage(path: String, diskPath: String): Boolean {
        val call = iconApi.downloadImage(path)
        var check = true
        call.enqueue(object : Callback<ResponseBody?> {
            override fun onResponse(
                call: Call<ResponseBody?>?,
                response: Response<ResponseBody?>
            ) {
                if(response.isSuccessful){
                    val writtenToDisk = writeResponseBodyToDisk(response.body(), diskPath)
                    check = true
                }else{
                    Log.d("HTTP_LOG", "server contact failed")
                    check = false
                }

            }

            override fun onFailure(call: Call<ResponseBody?>?, t: Throwable?) {
                Log.d("HTTP_LOG", "failed")
                check = false
            }
        })
        return check
    }

    private fun writeResponseBodyToDisk(body: ResponseBody?, path: String): Boolean {
        return try {
            val futureStudioIconFile = File(path)
            lateinit var inputStream: InputStream
            lateinit var outputStream: OutputStream
            try {
                val fileReader = ByteArray(4096)
                var fileSizeDownloaded: Long = 0
                inputStream = body!!.byteStream()
                outputStream = FileOutputStream(futureStudioIconFile)
                while (true) {
                    val read: Int = inputStream.read(fileReader)
                    if (read == -1) {
                        break
                    }
                    outputStream.write(fileReader, 0, read)
                    fileSizeDownloaded += read.toLong()
                }
                outputStream.flush()
                true
            } catch (e: IOException) {
                e.printStackTrace()
                false
            } finally {
                inputStream.close()
                outputStream.close()
            }
        } catch (e: IOException) {
            false
        }
    }



}