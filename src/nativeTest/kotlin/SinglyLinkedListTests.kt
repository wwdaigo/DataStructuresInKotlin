import linkedlist.*
import kotlin.test.*

class SinglyLinkedListTests {
	@Test
	fun `Create an empty singly linked list of integer type`() {
		val singlyLinkedList: LinkedList<Int> = SinglyLinkedList()

		assertEquals(0, singlyLinkedList.size)
		assertNull(singlyLinkedList.peekFirst)
		assertNull(singlyLinkedList.peekLast)
	}

	@Test
	fun `Add characters from the front and back`() {
		val singlyLinkedList: LinkedList<Char> = SinglyLinkedList()

		with(singlyLinkedList) {
			addFirst('A')
			addFirst('N')
			addFirst('A')
			addFirst('B')

			addLast('N')
			addLast('A')
		}

		assertEquals(6, singlyLinkedList.size)
		assertEquals('B', singlyLinkedList.peekFirst)
		assertEquals('A', singlyLinkedList.peekLast)
		assertEquals("[B, A, N, A, N, A]", singlyLinkedList.toString())
	}

	@Test
	fun `Add element at 3rd position 0 indexed in a 5 elements linked list`() {
		val singlyLinkedList: LinkedList<Int> = SinglyLinkedList()
		repeat(5) { singlyLinkedList.addLast(it + 1) }
		singlyLinkedList.add(3, 10)

		assertEquals(6, singlyLinkedList.size)
		assertEquals(1, singlyLinkedList.peekFirst)
		assertEquals(5, singlyLinkedList.peekLast)
		assertEquals(10, singlyLinkedList[3])
	}

	@Test
	fun `Add element at 5th position in a 2 elements linked list`() {
		val singlyLinkedList: LinkedList<Int> = SinglyLinkedList()
		repeat(2) { singlyLinkedList.addLast(it + 1) }
		assertFailsWith(IndexOutOfBoundsException::class) {
			singlyLinkedList.add(5, 10)
		}
	}

	@Test
	fun `Remove the items from the front`() {
		val singlyLinkedList: LinkedList<Int> = SinglyLinkedList()
		repeat(5) {
			singlyLinkedList.addLast(it + 1)
		}

		val first = singlyLinkedList.removeFirst()
		val second = singlyLinkedList.removeFirst()

		assertEquals(3, singlyLinkedList.size)
		assertEquals(1, first)
		assertEquals(2, second)
		assertEquals(3, singlyLinkedList.peekFirst)
		assertEquals(5, singlyLinkedList.peekLast)
	}

	@Test
	fun `Remove the items from the back`() {
		val singlyLinkedList: LinkedList<Int> = SinglyLinkedList()
		repeat(5) {
			singlyLinkedList.addLast(it + 1)
		}

		val last = singlyLinkedList.removeLast()
		val prevLast = singlyLinkedList.removeLast()

		assertEquals(3, singlyLinkedList.size)
		assertEquals(5, last)
		assertEquals(4, prevLast)
		assertEquals(1, singlyLinkedList.peekFirst)
		assertEquals(3, singlyLinkedList.peekLast)
	}

	@Test
	fun `Get the 3rd value from a 5 items list`() {
		val singlyLinkedList: LinkedList<Int> = SinglyLinkedList()
		repeat(5) {
			singlyLinkedList.addLast(it + 1)
		}

		val third = singlyLinkedList[2]
		assertEquals(5, singlyLinkedList.size)
		assertEquals(3, third)
	}

	@Test
	fun `Get the 10th value from a 5 items list`() {
		val singlyLinkedList: LinkedList<Int> = SinglyLinkedList()
		repeat(5) {
			singlyLinkedList.addLast(it + 1)
		}

		val tenth = singlyLinkedList[10]
		assertEquals(5, singlyLinkedList.size)
		assertNull(tenth)
	}

	@Test
	fun `Clear the list`() {
		val singlyLinkedList: LinkedList<Int> = SinglyLinkedList()
		repeat(10) {
			singlyLinkedList.addLast(it + 1)
		}

		singlyLinkedList.clear()
		assertEquals(0, singlyLinkedList.size)
		assertNull(singlyLinkedList.peekFirst)
		assertNull(singlyLinkedList.peekLast)
	}

