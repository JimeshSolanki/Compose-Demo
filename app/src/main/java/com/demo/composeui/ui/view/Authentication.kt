package com.demo.composeui.ui.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.demo.composeui.R
import com.demo.composeui.ui.generic.GenericButton
import com.demo.composeui.ui.generic.GenericCheckBox
import com.demo.composeui.ui.theme.ComposeUITheme

@Composable
fun Login() {
    Card(
        onClick = {
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            val (edtUserName, edtPassword, cbRememberMe, tvRememberMe, btnLogin) = createRefs()

            Text(
                text = stringResource(id = R.string.label_enter_username),
                modifier = Modifier
                    .constrainAs(edtUserName) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif,
            )

            Text(
                text = stringResource(R.string.label_enter_password),
                modifier = Modifier
                    .constrainAs(edtPassword) {
                        top.linkTo(edtUserName.bottom)
                        start.linkTo(edtUserName.start)
                        end.linkTo(edtUserName.end)
                    },
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif,
            )

            GenericCheckBox(
                text = stringResource(id = R.string.label_remember_me), modifier = Modifier
                    .constrainAs(cbRememberMe) {
                        top.linkTo(edtPassword.bottom)
                        start.linkTo(edtPassword.start)
                        end.linkTo(edtPassword.end)
                    }
            ) {
            }

            GenericButton(
                text = stringResource(id = R.string.label_login),
                modifier = Modifier.constrainAs(btnLogin) {
                    top.linkTo(cbRememberMe.bottom)
                    start.linkTo(cbRememberMe.start)
                    end.linkTo(cbRememberMe.end)
                },
                onClick = {
                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreviewer() {
    ComposeUITheme {
        Login()
    }
}