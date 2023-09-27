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

    val firstArtwork = R.drawable.grupo
    val secondArtwork = R.drawable.rachel
    val thirdArtwork = R.drawable.monica
    val fourthArtwork = R.drawable.phoebe
    val fiveArthWork = R.drawable.ross
    val sixArthWork = R.drawable.chandler
    val sevenArthWork = R.drawable.joey
    val eightArthWork = R.drawable.respiro
    val nineArthWork = R.drawable.siete
    val tenArthWork = R.drawable.acciongracias
    val elevenArthWork = R.drawable.pierden_casa

    var title by remember { mutableStateOf(R.string.friends) }
    var year by remember { mutableStateOf(R.string.Age) }
    var currentArtwork by remember { mutableStateOf(firstArtwork) }
    var imageResource by remember { mutableStateOf(currentArtwork) }


    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Box(
            modifier = Modifier.fillMaxWidth().background(color = Color.Gray).padding(16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.Student),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        ArtworkImage(
            currentArtwork = currentArtwork,
            modifier = Modifier.aspectRatio(0.9f)
        )
        Spacer(
            modifier = modifier.size(16.dp)
        )
        ArtworkTitle(
            title = title,
            year = year,
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
                    when (currentArtwork) {
                        firstArtwork -> {
                            currentArtwork = elevenArthWork
                            title = R.string.pierdenCasa
                            year = R.string.pierdenCasa_descripcion
                        }
                        secondArtwork -> {
                            currentArtwork = firstArtwork
                            title = R.string.friends
                            year = R.string.Age
                        }
                        thirdArtwork -> {
                            currentArtwork = secondArtwork
                            title = R.string.rachel
                            year = R.string.rachel_year
                        }
                        fourthArtwork -> {
                            currentArtwork = thirdArtwork
                            title = R.string.monica
                            year = R.string.monica_year
                        }
                        fiveArthWork -> {
                            currentArtwork = fourthArtwork
                            title = R.string.phoebe
                            year = R.string.phoebe_year
                        }
                        sixArthWork -> {
                            currentArtwork = fiveArthWork
                            title = R.string.ross
                            year = R.string.ross_year
                        }
                        sevenArthWork -> {
                            currentArtwork = sixArthWork
                            title = R.string.chandler
                            year = R.string.chandler_year
                        }
                        eightArthWork -> {
                            currentArtwork = sevenArthWork
                            title = R.string.joey
                            year = R.string.joey_year
                        }
                        nineArthWork -> {
                            currentArtwork = eightArthWork
                            title = R.string.respiro
                            year = R.string.respiro_descripcion
                        }
                        tenArthWork -> {
                            currentArtwork = nineArthWork
                            title = R.string.siete
                            year = R.string.siete_descripcion
                        }
                        else -> {
                            currentArtwork = tenArthWork
                            title = R.string.accionGracias
                            year = R.string.accionGracias_descripcion
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.purple_500)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp,
                ),
                modifier = Modifier.shadow(4.dp, shape= RoundedCornerShape(4.dp))
            ) {
                Text(
                    text = stringResource(id = R.string.anterior),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }
            Button(onClick = {
                currentArtwork = firstArtwork
                title = R.string.friends
                year = R.string.Age
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
                    when (currentArtwork) {
                        firstArtwork -> {
                            currentArtwork = secondArtwork
                            title = R.string.rachel
                            year = R.string.rachel_year
                        }
                        secondArtwork -> {
                            currentArtwork = thirdArtwork
                            title = R.string.monica
                            year = R.string.monica_year
                        }
                        thirdArtwork -> {
                            currentArtwork = fourthArtwork
                            title = R.string.phoebe
                            year = R.string.phoebe_year
                        }
                        fourthArtwork -> {
                            currentArtwork = fiveArthWork
                            title = R.string.ross
                            year = R.string.ross_year
                        }
                        fiveArthWork -> {
                            currentArtwork = sixArthWork
                            title = R.string.chandler
                            year = R.string.chandler_year
                        }
                        sixArthWork -> {
                            currentArtwork = sevenArthWork
                            title = R.string.joey
                            year = R.string.joey_year
                        }
                        sevenArthWork -> {
                            currentArtwork = eightArthWork
                            title = R.string.respiro
                            year = R.string.respiro_descripcion
                        }
                        eightArthWork -> {
                            currentArtwork = nineArthWork
                            title = R.string.siete
                            year = R.string.siete_descripcion
                        }
                        nineArthWork -> {
                            currentArtwork = tenArthWork
                            title = R.string.accionGracias
                            year = R.string.accionGracias_descripcion
                        }
                        tenArthWork -> {
                            currentArtwork = elevenArthWork
                            title = R.string.pierdenCasa
                            year = R.string.pierdenCasa_descripcion
                        }
                        else -> {
                            currentArtwork = firstArtwork
                            title = R.string.friends
                            year = R.string.Age
                        }
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

fun resetGallery(
    @DrawableRes currentArtwork: Int,
    @StringRes title: Int,
    @StringRes year: Int
){

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
fun ArtworkTitle2(
    @StringRes title: Int,
    @StringRes description: Int,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = title),
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.blue_100),
            fontSize = 32.sp,
        )
        Text(
            text = stringResource(id = description),
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.gray_300),
            fontSize = 16.sp,
        )
    }
}

@Composable
fun ArtworkTitle(
    @StringRes title: Int,
    @StringRes year: Int,
) {
    Column(
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

