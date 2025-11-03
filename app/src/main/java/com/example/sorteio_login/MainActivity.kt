package com.example.sorteio_login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sorteio_login.ui.theme.Sorteio_LoginTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Sorteio_LoginTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MelhorBuracoNegro(modifier = Modifier.padding(innerPadding))
                }
            }
        }
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

    var sorteado = remember { mutableStateOf<String?>(null) }

    Column (
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Qual o seu melhor PET?",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium,
            modifier = modifier.padding(top=16.dp, bottom = 16.dp)
        )
        Text(
            text = "Seu PET sumiu! E agora?"+
                    " Você precisará de um novo PET. No entanto, você transcedeu a realidade. Agora você pode ter um PET buraco negro!"+
                    " Clique no botão para descobrir seu novo PET buraco negro.",
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .padding(bottom = 24.dp)
        )
        Button(
            onClick = {
                val id = Random.nextInt(buracos.size)
                sorteado.value=buracos[id]
            }
        ) {
            Text(
                text = "Buraco Negro😁"
            )
        }
        if(sorteado.value!=null){
            var buracoAtual = sorteado.value!!
            val imagemRes = imagens[buracoAtual]

            if(imagemRes!=null){
                Image(
                    painter = painterResource(id=imagemRes),
                    contentDescription = "Foto de $buracoAtual",
                    modifier = Modifier.size(220.dp).padding(top = 20.dp, bottom = 12.dp)
                )
            }
            if (buracoAtual==="Via Láctea"){
                Text (
                    text = "Isso é um buraco negro?: $buracoAtual",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }else {
                Text(
                    text = "O seu novo PET: $buracoAtual",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Sorteio_LoginTheme {
        MelhorBuracoNegro()
    }
}