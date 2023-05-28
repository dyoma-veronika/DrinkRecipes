package com.example.drinkrecipes.presentation.ui.detailsscreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.drinkrecipes.presentation.model.DrinkDetailsViewData

@Composable
fun DrinkDetailsCard(
    drink: DrinkDetailsViewData?
) {

    val context = LocalContext.current
    val configuration = LocalConfiguration.current

    val instructions: String? = when (configuration.locales[0].language) {
        "de" -> drink?.instructionsDe
        "es" -> drink?.instructionsEs
        "fr" -> drink?.instructionsFr
        "it" -> drink?.instructionsIt
        "zh-Hans" -> drink?.instructionsZhHans
        "zh-Hant" -> drink?.instructionsZhHant
        else -> drink?.instructions
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = drink?.imageUri
                ),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f / 1f)
                    .shadow(elevation = 8.dp, shape = MaterialTheme.shapes.large)
                    .clip(RoundedCornerShape(20.dp))
            )
            Spacer(modifier = Modifier.height(8.dp))
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                drink?.name?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                drink?.ingredients?.let {
                    Text(
                        text = it.joinToString(", "),
                        style = MaterialTheme.typography.titleSmall
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                instructions?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}
