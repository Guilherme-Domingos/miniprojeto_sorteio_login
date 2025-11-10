package com.example.sorteio_login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sorteio_login.ui.theme.Sorteio_LoginTheme

@Composable
fun LoginScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "Logo do Aplicativo",
            modifier = Modifier
                .size(150.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Bem-vindo",
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Usuário") },
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = "Usuário") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Senha") },
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = { Icon(Icons.Default.Password, contentDescription = "Senha") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        ElevatedButton(
            onClick = {
                // simula o login bem-sucedido
                if (username.isNotEmpty() && password.isNotEmpty()) {
                    navController.navigate("sorteio")
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = Color.DarkGray,
                contentColor = Color.White
            )
        ) {
            Text("Entrar")
        }

        OutlinedButton(
            onClick = { /* futura tela de cadastro */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Criar nova conta")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    Sorteio_LoginTheme {
        LoginScreen(navController = rememberNavController())
    }
}