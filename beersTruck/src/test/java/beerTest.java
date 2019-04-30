import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.beer.truck.domain.entity.Beer;
import com.beer.truck.domain.mb.BeerMB;

class beerTest {
	BeerMB beerMB = new BeerMB();
	
	List<Beer> beers = beerMB.getBeers();
	
	@BeforeEach
	public void loadBeers() {
		beerMB.loadBeersList();
		beers = beerMB.getBeers();
	}
		
	@Test
	void loadBeersList() {		
		assertEquals(6, beers.size());
	}
	
	@Test
	void searchBeer() {		
		assertEquals(beers.get(0), beerMB.search(beers.get(0)));
	}
	
	@Test
	void insertActualTemperatureAtTheFirstTime(){		
		List<Beer> beersActualTemperatura = beerMB.getBeers();		
		for(Beer beer: beersActualTemperatura) {
			assertEquals(beer.getTempMinimum(), beer.getTempActual());
		}
	}
		
	@Test
	void searchBeerByName(){
		Beer beer1 = beerMB.searchBeerByName("IPA");
		assertEquals(beer1.getName(), "IPA");
		
		Beer beer2 = beerMB.searchBeerByName("Pale Ale");
		assertEquals(beer2.getName(), "Pale Ale");
	}	
}