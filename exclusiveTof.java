// TC : O(n)
// SC : O(n)
// Ran on LC : Yes
// Problems : None.

class Solution {
	public int[] exclusiveTime(int n, List<String> logs) {
		 int[] res = new int[n];
		 Stack<Integer> stack = new Stack<>();
		 int prevTime = 0;
		 for (String log : logs) {
			  String[] parts = log.split(":");
			  if (!stack.isEmpty()) 
					res[stack.peek()] +=  Integer.parseInt(parts[2]) - prevTime; 
			  prevTime = Integer.parseInt(parts[2]);
			  if (parts[1].equals("start")) 
					stack.push(Integer.parseInt(parts[0]));
			  else {
					res[stack.pop()]++;
					prevTime++;
			  }
		 }
		 return res;
	}
}