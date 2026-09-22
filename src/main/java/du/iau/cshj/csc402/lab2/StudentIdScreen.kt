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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import du.iau.cshj.csc402.lab2.ui.theme.AndroidGreen
import du.iau.cshj.csc402.lab2.ui.theme.Navy
import du.iau.cshj.csc402.lab2.ui.theme.ScreenBackground

@Composable
fun StudentIdScreen() {
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
                text = "Student ID",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Task 7 - Row & Column",
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
            modifier = Modifier.padding(22.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Row(
                    modifier = Modifier.padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(72.dp)
                            .clip(CircleShape)
                            .background(Navy),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "AA",
                            color = AndroidGreen,
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.size(16.dp))

                    Column {
                        Text(
                            text = "Aljury Aldossary",
                            fontWeight = FontWeight.Bold,
                            fontSize = 19.sp,
                            color = Navy
                        )

                        Text(
                            text = "CS",
                            color = Color.Gray
                        )

                        Text(
                            text = "2240007265",
                            color = Color.Gray,
                            fontFamily = FontFamily.Monospace
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Row {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(18.dp))
                                    .background(AndroidGreen.copy(alpha = 0.15f))
                                    .padding(horizontal = 10.dp, vertical = 5.dp)
                            ) {
                                Text(
                                    text = "Level 4",
                                    color = Color(0xFF168A52),
                                    fontWeight = FontWeight.Bold
                                )
                            }

                            Spacer(modifier = Modifier.size(8.dp))

                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(18.dp))
                                    .background(Color.LightGray.copy(alpha = 0.4f))
                                    .padding(horizontal = 10.dp, vertical = 5.dp)
                            ) {
                                Text(
                                    text = "CSHJ",
                                    color = Color.DarkGray,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            HorizontalDivider()

            Spacer(modifier = Modifier.height(10.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    StatItem("4.42", "GPA")
                    StatItem("78", "Credits")
                    StatItem("Active", "Status")
                }
            }
        }
    }
}

@Composable
fun StatItem(value: String, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            fontWeight = FontWeight.Bold,
            fontSize = 19.sp,
            color = Navy
        )

        Text(
            text = label,
            color = Color.Gray,
            fontSize = 12.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun StudentIdScreenPreview() {
    StudentIdScreen()
}
