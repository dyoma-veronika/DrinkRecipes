package com.example.drinkrecipes.presentation.ui.mainscreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.drinkrecipes.presentation.model.DrinkViewData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrinkCard(
    drink: DrinkViewData,
    onItemClick: (String) -> Unit
) {
    Card(
        modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        shape = MaterialTheme.shapes.large,
        onClick = { onItemClick(drink.id) }
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                model = drink.imageUri
            ),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f / 1f)
                .shadow(elevation = 8.dp, shape = MaterialTheme.shapes.large)
                .clip(RoundedCornerShape(20.dp))
        )
        Text(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
            text = drink.name,
            style = MaterialTheme.typography.headlineSmall
        )

    }
}
