package GymLife.controllers;

import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import GymLife.model.request.Profilo_massimaliRequest;
import GymLife.model.response.Profilo_massimaliResponse;

import GymLife.model.request.Profilo_misurazioneRequest;
import GymLife.model.response.Profilo_misurazioneResponse;

import GymLife.model.request.Profilo_pesoRequest;
import GymLife.model.response.Profilo_pesoResponse;

import GymLife.model.request.Profilo_intensitaRequest;
import GymLife.model.response.Profilo_intensitaResponse;

import GymLife.model.request.Profilo_chiusuraRequest;
import GymLife.model.response.Profilo_chiusuraResponse;

import GymLife.services.impl.ServicesImpl;
import GymLife.service.IServices;

@RequestMapping(value = "/profilo")
@RestController
public class ProfiloController {

    private IServices service = new ServicesImpl();

    @RequestMapping(value = "/profilo_massimali", method = RequestMethod.POST)
    @ResponseBody
    public Profilo_massimaliResponse profilo_massimali(@Valid @RequestBody Profilo_massimaliRequest utente, Errors errors) {

        Profilo_massimaliResponse response = new Profilo_massimaliResponse();

        if (errors.hasErrors()) {
            response.setEsito(false);
            response.setDescrizione("INPUT NON VALIDI");

            return response;
        }

        try {
            response = service.profilo_massimali(utente.getUsername(), utente.getEsercizio());
        } catch (Exception e) {

            response.setEsito(false);
            response.setDescrizione("ERRORE INTERNO");
            return response;
        }
        return response;
    }

    @RequestMapping(value = "/profilo_misurazione", method = RequestMethod.POST)
    @ResponseBody
    public Profilo_misurazioneResponse profilo_misurazione(@Valid @RequestBody Profilo_misurazioneRequest mis, Errors errors) {

        Profilo_misurazioneResponse response = new Profilo_misurazioneResponse();

        if (errors.hasErrors()) {
            response.setEsito(false);
            response.setDescrizione("INPUT NON VALIDI");

            return response;
        }

        try {
            response = service.profilo_misurazione(mis.getUsername(), mis.getParte());
        } catch (Exception e) {

            response.setEsito(false);
            response.setDescrizione("ERRORE INTERNO");
            return response;
        }
        return response;
    }

    @RequestMapping(value = "/profilo_peso", method = RequestMethod.POST)
    @ResponseBody
    public Profilo_pesoResponse profilo_peso(@Valid @RequestBody Profilo_pesoRequest peso, Errors errors) {

        Profilo_pesoResponse response = new Profilo_pesoResponse();

        if (errors.hasErrors()) {
            response.setEsito(false);
            response.setDescrizione("INPUT NON VALIDI");

            return response;
        }

        try {
            response = service.profilo_peso(peso.getUsername(), peso.getParte());
        } catch (Exception e) {

            response.setEsito(false);
            response.setDescrizione("ERRORE INTERNO");
            return response;
        }
        return response;
    }
    
    @RequestMapping(value = "/profilo_intensita", method = RequestMethod.POST)
    @ResponseBody
    public Profilo_intensitaResponse profilo_intensita(@Valid @RequestBody Profilo_intensitaRequest intensita, Errors errors) {

        Profilo_intensitaResponse response = new Profilo_intensitaResponse();

        if (errors.hasErrors()) {
            response.setEsito(false);
            response.setDescrizione("INPUT NON VALIDI");

            return response;
        }

        try {
            response = service.profilo_intensita(intensita.getUsername());
        } catch (Exception e) {

            response.setEsito(false);
            response.setDescrizione("ERRORE INTERNO");
            return response;
        }
        return response;
    }
    
     @RequestMapping(value = "/profilo_chiusura", method = RequestMethod.POST)
    @ResponseBody
    public Profilo_chiusuraResponse profilo_chiusura(@Valid @RequestBody Profilo_chiusuraRequest chiusura, Errors errors) {

        Profilo_chiusuraResponse response = new Profilo_chiusuraResponse();

        if (errors.hasErrors()) {
            response.setEsito(false);
            response.setDescrizione("INPUT NON VALIDI");

            return response;
        }

        try {
            response = service.profilo_chiusura(chiusura.getUsername());
        } catch (Exception e) {

            response.setEsito(false);
            response.setDescrizione("ERRORE INTERNO");
            return response;
        }
        return response;
    }

}
