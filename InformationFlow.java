class InformationFlow{

	String source = null;
	String destination = null;

	public InformationFlow(String source, String destination){
		this.source = source;
		this.destination = destination;
	} 

	public String getDestination(){
		return destination;
	}

	public String getSource(){
		return source;
	}

	public void printElement(){
		 
		System.out.println("Source :"+ source + " destination :" + destination );

	}

	public String printinline(){

		return (source +" > "+ destination);
	}

}
