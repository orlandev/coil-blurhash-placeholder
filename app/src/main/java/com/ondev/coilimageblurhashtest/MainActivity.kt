package com.ondev.coilimageblurhashtest

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toDrawable
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.ondev.coilimageblurhashtest.ui.theme.CoilImageDownloadTestTheme

class MainActivity : ComponentActivity() {
    @ExperimentalCoilApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoilImageDownloadTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column() {
                        App(resources)
                    }
                }
            }
        }
    }
}

const val imageURL = "https://ik.imagekit.io/6xgh00mrhaz/mapa_R2bOgibi6.jpg"

@ExperimentalCoilApi
@Composable
fun App(res: Resources) {
    val bitmap = BlurHashDecoder.decode("L58h%b0rO]px{aOAOFv}9czTHqxZ", 4, 4)
    Card(
        modifier = Modifier
            .height(400.dp)
            .fillMaxWidth()
            .padding(8.dp),
        shape = MaterialTheme.shapes.small
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            painter = rememberImagePainter(imageURL, builder = {
                when {
                    bitmap != null -> placeholder(bitmap.toDrawable(res))
                    else -> placeholder(R.drawable.no_image)
                }
                error(R.drawable.no_image)
                crossfade(700)
            }),
            contentDescription = null
        )
    }
}