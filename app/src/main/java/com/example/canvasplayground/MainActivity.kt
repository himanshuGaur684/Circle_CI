package com.example.canvasplayground

import android.graphics.Typeface
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.vector.Path
import androidx.compose.ui.graphics.vector.VectorProperty
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.canvasplayground.ui.theme.CanvasPlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CanvasPlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CustomUi()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CustomUi() {
    Canvas(modifier = Modifier
        .size(200.dp)
        .border(width = 2.dp, color = Color.DarkGray), onDraw = {
        drawLine(
            strokeWidth = 10.dp.toPx(),
            start = Offset(x = 0.dp.toPx(), y = 20.dp.toPx()),
            end = Offset(x = 100.dp.toPx(), y = 200.dp.toPx()),
            color = Color.Red
        )
    })
}

@Preview(showBackground = true)
@Composable
fun CustomUiArc() {
    Canvas(modifier = Modifier
        .size(200.dp)
        .border(width = 2.dp, color = Color.DarkGray), onDraw = {
        drawArc(
            color = Color.Red,
            startAngle = 30f,
            sweepAngle = 100f,
            useCenter = true,
//            topLeft = Offset(x=10.dp.toPx(),y=-50.dp.toPx()),
            size = Size(width = 50.dp.toPx(), height = 50.dp.toPx())
        )
    })
}

@Preview(showBackground = true)
@Composable
fun CustomUiCircle() {
    Canvas(modifier = Modifier
        .padding(4.dp)
        .size(200.dp)
        .border(width = 2.dp, color = Color.DarkGray), onDraw = {
        drawCircle(
            brush = Brush.verticalGradient(
                listOf(
                    Color.Red,
                    Color.Yellow,
                    Color.Green
                )
            ),
            radius = 20.dp.toPx(),
            center = Offset(x = 100.dp.toPx(), y = 80.dp.toPx()),
            style = Stroke(width = 20.dp.toPx())
        )
    })
}

@Preview(showBackground = true)
@Composable
fun CustomUiPath() {
    val textPaint = Paint().asFrameworkPaint().apply {
        isAntiAlias = true
        textSize = 24f
        color = android.graphics.Color.BLUE
        typeface = Typeface.create(Typeface.MONOSPACE, Typeface.BOLD)
    }
    Canvas(modifier = Modifier
        .padding(4.dp)
        .size(200.dp)
        .border(width = 2.dp, color = Color.DarkGray), onDraw = {

        drawIntoCanvas {
            it.nativeCanvas.drawText(
                "THis is Himanshu",
                0.dp.toPx(),
                20.dp.toPx(),
                textPaint
            )
        }
    })
}

@Preview(showBackground = true)
@Composable
fun DrawTriangle() {

    Canvas(modifier = Modifier.size(200.dp)) {

        drawCircle(
            color = Color.Black,
            style = Stroke(width = 4.dp.toPx())
        )
       drawCircle(
           color = Color.Black,
           radius = 10.dp.toPx(),
           center = Offset(x=50.dp.toPx(),y=55.dp.toPx())
       )
        drawCircle(
            color = Color.Black,
            radius = 10.dp.toPx(),
            center = Offset(x=150.dp.toPx(),y=55.dp.toPx())
        )
        drawRect(
            color = Color.Red,
            size = Size(width = 24.dp.toPx(), height = 24.dp.toPx()),
            topLeft = Offset(x=88.dp.toPx(),y=85.dp.toPx())
        )
        drawArc(
            color = Color.Red,
            startAngle = 0f,
            sweepAngle = 180f,
            useCenter = false,
            size = Size(width = 50.dp.toPx(), height = 50.dp.toPx()),
            topLeft = Offset(x=75.dp.toPx(),y=120.dp.toPx())
        )

    }
}
