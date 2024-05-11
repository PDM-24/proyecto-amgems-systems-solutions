import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alvarado.backpack.ui.components.report.ReportInfo
import com.alvarado.backpack.ui.components.report.ReportReasons

@Composable
fun ReportScreen() {
    // report variables
    val cycleInfo: MutableState<String> = remember { mutableStateOf("") }
    val dateInfo: MutableState<String> = remember { mutableStateOf("") }
    val titleInfo: MutableState<String> = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // info of report document
        ReportInfo(
            documentCycle = cycleInfo.value,
            documentDate = dateInfo.value,
            documentTitle = titleInfo.value
        )

        // list
        ReportReasons()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ReportScreenPreview() {
    ReportScreen()
}