package mockito1;
//import mockito1.DemoAPI;
public class ReqService {
	private DemoAPI myapi;

	public ReqService(DemoAPI api) {
		this.myapi = api;
	}
	
	public String fetch() {
		return myapi.getData();
	}

}
