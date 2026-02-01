package com.gerali.app.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.gerali.app.ui.theme.GeraliBlue
import com.gerali.app.ui.theme.GeraliGreen

enum class ButtonVariant {
    Primary,
    Secondary,
    Outline
}

@Composable
fun GeraliButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    loading: Boolean = false,
    variant: ButtonVariant = ButtonVariant.Primary
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        enabled = enabled && !loading,
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            containerColor = when (variant) {
                ButtonVariant.Primary -> GeraliBlue
                ButtonVariant.Secondary -> GeraliGreen
                ButtonVariant.Outline -> Color.Transparent
            },
            contentColor = if (variant == ButtonVariant.Outline) GeraliBlue else Color.White
        ),
        border = if (variant == ButtonVariant.Outline) {
            BorderStroke(2.dp, GeraliBlue)
        } else {
            null
        }
    ) {
        if (loading) {
            CircularProgressIndicator(
                modifier = Modifier.height(24.dp),
                color = Color.White
            )
        } else {
            Text(
                text = text,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
