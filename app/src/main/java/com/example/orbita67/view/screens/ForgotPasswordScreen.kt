package com.example.orbita67.view.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.orbita67.ui.theme.*


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CodeAccept(
    onClick: () -> Unit
) {

    var code by remember { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }
    val coroutineScope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current
    val bringIntoViewRequester = BringIntoViewRequester()
    val isFormValid by derivedStateOf { code.length == 6 }
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }



    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(Color.White)
            .fillMaxHeight()) {
        Column() {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp)
                    .bringIntoViewRequester(bringIntoViewRequester),
                backgroundColor = Color.White,
                elevation = 0.dp,
                shape = BottomBoxShape.medium
            ) {

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Проверка телефона",
                        fontSize = 28.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(top = 20.dp),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontFamily = cera_round_pro_regular
                    )
                    Text(
                        text = "Мы отправили на Ваш номер смс с 6-значным кодом подверждения. Пожалуйста, введите полученный код для входа в аккаунт.",
                        color = LightTextColor,
                        fontFamily = cera_round_pro_regular,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(top = 16.dp)
                            .padding(horizontal = 20.dp),
                        maxLines = 2,
                        textAlign = TextAlign.Center,

                        )


                    OutlinedTextField(
                        maxLines = 1,
                        value = code, onValueChange = {
                            if (it.length <= 6) code = it

                        },

                        label = {
                            Text(
                                text = "Код из смс",
                                color = PrimaryColor,
                                textAlign = TextAlign.Center,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = cera_round_pro_regular)
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .padding(horizontal = 20.dp)
                            .padding(top = 10.dp)
                            .focusRequester(focusRequester),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = PrimaryColor,
                            textColor = PrimaryColor,
                            focusedBorderColor = PrimaryColor,
                            focusedLabelColor = PrimaryColor,
                            cursorColor = PrimaryColor

                        ),

                        keyboardOptions = KeyboardOptions(
                            keyboardType =
                            KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = { if (isFormValid) onClick()}
                        ),
                        singleLine = true,
                        shape = BottomBoxShape.medium,
                        textStyle = TextStyle(
                            letterSpacing = 1.3.sp,
                            textAlign = TextAlign.Center,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = cera_round_pro_regular
                        )
                    )





                    Button(
                        enabled = isFormValid,
                        onClick = { onClick() },
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .padding(horizontal = 20.dp)
                            .padding(top = 20.dp, bottom = 20.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = PrimaryColor,
                            contentColor = Color.White
                        ),
                        contentPadding = PaddingValues(vertical = 14.dp),
                        shape = BottomBoxShape.medium
                    ) {

                        Text(text = "Отправить",
                            fontFamily = cera_round_pro_regular,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold)
                    }





                }
            }
        }
    }
}