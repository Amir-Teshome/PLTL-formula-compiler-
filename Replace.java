import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.*;

public class Replace extends PolicyGrammarBaseListener {


	ParseTree tree;

	public Replace(ParseTree tree){

		this.tree = tree;
	}


	@Override 
	public void exitP_method(PolicyGrammarParser.P_methodContext ctx) { 

		System.out.println("Before :" +  ctx.formula().getText() + ctx.getChildCount());
		System.out.println("chiled 1 "+ ctx.getChild(0).getText());
		System.out.println("chiled 2 "+ ctx.getChild(1).getText());
		System.out.println("chiled 3 "+ ctx.getChild(2).getText());
		System.out.println("chiled 4 "+ ctx.getChild(3).getText());
		

		ParserRuleContext prc = new ParserRuleContext(null, 0);
        
        PolicyGrammarParser.FormulaContext  fc = new PolicyGrammarParser.FormulaContext(ctx.getParent(),0);
        //fc.addChild(ctx.formula()); 
        
        PolicyGrammarParser.H_methodContext sm = new PolicyGrammarParser.H_methodContext(ctx.formula());
        sm.addChild(ctx.formula());
       
		System.out.println("new P :" +  sm.formula().getText() + sm.getChildCount());
		//System.out.println(fc.getChild(ctx.formula().getClass(), 0).getText());


	}

	@Override 
	public void exitOr_method(PolicyGrammarParser.Or_methodContext ctx) { 

		PolicyGrammarParser.Not_methodContext not1 = new PolicyGrammarParser.Not_methodContext(ctx.formula(0));
		not1.addChild(ctx.formula(0)); 

		PolicyGrammarParser.Not_methodContext not2 = new PolicyGrammarParser.Not_methodContext(ctx.formula(0));
		not1.addChild(ctx.formula(1)); 

		PolicyGrammarParser.And_methodContext andd = new PolicyGrammarParser.And_methodContext(ctx.formula(0));

		System.out.println(" before inside exit or: " + andd.getChildCount());
		andd.addChild(not1);
		andd.addChild(not2);

		PolicyGrammarParser.Not_methodContext not3 = new PolicyGrammarParser.Not_methodContext(ctx.formula(0));
		not3.addChild(andd); 

		System.out.println("inside exit or: " + not3.getChildCount() + " class is " + not3.getClass());
		System.out.println(not3.getText() );




	}

	
}