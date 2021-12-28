package com.example.jetcomposeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetcomposeexample.ui.theme.JetComposeExampleTheme
data class Contact(
    @DrawableRes val imageResource: Int,
    val name: String,
    val directions: List<String>
)

//List of contacts
val contactList = listOf(
    Contact(R.mipmap.header,"Julian", listOf("116921666","Siempre Viva 1","Julian@gmail.com")),
    Contact(R.mipmap.header,"Manuel", listOf("987739388","Del triunfo 233","mgood@hotmail.com")),
    Contact(R.mipmap.header,"Silvia", listOf("937783923","Belgrano 887","Silvia98@gmail.com")),
    Contact(R.mipmap.header,"Dario", listOf("987833","San Martin 876","Daro@gmail.com")),
    )

//How we will see each contact
//Composable fun always with upper letter
@Composable
private fun ContactCard(contact: Contact){
    val image = painterResource(id = R.mipmap.header)
    Card(shape= RoundedCornerShape(8.dp),elevation=8.dp,modifier = Modifier.padding(8.dp)){
        Column(modifier= Modifier.padding(16.dp)) {
            val imageModifier = Modifier
                .requiredHeight(150.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp))
            Image(painter = image, modifier = imageModifier, contentScale =  ContentScale.Crop,contentDescription = "Contact Photo")
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Text(text = contact.name,style = MaterialTheme.typography.h6)
            for(direction in contact.directions){
                Text(text = "* $direction", style = MaterialTheme.typography.body2)
            }
        }
    }
}


@Composable
private fun ContactColumnList(contactList: List<Contact>){
    //LazyColum funciona como un recycler view, inicializa a medida que va necesitando los elementos
LazyColumn{
    items(contactList){ contact->
        ContactCard(contact=contact)
    }
}
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //NewStory()
            ContactColumnList(contactList = contactList)
        }
    }
}

@Composable
private fun NewStory() {

    val imageModifier = Modifier
        .requiredHeight(150.dp)
        .fillMaxWidth()
        .clip(shape = RoundedCornerShape(10.dp))

    Column(modifier = Modifier.padding(16.dp)){
        Image(
            painter = painterResource(R.mipmap.header),
            contentDescription =  "Contact profile picture",
            modifier = imageModifier,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.padding(top = 10.dp))
        Text(text = "Lista de contactos ", style = MaterialTheme.typography.h6)
        Text(text = "Debajo Se listara la lista de contacto con la foto de cada persona",style = MaterialTheme.typography.body2)
   }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NewStory()
}


@Preview(showBackground = true)
@Composable
fun CardPreview() {
    ContactCard(contactList[0])
}