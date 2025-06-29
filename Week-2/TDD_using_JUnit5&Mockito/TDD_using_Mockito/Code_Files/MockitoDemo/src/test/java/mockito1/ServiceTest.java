package mockito1;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

class ServiceTest {

	@Test
    public void testExternalApi() {
        
        DemoAPI mockApi = mock(DemoAPI.class);
        when(mockApi.getData()).thenReturn("Mock Data");

       
        ReqService service = new ReqService(mockApi);
        String result = service.fetch();

        assertEquals("Mock Data", result);
    }

}