	@Test
	fun `Remove all elements from the front`() {
		val singlyLinkedList: LinkedList<Int> = SinglyLinkedList()
		repeat(10) {
			singlyLinkedList.addLast(it + 1)
		}
		repeat(10) {
			singlyLinkedList.removeFirst()
		}

		assertEquals(0, singlyLinkedList.size)
		assertNull(singlyLinkedList.peekFirst)
		assertNull(singlyLinkedList.peekLast)
	}

	@Test
	fun `Remove all elements from the back`() {
		val singlyLinkedList: LinkedList<Int> = SinglyLinkedList()
		repeat(10) {
			singlyLinkedList.addLast(it + 1)
		}
		repeat(10) {
			singlyLinkedList.removeLast()
		}

		assertEquals(0, singlyLinkedList.size)
		assertNull(singlyLinkedList.peekFirst)
		assertNull(singlyLinkedList.peekLast)
	}

	@Test
	fun `Remove the first element with remove at`() {
		val singlyLinkedList: LinkedList<Int> = SinglyLinkedList()
		repeat(10) {
			singlyLinkedList.addLast(it + 1)
		}

		val removed = singlyLinkedList.remove(0)

		assertEquals(9, singlyLinkedList.size)
		assertEquals(2, singlyLinkedList.peekFirst)
		assertEquals(10, singlyLinkedList.peekLast)
		assertEquals(1, removed)
	}

	@Test
	fun `Remove the 2nd index element with remove at`() {
		val singlyLinkedList: LinkedList<Int> = SinglyLinkedList()
		repeat(4) {
			singlyLinkedList.addLast(it + 1)
		}

		val removed = singlyLinkedList.remove(2)

		assertEquals(3, singlyLinkedList.size)
		assertEquals(1, singlyLinkedList.peekFirst)
		assertEquals(4, singlyLinkedList.peekLast)
		assertEquals(3, removed)
	}

	@Test
	fun `Remove 10th element in a list with 4 items`() {
		val singlyLinkedList: LinkedList<Int> = SinglyLinkedList()
		repeat(4) {
			singlyLinkedList.addLast(it + 1)
		}

		val removed = singlyLinkedList.remove(10)

		assertEquals(4, singlyLinkedList.size)
		assertEquals(1, singlyLinkedList.peekFirst)
		assertEquals(4, singlyLinkedList.peekLast)
		assertNull(removed)
	}

	@Test
	fun `Copy a linked list`() {
		val list = singlyLinkedListOf(1, 2, 3, 4, 5)
		val copy = list.copy()

		assertEquals(list.size, copy.size)
		assertEquals(list.toString(), copy.toString())
		assertFalse { list.headNode === copy.headNode }
	}

	@Test
	fun `Try to find an item in an empty linked list`() {
		val list = singlyLinkedListOf<Int>()
		val pos = list.contains(5)

		assertEquals(pos, -1)
	}

	@Test
	fun `Try to find an existing item in a linked list`() {
		val list = singlyLinkedListOf(1, 3, 5, 7)
		val pos = list.contains(5)

		assertEquals(pos, 2)
	}

	@Test
	fun `Try to find a non-existing item in a linked list`() {
		val list = singlyLinkedListOf(2, 4, 6, 8)
		val pos = list.contains(5)

		assertEquals(pos, -1)
	}

	@Test
	fun `Try to find a repeated item in a linked list`() {
		val list = singlyLinkedListOf(2, 4, 6, 8, 2, 4, 6, 8)
		val pos = list.contains(6)

		assertEquals(pos, 2)
	}

	@Test
	fun `Reverse an integer list`() {
		val list = singlyLinkedListOf(1, 2, 3, 4)
		list.reverse()
		val expected = "[4, 3, 2, 1]"

		assertEquals(expected, list.toString())
	}

	@Test
	fun `Sort an integer list`() {
		val list = singlyLinkedListOf(4, 2, 1, 3)
		val sorted = list.sorted()

		val expected = "[1, 2, 3, 4]"
		assertEquals(expected, sorted.toString())
	}

	@Test
	fun `Sort descending an integer list and return the sorted list`() {
		val list = singlyLinkedListOf(4, 2, 1, 3)
		val sorted = list.sortedDesc()

		println(sorted.toString())
		val expected = "[4, 3, 2, 1]"
		assertEquals(expected, sorted.toString())
	}
}