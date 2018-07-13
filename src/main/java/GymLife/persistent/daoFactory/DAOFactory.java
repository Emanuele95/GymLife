package GymLife.persistent.daoFactory;

import GymLife.persistent.dao.ProfiloDAO;
import GymLife.persistent.dao.StatisticheGlobaliDAO;
import GymLife.persistent.dao.AllenatiDAO;
import GymLife.persistent.dao.ArchivioDAO;
import GymLife.persistent.dao.PrevenzioneStreachingDAO;
import GymLife.persistent.dao.SchedaDAO;
import GymLife.persistent.dao.MassimaleDAO;
import GymLife.persistent.dao.MisurazioneDAO;
import GymLife.persistent.dao.UserDAO;
import GymLife.persistent.dao.EsercizioDAO;
import GymLife.persistent.dao.SchedePersonaliDAO;
import GymLife.persistent.dao.Parti_misurazioneDAO;
import GymLife.persistent.dao.SalvaSchedaDAO;

public abstract class DAOFactory {

    public static final String MYSQL = "mysql";

    public abstract UserDAO getUserDAO();

    public abstract StatisticheGlobaliDAO getStatisticheGlobaliDAO();

    public abstract ProfiloDAO getProfiloDAO();

    public abstract ArchivioDAO getArchivioDAO();

    public abstract AllenatiDAO getAllenatiDAO();

    public abstract SchedePersonaliDAO getSchedePersonaliDAO();

    public abstract SalvaSchedaDAO getSalvaSchedaDAO();

    public abstract MassimaleDAO getMassimaleDAO();

    public abstract SchedaDAO getSchedaDAO();

    public abstract MisurazioneDAO getMisurazioneDAO();

    public abstract EsercizioDAO getEsercizioDAO();

    public abstract Parti_misurazioneDAO getParti_misurazioneDAO();

    public abstract PrevenzioneStreachingDAO getPrevenzioneStreachingDAO();

    public static DAOFactory getDAOFactory(String tipo) {
        switch (tipo) {
            case MYSQL:
                return new MySQLDbDAOFactory();
            default:
                return null;
        }
    }
}
