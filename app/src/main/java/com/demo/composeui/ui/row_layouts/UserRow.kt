package com.demo.composeui.ui.row_layouts

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.demo.composeui.ui.model.User
import com.demo.composeui.ui.theme.ComposeUITheme

@Composable
fun UserRow(user: User) {
    Card(
        modifier = Modifier
//            .fillMaxWidth()
            .padding(3.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxWidth()
        ) {
            val (name, mobile) = createRefs()
            Text(
                text = user.name, modifier = Modifier
                    .padding(all = 8.dp)
                    .constrainAs(name) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(mobile.start)
                        width = Dimension.fillToConstraints
                    }
            )
            Text(
                text = user.mobileNo, modifier = Modifier
                    .padding(8.dp)
                    .constrainAs(mobile) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    }
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Preview
@Composable
fun RowPreview() {
    ComposeUITheme {
        val users = arrayListOf(
            User(name = "Jimesh", mobileNo = "+91 8238345247", isVisibleName = false),
            User(name = "Komal", mobileNo = "+91 7600746616", isVisibleMobileNo = false),
            User(name = "Papa", mobileNo = "+91 9998762136"),
            User(name = "Mummy", mobileNo = "+91 9601526641")
        )
        FlowRow(
            modifier = Modifier.wrapContentWidth(Alignment.Start),
//            columns = GridCells.Fixed(count = 2),
            verticalArrangement = Arrangement.spacedBy(1.dp),
            horizontalArrangement = Arrangement.spacedBy(1.dp)
        ) {
            users.forEach { user ->
                UserRow(user)
            }
//            items(users, key = { x -> x.name }) { user ->
//                UserRow(user)
//            }
        }
//        UserRow(User(name = "Jimesh", mobileNo = "+91 8238345247"))
    }
}