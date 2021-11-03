package com.abifarhan.composecrashcourse

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.abifarhan.composecrashcourse.ui.theme.ComposeCrashCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
//            Title()
            UserCard()
        }
    }


}

@Composable
fun UserCard() {
    Row() {
        Image(painter = painterResource(id = R.drawable.stawberry), contentDescription = "the description")
    }

    Column {

    }
}
//@Composable
//fun Title() {
//    val context = LocalContext.current
//    Text(
//        text = "Abi Jetpack Compose", fontSize = 32.sp,
//        fontFamily = FontFamily.Cursive,
//        color = colorResource(id = R.color.purple_700),
//        modifier = Modifier.clickable {
//            Toast.makeText(context, "Anda klik", Toast.LENGTH_SHORT).show()
//        }
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    androidx.compose.material.Surface(Modifier.fillMaxSize()) {
//        Title()
//    }
//}