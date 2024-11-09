package com.israelaguilar.musicplayerdiplo.ui.providers

class WritePermissionExplanationProvider: PermissionExplanationProvider {
    override fun getPermissionText(): String = "Permiso de escritura del almacenamiento externo"

    override fun getExplanation(isPermanentlyDeclined: Boolean): String {
        return if(isPermanentlyDeclined)
            "El permiso se ha negado permanentemente. Para usar esta aplicación, habilita el permiso en la configuración"
        else
            "Se requiere el permiso de escritura solamente para acceder a los archivos de audio del dispositivo. No se modificará ningún archivo"
    }
}