package com.walcker.jettrivia.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.walcker.jettrivia.presentation.theme.JetTriviaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MyApp { } }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    JetTriviaTheme { content() }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp { }
}