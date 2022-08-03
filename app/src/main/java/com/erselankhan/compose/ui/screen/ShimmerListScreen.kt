package com.erselankhan.compose.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShimmerListScreen(
) {
    val showShimmerView = true

    Box(Modifier.fillMaxSize()) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(2)
        ) {
            if (showShimmerView) {
                items(10) {
                    ShimmerEffectHolder()
                }
            } else {
                // load data here
            }
        }
    }
}

@Preview
@Composable
fun ShimmerEffectHolder() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImagePlaceHolder(
            size = 80.dp
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        LinePlaceHolder(
            width = 80.dp
        )
    }
}

/*
* Shimmer Effect Image Views
*/
@Composable
fun ImagePlaceHolder(
    size: Dp = 12.dp
) = ShimmerAnimation {
    Spacer(
        modifier = Modifier
            .size(size)
            .background(
                brush = it,
                RoundedCornerShape(8.dp)
            )
    )
}

/*
* Shimmer Effect Line Views
*/
@Composable
fun LinePlaceHolder(
    width: Dp = 40.dp
) = ShimmerAnimation {
    Spacer(
        modifier = Modifier
            .width(width)
            .height(16.dp)
            .background(
                brush = it,
                shape = RoundedCornerShape(4.dp)
            )
    )
}