package com.litereaction.tipping;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
    public List<TipSelection> get() {
        return tipSelectionRepository.findAll();
    }

    @RequestMapping(value = "/user/{user}", method = RequestMethod.GET)
    public List<TipSelection> getByUser(@PathVariable String user) {
        return tipSelectionRepository.findByUser(user);
    }

    @RequestMapping(value = "/user/{user}/meeting/{meeting}", method = RequestMethod.GET)
    public TipSelection getById(@PathVariable String user, @PathVariable String meeting) {
        return tipSelectionRepository.findByUserAndMeeting(user, meeting);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TipSelection getById(@PathVariable String id) {
        return tipSelectionRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Record tip selection")
    public TipSelection create(@RequestBody TipSelection tipSelection) {
        TipSelection findTip = tipSelectionRepository.findByUserAndMeeting(tipSelection.getUser(), tipSelection.getMeeting());
        if (findTip != null) {
            tipSelection.setId(findTip.getId());
        }
        return tipSelectionRepository.save(tipSelection);
    }

}
