package com.israelaguilar.musicplayerdiplo.ui.providers

import android.content.Context
import com.israelaguilar.musicplayerdiplo.R

class ReadAudioPermissionExplanationProvider(
    //private val context: Context
): PermissionExplanationProvider {



    override fun getPermissionText(): String = "Permiso para leer los archivos de audio"

    // Para no hacer hardcoding
    //override fun getPermissionText(): String = context.getString(R.string.music_player_diplo)

    override fun getExplanation(isPermanentlyDeclined: Boolean): String {
        return if(isPermanentlyDeclined)
            "El permiso se ha negado permanentemente. Para usar esta aplicación, habilita el permiso en la configuración"
        else
            "Se requiere el permiso solamente para acceder a los archivos de audio del dispositivo"
    }
}