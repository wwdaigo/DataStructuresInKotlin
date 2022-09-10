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

	operator fun get(index: Int): T?

	fun reverse()

	fun sort()
	fun sorted(): LinkedList<T>
	fun sortDescending()
	fun sortedDescending(): LinkedList<T>

	override fun toString(): String
}