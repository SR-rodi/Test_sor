package com.example.core.tools

import android.Manifest
import android.content.pm.PackageManager
import android.widget.ImageView
import androidx.activity.result.ActivityResultLauncher
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide


const val BASE_URL = "https://run.mocky.io/"
const val GET_MAINE = "/v3/654bd15e-b121-49ba-a588-960956b15175"
const val GET_BASKET = "v3/53539a72-3c5f-4f30-bbb1-6ca10d42c149"
const val GET_DETAILS = "v3/6c14c560-15c6-4248-b9d2-b4508df7d4f5"
const val DOLLAR = "$"
const val TRANSITION_NAME = "transition_fragment"

val REQUIRED_PERMISSIONS = arrayOf(
    Manifest.permission.ACCESS_COARSE_LOCATION,
    Manifest.permission.ACCESS_FINE_LOCATION
)

