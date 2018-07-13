package GymLife.service;

import GymLife.model.response.SchedePersonaliResponse;
import GymLife.model.response.ConsigliaSchedaResponse;
import GymLife.persistent.entity.Massimale;

import GymLife.model.response.Profilo_massimaliResponse;
import GymLife.model.response.AllenatiResponse;
import GymLife.model.response.Archivio_allenamentoResponse;
import GymLife.model.response.Archivio_esercizioResponse;
import GymLife.model.response.Archivio_massimaleResponse;
import GymLife.model.response.Archivio_misurazioneResponse;
import GymLife.model.response.PrevenzioneStreachingResponse;
import GymLife.model.response.EserciziResponse;
import GymLife.model.response.MiglioramentoResponse;
import GymLife.model.response.Profilo_chiusuraResponse;
import GymLife.model.response.Profilo_intensitaResponse;
import GymLife.model.response.Profilo_misurazioneResponse;
import GymLife.model.response.Profilo_pesoResponse;
import GymLife.model.response.VotazioneResponse;
import GymLife.model.response.VotazioniResponse;
import GymLife.persistent.entity.User;

public interface IServices {

    public void registrazione(String name, String email, String password);

    public User login(String email);

    public boolean isUserExist(String email, String name);

    public EserciziResponse esercizi(String muscolo, int corpo_libero, String difficolta, String nome);

    public PrevenzioneStreachingResponse fisioterapia(String muscolo, int corpo_libero, String difficolta, String nome);

    public void nuovoMassimale(String username, String data, int valore, String esercizio);

    public void nuovoMisurazione(String username, String data, int valore, String parte, String misura);

    public ConsigliaSchedaResponse consigliascheda(String regime, int n_giorni, String difficolta);

    public void salva_scheda(int scheda, String id_utilizzatore, String proprietario, int visibile);

    public SchedePersonaliResponse schede_personali(String nome);

    public AllenatiResponse massimalipersonali(String nome);

    public void salva_ess(String nome, String esercizio, int posizione, int giornata, int scheda, int proprietario, int ripetizioni_riuscite, float peso_usato, float peso_consigliato, int ripetizioni_originali);

    public void salva_allenamento(String nome, String data, String inizio, String fine, int scheda, int giornata, int proprietario, String note, int intensita, int modifica_stats);

    public Archivio_massimaleResponse archivio_massimale(String user, String data);

    public Archivio_misurazioneResponse archivio_misurazione(String user, String data);

    public Archivio_allenamentoResponse archivio_allenamento(String user, String data);

    public Archivio_esercizioResponse archivio_esercizio(String user, int n_allenamento);

    public Profilo_massimaliResponse profilo_massimali(String user, String esercizio);

    public Profilo_chiusuraResponse profilo_chiusura(String user);

    public Profilo_intensitaResponse profilo_intensita(String user);

    public Profilo_pesoResponse profilo_peso(String user, String parte);

    public Profilo_misurazioneResponse profilo_misurazione(String user, String parte);

    public VotazioniResponse votazioni();

    public MiglioramentoResponse miglioramento();

    public VotazioneResponse votazione(String user, int scheda, int proprietario);

    public void salva_votazione(String user, int scheda, int proprietario, int voto);

}
