package du.iau.cshj.csc402.lab2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import du.iau.cshj.csc402.lab2.ui.theme.AndroidGreen
import du.iau.cshj.csc402.lab2.ui.theme.Navy
import du.iau.cshj.csc402.lab2.ui.theme.ScreenBackground

data class TeamTask(
    val id: Int,
    val title: String,
    val owner: String,
    val isDone: Boolean = false
)

@Composable
fun TaskTrackerScreen() {
    val tasks = remember {
        mutableStateListOf(
            TeamTask(1, "Create GitHub repository", "Aljury", true),
            TeamTask(2, "Complete Kotlin tasks", "Aljury", true),
            TeamTask(3, "Build Compose screens", "Aljury"),
            TeamTask(4, "Take screenshots", "Aljury")
        )
    }

    val done = tasks.count { it.isDone }
    val total = tasks.size
    val open = total - done

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
                text = "Team Task Tracker",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Task 11 - Challenge",
                color = Color.LightGray
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(AndroidGreen)
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(containerColor = Navy)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                SummaryItem(done.toString(), "Done")
                SummaryItem(open.toString(), "Open")
                SummaryItem(total.toString(), "Total")
            }
        }

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(tasks, key = { it.id }) { task ->
                TaskRow(
                    task = task,
                    onToggle = {
                        val index = tasks.indexOfFirst { it.id == task.id }

                        if (index >= 0) {
                            tasks[index] = task.copy(
                                isDone = !task.isDone
                            )
                        }
                    }
                )
            }
        }

        Button(
            onClick = {
                val nextId = (tasks.maxOfOrNull { it.id } ?: 0) + 1

                tasks.add(
                    TeamTask(
                        id = nextId,
                        title = "New task",
                        owner = "Aljury"
                    )
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = AndroidGreen,
                contentColor = Navy
            )
        ) {
            Text(
                text = "+ Add task",
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun SummaryItem(value: String, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            color = AndroidGreen,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = label,
            color = Color.LightGray,
            fontSize = 12.sp
        )
    }
}

@Composable
fun TaskRow(
    task: TeamTask,
    onToggle: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = task.isDone,
                onCheckedChange = {
                    onToggle()
                },
                colors = CheckboxDefaults.colors(
                    checkedColor = AndroidGreen
                )
            )

            Spacer(modifier = Modifier.padding(4.dp))

            Column {
                Text(
                    text = task.title,
                    color = if (task.isDone) Color.Gray else Navy,
                    fontWeight = FontWeight.Bold,
                    textDecoration = if (task.isDone) {
                        TextDecoration.LineThrough
                    } else {
                        TextDecoration.None
                    }
                )

                Text(
                    text = task.owner,
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskTrackerScreenPreview() {
    TaskTrackerScreen()
}