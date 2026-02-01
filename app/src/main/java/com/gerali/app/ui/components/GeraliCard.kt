package com.gerali.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GeraliCard(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White,
    gradient: Brush? = null,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.large,
        shadowElevation = 6.dp,
        color = backgroundColor
    ) {
        Column(
            modifier = Modifier
                .background(gradient ?: Brush.verticalGradient(listOf(backgroundColor, backgroundColor)))
                .padding(16.dp)
        ) {
            content()
        }
    }
}
