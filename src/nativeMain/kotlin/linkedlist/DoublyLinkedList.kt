package linkedlist

class DoublyLinkedList<T> : LinkedList<T> {
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
			val node = Node(data)
			node.next = it
			it.prev = node
			head = node
		} ?: run {
			initialiseNodes(data)
		}
	}

	override fun addLast(data: T) {
		tail?.let {
			val node = Node(data)
			it.next = node
			node.prev = it
			tail = node
		} ?: run {
			initialiseNodes(data)
		}
	}

	private fun initialiseNodes(data: T) {
		Node(data).also {
			head = it
			tail = it
		}
	}

	override fun contains(value: T): Int {
		TODO("Not yet implemented")
	}

	override fun add(at: Int, data: T) {
		TODO("Not yet implemented")
	}

	override fun removeFirst(): T? {
		TODO("Not yet implemented")
	}

	override fun removeLast(): T? {
		TODO("Not yet implemented")
	}

	override fun remove(at: Int): T? {
		TODO("Not yet implemented")
	}

	override fun clear() {
		TODO("Not yet implemented")
	}

	override fun get(index: Int): T? {
		TODO("Not yet implemented")
	}

	fun copy(): LinkedList<T> {
		TODO("Not yet implemented")
	}

	override fun reverse() {
		TODO("Not yet implemented")
	}

	override fun toString(): String {
		TODO("Not yet implemented")
	}

	override fun iterator(): Iterator<T> {
		TODO("Not yet implemented")
	}

	class Node<T>(
		val value: T,
		var prev: Node<T>? = null,
		var next: Node<T>? = null
	)
}