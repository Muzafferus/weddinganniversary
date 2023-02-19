package com.muzafferus.weddinganniversary.presentation.screens.home

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.muzafferus.weddinganniversary.R
import com.muzafferus.weddinganniversary.domain.model.CoupleData
import com.muzafferus.weddinganniversary.ui.theme.*
import com.muzafferus.weddinganniversary.util.Util

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val coupleDataCompleted by homeViewModel.coupleData.collectAsState()

    if (coupleDataCompleted.isEmpty()) {
        EmptyList()
    } else {
        ListContent(coupleDataCompleted)
    }
}

@Composable
fun EmptyList() {
    EmptyContent(
        alphaAnim = ContentAlpha.disabled,
        icon = R.drawable.ic_network_error,
        message = "List is empty"
    )
}

@Composable
fun EmptyContent(
    alphaAnim: Float,
    icon: Int,
    message: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier
                .size(NETWORK_ERROR_ICON_HEIGHT)
                .alpha(alpha = alphaAnim),
            painter = painterResource(id = icon),
            contentDescription = stringResource(id = R.string.network_error_icon),
            tint = if (isSystemInDarkTheme()) LightGray else DarkGray
        )
        Text(
            modifier = Modifier
                .padding(top = SMALL_PADDING)
                .alpha(alpha = alphaAnim),
            text = message,
            color = if (isSystemInDarkTheme()) LightGray else DarkGray,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium,
            fontSize = MaterialTheme.typography.subtitle1.fontSize
        )

    }
}


@Composable
fun ListContent(data: ArrayList<CoupleData>) {
    LazyColumn(
        contentPadding = PaddingValues(all = SMALL_PADDING),
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
    ) {
        items(data) { couple ->
            CoupleItem(couple)
        }
    }
}

@Composable
fun CoupleItem(data: CoupleData) {

    Row(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(2.dp)
            .border(width = 1.dp, color = Purple700, shape = RoundedCornerShape(8.dp))
            .padding(2.dp)
            .background(color = Util.getColor(data.coupleWeddingDate))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.8f)
        ) {
            Text(
                modifier = Modifier.padding(start = SMALL_PADDING, bottom = SMALL_PADDING),
                text = data.coupleNames,
                color = Color.Black,
                fontSize = MaterialTheme.typography.subtitle1.fontSize,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(start = SMALL_PADDING, bottom = SMALL_PADDING),
                text = "ID: ${data.coupleId}",
                color = Color.Gray,
                fontSize = MaterialTheme.typography.subtitle2.fontSize,
                fontWeight = FontWeight.Light
            )
            Text(
                modifier = Modifier.padding(start = SMALL_PADDING, bottom = SMALL_PADDING),
                text = Util.parseDate(data.coupleWeddingDate),
                color = Color.Black,
                fontSize = MaterialTheme.typography.caption.fontSize
            )
        }

        if (Util.isHasTwoWeeks(data.coupleWeddingDate))
            Column(
                modifier = Modifier.fillMaxHeight().fillMaxSize().fillMaxWidth(),
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_network_error),
                    contentDescription = ""
                )
            }
    }
}

@Composable
@Preview(showBackground = true)
fun EmptyScreenPreview() {
    EmptyContent(
        alphaAnim = ContentAlpha.disabled,
        icon = R.drawable.ic_network_error,
        message = "Internet Unavailable."
    )
}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun EmptyScreenDarkPreview() {
    EmptyContent(
        alphaAnim = ContentAlpha.disabled,
        icon = R.drawable.ic_network_error,
        message = "Internet Unavailable."
    )
}