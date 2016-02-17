import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;
class GetSubFormulas extends PolicyGrammarBaseListener{

	PolicyGrammarParser parser;
	ArrayList<PolicyGrammarParser.FormulaContext> subformulaList = new ArrayList<PolicyGrammarParser.FormulaContext>();
	Map<PolicyGrammarParser.FormulaContext, CompactVector> varformula = new HashMap<PolicyGrammarParser.FormulaContext, CompactVector>();
	ArrayList<String> variables = new ArrayList<String>();
	//SubFormula val_pre = new SubFormula(); 
	CompactVector cv = new CompactVector();

	public GetSubFormulas(PolicyGrammarParser parser){
		this.parser = parser;
	}

	public ArrayList<PolicyGrammarParser.FormulaContext> get(){

		return subformulaList;
	}
	//override methods containg subformula
	@Override 
	public void exitStat(PolicyGrammarParser.StatContext ctx) { 


		//System.out.println("Finished collecting subformula");
		get();

	}

	@Override
	public void exitY_method(PolicyGrammarParser.Y_methodContext ctx) {

		//System.out.println("Parent of Y is " + ctx.formula().getParent().getText());
		//val_pre.subformula.put(subff, new CompactVector());
	
		
		subformulaList.add(ctx.formula()); 
	}

	@Override 
	public void exitS_method(PolicyGrammarParser.S_methodContext ctx) { 

		//String f1 = ctx.formula(0);
		//String f2 = ctx.formula(1);
		//System.out.println("Parent of S is " + ctx.getParent().getText());
		subformulaList.add(ctx.formula(0));
		subformulaList.add(ctx.formula(1));
		subformulaList.add(ctx);

	}

	@Override 
	public void exitP_method(PolicyGrammarParser.P_methodContext ctx) { 


		subformulaList.add(ctx.formula());
		//subformulaList.add(ctx.getChild(2));	
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
		subformulaList.add(newS);

		
		//System.out.println("P is " + ctx.getClass());
		//PolicyGrammarParser.S_methodContext c = PolicyGrammarParser.S_methodContext(new PolicyGrammarParser.FormulaContext());
		//PolicyGrammarParser.S_methodContext c = ((PolicyGrammarParser) ctx);

	}

	@Override 
	public void exitH_method(PolicyGrammarParser.H_methodContext ctx) { 

		

		PolicyGrammarParser.Not_methodContext not1 = new PolicyGrammarParser.Not_methodContext(ctx.formula());
		
		/*Create a new token and add the text NOT*/
		CommonToken tok = new CommonToken(PolicyGrammarParser.NOT);
		tok.setText("NOT");
		/*Create the terminal node */
		TerminalNodeImpl ter = new TerminalNodeImpl(tok); 
		

		/*  Creat NOT (formula) */
		not1.addChild(ter); 
		not1.addChild(ctx.formula()); 

		subformulaList.add(not1);

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

		subformulaList.add(not2);
		//System.out.println("P is " + ctx.getClass());
		//PolicyGrammarParser.P_methodContext co = PolicyGrammarParser.P_methodContext(ctx.getParent().getClass());
		//PolicyGrammarParser.S_methodContext c = ((PolicyGrammarParser) ctx);

	}


	@Override 
	public void exitAll_method(PolicyGrammarParser.All_methodContext ctx) {

		//getVariable(ctx.formula() , ctx.var() );
		/*if (ctx.formula().getClass().equals(PolicyGrammarParser.Parens_methodContext.class))
			System.out.println("Exiting all by " + ctx.formula().getChildCount());
			System.out.println("Ch 1 = "+ ctx.formula().getChild(0));
			System.out.println("Ch 2 = "+ ctx.formula().getChild(1).getChild(0).getChild(1).getChild(2).getText() ) ;
			System.out.println("Ch 3 = "+ ctx.formula().getChild(2)); */


	}


