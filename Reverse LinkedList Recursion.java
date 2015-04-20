public ListNode Reverse(ListNode head) { 
	if (head == null) return null; 
	if (head.next == null) return head; 
	// so we grab the second element (which will be the last after we reverse it) 
	ListNode post = head.next; 
	// bug fix - need to unlink list from the rest or you will get a cycle     
	head.next = null; // then we reverse everything from the second element on 
	ListNode newHead = Reverse(post); // then we join the two lists
	post.next = head; 
	return newHead; 
}