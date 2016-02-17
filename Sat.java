import java.util.*;
import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;

class Sat extends PolicyGrammarBaseVisitor<String> {

	InformationFlow incomingFlow;
	ReachabilityList reach = new ReachabilityList ();
	String result;
	String current_ctx = null;
	ArrayList<String> var_domain = new ArrayList<String>();

	Map<String, String> variable = new HashMap<String, String>();
	SubFormula val_new = new SubFormula();


	public Sat(InformationFlow incomingFlow, ReachabilityList reach, SubFormula val_new){

		this.incomingFlow = incomingFlow;
		this.reach = reach;
		this.val_new = val_new;
	}


	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitStat(PolicyGrammarParser.StatContext ctx) {

		String onePolicy = "true";
		//System.out.println("number of chile in SAT " + ctx.getChildCount()); 
		for(int i = 0; i < ctx.getChildCount(); i++){

			onePolicy = visit(ctx.getChild(i));
			//System.out.println("The policy ( line " + onePolicy + ctx.getChild(i).getClass()   );
			if(onePolicy.equals("false")){

				System.out.println("The policy ( line " + (i+1) + ")"+ ctx.getChild(i).getText() +" is not satisfied " );
				break;
			}
		}

		result = onePolicy;
		return onePolicy; 


	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitPrintDecision_method(PolicyGrammarParser.PrintDecision_methodContext ctx) { 
 
		return visit(ctx.getChild(0)); 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitBlank_method(PolicyGrammarParser.Blank_methodContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitAssign_method(PolicyGrammarParser.Assign_methodContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitParens_method(PolicyGrammarParser.Parens_methodContext ctx) { 
		return visit(ctx.formula());  

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitNot_method(PolicyGrammarParser.Not_methodContext ctx) { 

		String re = visit(ctx.formula());
		if(re.equals("true"))
			return "false";
		else 
			return "true";

		//return visitChildren(ctx); 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitS_method(PolicyGrammarParser.S_methodContext ctx) {


		CompactVector cv =  val_new.getValueof(ctx);

		if(cv.getboolvalue()){
			//System.out.println("returning true");
			return "true";
			}
		else 
			return "false";
		

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitAtom_method(PolicyGrammarParser.Atom_methodContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitY_method(PolicyGrammarParser.Y_methodContext ctx) { 

		
		PolicyGrammarParser.FormulaContext f = ctx.formula();
		CompactVector cv =  val_new.getValueof(f);
		//System.out.println("Inside sat Y vector of " + f.getText() + " is " + cv.getboolvalue());
		//cv.printVector();
	
			if(cv.getboolvalue()){
				/*if the formula inside Y happed before but it is not exactly in the previous state clear the filed
					assume the case where information flow is ACCEPTED, then next Y should return true but after i should return false
				*/
				String ss = visit(f);
				if(ss.equals("false")){
					cv.setboolvalue(false);
					val_new.add(f, cv);
				}

				return "true";
			}
			else 
				return "false";
		

		
		
		//return ""; 

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitAnd_method(PolicyGrammarParser.And_methodContext ctx) { 

		String left = visit(ctx.getChild(0));
		String right = visit(ctx.getChild(2));

		if(left.equals("true") && right.equals("true"))
			return "true";
		else 
			return "false";

	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitH_method(PolicyGrammarParser.H_methodContext ctx) { 


		PolicyGrammarParser.Not_methodContext not1 = new PolicyGrammarParser.Not_methodContext(ctx.formula());
		
		/*Create a new token and add the text NOT*/
		CommonToken tok = new CommonToken(PolicyGrammarParser.NOT);
		tok.setText("NOT");
		/*Create the terminal node */
		TerminalNodeImpl ter = new TerminalNodeImpl(tok); 
		

		/*  Creat NOT (formula) */
		not1.addChild(ter); 
		not1.addChild(ctx.formula()); 

		//subformulaList.add(not1);

		PolicyGrammarParser.S_methodContext newS = new PolicyGrammarParser.S_methodContext(ctx.formula());

		/*Create a new token and add the text true*/
		CommonToken tok_true = new CommonToken(PolicyGrammarParser.ID);
		tok_true.setText("true");
		/*Create the terminal node */
		TerminalNodeImpl ter_true = new TerminalNodeImpl(tok_true);


		/*Create a new token and add the text S*/
		CommonToken tok_s = new CommonToken(PolicyGrammarParser.SINCE);
		tok_s.setText("S");
		/*Create the terminal node */
		TerminalNodeImpl ter_s = new TerminalNodeImpl(tok_s);

		/* Create (true) S (NOT (formula))  */
		newS.addChild(ter_true);
		newS.addChild(ter_s);
		newS.addChild(not1);


		PolicyGrammarParser.Not_methodContext not2 = new PolicyGrammarParser.Not_methodContext(ctx.formula());
		/*Create NOT ( (true) S (NOT (formula)) )*/
		not2.addChild(ter);
		not2.addChild(newS); 

		CompactVector cv =  val_new.getValueof(not2);

		if(cv.getboolvalue()){
			//System.out.println("returning true");
			return "true";
			}
		else 
			return "false";

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitOr_method(PolicyGrammarParser.Or_methodContext ctx) { 


		String left = visit(ctx.getChild(0));
		String right = visit(ctx.getChild(2));

		if(left.equals("false") && right.equals("false"))
			return "false";
		else 
			return "true";

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitP_method(PolicyGrammarParser.P_methodContext ctx) {

		PolicyGrammarParser.S_methodContext newS = new PolicyGrammarParser.S_methodContext(ctx.formula());

		/*Create a new token and add the text true*/
		CommonToken tok_true = new CommonToken(PolicyGrammarParser.ID);
		tok_true.setText("true");
		/*Create the terminal node */
		TerminalNodeImpl ter_true = new TerminalNodeImpl(tok_true);

		/*Create a new token and add the text S*/
		CommonToken tok_s = new CommonToken(PolicyGrammarParser.SINCE);
		tok_s.setText("S");
		/*Create the terminal node */
		TerminalNodeImpl ter_s = new TerminalNodeImpl(tok_s);

		newS.addChild(tok_true);
		newS.addChild(tok_s);
		newS.addChild(ctx.formula()); 

		CompactVector cv =  val_new.getValueof(newS);

		if(cv.getboolvalue()){
			//System.out.println("returning true");
			return "true";
			}
		else 
			return "false";

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitAll_method(PolicyGrammarParser.All_methodContext ctx) { 

		//System.out.println(" Inside visit all " + ctx.getChildCount());
		String var = visit(ctx.getChild(1));
		String dom_name = visit(ctx.getChild(3));
		
		ArrayList<String> elements = Decision.getElmOf(dom_name);

		//System.out.println("elements "+ elements);

		for(String s: elements){

			//variable.push(s);
			current_ctx = var;
			variable.put(current_ctx, s);
			String re = visit(ctx.getChild(4));
			if(re.equals("false")){
				variable.clear();
				return re;
			}

		}

		variable.clear();
		return "true"; 


	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitExist_method(PolicyGrammarParser.Exist_methodContext ctx) { 


		String var = visit(ctx.getChild(1));
		String dom_name = visit(ctx.getChild(3));
		
		ArrayList<String> elements = Decision.getElmOf(dom_name);
		for(String s: elements){

			//variable.push(s);
			current_ctx = var;
			variable.put(current_ctx, s);
			String re = visit(ctx.getChild(4));
			if(re.equals("true")){
				//variable.clear();
				return re;

			}

		}

		return "false"; 

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitFlow_method(PolicyGrammarParser.Flow_methodContext ctx) { 



		String left = visit(ctx.getChild(0));
		String right = visit(ctx.getChild(2));

		String source = incomingFlow.getSource();
		String destin = incomingFlow.getDestination();

		String leftClass = ctx.getChild(0).getClass().getName();
		String rightClass = ctx.getChild(2).getClass().getName();

		/*If the flow is b.n variable and variable */

		if(leftClass.equals("PolicyGrammarParser$Var_methodContext") && rightClass.equals("PolicyGrammarParser$Var_methodContext")){

			//System.out.println("INSID BOTH VAR *******************************" + variable.size());
			if(left.equals(current_ctx)){

				left = variable.get(left);
				right = variable.get(right);

			}

			else {

				right = variable.get(right);
				left = variable.get(left);
			}


		}
		else{

	    if(leftClass.equals("PolicyGrammarParser$Var_methodContext") )

	    	left = variable.get(left);
			//left = variable.pop();

		if(rightClass.equals("PolicyGrammarParser$Var_methodContext") )

			right = variable.get(right);
			//right = variable.pop();
	    }

		/* after geting varible valuse comput the flow*/
		if (left.equals(source) && right.equals(destin))

			return "true";
		else
			return "false";


	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitIflow_method(PolicyGrammarParser.Iflow_methodContext ctx) { 

		String left = visit(ctx.getChild(0));
		String right = visit(ctx.getChild(2));

		String source = incomingFlow.getSource();
		String destin = incomingFlow.getDestination();

		String leftClass = ctx.getChild(0).getClass().getName();
		String rightClass = ctx.getChild(2).getClass().getName();


		if(leftClass.equals("PolicyGrammarParser$Var_methodContext") && rightClass.equals("PolicyGrammarParser$Var_methodContext")){

			//System.out.println("INSID BOTH VAR *******************************" + variable.size());
			if(left.equals(current_ctx)){

				left = variable.get(left);
				right = variable.get(right);

			}

			else {

				right = variable.get(right);
				left = variable.get(left);
				
			}

		}
		else{

	    if(leftClass.equals("PolicyGrammarParser$Var_methodContext") )

	    	left = variable.get(left);
			//left = variable.pop();

		if(rightClass.equals("PolicyGrammarParser$Var_methodContext") )

			right = variable.get(right);
			//right = variable.pop();
	    }


		/* If the incoming flow creates a direct information flow return true*/
		if (left.equals(source) && right.equals(destin))
			return "true";

		/* else cheack if it creates indirect flow*/
		else {
			/* if the incoming flow left side maches with the source we need to cheack only if
				destination reaches right context before
			 */
			if(left.equals(source)){

				if(reach.isIn(destin, right))
					return "true";
				else
					return "false";
			}
			/* if the incoming flow right side maches with the destination we need to cheack only if
				left reaches source context before
			 */
			if(right.equals(destin)){

				if(reach.isIn(left, source))
					return "true";
				else 
					return "false";

			}
			/* if both the source and the destination is diffrent from the left and right side of the rule
			   cheak if destination reaches right context before and  left reaches source context before
			 */

			if (reach.isIn(left, source) && reach.isIn(destin, right) )
				return "true";
			else 
				return "false";

		}

		//return ""; 

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitElem_method(PolicyGrammarParser.Elem_methodContext ctx) { 

		String left = visit(ctx.getChild(0));
		String right = visit(ctx.getChild(2));
		String leftClass = ctx.getChild(0).getClass().getName();
		ArrayList<String> right_ele = Decision.getElmOf(right);

		if(leftClass.equals("PolicyGrammarParser$Ctx_methodContext")){

			for(String s : right_ele){
				if(s.equals(left))
					return "true";
			}

			return "false";
		}

		else if(leftClass.equals("PolicyGrammarParser$Dom_methodContext")){

			ArrayList<String> left_ele = Decision.getElmOf(right);
			for(String s: left_ele){

				boolean re =right_ele.contains(s);
				if(re == false)
					return "flase";

			}

			return "true";

		}
		
		return "";
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitEqu_ctx_method(PolicyGrammarParser.Equ_ctx_methodContext ctx) { 

		String left = visit(ctx.getChild(0));
		String right = visit(ctx.getChild(2));

		if(left.equals(right))
			return "true";
		else 
			return "false";

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitEqu_dom_method(PolicyGrammarParser.Equ_dom_methodContext ctx) { 


		String left = visit(ctx.getChild(0));
		String right = visit(ctx.getChild(2));
		ArrayList<String> left_ele = Decision.getElmOf(left);
		ArrayList<String> right_ele = Decision.getElmOf(right);

		if(left_ele.size() != right_ele.size())
			return "false";

		else {

			for( int i=0; i<left_ele.size(); i++ )
			{
				if(! left_ele.get(i).equals(right_ele.get(i)) )
					return "false";

			}
		}

		return "true"; 


	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitCtx_method(PolicyGrammarParser.Ctx_methodContext ctx) { 

		return ctx.getText(); 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitDom_method(PolicyGrammarParser.Dom_methodContext ctx) { 

		return ctx.getText();  
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public String visitVar_method(PolicyGrammarParser.Var_methodContext ctx) { 
		return ctx.getText();
	 }



}