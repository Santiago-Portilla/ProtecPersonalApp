package com.portosdeveloper.protecpersonalapp.presentation.screens.WorkScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.portosdeveloper.protecpersonalapp.R
import com.portosdeveloper.protecpersonalapp.domain.module.User
import com.portosdeveloper.protecpersonalapp.presentation.screens.WorkScreen.WorkViewModel
import com.portosdeveloper.protecpersonalapp.presentation.ui.theme.Gray700
import com.portosdeveloper.protecpersonalapp.presentation.ui.theme.Green200

@Composable
fun WorkContent(viewModel: WorkViewModel = hiltViewModel(), user: User){

    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth()
    ){
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            backgroundColor = Gray700
        ){
            Row(

            ) {
                if(user.image != ""){
                    AsyncImage(
                        modifier = Modifier
                            .padding(5.dp)
                            .size(150.dp)
                            .clip(CircleShape),
                        model = user.image,
                        contentDescription = "User Image",
                        contentScale = ContentScale.Crop
                    )
                }else{
                    Image(
                        modifier = Modifier.size(120.dp),
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = "ImageUser")
                }
                Column(
                    modifier = Modifier.padding(top = 100.dp)
                ) {
                    Text(
                        text = "${user.name} ${user.surName}",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = user.job,
                        fontSize = 20.sp,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            backgroundColor = Gray700

        ) {
            Column() {
                Row(
                    Modifier.fillMaxWidth()
                ) {
                    Text(
                        modifier = Modifier.padding(start = 10.dp),
                        text = "Hoy",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        modifier = Modifier.padding(end = 10.dp),
                        text = "$ ${user.workDay}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
                Row(
                    Modifier.fillMaxWidth()
                ) {
                    Text(modifier = Modifier.padding(start = 10.dp),
                        text = "Quincena",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        modifier = Modifier.padding(end = 10.dp),
                        text = "$ ${user.workWeek}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
                Row(
                    Modifier.fillMaxWidth()
                ) {
                    Text(
                        modifier = Modifier.padding(start = 10.dp),
                        text = "Mes",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        modifier = Modifier.padding(end = 10.dp),
                        text = "$ ${user.workMonth}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            backgroundColor = Gray700

        ) {
            Column() {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp)
                        .clickable { expanded = !expanded },
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    Text(
                        modifier = Modifier
                            .padding(start = 10.dp),
                        text = "Trabajado",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = "",
                        modifier = Modifier.padding(8.dp)
                    )
                }
                if(expanded){
                    if(user.workDay == "0"){
                        Text(
                            modifier = Modifier.padding(start = 15.dp),
                            text = "Aun no ha empezado",
                            fontWeight = FontWeight.Bold
                        )
                    }else{
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(start = 20.dp),
                                text = "Paquete",
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(start = 20.dp),
                                text = "Fecha",
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(start = 10.dp),
                                text = "Cantidad",
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(start = 20.dp),
                                text = "Total",
                                fontWeight = FontWeight.Bold
                            )

                        }
                        user.workListFinish.forEachIndexed { index, string ->

                            val parts = string.split(",")
                            val id = parts.getOrElse(0) { "" }
                            val date = parts.getOrElse(1) { "" }
                            val quantity = parts.getOrElse(3) { "" }
                            val price = parts.getOrElse(4) { "" }
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ){
                                Text(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 20.dp),
                                    text = "- $id",
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 10.dp),
                                    text = date
                                )
                                Text(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 30.dp),
                                    text = quantity
                                )
                                Text(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(start = 10.dp),
                                    text = "+$ $price",
                                    color = Green200,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }

            }
        }

    }
}

