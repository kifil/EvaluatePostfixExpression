public class Solution {
	public int evalRPN(ArrayList<String> a) {
	    Stack<Integer> valueStack = new Stack<>();
	    
	    if(a.size() == 0){
	        return 0;
	    }
	    
	    for(String item : a){
	        Integer numericValue = null;
	        
	        try{
	            numericValue = Integer.parseInt(item);
	        }
	        catch(Exception e){
	            // numeric val is null
	        }
	        
	        //if item is an Int, then push
	        if(numericValue!= null){
	            valueStack.add(numericValue);
	        }
	        //otherwise it is an operator
	        else{
	            //pop last 2, do operation, push result and continue
	            Integer firstVal = valueStack.pop();
	            Integer secondVal = valueStack.pop();
	            Integer newVal = 0;
	            
	            switch(item){
	                case "+":
	                    newVal = secondVal + firstVal;
	                    break;
                    case "-":
	                    newVal = secondVal - firstVal;
                        break;
                    case "*":
	                    newVal = secondVal * firstVal;
                        break;
                    case "/":
	                    newVal = secondVal / firstVal;
                        break;
	            
	            }
	            valueStack.add(newVal);
	        }
	    }
	    
	    //result will be the only thing on the stack
	    return valueStack.pop();
	}
}
