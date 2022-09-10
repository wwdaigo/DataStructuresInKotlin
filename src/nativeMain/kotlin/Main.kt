import linkedlist.SinglyLinkedList
import linkedlist.singlyLinkedListOf

fun main() {
	val singlyLinkedList = SinglyLinkedList<Int>()
	repeat(5) { singlyLinkedList.addLast(it + 1) }
	println(singlyLinkedList.removeLast())
	println(singlyLinkedList.toString())

	val list2 = singlyLinkedListOf(1, 5, 6)

	println(singlyLinkedList.headNode)
	println(list2.toString())
}