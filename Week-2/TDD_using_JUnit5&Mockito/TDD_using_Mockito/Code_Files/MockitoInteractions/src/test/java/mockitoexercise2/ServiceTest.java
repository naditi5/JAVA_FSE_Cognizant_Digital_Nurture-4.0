package mockitoexercise2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
class ServiceTest {

	@Test
    public void testVerifyInteraction() {
        // Arrange
        SampleAPI mockApi = mock(SampleAPI.class);
        Service service = new Service(mockApi);

        // Act
        service.fetchData();

        // Assert (verify)
        verify(mockApi).getData(); // Confirms getData() was called once
    }

}
