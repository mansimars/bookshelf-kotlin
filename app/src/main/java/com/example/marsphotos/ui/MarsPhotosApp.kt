/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.marsphotos.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.marsphotos.R
import com.example.marsphotos.ui.screens.HomeScreen
import com.example.marsphotos.ui.screens.MarsViewModel

@Composable
fun MarsPhotosApp(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { TopAppBar(
            modifier = Modifier.height(80.dp),
            backgroundColor = Color.Black,
            title = {

                Row {

                    Text("Shelf 1", modifier.weight(1f),
                        textAlign = TextAlign.Center,
                        color = Color.White)
//                    Divider(color = Color.White, thickness = 3.dp)
                    Text("Shelf 2", modifier.weight(1f),
                        textAlign = TextAlign.Center,
                        color = Color.White)

                }

        }) }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = Color.Gray
        ) {
            val marsViewModel: MarsViewModel =
                viewModel(factory = MarsViewModel.Factory)
            HomeScreen(
                marsUiState = marsViewModel.marsUiState,
                retryAction = marsViewModel::getMarsPhotos
            )
        }
    }
}
