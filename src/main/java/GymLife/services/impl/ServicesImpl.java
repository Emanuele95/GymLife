package GymLife.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.mysql.fabric.Response;

import GymLife.model.response.SchedePersonaliResponse;
import GymLife.persistent.entity.SalvaScheda;
import GymLife.persistent.dao.ProfiloDAO;
import GymLife.persistent.dao.SalvaSchedaDAO;
import GymLife.persistent.dao.StatisticheGlobaliDAO;
import GymLife.model.request.PrevenzioneStreachingRequest;
import GymLife.model.response.PrevenzioneStreachingResponse;
import GymLife.model.request.EserciziRequest;
import GymLife.model.response.AllenatiResponse;
import GymLife.model.response.Archivio_allenamentoResponse;
import GymLife.model.response.Archivio_esercizioResponse;
import GymLife.model.response.Archivio_massimaleResponse;
import GymLife.model.response.Archivio_misurazioneResponse;
import GymLife.model.response.EserciziResponse;
import GymLife.model.response.ConsigliaSchedaResponse;
import GymLife.model.response.MiglioramentoResponse;
import GymLife.model.response.Profilo_chiusuraResponse;
import GymLife.model.response.Profilo_intensitaResponse;
import GymLife.model.response.Profilo_massimaliResponse;
import GymLife.model.response.Profilo_misurazioneResponse;
import GymLife.model.response.Profilo_pesoResponse;
import GymLife.model.response.VotazioneResponse;
import GymLife.model.response.VotazioniResponse;
import GymLife.persistent.entity.Esercizio;
import GymLife.persistent.dao.UserDAO;
import GymLife.persistent.dao.SchedePersonaliDAO;
import GymLife.persistent.dao.ArchivioDAO;
import GymLife.persistent.daoFactory.DAOFactory;
import GymLife.persistent.entity.Storico_esercizio;
import GymLife.persistent.entity.Storico_allenamento;
import GymLife.persistent.entity.Giornata_scheda;
import GymLife.persistent.entity.User;
import GymLife.persistent.entity.Parti_misurazione;
import GymLife.persistent.entity.Massimale;
import GymLife.persistent.entity.Misurazione;
import GymLife.persistent.dao.AllenatiDAO;
import GymLife.persistent.dao.MisurazioneDAO;
import GymLife.persistent.dao.EsercizioDAO;
import GymLife.persistent.dao.SchedaDAO;
import GymLife.persistent.dao.MassimaleDAO;
import GymLife.persistent.dao.Parti_misurazioneDAO;
import GymLife.persistent.dao.PrevenzioneStreachingDAO;
import GymLife.persistent.entity.Esercizio_giornata;
import GymLife.persistent.entity.Scheda;
import GymLife.persistent.entity.Votazione;
import GymLife.service.IServices;

public class ServicesImpl implements IServices {

    DAOFactory mysqlDAOfactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

