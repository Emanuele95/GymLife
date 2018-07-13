package GymLife.persistent.daoFactory;

import GymLife.persistent.dao.AllenatiDAO;
import GymLife.persistent.dao.impl.MySQLAllenatiDAO;

import GymLife.persistent.dao.ArchivioDAO;
import GymLife.persistent.dao.impl.MySQLArchivioDAO;

import GymLife.persistent.dao.StatisticheGlobaliDAO;
import GymLife.persistent.dao.impl.MySQLStatisticheGlobaliDAO;

import GymLife.persistent.dao.UserDAO;
import GymLife.persistent.dao.impl.MySQLUserDAO;

import GymLife.persistent.dao.SalvaSchedaDAO;
import GymLife.persistent.dao.impl.MySQLSalvaSchedaDAO;

import GymLife.persistent.dao.SchedePersonaliDAO;
import GymLife.persistent.dao.impl.MySQLSchedePersonaliDAO;

import GymLife.persistent.dao.ProfiloDAO;
import GymLife.persistent.dao.impl.MySQLProfiloDAO;

import GymLife.persistent.dao.SchedaDAO;
import GymLife.persistent.dao.impl.MySQLSchedaDAO;

import GymLife.persistent.dao.MassimaleDAO;
import GymLife.persistent.dao.impl.MySQLMassimaleDAO;

import GymLife.persistent.dao.Parti_misurazioneDAO;
import GymLife.persistent.dao.impl.MySQLParti_misurazioneDAO;

import GymLife.persistent.dao.MisurazioneDAO;
import GymLife.persistent.dao.impl.MySQLMisurazioneDAO;

import GymLife.persistent.dao.impl.MySQLEsercizioDAO;
import GymLife.persistent.dao.EsercizioDAO;

import GymLife.persistent.dao.impl.MySQLPrevenzioneStreachingDAO;
import GymLife.persistent.dao.PrevenzioneStreachingDAO;

public class MySQLDbDAOFactory extends DAOFactory {

    @Override
    public UserDAO getUserDAO() {
        return new MySQLUserDAO();
    }

    @Override
    public StatisticheGlobaliDAO getStatisticheGlobaliDAO() {
        return new MySQLStatisticheGlobaliDAO();
    }

    @Override
    public ProfiloDAO getProfiloDAO() {
        return new MySQLProfiloDAO();
    }

    @Override
    public AllenatiDAO getAllenatiDAO() {
        return new MySQLAllenatiDAO();
    }

    @Override
    public ArchivioDAO getArchivioDAO() {
        return new MySQLArchivioDAO();
    }

    @Override
    public SalvaSchedaDAO getSalvaSchedaDAO() {
        return new MySQLSalvaSchedaDAO();
    }

    @Override
    public SchedePersonaliDAO getSchedePersonaliDAO() {
        return new MySQLSchedePersonaliDAO();
    }

    @Override
    public SchedaDAO getSchedaDAO() {
        return new MySQLSchedaDAO();
    }

    @Override
    public MassimaleDAO getMassimaleDAO() {
        return new MySQLMassimaleDAO();
    }

    @Override
    public Parti_misurazioneDAO getParti_misurazioneDAO() {
        return new MySQLParti_misurazioneDAO();
    }

    @Override
    public MisurazioneDAO getMisurazioneDAO() {
        return new MySQLMisurazioneDAO();
    }

    @Override
    public EsercizioDAO getEsercizioDAO() {
        return new MySQLEsercizioDAO();
    }

    @Override
    public PrevenzioneStreachingDAO getPrevenzioneStreachingDAO() {
        return new MySQLPrevenzioneStreachingDAO();
    }

}
