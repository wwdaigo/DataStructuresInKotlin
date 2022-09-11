import linkedlist.singlyLinkedListOf

fun main() {
	val list2 = singlyLinkedListOf(6, 7, 1, 3)
	val so = list2.sorted()
	val so2 = list2.sortedDescending()

	println(list2.toString())
	println(so.toString())
	println(so2.toString())
}