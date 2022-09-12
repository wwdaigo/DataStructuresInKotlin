package linkedlist

interface LinkedList<T> : Iterable<T> {
	val size: Int
	val peekFirst: T?
	val peekLast: T?

	fun addFirst(data: T)
	fun addLast(data: T)
	fun add(at: Int, data: T)

	fun removeFirst(): T?
	fun removeLast(): T?
	fun remove(at: Int): T?

	fun clear()

	fun contains(value: T): Int
	operator fun get(index: Int): T?

	fun reverse()

	override fun toString(): String
}