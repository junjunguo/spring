package com.junjunguo.spring.upload.controller;

import com.junjunguo.spring.upload.data.SpittleRepository;
import com.junjunguo.spring.upload.model.Spittle;
import com.junjunguo.spring.upload.model.SpittleForm;
import com.junjunguo.spring.upload.util.DuplicateSpittleException;
import com.junjunguo.spring.upload.util.SpittleNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

  private static final String MAX_LONG_AS_STRING = "9223372036854775807";
  
  private SpittleRepository spittleRepository;

  @Autowired
  public SpittleController(SpittleRepository spittleRepository) {
    this.spittleRepository = spittleRepository;
  }

  @RequestMapping(method=RequestMethod.GET)
  public List<Spittle> spittles(
      @RequestParam(value="max", defaultValue=MAX_LONG_AS_STRING) long max,
      @RequestParam(value="count", defaultValue="20") int count) {
    return spittleRepository.findSpittles(max, count);
  }

  @RequestMapping(value="/{spittleId}", method=RequestMethod.GET)
  public String spittle(
      @PathVariable("spittleId") long spittleId, 
      Model model) {
    Spittle spittle = spittleRepository.findOne(spittleId);
    if (spittle == null) {
      throw new SpittleNotFoundException();
    }
    model.addAttribute(spittle);
    return "spittle";
  }

  @RequestMapping(method=RequestMethod.POST)
  public String saveSpittle(SpittleForm form, Model model) {
    try {
      spittleRepository.save(new Spittle(null, form.getMessage(), new Date(), 
          form.getLongitude(), form.getLatitude()));
      return "redirect:/spittles";
    } catch (DuplicateSpittleException e) {
      return "error/duplicate";
    }
  }
  
  @ExceptionHandler(DuplicateSpittleException.class)
  public String handleNotFound() {
    return "error/duplicate";
  }

}
