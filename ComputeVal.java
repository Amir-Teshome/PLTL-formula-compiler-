import java.util.*;
import java.util.HashMap;
import java.util.Map;


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;


class ComputeVal extends PolicyGrammarBaseVisitor<CompactVector>{


	InformationFlow incomingFlow;
	SubFormula val_pre = new SubFormula();

	SubFormula val_new = new SubFormula();
	Map<String, String> variable = new HashMap<String, String>();
	String current_ctx = null;
	ReachabilityList reach = new ReachabilityList ();

	public ComputeVal(SubFormula val_pre, InformationFlow incomingFlow, ReachabilityList reach){

		this.val_pre = val_pre;
		this.val_new = val_pre; 
		this.incomingFlow = incomingFlow;
		this.reach = reach;
	}


	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public CompactVector visitStat(PolicyGrammarParser.StatContext ctx) { 

		System.out.println("number of chile in SAT " + ctx.getChildCount());
		ArrayList<CompactVector> re = new ArrayList<CompactVector>();
		boolean bool = true;
		CompactVector cv = new CompactVector(); 
	
		for(int i = 0; i < ctx.getChildCount(); i++)
			re.add(visit(ctx.getChild(i)));

		cv = re.get(0);
		for(int i = 1; i < ctx.getChildCount(); i++){ 

			CompactVector cv2 = cv.intersection(re.get(i));

			if(cv2.getboolvalue() == false)
				bool = false;
			cv = cv2;
		}

		if(!bool)
			cv.setboolvalue(true);

		return cv; 

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public CompactVector visitPrintDecision_method(PolicyGrammarParser.PrintDecision_methodContext ctx) { 


		
		CompactVector cv = visit(ctx.getChild(0));
		return cv;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public CompactVector visitBlank_method(PolicyGrammarParser.Blank_methodContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public CompactVector visitAssign_method(PolicyGrammarParser.Assign_methodContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public CompactVector visitParens_method(PolicyGrammarParser.Parens_methodContext ctx) { 

		return visit(ctx.formula()); 

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public CompactVector visitNot_method(PolicyGrammarParser.Not_methodContext ctx) { 

		CompactVector to_return = new CompactVector();

		to_return = visit(ctx.formula());
		if(to_return.getboolvalue())

			to_return.setboolvalue(false);
		else 
			to_return.setboolvalue(true);

		return to_return; 


	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public CompactVector visitS_method(PolicyGrammarParser.S_methodContext ctx) { 
		

		CompactVector left = visit(ctx.getChild(0));
		CompactVector right = visit(ctx.getChild(2));
		CompactVector form = val_new.getValueof(ctx);

		/* if it is bulet we don't need to add the left side to subformula list b.c it is not subformula */
		if(ctx.getChild(0).getClass().getName().equals("org.antlr.v4.runtime.tree.TerminalNodeImpl")){

			
			CompactVector bu = new CompactVector();
			bu.setboolvalue(true);
			left = bu;
			val_new.add(ctx.formula(0) , right);

			CompactVector to_return = new CompactVector();

			CompactVector form_n_left = form.intersection(left);
			to_return = form_n_left.union(right);

			val_new.add(ctx, to_return);

			return to_return; 


		}

		else{

			val_new.add(ctx.formula(0) , left);
			
			val_new.add(ctx.formula(1) , right);			

			CompactVector to_return = new CompactVector();

			CompactVector form_n_left = form.intersection(left);
			to_return = form_n_left.union(right);

			val_new.add(ctx, to_return);

			return to_return;  
	}

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public CompactVector visitAtom_method(PolicyGrammarParser.Atom_methodContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public CompactVector visitY_method(PolicyGrammarParser.Y_methodContext ctx) { 


		//CompactVector to_return = new CompactVector();
		PolicyGrammarParser.FormulaContext f = ctx.formula();
		//CompactVector to_return =  val_pre.getValueof(f);
		CompactVector to_return = new CompactVector();

		to_return = visit(f);
		//System.out.println("Inside sat Y vector of " + f.getText() + " is " + cv.getboolvalue());
		//cv.printVector();

		//System.out.println("result of getvalue ");
		//val_new.printList();
	
			if(to_return.getboolvalue()){
				System.out.println("returning true inside visit y and IF is" + incomingFlow.printinline() );
				to_return.setboolvalue(true);
			}
			else 
				to_return.setboolvalue(false);


		val_new.add(f, to_return);	

		//System.out.println("inside visit Y. val new is setted to  ");
		//val_new.printList();
		return to_return; 

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public CompactVector visitAnd_method(PolicyGrammarParser.And_methodContext ctx) { 

		CompactVector left = visit(ctx.getChild(0));
		CompactVector right = visit(ctx.getChild(2));
		CompactVector to_return = new CompactVector();

		to_return = left.intersection(right);

		return to_return; 
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public CompactVector visitP_method(PolicyGrammarParser.P_methodContext ctx) { 



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

		//CompactVector cv =  val_new.getValueof(newS);

		return visit(newS); 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public CompactVector visitOr_method(PolicyGrammarParser.Or_methodContext ctx) { 


		CompactVector left = visit(ctx.getChild(0));
		CompactVector right = visit(ctx.getChild(2));
		CompactVector to_return = new CompactVector();

		to_return = left.union(right);

		return to_return; 

		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public CompactVector visitH_method(PolicyGrammarParser.H_methodContext ctx) {



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


		PolicyGrammarParser.VarContext vc = new PolicyGrammarParser.VarContext(); 
		PolicyGrammarParser.Var_methodContext vara = new PolicyGrammarParser.Var_methodContext(vc);
		vara.addChild(tok_true);

		/*Create a new token and add the text S*/
		CommonToken tok_s = new CommonToken(PolicyGrammarParser.SINCE);
		tok_s.setText("S");
		/*Create the terminal node */
		TerminalNodeImpl ter_s = new TerminalNodeImpl(tok_s);

		/* Create (true) S (NOT (formula))  */
		newS.addChild(tok_true);
		newS.addChild(ter_s);
		newS.addChild(not1);


		PolicyGrammarParser.Not_methodContext not2 = new PolicyGrammarParser.Not_methodContext(ctx.formula());
		/*Create NOT ( (true) S (NOT (formula)) )*/
		not2.addChild(ter);
		not2.addChild(newS); 

		//CompactVector cv =  val_new.getValueof(not2); 

		return visit(not2); 





	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public CompactVector visitAll_method(PolicyGrammarParser.All_methodContext ctx) { 

		String var = visit(ctx.getChild(1)).stringValue;
		//System.out.println("inside visit *********************");
		String dom_name = visit(ctx.getChild(3)).stringValue;
		boolean success = true;
		ArrayList<String> elements = Decision.getElmOf(dom_name);
		CompactVector cv = new CompactVector();
		CompactVector to_return = new CompactVector();


		for(String s: elements){

			//variable.push(s);
			current_ctx = var;
			variable.put(current_ctx, s);
			cv = visit(ctx.getChild(4));

			if(! cv.getboolvalue())
				success = cv.getboolvalue();
				//val_new.subformula.put(f, to_return);
				//val_new.add(cv);
			to_return = to_return.union(cv);
		}

		to_return.setboolvalue(success);


		return to_return; 

	}
	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public CompactVector visitExist_method(PolicyGrammarParser.Exist_methodContext ctx) { 


		String var = visit(ctx.getChild(1)).stringValue;
		//System.out.println("inside visit *********************");
		String dom_name = visit(ctx.getChild(3)).stringValue;
		boolean success = false;
		ArrayList<String> elements = Decision.getElmOf(dom_name);
		CompactVector cv = new CompactVector();
		CompactVector to_return = new CompactVector();


		for(String s: elements){

			//variable.push(s);
			current_ctx = var;
			variable.put(current_ctx, s);

			cv = visit(ctx.getChild(4));

			if(!success && cv.getboolvalue())
				success = cv.getboolvalue();
				//val_new.subformula.put(f, to_return);
				//val_new.add(cv);
			to_return = to_return.union(cv);
		}

		if(success)
			to_return.setboolvalue(true);

		return to_return; 

	}	
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override
	public CompactVector visitFlow_method(PolicyGrammarParser.Flow_methodContext ctx) { 


		String left = visit(ctx.getChild(0)).stringValue;
		String right = visit(ctx.getChild(2)).stringValue;

		String source = incomingFlow.getSource();
		String destin = incomingFlow.getDestination();

		String leftClass = ctx.getChild(0).getClass().getName();
		String rightClass = ctx.getChild(2).getClass().getName();

		String leftvar = null;
		String rightvar = null;
		CompactVector to_return = new CompactVector();

		/*If the flow is b.n variable and variable */

		if(leftClass.equals("PolicyGrammarParser$Var_methodContext") && rightClass.equals("PolicyGrammarParser$Var_methodContext")){

			//System.out.println("INSID BOTH VAR *******************************" + variable.size());
			if(left.equals(current_ctx)){

				leftvar = left;
				rightvar = right;

				left = variable.get(leftvar);
				right = variable.get(rightvar);

			}

			else {

				leftvar = left;
				rightvar = right;

				right = variable.get(rightvar);
				left = variable.get(leftvar);				
			}


		}
		else{

		    if(leftClass.equals("PolicyGrammarParser$Var_methodContext") ){

		    	leftvar = left;
		    	left = variable.get(leftvar);

		    }

			if(rightClass.equals("PolicyGrammarParser$Var_methodContext") ){

				rightvar = right;
				right = variable.get(rightvar);
				//System.out.println("poped in right var ************" + left);

			}		
	    } 

		/* after geting varible valuse comput the flow*/
		if (left.equals(source) && right.equals(destin)){

			if(leftvar != null)
				to_return.add(leftvar, source);

			if(rightvar != null)
				to_return.add(rightvar, destin);

			to_return.setboolvalue(true);

		}

		else {

			//System.out.println("poped in right var ************" + left);
			to_return.setboolvalue(false);
		}


		return to_return; 



	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public CompactVector visitIflow_method(PolicyGrammarParser.Iflow_methodContext ctx) { 

		String left = visit(ctx.getChild(0)).stringValue;
		String right = visit(ctx.getChild(2)).stringValue;

		String source = incomingFlow.getSource();
		String destin = incomingFlow.getDestination();

		String leftClass = ctx.getChild(0).getClass().getName();
		String rightClass = ctx.getChild(2).getClass().getName();

		String leftvar = null;
		String rightvar = null;
		CompactVector to_return = new CompactVector();


		if(leftClass.equals("PolicyGrammarParser$Var_methodContext") && rightClass.equals("PolicyGrammarParser$Var_methodContext")){

			if(left.equals(current_ctx)){

				leftvar = left;
				rightvar = right;

				//left = variable.pop();
				//right = variable.pop();
				left = variable.get(leftvar);
				right = variable.get(rightvar);
				
			}

			else {


				leftvar = left;
				rightvar = right;

				right = variable.get(rightvar);
				left = variable.get(leftvar);
				
			}

		}
		else{

	    if(leftClass.equals("PolicyGrammarParser$Var_methodContext") ){

	    	leftvar = left;
	    	//left = variable.pop();
	    	left = variable.get(leftvar);
	    }

			

		if(rightClass.equals("PolicyGrammarParser$Var_methodContext") ){

				rightvar = right;
				right = variable.get(rightvar);
				//right = variable.pop();
		}
	
	    }

		/* If the incoming flow creates a direct information flow return true*/
		if (left.equals(source) && right.equals(destin)){

			if(leftvar != null)
				to_return.add(leftvar, source);

			if(rightvar != null)
				to_return.add(rightvar, destin);

			to_return.setboolvalue(true);
			
		}

		/* else cheack if it creates indirect flow*/
		else {
			/* if the incoming flow left side maches with the source we need to cheack only if
				destination reaches right context before
			 */
			if(left.equals(source)){

				if(reach.isIn(destin, right)){
					if(leftvar != null)
						to_return.add(leftvar, source);

					to_return.setboolvalue(true);
				}

			}
			/* if the incoming flow right side maches with the destination we need to cheack only if
				left reaches source context before
			 */
			if(right.equals(destin)){

				if(reach.isIn(left, source)){
					if(rightvar != null)
						to_return.add(rightvar, destin);

					to_return.setboolvalue(true);
				}
			

			}
			/* if both the source and the destination is diffrent from the left and right side of the rule
			   cheak if destination reaches right context before and  left reaches source context before
			 */

			if (reach.isIn(left, source) && reach.isIn(destin, right) ){

				if(leftvar != null)
					to_return.add(leftvar, source);

				if(rightvar != null)
					to_return.add(rightvar, destin);

				to_return.setboolvalue(true);		

			}


		}

		return to_return; 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public CompactVector visitElem_method(PolicyGrammarParser.Elem_methodContext ctx) { 

		String left = visit(ctx.getChild(0)).stringValue;
		String right = visit(ctx.getChild(2)).stringValue;
		String leftClass = ctx.getChild(0).getClass().getName();
		ArrayList<String> right_ele = Decision.getElmOf(right);
		CompactVector to_return = new CompactVector();


		if(leftClass.equals("PolicyGrammarParser$Ctx_methodContext")){

			for(String s : right_ele){
				if(s.equals(left))
					to_return.setboolvalue(true);
			}

		}

		else if(leftClass.equals("PolicyGrammarParser$Dom_methodContext")){

			ArrayList<String> left_ele = Decision.getElmOf(right);
			boolean rea = true;
			for(String s: left_ele){

				boolean re =right_ele.contains(s);
				if(re == false)
					rea = false;

			}

			to_return.setboolvalue(rea);

		}
		
		return to_return; 

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public CompactVector visitEqu_ctx_method(PolicyGrammarParser.Equ_ctx_methodContext ctx) { 


		String left = visit(ctx.getChild(0)).stringValue;
		String right = visit(ctx.getChild(2)).stringValue;
		CompactVector to_return = new CompactVector();


		if(left.equals(right))
			to_return.setboolvalue(true);
		else 
			to_return.setboolvalue(false);


		return to_return; 


	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public CompactVector visitEqu_dom_method(PolicyGrammarParser.Equ_dom_methodContext ctx) { 


		String left = visit(ctx.getChild(0)).stringValue;
		String right = visit(ctx.getChild(2)).stringValue;
		ArrayList<String> left_ele = Decision.getElmOf(left);
		ArrayList<String> right_ele = Decision.getElmOf(right);
		CompactVector to_return = new CompactVector();

		to_return.setboolvalue(true);

		if(left_ele.size() != right_ele.size())
			to_return.setboolvalue(false);

		else {

			for( int i=0; i<left_ele.size(); i++ )
			{
				if(! left_ele.get(i).equals(right_ele.get(i)) )
					to_return.setboolvalue(false);

			}
		}

		return to_return; 



	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public CompactVector visitCtx_method(PolicyGrammarParser.Ctx_methodContext ctx) { 


		String val = ctx.getText();

		CompactVector to_return = new CompactVector();

		to_return.stringValue = val;
		return to_return; 


	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public CompactVector visitDom_method(PolicyGrammarParser.Dom_methodContext ctx) { 

		String val = ctx.getText();

		CompactVector to_return = new CompactVector();

		to_return.stringValue = val;
		return to_return; 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override 
	public CompactVector visitVar_method(PolicyGrammarParser.Var_methodContext ctx) { 

		String val = ctx.getText();

		CompactVector to_return = new CompactVector();

		to_return.stringValue = val;
		return to_return; 


	}

}