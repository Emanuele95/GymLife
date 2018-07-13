package GymLife.controllers;

import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import GymLife.model.response.MisurazioniResponse;
import GymLife.model.request.MisurazioniRequest;
import GymLife.model.request.MassimaliRequest;
import GymLife.model.response.MassimaliResponse;
import GymLife.services.impl.ServicesImpl;
import GymLife.service.IServices;
import java.util.HashMap;

@RequestMapping(value = "/massimali_misurazioni")
@RestController
public class MassimaliMisurazioniController {

    private IServices service = new ServicesImpl();
    
    @RequestMapping(value = "/nuovoMisurazione", method = RequestMethod.POST)
    @ResponseBody
    
    public MisurazioniResponse nuovoMisurazione(@Valid @RequestBody MisurazioniRequest misurazione, Errors errors) {

       MisurazioniResponse response = new MisurazioniResponse();
        if (errors.hasErrors()) {
            response.setEsito(false);
            response.setDescrizione("INPUT NON VALIDI");
            return response;
        }
        
        String misura = misurazione.getMisura();
        String parte = misurazione.getParte();
        int valore = misurazione.getValore();
        String data = misurazione.getData();
        String username = misurazione.getUsername();

        try {
            service.nuovoMisurazione(username, data, valore, parte, misura);
        } catch (Exception e) {

            response.setEsito(false);
            response.setDescrizione("ERRORE INTERNO");
            return response;
        }
        response.setEsito(true);
        response.setDescrizione("Misurazione Salvata");

        return response;
    }

    @RequestMapping(value = "/nuovoMassimale", method = RequestMethod.POST)
    @ResponseBody
  
    public MassimaliResponse nuovoMassimale(@Valid @RequestBody MassimaliRequest massimale, Errors errors) {

        MassimaliResponse response = new MassimaliResponse();
        if (errors.hasErrors()) {
            response.setEsito(false);
            response.setDescrizione("INPUT NON VALIDI");
            return response;
        }

        String esercizio = massimale.getEsercizio();
        int valore = massimale.getValore();
        String data = massimale.getData();
        String username = massimale.getUsername();

        try {
            service.nuovoMassimale(username, data, valore, esercizio);
        } catch (Exception e) {

            response.setEsito(false);
            response.setDescrizione("ERRORE INTERNO");
            return response;
        }
        response.setEsito(true);
        response.setDescrizione("Massimale Salvato");

        return response;
    }

    
}
