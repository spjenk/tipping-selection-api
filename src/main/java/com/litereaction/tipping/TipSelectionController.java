package com.litereaction.tipping;

import com.litereaction.tipping.model.TipSelection;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/selection")
@CrossOrigin(origins = "*")
public class TipSelectionController {

    private Logger logger = LoggerFactory.getLogger(TipSelectionController.class);

    @Autowired
    TipSelectionRepository tipSelectionRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get all tip selections")
    public ResponseEntity<List<TipSelection>> get() {
        List<TipSelection> selections = tipSelectionRepository.findAll();
        return new ResponseEntity<List<TipSelection>>(selections, getHttpHeader(), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{user}", method = RequestMethod.GET)
    public List<TipSelection> getByUser(@PathVariable String user) {
        return tipSelectionRepository.findByUser(user);
    }

    @RequestMapping(value = "/user/{user}/meeting/{meeting}", method = RequestMethod.GET)
    public ResponseEntity<TipSelection> getById(@PathVariable String user, @PathVariable String meeting) {
        TipSelection selections = tipSelectionRepository.findByUserAndMeetingId(user, meeting);
        HttpStatus s = selections != null ? HttpStatus.OK : HttpStatus.NO_CONTENT;

        return new ResponseEntity<TipSelection>(selections, getHttpHeader(), s);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TipSelection getById(@PathVariable String id) {
        return tipSelectionRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Record tip selection")
    public ResponseEntity<TipSelection> create(@RequestBody TipSelection tipSelection) {
        TipSelection findTip = tipSelectionRepository.findByUserAndMeetingId(tipSelection.getUser(), tipSelection.getMeetingId());
        if (findTip != null) {
            tipSelection.setId(findTip.getId());
        }

        try {
            TipSelection selection = tipSelectionRepository.save(tipSelection);
            return new ResponseEntity<TipSelection>(selection, getHttpHeader(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<TipSelection>(tipSelection, getHttpHeader(), HttpStatus.BAD_REQUEST);
        }
    }

    private HttpHeaders getHttpHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

}
