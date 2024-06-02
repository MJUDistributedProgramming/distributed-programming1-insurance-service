package IF;

import java.util.ArrayList;

import domain.Accident;

public interface AccidentList {

	public boolean add(Accident accident);

	public boolean deleteById(int accidentID);

	public Accident retrieveById(int accidentID);
	
	public ArrayList<Accident> retrieveByCustomerId(int customerId);
	
	public ArrayList<Accident> retrieveAll();

	public void update(Accident accident, int accidentID);
}