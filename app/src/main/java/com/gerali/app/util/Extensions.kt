package com.gerali.app.util

fun formatCpf(input: String): String {
    val digits = input.filter { it.isDigit() }.take(11)
    val builder = StringBuilder()
    digits.forEachIndexed { index, c ->
        builder.append(c)
        if (index == 2 || index == 5) builder.append('.')
        if (index == 8) builder.append('-')
    }
    return builder.toString()
}
