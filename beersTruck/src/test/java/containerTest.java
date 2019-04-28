import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.beer.truck.domain.entity.Beer;
import com.beer.truck.domain.entity.Container;
import com.beer.truck.domain.mb.BeerMB;
import com.beer.truck.domain.mb.ContainerMB;

class containerTest {
	
	ContainerMB containerMB = new ContainerMB();
	BeerMB beerMB = new BeerMB();
	
	Container container = new Container();	
	
	@BeforeEach
	public void loadContainersList(){		
		containerMB.loadContainersList();		
	}		
	
	public void createContainer() {		
		Beer beer = new Beer();
		beer.setId(1);		
		beer.setName("Beer Test");
		beer.setTempMaximum(7.0);
		beer.setTempMinimum(4.0);
		beer.setTempActual(4.0);
		
		container.setId(1);
		container.setBeer(beer);
	}
	
	@Test
	void searchContainerById() {		
		Container cont = containerMB.searchContainerById(1);
		assertEquals(1, cont.getId());
	}
	
	@Test
	void updateBeerTemperature() {		
		createContainer();
		assertEquals(4.0, containerMB.measuredTemperature(container, 0.2), 4.2);		
	}
	
	@Test
	void openTruckDoors() {
		List<Container> containers = containerMB.getContainers();
		Double tempBefore = containers.get(0).getBeer().getTempActual(); 
		beerMB.loadBeersList();
		containerMB.openTruckDoors();
		List<Container> containersTempUpdate = containerMB.getContainers();	
		
		assertNotSame(tempBefore, containersTempUpdate.get(0).getBeer().getTempActual());
	}
}