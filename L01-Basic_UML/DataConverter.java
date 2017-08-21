
public class DataConverter {
	
	public long ID;
	public Memento memento;
	
	
	public Memento createMemento(){
		return new Memento();
	}
	
	public void setMemento(Memento memento)
	{
		this.memento = memento;
	}
	
	public long getLastProcessedID(){
		return memento.getID();
	}
	
	public boolean process(){
		return true;
	}
	
	public class Memento{
		public long lastProcessedID;
		
		public long getID(){
			return 	lastProcessedID;
		}
	}
	
}
