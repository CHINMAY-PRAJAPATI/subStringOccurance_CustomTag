package com.example.myTagHandlerClasses;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SubStringOccuranceTagHandlerClass extends SimpleTagSupport{
		
		private String subStringOccurance="";
		
			public void setSubStringOccurance(String subStringOccurance) {
			this.subStringOccurance = subStringOccurance;
		}


		public void doTag() throws JspException, IOException {
			JspWriter out = getJspContext().getOut();
			try{	
				String[] sample = subStringOccurance.split(" ");
						
				int i;	    // variables used in for loop
				int j;	    // variables used in for loop 
				int is=0;   // is is used to count the occurance of varialble 'is'
				int the=0;  // the is used to count the occurance of varialble 'the'
				int a=0;    // a is used to count the occurance of varialble 'a'
				int flag;	// it is a flag variable

				flag = sample.length;
				int arr[] = new int[flag]; 
				
				StringWriter writer = new StringWriter();
				getJspBody().invoke(writer);
				String mainString = writer.toString();
				String[] mainSample = mainString.split(" ");
								
					for(i=0;i!=mainSample.length;i++)//used to find is,the,a
					{
						if(mainSample[i].equals("is"))
						{
							is++;
						}
						else if(mainSample[i].equals("the"))
						{
							the++;
						}
						else if(mainSample[i].equals("a"))
						{
							a++;					
						}
					}
						out.println("<h3 style=\"color:#09295e;\">IS(Count) : " + is + " </h3>");
						out.println("<h3 style=\"color:#5e0931;\">THE(Count) : " + the + "</h3>");
						out.println("<h3 style=\"color:#891400;\">A(Count) : " + a + "</h3>");
					
					for(i=0;i != mainSample.length;i++)//used to find subString 
					{
						for(j=0;j != sample.length;j++)
						{
								if(mainSample[i].equals(sample[j]))
								{
									arr[j]++;
								}
						}
					}
					for(i=0;i != sample.length;i++)
					{
						out.println("<h3 style=\"color:#442600;\">"+sample[i].toString()+"(Count) : " + arr[i] + "</h3>");		
					}
			}
			catch(Exception e)
			{
					out.println(e);
			}
		}
}