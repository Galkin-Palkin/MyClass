import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle

@Immutable
data class ThemeTypography(
    val h2: TextStyle,
    val h3: TextStyle,
    val h4: TextStyle,
    val h5: TextStyle,
    val default: TextStyle,
    val button: TextStyle,
    val menuText: TextStyle,
    val selectedMenuText: TextStyle,
    val inputFieldInnerText: TextStyle,
    val inputFieldHeader: TextStyle,
    val dropDownMenuText: TextStyle,
)