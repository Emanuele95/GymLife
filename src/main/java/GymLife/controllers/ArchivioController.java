package GymLife.controllers;

import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import GymLife.model.request.Archivio_esercizioRequest;
import GymLife.model.request.ArchivioRequest;
import GymLife.model.response.Archivio_massimaleResponse;
import GymLife.model.response.Archivio_misurazioneResponse;
import GymLife.model.response.Archivio_esercizioResponse;
import GymLife.model.response.Archivio_allenamentoResponse;

import GymLife.services.impl.ServicesImpl;
import GymLife.service.IServices;

@RequestMapping(value = "/archivio")
@RestController
public class ArchivioController {

    private IServices service = new ServicesImpl();

    @RequestMapping(value = "/archivio_massimale", method = RequestMethod.POST)
    @ResponseBody
    public Archivio_massimaleResponse archivio_massimale(@Valid @RequestBody ArchivioRequest archivio, Errors errors) {

        Archivio_massimaleResponse response = new Archivio_massimaleResponse();

        if (errors.hasErrors()) {
            response.setEsito(false);
            response.setDescrizione("INPUT NON VALIDI");

            return response;
        }

        try {
            response = service.archivio_massimale(archivio.getUser(), archivio.getData());
        } catch (Exception e) {

            response.setEsito(false);
            response.setDescrizione("ERRORE INTERNO");
            return response;
        }
        return response;
    }

    @RequestMapping(value = "/archivio_misurazione", method = RequestMethod.POST)
    @ResponseBody
    public Archivio_misurazioneResponse archivio_misurazione(@Valid @RequestBody ArchivioRequest archivio, Errors errors) {

        Archivio_misurazioneResponse response = new Archivio_misurazioneResponse();

        if (errors.hasErrors()) {
            response.setEsito(false);
            response.setDescrizione("INPUT NON VALIDI");

            return response;
        }

        try {
            response = service.archivio_misurazione(archivio.getUser(), archivio.getData());
        } catch (Exception e) {

            response.setEsito(false);
            response.setDescrizione("ERRORE INTERNO");
            return response;
        }
        return response;
    }

    @RequestMapping(value = "/archivio_allenamento", method = RequestMethod.POST)
    @ResponseBody
    public Archivio_allenamentoResponse archivio_allenamento(@Valid @RequestBody ArchivioRequest archivio, Errors errors) {

        Archivio_allenamentoResponse response = new Archivio_allenamentoResponse();

        if (errors.hasErrors()) {
            response.setEsito(false);
            response.setDescrizione("INPUT NON VALIDI");

            return response;
        }

        try {
             response = service.archivio_allenamento(archivio.getUser(), archivio.getData());
        } catch (Exception e) {

            response.setEsito(false);
            response.setDescrizione("ERRORE INTERNO");
            return response;
        }
        return response;
    }
    
    @RequestMapping(value = "/archivio_esercizio", method = RequestMethod.POST)
    @ResponseBody
    public Archivio_esercizioResponse archivio_esercizio(@Valid @RequestBody Archivio_esercizioRequest archivio, Errors errors) {

        Archivio_esercizioResponse response = new Archivio_esercizioResponse();

        if (errors.hasErrors()) {
            response.setEsito(false);
            response.setDescrizione("INPUT NON VALIDI");

            return response;
        }

        try {
            response = service.archivio_esercizio(archivio.getUser(), archivio.getN_allenamento());
        } catch (Exception e) {

            response.setEsito(false);
            response.setDescrizione("ERRORE INTERNO");
            return response;
        }
        return response;
    }


}
