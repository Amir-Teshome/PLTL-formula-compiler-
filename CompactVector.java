import java.util.HashMap;
import java.util.Map;
import java.util.*;

class CompactVector{	

	Map<String, ArrayList<String>> variable = new HashMap<String, ArrayList<String>>();
	boolean boolValue = false; 
	String stringValue=null;

	public boolean getboolvalue(){

		return boolValue;
	}


	
	public void setboolvalue(boolean val){

		boolValue = val;
	}

	public void put(String key, ArrayList<String> val){

		variable.put(key, val);
	}

	public int size(){

		return variable.size(); 
	}

	public int add(String var, String value){

		ArrayList<String> list = get(var);

		if(list == null){

			ArrayList<String> new_list = new ArrayList<String>();
			new_list.add(value);
			variable.put(var, new_list);
			return -1;
		}

		else {

			if(!list.contains(value))//if it alrady exist don't add it again
			    list.add(value);
			variable.put(var, list);
			return 1;
		}

	}

	public ArrayList<String> get(String key){

		for (Map.Entry<String, ArrayList<String>> entry : variable.entrySet()) {
			String ke = entry.getKey();
			ArrayList<String> val = entry.getValue();

			if(key.equals(ke))
				return val;
		}

		return null; //variable.get(key);
	}

	public void printVector(){

		System.out.print("[ ");

		for (Map.Entry<String, ArrayList<String>> entry : variable.entrySet())
			System.out.print(entry.getKey() + ": " + entry.getValue());

		System.out.print(" ] bool value: " + boolValue + " stringValue: " + stringValue);
	
}

	public boolean isNull(){

			if(variable == null)
				return true;
			else 
				return false;
	}

	public boolean isequal(CompactVector cv){

		boolean result = true;


		if(cv.size() == variable.size())
		{
			for (Map.Entry<String, ArrayList<String>> entry : variable.entrySet()) {
				
				String ke = entry.getKey();
				ArrayList<String> val = entry.getValue();

				ArrayList<String> incoming_val = cv.get(ke);

				if(incoming_val == null)

					 result = false;
				
				else {
					if(val != null)
						for(String s : val){
							if(!incoming_val.contains(s))
								result = false;
					}

				}


			}

			if( (getboolvalue() ^ cv.getboolvalue() ) )
				result = false;

	  }

	  else {

	  	result = false;
	  }

	  return result;

	}




	public CompactVector union(CompactVector cv){

		CompactVector to_return = new CompactVector();

		for (Map.Entry<String, ArrayList<String>> entry : variable.entrySet()) {

				String ke = entry.getKey();
				ArrayList<String> val = entry.getValue();

				if(val != null)
					for(String s: val)
						to_return.add(ke, s);
		}

		for (Map.Entry<String, ArrayList<String>> entry : cv.variable.entrySet()) {

				String ke = entry.getKey();
				ArrayList<String> val = entry.getValue();

				for(String s: val)
					to_return.add(ke, s);
		}


		if(getboolvalue() || cv.getboolvalue())
			to_return.setboolvalue(true);
		else 
			to_return.setboolvalue(false);

		return to_return;

	}

	public CompactVector intersection(CompactVector cv){

		CompactVector to_return = new CompactVector();
		boolean found;

		if(variable.size() >= cv.variable.size()) {

		//System.out.println("#############################	Inside intersection variable.size is larger ************");
			for (Map.Entry<String, ArrayList<String>> entry : variable.entrySet()) {

				found = false;
				String key = entry.getKey();
				ArrayList<String> val = entry.getValue(); 

				if(cv.variable.containsKey(key))

					for (Map.Entry<String, ArrayList<String>> entry2 : cv.variable.entrySet()) {

						String key2 = entry2.getKey();
						ArrayList<String> val2 = entry2.getValue();

						if(key.equals(key2)){

							found = true;
							for(String s1 : val)
								for(String s2 : val2)
									if(s1.equals(s2))
										to_return.add(key, s1);

						}
					}

				else 
					if(val != null)
						for(String s: val)
							to_return.add(key,s);

			}

			for(Map.Entry<String, ArrayList<String>> entry2 : cv.variable.entrySet()){

				String key2 = entry2.getKey();
				ArrayList<String> val2 = entry2.getValue();
				if(!variable.containsKey(key2))
					for(String s : val2)
						to_return.add(key2, s);
			}

		}


		else {

			for (Map.Entry<String, ArrayList<String>> entry : cv.variable.entrySet()) {

				found = false;
				String key = entry.getKey();
				ArrayList<String> val = entry.getValue(); 

				if(variable.containsKey(key))

					for (Map.Entry<String, ArrayList<String>> entry2 : variable.entrySet()) {

						String key2 = entry2.getKey();
						ArrayList<String> val2 = entry2.getValue();

						if(key.equals(key2)){

							found = true;
							for(String s1 : val)
								for(String s2 : val2)
									if(s1.equals(s2))
										to_return.add(key, s1);

						}


					}

				else
					if(val != null)
						for(String s: val)
							to_return.add(key,s);

			}

			for(Map.Entry<String, ArrayList<String>> entry2 : variable.entrySet()){

				String key2 = entry2.getKey();
				ArrayList<String> val2 = entry2.getValue();
				if(!cv.variable.containsKey(key2))
					for(String s : val2)
						to_return.add(key2, s);
			}


		}

		if(getboolvalue() && cv.getboolvalue())
			to_return.setboolvalue(true);
		else 
			to_return.setboolvalue(false);

		return to_return;
	}




}