	public void getVariable(ParserRuleContext ctx){


		String clas = ctx.getClass().getName(); 

		ArrayList<String> result = new ArrayList<String>(); 

		if(clas.equals("PolicyGrammarParser$Parens_methodContext")){

			ctx = (ParserRuleContext)ctx.getChild(1);
			getVariable(ctx);
		}


		else if(clas.equals("PolicyGrammarParser$Y_methodContext")){

			ParserRuleContext ctx1 = (ParserRuleContext)ctx.getChild(2);
			getVariable(ctx1);
			//System.out.println("number of Child in y method " + ctx.getChild(2).getText() );
		}

		else if(clas.equals("PolicyGrammarParser$S_methodContext")){

			if( !(ctx.getChild(0).getClass().getName().equals("org.antlr.v4.runtime.tree.TerminalNodeImpl")) ){
				ParserRuleContext ctx1 = (ParserRuleContext)ctx.getChild(0);
				getVariable(ctx1);
			}
			
			ParserRuleContext ctx2 = (ParserRuleContext)ctx.getChild(2);			
			getVariable(ctx2);

		}


		else if(clas.equals("PolicyGrammarParser$P_methodContext")){

			ParserRuleContext ctx1 = (ParserRuleContext)ctx.getChild(2);
			getVariable(ctx1);
			//System.out.println("number of Child in y method " + ctx.getChild(2).getText() );
		}

		else if(clas.equals("PolicyGrammarParser$H_methodContext")){

			ParserRuleContext ctx1 = (ParserRuleContext)ctx.getChild(2);
			getVariable(ctx1);
			//System.out.println("number of Child in y method " + ctx.getChild(2).getText() );
		} 

		else if(clas.equals("PolicyGrammarParser$Not_methodContext")){

			ParserRuleContext ctx1 = (ParserRuleContext)ctx.getChild(1);
			getVariable(ctx1);
			//System.out.println("number of Child in y method " + ctx.getChild(2).getText() );
		} 


		else if(clas.equals("PolicyGrammarParser$And_methodContext")){

			//System.out.println("inside flow " + ctx.getChildCount());

			ParserRuleContext ctx1 = (ParserRuleContext)ctx.getChild(0);
			ParserRuleContext ctx2 = (ParserRuleContext)ctx.getChild(2);

			getVariable(ctx1);
			getVariable(ctx2); 

		} 

		else if(clas.equals("PolicyGrammarParser$Or_methodContext")){

			//System.out.println("inside flow " + ctx.getChildCount());

			ParserRuleContext ctx1 = (ParserRuleContext)ctx.getChild(0);
			ParserRuleContext ctx2 = (ParserRuleContext)ctx.getChild(2);

			getVariable(ctx1);
			getVariable(ctx2); 

		}

		else if(clas.equals("PolicyGrammarParser$Exist_methodContext")){

			ParserRuleContext ctx1 = (ParserRuleContext)ctx.getChild(4);
			//System.out.println("number of Child " + ctx.getChildCount() );
		}		


		else if(clas.equals("PolicyGrammarParser$All_methodContext")){

			System.out.println("number of Child " + ctx.getChildCount() );
		}


		else if(clas.equals("PolicyGrammarParser$Atom_methodContext")){

			ctx = (ParserRuleContext)ctx.getChild(0);
			getVariable(ctx);
		}

		else if(clas.equals("PolicyGrammarParser$Flow_methodContext")){

			//System.out.println("inside flow " + ctx.getChildCount());

			ParserRuleContext ctx1 = (ParserRuleContext)ctx.getChild(0);
			ParserRuleContext ctx2 = (ParserRuleContext)ctx.getChild(2);

			getVariable(ctx1);
			getVariable(ctx2);  

		} 

		else if(clas.equals("PolicyGrammarParser$Iflow_methodContext")){

			//System.out.println("inside flow " + ctx.getChildCount());

			ParserRuleContext ctx1 = (ParserRuleContext)ctx.getChild(0);
			ParserRuleContext ctx2 = (ParserRuleContext)ctx.getChild(2);

			getVariable(ctx1);
			getVariable(ctx2);  

		}

		else if(clas.equals("PolicyGrammarParser$Elem_methodContext")){

			//System.out.println("inside flow " + ctx.getChildCount());

			ParserRuleContext ctx1 = (ParserRuleContext)ctx.getChild(0);
			ParserRuleContext ctx2 = (ParserRuleContext)ctx.getChild(2);

			getVariable(ctx1);
			getVariable(ctx2);  

		}  


		else if(clas.equals("PolicyGrammarParser$Equ_ctx_methodContext")){

			//System.out.println("inside flow " + ctx.getChildCount());

			ParserRuleContext ctx1 = (ParserRuleContext)ctx.getChild(0);
			ParserRuleContext ctx2 = (ParserRuleContext)ctx.getChild(2);

			getVariable(ctx1);
			getVariable(ctx2);  

		}

		else if(clas.equals("PolicyGrammarParser$Equ_dom_methodContext")){

			//System.out.println("inside flow " + ctx.getChildCount());

			ParserRuleContext ctx1 = (ParserRuleContext)ctx.getChild(0);
			ParserRuleContext ctx2 = (ParserRuleContext)ctx.getChild(2);

			getVariable(ctx1);
			getVariable(ctx2);  

		}


		else if(clas.equals("PolicyGrammarParser$Ctx_methodContext")){

			//System.out.println(" inside  " + clas);
			//ctx = (ParserRuleContext)ctx.getChild(0); 
			//getVariable(ctx);
		}


		else if(clas.equals("PolicyGrammarParser$Dom_methodContext")){

			//System.out.println(" inside  " + clas);
			//ctx = (ParserRuleContext)ctx.getChild(0); 
			//getVariable(ctx);
		}


		else if(clas.equals("PolicyGrammarParser$Var_methodContext")){

			ArrayList<String> r = new ArrayList<String>();
			variables.add(ctx.getText());
			//return r;
			//System.out.println("inside variable " + + " added in result " + result);

		}

		else {

			 System.out.println(" Error : Geting variable from unkown method " + clas);
			//return result;
		}

	}

}