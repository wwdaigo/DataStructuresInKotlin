package linkedlist

class SinglyLinkedList<T>(firstNode: Node<T>? = null) : LinkedList<T> {
	private var count = 0
	private var head: Node<T>? = firstNode
	private var tail: Node<T>? = firstNode

	val headNode: Node<T>? get() = head

	override val size: Int
		get() = count

	override val peekFirst: T?
		get() = head?.value

	override val peekLast: T?
		get() = tail?.value

	override fun addFirst(data: T) {
		head?.let {
			head = Node(data, it)
		} ?: run {
			initialiseNodes(data)
		}

		count++
	}

	override fun addLast(data: T) {
		tail?.let {
			it.next = Node(data)
			tail = it.next
		} ?: run {
			initialiseNodes(data)
		}

		count++
	}

	override fun add(at: Int, data: T) {
		if (at > size) throw IndexOutOfBoundsException()
		if (at == 0) {
			addFirst(data)
		} else {
			var t = head
			repeat(at - 1) {
				t = t?.next
			}
			t?.next = Node(data, t?.next)
		}

		count++
	}

	private fun initialiseNodes(data: T) {
		Node(data).also {
			head = it
			tail = it
		}
	}

	override fun removeFirst(): T? {
		if (size == 1) clear()

		return head?.let {
			val value = it.value

			head = it.next
			count --
			value
		}
	}

	// O(n)
	override fun removeLast(): T? {
		if (size == 1) clear()

		return tail?.let {
			val value = it.value

			var t = head
			while (t?.next !== tail) {
				t = t?.next
			}
			t?.next = t?.next?.next
			tail = t

			count--
			value
		}
	}

	override fun remove(at: Int): T? {
		if (at > size) return null

		return when (at) {
			0 -> removeFirst()
			size - 1 -> removeLast()
			else -> {
				var t = head
				repeat(at - 1) { t = t?.next }
				val next = t?.next
				t?.next = t?.next?.next
				count --

				next?.value
			}
		}
	}

	override fun clear() {
		count = 0
		head = null
		tail = null
	}

	override fun contains(value: T): Int {
		var c = 0
		var t = head
		while (t != null) {
			if (t.value == value) return c
			c++
			t = t.next
		}
		return -1
	}

	override fun get(index: Int): T? {
		return if (index < size) {
			var t = head
			repeat(index) { t = t?.next }
			t?.value
		} else {
			null
		}
	}

	fun copy() = SinglyLinkedList<T>().also { list ->
		forEach { list.addLast(it) }
	}

	override fun reverse() {
		tail = head

		var prev: Node<T>? = null
		var next: Node<T>?
		var current = head

		while (current != null) {
			next = current.next
			current.next = prev
			prev = current
			current = next
		}

		head = prev
	}

	override fun toString(): String {
		var t = head
		val sb = StringBuilder()
		sb.append('[')
		while (t != null) {
			sb.append(t.value)
			t.next?.let { sb.append(", ") }

			t = t.next
		}
		sb.append(']')

		return sb.toString()
	}

	override fun iterator(): Iterator<T> {
		return LinkedListIterator(head)
	}

	private class LinkedListIterator<T>(head: Node<T>?) : Iterator<T> {
		private var t: Node<T>? = head

		override fun next(): T {
			val value = t!!.value
			t = t?.next
			return value
		}

		override fun hasNext(): Boolean {
			return t != null
		}
	}

	data class Node<T>(
		val value: T,
		var next: Node<T>? = null
	)
}

fun <T> singlyLinkedListOf(vararg items: T) = SinglyLinkedList<T>().apply {
	items.forEach { addLast(it) }
}

/*
* Sorting algorithm
* */

fun <T: Comparable<T>> SinglyLinkedList<T>.sorted(): SinglyLinkedList<T> {
	val newHead = mergeSort(headNode) { a, b ->
		when {
			a == b -> 0
			a < b -> 1
			else -> -1
		}
	}

	return SinglyLinkedList(newHead)
}

fun <T: Comparable<T>> SinglyLinkedList<T>.sortedDesc(): SinglyLinkedList<T> {
	val newHead = mergeSort(headNode) { a, b ->
		when {
			a == b -> 0
			a > b -> 1
			else -> -1
		}
	}

	return SinglyLinkedList(newHead)
}
private fun <T : Comparable<T>> mergeSort(
	node: SinglyLinkedList.Node<T>?,
	comparator: Comparator<T>
): SinglyLinkedList.Node<T>? {
	if (node?.next == null) return node
	var slow = node
	var fast = node

	while (fast?.next != null) {
		slow = slow?.next
		fast = fast.next?.next
	}
	var prevSlow = node
	while (prevSlow?.next !== slow) { prevSlow = prevSlow?.next }
	prevSlow?.next = null

	val left = mergeSort(node, comparator)
	val right = mergeSort(slow, comparator)

	return merge(left, right, comparator)
}

private fun <T : Comparable<T>> merge(
	left: SinglyLinkedList.Node<T>?,
	right: SinglyLinkedList.Node<T>?,
	comparator: Comparator<T>
): SinglyLinkedList.Node<T>? {
	if (left == null && right == null) return null
	val newLL = SinglyLinkedList(left ?: right).copy()
	val dummy = newLL.headNode
	var dummyTail: SinglyLinkedList.Node<T>? = dummy

	var tLeft = left
	var tRight = right

	while (tLeft != null && tRight != null) {
		if (comparator.compare(tLeft.value, tRight.value) == 1) {
			dummyTail?.next = tLeft
			tLeft = tLeft.next
		} else {
			dummyTail?.next = tRight
			tRight = tRight.next
		}
		dummyTail = dummyTail?.next
	}
	dummyTail?.next = tRight ?: tLeft

	return dummy?.next
}