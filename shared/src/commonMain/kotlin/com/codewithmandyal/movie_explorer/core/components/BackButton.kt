package com.codewithmandyal.movie_explorer.core.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusTarget
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun BackButton(
    circleSize: Dp,
    arrowSize: Dp,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    var focused by remember { mutableStateOf(false) }

    val backgroundColor by animateColorAsState(
        targetValue = if (focused) Color(0xFFE50914) else Color(0xAA222222),
        label = "BackButtonBackground"
    )

    val borderColor by animateColorAsState(
        targetValue = if (focused) Color.White else Color.White.copy(alpha = 0.08f),
        label = "BackButtonBorder"
    )

    val scale by animateFloatAsState(
        targetValue = if (focused) 1.08f else 1f,
        label = "BackButtonScale"
    )


    Box(
        modifier = modifier
            .size(circleSize)
            .onFocusChanged {
                focused = it.isFocused
                println("BackButton Focus = ${it.isFocused}")
            }
           // .focusable()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = {
                    println("BackButton Click")
                    onClick()

                }
            )
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
            .clip(CircleShape)
            .background(backgroundColor)
            .border(
                width = 2.dp,
                color = borderColor,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(arrowSize)
        )
    }
}