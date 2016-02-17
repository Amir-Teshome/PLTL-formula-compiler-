import java.util.*;
import java.util.HashMap;
import java.util.Map;

class ReachabilityList{

	Map<String, ArrayList<String>> reach = new HashMap<String, ArrayList<String>>();

	public ReachabilityList (){}
	public ReachabilityList(Map<String, ArrayList<String>> reach){

		for (Map.Entry<String, ArrayList<String>> entry : reach.entrySet()) {
			String key = entry.getKey();
			ArrayList<String> val = entry.getValue();
			this.reach.put(key, val);
		}
	}

	public void init(ArrayList<String> list){

		for(String s : list){
			s = s.trim();
			reach.put(s, new ArrayList<String>());
		}
	}

	public int addReach(InformationFlow iflow){

		String source = iflow.getSource();
		String destination = iflow.getDestination();

		
		if(!isIn(source, destination)){

			ArrayList<String> cv = new ArrayList<String>();
			cv = getListOf(source);
			//System.out.println("***** return from finding for "+ source +" result is "+ cv +"   *****");
			cv.add(destination);

			reach.put(source, cv);
			//System.out.println("************************************* Inside if ");
			ArrayList<String> containingSorce = getContaining(source);

			for(String s : containingSorce){
				cv = getListOf(s);
				cv.add(destination);
				reach.put(s, cv);
				//reach.get(s).add(destination); 
			}

			return 0;
		}

		return -1;

	}
	
	public boolean isIn(String ctx1, String ctx2){

		
		ArrayList<String> list = new ArrayList<String>();
		
		list = reach.get(ctx1);
		
		if(list == null){
			
			return false;
		}
			
		for(String s : list){
			//System.out.println(s+"eeeeeeeeeeeeeeeeeeeeeeeeeerrrrrrrrrrrrrr");
			if(s.equals(ctx2))
				return true;
		}		
	
		return false;

	}

	public ArrayList<String> getContaining(String ctx){

		ArrayList<String> result = new ArrayList<String>();
		Set<String> keys = reach.keySet();
		for(String s : keys){
			if(isIn(s,ctx))
				result.add(s);
		}

		return result;
	} 


	public void printList(){

		Set<String> keys = reach.keySet();
		//System.out.println("******* Reachability List *******");
		for(String key : keys)
			System.out.println(key + " = " + reach.get(key));


	}
	public int size(){

		return reach.size(); 
	}

	public ArrayList<String> getListOf(String key){

		for (Map.Entry<String, ArrayList<String>> entry : reach.entrySet()) {
			String ke = entry.getKey();
			ArrayList<String> va = entry.getValue();

			if(ke.equals(key))
				return va;
		}

		System.out.println("Can not find " + key + " in Reachability List");
		return null;
	}	


}