package com.example.sorteio_login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sorteio_login.ui.theme.Sorteio_LoginTheme
import kotlin.random.Random

@Composable
fun TelaSorteio(navController: NavController) {
    MelhorBuracoNegro()

    // Exemplo: botão para voltar
    Button(
        onClick = { navController.popBackStack() },
        modifier = Modifier
            .padding(top = 16.dp)
    ) {
        Text("Voltar")
    }
}

@Composable
fun MelhorBuracoNegro(modifier: Modifier = Modifier) {
    val buracos = listOf("Supermassivo", "Via Láctea", "Intermediário", "Estelar")

    val imagens = mapOf(
        "Supermassivo" to R.drawable.supermassivo,
        "Via Láctea" to R.drawable.vialactea,
        "Intermediário" to R.drawable.intermediario,
        "Estelar" to R.drawable.estelar
    )

    var sorteado by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Qual o seu melhor PET?",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium,
            modifier = modifier.padding(top = 16.dp, bottom = 16.dp)
        )

        Text(
            text = "Seu PET sumiu! E agora? Você precisará de um novo PET. " +
                    "Mas você transcedeu a realidade: agora pode ter um PET buraco negro! " +
                    "Clique no botão para descobrir qual será o seu.",
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .padding(bottom = 24.dp)
        )

        Button(
            onClick = {
                val id = Random.nextInt(buracos.size)
                sorteado = buracos[id]
            }
        ) {
            Text("Buraco Negro 😁")
        }

        sorteado?.let { buracoAtual ->
            val imagemRes = imagens[buracoAtual]
            Spacer(modifier = Modifier.height(20.dp))

            imagemRes?.let {
                Image(
                    painter = painterResource(id = it),
                    contentDescription = "Foto de $buracoAtual",
                    modifier = Modifier
                        .size(220.dp)
                        .padding(bottom = 12.dp)
                )
            }

            Text(
                text = if (buracoAtual == "Via Láctea")
                    "Isso é um buraco negro? $buracoAtual"
                else
                    "O seu novo PET: $buracoAtual",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TelaSorteioPreview() {
    Sorteio_LoginTheme {
        MelhorBuracoNegro()
    }
}
