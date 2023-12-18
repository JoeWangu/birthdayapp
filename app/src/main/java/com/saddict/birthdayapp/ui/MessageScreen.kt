package com.saddict.birthdayapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saddict.birthdayapp.R

@Composable
fun MessageScreen(state:ScrollState, modifier: Modifier = Modifier){
    Box(modifier = modifier){
        Image(
            painter = painterResource(id = R.drawable.design),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = state),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            MessageBody(
//                modifier = Modifier
//                    .offset(y = (-180).dp)
            )
            Spacer(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.bd_cake),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
            )
        }
    }
}

@Composable
fun MessageBody(
//    modifier: Modifier = Modifier
){
//    Column(
//        modifier = modifier
//            .fillMaxSize()
//            .padding(8.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Bottom
//    ) {
        Text(
            text = stringResource(id = R.string.message),
            style = MaterialTheme.typography.labelSmall,
            color = Color.Black,
            fontSize = 20.sp
        )
//    }
}