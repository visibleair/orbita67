import androidx.compose.runtime.Composable
import com.example.orbita67.R
import com.example.orbita67.ui.home.hometabs.BooksScreen
import com.example.orbita67.ui.home.hometabs.MoviesScreen
import com.example.orbita67.ui.home.hometabs.MusicScreen

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(var icon: Int, var title: String, var screen: ComposableFun) {
    object Music : TabItem(R.drawable.ic_search, "Music", { MusicScreen() })
    object Movies : TabItem(R.drawable.ic_search, "Movies", { MoviesScreen() })
    object Books : TabItem(R.drawable.ic_search, "Books", { BooksScreen() })
}