import java.util.*;
import java.util.HashMap;
import java.util.Map;

class SubFormula{

	Map<PolicyGrammarParser.FormulaContext, CompactVector> subformula = new HashMap<PolicyGrammarParser.FormulaContext, CompactVector>();

	/*public SubFormula(ArrayList<FormulaContext> subf){

		for(formula : subf){
			subformula.put(formula, new CompactVector());
		}


	}*/

	int add(PolicyGrammarParser.FormulaContext fr, CompactVector cv){


		CompactVector existing = getValueof(fr);

		if(existing == null){

			System.out.println("Adding new ");
			cv.printVector();
			subformula.put(fr, cv);
		}

		else{

			//System.out.println("existing returns ");
			//existing.printVector();
			//cv.printVector();

			if(!existing.isequal(cv)){
				//System.out.println("existing is not null it is " + existing.isequal(cv));
				CompactVector cc = existing.union(cv);

				//System.out.println("Adding existing subformula before removing " + fr.getText());
				//printList();
				
				//if(subformula.containsKey(fr) )
				//System.out.println("****************************************************subformula contains  " + fr.getText() );
				

			    for(Iterator<Map.Entry<PolicyGrammarParser.FormulaContext, CompactVector>> it = subformula.entrySet().iterator(); it.hasNext(); ) {
			      Map.Entry<PolicyGrammarParser.FormulaContext, CompactVector> entry = it.next();
			      if(entry.getKey().getText().equals(fr.getText())) {
			        it.remove();
			      }
			    }

				//subformula.remove(fr);

				//System.out.println("removed value is ");
				//rm.printVector();
				//System.out.println("Adding existing subformula after removing " + fr.getText());
				//printList();
				subformula.put(fr, cc);

			}

		}

		return 0;







	}

	CompactVector getValueof(PolicyGrammarParser.FormulaContext formula){

		CompactVector val = new CompactVector(); 
		for (Map.Entry<PolicyGrammarParser.FormulaContext, CompactVector> entry : subformula.entrySet()) {
			PolicyGrammarParser.FormulaContext key = entry.getKey();
			val = entry.getValue();

			if(key.getText().equals(formula.getText()))
			{
				//System.out.println("Found *** "+ key.getText() + "inside subformula " + val.getboolvalue());
				return val;
				//break;
			}



		}

		return val;
	}
	public void printList(){


		for (Map.Entry<PolicyGrammarParser.FormulaContext, CompactVector> entry : subformula.entrySet()) {
			PolicyGrammarParser.FormulaContext key = entry.getKey();
			CompactVector val = entry.getValue();

			System.out.print("{ " + key.getText() + ":");
			val.printVector();
			System.out.println(" }");

		}


	}



}