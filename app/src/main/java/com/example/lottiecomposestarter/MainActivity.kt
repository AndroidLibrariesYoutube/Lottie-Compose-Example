package com.example.lottiecomposestarter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.example.lottiecomposestarter.ui.theme.LottieComposeStarterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LottieComposeStarterTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Loader()
                }
            }
        }
    }

    @Composable
    fun Loader() {
        val compositionResult: LottieCompositionResult = rememberLottieComposition(
            spec = LottieCompositionSpec.RawRes(R.raw.anim_truck)
        )

        val progress by animateLottieCompositionAsState(
            composition = compositionResult.value,
            isPlaying = true,
            iterations = LottieConstants.IterateForever,
            speed = 0.5f
        )

        LottieAnimation(
            composition = compositionResult.value,
            progress = progress,
            modifier = Modifier.padding(all = 20.dp)
        )

    }

}

