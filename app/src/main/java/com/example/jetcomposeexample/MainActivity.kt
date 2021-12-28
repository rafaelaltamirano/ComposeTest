package com.example.jetcomposeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetcomposeexample.ui.theme.JetComposeExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewStory()
        }
    }
}

@Composable
private fun NewStory() {

    val imageModifier = Modifier
        .requiredHeight(150.dp)
        .fillMaxWidth()

    Column(modifier = Modifier.padding(16.dp)){
        Image(
            painter = painterResource(R.mipmap.header),
            contentDescription =  "Contact profile picture",
            modifier = imageModifier,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.padding(top = 10.dp))
        Text(text = "Titulo de la noticia ")
        Text(text = "Descripcion de la noticia ")
        Text(text = "Pie de pagina de la noticia")
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NewStory()
}