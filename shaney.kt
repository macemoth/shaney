// Based on the program presented in the "Design and Implementation" chapter
// of The Practice of Programming (Kernighan and Pike, Addison-Wesley 1999).
// See also Computer Recreations, Scientific American 260, 122 - 125 (1989).

import java.io.File
import kotlin.system.exitProcess

class Prefix() {

    var content = arrayOf<String>("", "")

    override fun toString(): String {
        return content.joinToString(" ")
    }

    fun shift(word: String) {
        content[0] = content[1]
        content[1] = word
    }
}

class Chain() {
    val chain = mutableMapOf<String, ArrayList<String>>()

    fun build(text: String) {
        val words = text.split(" ", "\n")
        val p = Prefix()
        var key: String
        for (w in words) {
            key = p.toString()
            chain.getOrPut(key) { arrayListOf() }.add(w)
            p.shift(w)
        }
    }

    fun generate(length: Int): String {
        val p = Prefix()
        val words = arrayListOf<String>()
        var choices: ArrayList<String>
        var next: String
        for (i in 0 until length) {
            if (p.toString() in chain.keys) {
                choices = chain[p.toString()]!!
                if (choices.size == 0) break
            } else break
            next = choices.random()
            words.add(next)
            p.shift(next)
        }
        return words.joinToString(" ")
    }
}

fun main(args: Array<String>) {
    if (args.size != 2) {
        println("Mark V. Shaney")
        print("Synopsis shaney <num words to generate> <input>.txt")
        exitProcess(2)
    }
    val file = File(args[1])
    if (!file.exists()) {
        println("File ${file.name} does not exist")
        exitProcess(2)
    }
    val c = Chain()
    c.build(file.readText())
    val text = c.generate(args[0].toInt())
    println(text)
}