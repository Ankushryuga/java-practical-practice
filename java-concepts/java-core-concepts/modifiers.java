/***
Java supports access modifiers to provide different restriction levels in different program parts in other words,
access modifiers control which code sections can invoke the name of a class.
*/

// In general, the table translates to:

/**

  Access Modifier	    Within Class    	Within Subclass    	Within package    	Outside Package
      Private          	Visible	          Not Visible        	Not Visible	        Not Visible
      [Default]        	Visible          	Not Visible          	Visible          	Not Visible
      Protected        	Visible            	Visible            	Visible          	Not Visible
      Public          	Visible            	Visible            	Visible            	Visible


  */
