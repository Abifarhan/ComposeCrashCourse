package com.abifarhan.composecrashcourse

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Space
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abifarhan.composecrashcourse.ui.theme.ComposeCrashCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
//            MessageCard(Message("Abi","Farhan"))

            ComposeCrashCourseTheme {
                Conversation(SampleData.conversationSample)
            }
        }
    }


}

//@Composable
//fun MessageCard(name: String) {
//    Text(text="Hello $name")
//}

@Composable
fun MessageCard(msg: Message) {
//    Add padding around our message
    Row(modifier = Modifier.padding(all = 8.dp)) {
       Image(
           painter = painterResource(id = R.drawable.stawberry),
           contentDescription = "Contact profile picture",
           modifier = Modifier
//       // Set image size to 40 dp
               .size(40.dp)
//       Clip image
               .clip(CircleShape)
               .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
           )

        Spacer(modifier = Modifier.width(8.dp))

//        We keep track if the message is expanded or not in this
//        variable
        var isExpanded by remember{
            mutableStateOf(false)
        }
        val surfaceColor: Color by animateColorAsState(
            if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
        )
//        We toggle the isExpanded variable when we click on this Columns
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(text = msg.author,
            color = MaterialTheme.colors.secondaryVariant,
            style = MaterialTheme.typography.subtitle2)

//            Add a vertical space between the author adnd message texts
            Spacer(modifier = Modifier.height(4.dp))

            androidx.compose.material.Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
//                surfaceColor color will be changing gradually from primary to surface
            color = surfaceColor,
                modifier = Modifier.animateContentSize().padding(1.dp)
            ) {
                Text(text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
//                    If the message is expanded, we display all its content
//                    otherwise we only display the first line
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.body2)
            }
        }
    }

}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewMessageCard() {
//    ComposeTutorialTheme{
//
//    }
    ComposeCrashCourseTheme {
        Conversation(SampleData.conversationSample)
    }
//    MessageCard(
//        msg = Message("Colleague","Hey, take a look at Jetpack Compose, it's great")
//    )
}

//adding  multiple text

data class Message(val author: String, val body: String)


@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn() {
        items(messages) { message ->
            MessageCard(msg = message)
        }
    }
}
//@Composable
//fun UserCard() {
//    Row() {
//        Image(painter = painterResource(id = R.drawable.stawberry), contentDescription = "the description")
//    }
//
//    Column {
//
//    }
//}
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