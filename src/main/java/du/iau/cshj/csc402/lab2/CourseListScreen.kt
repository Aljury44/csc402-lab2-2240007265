package du.iau.cshj.csc402.lab2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import du.iau.cshj.csc402.lab2.ui.theme.AndroidGreen
import du.iau.cshj.csc402.lab2.ui.theme.Navy
import du.iau.cshj.csc402.lab2.ui.theme.ScreenBackground

data class Course(
    val code: String,
    val title: String,
    val credits: Int,
    val days: String
)

@Composable
fun CourseListScreen() {
    val courses = remember {
        listOf(
            Course(
                "HCI",
                "Human Computer Interaction-CS72",
                3,
                "Section CS72"
            ),
            Course(
                "DIP",
                "Image Processing-04",
                3,
                "Section 04"
            ),
            Course(
                "DIP",
                "Image Processing-CS74",
                3,
                "Section CS74"
            ),
            Course(
                "CSC 402",
                "Mobile Application Programming-02",
                3,
                "Section 02"
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ScreenBackground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Navy)
                .padding(20.dp)
        ) {
            Text(
                text = "My Courses",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Task 10 - LazyColumn & data class",
                color = Color.LightGray
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(AndroidGreen)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(courses) { course ->
                CourseRow(course)
            }
        }
    }
}

@Composable
fun CourseRow(course: Course) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
        ) {
            Box(
                modifier = Modifier
                    .width(5.dp)
                    .fillMaxHeight()
                    .background(AndroidGreen)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                Text(
                    text = course.code,
                    fontWeight = FontWeight.Bold,
                    color = Navy
                )

                Text(
                    text = course.title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 15.sp
                )

                Text(
                    text = course.days,
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }

            Box(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = 14.dp)
                    .clip(RoundedCornerShape(18.dp))
                    .background(AndroidGreen.copy(alpha = 0.15f))
                    .padding(horizontal = 10.dp, vertical = 6.dp)
            ) {
                Text(
                    text = "${course.credits} cr",
                    color = Color(0xFF168A52),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseListScreenPreview() {
    CourseListScreen()
}