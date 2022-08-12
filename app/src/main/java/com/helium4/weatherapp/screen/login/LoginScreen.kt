

package com.helium4.weatherapp.screen.login

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.helium4.weatherapp.components.EmailField
import com.helium4.weatherapp.components.LoginButton
import com.helium4.weatherapp.components.PassField
import com.helium4.weatherapp.navigation.WeatherScreens
import com.helium4.weatherapp.utils.isEmailValid


@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current

    val email= remember {
        mutableStateOf("")
    }
    val pass= remember {
        mutableStateOf("")
    }
    val emailValidSate = remember(email.value) {

        email.value.trim().isBlank()
    }
    val passValidSate = remember(email.value) {

        pass.value.trim().isBlank()

    }
    val keyboardController = LocalSoftwareKeyboardController.current

    Surface(modifier = Modifier
        .padding(2.dp)
        .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(8.dp),),
        border = BorderStroke(width = 1.dp,color = Color.LightGray)
    ) {
        Column(modifier = Modifier.padding(6.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally) {

            EmailField(
                valueState = email ,
                labelId = "Enter Email",
                enabled = true ,
                isSingleLine = true,
                onAction = KeyboardActions{


                }
            )

            PassField(
                valueState = pass ,
                labelId = "Enter Password",
                enabled = true ,
                isSingleLine = true,
                onAction = KeyboardActions{

                }
            )
            Button(modifier = Modifier.padding(5.dp)
                ,onClick = {

                    if (pass.value.toString() == "" || email.value.toString() == "" )

                        Toast.makeText(
                            context,
                            "Please enter any details",
                            Toast.LENGTH_SHORT
                        ).show()
                    //Send the value back to lambda

                    else if (email.value == "testapp@google.com" && pass.value =="Test@123456"){


                        navController.navigate(WeatherScreens.MainScreen.name)

                    }else if (email.value != "testapp@google.com" || pass.value !="Test@123456"){


                        Toast.makeText(
                            context,
                            "Wrong Cred...",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    keyboardController?.hide()
                }) {
                Text(text = "Login Button")
            }



        }

    }




}