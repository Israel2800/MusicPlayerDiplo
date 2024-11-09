package com.israelaguilar.musicplayerdiplo.data

import android.content.Context
import android.provider.MediaStore
import android.util.Log
import com.israelaguilar.musicplayerdiplo.data.local.model.MusicFile

class AudioRepository(
    private val context: Context
) {

    fun getAllAudio(): MutableList<MusicFile>{
        // Aquí leemos todos los archivos de audio del dispositivo en almacenamiento externo

        val tempAudioList = mutableListOf<MusicFile>()

        // Generamos los elementos que me pide el query

        val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI

        val selection = "${MediaStore.Audio.Media.IS_MUSIC} == 1" // Filtro o condición para que el query solamente me de archivos de música

        val projection = arrayOf(
            MediaStore.Audio.Media.ALBUM,
            MediaStore.Audio.Media.TITLE,
            MediaStore.Audio.Media.DURATION,
            MediaStore.Audio.Media.DATA,
            MediaStore.Audio.Media.ARTIST,
        )

        val cursor = context.contentResolver.query(
            uri,
            projection,
            selection,
            null,
            null
        )

        if(cursor != null){
            while(cursor.moveToNext()){
                // Obteniendo las columnas que me interesan de cada archivo de música
                val album = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM))
                val title = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE))
                val duration = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION))
                val data = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA))
                val artist = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST))

                val musicFile = MusicFile(data, title, artist, album, duration ?: "0")

                Log.d("MUSICA", "Ruta: $data - Album: $album")

                tempAudioList.add(musicFile)
            }
            cursor.close()
        }

        return tempAudioList
    }

}