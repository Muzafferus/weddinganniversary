package com.muzafferus.weddinganniversary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.muzafferus.weddinganniversary.navigation.SetupNavGraph
import com.muzafferus.weddinganniversary.ui.theme.WeddingAnniversaryTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeddingAnniversaryTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}