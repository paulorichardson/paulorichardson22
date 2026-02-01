package com.gerali.app.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.gerali.app.R
import com.gerali.app.ui.components.ButtonVariant
import com.gerali.app.ui.components.GeraliButton
import com.gerali.app.ui.components.GeraliTextField
import com.gerali.app.ui.theme.GeraliBlue
import com.gerali.app.ui.theme.GeraliGreen
import com.gerali.app.ui.theme.TextSecondary
import com.gerali.app.util.formatCpf

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onGoToScanner: () -> Unit
) {
    var cpf by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(GeraliBlue, GeraliGreen)
                )
            )
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .size(120.dp)
                .clip(RoundedCornerShape(32.dp))
        ) {
            androidx.compose.foundation.Image(
                painter = painterResource(id = R.drawable.ic_gerali_logo),
                contentDescription = "Gerali"
            )
        }

        Spacer(Modifier.height(16.dp))

        Text(
            "Gestão de Alimentação Inteligente",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White
        )

        Spacer(Modifier.height(32.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp)
            ) {
                Text(
                    "Bem-vindo(a)!",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = GeraliBlue
                )

                Text(
                    "Entre com suas credenciais",
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextSecondary
                )

                Spacer(Modifier.height(24.dp))

                GeraliTextField(
                    value = cpf,
                    onValueChange = { cpf = formatCpf(it) },
                    label = "CPF",
                    placeholder = "000.000.000-00",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                Spacer(Modifier.height(16.dp))

                GeraliTextField(
                    value = senha,
                    onValueChange = { senha = it },
                    label = "Senha",
                    isPassword = true
                )

                Spacer(Modifier.height(24.dp))

                GeraliButton(
                    text = "Entrar no Sistema",
                    onClick = onLoginSuccess
                )

                Spacer(Modifier.height(16.dp))

                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    GeraliButton(
                        text = "Admin",
                        onClick = onLoginSuccess,
                        modifier = Modifier.weight(1f),
                        variant = ButtonVariant.Outline
                    )
                    GeraliButton(
                        text = "Scanner",
                        onClick = onGoToScanner,
                        modifier = Modifier.weight(1f),
                        variant = ButtonVariant.Secondary
                    )
                }
            }
        }
    }
}
