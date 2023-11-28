package com.wedge.drawingtoyou.core.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wedge.drawingtoyou.ui.theme.OnSecondary
import com.wedge.drawingtoyou.ui.theme.devomayo

@Composable
fun WdtyButton(
    modifier: Modifier = Modifier,
    buttonType: WdtyButtonType = WdtyButtonType.PRIMARY,
    buttonState: WdtyButtonState = WdtyButtonState.DEFAULT,
    text: String,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(buttonType.getButtonColor(buttonState), shape = RoundedCornerShape(100.dp))
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        WDtyButtonIcon(
            modifier = Modifier.wrapContentSize(),
            buttonState = buttonState
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            color = buttonState.textColor,
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontFamily = devomayo,
                fontWeight = FontWeight.W400,
                color = OnSecondary,
                textAlign = TextAlign.Center,
            )
        )
    }
}

@Composable
fun WDtyButtonIcon(
    modifier: Modifier = Modifier,
    buttonState: WdtyButtonState,
) {
    if (buttonState == WdtyButtonState.LOADING) {
        CircularProgressIndicator(
            modifier = modifier
        )
    } else {
        Image(
            modifier = modifier,
            painter = painterResource(id = buttonState.brushIcon),
            contentDescription = "brush_icon"
        )
    }
}

@Preview
@Composable
fun Preview_WdtyButton() {
    Column {
        WdtyButton(
            buttonType = WdtyButtonType.PRIMARY,
            buttonState = WdtyButtonState.ACTIVE,
            text = "test"
        )
        WdtyButton(
            buttonType = WdtyButtonType.SECONDARY,
            buttonState = WdtyButtonState.ACTIVE,
            text = "test"
        )
    }
}