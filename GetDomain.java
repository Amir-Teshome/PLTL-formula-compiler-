import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;	
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.*;
import java.util.HashMap;
import java.util.Map;

class GetDomain {


	ArrayList<String> all_context = new ArrayList<String>();
	ArrayList<String> all_domain = new ArrayList<String>();
	Map<String, ArrayList<String>>  dom_AND_ctx = new HashMap<String, ArrayList<String>>();
	ArrayList<String> ctx_per_dom = new ArrayList<String>();


	public void get() { 

		String listctx = null;
		String current_dom, current_ctx;
		String inputfile = "DomainFile";
		File file = new File(inputfile);
		BufferedReader reader = null;

		
		try {
	    		reader = new BufferedReader(new FileReader(file));
	    		String text = null; 
	    		
	    		while ((text = reader.readLine()) != null) {

	    			//System.out.print("Line: " + text);
	    			 StringTokenizer st1 = new StringTokenizer(text, "=");
	    			 ArrayList<String> ctx_per_dom = new ArrayList<String>();
	    			 current_dom = (String)st1.nextElement() ;
	    			 current_dom = current_dom.trim();

	    			 if(! all_domain.contains(current_dom) )
	    			 	all_domain.add((current_dom));

	    			 else{

	    			 	System.out.print("error : Multiple Domain name found while reading " + inputfile);
	    			 	break;
	    			 }
	    			 
	    			 listctx = (String)st1.nextElement();

	    			 listctx = listctx.replaceFirst("\\{", "");

	    			 listctx = listctx.replaceFirst("\\}", "");
	    			 
	    			 StringTokenizer st2 = new StringTokenizer(listctx, ","	);
	    			 

	    			 while(st2.hasMoreElements()){

	    			 	current_ctx = (String)st2.nextElement();
	    			 	current_ctx = current_ctx.trim();
	    			 	ctx_per_dom.add(current_ctx);

	    			 	if(! all_context.contains(current_dom))
	    			 		all_context.add(current_ctx);

	    			 }

	    			 dom_AND_ctx.put(current_dom, ctx_per_dom);

	    			 //System.out.println(current_dom+ " : " + ctx_per_dom);
	    			 //ctx_per_dom.clear();
	    			 /*System.out.println("after cleaning ***********************");
	    			 System.out.println(current_dom+ " : " + ctx_per_dom);*/
	    			}
			} 
		catch (FileNotFoundException e) { e.printStackTrace();} 
		catch (IOException e) {e.printStackTrace();}
	
			//if (reader != null) 
            //	reader.close();
			
		// Open LexerGrammar file and insert 
		//System.out.print(domain);
		String ctx = "\'";
		for (String s : all_context)
			    {
                     ctx =  ctx + s.replaceAll("\\s", "") + "\' |\'";
                }
        ctx = "CTX: " + ctx.substring(0, ctx.length()-2) + ";";


		String dom = "\'";
		for (String str : all_domain)
			    {
                     dom =  dom + str.replaceAll("\\s", "") + "\' |\'";
                }
        dom = "DOM: " + dom.substring(0, dom.length()-2) + ";" ;

        

		BufferedReader rd = null;
    	BufferedWriter wt = null;

	    try {
	        rd = new BufferedReader(
	                new InputStreamReader(
	                        new FileInputStream("LexerGrammar_initial.g4"), "UTF-8")
	                );

	        wt = new BufferedWriter(
	                new OutputStreamWriter(
	                        new FileOutputStream(
	                                "LexerGrammar.g4"), "UTF-8")
	                );

	        int count = 0;

	        for (String line; (line = rd.readLine()) != null;) {

	            count++;
	            if (count == 2) {
	                // add your line
	                wt.write(ctx); 
	                wt.write("\n");
	                wt.write(dom);
	                wt.write("\n");

	            }

	            wt.write(line);
	            wt.newLine();
	        }

	         wt.close();
	    }

		catch (IOException e) { 
			  e.printStackTrace();

			}

			System.out.println("***** Finished geting domains and contexts *****");	

}	




}