package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {

    var title by remember { mutableStateOf(1) }
    var year by remember { mutableStateOf(1) }
    var currentArtwork by remember { mutableStateOf(1) }

    val images = when (currentArtwork){
        1 -> R.drawable.grupo
        2 -> R.drawable.rachel
        3 -> R.drawable.monica
        4 -> R.drawable.phoebe
        5 -> R.drawable.ross
        6 -> R.drawable.chandler
        7 -> R.drawable.joey
        8 -> R.drawable.respiro
        9 -> R.drawable.siete
        10 -> R.drawable.acciongracias
        else -> R.drawable.pierden_casa
    }

    val titles = when (title){
        1 -> R.string.friends
        2 -> R.string.rachel
        3 -> R.string.monica
        4 -> R.string.phoebe
        5 -> R.string.ross
        6 -> R.string.chandler
        7 -> R.string.joey
        8 -> R.string.respiro
        9 -> R.string.siete
        10 -> R.string.accionGracias
        else -> R.string.pierdenCasa
    }

    val years = when (year){
        1 -> R.string.Age
        2 -> R.string.rachel_year
        3 -> R.string.monica_year
        4 -> R.string.phoebe_year
        5 -> R.string.ross_year
        6 -> R.string.chandler_year
        7 -> R.string.joey_year
        8 -> R.string.respiro_descripcion
        9 -> R.string.siete_descripcion
        10 -> R.string.accionGracias_descripcion
        else -> R.string.pierdenCasa_descripcion
    }

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.purple_500))
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.Student),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Spacer(
            modifier = modifier.size(16.dp)
        )
        Text(
            text = stringResource(R.string.titlle),
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.blue_100),
            fontSize = 32.sp,
            textAlign = TextAlign.Center
        )
        Spacer(
            modifier = modifier.size(9.dp)
        )
        ArtworkImage(
            currentArtwork = images,
            modifier = Modifier.aspectRatio(0.9f)
        )
        Spacer(
            modifier = modifier.size(16.dp)
        )
        ArtworkTitle(
            title = titles,
            year = years,
        )
        Spacer(
            modifier = modifier.size(25.dp)
        )
        Row(
            modifier = modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            Button(
                onClick = {
                    if(currentArtwork == 1){
                        currentArtwork = 11
                        title = 11
                        year = 11
                    }
                    else if(currentArtwork > 1 || currentArtwork < 12){
                           currentArtwork -= 1
                           title -= 1
                           year -= 1
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.purple_500)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp,
                )
            ) {
                Text(
                    text = stringResource(id = R.string.anterior),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }
            Button(onClick = {
                currentArtwork = 1
                title = 1
                year = 1
            },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.purple_700)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                )
            ) {
                Text(
                    text = stringResource(id = R.string.reiniciar),
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.white),
                    fontSize = 16.sp,
                )
            }
            Button(
                onClick = {

                    currentArtwork += 1
                    title += 1
                    year += 1

                    if(currentArtwork == 11){
                        currentArtwork = 11
                        title = 11
                        year = 11
                    }
                    else if(currentArtwork > 12){
                        currentArtwork = 1
                        title = 1
                        year = 1
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.purple_500)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                ),
            ) {
                Text(
                    text = stringResource(id = R.string.siguiente),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )

            }

        }
    }
}

@Composable
fun ArtworkImage(
    modifier: Modifier = Modifier,
    @DrawableRes currentArtwork: Int
) {
    Image(
        painter = painterResource(id = currentArtwork),
        contentDescription = null,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp)),
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun ArtworkTitle(
    @StringRes title: Int,
    @StringRes year: Int,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = title),
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.blue_100),
            fontSize = 32.sp,
        )
        Text(
            text = stringResource(id = year),
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.gray_300),
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}

