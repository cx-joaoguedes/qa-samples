fun main(args: Array<String>) {
    

    val input = readLine()!! // Malicious regex (\a+)+ could be input
    val releaseText = input
	val versionRegex = Regex("dd")

    for (i in 0..20) {
        val answer = versionRegex.matchesAt(releaseText, i) // This should 
        if (answer) println("$i: ${versionRegex.matchAt(releaseText, i)?.value}")
		if (answer) println("$i: ${versionRegex.containsMatchIn(releaseText, i)?.value}")
		if (answer) println("$i: ${versionRegex.find(releaseText, i)?.value}")
		if (answer) println("$i: ${versionRegex.findAll(releaseText, i)?.value}")
		if (answer) println("$i: ${versionRegex.matches(releaseText, i)?.value}")
		if (answer) println("$i: ${versionRegex.matchEntire(releaseText, i)?.value}")
		if (answer) println("$i: ${versionRegex.replace(releaseText, i)?.value}")
		if (answer) println("$i: ${versionRegex.replaceFirst(releaseText, i)?.value}")
		if (answer) println("$i: ${versionRegex.split(releaseText, i)?.value}")
		if (answer) println("$i: ${versionRegex.splitToSequence(releaseText, i)?.value}")
    }
}