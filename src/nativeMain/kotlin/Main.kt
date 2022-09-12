import linkedlist.DoublyLinkedList
import linkedlist.singlyLinkedListOf

fun main() {
	val doubly = DoublyLinkedList<Int>()
	doubly.addFirst(1)
	doubly.addFirst(3)
	doubly.addLast(10)


	val ll = singlyLinkedListOf(5, 3, 1, 5 , 6, 8)
	val co = ll.copy()
	println(co.sorted())
/*
	var t = doubly.headNode
	while (t?.next != null) {
		println(t.value)
		t = t.next
	}
	while (t != null) {
		println(t.value)
		t = t.prev
	}
*/
}

