package bionicsproInc.db.ifaces;

import java.util.List;

import bionicsproInc.db.pojos.*;

public interface DBManage {
    
	//Connection to database
	public void connect();
    
   //Add new engineer
	public void hireEngineer(Engineer eng);
	
	//getting an existed engineer
	public Engineer getEngineer(int id);
	
	public List<Engineer> search_by_name(String NAME_SURNAME);
	
	
}
