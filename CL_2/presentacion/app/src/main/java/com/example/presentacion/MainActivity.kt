package com.example.presentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.presentacion.ui.theme.PresentacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PresentacionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Presentacion(modifier = Modifier
                        .padding(innerPadding)
                        .background(Color(0xffd2e7d4)));
                }
            }
        }
    }
}

@Composable
fun Presentacion(modifier: Modifier) {
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(R.drawable.android_logo),
                contentDescription = "Logotipo de Android",
                modifier = Modifier.background(Color(0xFF073042))
            )
            Text(
                text = "Agustín González",
                fontSize = 50.sp,
                color = Color(0xFF142519),
                modifier = Modifier
                    .padding(7.dp)
            )
            Text(
                text = "Intento de desarrollador de Android",
                color = Color(0xff046b3a),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
        Column {
            Row {
                Icon(
                    imageVector = Icons.Rounded.Call,
                    contentDescription = "Icono de teléfono",
                    tint = Color(0xff016c3a),
                )
                Text(
                    text = "600 000 000",
                    modifier = Modifier.padding(10.dp, 0.dp),
                    color = Color(0xff0a180b)
                )
            }
            Row {
                Icon(
                    imageVector = Icons.Rounded.Share,
                    contentDescription = "Icono de compartir",
                    tint = Color(0xff016c3a)
                )
                Text(
                    text = "@yo",
                    modifier = Modifier.padding(10.dp, 0.dp),
                    color = Color(0xff0a180b)
                )
            }
            Row {
                Icon(
                    imageVector = Icons.Rounded.Email,
                    contentDescription = "Icono de email",
                    tint = Color(0xff016c3a)
                )
                Text(
                    text = "yo@yo.com",
                    modifier = Modifier.padding(10.dp, 0.dp),
                    color = Color(0xff0a180b)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PresentacionPreview() {
    PresentacionTheme {
        Presentacion(Modifier.background(Color(0xffd2e7d4)))
    }
}