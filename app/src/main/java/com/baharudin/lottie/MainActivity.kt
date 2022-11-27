package com.baharudin.lottie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.*
import com.baharudin.lottie.ui.theme.LottieTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LottieTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    loaderAnimation()
                }
            }
        }
    }
}

@Composable
fun loaderAnimation() {
    val compotionResult : LottieCompositionResult = rememberLottieComposition(
        spec = LottieCompositionSpec.Asset(
           "lottie/chiky.json"
        )
    )
    val progressAnimation by animateLottieCompositionAsState(
        compotionResult.value,
        isPlaying = true,
        iterations = LottieConstants.IterateForever,
        speed = 1.0f
    )
    LottieAnimation(composition = compotionResult.value, progress = progressAnimation)
}