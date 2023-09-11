import java.io.File
import java.nio.file.FileVisitResult
import java.nio.file.Path
import kotlin.io.path.ExperimentalPathApi
import kotlin.io.path.Path
import kotlin.io.path.fileVisitor
import kotlin.io.path.visitFileTree

@OptIn(ExperimentalPathApi::class)
fun main(args: Array<String>) {
    val cleanVisitor = fileVisitor {
        onPreVisitDirectory { directory, attributes ->
            // the 'directory' variable is an existing file path and 
            // could contain dangerous characters to certain vulnerabilities
            println("onPreVisitDirectory:\t" + directory)
            FileVisitResult.CONTINUE
        }

        onVisitFile { file, attributes ->
            // 'file' parameter has the stored file name and contents of the selected file
            // it should be considered stored input
            println("onVisitFile:\t\t\t" + file.fileName)
            FileVisitResult.CONTINUE
        }
    }

    Path("src/test/resources").visitFileTree(cleanVisitor)
}

@OptIn(ExperimentalPathApi::class)
fun main2(args: Array<String>) {
    File("src/test/resources")
        .walk(FileWalkDirection.BOTTOM_UP)
        .sortedBy { it.isDirectory }
        .forEach { println(it) } // 'it' is a stored input

    val directory = File("/path/to/directory")

    directory.walk().forEach { file ->
        println(file.absolutePath)
    }
}

fun main3() {
    val source = File("path/to/source/directory")
    val destination = File("path/to/destination/directory")

    source.copyToRecursively(destination)

    Path("path").copyToRecursively(
        target = Path.of("some-other-directory"),
        followLinks = false,
        copyAction = { source, target ->
            when {
                source.name.contains("_dont-copy-me") -> CopyActionResult.SKIP_SUBTREE
                source.name.contains("oops-this-is-bad") -> CopyActionResult.TERMINATE
                else -> CopyActionResult.CONTINUE
            }
        }
    )
}
