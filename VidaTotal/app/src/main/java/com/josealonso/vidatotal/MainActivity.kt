package com.josealonso.vidatotal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.josealonso.vidatotal.ui.VidaTotalApp
import com.josealonso.vidatotal.ui.theme.VidaTotalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VidaTotalTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    VidaTotalApp()
                }
            }
        }
    }
}
