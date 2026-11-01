package com.ael.diverto.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ael.diverto.R
import com.ael.diverto.ui.theme.GlassBorder
import com.ael.diverto.ui.theme.GlassWhite
import com.ael.diverto.ui.theme.PrimaryAmber
import com.ael.diverto.ui.theme.TextPrimary
import com.ael.diverto.ui.theme.TextSecondary

@Composable
fun AppHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Kiri: Logo + Title Diverto
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f, fill = false)
        ) {
            Image(
                painter = painterResource(id = R.drawable.divertologo),
                contentDescription = "Diverto Logo",
                modifier = Modifier.size(36.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = "Diverto",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = TextPrimary
                )
                Text(
                    text = "Smart Solar Diverter",
                    fontSize = 10.sp,
                    color = TextSecondary
                )
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Kanan: Badge Cuaca Ringkas (Tidak tabrakan)
        Box(
            modifier = Modifier
                .background(GlassWhite, RoundedCornerShape(14.dp))
                .border(1.dp, GlassBorder, RoundedCornerShape(14.dp))
                .padding(horizontal = 10.dp, vertical = 6.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(text = "☀️", fontSize = 14.sp)
                Column {
                    Text(
                        text = "32°C Cerah",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                    Text(
                        text = "Bandung",
                        fontSize = 9.sp,
                        color = PrimaryAmber,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}