    public void registrazione(String name, String email, String password) {

        UserDAO userDAO = mysqlDAOfactory.getUserDAO();

        User user = new User();
        user.setNome(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setN_allenamenti(0);
        user.setN_misurazioni(0);
        user.setN_massimali(0);
        userDAO.addUser(user);

    }

    public User login(String email) {

        UserDAO userDAO = mysqlDAOfactory.getUserDAO();

        User user = userDAO.getUser(email);

        return user;
    }

    public boolean isUserExist(String email, String name) {

        UserDAO userDAO = mysqlDAOfactory.getUserDAO();

        User user = userDAO.getUser(email);

        if (user != null) {

            return true;
        }

        User userName = userDAO.getUserName(name);

        if (userName != null) {
            return true;
        }

        return false;

    }

    @Override
    public EserciziResponse esercizi(String muscolo, int corpo_libero, String difficolta, String nome) {

        EserciziResponse eserciziResponse = new EserciziResponse();
        EsercizioDAO esercizioDAO = mysqlDAOfactory.getEsercizioDAO();

        ArrayList<Esercizio> esercizio = esercizioDAO.getEserciziArray(muscolo, corpo_libero, difficolta, nome);

        if (esercizio == null) {
            eserciziResponse.setEsito(false);
            eserciziResponse.setDescrizione("NON CI SONO ESERCIZI DI INTERESSE");

            return eserciziResponse;
        }

        eserciziResponse.setEsito(true);
        eserciziResponse.setDescrizione("ESERCIZI TROVATI");
        eserciziResponse.setExercises(esercizio);

        return eserciziResponse;
    }

    public void nuovoMassimale(String username, String data, int valore, String esercizio) {

        MassimaleDAO massimaleDAO = mysqlDAOfactory.getMassimaleDAO();
        UserDAO userDAO = mysqlDAOfactory.getUserDAO();
        EsercizioDAO esercizioDAO = mysqlDAOfactory.getEsercizioDAO();

        Esercizio es = esercizioDAO.getEsercizio(esercizio);

        User user = userDAO.getUserName(username);

        Massimale massimale = new Massimale();

        massimale.setValore(valore);
        massimale.setData(data);
        massimale.setEsercizio(es);
        massimale.setUser(user);
        massimale.setN_massimale((user.getN_massimali()) + 1);
        massimaleDAO.addMassimale(massimale);

    }

    public void nuovoMisurazione(String username, String data, int valore, String parte, String misura) {

        MisurazioneDAO misurazioneDAO = mysqlDAOfactory.getMisurazioneDAO();
        UserDAO userDAO = mysqlDAOfactory.getUserDAO();
        Parti_misurazioneDAO Parti_misurazioneDAO = mysqlDAOfactory.getParti_misurazioneDAO();

        User user = userDAO.getUserName(username);
        Parti_misurazione body = Parti_misurazioneDAO.getParti_misurazione(parte);

        Misurazione misurazione = new Misurazione();
        misurazione.setParte(body);
        misurazione.setValore(valore);
        misurazione.setN_misurazione((user.getN_misurazioni()) + 1);
        misurazione.setMisura(misura);
        misurazione.setUser(user);
        misurazione.setData(data);

        misurazioneDAO.addMisurazione(misurazione);
    }

    @Override
    public PrevenzioneStreachingResponse fisioterapia(String muscolo, int corpo_libero, String difficolta, String nome) {

        PrevenzioneStreachingResponse eserciziResponse = new PrevenzioneStreachingResponse();
        PrevenzioneStreachingDAO esercizioDAO = mysqlDAOfactory.getPrevenzioneStreachingDAO();

        ArrayList<Esercizio> esercizio = esercizioDAO.getFisioterapiaArray(muscolo, corpo_libero, difficolta, nome);

        if (esercizio == null) {
            eserciziResponse.setEsito(false);
            eserciziResponse.setDescrizione("NON CI SONO ESERCIZI DI INTERESSE");

            return eserciziResponse;
        }

        eserciziResponse.setEsito(true);
        eserciziResponse.setDescrizione("ESERCIZI TROVATI");
        eserciziResponse.setExercises(esercizio);

        return eserciziResponse;
    }

    @Override
    public ConsigliaSchedaResponse consigliascheda(String regime, int n_giorni, String difficolta) {

        ConsigliaSchedaResponse schedeResponse = new ConsigliaSchedaResponse();
        SchedaDAO schedaDAO = mysqlDAOfactory.getSchedaDAO();

        ArrayList<Esercizio_giornata> scheda = schedaDAO.getSchedeArray(regime, n_giorni, difficolta);

        if (scheda == null) {
            schedeResponse.setEsito(false);
            schedeResponse.setDescrizione("NON CI SONO SCHEDE DI INTERESSE");

            return schedeResponse;
        }

        schedeResponse.setEsito(true);
        schedeResponse.setDescrizione("Schede Trovate");
        schedeResponse.setSchede(scheda);

        return schedeResponse;
    }

    public void salva_scheda(int scheda, String id_utilizzatore, String proprietario, int visibile) {

        SalvaSchedaDAO salvaschedaDAO = mysqlDAOfactory.getSalvaSchedaDAO();

        UserDAO userDAO = mysqlDAOfactory.getUserDAO();

        UserDAO user2DAO = mysqlDAOfactory.getUserDAO();
        SchedaDAO schedaDAO = mysqlDAOfactory.getSchedaDAO();

        Scheda sc = schedaDAO.getScheda(scheda);

        User user = userDAO.getUserName(id_utilizzatore);

        User user2 = user2DAO.getUserName(proprietario);

        SalvaScheda schedas = new SalvaScheda();

        schedas.setId_utilizzatore(user);
        schedas.setProprietario(user2);
        schedas.setVisibile(visibile);
        schedas.setScheda(sc);
        salvaschedaDAO.addScheda(schedas);

    }

    @Override
    public SchedePersonaliResponse schede_personali(String nome) {

        SchedePersonaliResponse schedeResponse = new SchedePersonaliResponse();

        UserDAO userDAO = mysqlDAOfactory.getUserDAO();
        User user = userDAO.getUserName(nome);

        int id_utilizzatore = user.getId();

        SchedePersonaliDAO schede_personal = mysqlDAOfactory.getSchedePersonaliDAO();
        ArrayList<SalvaScheda> scheda = schede_personal.getSchedePersonali(id_utilizzatore);

        if (scheda == null) {
            schedeResponse.setEsito(false);
            schedeResponse.setDescrizione("NON CI SONO SCHEDE PERSONALI");

            return schedeResponse;
        }

        schedeResponse.setEsito(true);
        schedeResponse.setDescrizione("Schede Trovate");
        schedeResponse.setSchede(scheda);

        return schedeResponse;
    }

    @Override
    public AllenatiResponse massimalipersonali(String nome) {

        AllenatiResponse massimaliResponse = new AllenatiResponse();

        UserDAO userDAO = mysqlDAOfactory.getUserDAO();
        User user = userDAO.getUserName(nome);

        int id_utilizzatore = user.getId();

        AllenatiDAO massimalidao = mysqlDAOfactory.getAllenatiDAO();
        ArrayList<Massimale> massimali = massimalidao.getMassimaliPersonali(id_utilizzatore);

        if (massimali == null) {
            massimaliResponse.setEsito(false);
            massimaliResponse.setDescrizione("NON CI SONO SCHEDE PERSONALI");

            return massimaliResponse;
        }

        massimaliResponse.setEsito(true);
        massimaliResponse.setDescrizione("Massimali Trovati");
        massimaliResponse.setMassimali(massimali);

        return massimaliResponse;
    }

    public void salva_ess(String nome, String esercizio, int posizione, int giornata, int scheda, int proprietario, int ripetizioni_riuscite, float peso_usato, float peso_consigliato, int ripetizioni_originali) {

        AllenatiDAO esDAO = mysqlDAOfactory.getAllenatiDAO();
        UserDAO userDAO = mysqlDAOfactory.getUserDAO();
        UserDAO propDAO = mysqlDAOfactory.getUserDAO();
        SalvaSchedaDAO giornataDAO = mysqlDAOfactory.getSalvaSchedaDAO();
        SchedaDAO schedaDAO = mysqlDAOfactory.getSchedaDAO();
        EsercizioDAO esercizioDAO = mysqlDAOfactory.getEsercizioDAO();

        User prop = propDAO.getId(proprietario);
        User user = userDAO.getUserName(nome);
        Giornata_scheda giornatas = giornataDAO.getGiornataScheda(giornata);
        Scheda schedas = schedaDAO.getScheda(scheda);
        Esercizio es = esercizioDAO.getEsercizio(esercizio);

        Storico_esercizio ess = new Storico_esercizio();

        ess.setUser(user);
        ess.setN_allenamento((user.getN_allenamenti()) + 1);
        ess.setEsercizio(es);
        ess.setPosizione(posizione);
        ess.setGiornata(giornatas);
        ess.setScheda(schedas);
        ess.setProprietario(prop);
        ess.setRipetizioni_riuscite(ripetizioni_riuscite);
        ess.setPeso_usato(peso_usato);
        ess.setPeso_consigliato(peso_consigliato);
        ess.setRipetizioni_originali(ripetizioni_originali);

        esDAO.addEss(ess);
    }

    public void salva_allenamento(String nome, String data, String inizio, String fine, int scheda, int giornata, int proprietario, String note, int intensita, int modifica_stats) {

        AllenatiDAO allDAO = mysqlDAOfactory.getAllenatiDAO();
        UserDAO userDAO = mysqlDAOfactory.getUserDAO();
        UserDAO propDAO = mysqlDAOfactory.getUserDAO();
        SalvaSchedaDAO giornataDAO = mysqlDAOfactory.getSalvaSchedaDAO();
        SchedaDAO schedaDAO = mysqlDAOfactory.getSchedaDAO();

        User prop = propDAO.getId(proprietario);
        User user = userDAO.getUserName(nome);
        Giornata_scheda giornatas = giornataDAO.getGiornataScheda(giornata);
        Scheda schedas = schedaDAO.getScheda(scheda);

        Storico_allenamento all = new Storico_allenamento();

        all.setUser(user);
        all.setN_allenamento((user.getN_allenamenti()) + 1);
        all.setGiornata(giornatas);
        all.setScheda(schedas);
        all.setProprietario(prop);
        all.setData(data);
        all.setOra_inizio(inizio);
        all.setOra_fine(fine);
        all.setNote(note);
        all.setIntensità(intensita);
        all.setModifica_stats(modifica_stats);

        allDAO.addAllenamento(all);
    }

    @Override
    public Archivio_allenamentoResponse archivio_allenamento(String users, String data) {

        Archivio_allenamentoResponse allenamentoResponse = new Archivio_allenamentoResponse();

        UserDAO userDAO = mysqlDAOfactory.getUserDAO();
        User user = userDAO.getUserName(users);

        int id_utilizzatore = user.getId();

        ArchivioDAO archiviodao = mysqlDAOfactory.getArchivioDAO();
        ArrayList<Storico_allenamento> allenamento = archiviodao.getAllenamentoArchivio(id_utilizzatore, data);

        if (allenamento == null) {
            allenamentoResponse.setEsito(false);
            allenamentoResponse.setDescrizione("NON CI SONO SCHEDE PERSONALI");

            return allenamentoResponse;
        }

        allenamentoResponse.setEsito(true);
        allenamentoResponse.setDescrizione("Allenamento Trovato");
        allenamentoResponse.setAllenamento(allenamento);

        return allenamentoResponse;
    }

    @Override
    public Archivio_misurazioneResponse archivio_misurazione(String users, String data) {

        Archivio_misurazioneResponse misurazioneResponse = new Archivio_misurazioneResponse();

        UserDAO userDAO = mysqlDAOfactory.getUserDAO();
        User user = userDAO.getUserName(users);

        int id_utilizzatore = user.getId();

        ArchivioDAO massimalidao = mysqlDAOfactory.getArchivioDAO();
        ArrayList<Misurazione> misurazione = massimalidao.getMisurazioneArchivio(id_utilizzatore, data);

        if (misurazione == null) {
            misurazioneResponse.setEsito(false);
            misurazioneResponse.setDescrizione("NON CI SONO MISURAZIONI PERSONALI");

            return misurazioneResponse;
        }

        misurazioneResponse.setEsito(true);
        misurazioneResponse.setDescrizione("Misurazioni Trovate");
        misurazioneResponse.setMisurazione(misurazione);

        return misurazioneResponse;
    }

    @Override
    public Archivio_massimaleResponse archivio_massimale(String users, String data) {

        Archivio_massimaleResponse massimaliResponse = new Archivio_massimaleResponse();

        UserDAO userDAO = mysqlDAOfactory.getUserDAO();
        User user = userDAO.getUserName(users);

        int id_utilizzatore = user.getId();

        ArchivioDAO massimalidao = mysqlDAOfactory.getArchivioDAO();
        ArrayList<Massimale> massimali = massimalidao.getMassimaleArchivio(id_utilizzatore, data);

        if (massimali == null) {
            massimaliResponse.setEsito(false);
            massimaliResponse.setDescrizione("NON CI SONO MASSIMALI PERSONALI");

            return massimaliResponse;
        }

        massimaliResponse.setEsito(true);
        massimaliResponse.setDescrizione("Massimali Trovati");
        massimaliResponse.setMassimale(massimali);

        return massimaliResponse;
    }

    @Override
    public Archivio_esercizioResponse archivio_esercizio(String users, int n_allenamento) {

        Archivio_esercizioResponse esercizioResponse = new Archivio_esercizioResponse();

        UserDAO userDAO = mysqlDAOfactory.getUserDAO();
        User user = userDAO.getUserName(users);

        int id_utilizzatore = user.getId();

        ArchivioDAO esdao = mysqlDAOfactory.getArchivioDAO();
        ArrayList<Storico_esercizio> es = esdao.getEsercizioArchivio(id_utilizzatore, n_allenamento);

        if (es == null) {
            esercizioResponse.setEsito(false);
            esercizioResponse.setDescrizione("NON CI SONO MASSIMALI PERSONALI");

            return esercizioResponse;
        }

        esercizioResponse.setEsito(true);
        esercizioResponse.setDescrizione("Massimali Trovati");
        esercizioResponse.setEsercizio(es);

        return esercizioResponse;
    }

    @Override
    public Profilo_massimaliResponse profilo_massimali(String nome, String esercizio) {

        Profilo_massimaliResponse massimaliResponse = new Profilo_massimaliResponse();

        UserDAO userDAO = mysqlDAOfactory.getUserDAO();
        User user = userDAO.getUserName(nome);

        int id_utilizzatore = user.getId();

        ProfiloDAO massimalidao = mysqlDAOfactory.getProfiloDAO();
        ArrayList<Massimale> massimali = massimalidao.getMassimaliProfilo(id_utilizzatore, esercizio);

        if (massimali == null) {
            massimaliResponse.setEsito(false);
            massimaliResponse.setDescrizione("NON CI SONO MASSIMALI PERSONALI");

            return massimaliResponse;
        }

        massimaliResponse.setEsito(true);
        massimaliResponse.setDescrizione("Massimali Trovati");
        massimaliResponse.setMassimale(massimali);

        return massimaliResponse;
    }

    @Override
    public Profilo_chiusuraResponse profilo_chiusura(String nome) {

        Profilo_chiusuraResponse massimaliResponse = new Profilo_chiusuraResponse();

        UserDAO userDAO = mysqlDAOfactory.getUserDAO();
        User user = userDAO.getUserName(nome);

        int id_utilizzatore = user.getId();

        ProfiloDAO massimalidao = mysqlDAOfactory.getProfiloDAO();
        ArrayList<Storico_esercizio> massimali = massimalidao.getChiusuraProfilo(id_utilizzatore);

        if (massimali == null) {
            massimaliResponse.setEsito(false);
            massimaliResponse.setDescrizione("NON CI SONO ALLENAMENTI PERSONALI");

            return massimaliResponse;
        }

        massimaliResponse.setEsito(true);
        massimaliResponse.setDescrizione("Allenamenti Trovati");
        massimaliResponse.setEsercizio(massimali);

        return massimaliResponse;
    }

    @Override
    public Profilo_intensitaResponse profilo_intensita(String nome) {

        Profilo_intensitaResponse massimaliResponse = new Profilo_intensitaResponse();

        UserDAO userDAO = mysqlDAOfactory.getUserDAO();
        User user = userDAO.getUserName(nome);

        int id_utilizzatore = user.getId();

        ProfiloDAO massimalidao = mysqlDAOfactory.getProfiloDAO();
        ArrayList<Storico_allenamento> massimali = massimalidao.getIntensitaProfilo(id_utilizzatore);

        if (massimali == null) {
            massimaliResponse.setEsito(false);
            massimaliResponse.setDescrizione("NON CI SONO ALLENAMENTI PERSONALI");

            return massimaliResponse;
        }

        massimaliResponse.setEsito(true);
        massimaliResponse.setDescrizione("Allenamenti Trovati");
        massimaliResponse.setAllenamento(massimali);

        return massimaliResponse;
    }

    @Override
    public Profilo_pesoResponse profilo_peso(String nome, String parte) {

        Profilo_pesoResponse massimaliResponse = new Profilo_pesoResponse();

        UserDAO userDAO = mysqlDAOfactory.getUserDAO();
        User user = userDAO.getUserName(nome);

        int id_utilizzatore = user.getId();

        ProfiloDAO massimalidao = mysqlDAOfactory.getProfiloDAO();
        ArrayList<Misurazione> massimali = massimalidao.getPesoProfilo(id_utilizzatore, parte);
        if (massimali == null) {
            massimaliResponse.setEsito(false);
            massimaliResponse.setDescrizione("NON CI SONO MISURAZIONI PERSONALI");

            return massimaliResponse;
        }

        massimaliResponse.setEsito(true);
        massimaliResponse.setDescrizione("Misurazioni Trovate");
        massimaliResponse.setMisuarzione(massimali);

        return massimaliResponse;
    }

    @Override
    public Profilo_misurazioneResponse profilo_misurazione(String nome, String parte) {

        Profilo_misurazioneResponse massimaliResponse = new Profilo_misurazioneResponse();

        UserDAO userDAO = mysqlDAOfactory.getUserDAO();
        User user = userDAO.getUserName(nome);

        int id_utilizzatore = user.getId();

        ProfiloDAO massimalidao = mysqlDAOfactory.getProfiloDAO();
        ArrayList<Misurazione> massimali = massimalidao.getMisurazioniProfilo(id_utilizzatore, parte);
        if (massimali == null) {
            massimaliResponse.setEsito(false);
            massimaliResponse.setDescrizione("NON CI SONO MISURAZIONI PERSONALI");

            return massimaliResponse;
        }

        massimaliResponse.setEsito(true);
        massimaliResponse.setDescrizione("Misurazioni Trovate");
        massimaliResponse.setMisuarzione(massimali);

        return massimaliResponse;
    }

    @Override
    public MiglioramentoResponse miglioramento() {

        MiglioramentoResponse miglioramentoResponse = new MiglioramentoResponse();

        StatisticheGlobaliDAO miglioramentodao = mysqlDAOfactory.getStatisticheGlobaliDAO();
        ArrayList<Giornata_scheda> miglioramento = miglioramentodao.getMisurazioniGlobali();
        if (miglioramento == null) {
            miglioramentoResponse.setEsito(false);
            miglioramentoResponse.setDescrizione("NON CI SONO SCHEDE");

            return miglioramentoResponse;
        }

        miglioramentoResponse.setEsito(true);
        miglioramentoResponse.setDescrizione("Schede Trovate");
        miglioramentoResponse.setMiglioramento(miglioramento);

        return miglioramentoResponse;
    }

    @Override
    public VotazioniResponse votazioni() {

        VotazioniResponse votazioniResponse = new VotazioniResponse();

        StatisticheGlobaliDAO votazionidao = mysqlDAOfactory.getStatisticheGlobaliDAO();
        ArrayList<Scheda> votazioni = votazionidao.getVotazioniGlobali();
        if (votazioni == null) {
            votazioniResponse.setEsito(false);
            votazioniResponse.setDescrizione("NON CI SONO SCHEDE");

            return votazioniResponse;
        }

        votazioniResponse.setEsito(true);
        votazioniResponse.setDescrizione("Schede Trovate");
        votazioniResponse.setVotazioni(votazioni);

        return votazioniResponse;
    }
    
    @Override
    public VotazioneResponse votazione(String nome, int scheda, int proprietario) {

        VotazioneResponse votazioniResponse = new VotazioneResponse();

        UserDAO userDAO = mysqlDAOfactory.getUserDAO();
        User user = userDAO.getUserName(nome);
        
        
        SchedePersonaliDAO votazionidao = mysqlDAOfactory.getSchedePersonaliDAO();
        ArrayList<Votazione> votazioni = votazionidao.getVotazioniPersonali(user.getId(), scheda, proprietario);
        
        if (votazioni == null) {
            votazioniResponse.setEsito(false);
            votazioniResponse.setDescrizione("NON CI SONO SCHEDE");

            return votazioniResponse;
        }

        votazioniResponse.setEsito(true);
        votazioniResponse.setDescrizione("Schede Trovate");
        votazioniResponse.setVotazione(votazioni);

        return votazioniResponse;
    }
    
    public void salva_votazione(String name, int scheda, int proprietario, int votouser) {

        SchedePersonaliDAO salvaschedaDAO = mysqlDAOfactory.getSchedePersonaliDAO();

        UserDAO userDAO = mysqlDAOfactory.getUserDAO();

        UserDAO user2DAO = mysqlDAOfactory.getUserDAO();
        
        SchedaDAO schedaDAO = mysqlDAOfactory.getSchedaDAO();

        Scheda sc = schedaDAO.getScheda(scheda);

        User user = userDAO.getUserName(name);

        User user2 = user2DAO.getId(proprietario);

        Votazione voto = new Votazione();

       
        voto.setProprietario(user2);
        
        voto.setId_votante(user);
        voto.setScheda(sc);
        voto.setVoto(votouser);
        salvaschedaDAO.addVotazione(voto);

    }

}
