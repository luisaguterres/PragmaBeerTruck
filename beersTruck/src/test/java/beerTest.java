import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.beer.truck.domain.entity.Beer;
import com.beer.truck.domain.mb.BeerMB;

class beerTest {
	BeerMB beerBean = new BeerMB();
	
	List<Beer> beers = beerBean.getBeers();
	
	@BeforeEach
	public void loadBeers() {
		beers = beerBean.listBeers();
	}
		
	//check if the system is loading the beers list
	@Test
	void loadBeersList() {		
		assertEquals(6, beers.size());
	}
	
	@Test
	void insertActualTemperature(){		
		List<Beer> beersActualTemperatura = beerBean.getBeers();		
		for(Beer beer: beersActualTemperatura) {
			assertEquals(beer.getTempMinimum(), beer.getTempActual());
		}
	}
		
	@Test
	void searchBeerByName(){
		Beer beer1 = beerBean.searchBeerByName("IPA");
		assertEquals(beer1.getName(), "IPA");
		
		Beer beer2 = beerBean.searchBeerByName("Pale Ale");
		assertEquals(beer2.getName(), "Pale Ale");
	}	
}