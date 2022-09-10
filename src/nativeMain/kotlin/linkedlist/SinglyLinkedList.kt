package linkedlist

class SinglyLinkedList<T> : LinkedList<T> {
	private var count = 0

	private var head: Node<T>? = null
	private var tail: Node<T>? = null

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

	override fun get(index: Int): T? {
		return if (index < size) {
			var t = head
			repeat(index) { t = t?.next }
			t?.value
		} else {
			null
		}
	}

	override fun reverse() {
		TODO("Not yet implemented")
	}

	override fun sort() {
		TODO("Not yet implemented")
	}

	override fun sorted(): LinkedList<T> {
		TODO("Not yet implemented")
	}

	override fun sortDescending() {
		TODO("Not yet implemented")
	}

	override fun sortedDescending(): LinkedList<T> {
		TODO("Not yet implemented")
	}

	override fun toString(): String {
		var t = head
		val sb = StringBuilder()
		while (t != null) {
			sb.append(t.value)
			t.next?.let { sb.append(", ") }

			t = t.next
		}

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