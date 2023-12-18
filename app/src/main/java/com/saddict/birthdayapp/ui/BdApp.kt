package com.saddict.birthdayapp.ui

import android.net.Uri
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.saddict.birthdayapp.R
import com.saddict.birthdayapp.navigation.BdNavEnum

@Composable
fun BdApp(uri: Uri, modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = BdNavEnum.valueOf(
        backStackEntry?.destination?.route ?: BdNavEnum.Start.name
    )
    val state = rememberScrollState()
    Scaffold(
        topBar = {
            TopBar(
                currentScreenTitle = currentScreen.title,
                canNavigateUp = navController.previousBackStackEntry != null,
                navigateUp = { navController.popBackStack() }
            )
        },
        modifier = modifier
    ) {
        NavHost(
            navController = navController,
            startDestination = BdNavEnum.Start.name,
            modifier = Modifier.padding(it)
        ) {
            composable(route = BdNavEnum.Start.name) {
                HomeScreen(
                    onNextClick = { navController.navigate(BdNavEnum.Message.name) },
                    uri = uri
                )
            }
            composable(route = BdNavEnum.Message.name){
                MessageScreen(
                    state = state
//                    onBackClick = { navController.popBackStack() }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    @StringRes currentScreenTitle: Int,
    canNavigateUp: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = currentScreenTitle),
                style = MaterialTheme.typography.displayLarge
            )
        },
        modifier = modifier,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.onPrimary,
            titleContentColor = MaterialTheme.colorScheme.secondary
        ),
        navigationIcon = {
            if (canNavigateUp) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowBack,
                        contentDescription = stringResource(id = R.string.go_back)
                    )
                }
            }
        }
    )
}