package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MakeLemonade(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MakeLemonade(modifier: Modifier = Modifier) {
    var contador by remember { mutableIntStateOf(0) }
    var estrujamientos by remember { mutableIntStateOf((2..4).random()) }
    var contadorEstrujamientos by remember { mutableIntStateOf(0) }
    val imageResource = when(contador) {
        0 -> R.drawable.lemon_tree
        1 -> R.drawable.lemon_squeeze
        2 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val textResource = when(contador) {
        0 -> R.string.texto_1
        1 -> R.string.texto_2
        2 -> R.string.texto_3
        else -> R.string.texto_4
    }
    val altTextResource = when(contador) {
        0 -> R.string.texto_alt_1
        1 -> R.string.texto_alt_2
        2 -> R.string.texto_alt_3
        else -> R.string.texto_alt_4
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    if (contador == 3) {
                        contador = 0
                    }
                    else if (contador == 1) {
                        contadorEstrujamientos += 1
                        if (contadorEstrujamientos >= estrujamientos) {
                            estrujamientos = (2..4).random()
                            contadorEstrujamientos = 0
                            contador += 1
                        }
                    }
                    else {
                        contador += 1
                    }
                },
                shape = RoundedCornerShape(30.dp)
            ) {
                Image(
                    painter = painterResource(imageResource),
                    contentDescription = stringResource(altTextResource)
                )
            }
            Text(
                text = stringResource(textResource),
                modifier = Modifier.padding(0.dp, 16.dp),
                fontSize = 18.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadePreview() {
    LemonadeTheme {
        MakeLemonade(modifier = Modifier)
    }
}