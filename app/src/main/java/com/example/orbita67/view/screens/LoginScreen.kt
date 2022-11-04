package com.example.orbita67.view.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.orbita67.R
import com.example.orbita67.ui.theme.*
import com.example.orbita67.view.MaskTransformation
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LoginScreen(
    onClick: () -> Unit,
    onSignUpClick: () -> Unit,
    onForgotClick: () -> Unit
) {

    var phonenumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordOpen by remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }
    val coroutineScope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current
    val bringIntoViewRequester = BringIntoViewRequester()
    val isFormValid by derivedStateOf { phonenumber.length == 10 }
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }



    Box(contentAlignment = Alignment.Center, modifier = Modifier
        .background(Color.White)
        .fillMaxHeight()) {
        Column() {
            Card(
                modifier = Modifier
                    .bringIntoViewRequester(bringIntoViewRequester),
                backgroundColor = Color.White,
                elevation = 0.dp,
                shape = BottomBoxShape.medium
            ) {

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Ваш телефонный номер",
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
                        text = "Для входа или регистрации в приложение, пожалусйта, введите свой номер телефона",
                        color = LightTextColor,
                        fontFamily = cera_round_pro_regular,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .padding(horizontal = 20.dp),
                        maxLines = 2,
                        textAlign = TextAlign.Center,

                    )


                    OutlinedTextField(
                        maxLines = 1,
                        value = phonenumber, onValueChange = {
                            if (it.length <= 10) phonenumber = it

                        },

                        label = {
                            Text(
                                text = "Номер телефона",
                                color = PrimaryColor,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = cera_round_pro_regular)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(top = 10.dp)
                            .focusRequester(focusRequester)
                            .onFocusEvent { event ->
                                if(event.isFocused){
                                    coroutineScope.launch {
                                        bringIntoViewRequester.bringIntoView()
                                    }
                                }
                            },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = PrimaryColor,
                            textColor = PrimaryColor,
                            focusedBorderColor = PrimaryColor,
                            focusedLabelColor = PrimaryColor,
                            cursorColor = PrimaryColor

                        ),
                        leadingIcon = {
                            Row(
                                modifier = Modifier.padding(start = 8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "+7",
                                    color = PrimaryColor,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    fontFamily = cera_round_pro_regular
                                )
                                Spacer(
                                    modifier = Modifier
                                        .width(10.dp)
                                )
                                Spacer(
                                    modifier = Modifier
                                        .width(1.dp)
                                        .height(20.dp)
                                        .background(PrimaryColor)
                                )
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType =
                            KeyboardType.Phone,
                            imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = { if (isFormValid) onClick()}
                        ),
                        singleLine = true,
                        shape = BottomBoxShape.medium,
                        textStyle = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = cera_round_pro_regular
                        )
                    )





                    Button(
                        enabled = isFormValid,
                        onClick = { onClick() },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(top = 20.dp, bottom = 20.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = PrimaryColor,
                            contentColor = Color.White
                        ),
                        contentPadding = PaddingValues(vertical = 14.dp),
                        shape = BottomBoxShape.medium
                    ) {

                        Text(text = "Далее",
                            fontFamily = cera_round_pro_regular,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold)
                    }





                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewFunc(){
    LoginScreen(onClick = { /*TODO*/ }, onSignUpClick = { /*TODO*/ }) {
        
    }
}