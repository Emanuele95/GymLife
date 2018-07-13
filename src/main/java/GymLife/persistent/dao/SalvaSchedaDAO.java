package GymLife.persistent.dao;
import GymLife.persistent.entity.SalvaScheda;
import GymLife.persistent.entity.Giornata_scheda;


public interface SalvaSchedaDAO {
	public void addScheda(SalvaScheda scheda);
        
        public Giornata_scheda getGiornataScheda(int id);

}