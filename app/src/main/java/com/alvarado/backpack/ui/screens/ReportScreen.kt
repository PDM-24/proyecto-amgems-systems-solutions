import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ReportScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // info of report document
        Box(){

        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ReportScreenPreview() {
    ReportScreen()
}