package mockitoexercise2;

public class Service {

	private SampleAPI externalApi;

    public Service(SampleAPI externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }

}
