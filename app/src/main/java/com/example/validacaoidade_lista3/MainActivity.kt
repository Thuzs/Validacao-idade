package com.example.validacaoidade_lista3

import android.R.attr.name
import android.R.attr.onClick
import android.R.attr.x
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.validacaoidade_lista3.ui.theme.ValidacaoIdadeLista3Theme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ValidacaoIdadeLista3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BasicComponentsScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BasicComponentsScreen(modifier: Modifier = Modifier) {
    var idade  by remember{
        mutableStateOf(7)
    }
    Column(
        modifier = modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Spacer(modifier = Modifier.height(150.dp))
        Text(
            text = "Qual é a sua idade?",
            fontSize = 26.sp,
            color = Color(0xFF1B59B9)
        )
        Text(
            text = "Aperte os botões para informar a sua idade",
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "$idade",
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(
                onClick = {
                    if (idade > 0) {
                        idade --
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1B59B9)

                ),
                shape = RoundedCornerShape(12.dp)
                ) {
                Text(
                    text = "-",
                    fontSize = 36.sp
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = {
                    if (idade < 180) {
                        idade ++
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1B59B9)

                ),
                shape = RoundedCornerShape(12.dp)

            ) {
                Text(
                    text = "+",
                    fontSize = 33.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        if (idade >= 18) {
            Text(
                text = "Você é MAIOR de idade",
                fontSize = 26.sp,
                color = Color(0xFF1B59B9)
            )
    }else{
        Text(
            text = "Você é MENOR de idade",
            fontSize = 26.sp,
            color = Color(0xFF1B59B9)
        )
    }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ValidacaoIdadeLista3Theme {
        BasicComponentsScreen()
    }
}