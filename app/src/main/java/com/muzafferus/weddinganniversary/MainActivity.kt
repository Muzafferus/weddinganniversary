package com.muzafferus.weddinganniversary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import com.muzafferus.weddinganniversary.navigation.SetupNavGraph
import com.muzafferus.weddinganniversary.ui.theme.WeddingAnniversaryTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeddingAnniversaryTheme {
                SetupNavGraph(navController = navController)
            }
        }
    }
}