package entities;

// *** tem pelo menos um m�todo abstrato
// *** n�o podem ser instanciadas 
// *** usa-se abstract

abstract class Funcionalities {
	
	protected String name;
	protected String description;

	abstract public void printAll();
	// abstract public void create(); 
	// abstract public void edit();
	// abstract public void delete();
	// abstract public void search();
	
}
