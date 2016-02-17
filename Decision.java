/***
 * This class impliments the decision algorithm
***/
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class Decision {
	    
      
      /** list to each contextt showing whom did it reach until now */  
     static ReachabilityList reach_pre = new ReachabilityList(); 

     /** list of subformula to store the previous value evaluation */
     static SubFormula val_pre = new SubFormula(); 
     static String result = null;

     static int counter = -1;
     static Map<String, ArrayList<String>>  dom_AND_ctx = new HashMap<String, ArrayList<String>>();

    public static void main(String[] args) throws Exception {
        
        InformationFlow incomingFlow = null;
        /*call the get method of Getdomain to cllect the domain and context
          this method will write the CTX and DOM tokens to the lexer file (LexerGrammar)  
        */
        GetDomain gd = new GetDomain();
        gd.get();

        /* get the domain and context in a map*/
        dom_AND_ctx = gd.dom_AND_ctx;

        /*for (Map.Entry<String, ArrayList<String>> entry : dom_AND_ctx.entrySet()) {
            String key = entry.getKey();
            ArrayList<String> val = entry.getValue();
            System.out.println(key +" : "+ val);
        }*/

        /* initalize the reachability list for all contexts with empty list */
        reach_pre.init(gd.all_context);


        /* get input file if it is specifide in the command line
           other ask users for input
        */
        String inputFile = null;
        if ( args.length>0 ) inputFile = args[0];
        InputStream is = System.in;
        if ( inputFile!=null ) is = new FileInputStream(inputFile);
        ANTLRInputStream input = new ANTLRInputStream(is);

        /*  Get the Lexer */
        PolicyGrammarLexer   lexer =  new PolicyGrammarLexer(input);
        /*  Get the Tokens*/
        CommonTokenStream    tokens = new CommonTokenStream(lexer);
        /*  Get the parser */
        PolicyGrammarParser  parser = new PolicyGrammarParser(tokens);
        /*  Parse starting from grammer rule called stat and generate AST */
        ParseTree tree = parser.stat(); // parse


        //Replace r = new Replace(tree);        
        /*  Create a wolker wich will make an automatic visit to all nodes  */
        ParseTreeWalker walker = new ParseTreeWalker(); 

        /*  the work to do while visiting all nodes inthis case walk to get all the subformulas
            this class extends the listner to be notified while entering and exiting nodes
         */
        GetSubFormulas extractor = new GetSubFormulas(parser);

        //Replace rr = new Replace(tree);

        /*  Make the actual walk doing the tasks specified in extractor */
        walker.walk(extractor, tree); // initiate walk of tree with listener

        /*  The walk will collect the subformulas in an array list called subformulaList
            Get this list and add it a fild in class SubFormula
         */
        ArrayList<PolicyGrammarParser.FormulaContext> sublist = extractor.subformulaList;
        

      
        //System.out.println("sublist " + sublist.getText());
       for(PolicyGrammarParser.FormulaContext subff : sublist){

            CompactVector cv = new CompactVector();
            //System.out.println("calling getvariable by " + subff.getClass().getName());
            //ArrayList<String> var =
             
            //cv.setboolvalue(true);
            extractor.getVariable(subff);
                       
            for(String s: extractor.variables)
                cv.put(s, null);
            val_pre.subformula.put(subff, cv);
            /*Clear the variable in extract for the next itration*/
           extractor.variables.clear();
            //System.out.println("after "+ extractor.variables);
        }  


        //System.out.println("**** List of Sub Formula ****");
        //val_pre.printList();        


        //getVariable();
        /*System.out.println("**** reachability List ****");
        reach_pre.printList();*/
        //int i=0;
        incomingFlow = getIF();

        while(incomingFlow != null){

            System.out.println("Incoming information flow: " + incomingFlow.printinline());
            /* this is to calculate the time taken in nano second*/ 
            long startTime = System.nanoTime();

            ReachabilityList  reach_new = new ReachabilityList(reach_pre.reach);

            reach_new.addReach(incomingFlow);

            SubFormula val_new = new SubFormula(); 

            /*System.out.println("**** List of new Sub Formula ****");
            val_new.printList();

            
            System.out.println("**** New reachability List ****");
            reach_new.printList();*/
            ComputeVal cval = new ComputeVal(val_pre, incomingFlow, reach_new);
            if(val_pre.subformula.size() > 0){

                cval.visit(tree);
                System.out.println("**** List of Sub Formula after compute val****");
                cval.val_new.printList(); 

            }


            Sat sat = new Sat(incomingFlow, reach_new, cval.val_new);
            sat.visit(tree); 

            /* this is to calculate the time taken in nano second*/

           long estimatedTime = System.nanoTime() - startTime;
           System.out.println("Time this takes " + estimatedTime);


            result = sat.result;
            if(result.equals("false")){

                /*System.out.println("reach list after accceptance ");
                reach_pre.printList();*/

                System.out.println("Information flow NOT accepted");
                

                break;
            } 

            else{

                reach_pre = reach_new;
                val_pre = cval.val_new;

                System.out.println("reach list after accceptance ");
                reach_pre.printList();

                System.out.println("Information flow accepted \n \n");
                incomingFlow = getIF();

             }
            ////reach_new.addReach(incomingFlow);
            //System.out.println("From reach inside reachbility");
           //if(i == 2)
            //break ;

        } 



    }


    public static InformationFlow getIF(){

        InformationFlow iflow2 = new InformationFlow("user1", "user3");
        InformationFlow iflow3 = new InformationFlow("user3", "user4");
        InformationFlow iflow = new InformationFlow("user4", "user2");
        ArrayList<InformationFlow> fl = new ArrayList<InformationFlow>();
       fl.add(iflow2);
       fl.add(iflow3); fl.add(iflow);
         
        counter ++;
        return fl.get(counter);
    }


    public static ArrayList<String> getElmOf(String dom){


        for (Map.Entry<String, ArrayList<String>> entry : dom_AND_ctx.entrySet()) {
            String ke = entry.getKey();
            ArrayList<String> va = entry.getValue();

            if(ke.equals(dom))
                return va;
        }

        System.out.println("error : Can not find a Domain called " + dom + " in domain  List");
        return null;
    }





}
