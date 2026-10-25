package pe.edu.upc.recipeapp.core.designsystems

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

@Suppress("CheckReturnValue")
val book: ImageVector
    get() {
        if (_book != null) {
            return _book!!
        }
        _book =
            ImageVector.Builder(
                name = "book",
                defaultWidth = 24.dp,
                defaultHeight = 24.dp,
                viewportWidth = 24f,
                viewportHeight = 24f,
            )
                .apply {
                    path(
                        fill = SolidColor(Color.Black),
                        fillAlpha = 1f,
                        stroke = null,
                        strokeAlpha = 1f,
                        strokeLineWidth = 1f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Bevel,
                        strokeLineMiter = 1f,
                        pathFillType = PathFillType.NonZero,
                    ) {
                        moveTo(6f, 22f)
                        quadToRelative(-0.825f, 0f, -1.412f, -0.587f)
                        reflectiveQuadTo(4f, 20f)
                        verticalLineTo(4f)
                        quadToRelative(0f, -0.825f, 0.588f, -1.412f)
                        reflectiveQuadTo(6f, 2f)
                        horizontalLineToRelative(12f)
                        quadToRelative(0.825f, 0f, 1.413f, 0.588f)
                        reflectiveQuadTo(20f, 4f)
                        verticalLineToRelative(16f)
                        quadToRelative(0f, 0.825f, -0.587f, 1.413f)
                        reflectiveQuadTo(18f, 22f)
                        close()
                        moveTo(11f, 11f)
                        lineToRelative(2.5f, -1.5f)
                        lineTo(16f, 11f)
                        verticalLineTo(4f)
                        horizontalLineToRelative(-5f)
                        close()
                    }
                }
                .build()
        return _book!!
    }

private var _book: ImageVector? = null


@Suppress("CheckReturnValue")
val bookmark: ImageVector
    get() {
        if (_bookmark != null) {
            return _bookmark!!
        }
        _bookmark =
            ImageVector.Builder(
                name = "bookmark",
                defaultWidth = 24.dp,
                defaultHeight = 24.dp,
                viewportWidth = 24f,
                viewportHeight = 24f,
            )
                .apply {
                    path(
                        fill = SolidColor(Color.Black),
                        fillAlpha = 1f,
                        stroke = null,
                        strokeAlpha = 1f,
                        strokeLineWidth = 1f,
                        strokeLineCap = StrokeCap.Butt,
                        strokeLineJoin = StrokeJoin.Bevel,
                        strokeLineMiter = 1f,
                        pathFillType = PathFillType.NonZero,
                    ) {
                        moveTo(5f, 21f)
                        verticalLineTo(5f)
                        quadToRelative(0f, -0.825f, 0.588f, -1.413f)
                        reflectiveQuadTo(7f, 3f)
                        horizontalLineToRelative(10f)
                        quadToRelative(0.825f, 0f, 1.413f, 0.588f)
                        reflectiveQuadTo(19f, 5f)
                        verticalLineToRelative(16f)
                        lineToRelative(-7f, -3f)
                        close()
                    }
                }
                .build()
        return _bookmark!!
    }

private var _bookmark: ImageVector? = null
