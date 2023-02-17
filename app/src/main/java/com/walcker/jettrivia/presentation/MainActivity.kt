package com.walcker.jettrivia.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.walcker.jettrivia.presentation.screens.TriviaHome
import com.walcker.jettrivia.presentation.theme.JetTriviaTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MyApp { TriviaHome()} }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    JetTriviaTheme { content() }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp { TriviaHome()}
}