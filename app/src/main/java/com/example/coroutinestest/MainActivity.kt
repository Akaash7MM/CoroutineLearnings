package com.example.coroutinestest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.example.coroutinestest.ui.theme.CoroutinesTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       val testString: MutableState<String> = mutableStateOf("Dummy Text")

        setContent {
            CoroutinesTestTheme {
              TextTest(testString.value.toString())
        }
    }
        withContextTest { text ->
          testString.value = text as String
        }

        lifecycleScope.launchWhenStarted {
            // Lives as long as the activity does, using global scope will keep
            // the coroutine running even if we move to another acivity
            // same for viewmodelscope lives as long as viewmodel does.
        }

    }
}
@Composable
fun TextTest(str : String){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = str,
            modifier = Modifier,
            style = TextStyle(
                color = Color.Black,
                fontSize = 32.sp
            )
        )
    }
}


