package du.iau.cshj.csc402.lab2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import du.iau.cshj.csc402.lab2.ui.theme.AndroidGreen
import du.iau.cshj.csc402.lab2.ui.theme.Navy
import du.iau.cshj.csc402.lab2.ui.theme.ScreenBackground

@Composable
fun GreetingScreen() {
    var name by remember { mutableStateOf("") }
    var submittedName by remember { mutableStateOf("") }

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
                text = "Greeting Card",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Task 9 - TextField & state",
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
            modifier = Modifier.padding(24.dp)
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Your name") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(14.dp))

            Button(
                onClick = {
                    submittedName = name.trim()
                },
                enabled = name.isNotBlank(),
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = AndroidGreen,
                    contentColor = Navy
                )
            ) {
                Text(
                    text = "Show greeting",
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(26.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(26.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (submittedName.isBlank()) {
                        Text(
                            text = "Type your name above\nto see the greeting.",
                            textAlign = TextAlign.Center,
                            color = Color.Gray
                        )
                    } else {
                        Text(
                            text = "Marhaba, $submittedName!",
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Bold,
                            color = Navy
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Your name has ${submittedName.length} letters.",
                            color = Color.Gray
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(18.dp))
                                .background(AndroidGreen.copy(alpha = 0.15f))
                                .padding(horizontal = 12.dp, vertical = 6.dp)
                        ) {
                            Text(
                                text = "CSC 402 - Lab 2",
                                color = Color(0xFF168A52),
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingScreenPreview() {
    GreetingScreen()
}