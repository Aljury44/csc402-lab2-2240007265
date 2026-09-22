package du.iau.cshj.csc402.lab2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import du.iau.cshj.csc402.lab2.ui.theme.AndroidGreen
import du.iau.cshj.csc402.lab2.ui.theme.Navy
import du.iau.cshj.csc402.lab2.ui.theme.ScreenBackground

@Composable
fun AttendanceCounter() {
    var count by remember { mutableStateOf(0) }

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
                text = "Attendance Counter",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )

            Text(
                text = "Task 8 - remember & state",
                color = Color.LightGray
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(AndroidGreen)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "STUDENTS PRESENT",
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(18.dp))

            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier
                    .width(200.dp)
                    .height(130.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = count.toString(),
                        fontSize = 52.sp,
                        fontWeight = FontWeight.Bold,
                        color = Navy
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(35.dp)
            ) {
                OutlinedButton(
                    onClick = {
                        if (count > 0) count--
                    },
                    enabled = count > 0,
                    modifier = Modifier.width(100.dp)
                ) {
                    Text("-", fontSize = 24.sp)
                }

                Button(
                    onClick = {
                        count++
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AndroidGreen,
                        contentColor = Navy
                    ),
                    modifier = Modifier.width(100.dp)
                ) {
                    Text("+", fontSize = 24.sp)
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            OutlinedButton(
                onClick = {
                    count = 0
                },
                enabled = count > 0,
                modifier = Modifier.width(160.dp)
            ) {
                Text("Reset")
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = if (count == 0) {
                    "Tap + to check a student in."
                } else {
                    "$count of 30 students checked in."
                },
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AttendanceCounterPreview() {
    AttendanceCounter()
}