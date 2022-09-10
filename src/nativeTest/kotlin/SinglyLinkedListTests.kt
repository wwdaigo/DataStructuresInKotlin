import linkedlist.LinkedList
import linkedlist.SinglyLinkedList
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNull

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
		assertEquals("B, A, N, A, N, A", singlyLinkedList.toString())
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
	fun `Reverse an empty list`() {

	}

	@Test
	fun `Reverse an integer list`() {

	}

	@Test
	fun `Sort an empty list in place`() {

	}

	@Test
	fun `Sort an integer list and return the sorted list`() {

	}

	@Test
	fun `Sort descending an empty list in place`() {

	}

	@Test
	fun `Sort descending an integer list and return the sorted list`() {

	}
}