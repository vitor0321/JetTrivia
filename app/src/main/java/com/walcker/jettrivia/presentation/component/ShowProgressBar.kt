package com.walcker.jettrivia.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.walcker.jettrivia.presentation.theme.mDarkPurple
import com.walcker.jettrivia.presentation.theme.mLightPurple
import java.math.BigDecimal
import java.sql.CallableStatement

@Composable
fun ShowProgressBar(
    score: Int,
    listQuestionSize: Int
) {

    val scoreBig: BigDecimal = remember {
        BigDecimal(score).setScale(10, BigDecimal.ROUND_HALF_UP)
    }
    val listQuestionSizeBig: BigDecimal = remember {
        BigDecimal(listQuestionSize).setScale(10, BigDecimal.ROUND_HALF_UP)
    }
    val percentageOfList = remember{(scoreBig / listQuestionSizeBig)}
    val progressFactor = remember { mutableStateOf(percentageOfList) }

    Row(
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .height(45.dp)
            .border(
                width = 4.dp,
                brush = Brush.linearGradient(
                    colors = listOf(mLightPurple, mDarkPurple)
                ),
                shape = RoundedCornerShape(34.dp)
            )
            .clip(
                RoundedCornerShape(
                    topEndPercent = 50,
                    bottomStartPercent = 50,
                    topStartPercent = 50,
                    bottomEndPercent = 50
                )
            )
            .background(Color.Transparent),
        verticalAlignment = Alignment.CenterVertically
    ) {

        LinearProgressIndicator(
            progress = progressFactor.value.toFloat(),
            backgroundColor = Color.Transparent,
            color = Color.White,
            modifier = Modifier
                .fillMaxSize()
                .padding(6.dp)
                .clip(RoundedCornerShape(34.dp))
        )
    }
}