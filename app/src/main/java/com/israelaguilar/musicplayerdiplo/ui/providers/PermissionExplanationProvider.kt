package com.israelaguilar.musicplayerdiplo.ui.providers

interface PermissionExplanationProvider {

    fun getPermissionText(): String
    fun getExplanation(isPermanentlyDeclined: Boolean): String

}